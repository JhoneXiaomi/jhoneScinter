<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>FAQ列表|案例问答列表</title>
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
		<table class="easyui-datagrid" data-options="fitColumns:true,toolbar:'#toolbar'" id="grid_faq"></table>
		<div id="toolbar" class="toolpanel datagrid-toolbar">
		    <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-new" plain="true" id="js_add">新建</a>
			<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" plain="true" id="js_edit">编辑</a>
			<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-del" plain="true" id="js_del">删除</a>
			<!-- 
			<a href="javascript:void(0);" class="easyui-linkbutton l-btn l-btn-plain" iconcls="icon-authorize" plain="true" id="">授权</a>
             -->
            <div class="rf reletive sch">
				<input class="txt" type="text" id="keyWord" name="keyWord" value="可按问题、答案描述搜索" />
				<button type="button" id="search" class="sbutton">查询</button>
			</div>
           <div class="rf">
            <c:choose>
			 		<c:when test="${sessionScope.Role.roleName=='超级管理员' }">
				 	<c:if test="${sessionScope.controlledCompany=='sczs' }">
				 	
					 	  <td class="right"><i class="require">*</i>隶属分公司：</td>
		            	  <td>
		                  <select name="BCompany" id="BCompany" class="easyui-combobox" 
		            			data-options="panelHeight:'auto',editable : false,
		            			valueField: 'id',      
		             			textField: 'text',
		             			url:'${pageContext.request.contextPath}/static/www/json/scinter/scinter_company.json',
		             			onLoadSuccess:function(data){
		             			<%-- var BCompany = '${requestScropt.BCompany }';
						                    	if(BCompany!=''){
						                   			$('#BCompany').combobox('setValue',BCompany);
						                   		} --%>
		             
		                   }" style="width:247px;">
		            			 	<option value="===请选择===">===请选择===</option>
		            	  </select>
		                  </td>	
				 	</c:if>	
				 	<c:if test="${sessionScope.controlledCompany=='xzzs' }">
				 	
					 	  <td class="right"><i class="require">*</i>隶属分公司：</td>
		            	  <td>
		                  <select name="BCompany" id="BCompany" class="easyui-combobox" 
		            			data-options="panelHeight:'auto',editable : false,
		            			valueField: 'id',      
		             			textField: 'text',
		             			url:'${pageContext.request.contextPath}/static/www/json/xzzs/xz_company.json',
		             			onLoadSuccess:function(data){
		             			<%-- var BCompany = '${requestScropt.BCompany }';
						                    	if(BCompany!=''){
						                   			$('#BCompany').combobox('setValue',BCompany);
						                   		} --%>
		             
		                   }" style="width:247px;">
		            			 	<option value="===请选择===">===请选择===</option>
		            	  </select>
		                  </td>	
				 	</c:if>	
				 	<c:if test="${sessionScope.controlledCompany=='rbwzs1' }">
				 	
					 	  <td class="right"><i class="require">*</i>隶属分公司：</td>
		            	  <td>
		                  <select name="BCompany" id="BCompany" class="easyui-combobox" 
		            			data-options="panelHeight:'auto',editable : false,
		            			valueField: 'id',      
		             			textField: 'text',
		             			url:'${pageContext.request.contextPath}/static/www/json/rbwzs1/rbw_company.json',
		             			onLoadSuccess:function(data){
		             			<%-- var BCompany = '${requestScropt.BCompany }';
						                    	if(BCompany!=''){
						                   			$('#BCompany').combobox('setValue',BCompany);
						                   		} --%>
		             
		                   }" style="width:247px;">
		            			 	<option value="===请选择===">===请选择===</option>
		            	  </select>
		                  </td>	
				 	</c:if>	
				 	<c:if test="${sessionScope.controlledCompany=='rbwzs2' }">
				 	
					 	  <td class="right"><i class="require">*</i>隶属分公司：</td>
		            	  <td>
		                  <select name="BCompany" id="BCompany" class="easyui-combobox" 
		            			data-options="panelHeight:'auto',editable : false,
		            			valueField: 'id',      
		             			textField: 'text',
		             			url:'${pageContext.request.contextPath}/static/www/json/rbwzs2/rbw_company.json',
		             			onLoadSuccess:function(data){
		             			<%-- var BCompany = '${requestScropt.BCompany }';
						                    	if(BCompany!=''){
						                   			$('#BCompany').combobox('setValue',BCompany);
						                   		} --%>
		             
		                   }" style="width:247px;">
		            			 	<option value="===请选择===">===请选择===</option>
		            	  </select>
		                  </td>	
				 	</c:if>
				 	<c:if test="${sessionScope.controlledCompany=='rrlzs' }">
				 	
					 	  <td class="right"><i class="require">*</i>隶属分公司：</td>
		            	  <td>
		                  <select name="BCompany" id="BCompany" class="easyui-combobox" 
		            			data-options="panelHeight:'auto',editable : false,
		            			valueField: 'id',      
		             			textField: 'text',
		             			url:'${pageContext.request.contextPath}/static/www/json/rrlzs/rrl_company.json',
		             			onLoadSuccess:function(data){
		             			<%-- var BCompany = '${requestScropt.BCompany }';
						                    	if(BCompany!=''){
						                   			$('#BCompany').combobox('setValue',BCompany);
						                   		} --%>
		             
		                   }" style="width:247px;">
		            			 	<option value="===请选择===">===请选择===</option>
		            	  </select>
		                  </td>	
				 	</c:if>
			 		</c:when>
			 		<c:otherwise> 
				 		<td class="right">
				 			<input type="hidden" value="${sessionScope.Role.branchCompany }" name="BCompany" id="BCompany"/>
				 		</td>
			 		</c:otherwise>
			 </c:choose>
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
            $("#grid_faq").datagrid({
                url:'${pageContext.request.contextPath}/admin/listFaqToJson',
                fit:true,
                striped: true,
                pagination:true,
                pageSize: 10,
                singleSelect:true,
				scrollbarSize:0,
				checkOnSelect:true,
           		selectOnCheck:false,
                columns:[[
					{field:'faqId',checkbox:true},
					{field:'faqDesc',align:'left',width:50,title:'装修问题描述'},
					{field:'faqAnswer',align:'left',width:50,title:'问题答案',
						formatter:function(value,row,index){
                    		return '<div style="width:100%;" title="'+value+'">'+value+'</div>';
						}
					},
					{field:'faqType',align:'left',width:30,title:'问题类型',
						formatter:function(value,row,index){
                    		if(value==1){		
                    			return '<div style="width:100%">水电类</div>'; 
                    		}else if(value==2){
                    			return '<div style="width:100%;">油漆类</div>';
                    		}else if(value==3){
                    			return '<div style="width:100%;">地板类</div>';
                    		}else{
                    			return '';
                    		}
						}	
					},
					{field:'creater',align:'left',width:20,title:'创建人'},				
					{field:'createTime',align:'left',width:30,title:'创建时间'},
					{field:'updater',align:'left',width:20,title:'修改人'},				
					{field:'updateTime',align:'left',width:30,title:'修改时间'},
					{field:'branchCompany',align:'left',width:20,title:'隶属分公司',
						formatter:function(value,row,index){
							return formatCompanyName(value);
						}	
					},
					]
                ],
                onSelect:function(index,row){
                    if(!$("#js_layout").layout("panel","south").is(":visible")){
                       $("#js_layout").layout("autoExpand","south");
                    }
					$("#framebottom").attr("src","showFaq?faqId="+row.faqId);
                },
				onLoadSuccess:function(node,data){
					//选中子页面传递的某行
					$("#grid_faq").datagrid("selectRow",rowIndex);
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
	   $("#framebottom").attr("src","faqSave.jsp");
	});
	
    /*编辑*/
    $("#js_edit").on("click",function(){
	   if(!$("#js_layout").layout("panel","south").is(":visible")){
			$("#js_layout").layout("autoExpand","south");
	   }
	   //获取复选框值
	   var items = $("input[name='faqId']:checked");
       var faqIdArr = [];
       $.each(items, function (index, item) {
    	   faqIdArr[index] = item.value;
       });
       if(faqIdArr.length==1){
    	   $("#framebottom").attr("src","showFaq?faqId="+faqIdArr[0]);
       }else{
    	   $.messager.alert("操作提示", "请选择一行！","info");
       }
	});
	
    /*删除 */
    $("#js_del").on("click",function(){
	   //获取复选框值
	   var items = $("input[name='faqId']:checked");
       var faqIdArr = [];
       $.each(items, function (index, item) {
    	   faqIdArr[index] = item.value;
       });
       
       if(faqIdArr.length>0){
    	   $.messager.confirm("确认", "确认删除选中的"+faqIdArr.length+"条装修问答?", function (r){  
	   	        if (r) {
	   	        	$.ajax({
	   		   			type : "POST",
	   		   			dataType : "json",
	   		   			url : "${pageContext.request.contextPath}/admin/delFaq",
	   		   			data : "faqIds=" + faqIdArr,
	   		   			success : function(data) {
	   		   				if(data.data=="ok"){
	   		   					$.messager.alert("操作提示", "删除成功！","info");
	   		   					$("#grid_faq").datagrid('reload'); //重新加载
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
		
		
		if($('#keyWord').val()=="可按问题、答案描述搜索"){
			$('#keyWord').val('');
			
		}
		    var role = '${sessionScope.Role.roleName }';
			var BCompany = "";
			if(role =='超级管理员'){
				BCompany = $("#BCompany").combobox('getValue');
			}else{
				BCompany = $("#BCompany").val();
			}
		//加载搜索列表
		var query = {'keyWord': $('#keyWord').val(),'BCompany': BCompany}; //把查询条件拼接成JSON
		$("#grid_faq").datagrid('options').queryParams = query; //把查询条件赋值给datagrid内部变量
		$("#grid_faq").datagrid({url:'${pageContext.request.contextPath}/admin/searchListFaq'}); //重新加载查询url
		$("#grid_faq").datagrid('reload'); //重新加载
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