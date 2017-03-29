<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
    	<div data-options="region:'north',split:true" style="height:50px;overflow:hidden;">
			<table style="width:100%;">
				<tr>
					<td align="left">
						<a title="三创国际 | 网站集成管理平台" href="javascript:void(0);"><img src="${pageContext.request.contextPath}/static/www/images/logo.png" style="margin:-2px 0px 0px 8px;vertical-align: middle;"/></a>
						<ul class="index_tab">
							<li><a href="scinter_index.jsp">三创装饰  </a></li>
							<li><a href="xinzhou_index.jsp">新洲装饰 </a></li>
							<li><a href="xinzhou_index.jsp">瑞博文装饰 </a></li>
							<li><a href="system_index.jsp">系统管理  </a></li>
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
    
        <div data-options="region:'west',split:true" class="aside noborder" id="westTree">
            <div class="easyui-accordion noborder-s" data-options="fit:true" id="accordion">
                <div title="网站首页 ">
					<ul id="wzsy" class="easyui-tree"></ul>
                </div>
                
                <div title="专题活动">
					<ul id="zthd" class="easyui-tree"></ul>
                </div>
                
                <div title="装修套餐">
					<ul id="zxtc" class="easyui-tree"></ul>
                </div>
                
                <div title="设计团队">
					<ul id="sjtd" class="easyui-tree"></ul>
                </div>
                
                <div title="装修案例">
					<ul id="zxal" class="easyui-tree"></ul>
                </div>
                
                <div title="热装楼盘">
					<ul id="rzlp" class="easyui-tree"></ul>
                </div>
                
                <div title="说装修">
					<ul id="szx" class="easyui-tree"></ul>
                </div>
                
                <div title="三创新闻">
					<ul id="qyxw" class="easyui-tree"></ul>
                </div>
                 
                <div title="关于三创">
					<ul id="qyxw" class="easyui-tree"></ul>
                </div>
                
                <div title="合作品牌">
					<ul id="hzpp" class="easyui-tree"></ul>
                </div>
                
                <div title="留言管理">
					<ul id="typz" class="easyui-tree"></ul>
                </div>
                
                <div title="订单管理">
					<ul id="typz" class="easyui-tree"></ul>
                </div>
                
                <div title="报修管理">
					<ul id="typz" class="easyui-tree"></ul>
                </div>
                
            </div>
        </div> 
        
	    <div data-options="region:'center'" class="noborder hidden">
	    	<iframe name="frameright" id="frameright" src="www/userList.jsp" height="100%" width="100%" frameborder="0" scrolling="no" allowtransparency="true"></iframe>
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