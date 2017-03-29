<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.scinter.www.listener.ApplicationConstants"%>
<%
response.setHeader("Pragma","No-cache");    
response.setHeader("Cache-Control","no-cache");    
response.setDateHeader("Expires", 0);
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>在线登录统计</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/easyui.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/common.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/QA.css" type="text/css" />
<script src="${pageContext.request.contextPath}/static/www/scripts/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/easyui.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/easyui.datagrid.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/common.js" type="text/javascript" charset="utf-8"></script>    
</head>
<body>
<% SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  %>
<div class="wrapper layout" id="js_layout">
		<div id="toolbar">
    		<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-refresh" plain="true" id="js_refresh">刷新缓存</a>
			<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-xiaXian" plain="true" id="js_offline">强制下线</a>
			<span style="float:right;">
				服务器启动时间:
				<%=sdf.format(ApplicationConstants.START_DATE) %>
				&nbsp;&nbsp;||&nbsp;&nbsp;
				历史访问人数：
				<span style="color: red;"><%= ApplicationConstants.TOTAL_HISTORY_COUNT %></span>
				&nbsp;&nbsp;||&nbsp;&nbsp;
				当前在线人数：
				<span  style="color: red;"><% out.print(ApplicationConstants.CURRENT_LOGIN_COUNT); %></span>
			</span>
		</div>
	    <div data-options="region:'center'" id="js_center" class="layout-center noborder">
	        <table class="easyui-datagrid" data-options="fitColumns:true,singleSelect:true,toolbar:'#toolbar'" id="grid"></table>
	    </div>

</div>
<script type="text/javascript" charset="utf-8">

jQuery(function($){
 //加载grid表格
    $("#js_layout").layout({fit:true});
    function gridLoad(){
    	$("#grid").datagrid({
	           	url: '${pageContext.request.contextPath}/admin/onlineUserListToJson',
	            fit:true,
	            striped: true,
	            pagination:true,
	            rownumbers:true,
	            singleSelect:true,
	            checkOnSelect:true,
	            scrollbarSize:0,
           		selectOnCheck:false,
	            height:$("#js_center").height(),
	            columns:[[
					{field:'sessionid',checkbox:true},
	                {field:'userId',align:'left',width:30,title:'帐号ID'},
	                {field:'username',align:'left',width:30,title:'名称'},
	                {field:'ip',align:'left',width:50,title:'登录IP'},
	                {field:'createTime',align:'left',width:50,title:'登录时间'},
	                {field:'accessedTime',align:'left',width:50,title:'最近访问时间'}
	            ]],
	            onSelect:function(index, row){
	               
	            },
				onLoadSuccess:function(data){
					
				}
	        });
    };
    gridLoad();

    /*刷新 */
    $("#js_refresh").on("click",function(){
    	$("#grid").datagrid('reload'); //重新加载表格
	});
    /*强制下线 */
    $("#js_offline").on("click",function(){
    	//获取复选框值
 	  
			var items = $("input[name='sessionid']:checked");
			if (items.length == 0) {
				$.messager.alert("操作提示", "请先选择一行！", "info");
				return false;
			}
			var sessionIdArr = [];
			$.each(items, function(index, item) {
				sessionIdArr[index] = item.value;
			});
			$.ajax({
				type : "POST",
				dataType : "json",
				url : "${pageContext.request.contextPath}/admin/offLine",
				data : "sessionIds=" + sessionIdArr,
				success : function(data) {
					if (data.data == "ok") {
						$.messager.alert("操作提示", "用户已被强制下线！", "info");
						$("#grid").datagrid('reload');
					}
				}
			});
		});
	});
</script>
</body>
</html>

