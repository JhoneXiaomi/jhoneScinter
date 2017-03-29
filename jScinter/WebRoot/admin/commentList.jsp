<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>留言列表</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/easyui.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/common.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/QA.css" type="text/css" />
</head>
<body>
<div class="wrapper" id="js_layout">
	 <div data-options="region:'south',split:true,maxHeight:1000" class="layout-south border hidden" id="js_south">
        <!--//my code -->
        <iframe name="framebottom" id="framebottom" src="" height="100%" width="100%" frameborder="0" scrolling="no" allowtransparency="true"></iframe> 
	</div>
	<div data-options="region:'center'" class="noborder hidden">
		<table class="easyui-datagrid" data-options="fitColumns:true,toolbar:'#toolbar'" id="grid_comment"></table>
		<div id="toolbar" class="toolpanel datagrid-toolbar">
			<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" plain="true" id="js_edit">编辑</a>
			<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-del" plain="true" id="js_del">删除</a>
			<!-- 
			<a href="javascript:void(0);" class="easyui-linkbutton l-btn l-btn-plain" iconcls="icon-authorize" plain="true" id="">授权</a>
             -->
            <div class="rf reletive sch">
				<input class="txt" type="text" id="keyWord" name="keyWord" value="请输入评论内容、访客姓名或电话" />
				<button type="button" id="search" class="sbutton">查询</button>
			</div>
            
		</div>
	</div>
</div>
<script src="${pageContext.request.contextPath}/static/www/scripts/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/easyui.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/easyui.datagrid.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/common.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" charset="utf-8">
var rowIndex = 0;
jQuery(function($){
	$("#js_south").height($(parent).height()*0.5);
    $("#js_layout").layout({fit:true});
	  var $$=window.$$={
        //加载表格
        loadGrid:function(param){
            $("#grid_comment").datagrid({
                url:'${pageContext.request.contextPath}/admin/listPageToJson',
                fit:true,
                striped: true,
                pagination:true,
                pageSize: 10,
                singleSelect:true,
				scrollbarSize:0,
				checkOnSelect:true,
           		selectOnCheck:false,
                columns:[[
					{field:'commentId',checkbox:true},
					{field:'commentDesc',align:'left',width:50,title:'评论内容',
						formatter:function(value,row,index){
							if(value.length>20){
                    			return value.substring(0,20)+"...";
							}else{
								return value;
							}
						}	
					},
					{field:'visitorName',align:'left',width:30,title:'访客姓名'},
					{field:'visitorPhone',align:'left',width:40,title:'访客电话'},
					{field:'visitorIp',align:'left',width:40,title:'访客IP'},
					{field:'caseId',align:'left',width:40,title:'关联案例'},
					{field:'type',align:'left',width:30,title:'留言分类',
						formatter:function(value,row,index){
                    		if(value==1){		
                    			return '<div style="width:60%;">案例留言</div>'; 
                    		}else if(value==2){
                    			return '<div style="width:60%;">设计师留言</div>';
                    		}else{
                    			return false;
                    		}
						}
					},
					{field:'createTime',align:'left',width:50,title:'留言时间'},
					{field:'status',align:'center',width:30,title:'状态',
						formatter:function(value,row,index){
							if(value==1){		
                    			return '<div style="width:60%;background-color:#00EE00;font-weight:bold;">正常</div>'; 
                    		}else if(value==2){
                    			return '<div style="width:60%;background-color:red;font-weight:bold;color:#FFFAFA;">待审</div>';
                    		}else{
                    			return '';
                    		}
						}
					}
                ]],
                onSelect:function(index,row){
                    if(!$("#js_layout").layout("panel","south").is(":visible")){
                       $("#js_layout").layout("autoExpand","south");
                    }
					$("#framebottom").attr("src","showComment?commentId="+row.commentId);
                },
				onLoadSuccess:function(node,data){
					$("#grid_comment").datagrid("selectRow",rowIndex);
				}
            });
        },
		init:function(){
            $$.loadGrid();
        }
    };
    $$.init();
    /*编辑*/
    $("#js_edit").on("click",function(){
	   if(!$("#js_layout").layout("panel","south").is(":visible")){
			$("#js_layout").layout("autoExpand","south");
	   }
	   //获取复选框值
	   var items = $("input[name='commentId']:checked");
       var commentIdArr = [];
       $.each(items, function (index, item) {
    	   commentIdArr[index] = item.value;
       });
       if(commentIdArr.length==1){
    	   $("#framebottom").attr("src","showComment?commentId="+commentIdArr[0]);
       }else{
    	   $.messager.alert("操作提示", "请选择一行！","info");
       }
	});
	
    /*删除 */
    $("#js_del").on("click",function(){
	   //获取复选框值
	   var items = $("input[name='commentId']:checked");
       var commentIdArr = [];
       $.each(items, function (index, item) {
    	   commentIdArr[index] = item.value;
       });
       if(commentIdArr.length>0){
    	   $.messager.confirm("确认", "确认删除选中的"+commentIdArr.length+"条留言?", function (r){  
	   	        if (r) {
	   	        	$.ajax({
	   		   			type : "POST",
	   		   			dataType : "json",
	   		   			url : "${pageContext.request.contextPath}/admin/delComment",
	   		   			data : "commentIds=" + commentIdArr,
	   		   			success : function(data) {
	   		   				if(data.data=="ok"){
	   		   					$.messager.alert("操作提示", "删除成功！","info");
	   		   					$("#grid_comment").datagrid('reload'); //重新加载
	   		   				}
	   		   			}
	   	   			});
	   	        }
   	    	});
       }else{
    	   $.messager.alert("操作提示", "请选择一行！","info");
       }
	});
    
    
    /*搜索*/
	$("#search").on("click",function(){
		if($('#keyWord').val()=="请输入评论内容、访客姓名或电话"){
			$('#keyWord').val('');
		}
		//加载搜索列表
		var query = {'keyWord': $('#keyWord').val()};               //把查询条件拼接成JSON
		$("#grid_comment").datagrid('options').queryParams = query;    //把查询条件赋值给datagrid内部变量
		$("#grid_comment").datagrid({url:'${pageContext.request.contextPath}/admin/searchListComment'}); //重新加载查询url
		$("#grid_comment").datagrid('reload');                         //重新加载
	});
    
    
    /*window resize*/
    winResize=function(){
        var winWidth = $(window).width(),winHeight=$(window).height();
        $("#js_layout").layout("resize",{width:winWidth,height:winHeight});
		if ($.support.boxModel && !$.support.leadingWhitespace){
            var iframes = window.frames;
            for(var l = iframes.length,i=0;i<l;i++){
                var f = iframes[i].winResize;if(f)f();
            }
        }
    }
    $(window).wresize(winResize);
    winResize();
});
</script>
</body>
</html>