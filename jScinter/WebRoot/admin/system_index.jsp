<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>会达装饰集团|网站集成管理平台</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/easyui.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/common.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/QA.css" type="text/css" />
	<script type="text/javascript" charset="utf-8">
		var roleName = "${sessionScope.Role.roleName}";
		if(roleName!="超级管理员"){
			location.href  = "${pageContext.request.contextPath}/error/404.jsp";
		}
	
	</script>
</head>
<body>
    <div class="wrapper" id="js_layout">  
    	<div data-options="region:'north',split:true" style="height:50px;overflow:hidden;">
			<table style="width:100%;">
				<tr>
					<td align="left">
						<a title="三创国际 | 网站集成管理平台" href="javascript:void(0);"><img src="${sessionScope.scinter_logo_url }" style="margin:-2px 0px 0px 8px;vertical-align: middle;width:156px;height:39px;"/></a>
						<ul class="index_tab">
							<li><a href="scinter_index.jsp">网站管理</a></li>
							<!-- 超级管理员才可以系统设置 -->
							<c:if test='${sessionScope.Role.roleName=="超级管理员" }'>
							<li><a href="system_index.jsp">系统设置</a></li>
							</c:if>
						</ul>
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
    
    	<div data-options="region:'west',split:true,width:200" title="系统设置导航树" class="aside noborder" id="westTree">
            <div class="easyui-accordion noborder-s" data-options="fit:true" id="accordion" style="margin-top: 3px;">
                
                <div title="系统设置">
					<ul id="sysAdmin" class="easyui-tree"></ul>
                </div>
                
            </div>
        </div> 
        
	    <div data-options="region:'center'" class="noborder hidden">
	    	<iframe name="frameright" id="frameright" src="userList.jsp" height="100%" width="100%" frameborder="0" scrolling="no" allowtransparency="true"></iframe>
	    </div>
      
    </div>
<script src="${pageContext.request.contextPath}/static/www/scripts/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/easyui.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/easyui.tree.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/common.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" charset="utf-8">
	jQuery(function($) {
		
		$("#accordion").accordion(
				{
					onSelect : function(title, index) {
						$("#frameright").attr(
								"src",
								$("#accordion").accordion("getPanel", index)
										.find(".tree-node-selected a").attr(
												"href"));
					}
				});
		$("#js_layout").layout({
			fit : true
		});
		
		/*导航树菜单*/
		
		/*系统管理 */
		$('#sysAdmin').tree(
				{
					url : '${pageContext.request.contextPath}/static/www/json/sysAdmin.json?' + Math.random(),
					onLoadSuccess : function(node, data) {
						$("#sysAdmin").tree("select",$("#sysAdmin").tree("getRoot").target);
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