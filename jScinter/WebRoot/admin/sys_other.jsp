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
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/webuploader.css" type="text/css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/SYS.css" type="text/css" />
</head>
<body>
<div class="wrapper" id="js_layout">
	<form id="sysOtherForm" method="post">
    <div data-options="region:'center'" class="noborder hidden-x pad10">
		<table class="forms">
			<tbody>
				
				<tr class="ttl">
					<td colspan="2">
						系统信息设置
					</td> 
				</tr>
                <tr>
					<td class="right">系统名称：</td>
					<td><input type="text" id="scinter_website_name" name="scinter_website_name" class="txt" value="${scinter_website_name }" style="width:245px;"/></td>
				</tr>
				<tr>
					<td class="right">系统左上方LOGO：</td>
                    <td>
                    <a href="javscript:void(0);" class="thumbnail"><img width="80px;" id="scinter_logo_url_img" src="${scinter_logo_url }"></a>
                    <input type="hidden" id="scinter_logo_url" name="scinter_logo_url" value="${scinter_logo_url }"/>&nbsp;&nbsp;
					<span id="scinter_logo_upload">选择图片</span>
					<span>[图片大小:156*39(px)]</span>             
                    </td>
				</tr>
				<tr>
					<td class="right">登录页背景图片：</td>
					<td>
					<a href="javscript:void(0);" class="thumbnail"><img width="80px;" id="scinter_login_bg_img" src="${scinter_login_bg }"></a>
					<input type="hidden" id="scinter_login_bg" name="scinter_login_bg" value="${scinter_login_bg }"/>&nbsp;&nbsp;
					<span id="login_bg_upload">选择图片</span>
					<span>[图片大小:565*257(px)]</span>
					</td>
				</tr>
				
				<tr class="ttl">
					<td colspan="2">邮件设置</td>
				</tr>
				<tr>
                    <td class="right">发送邮件服务器(SMTP)：</td>
                    <td><input type="text" id="smtp_server" name="smtp_server" class="txt" style="width:245px;" value="${smtp_server }"></td>
                </tr>
                <tr>
                    <td class="right">邮箱地址：</td>
                    <td><input type="text" id="email_address"  name="email_address" class="txt" style="width:245px;" value="${email_address }"></td>
                </tr>
                <tr>
                    <td class="right">邮箱密码：</td>
                    <td><input type="text" id="email_password" name="email_password" class="txt" style="width:245px;" value="${email_password }"></td>
                </tr>

                <tr class="ttl">
                    <td colspan="2">
                       		上传文件路径设置
                    </td>
                </tr>
                <tr>
                    <td class="right">服务器端保存路径：</td>
                    <td>
                    	<input type="text" class="txt" id="server_upload_file_path" name="server_upload_file_path" style="width:245px;" value="${server_upload_file_path }">&nbsp;&nbsp;
                    </td>
                </tr>
                
                <tr class="ttl">
                    <td colspan="2">
                       		数据库备份设置
                    </td>
                </tr>
                <tr>
                    <td class="right">数据库密码：</td>
                    <td><input type="text" id="database_password" class="txt" style="width:245px;" value="">&nbsp;&nbsp;
                        <button class="sbutton" id="db_backup" type="button">手动备份</button>
                    </td>
                </tr>
                <!-- 
                <tr>
					<td class="right">自动备份：</td>
					<td>间隔
					    <select name="database_back_datetime" id="database_back_datetime" class="easyui-combobox" style="width:77px;">
					        <option value="1">1天</option>
					        <option value="3">3天</option>
					        <option value="7">7天</option>
					        <option value="14">14天</option>
					        <option value="30">30天</option>
					    </select>
					</td>
				</tr>
				 -->
			</tbody>
		</table>
    </div>
    <div data-options="region:'south',collapsible:false,height:50" class="noborder hidden">
	   <div class="ftbutton border-n">
			<ul class="lists rf" style="padding-left:200px;">
				<li><button class="button" id="js_save" type="button">保存</button></li>
				<li><button class="button" type="reset">重置</button></li>
			</ul>
		</div>
    </div>
    </form>
</div>
<script src="${pageContext.request.contextPath}/static/www/scripts/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/easyui.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/webuploader.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/common.js" type="text/javascript" charset="utf-8"></script> 
<script type="text/javascript" charset="utf-8">
jQuery(function($){
   $("#js_layout").layout({fit:true});
   
   /*数据库备份*/
   $("#db_backup").click(function(){
	   var pwd = $("#database_password").val();
	   var db_pwd = '${database_password}';
	   if(pwd!=db_pwd){
		   $.messager.alert("操作提示", "数据库密码错误，请重新输入！","info");
		   $("#database_password").val("");
		   $("#database_password").focus();
			return false;
	   }else{
		   $.post("${pageContext.request.contextPath}/admin/mysqlBackup", { dbPWD: db_pwd },
				  function(data){
				  	if(data.data!="fail"){
				  		location.href = "${pageContext.request.contextPath}/admin/download?fileName="+data.data;
				  	}else{
				  		$.messager.alert("操作提示", "数据库备份失败！","info");
				  	}
			});
	   }
	   
	   
   });
   
   /*保存 */
	$("#js_save").click(function(){
		$('#sysOtherForm').form({
		    url:'${pageContext.request.contextPath}/admin/saveOtherConfig',
			onSubmit : function() {
				//进行表单验证
				var server_upload_file_path = $("#server_upload_file_path").val();
				if(server_upload_file_path==""){
					$("#server_upload_file_path").focus();
					$.messager.alert("操作提示", "服务器上传文件保存路径不能为空！","info");
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
		$('#sysOtherForm').submit();
	});
   
   /*logo上传*/
	var uploader = WebUploader.create({
	
	    // 选完文件后，是否自动上传。
	    auto: true,
	
	    // swf文件路径
	    swf: '${pageContext.request.contextPath}/static/www/scripts/Uploader.swf',
	
	    // 文件接收服务端。
	    server: '${pageContext.request.contextPath}/admin/imgFileListUpload?imgType=1',
	    
	     fileNumLimit:30,
	    
	    // 选择文件的按钮
	    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
	    pick: {
	    	id:'#scinter_logo_upload'
	    	,multiple : false,
	    },
	
	    // 只允许选择图片文件。
	    accept: {
            title: 'Images',
            extensions: 'gif,jpg,jpeg,bmp,png,GIF,JPG,JPEG,BMP,PNG',
            mimeTypes: 'image/*'
        },
	});
	
	// 文件上传成功，显示图片
	uploader.on('uploadSuccess', function( file,response ) {
	    //增加多个文件显示及删除操作
		var url = response.url;
		$("#scinter_logo_url").val(url);
		$("#scinter_logo_url_img").attr("src",url);
	});
   
	
	var uploader1 = WebUploader.create({
		
	    // 选完文件后，是否自动上传。
	    auto: true,
	
	    // swf文件路径
	    swf: '${pageContext.request.contextPath}/static/www/scripts/Uploader.swf',
	
	    // 文件接收服务端。
	    server: '${pageContext.request.contextPath}/admin/imgFileListUpload?imgType=2',
	    
	     fileNumLimit:30,
	    
	    // 选择文件的按钮
	    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
	    pick: {
	    	id:'#login_bg_upload'
	    	,multiple : false,
	    },
	
	    // 只允许选择图片文件。
	    accept: {
            title: 'Images',
            extensions: 'gif,jpg,jpeg,bmp,png,GIF,JPG,JPEG,BMP,PNG',
            mimeTypes: 'image/*'
        },
	});
	
	// 文件上传成功，显示图片
	uploader1.on('uploadSuccess', function( file,response ) {
	    //增加多个文件显示及删除操作
		var url = response.url;
		$("#scinter_login_bg").val(url);
		$("#scinter_login_bg_img").attr("src",url);
	});
   
});
</script>
</body>
</html>
