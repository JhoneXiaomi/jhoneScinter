<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
  <head>
	<title>会达装饰集团&nbsp;|&nbsp;网站集成管理平台&nbsp;|&nbsp;登录</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<style>
	li{list-style:none;}img{border:none;}em{font-style:normal;}
	.clear{height:0;overflow:hidden;clear:both;}
	.UpLayer{ margin:100px;}
	.UpLayer dl dt{width:150px;position:absolute; z-index:3;padding:0 5px;line-height:20px;}
	.UpLayer02{border:#ccc 1px solid; border-top:none;background:#f1f1f1; margin:-1px 0 0 -1px;}
	.UpLayer dl dd{ width:150px;position:absolute;z-index:2;border:#ccc 1px solid;padding:5px; line-height:20px; background:#f1f1f1; display:none; margin:-55px 0 0 -1px;}
	.UpLayer dl dd a{ display:block;border-bottom:#ccc 1px dashed;}
	a{color:#000000;font-weight:bold;border-bottom:dashed #999999 1px;text-decoration:none;outline:none;blr:this.onFocus=this.blur();}
	a:hover{color:#000;text-decoration:underline;}
	</style>
	<style>
		ul{
			margin: 0px;
			padding: 0px;
		}
		li{
			margin: 0px;
			padding: 0px;
		}
	</style>
</head>
<body bgcolor="#EFEEEE">
<form method="post" action="index" name="form1" id="loginForm" >		
	<div id="bg_div" style="margin:0px auto;margin-top:180px;width:565px;height:257px;background-image:url(${sessionScope.scinter_login_bg})">
			<div style="position:relative;left:40px;top:120px;">
				<span style="color:#636363;font-weight:bold;font-family:Arial,sans-serif;font-size: 14px;">账号：&nbsp;&nbsp;</span>
				<input type="hidden" id="showKaptchaImageOrNot" name="showKaptchaImageOrNot"/>
				<input type="text" id="userName" name="userName" style="border:1px solid #CCC;width:150px;height:23px;color: #444;font-size: 16px;font-weight: bold;line-height: 18px;" maxlength="20" />
			</div>
			<div style="position:relative;left:40px;top:132px;">
				<span style="color:#636363;font-weight:bold;font-family:Arial,sans-serif;font-size: 14px;">密码：&nbsp;&nbsp;</span>
				<input type="password" id="password" name="password" style="border:1px solid #CCC;width:150px;height:23px;color: #444;font-size: 16px;font-weight: bold;line-height: 18px;" maxlength="20" />
			</div>
			
			<div id="kaptcha_div" style="position:relative;left:25px;top:135px;display:none;">
			      <span style="color:#636363;font-weight:bold;font-family:Arial,sans-serif;font-size: 14px;">验证码：&nbsp;&nbsp;</span>
			      <input name="kaptcha" type="text" id="kaptcha" maxlength="4" style="border:1px solid #CCC;width:150px;height:23px;color: #444;font-size: 16px;font-weight: bold;" />               
			      <img width="90px"  height="32px" style="margin-bottom:-8px;cursor:pointer;" src="${pageContext.request.contextPath}/admin/getKaptchaImage" id="kaptchaImage" title="点击刷新"/>  
			</div>
			
			<div style="position:relative;left:130px;top:144px;">
				<input name="sub" type="submit" title="Login" style="width:55px;height:25px;border:1px solid #CCC;background-color:#EEF0F2;cursor:hand" id="submitButton" value="登录">
				<input name="reset" type="reset" title="Login" style="width:55px;height:25px;border:1px solid #CCC;background-color:#EEF0F2;cursor:hand" id="resetButton" value="重置">
			</div>
			
			<span style="color:red;font-size:12px;margin-left:40px;position:relative;top:-26px;">${errorInfo }</span>
	</div>
</form>
<script src="${pageContext.request.contextPath}/static/www/scripts/jquery.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" charset="utf-8">
		jQuery(function($){
			$("#userName").focus();
			
			//验证码是否显示
			$.get("${pageContext.request.contextPath}/admin/showKaptchaImageOrNot",
			  function(data){
				
				if(null!=data.data){
					var bg_url = data.data.bg_url;
					var login_captcha = data.data.login_captcha;
					if(bg_url!=""){
				    	$("#bg_div").css("backgroundImage","url("+bg_url+")");
				    }
					if(login_captcha=="0"){
				    	$("#showKaptchaImageOrNot").val("0");
				    	$("#kaptcha_div").hide();
				    }
				    if(login_captcha=="1"){
				    	$("#showKaptchaImageOrNot").val("1");
				    	$("#kaptcha_div").show();
				    	//刷新验证码
				    	$('#kaptchaImage').hide().attr('src', '${pageContext.request.contextPath}/admin/getKaptchaImage?random=' + Math.floor(Math.random()*100) ).fadeIn();
				    }
				}
			});
			
			//验证登陆表单
			$("#loginForm").submit(function(){
				var id = $("#userName").val();
				var pwd = $("#password").val();
				var code = "";		
				$.ajax({
					type : "POST",
					dataType : "json",
					async: false,
					url : "${pageContext.request.contextPath}/admin/getKaptchaCode",
					success : function(data) {
						code = data.data;
					}
				});
				
				var kaptcha = $("#kaptcha").val();
				if(id==""){
					alert("用户名不能为空！");
					$("#userName").focus();
					return false;
				}
				if(pwd==""){
					alert("密码不能为空！");
					$("#password").focus();
					return false;
				}
				//alert(code);
				if(kaptcha==""){
					alert("验证码不能为空！");
					$("#kaptcha").focus();
					return false;
				}
				if(kaptcha!=code){
					alert("验证码错误，请重新输入！");
					//刷新验证码
			    	$('#kaptchaImage').hide().attr('src', '${pageContext.request.contextPath}/admin/getKaptchaImage?random=' + Math.floor(Math.random()*100) ).fadeIn();
					$("#kaptcha").val("");
					$("#kaptcha").focus();
					return false;
				}
				
			});
			
		});
		
		$(function(){
		    $('#kaptchaImage').click(function () {//生成验证码  
		     $(this).hide().attr('src', '${pageContext.request.contextPath}/admin/getKaptchaImage?random=' + Math.floor(Math.random()*100) ).fadeIn();  
		     var code = '${code}'; 
		    $("#codeVal").val(code);
		    event.cancelBubble=true;  
		    });  
		});   
		  
		  
		window.onbeforeunload = function(){  
		    //关闭窗口时自动退出  
		    if(event.clientX>360&&event.clientY<0||event.altKey){     
		        alert(parent.document.location);  
		    }  
		};  
		  
		  
		function changeCode() {  
		    $('#kaptchaImage').hide().attr('src', '${pageContext.request.contextPath}/admin/getKaptchaImage?random=' + Math.floor(Math.random()*100) ).fadeIn();  
		    event.cancelBubble=true;  
		}
	
	</script>
</body>
</html>
