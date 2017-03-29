<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>用户列表 | 后台管理系统</title>
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
		<table class="easyui-datagrid" data-options="fitColumns:true,toolbar:'#toolbar'" id="grid_listUser"></table>
		<div id="toolbar" class="toolpanel datagrid-toolbar">
		    <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-new" plain="true" id="js_add">新建</a>
			<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" plain="true" id="js_edit">编辑</a>
			<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-del" plain="true" id="js_del">删除</a>
			<a href="javascript:void(0);" class="easyui-linkbutton l-btn l-btn-plain" iconcls="icon-authorize" plain="true" id="js_reset">重置密码</a>
			<a href="javascript:void(0);" class="easyui-linkbutton toggles" iconCls="icon-showStart" plain="true" id="js_start">启用</a>
			<a href="javascript:void(0);" class="easyui-linkbutton toggles" iconCls="icon-showStop" plain="true" id="js_stop">停用</a>
			<!-- 
		    <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-leadin" plain="true" id="js_import">导入</a>
			<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-leadout" plain="true" id="leadout">导出</a>
           	-->	 
           <div class="rf reletive sch">
				<input class="txt" type="text" id="keyWord" name="keyWord" value="请输入用户ID、姓名或电话" />
				<button type="button" id="search" class="sbutton">查询</button>
			</div>
			<div class="rf">
	            <select class="easyui-combobox" name="status" id="status" style="width:120px;">
	                <option value="1">正常</option>
	                <option value="2">停用</option>
	            </select>
	        </div>
		</div>
	</div>
</div>


<div id="dlg" class="easyui-dialog"  modal="true" inline="true"  shadow="true" style="width: 450px; height: 200px;"  closed="true" buttons="#dlg-buttons">
		<div data-options="region:'center'" class="noborder hidden-x">
			<br/>
			<form id="form1" method="post">
					<table class="forms">
						<tbody>
							<tr>
								<td class="right"><i class="require">*</i>新密码：</td>
								<td>
									<input type="password" id="newPWD1" name="newPWD1" class="txt" /> 
								</td>
							</tr>
							<tr>
								<td class="right"><i class="require">*</i>新密码确认：</td>
								<td>
									<input type="password" id="newPWD2" name="newPWD2" class="txt" /> 
								</td>
							</tr>
							
						</tbody>
					</table>
				</form>
		</div>
	<div id="dlg-buttons">
		<div class="ftbutton border-n">
            <ul class="lists rf">
                <li><button id="resetPWD" class="button" type="button">保存</button></li>
                <li><button class="button" type="button"  onclick="$('#dlg').dialog('close');" >取消</button></li>
            </ul>
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
            $("#grid_listUser").datagrid({
                url:'${pageContext.request.contextPath}/admin/listUserToJson',
                fit:true,
                striped: true,
                pagination:true,
                pageSize: 10,
                singleSelect:true,
				scrollbarSize:0,
				checkOnSelect:true,
           		selectOnCheck:false,
                columns:[[
					{field:'userId',checkbox:true},
					{field:'userName',align:'left',width:50,title:'用户ID'},
					{field:'nickName',align:'left',width:50,title:'姓名',
						formatter:function(value,row,index){
							return '<a class="nblack" href="javascript:void(0);">'+value+'</a>';
						}
					},
					{field:'roleName',align:'left',width:50,title:'角色'},
					{field:'phone',align:'left',width:60,title:'电话'},
					{field:'creater',align:'left',width:40,title:'创建人'},
                    {field:'createTime',align:'left',width:60,title:'创建时间'},
					{field:'updater',align:'left',width:40,title:'修改人'},
                    {field:'updateTime',align:'left',width:60,title:'修改时间'},
                    {field:'status',align:'center',width:30,title:'状态',
                    	formatter:function(value,row,index){
                    		if(value==1){		
                    			return '<div style="width:60%;background-color:#00EE00;font-weight:bold;">正常</div>'; 
                    		}else if(value==2){
                    			return '<div style="width:60%;background-color:red;font-weight:bold;color:#FFFAFA;">停用</div>';
                    		}else{
                    			return value;
                    		}
						}	
                    }
                ]],
                onSelect:function(index,row){
                    if(!$("#js_layout").layout("panel","south").is(":visible")){
                       $("#js_layout").layout("autoExpand","south");
                    }
					$("#framebottom").attr("src","showUser?userId="+row.userId);
                },
				onLoadSuccess:function(node,data){
					$("#grid_listUser").datagrid("selectRow",rowIndex);
					//$('.opration a').click(function(e){e.stopPropagation();});
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
	   $("#framebottom").attr("src","userAdd.jsp");
	});
	
    /*编辑*/
    $("#js_edit").on("click",function(){
	   if(!$("#js_layout").layout("panel","south").is(":visible")){
			$("#js_layout").layout("autoExpand","south");
	   }
	   //获取复选框值
	   var items = $("input[name='userId']:checked");
       var userId = [];
       $.each(items, function (index, item) {
    	   userId[index] = item.value;
       });
       if(userId.length==1){
    	   $("#framebottom").attr("src","showUser?userId="+userId[0]);
       }else{
    	   $.messager.alert("操作提示", "请选择一行！","info");
       }
	});
	
    /*删除*/
    $("#js_del").on("click",function(){
	   //获取复选框值
	   var items = $("input[name='userId']:checked");
       var userId = [];
       $.each(items, function (index, item) {
    	   userId[index] = item.value;
       });
       if(userId.length>0){
    	   $.messager.confirm("确认", "确认删除选中的"+userId.length+"条用户?", function (r){  
	   	        if (r) {
	   	        	$.ajax({
	   		   			type : "POST",
	   		   			dataType : "json",
	   		   			url : "${pageContext.request.contextPath}/admin/updateUserStatus",
	   		   			data : "userIds=" + userId+"&status=3",
	   		   			success : function(data) {
	   		   				if(data.data=="ok"){
	   		   					$.messager.alert("操作提示", "删除成功！","info");
	   		   					$("#grid_listUser").datagrid('reload'); //重新加载
	   		   				}
	   		   			}
	   	   			});
	   	        }
   	    	});
       }else{
    	   $.messager.alert("操作提示", "请先选择一行！","info");
       }
	});
    
    /*停用 */
    $("#js_stop").on("click",function(){
	   //获取复选框值
	   var items = $("input[name='userId']:checked");
       var userId = [];
       $.each(items, function (index, item) {
    	   userId[index] = item.value;
       });
       if(userId.length>0){
    	   $.messager.confirm("确认", "确认停用选中的"+userId.length+"条用户?", function (r){  
	   	        if (r) {
	   	        	$.ajax({
	   		   			type : "POST",
	   		   			dataType : "json",
	   		   			url : "${pageContext.request.contextPath}/admin/updateUserStatus",
	   		   			data : "userIds=" + userId+"&status=2",
	   		   			success : function(data) {
	   		   				if(data.data=="ok"){
	   		   					$.messager.alert("操作提示", "停用账号成功！","info");
	   		   					$("#grid_listUser").datagrid('reload'); //重新加载
	   		   				}
	   		   			}
	   	   			});
	   	        }
   	    	});
       }else{
    	   $.messager.alert("操作提示", "请先选择一行！","info");
       }
	});
    
    /*启用 */
    $("#js_start").on("click",function(){
	   //获取复选框值
	   var items = $("input[name='userId']:checked");
       var userId = [];
       $.each(items, function (index, item) {
    	   userId[index] = item.value;
       });
       if(userId.length>0){
    	   $.messager.confirm("确认", "确认启用选中的"+userId.length+"条用户?", function (r){  
	   	        if (r) {
	   	        	$.ajax({
	   		   			type : "POST",
	   		   			dataType : "json",
	   		   			url : "${pageContext.request.contextPath}/admin/updateUserStatus",
	   		   			data : "userIds=" + userId+"&status=1",
	   		   			success : function(data) {
	   		   				if(data.data=="ok"){
	   		   					$.messager.alert("操作提示", "启用账号成功！","info");
	   		   					$("#grid_listUser").datagrid('reload'); //重新加载
	   		   				}
	   		   			}
	   	   			});
	   	        }
   	    	});
       }else{
    	   $.messager.alert("操作提示", "请先选择一行！","info");
       }
	});
    
    /*密码重置 */
    $("#js_reset").on("click",function(){
    	//获取复选框值
 	    var items = $("input[name='userId']:checked");
        var userId = [];
        $.each(items, function (index, item) {
     	   userId[index] = item.value;
        });
        if(userId.length>0){
        	$('#dlg').dialog('open').dialog('setTitle', '密码重置');
        }else{
     	   $.messager.alert("操作提示", "请先选择一行！","info");
        }
    });
    
	$("#resetPWD").click(function() {
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
					
					//获取复选框值
					var items = $("input[name='userId']:checked");
					var userIdArr = [];
					$.each(items, function(index, item) {
						userIdArr[index] = item.value;
					});
					$.ajax({
						type : "POST",
						dataType : "json",
						url : "${pageContext.request.contextPath}/admin/resetUsersPassword",
						data : "userIds=" + userIdArr + "&newPWD=" + pwd1,
						success : function(data) {
							if (data.data == "ok") {
								$('#dlg').dialog('close');
								$.messager.alert("操作提示", "密码重置成功！", "info");
								$("#newPWD1").val("");
								$("#newPWD2").val("");
							}else if(data.data=="short_length"){
								$.messager.alert("操作提示", "密码长度太短，请重新输入！", "info");
							}
						}
					});
					
				}
			});
			
		});

		/*搜索*/
		$("#search").on("click", function() {
			if($('#keyWord').val()=="请输入用户ID、姓名或电话"){
				$('#keyWord').val('');
			}
			//加载搜索列表
			var query = {
				'keyWord' : $('#keyWord').val()
			}; //把查询条件拼接成JSON
			$("#grid_listUser").datagrid('options').queryParams = query; //把查询条件赋值给datagrid内部变量
			$("#grid_listUser").datagrid({
				url : '${pageContext.request.contextPath}/admin/searchListUser'
			}); //重新加载查询url
			$("#grid_listUser").datagrid('reload'); //重新加载
		});

		/*window resize*/
		winResize = function() {
			var winWidth = $(window).width(), winHeight = $(window).height();
			$("#js_layout").layout("resize", {
				width : winWidth,
				height : winHeight
			});
			if ($.support.boxModel && !$.support.leadingWhitespace) {
				var iframes = window.frames;
				for (var l = iframes.length, i = 0; i < l; i++) {
					var f = iframes[i].winResize;
					if (f)
						f();
				}
			}
		}
		$(window).wresize(winResize);
		winResize();
	});
</script>
</body>
</html>