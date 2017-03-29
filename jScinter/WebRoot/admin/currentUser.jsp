<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>用户信息 | 后台管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/easyui.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/common.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/QA.css" type="text/css" />
</head>
<body>
<div class="wrapper details notblbew" id="js_layout">
    <div data-options="region:'center'" class="noborder">
        <div class="easyui-tabs" data-options="tools:'#tab-tools'" id="tabs"> 
            <div title="用户基本信息" data-options="" class="pad10 relative" id="tab1">
                <form id="userForm" method="post">
                <input type="hidden" id="userId" name="userId" value="${empty userInfo.userId ? sessionScope.UserInfo.userId : userInfo.userId}"  />
                <table class="forms" style="table-layout:fixed;">
                    <tbody>
                    	<tr>
                            <td class="right" width="120"></td>
                            <td width="300"></td>
                            <td class="right" width="120"></td>
                            <td width="300"></td>
                        </tr>
                    	<tr>
                    		<td class="right"><i class="require">*</i>用户ID：</td>
                    		<td>
                    			<input class="txt" disabled="disabled" id="userName" name="userName" type="text" value="${empty userInfo.userName ? sessionScope.UserInfo.userName : userInfo.userName}" />
                    		</td>
                    		<td class="right"><i class="require">*</i>姓名：</td>
                    		<td><input class="txt" id="nickName" name="nickName" type="text" value="${empty userInfo.nickName ? sessionScope.UserInfo.nickName : userInfo.nickName}" />
                    		</td>
                    	</tr>
                    	
                    	<tr>
                    		<td class="right" width="10%">电子邮箱：</td>
                    		<td><input class="txt" id="email" name="email" type="text" value="${empty userInfo.email ? sessionScope.UserInfo.email : userInfo.email}" /></td>
                    		<td class="right" width="10%">电话：</td>
                    		<td><input class="txt" id="phone" name="phone" type="text" value="${empty userInfo.phone ? sessionScope.UserInfo.phone : userInfo.phone}" /></td>
                    	</tr>
                    	
                    </tbody>
                </table>
                </form>
				<div class="blank10"></div>
            </div>
        </div>
        
        <div id="tab-tools" class="">  
            <!--a href="javascript:void(0)" class="ico pop" title="弹出" id="winMax">&nbsp;</a-->
        </div>
    </div>
    <div data-options="region:'south',collapsible:false,height:50" class="noborder hidden">
        <div class="ftbutton border-n">
            <ul class="lists rf">
                <li><button class="button" type="button" id="js_save">保存</button></li>
            </ul>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/static/www/scripts/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/easyui.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/easyui.datagrid.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/common.js" type="text/javascript" charset="utf-8"></script>

<script type="text/javascript" charset="utf-8">
jQuery(function($){
    /*弹出按钮*/
    if(window.top==window.self){
        $("#winMax").hide();
    }else{
        $("#winMax").winOpen({url:location.href,event:"click",width:800,height:600,beforeOpen:function(){
            parent.hideSouth();
            return true;
        }});
    }
    
	/*layout*/
    $("#js_layout").layout({fit:true});
	
	// ${pageContext.request.contextPath}
	
	/*选中下拉combobox */
    var roleId = '${userInfo.roleId}';
	if(null!=roleId && roleId!=""){
		$('#roleId').combobox('setValue',roleId);
	}
    
	function checkUserIdExist(userId){
		//中文编码
    	userId = encodeURI(encodeURI(userId));
		var flag = false;
		$.ajax({
			type : "POST",
			dataType : "json",
			async: false,
			url : "${pageContext.request.contextPath}/admin/checkUserId",
			data : "userId=" + userId,
			success : function(data) {
				if (data.data == "ok") {
					flag = true;
				}
			}
		});
		return flag;
	}
	
	/*保存 */
	$("#js_save").click(function(){
		$('#userForm').form({
		    url:'${pageContext.request.contextPath}/admin/saveUser',
			onSubmit : function() {
				//进行表单验证
				var id = $("#userId").val();
				var userId = $("#userName").val();
				
				if(id==""){
					var flag = checkUserIdExist(userId);
					if(flag){
						$.messager.alert("操作提示", "用户ID已经存在！","info");
						return false;
					}
				}
				var nickName = $("#nickName").val();
				var roleId = $("#roleId").combobox("getValue");
				if(userId==""){
					$("#userName").focus();
					$.messager.alert("操作提示", "用户ID不能为空！","info");
					return false;
				}
				if(nickName==""){
					$("#nickName").focus();
					$.messager.alert("操作提示", "姓名不能为空！","info");
					return false;					
				}
				if(roleId==""||roleId=="===请选择==="){
					$("#roleId").focus();
					$.messager.alert("操作提示", "请先选择角色！","info");
					return false;
				}
			},
			success : function(data) {
				var str=jQuery.parseJSON(data);
				if(str.data=='ok'){
					$.messager.alert("操作提示", "保存成功！","info");
				}else{
					$.messager.alert("操作提示", "操作失败！","info");
				}
			}
		});
		//提交表单
		$('#userForm').submit();
	});
	
    
    /*tabs*/
    $("#tabs").tabs({fit:true,tools:'#tab-tools',onSelect:function(title,index){
        var tab=$("#tabs").tabs("getTab",index),loaded = tab.attr("loaded");
        if(loaded=="true")
            return;
        else
            tab.attr("loaded",true);
    }});
	
	//自适应窗口大小
     winResize=function(){
        var winWidth = $(window).width(),winHeight=$(window).height();
        $("#js_layout").layout("resize",{width:winWidth,height:winHeight});
		var tdW2=$("table.forms td").eq(1).width();
		var tdW3=$("table.forms td").eq(2).width();
		$("div.equalW").width(tdW2+tdW3+247+12+2);
		tableAlign("tab1");
		
		
   }
    $(window).wresize(winResize);
    winResize();
});
</script>
</body>
</html>
