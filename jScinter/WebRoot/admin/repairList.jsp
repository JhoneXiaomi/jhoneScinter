<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<table class="easyui-datagrid" data-options="fitColumns:true,toolbar:'#toolbar'" id="grid_repair"></table>
		<div id="toolbar" class="toolpanel datagrid-toolbar">
		    <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-new" plain="true" id="js_add">新建</a>
			<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" plain="true" id="js_edit">编辑</a>
			<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-del" plain="true" id="js_del">删除</a>
			<!-- 
			<a href="javascript:void(0);" class="easyui-linkbutton l-btn l-btn-plain" iconcls="icon-authorize" plain="true" id="">授权</a>
             -->
            <div class="rf reletive sch">
				<input style="width: " class="txt" type="text" id="keyWord" name="keyWord" value="请输入客户姓名、手机号或楼盘名称" />
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
            $("#grid_repair").datagrid({
                url:'${pageContext.request.contextPath}/admin/listRepairToJson',
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
					{field:'repairId',align:'left',width:50,title:'报修编号'},
					{field:'buildName',align:'left',width:40,title:'楼盘小区'},
					{field:'clientName',align:'left',width:30,title:'客户姓名'},
					{field:'sex',align:'left',width:15,title:'性别'},
					{field:'phone',align:'left',width:40,title:'手机号'},
					{field:'address',align:'left',width:40,title:'行政区域',
						formatter:function(value,row,index){
                			value = value.replace("null","");
                			return value.replace(new RegExp(",","gm"),"");
						}		
					},					
					{field:'chargeManager',align:'left',width:30,title:'原工程经理'},
					{field:'chargeDesigner',align:'left',width:30,title:'原设计师'},
					{field:'repairType',align:'left',width:30,title:'维修类别'},
					{field:'startDate',align:'left',width:30,title:'开工日期',
						formatter:function(value,row,index){
                    		return value.substring(0,11);
						}	
					},
					{field:'repairTime',align:'left',width:50,title:'预约时间'},
					{field:'branchCompany',align:'left',width:40,title:'隶属分公司',
						formatter:function(value,row,index){
							return formatCompanyName(value);
						}	
					},
					{field:'repairStatus',align:'center',width:20,title:'状态',
						formatter:function(value,row,index){
                    		if(value==0){		
                    			return '<div style="width:100%;background-color:red;font-weight:bold;color:#FFFAFA;">未处理</div>'; 
                    		}else if(value==1){
                    			return '<div style="width:100%;background-color:#FFD700;font-weight:bold;">处理中</div>';
                    		}else if(value==2){
                    			return '<div style="width:100%;background-color:#00EE00;font-weight:bold;">已处理</div>';
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
					$("#framebottom").attr("src","showRepair?repairId="+row.id);
                },
				onLoadSuccess:function(node,data){
					$("#grid_repair").datagrid("selectRow",rowIndex);
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
	   $("#framebottom").attr("src","repairSave.jsp");
	});
	
    /*编辑*/
    $("#js_edit").on("click",function(){
	   if(!$("#js_layout").layout("panel","south").is(":visible")){
			$("#js_layout").layout("autoExpand","south");
	   }
	   //获取复选框值
	   var items = $("input[name='id']:checked");
       var repairIdArr = [];
       $.each(items, function (index, item) {
    	   repairIdArr[index] = item.value;
       });
       if(repairIdArr.length==1){
    	   $("#framebottom").attr("src","showRepair?repairId="+repairIdArr[0]);
       }else{
    	   $.messager.alert("操作提示", "请选择一行！","info");
       }
	});
	
    /*删除 */
    $("#js_del").on("click",function(){
	   //获取复选框值
	   var items = $("input[name='id']:checked");
       var repairIdArr = [];
       $.each(items, function (index, item) {
    	   repairIdArr[index] = item.value;
       });
       if(repairIdArr.length>0){
    	   $.messager.confirm("确认", "确认删除选中的"+repairIdArr.length+"客户报修单?", function (r){  
	   	        if (r) {
	   	        	$.ajax({
	   		   			type : "POST",
	   		   			dataType : "json",
	   		   			url : "${pageContext.request.contextPath}/admin/delRepair",
	   		   			data : "repairIds=" + repairIdArr,
	   		   			success : function(data) {
	   		   				if(data.data=="ok"){
	   		   					$.messager.alert("操作提示", "删除成功！","info");
	   		   					$("#grid_repair").datagrid('reload'); //重新加载
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
		if($('#keyWord').val()=="请输入客户姓名、手机号或楼盘名称"){
			$('#keyWord').val('');
		}
		 var role = '${sessionScope.Role.roleName }';
			var BCompany = "";
			if(role =='超级管理员'){
				BCompany = $("#BCompany").combobox('getValue');
			}else{
				BCompany = $("#BCompany").val();
			}
		//加载搜索列	
		var query = {'keyWord': $('#keyWord').val(),'BCompany':BCompany}; //把查询条件拼接成JSON
		$("#grid_repair").datagrid('options').queryParams = query; //把查询条件赋值给datagrid内部变量
		$("#grid_repair").datagrid({url:'${pageContext.request.contextPath}/admin/searchListRepair'}); //重新加载查询url
		$("#grid_repair").datagrid('reload'); //重新加载
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