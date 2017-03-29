<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>用户密码修改</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/easyui.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/common.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/QA.css" type="text/css" />
</head>
<body>
<div class="wrapper details notblbew" id="js_layout">
    <div data-options="region:'center'" class="noborder" style="overflow:hidden;">
        <div class="easyui-tabs" data-options="tools:'#tab-tools'" id="tabs"> 
            <div title="密码重置" data-options="" class="pad10 relative" id="tab1">
                <form id="userForm" method="post">
                <input type="hidden" id="userId" name="userId" value="${sessionScope.UserInfo.userId}"  />
                <table class="forms" style="table-layout:fixed;">
                    <tbody>
                    	<tr>
                            <td class="right" width="120"></td>
                            <td width="300"></td>
                            <td class="right" width="120"></td>
                            <td width="300"></td>
                        </tr>
                    	<tr>
                    		<td class="right"><span style="color:red;">*</span>旧密码：</td>
                    		<td><input class="txt" id="oldPWD" name="oldPWD" type="password" />
                    			
                    		</td>
                    		<td class="right"></td>
                    		<td>
                    		</td>
                    	</tr>
                    	
                    	<tr>
                    		<td class="right" width="10%"><span style="color:red;">*</span>新密码：</td>
                    		<td><input class="txt" id="newPWD1" name="newPWD1" type="password" />
                    		
                    		</td>
                    		<td class="right" width="10%"></td>
                    		<td></td>
                    	</tr>
                    	<tr>
                    		<td class="right" width="10%"><span style="color:red;">*</span>新密码确认：</td>
                    		<td><input class="txt" id="newPWD2" name="newPWD2" type="password" />
                    		</td>
                    		<td class="right" width="10%"></td>
                    		<td></td>
                    	</tr>
                    	<tr>
                    		<td>
                    			<div class="ftbutton border-n">
						            <ul class="lists rf">
						                <li><button id="js_save" class="button" type="button">保存</button></li>
						            </ul>
					        	</div>
                    		</td>
                    	</tr>
                    </tbody>
                </table>
                </form>
				<div class="blank10"></div>
            </div>
        </div>
    </div>
</div>


<script src="${pageContext.request.contextPath}/static/www/scripts/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/jQuery.md5.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/easyui.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/easyui.datagrid.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/easyui.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/common.js" type="text/javascript" charset="utf-8"></script>

<script type="text/javascript" charset="utf-8">
jQuery(function($){
    
	/*layout*/
    $("#js_layout").layout({fit:true});
	
	// ${pageContext.request.contextPath}
	
	
	/*保存 */
	$("#js_save").click(function(){
		var oldPWD = $("#oldPWD").val();
		var md5OldPWD = $.md5(oldPWD);
		var currentPWD = '${sessionScope.UserInfo.password}';
		if(md5OldPWD!=currentPWD){
			$.messager.alert("操作提示", "旧密码不正确！", "info");
			return false;
		}
		var pwd1 = $("#newPWD1").val();
		var pwd2 = $("#newPWD2").val();
		if (pwd1 == "") {
			$.messager.alert("操作提示", "新密码不能为空！", "info");
			return false;
		}
		if (pwd2 == "") {
			$.messager.alert("操作提示", "确认密码不能为空！", "info");
			return false;
		}
		if (pwd1 != pwd2) {
			$.messager.alert("操作提示", "两次密码输入不一致！", "info");
			return false;
		}
		
		//同步 密码安全设置检查
		$.ajax({
			type : "POST",
			dataType : "json",
			async: false,
			url : "${pageContext.request.contextPath}/admin/checkSystemPasswordSafe",
			success : function(data) {
				var password_min_length = data.data.password_min_length;//用户密码长度控制
				var new_password_repeat = data.data.new_password_repeat;//用户密码修改控制 新密码不能与当前密码相同
				var new_password_number = data.data.new_password_number;//用户密码复杂度控制 数字个数
				var new_password_lowercase = data.data.new_password_lowercase;//用户密码复杂度控制 小写字符个数
				var new_password_uppercase = data.data.new_password_uppercase;//用户密码复杂度控制 大写字符个数
				if(pwd2.length<password_min_length){
					$.messager.alert("操作提示", "密码长度过短，请至少输入"+password_min_length+"位!", "info");
					return false;
				}
				
				// 数字个数
				var numCount = pwd2.replace(/\D/g, '').length;
				// 大小写字母个数
				var lowerCount = pwd2.replace(/[^a-z]/g, '').length;
				// 大小写字母个数					
				var upperCount = pwd2.replace(/[^A-Z]/g, '').length;
				if(numCount < new_password_number){
					$.messager.alert("操作提示", "新密码至少需包含 "+new_password_number+"位数字！", "info");
					return false;
				}
				if(lowerCount < new_password_lowercase){
					$.messager.alert("操作提示", "新密码至少需包含 "+new_password_number+"位小写字母！", "info");
					return false;
				}
				if(upperCount < new_password_uppercase){
					$.messager.alert("操作提示", "新密码至少需包含 "+new_password_number+"位大写字母！", "info");
					return false;
				}
				
				if(new_password_repeat=="0"){
					var md5OldPWD = $.md5(pwd2);
					var currentPWD = '${sessionScope.UserInfo.password}';
					if(md5OldPWD==currentPWD){
						$.messager.alert("操作提示", "新密码不能与当前密码相同！", "info");
						return false;
					}
				}
				
				var userId = $("#userId").val();
				$.ajax({
					type : "POST",
					dataType : "json",
					url : "${pageContext.request.contextPath}/admin/resetUsersPassword",
					data : "userIds=" + userId + "&newPWD=" + pwd1,
					success : function(data) {
						if (data.data == "ok") {
							//$.messager.alert("操作提示", "密码重置成功,请重新登录!", "info");
							$.messager.confirm('Confirm','密码重置成功，确认退出并重新登录？',function(r){ 
								if (r){
									parent.location.href = "${pageContext.request.contextPath}/admin/loginout"; 
								}
							});
						}else if(data.data=="short_length"){
							$.messager.alert("操作提示", "密码长度太短，请重新输入！", "info");
						}
					}
				});
				
			}
		});
		
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
