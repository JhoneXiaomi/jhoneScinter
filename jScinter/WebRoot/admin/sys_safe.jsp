<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", -10);
%> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>safe</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/easyui.css" type="text/css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/common.css" type="text/css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/SYS.css" type="text/css" />
</head>
<body>
<div class="wrapper" id="js_layout">
	<form id="sysSafeForm" method="post">
    <div data-options="region:'center'" class="noborder hidden-x pad10">
		<table class="forms">
			<tbody>
				<tr class="ttl">
					<td colspan="2">
						账号安全设置：
					</td> 
				</tr>
				<tr>
					<td class="right" width="240">
					           用户账号区分大小写：
					</td>
					<td>
					    <input type="radio" id="account_case_yes" value="1" name="account_case" checked="checked"><label for="account_case_yes" class="name">区分大小写</label>
                        <input type="radio" id="account_case_no" value="0" name="account_case"><label for="account_case_no" class="name">不区分大小写</label>
					</td>
				</tr>
				<tr>
					<td class="right">用户默认密码：</td>
					<td><input type="text" class="txt" id="default_password" name="default_password" style="width:143px;" value="${default_password }"></td>
				</tr>
				<tr>
					<td class="right">默认密码有效期：</td>
					<td><input type="number" class="txt" id="default_password_validity_time" name="default_password_validity_time" style="width:143px;" value="${default_password_validity_time }">天</td>
				</tr>
				<tr>
					<td class="right">登录随机验证码：</td>
					<td>
						<input type="radio" value="1" id="login_captcha_yes" name="login_captcha" checked="checked"><label for="login_captcha_yes" class="name">启用</label>
                        <input type="radio" value="0" id="login_captcha_no" name="login_captcha"><label for="login_captcha_no" class="name">不启用</label>
                    </td>
				</tr>
				<tr>
				    <td class="right">用户密码长度控制：</td>
					<td>控制密码最小长度，至少包含<select id="password_min_length" name="password_min_length" class="easyui-combobox" style="width:50px;"><option value="0">任意</option><option value="6">6</option><option value="8">8</option><option value="10">10</option><option value="12">12</option><option value="14">14</option><option value="16">16</option><option value="18">18</option></select>个字符</td>
				</tr>
				<tr>
				    <td class="right">用户密码修改控制：</td>
					<td>新密码不能与当前密码相同
						<input type="radio" value="1" id="new_password_repeat_yes" name="new_password_repeat" checked="checked"><label for="new_password_repeat_yes" class="name">启用</label>
                        <input type="radio" value="0" id="new_password_repeat_no" name="new_password_repeat"><label for="new_password_repeat_no" class="name">不启用</label>
					</td>
				</tr>
				<tr>
				    <td class="right">用户密码复杂度控制 ：</td>
					<td>控制密码复杂度，密码至少包含<input type="number" id="new_password_uppercase" name="new_password_uppercase" class="txt" style="width:43px;" value="${new_password_uppercase }">个大写字符，<input type="number" id="new_password_lowercase" name="new_password_lowercase" class="txt" style="width:43px;" value="${new_password_lowercase }">个小写字符，<input id="new_password_number" name="new_password_number" type="number" class="txt" style="width:50px;" value="${new_password_number }">个数字</td>
				</tr>
				<tr>
					<td class="right">管理员重置账号密码后发送邮件通知：</td>
					<td>
						<input type="radio" value="1" id="new_password_email_yes" name="new_password_email" checked="checked"><label for="new_password_email_yes" class="name">是</label>
						<input type="radio" value="0" id="new_password_email_no" name="new_password_email"><label for="new_password_email_no" class="name">否</label>
					</td>
				</tr>
				
                <tr class="ttl">
                    <td colspan="2">会话安全设置：</td>
                </tr>
                <tr>
                    <td class="right">会话失效时间：</td>
                    <td>会话超过 <input type="number" id="session_timeout" name="session_timeout" class="txt" style="width:43px;" value="${session_timeout }"> 分钟内无活动失效(注：会话超时时间范围必须在30~240分钟之间)</td>
                </tr>
                <tr>
                    <td class="right">用户在线状态更新间隔：</td>
                    <td><input type="number" id="session_update_time" name="session_update_time" class="txt" style="width:43px;" value="${session_update_time }">秒（注：不得大于10秒）</td>
                </tr>
                
			</tbody>
		</table>
    </div>
    <div data-options="region:'south',collapsible:false,height:50" class="noborder hidden">
	   <div class="ftbutton border-n">
			<ul class="lists rf" style="padding-left:200px;">
				<li><button id="js_save" class="button" type="button">保存</button></li>
				<li><button class="button" type="reset">重置</button></li>
			</ul>
		</div>
    </div>
    </form>
</div>
<script src="${pageContext.request.contextPath}/static/www/scripts/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/easyui.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/common.js" type="text/javascript" charset="utf-8"></script> 
<script type="text/javascript" charset="utf-8">
jQuery(function($){
   $("#js_layout").layout({fit:true});
   
   /* 初始化单选框和下拉列表 */
   var account_case = '${account_case}';
   var login_captcha = '${login_captcha}';
   var new_password_repeat = '${new_password_repeat}';
   var new_password_email = '${new_password_email}';
   var password_min_length = '${password_min_length}';
   
   if(account_case=="1"){
	   $("#account_case_yes").attr("checked","checked");
   }else if(account_case=="0"){
	   $("#account_case_no").attr("checked","checked");
   }
   
   if(login_captcha=="1"){
	   $("#login_captcha_yes").attr("checked","checked");
   }else if(login_captcha=="0"){
	   $("#login_captcha_no").attr("checked","checked");
   }
   
   if(new_password_repeat=="1"){
	   $("#new_password_repeat_yes").attr("checked","checked");
   }else if(new_password_repeat=="0"){
	   $("#new_password_repeat_no").attr("checked","checked");
   }
   
   if(new_password_email=="1"){
	   $("#new_password_email_yes").attr("checked","checked");
   }else if(new_password_email=="0"){
	   $("#new_password_email_no").attr("checked","checked");
   }
   
   $('#password_min_length').combobox('setValue',password_min_length);
   
   /*保存 */
	$("#js_save").click(function(){
		$('#sysSafeForm').form({
		    url:'${pageContext.request.contextPath}/admin/saveSystemConfig',
			onSubmit : function() {
				//进行表单验证
				var default_password = $("#default_password").val();
				if(default_password==""){
					$("#default_password").focus();
					$.messager.alert("操作提示", "用户默认密码不能为空！","info");
					return false;
				}
				
			},
			success : function(data) {
				var str=jQuery.parseJSON(data);
				if(str.data=='ok'){
					//刷新父窗口表格
					$.messager.alert("操作提示", "保存成功！","info");
				}else{
					$.messager.alert("操作提示", "操作失败！","info");
				}
			}
		});
		//提交表单
		$('#sysSafeForm').submit();
	});
   
});
</script>
</body>
</html>
