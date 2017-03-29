<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>新建角色</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/easyui.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/common.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/QA.css" type="text/css" />
</head>
<body>
<div class="wrapper details notblbew" id="js_layout">
    <div data-options="region:'center'" class="noborder" style="overflow:hidden;">
        <div class="easyui-tabs" data-options="tools:'#tab-tools'" id="tabs"> 
            <div title="角色基本信息" data-options="" class="pad10 relative" id="tab1">
                <form id="roleForm" method="post">
                <input type="hidden" id="roleId" name="roleId" value="${roleInfo.roleId}"  />
                <input type="hidden" id="authId" name="authId" value="${authInfo.authId}"  />
                <table class="forms" style="table-layout:fixed;">
                    <tbody>
                    	<tr>	
                            <td class="right" width="120"></td>
                            <td width="300"></td>
                            <td class="right" width="120"></td>
                            <td width="300"></td>
                        </tr>
                    	<tr>
                    		<td class="right"><i class="require">*</i>角色名称：</td>
                    		<td><input class="txt" id="roleName" name="roleName" type="text" value="${roleInfo.roleName}" />
                    		</td>
                    		<td class="right" width="120"></td>
                            <td width="300"></td>
                    	</tr>
                    	
                    	<tr>
                    		<td class="right"><i class="require">*</i>隶属分公司：</td>
                    		<td>
		                    	<select name="branchCompany" id="branchCompany" class="easyui-combobox" 
                    			data-options="panelHeight:'160',editable : false,
                    			valueField: 'id',      
                     			textField: 'text',
                     			url:'${pageContext.request.contextPath}/static/www/json/scinter_company.json',
                     			onLoadSuccess:function(data){
			                    	var status = '${roleInfo.branchCompany }';
			                    	if(status!=''){
			                   			$('#branchCompany').combobox('setValue',status);
			                   		}
			                    }" style="width:247px;">
                    			 	<option>===请选择===</option>
                    			</select>
                    		</td>
                    		<td class="right" width="120"></td>
                            <td width="300"></td>
                    	</tr>
                    	
                   		<tr>
                    		<td class="right"><i class="require">*</i>共有权限：</td>
                    		<td>
		                    		<input id="myTask1" name="zxal" type="checkbox" value="${authInfo.zxal }" style="vertical-align: middle;" /><label for="myTask1">装修案例</label>
		                    		&nbsp;&nbsp;
		                    		<input id="myTask2" name="sjtd" type="checkbox" value="${authInfo.sjtd }" style="vertical-align: middle;" /><label for="myTask2">设计团队</label>
		                    		&nbsp;&nbsp;
		                    		<input id="myTask3" name="lpxx" type="checkbox" value="${authInfo.lpxx }" style="vertical-align: middle;" /><label for="myTask3">楼盘信息</label>
		                    		&nbsp;&nbsp;
		                    		<input id="myTask4" name="zjgd" type="checkbox" value="${authInfo.zjgd }" style="vertical-align: middle;" /><label for="myTask4">在建工地</label>
                    		</td>
                    		<td class="right" width="120"></td>
                            <td width="300"></td>
                    	</tr>
                    	<tr>
                    		<td class="right"></td>
                    		<td>
		                    		<input id="myTask5" name="hxdp" type="checkbox" value="${authInfo.hxdp }" style="vertical-align: middle;" /><label for="myTask5">户型点评</label>
		                    		&nbsp;&nbsp;
		                    		<input id="myTask6" name="zxdd" type="checkbox" value="${authInfo.zxdd }" style="vertical-align: middle;" /><label for="myTask6">在线订单</label>                    				
		                    		&nbsp;&nbsp;
                    				<input id="myTask7" name="zxbx" type="checkbox" value="${authInfo.zxbx }" style="vertical-align: middle;" /><label for="myTask7">在线报修</label>
                    				&nbsp;&nbsp;
                    				<input id="myTask8" name="zxwd" type="checkbox" value="${authInfo.zxwd }" style="vertical-align: middle;" /><label for="myTask8">装修问答</label>
                    		</td>
                    		<td class="right" width="120"></td>
                            <td width="300"></td>
                    	</tr>
                    	
                    	<tr>
                    		<td class="right"></td>
                    		<td>
	                    		<input id="myTask9" name="lypl" type="checkbox" value="${authInfo.lypl }" style="vertical-align: middle;" /><label for="myTask9">留言评论</label>
	                    		&nbsp;&nbsp;
	                    		<input id="myTask10" name="sypz" type="checkbox" value="${authInfo.sypz }" style="vertical-align: middle;" /><label for="myTask10">首页配置</label>
                    			&nbsp;&nbsp;
	                    		<input id="myTask21" name="syhdlb" type="checkbox" value="${authInfo.syhdlb }" style="vertical-align: middle;" /><label for="myTask21">首页活动轮播</label>
                    			 &nbsp;&nbsp;
                    		    <input id="myTask19" name="rmxq" type="checkbox" value="${authInfo.rmxq }" style="vertical-align: middle;" /><label for="myTask19">热门小区</label>
                    		</td>
                    		<td class="right" width="120"></td>
                            <td width="300"></td>
                    	</tr>
                    	<tr>
                    		<td class="right"></td>
                    		<td>
	                    		<input id="myTask40" name="syhdlbm" type="checkbox" value="${authInfo.syhdlbm }" style="vertical-align: middle;" /><label for="myTask40">手机首页活动轮播</label>
	                    		&nbsp;&nbsp;
                    		</td>
                    		<td class="right" width="120"></td>
                            <td width="300"></td>
                    	</tr>
                    	<tr>
                    		<td class="right"><i class="require">*</i>三创权限：</td>
                    		<td>
	                    		<input id="myTask12" name="schd" type="checkbox" value="${authInfo.schd }" style="vertical-align: middle;" /><label for="myTask12">热门活动</label>
                    			&nbsp;&nbsp;
                    			<input id="myTask11" name="zxzx" type="checkbox" value="${authInfo.zxzx }" style="vertical-align: middle;" /><label for="myTask11">说装修</label>
                    		</td>
                    		<td class="right" width="120"></td>
                            <td width="300"></td>
                    	</tr>
                    	<tr>
                    		<td class="right"><i class="require">*</i>新洲权限：</td>
                    		<td>
                    		    <input id="myTask13" name="xzxw" type="checkbox" value="${authInfo.xzxw }" style="vertical-align: middle;" /><label for="myTask13">新洲新闻</label>
	                    		&nbsp;&nbsp;
	                    		<input id="myTask14" name="xzhd" type="checkbox" value="${authInfo.xzhd }" style="vertical-align: middle;" /><label for="myTask14">新洲活动</label>
                    		    &nbsp;&nbsp;
                    		    <input id="myTask31" name="lftc" type="checkbox" value="${authInfo.lftc }" style="vertical-align: middle;" /><label for="myTask14">老房套餐</label>
                    		    &nbsp;&nbsp;
                    		</td>
                    		<td class="right" width="120"></td>
                            <td width="300"></td>
                    	</tr>
                    	<tr>
                    		<td class="right"><i class="require">*</i>瑞博文权限：</td>
                    		<td>
	                    		<input id="myTask15" name="rbwzx" type="checkbox" value="${authInfo.rbwzx }" style="vertical-align: middle;" /><label for="myTask15">说装修</label>
	                    		&nbsp;&nbsp;
	                    		<input id="myTask16" name="rbwhd" type="checkbox" value="${authInfo.rbwhd }" style="vertical-align: middle;" /><label for="myTask16">热门活动</label>
                    		    &nbsp;&nbsp;
                    		    <input id="myTask17" name="zxxgt" type="checkbox" value="${authInfo.zxxgt }" style="vertical-align: middle;" /><label for="myTask17">装修效果图</label>
                    		     &nbsp;&nbsp;
                    		    <input id="myTask18" name="zxfg" type="checkbox" value="${authInfo.zxfg }" style="vertical-align: middle;" /><label for="myTask18">装修风格</label>
                    		</td>
                    		<td class="right" width="120"></td>
                            <td width="300"></td>
                    	</tr>
                    	<tr>
                    		<td class="right"><i class="require">*</i>人人乐权限：</td>
                    		<td>
	                    		<input id="myTask20" name="rrlzxal" type="checkbox" value="${authInfo.rrlzxal }" style="vertical-align: middle;" /><label for="myTask20">说装修</label>
	                    		&nbsp;&nbsp;
                    		</td>
                    		<td class="right" width="120"></td>
                            <td width="300"></td>
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
    /*页面布局*/
    $("#js_layout").layout({fit:true});
    
    /*选择权限复选框 */
    var authId = $("#authId").val();
    if(authId!=""){
	  	//如果值为1 则选中复选框
		var items = $("input[type='checkbox']");
	    $.each(items, function (index, item) {
	 	   if(item.value==1){
	 		 item.checked = true;
	 	   }
	    });
	}
    
    /*检查角色名称是否重复 */
    function checkRoleNameExist(roleName){
    	//中文编码
    	roleName = encodeURI(encodeURI(roleName));
		var flag = false;
		$.ajax({
			type : "POST",
			dataType : "json",
			async: false,
			url : "${pageContext.request.contextPath}/admin/checkRoleName",
			data : "roleName=" + roleName,
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
		$('#roleForm').form({
		    url:'${pageContext.request.contextPath}/admin/saveRole',
			onSubmit : function() {
				//进行表单验证
				var roleId = $("#roleId").val();
				var roleName = $("#roleName").val();
				if(roleId==""){
					//判断角色重名
					var flag = checkRoleNameExist(roleName);
					if(flag){
						$.messager.alert("操作提示", "角色名称已经存在，请修改！","info");
						return false;
					}
				}
				//表单验证
				if(roleName=="" || roleName.trim()==""){			
					$.messager.alert("操作提示", "角色名称不能为空！","info");
					$("#roleName").val("");
					$("#roleName").focus();
					return false;
				}
				var items = $("input[type='checkbox']:checked");
				if(items.length==0){
					$.messager.alert("操作提示", "请至少勾选一个功能模块！","info");
					return false;
				}
				
				//如果选中复选框则赋值为1 否则为0
				var itemsAll = $("input[type='checkbox']");
				$.each(itemsAll, function (index, item) {
					
					 if($(this).prop("checked") == true){
				 		  $(this).val(1);
				 		  // console.info("checkbox name is:"+$(this).attr("name")+"["+$(this).val()+"]");
				 	   }
					 if($(this).prop("checked") == false){
				 		  
						
				 		  $(this).prop("checked","checked");
				 		  $(this).val(0); 
				 		  // console.info("check is checked or false:"+ $(this).prop("checked")+"checkbox name is:"+$(this).attr("name")+"["+$(this).val()+"]");
				 	   }
				 });
			},
			success : function(data) {
				var str=jQuery.parseJSON(data);
				if(str.data=='ok'){
					//刷新父窗口表格
					$.messager.alert("操作提示", "保存成功！","info");
					var row = parent.$("#grid_role").datagrid('getSelected');
				  	var rowIndex = parent.$("#grid_role").datagrid('getRowIndex', row);
				  	parent.rowIndex = rowIndex;
					parent.$("#grid_role").datagrid("reload");
				}else{
					$.messager.alert("操作提示", "操作失败！","info");
				}
			}
		});
		//提交表单
		$('#roleForm').submit();
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
		
		
   };
    $(window).wresize(winResize);
    winResize();
});
</script>
</body>
</html>
