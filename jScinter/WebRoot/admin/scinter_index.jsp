<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>会达装饰集团|网站集成管理平台</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/easyui.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/common.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/QA.css" type="text/css" />
</head>
<body>
    <div class="wrapper" id="js_layout">  
    	<div data-options="region:'north',split:true" id="box_north" style="height:50px;overflow:hidden;">
			<table style="width:100%;">
				<tr>
					<td align="left">
						<a title="三创国际 | 网站集成管理平台" href="javascript:void(0);"><img src="${sessionScope.scinter_logo_url }" style="margin:-2px 0px 0px 8px;vertical-align: middle;width:156px;height:39px;"/></a>
						<c:if test='${firstLogin==0 }'>
						<ul class="index_tab">
							<li><a href="scinter_index.jsp">网站管理</a></li>
							<!-- 超级管理员才可以系统设置 -->
							<c:if test='${sessionScope.Role.roleName=="超级管理员" }'>
							<li><a href="system_index.jsp">系统设置</a></li>
							</c:if>
						</ul>
						</c:if>
					</td>
					<td align="right">
						<table style="margin-top:5px;">
								<tr>
									<td><b>当前时间：</b></td>
									<td><span id="dateTime"></span></td>
								</tr>
								<tr>
									<td><b>当前用户：</b></td>
									<td>${sessionScope.UserInfo.nickName} &nbsp;|&nbsp;${sessionScope.Role.roleName}&nbsp;|&nbsp;<a href="loginout" style="color: red;" >注销</a></td>
								</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
		
        <div data-options="region:'west',split:true,width:200" title="网站管理导航树" class="aside noborder" id="westTree">
            <div class="easyui-accordion noborder-s" data-options="fit:true" id="accordion" style="margin-top: 3px;">
                <c:if test='${sessionScope.Role.roleName=="超级管理员" }'>
                <c:if test='${firstLogin==0 }'>
                <div title="三创装饰 ">
					<ul id="sczs" class="easyui-tree"></ul>
                </div>
                
                <div title="新洲装饰">
					<ul id="xzzs" class="easyui-tree"></ul>
                </div>
                
                <div title="瑞博文装饰一">
					<ul id="rbwzs1" class="easyui-tree"></ul>
                </div>
                 <div title="瑞博文装饰二">
					<ul id="rbwzs2" class="easyui-tree"></ul>
                </div>
                
                <div title="人人乐装饰">
					<ul id="rrlzs" class="easyui-tree"></ul>
                </div>
                </c:if>
                </c:if>
                
                <c:if test='${sessionScope.Role.roleName!="超级管理员" }'>
                <c:if test='${firstLogin==0 }'>
                <c:if test="${fn:contains(sessionScope.Role.branchCompany,'sc')}">
                <div title="三创装饰 ">
					<ul id="sczs" class="easyui-tree"></ul>
                </div>
                </c:if>
                
                <c:if test="${fn:contains(sessionScope.Role.branchCompany,'xz')}">
                <div title="新洲装饰">
					<ul id="xzzs" class="easyui-tree"></ul>
                </div>
                </c:if>
                
                <c:if test="${fn:contains(sessionScope.Role.branchCompany,'rbw1')}">
                <div title="瑞博文装饰">
					<ul id="rbwzs1" class="easyui-tree"></ul>
                </div>
                </c:if>
                <c:if test="${fn:contains(sessionScope.Role.branchCompany,'rbw2')}">
                <div title="瑞博文装饰">
					<ul id="rbwzs2" class="easyui-tree"></ul>
                </div>
                </c:if>
                
                <c:if test="${fn:contains(sessionScope.Role.branchCompany,'rrl')}">
                <div title="人人乐装饰">
					<ul id="rrlzs" class="easyui-tree"></ul>
                </div>
                </c:if>
                </c:if>
                </c:if>

                <div title="个人设置">
					<ul id="settings" class="easyui-tree tree"></ul>
                </div>
            </div>
        </div> 
        
	    <div data-options="region:'center'" class="noborder hidden">
	    	<input type="hidden" id="homeBranchCompany" name="homeBranchCompany"/>
	    	<iframe name="frameright" id="frameright" src="caseList.jsp" height="100%" width="100%" frameborder="0" scrolling="no" allowtransparency="true"></iframe>
	    </div>
      
    </div>
<script src="${pageContext.request.contextPath}/static/www/scripts/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/easyui.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/easyui.tree.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/common.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" charset="utf-8">
	jQuery(function($) {
		
		$("#js_layout").layout({fit:true});
		
		var loginFlag = '${firstLogin}';
		if(loginFlag==1){
			$.messager.alert("操作提示", "初次登陆，请先修改密码！","info");
			$("#frameright").attr("src","password.jsp");
		}else{
			//登录初始化页面
			var roleName = '${sessionScope.Role.roleName}';
			var branchCompany = '${sessionScope.Role.branchCompany}';
			
			if(roleName=="超级管理员"){
				$("#frameright").attr('src','${pageContext.request.contextPath}/admin/initialize?controlledCompany=sczs');
			}else{
				if(branchCompany.indexOf("sc")>0){
					$("#frameright").attr('src','${pageContext.request.contextPath}/admin/initialize?controlledCompany=sczs');
				}else if(branchCompany.indexOf("xz")>0){
					$("#frameright").attr('src','${pageContext.request.contextPath}/admin/initialize?controlledCompany=xzzs');
				}else if(branchCompany.indexOf("rbw1")>0){
					$("#frameright").attr('src','${pageContext.request.contextPath}/admin/initialize?controlledCompany=rbwzs1');
				}else if(branchCompany.indexOf("rbw2")>0){
					$("#frameright").attr('src','${pageContext.request.contextPath}/admin/initialize?controlledCompany=rbwzs2');
				}else if(branchCompany.indexOf("rrl")>0){
					$("#frameright").attr('src','${pageContext.request.contextPath}/admin/initialize?controlledCompany=rrlzs');
				}		
			}
			
			
			
			
		}
		
		$("#accordion").accordion(
				{
					onSelect : function(title, index) {
						console.info("title:"+title+"index:"+index+"the value of accontdion is:"+$("#accordion").accordion("getPanel", index).find(".tree-node-selected a").attr("href"));
						// $("#frameright").attr("src",$("#accordion").accordion("getPanel", index).find(".tree-node-selected a").attr("href"));
					    var branchCompany = "";
						if(title == '三创装饰'){
							branchCompany = "sczs";
						}else if(title == '新洲装饰'){
							branchCompany = "xzzs";
						}else if(title == '人人乐装饰'){
							branchCompany = "rrlzs";
						}else if(title == '瑞博文装饰一'){
							branchCompany = "rbwzs1";
						}else if(title == '瑞博文装饰二'){
							branchCompany = "rbwzs2";
						}    
						controlledCompany = "";
						$("#frameright").attr('src','${pageContext.request.contextPath}/admin/initialize?controlledCompany='+branchCompany);
					}
				});
		
		/*导航树菜单*/
		
		/* 三创装饰 */
		$('#sczs').tree(
				{
					url : '${pageContext.request.contextPath}/admin/scGetRoleAuthJson?authId=${sessionScope.Role.authId}&homeBranchCompany=sc&r=' + Math.random(),
					onLoadSuccess : function(node, data) {
						
						$("#sczs").tree("select",$("#sczs").tree("getRoot").target);
					}
				});
		
		/* 新洲装饰 */
		$('#xzzs').tree(
				{
					url : '${pageContext.request.contextPath}/admin/xzGetRoleAuthJson?authId=${sessionScope.Role.authId}&homeBranchCompany=xz&r=' + Math.random(),
					onLoadSuccess : function(node, data) {
						
					     $("#xzzs").tree("select",$("#xzzs").tree("getRoot").target); 
					}
					
				});
		
		/* 瑞博文装饰 一 */
		$('#rbwzs1').tree(
				{
					url : '${pageContext.request.contextPath}/admin/rbwGetRoleAuthJson?authId=${sessionScope.Role.authId}&homeBranchCompany=rbw&r=' + Math.random(),
					onLoadSuccess : function(node, data) {
						
						$("#rbwzs1").tree("select",$("#rbwzs1").tree("getRoot").target);
					},
				});
		
		/* 瑞博文装饰 二 */
		$('#rbwzs2').tree(
				{
					url : '${pageContext.request.contextPath}/admin/rbw2GetRoleAuthJson?authId=${sessionScope.Role.authId}&homeBranchCompany=rbw&r=' + Math.random(),
					onLoadSuccess : function(node, data) {
						
						$("#rbwzs2").tree("select",$("#rbwzs2").tree("getRoot").target);
					},
				});
		
		/* 人人乐装饰 */
		$("#rrlzs").tree({
				url : '${pageContext.request.contextPath}/admin/rrlGetRoleAuthJson?authId=${sessionScope.Role.authId}&homeBranchCompany=rrl&r=' + Math.random(),
				onLoadSuccess : function(node, data) {

					$("#rrlzs").tree("select",$("#rrlzs").tree("getRoot").target);
				}
				});
		
		/* 个人设置 */
		$('#settings').tree(
				{
					url : '${pageContext.request.contextPath}/static/www/json/settings.json?' + Math.random(),
					onLoadSuccess : function(node, data) {
						
						$("#settings").tree("select",
								$("#settings").tree("getRoot").target);
					}
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
		};
		$(window).wresize(winResize);
		winResize();
		
	});
</script>
<script type="text/javascript">
	//时间显示
	tick();
</script>
</body>
</html>