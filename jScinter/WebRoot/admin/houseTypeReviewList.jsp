<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>在线报修列表</title>
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
		<table class="easyui-datagrid" data-options="fitColumns:true,toolbar:'#toolbar'" id="grid_houseTypeReview"></table>
		<div id="toolbar" class="toolpanel datagrid-toolbar">
		    <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-new" plain="true" id="js_add">新建</a>
			<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" plain="true" id="js_edit">编辑</a>
			<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-del" plain="true" id="js_del">删除</a>
			
            <div class="rf reletive sch">
				<input style="width: " class="txt" type="text" id="keyWord" name="keyWord" value="填写点评内容、点评者姓名" />
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
            $("#grid_houseTypeReview").datagrid({
                url:'${pageContext.request.contextPath}/admin/listHouseTypeReviewToJson',
                fit:true,
                striped: true,
                pagination:true,
                pageSize: 10,
                singleSelect:true,
				scrollbarSize:0,
				checkOnSelect:true,
           		selectOnCheck:false,
                columns:[[
					{field:'id',checkbox:true},
					{field:'title',align:'left',width:50,title:'点评标题'},
					{field:'type',align:'left',width:20,title:'户型'},
					{field:'acreage',align:'left',width:20,title:'面积'},
					{field:'designer',align:'left',width:30,title:'设计师'},					
					{field:'readNum',align:'left',width:20,title:'浏览量'},
					{field:'creater',align:'left',width:30,title:'创建人'},
					{field:'createTime',align:'left',width:30,title:'创建时间'},
					{field:'updater',align:'left',width:30,title:'修改人'},
					{field:'updateTime',align:'left',width:30,title:'修改时间'}
                ]],
                onSelect:function(index,row){
                    if(!$("#js_layout").layout("panel","south").is(":visible")){
                       $("#js_layout").layout("autoExpand","south");
                    }
					$("#framebottom").attr("src","showHouseTypeReview?houseTypeId="+row.id);
                },
				onLoadSuccess:function(node,data){
					$("#grid_houseTypeReview").datagrid("selectRow",rowIndex);
				}
            });
        },
		init:function(){
            $$.loadGrid();
        }
    };
    $$.init();
	 /*新建*/
	$("#js_add").on("click",function(){
	   if(!$("#js_layout").layout("panel","south").is(":visible")){
			$("#js_layout").layout("autoExpand","south");
	   }
	   $("#framebottom").attr("src","houseTypeReviewSave.jsp");
	});
	
    /*编辑*/
    $("#js_edit").on("click",function(){
	   if(!$("#js_layout").layout("panel","south").is(":visible")){
			$("#js_layout").layout("autoExpand","south");
	   }
	   //获取复选框值
	   var items = $("input[name='id']:checked");
       var houseTypeIdArr = [];
       $.each(items, function (index, item) {
    	   houseTypeIdArr[index] = item.value;
       });
       if(houseTypeIdArr.length==1){
    	   $("#framebottom").attr("src","showHouseTypeReview?houseTypeId="+houseTypeIdArr[0]);
       }else{
    	   $.messager.alert("操作提示", "请选择一行！","info");
       }
	});
	
    /*删除 */
    $("#js_del").on("click",function(){
	   //获取复选框值
	   var items = $("input[name='id']:checked");
       var houseTypeIdArr = [];
       $.each(items, function (index, item) {
    	   houseTypeIdArr[index] = item.value;
       });
       if(houseTypeIdArr.length>0){
    	   $.messager.confirm("确认", "确认删除选中的"+houseTypeIdArr.length+"条户型点评信息?", function (r){  
	   	        if (r) {
	   	        	$.ajax({
	   		   			type : "POST",
	   		   			dataType : "json",
	   		   			url : "${pageContext.request.contextPath}/admin/delHouseTypeReview",
	   		   			data : "houseTypeIds=" + houseTypeIdArr,
	   		   			success : function(data) {
	   		   				if(data.data=="ok"){
	   		   					$.messager.alert("操作提示", "删除成功！","info");
	   		   					$("#grid_houseTypeReview").datagrid('reload'); //重新加载
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
		if($('#keyWord').val()=="填写点评内容、点评者姓名"){
			$('#keyWord').val('');
		}
		//加载搜索列表
		var query = {'keyWord': $('#keyWord').val()}; //把查询条件拼接成JSON
		$("#grid_houseTypeReview").datagrid('options').queryParams = query; //把查询条件赋值给datagrid内部变量
		$("#grid_houseTypeReview").datagrid({url:'${pageContext.request.contextPath}/admin/searchListHouseTypeReview'}); //重新加载查询url
		$("#grid_houseTypeReview").datagrid('reload'); //重新加载
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