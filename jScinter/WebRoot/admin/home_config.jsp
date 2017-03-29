<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", -10);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>网站首页配置</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/easyui.css" type="text/css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/common.css" type="text/css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/webuploader.css" type="text/css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/SYS.css" type="text/css" />
	<style>
	    .curCompany a:link{color:blue;}
		/* .curCompany a:visited{color: #6ADD3F;} */
		.curCompany a:hover{color: #6ADD3F}
	
	</style>
</head>
<body>
<div class="wrapper" id="js_layout">
	<form id="sysOtherForm" method="post">
	<input type="hidden" id="curBranchCompany" name="curBranchCompany" value="${curBranchCompany }"/>
    <div data-options="region:'center'" class="noborder hidden-x pad10">
		<table class="forms">
			<tbody>
				 	<c:choose>
				 			<c:when test="${currentPer == '超级管理员' }">
				 			<c:if test="${sessionScope.controlledCompany=='sczs' }">
					 			<tr>
									<td colspan="2" class="curCompany">
										<a href="javascript:void(0)" style="color: red;">(三创)</a>&nbsp;&nbsp;&nbsp;
										<a href="${pageContext.request.contextPath}/admin/showHomeConfig?homeCompany=bjsc">北京</a>&nbsp;&nbsp;&nbsp;
							            <a href="${pageContext.request.contextPath}/admin/showHomeConfig?homeCompany=tjsc">天津</a>&nbsp;&nbsp;&nbsp;
								        <a href="${pageContext.request.contextPath}/admin/showHomeConfig?homeCompany=lfsc">廊坊</a>&nbsp;&nbsp;&nbsp;
								        <a href="${pageContext.request.contextPath}/admin/showHomeConfig?homeCompany=sjzsc">石家庄</a>&nbsp;&nbsp;&nbsp;
								        <a href="${pageContext.request.contextPath}/admin/showHomeConfig?homeCompany=hssc">衡水</a>&nbsp;&nbsp;&nbsp;
								        <a href="${pageContext.request.contextPath}/admin/showHomeConfig?homeCompany=bdsc">保定</a>&nbsp;&nbsp;&nbsp;
								        <a href="${pageContext.request.contextPath}/admin/showHomeConfig?homeCompany=tysc">太原</a>&nbsp;&nbsp;&nbsp;
								        <a href="${pageContext.request.contextPath}/admin/showHomeConfig?homeCompany=tssc">唐山</a>
									</td>
								</tr>	
							</c:if>
							<c:if test="${sessionScope.controlledCompany=='xzzs' }">
								<tr>
									<td colspan="2" class="curCompany">
										<a href="javascript:void(0)" style="color: red;">(新洲)</a>&nbsp;&nbsp;&nbsp;
										<a href="${pageContext.request.contextPath}/admin/showHomeConfig?homeCompany=bjxz">北京</a>&nbsp;&nbsp;&nbsp;
							            <a href="${pageContext.request.contextPath}/admin/showHomeConfig?homeCompany=tjxz">天津</a>&nbsp;&nbsp;&nbsp;
								        <a href="${pageContext.request.contextPath}/admin/showHomeConfig?homeCompany=tsxz">唐山</a>&nbsp;&nbsp;&nbsp;
								        <a href="${pageContext.request.contextPath}/admin/showHomeConfig?homeCompany=bdxz">保定</a>&nbsp;&nbsp;&nbsp;
								        <a href="${pageContext.request.contextPath}/admin/showHomeConfig?homeCompany=lfxz">廊坊</a>&nbsp;&nbsp;&nbsp;
								        <a href="${pageContext.request.contextPath}/admin/showHomeConfig?homeCompany=sjzxz">石家庄</a>&nbsp;&nbsp;&nbsp;
								        <a href="${pageContext.request.contextPath}/admin/showHomeConfig?homeCompany=czxz">沧州</a>&nbsp;&nbsp;&nbsp;
								        <a href="${pageContext.request.contextPath}/admin/showHomeConfig?homeCompany=tyxz">太原</a>&nbsp;&nbsp;&nbsp;
								        <a href="${pageContext.request.contextPath}/admin/showHomeConfig?homeCompany=jnxz">济南</a>&nbsp;&nbsp;&nbsp;
								        <a href="${pageContext.request.contextPath}/admin/showHomeConfig?homeCompany=hfxz">合肥</a>&nbsp;&nbsp;&nbsp;
								        <a href="${pageContext.request.contextPath}/admin/showHomeConfig?homeCompany=cqxz">重庆</a>&nbsp;&nbsp;&nbsp;
								        <a href="${pageContext.request.contextPath}/admin/showHomeConfig?homeCompany=zzxz">郑州</a>
									</td>
									
								</tr>
							</c:if>	
							<c:if test="${sessionScope.controlledCompany=='rbwzs1' }">
								<tr>
									<td colspan="2" class="curCompany">
										<a href="javascript:void(0)" style="color: red;">(瑞博文一)</a>&nbsp;&nbsp;&nbsp;
							            <a href="${pageContext.request.contextPath}/admin/showHomeConfig?homeCompany=sjzrbw1">石家庄</a>&nbsp;&nbsp;&nbsp;
								        <a href="${pageContext.request.contextPath}/admin/showHomeConfig?homeCompany=bdrbw1">保定</a>&nbsp;&nbsp;&nbsp;
								        <a href="${pageContext.request.contextPath}/admin/showHomeConfig?homeCompany=hsrbw1">衡水</a>&nbsp;&nbsp;&nbsp;
								        <a href="${pageContext.request.contextPath}/admin/showHomeConfig?homeCompany=lfrbw1">廊坊</a>
									</td>
								</tr>	
							</c:if>
							<c:if test="${sessionScope.controlledCompany=='rbwzs2' }">
								<tr>
									<td colspan="2" class="curCompany">
										<a href="javascript:void(0)" style="color: red;">(瑞博文二)</a>&nbsp;&nbsp;&nbsp;
										<a href="${pageContext.request.contextPath}/admin/showHomeConfig?homeCompany=hsrbw2">衡水</a>&nbsp;&nbsp;&nbsp;
									</td>
								</tr>	
							</c:if>
							<c:if test="${sessionScope.controlledCompany=='rrlzs' }">
								<tr>
									<td colspan="2" class="curCompany">
										<a href="javascript:void(0)" style="color: red;">(人人乐)</a>&nbsp;&nbsp;&nbsp;
										<a href="${pageContext.request.contextPath}/admin/showHomeConfig?homeCompany=sjzrrl">石家庄</a>
							            
									</td>
								</tr>	
							</c:if>
				 			</c:when>
				 	</c:choose>
				
				<tr class="ttl">
					<td colspan="2">
						首页配置(PC站点)
					</td>
				</tr>
				<tr>
					<td><input type="hidden" name="server_upload_file_path" value="${server_upload_file_path}"/></td>				
				</tr>
                <tr>
					<td class="right">公司电话(PC站)：</td>
					<td colspan="3"><input type="text" id="scinter_home_telePhone" name="scinter_home_telePhone" style="width:300px;"class="txt" value="${scinter_home_telePhone }" style="width:245px;"/></td>
				</tr>
				<c:set var="theString" value="${curBranchCompany }"/>
						<c:if test="${fn:endsWith(theString,'sc') }">
							<tr>
								<td class="right">QQ咨询(PC站)：</td>
								<td colspan="2"><input type="text" id="scinter_home_portraiture" name="scinter_home_portraiture" style="width:300px;"class="txt" value="${scinter_home_portraiture }" style="width:245px;"/></td>
							</tr>
							<tr>
								<td class="right">公司邮箱(PC站)：</td>
								<td colspan="2"><input type="text" id="scinter_home_postBox" name="scinter_home_postBox" style="width:300px;" class="txt" value="${scinter_home_postBox }" style="width:245px;"/></td>
							</tr>
						</c:if>
				<tr>
					<td class="right">公司名称(PC站)：</td>
					<td colspan="2"><input type="text" id="scinter_home_childCompany" name="scinter_home_childCompany" style="width:300px;" class="txt" value="${scinter_home_childCompany }" style="width:245px;"/></td>
				</tr>	
				<tr>
					<td class="right">公司地址(PC站)：</td>
					<td colspan="2">
					
                		<textarea id="scinter_home_address" name="scinter_home_address" style="width:300px;height:60px;">${scinter_home_address}</textarea>
                	</td>					
				</tr>
				
				<tr>
					<td class="right">友情链接(PC站)：</td>
					<td colspan="2">
					
                		<textarea id="scinter_home_friendlyLink" name="scinter_home_friendlyLink" style="width: 50%;overflow: scroll;">${scinter_home_friendlyLink}</textarea>
                	    <br/><font color="red">注：如果有多个友情链接，请使用回车键换行，请拷贝示例代码后修改href为对应网站链接和网站描述文字</font>
                	    <br/><pre>示例代码：&lt;a href="http://www.to8to.com/index.html" target="_blank"&gt;土巴兔装修网&lt;/a&gt;</pre> 
                	</td>
				</tr>
				
				<tr>
					<td class="right">百度商桥(PC站)：</td>
					<td colspan="3">
					
                		<textarea id="scinter_home_shangQiao" name="scinter_home_shangQiao" style="width: 50%;">${scinter_home_shangQiao}</textarea>
                	</td>	
				</tr>
				<tr>
					<td class="right">百度统计(PC站)：</td>
					<td colspan="3">
					
                		<textarea id="scinter_home_statistics" name="scinter_home_statistics" style="width: 50%;">${scinter_home_statistics}</textarea>
                	</td>	
				</tr>
				
				<tr>
					<td class="right">首页公司logo(PC站) :</td>
                    <td>
                    <a href="javscript:void(0);" class="thumbnail"><img width="80px;" id="scinter_home_logo_url" src="${scinter_home_logo}"></a>
                    <input type="hidden" id="scinter_home_logo" name="scinter_home_logo" value="${scinter_home_logo}"/>&nbsp;&nbsp;
					<span id="scinter_logo_upload">选择图片</span>
					<c:set var="theString" value="${sessionScope.Role.branchCompany }"/>
					<c:if test="${fn:endsWith(theString,'sc') }">
					    <span>[图片大小:400*110(px)]</span>  
					</c:if>
					<c:if test="${fn:endsWith(theString,'xz') }">
						<span>[图片大小:300*120(px)]</span>  
					</c:if>
					<c:if test="${fn:endsWith(theString,'rbw1') }">
						<span>[图片大小:454*85(px)]</span>  
					</c:if>
					<c:if test="${fn:endsWith(theString,'rbw2') }">
						<span>[图片大小:454*85(px)]</span>  
					</c:if>
					<c:if test="${fn:endsWith(theString,'rrl') }">
						<span>[图片大小:454*85(px)]</span>  
					</c:if>
                    </td>
				</tr>
				<tr>
					<td class="right">底部二维码(PC站)：</td>
					<td>
					<a href="javscript:void(0);" class="thumbnail"><img width="80px;" id="scinter_home_twoCodeImg_url" src="${scinter_home_twoCodeImg }"></a>
					<input type="hidden" id="scinter_home_twoCodeImg" name="scinter_home_twoCodeImg" value="${scinter_home_twoCodeImg }"/>&nbsp;&nbsp;
					<span id="scinter_home_twoCodeImg_upload">选择图片</span>
					<c:set var="theString" value="${curBranchCompany }"/>
					<c:if test="${fn:endsWith(theString,'sc') }">
						<span>[图片大小:101*103(px)]</span>
					</c:if>
					<c:if test="${fn:endsWith(theString,'xz') }">
						<span>[图片大小:103*104(px)]</span>
					</c:if>
					<c:if test="${fn:endsWith(theString,'rbw1') }">
						<span>[图片大小:96*96(px)]</span>
					</c:if>
					<c:if test="${fn:endsWith(theString,'rbw2') }">
						<span>[图片大小:96*96(px)]</span>
					</c:if>
					<c:if test="${fn:endsWith(theString,'rrl') }">
						<span>[图片大小:96*96(px)]</span>
					</c:if>
					</td>
				</tr>
				
				
				<tr>
					<td class="right">合作品牌(PC站)：</td>
					<td >
						<input type="hidden" id="Scinter_home_coworker" name="Scinter_home_coworker" value="${Scinter_home_coworker }"/>&nbsp;&nbsp;
						<span id="scinter_home_coworker_upload">选择图片</span>
						<c:set var="theString" value="${curBranchCompany }"/>
						<c:if test="${fn:endsWith(theString,'sc') }">
							<span>[图片大小:170*100(px)]</span>
						</c:if>
						<c:if test="${fn:endsWith(theString,'xz') }">
							<span>[图片大小:184*82(px)]</span>
						</c:if>
						<c:if test="${fn:endsWith(theString,'rbw1') }">
							<span>[图片大小:212*97(px)]</span>
						</c:if>
						<c:if test="${fn:endsWith(theString,'rbw2') }">
							<span>[图片大小:212*97(px)]</span>
						</c:if>
						<c:if test="${fn:endsWith(theString,'rrl') }">
							<span>[图片大小:212*97(px)]</span>
						</c:if>
					</td>
				</tr>
				<tr >	
					<td class="right">合作品牌展示(PC站)：</td>
					<td colspan="2" id="scinter_home_coworkerList">	
					<c:forEach items="${scinter_home_coworkerList }" var="coworkerList">
						<a target="_blank" id="image_${coworkerList.configId }" href="${coworkerList.value }">
							<img title="查看大图" src="${coworkerList.value }" style="margin-left:10px;width:80px;height:80px;cursor:pointer;" />
						</a>&nbsp;<img title="删除" id="delImage_${coworkerList.configId }" onclick="delImage('${coworkerList.configId }')" src="${pageContext.request.contextPath}/static/www/css/img/empty.png"/>
					</c:forEach>					
					
					</td>
					
				</tr>
				
				<%-- <tr>
				
					<td class="right">首页焦点轮播(PC站)：</td>
					<td>
						<input type="hidden" id="Scinter_home_turnImgs" name="Scinter_home_turnImgs" value="${Scinter_home_turnImgs }"/>&nbsp;&nbsp;
						<span id="scinter_home_turnImgs_upload">选择图片</span>
						<c:set var="theString" value="${curBranchCompany }"/>
						<c:if test="${fn:endsWith(theString,'sc') }">
							<span>[图片大小:1920*460(px)]</span>
						</c:if>
						<c:if test="${fn:endsWith(theString,'xz') }">
							<span>[图片大小:1920*430(px)]</span>
						</c:if>
						<c:if test="${fn:endsWith(theString,'rbw1') }">
							<span>[图片大小:1920*626(px)]</span>
						</c:if>
						<c:if test="${fn:endsWith(theString,'rbw2') }">
							<span>[图片大小:1920*626(px)]</span>
						</c:if>
						<c:if test="${fn:endsWith(theString,'rrl') }">
							<span>[图片大小:1920*626(px)]</span>
						</c:if>
					</td>
				</tr>
				
				<tr>	
					<td class="right">首页焦点轮播图片(PC站)：</td>
					<td colspan="2" id="scinter_home_turnImgsList">	
					<c:forEach items="${scinter_home_turnImgsList }" var="turnImg">
						<a target="_blank" id="image_${turnImg.configId }" href="${turnImg.value }">
							<img title="查看大图" src="${turnImg.value }" style="margin-left:10px;width:80px;height:80px;cursor:pointer;" />
						</a>&nbsp;<img title="删除" id="delImage_${turnImg.configId }" onclick="delImage('${turnImg.configId }')" src="${pageContext.request.contextPath}/static/www/css/img/empty.png"/>
					</c:forEach>					
					
					</td>
					
				</tr> --%>
				    <c:set var="theString" value="${curBranchCompany }"/>
				    <c:if test="${fn:endsWith(theString,'sc') }">
						<tr>
						
							<td class="right">首页装修风格(抽屉式效果)(PC站)：</td>
							<td>
								<input type="hidden" id="scinter_home_decorateImgs" name="scinter_home_decorateImgs" value="${scinter_home_decorateImgs }"/>&nbsp;&nbsp;
								<span id="scinter_home_decorateImgs_upload">选择图片</span>
								<span>[图片大小:632*334(px)]</span>
							</td>
						</tr>
						<tr>
							<td class="right">首页装修风格(抽屉式效果)展示(PC站)：</td>
							<td colspan="2" id="scinter_home_decorateImgsList">
							<c:forEach items="${scinter_home_decorateImgsList }" var="decorateImg">
								<a target="_blank" id="image_${decorateImg.configId }" href="${decorateImg.value }">
									<img title="查看大图" src="${decorateImg.value }" style="margin-left:10px;width:80px;height:80px;cursor:pointer;" />
								</a>&nbsp;<img title="删除" id="delImage_${decorateImg.configId }" onclick="delImage('${decorateImg.configId }')" src="${pageContext.request.contextPath}/static/www/css/img/empty.png"/>
							</c:forEach>	
							</td>
						</tr>
				    </c:if>
				    <c:if test="${fn:endsWith(theString,'w2') }">
						<tr>
						
							<td class="right">首页装修风格(抽屉式效果)(PC站)：</td>
							<td>
								<input type="hidden" id="scinter_home_decorateImgs" name="scinter_home_decorateImgs" value="${scinter_home_decorateImgs }"/>&nbsp;&nbsp;
								<span id="scinter_home_decorateImgs_upload">选择图片</span>
								<span>[图片大小:1040*494(px)]</span>
							</td>
						</tr>
						<tr>
							<td class="right">首页装修风格(抽屉式效果)展示(PC站)：</td>
							<td colspan="2" id="scinter_home_decorateImgsList">
							<c:forEach items="${scinter_home_decorateImgsList }" var="decorateImg">
								<a target="_blank" id="image_${decorateImg.configId }" href="${decorateImg.value }">
									<img title="查看大图" src="${decorateImg.value }" style="margin-left:10px;width:80px;height:80px;cursor:pointer;" />
								</a>&nbsp;<img title="删除" id="delImage_${decorateImg.configId }" onclick="delImage('${decorateImg.configId }')" src="${pageContext.request.contextPath}/static/www/css/img/empty.png"/>
							</c:forEach>	
							</td>
						</tr>
				    </c:if>
				    
				<tr class="ttl">
					<td colspan="2">首页配置(手机站)</td>
				</tr>
				<tr>
					<td class="right">联系电话(手机站)：</td>
					<td colspan="3"><input type="text" id="scinter_home_M_telePhone" name="scinter_home_M_telePhone" style="width:300px;"class="txt" value="${scinter_home_M_telePhone }" style="width:245px;"/></td>
				</tr>
				
				<!-- 后期根据需要自行添加 -->
				<%-- <tr>
					<td class="right">联系人员：</td>
					<td colspan="2"><input type="text" id="scinter_home_M_person" name="scinter_home_M_person" style="width:300px;"class="txt" value="${scinter_home_M_person }" style="width:245px;"/></td>
				</tr>
				<tr>
					<td class="right">邮箱地址：</td>
					<td colspan="2"><input type="text" id="scinter_home_M_postBox" name="scinter_home_M_postBox" style="width:300px;" class="txt" value="${scinter_home_M_postBox }" style="width:245px;"/></td>
				</tr>
				<tr>
                    <td class="right">公司地址：</td>
                    <td><textarea id="scinter_home_M_address" name="scinter_home_M_address" style="width:300px;height:60px;">${scinter_home_M_address}</textarea></td>
                </tr> --%>
                <tr>
					<td class="right">百度商桥(手机站):</td>
					<td colspan="3">
                		<textarea id="scinter_home_M_shangQiao" name="scinter_home_M_shangQiao" style="width: 50%;">${scinter_home_M_shangQiao}</textarea>
                	</td>	
				</tr>
				<tr>
					<td class="right">百度统计(手机站)：</td>
					<td colspan="3">
					
                		<textarea id="scinter_home_M_statistics" name="scinter_home_M_statistics" style="width: 50%;">${scinter_home_M_statistics}</textarea>
                	</td>	
				</tr>
                <tr>
					<td class="right">首页LOGO(手机站):</td>
					<td>
						<a href="javscript:void(0);" class="thumbnail">
							<img width="80px;" id="scinter_home_M_logoImg_url" src="${scinter_home_M_logoImg }">
						</a>
						<input type="hidden" id="scinter_home_M_logoImg" name="scinter_home_M_logoImg" value="${scinter_home_M_logoImg }"/>&nbsp;&nbsp;
						<span id="scinter_home_M_logoImg_upload">选择图片</span>
						<span>[图片大小:118*60(px)]</span>
					</td>
				</tr>
                <tr>
					<td class="right">二维码(手机站):</td>
					<td>
					<a href="javscript:void(0);" class="thumbnail"><img width="80px;" id="scinter_home_M_twoCodeImg_url" src="${scinter_home_M_twoCodeImg }"></a>
					<input type="hidden" id="scinter_home_M_twoCodeImg" name="scinter_home_M_twoCodeImg" value="${scinter_home_M_twoCodeImg }"/>&nbsp;&nbsp;
					<span id="scinter_home_M_twoCodeImg_upload">选择图片</span>
					<span>[图片大小:101*103(px)]</span>
					</td>
				</tr>
				<%-- <tr>
					<td class="right">首页焦点轮播(手机站)：</td>
					<td>
						<input type="hidden" id="Scinter_home_M_turnImgs" name="Scinter_home_M_turnImgs" value="${Scinter_home_M_turnImgs }"/>&nbsp;&nbsp;
						<span id="Scinter_home_M_turnImgs_upload">选择图片</span>
						<span>[图片大小:320*400(px)]</span>
					</td>
				</tr>
				
				<tr>	
					<td class="right">首页焦点轮播图片展示(手机站)：</td>
					<td colspan="2" id="Scinter_home_M_turnImgsList">	
					<c:forEach items="${Scinter_home_M_turnImgsList }" var="turnImg">
						<a target="_blank" id="image_${turnImg.configId }" href="${turnImg.value }">
							<img title="查看大图" src="${turnImg.value }" style="margin-left:10px;width:80px;height:80px;cursor:pointer;" />
						</a>&nbsp;<img title="删除" id="delImage_${turnImg.configId }" onclick="delImage('${turnImg.configId }')" src="${pageContext.request.contextPath}/static/www/css/img/empty.png"/>
					</c:forEach>					
					
					</td>
					
				</tr> --%>
				<tr class="ttl">
					<td colspan="2">
						SEO配置(应用于PC/MP首页)
					</td>
				</tr>
				<tr>
					<td class="right">SEO标题:</td>
					<td colspan="3">
                		<textarea id="scinter_home_seo_title" name="scinter_home_seo_title" style="width: 50%;">${scinter_home_seo_title}</textarea>
                	</td>	
				</tr>
				<tr>
					<td class="right">SEO关键字:</td>
					<td colspan="3">
                		<textarea id="scinter_home_seo_keyword" name="scinter_home_seo_keyword" style="width: 50%;">${scinter_home_seo_keyword}</textarea>
                	</td>	
				</tr>
				<tr>
					<td class="right">SEO描述:</td>
					<td colspan="3">
                		<textarea id="scinter_home_seo_desc" name="scinter_home_seo_desc" style="width: 50%;">${scinter_home_seo_desc}</textarea>
                	</td>	
				</tr>
				<tr class="ttl">
					<td colspan="2">
						SEO配置(应用于PC/MP装修套餐)
					</td>
				</tr>
				<tr>
					<td class="right">SEO标题:</td>
					<td colspan="3">
                		<textarea id="scinter_package_seo_title" name="scinter_package_seo_title" style="width: 50%;">${scinter_package_seo_title}</textarea>
                	</td>	
				</tr>
				<tr>
					<td class="right">SEO关键字:</td>
					<td colspan="3">
                		<textarea id="scinter_package_seo_keyword" name="scinter_package_seo_keyword" style="width: 50%;">${scinter_package_seo_keyword}</textarea>
                	</td>	
				</tr>
				<tr>
					<td class="right">SEO描述:</td>
					<td colspan="3">
                		<textarea id="scinter_package_seo_desc" name="scinter_package_seo_desc" style="width: 50%;">${scinter_package_seo_desc}</textarea>
                	</td>	
				</tr>
				<tr class="ttl">
					<td colspan="2">
						SEO配置(应用于PC/MP设计案例的列表页)
					</td>
				</tr>
				<tr>
					<td class="right">SEO标题:</td>
					<td colspan="3">
                		<textarea id="scinter_cases_seoTitle_str" name="scinter_cases_seoTitle_str" style="width: 50%;">${scinter_cases_seoTitle_str}</textarea>
                	</td>	
				</tr>
				<tr>
					<td class="right">SEO关键字:</td>
					<td colspan="3">
                		<textarea id="scinter_cases_seoKeyword_str" name="scinter_cases_seoKeyword_str" style="width: 50%;">${scinter_cases_seoKeyword_str}</textarea>
                	</td>	
				</tr>
				<tr>
					<td class="right">SEO描述:</td>
					<td colspan="3">
                		<textarea id="scinter_cases_seoDesc_str" name="scinter_cases_seoDesc_str" style="width: 50%;">${scinter_cases_seoDesc_str}</textarea>
                	</td>	
				</tr>
				<tr class="ttl">
					<td colspan="2">
						SEO配置(应用于PC/MP楼盘信息)
					</td>
				</tr>
				<tr>
					<td class="right">SEO标题:</td>
					<td colspan="3">
                		<textarea id="scinter_house_seo_title" name="scinter_house_seo_title" style="width: 50%;">${scinter_house_seo_title}</textarea>
                	</td>	
				</tr>
				<tr>
					<td class="right">SEO关键字:</td>
					<td colspan="3">
                		<textarea id="scinter_house_seo_keyword" name="scinter_house_seo_keyword" style="width: 50%;">${scinter_house_seo_keyword}</textarea>
                	</td>	
				</tr>
				<tr>
					<td class="right">SEO描述:</td>
					<td colspan="3">
                		<textarea id="scinter_house_seo_desc" name="scinter_house_seo_desc" style="width: 50%;">${scinter_house_seo_desc}</textarea>
                	</td>	
				</tr>
				<tr class="ttl">
					<td colspan="2">
						<c:set var="theString" value="${curBranchCompany }"/>
						<c:if test="${fn:endsWith(theString,'sc') }">
							SEO配置(应用于PC/MP热门活动的列表页)
						</c:if>
						<c:if test="${fn:endsWith(theString,'xz') }">
							SEO配置(应用于PC/MP新洲活动的列表页)
						</c:if>
						<c:if test="${fn:endsWith(theString,'rbw1') }">
							SEO配置(应用于PC/MP热门活动的列表页)
						</c:if>
						<c:if test="${fn:endsWith(theString,'rbw2') }">
							SEO配置(应用于PC/MP热门活动的列表页)
						</c:if>
						<c:if test="${fn:endsWith(theString,'rrl') }">
							SEO配置(应用于PC/MP热门活动的列表页)
						</c:if>
					</td>
				</tr>
				<tr>
					<td class="right">SEO标题:</td>
					<td colspan="3">
                		<textarea id="scinter_news_seoTitle_str" name="scinter_news_seoTitle_str" style="width: 50%;">${scinter_news_seoTitle_str}</textarea>
                	</td>	
				</tr>
				<tr>
					<td class="right">SEO关键字:</td>
					<td colspan="3">
                		<textarea id="scinter_news_seoKeyword_str" name="scinter_news_seoKeyword_str" style="width: 50%;">${scinter_news_seoKeyword_str}</textarea>
                	</td>	
				</tr>
				<tr>
					<td class="right">SEO描述:</td>
					<td colspan="3">
                		<textarea id="scinter_news_seoDesc_str" name="scinter_news_seoDesc_str" style="width: 50%;">${scinter_news_seoDesc_str}</textarea>
                	</td>	
				</tr>
				<tr class="ttl">
					<td colspan="2">
						SEO配置(应用于PC/MP设计团队的列表页)
					</td>
				</tr>
				<tr>
					<td class="right">SEO标题:</td>
					<td colspan="3">
                		<textarea id="scinter_designer_seoTitle_str" name="scinter_designer_seoTitle_str" style="width: 50%;">${scinter_designer_seoTitle_str}</textarea>
                	</td>	
				</tr>
				<tr>
					<td class="right">SEO关键字:</td>
					<td colspan="3">
                		<textarea id="scinter_designer_seoKeyword_str" name="scinter_designer_seoKeyword_str" style="width: 50%;">${scinter_designer_seoKeyword_str}</textarea>
                	</td>	
				</tr>
				<tr>
					<td class="right">SEO描述:</td>
					<td colspan="3">
                		<textarea id="scinter_designer_seoDesc_str" name="scinter_designer_seoDesc_str" style="width: 50%;">${scinter_designer_seoDesc_str}</textarea>
                	</td>	
				</tr>
				<tr class="ttl">
					<td colspan="2">
					<c:set var="theString" value="${curBranchCompany }"/>
						<c:if test="${fn:endsWith(theString,'sc') }">
							SEO配置(应用于PC/MP说装修的列表页)
						</c:if>
						<c:if test="${fn:endsWith(theString,'xz') }">
							SEO配置(应用于PC/MP装修新闻的列表页)
						</c:if>
						<c:if test="${fn:endsWith(theString,'rbw1') }">
							SEO配置(应用于PC/MP说装修的列表页)
						</c:if>
						<c:if test="${fn:endsWith(theString,'rbw2') }">
							SEO配置(应用于PC/MP说装修的列表页)
						</c:if>
						<c:if test="${fn:endsWith(theString,'rrl') }">
							SEO配置(应用于PC/MP说装修的列表页)
						</c:if>
					</td>
				</tr>
				<tr>
					<td class="right">SEO标题:</td>
					<td colspan="3">
                		<textarea id="scinter_spe_seoTitle_str" name="scinter_spe_seoTitle_str" style="width: 50%;">${scinter_spe_seoTitle_str}</textarea>
                	</td>	
				</tr>
				<tr>
					<td class="right">SEO关键字:</td>
					<td colspan="3">
                		<textarea id="scinter_spe_seoKeyword_str" name="scinter_spe_seoKeyword_str" style="width: 50%;">${scinter_spe_seoKeyword_str}</textarea>
                	</td>	
				</tr>
				<tr>
					<td class="right">SEO描述:</td>
					<td colspan="3">
                		<textarea id="scinter_spe_seoDesc_str" name="scinter_spe_seoDesc_str" style="width: 50%;">${scinter_spe_seoDesc_str}</textarea>
                	</td>	
				</tr>
				<c:set var="theString" value="${curBranchCompany }"/>
				<c:if test="${fn:endsWith(theString,'sc') }">
				<tr class="ttl">
					<td colspan="2">
						SEO配置(应用于PC/MP蓝钻工艺的列表页)
					</td>
				</tr>
				<tr>
					<td class="right">SEO标题:</td>
					<td colspan="3">
                		<textarea id="scinter_diamond_seoTitle_str" name="scinter_diamond_seoTitle_str" style="width: 50%;">${scinter_diamond_seoTitle_str}</textarea>
                	</td>	
				</tr>
				<tr>
					<td class="right">SEO关键字:</td>
					<td colspan="3">
                		<textarea id="scinter_diamond_seoKeyword_str" name="scinter_diamond_seoKeyword_str" style="width: 50%;">${scinter_diamond_seoKeyword_str}</textarea>
                	</td>	
				</tr>
				<tr>
					<td class="right">SEO描述:</td>
					<td colspan="3">
                		<textarea id="scinter_diamond_seoDesc_str" name="scinter_diamond_seoDesc_str" style="width: 50%;">${scinter_diamond_seoDesc_str}</textarea>
                	</td>	
				</tr>
				</c:if>
				
				<tr class="ttl">
					<td colspan="2">
						<c:set var="theString" value="${curBranchCompany }"/>
						<c:if test="${fn:endsWith(theString,'sc') }">
							SEO配置(应用PC/MP三创服务)
						</c:if>
						<c:if test="${fn:endsWith(theString,'xz') }">
							SEO配置(应用PC/MP新洲服务)
						</c:if>
						<c:if test="${fn:endsWith(theString,'rbw1') }">
							SEO配置(应用PC/MP瑞博文服务)
						</c:if>
						<c:if test="${fn:endsWith(theString,'rbw2') }">
							SEO配置(应用PC/MP瑞博文服务)
						</c:if>
						<c:if test="${fn:endsWith(theString,'rrl') }">
							SEO配置(应用PC/MP人人乐服务)
						</c:if>
					</td>
				</tr>
				<tr>
					<td class="right">SEO标题:</td>
					<td colspan="3">
                		<textarea id="service_seoTitle_str" name="service_seoTitle_str" style="width: 50%;">${service_seoTitle_str}</textarea>
                	</td>	
				</tr>
				<tr>
					<td class="right">SEO关键字:</td>
					<td colspan="3">
                		<textarea id="service_seoKeyword_str" name="service_seoKeyword_str" style="width: 50%;">${service_seoKeyword_str}</textarea>
                	</td>	
				</tr>
				<tr> 
					<td class="right">SEO描述:</td>
					<td colspan="3">
                		<textarea id="service_seoDesc_str" name="service_seoDesc_str" style="width: 50%;">${service_seoDesc_str}</textarea>
                	</td>	
				</tr>
				
				<tr class="ttl">
					<td colspan="2">
						<c:set var="theString" value="${curBranchCompany }"/>
						<c:if test="${fn:endsWith(theString,'sc') }">
							SEO配置(应用PC/MP关于三创)
						</c:if>
						<c:if test="${fn:endsWith(theString,'xz') }">
							SEO配置(应用PC/MP关于新洲)
						</c:if>
						<c:if test="${fn:endsWith(theString,'w1') }">
							SEO配置(应用PC/MP关于瑞博文)
						</c:if>
						<c:if test="${fn:endsWith(theString,'w2') }">
							SEO配置(应用PC/MP关于瑞博文)
						</c:if>
						<c:if test="${fn:endsWith(theString,'rl') }">
							SEO配置(应用PC/MP关于人人乐)
						</c:if>
					</td>
				</tr>
				<tr>
					<td class="right">SEO标题:</td>
					<td colspan="3">
                		<textarea id="scinter_about_seoTitle_str" name="scinter_about_seoTitle_str" style="width: 50%;">${scinter_about_seoTitle_str}</textarea>
                	</td>	
				</tr>
				<tr>
					<td class="right">SEO关键字:</td>
					<td colspan="3">
                		<textarea id="scinter_about_seoKeyword_str" name="scinter_about_seoKeyword_str" style="width: 50%;">${scinter_about_seoKeyword_str}</textarea>
                	</td>	
				</tr>
				<tr>
					<td class="right">SEO描述:</td>
					<td colspan="3">
                		<textarea id="scinter_about_seoDesc_str" name="scinter_about_seoDesc_str" style="width: 50%;">${scinter_about_seoDesc_str}</textarea>
                	</td>	
				</tr>
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

var curBranchCompany = '${curBranchCompany}';
	/* 为友情链接添加点击方法,实现前缀自动添加 http:// */
	/* $("#scinter_home_friendlyLink").on("click",function(){
		
		$("#scinter_home_friendlyLink").val("http://");
	}); */
	
	/* 图片删除方法 */
	function delImage(id){
	
			$.ajax({
				type : "POST",
				dataType : "json",
				async: false,
				url : "${pageContext.request.contextPath}/admin/delHomeConfig",
				data : "homeConfigId=" + id,
				success : function(data) {
					if (data.data == "ok") {
						$("#image_"+id).remove();
						$("#delImage_"+id).remove();
					}
				}
			});
			
		}
jQuery(function($){
   $("#js_layout").layout({fit:true});
   
   /*保存 */
	$("#js_save").click(function(){
		$('#sysOtherForm').form({
		    url:'${pageContext.request.contextPath}/admin/saveHomeConfig',
			onSubmit : function() {
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
   
   /*scinter_home_logo上传*/
	var uploader = WebUploader.create({
	
	    // 选完文件后，是否自动上传。
	    auto: true,
	
	    // swf文件路径
	    swf: '${pageContext.request.contextPath}/static/www/scripts/Uploader.swf',
	
	    // 文件接收服务端。
	    server: '${pageContext.request.contextPath}/admin/imgFileListUpload?imgType=3&curBranchCompany=${curBranchCompany}',
	    
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
		$("#scinter_home_logo").val(url);
	 	$("#scinter_home_logo_url").attr("src",url); 
	});
   
//	实现轮播图片的上传
	var uploader1 = WebUploader.create({
		
	    // 选完文件后，是否自动上传。
	    auto: true,
	
	    // swf文件路径
	    swf: '${pageContext.request.contextPath}/static/www/scripts/Uploader.swf',
	
	    // 文件接收服务端。
	    server: '${pageContext.request.contextPath}/admin/imgFileListUpload?imgType=4&curBranchCompany=${curBranchCompany}',
	    
	     fileNumLimit:30,
	    
	    // 选择文件的按钮
	    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
	    pick: {
	    	id:'#scinter_home_turnImgs_upload'
	    	//,multiple : false,
	    },
	    // 默认图片不压缩
	    compress:false,
	    // 只允许选择图片文件。
	    accept: {
            title: 'Images',
            extensions: 'gif,jpg,jpeg,bmp,png,GIF,JPG,JPEG,BMP,PNG',
            mimeTypes: 'image/*'
        },
	});

	// 文件上传成功，显示图片
	uploader1.on('uploadSuccess', function( file,response ) {
		  /* 操作成功刷新页面 */
		   //window.location.href = "${pageContext.request.contextPath}/admin/showHomeConfig";
		var url = response.url;
		var imgId = response.imageId;
		var zoomImgId = "zoom_img_"+Math.floor(Math.random()*100);
		$("#scinter_home_turnImgsList").append('<a title="查看大图" id="image_'+imgId+'" target="_blank" href="'+url+'"><img alt="缩略图" id="image_'+imgId+'" src="'+url+'" style="margin-left:10px;width:80px;height:80px;cursor:pointer;"/></a>');
		$("#scinter_home_turnImgsList").append('</a>&nbsp;<img title="删除" id="delImage_'+imgId+'" onclick="delImage('+imgId+')" src="${pageContext.request.contextPath}/static/www/css/img/empty.png"/>');
	});
	
//	实现首页装修风格图片(抽屉式效果)上传
	var uploader2 = WebUploader.create({
		
	    // 选完文件后，是否自动上传。
	    auto: true,
	
	    // swf文件路径
	    swf: '${pageContext.request.contextPath}/static/www/scripts/Uploader.swf',
	
	    // 文件接收服务端。
	    server: '${pageContext.request.contextPath}/admin/imgFileListUpload?imgType=5&curBranchCompany=${curBranchCompany}',
	    
	     fileNumLimit:30,
	    
	    // 选择文件的按钮
	    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
	    pick: {
	    	id:'#scinter_home_decorateImgs_upload'
	    	//,multiple : false,
	    },
	
	    // 只允许选择图片文件。
	    accept: {
            title: 'Images',
            extensions: 'gif,jpg,jpeg,bmp,png,GIF,JPG,JPEG,BMP,PNG',
            mimeTypes: 'image/*'
        },
	});
	
	// 文件上传成功，显示图片
	uploader2.on('uploadSuccess', function( file,response ) {
	    /* 操作成功刷新页面 */
		var url = response.url;
		var imgId = response.imageId;
		var zoomImgId = "zoom_img_"+Math.floor(Math.random()*100);
		$("#scinter_home_decorateImgsList").append('<a title="查看大图" id="image_'+imgId+'" target="_blank" href="'+url+'"><img alt="缩略图" id="image_'+imgId+'" src="'+url+'" style="margin-left:10px;width:80px;height:80px;cursor:pointer;"/></a>');
		$("#scinter_home_decorateImgsList").append('</a>&nbsp;<img title="删除" id="delImage_'+imgId+'" onclick="delImage('+imgId+')" src="${pageContext.request.contextPath}/static/www/css/img/empty.png"/>');
	});
	
//	实现首页二维码（PC站）上传
	var uploader3 = WebUploader.create({
		
	    // 选完文件后，是否自动上传。
	    auto: true,
	
	    // swf文件路径
	    swf: '${pageContext.request.contextPath}/static/www/scripts/Uploader.swf',
	
	    // 文件接收服务端。
	    server: '${pageContext.request.contextPath}/admin/imgFileListUpload?imgType=6&curBranchCompany=${curBranchCompany}',
	    
	     fileNumLimit:30,
	    
	    // 选择文件的按钮
	    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
	    pick: {
	    	id:'#scinter_home_twoCodeImg_upload'
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
	uploader3.on('uploadSuccess', function( file,response ) {
	    //增加多个文件显示及删除操作
		var url = response.url;
		$("#scinter_home_twoCodeImg").val(url);
		$("#scinter_home_twoCodeImg_url").attr("src",url); 
	});
//	实现合作品牌图片上传
	var uploader4 = WebUploader.create({
		
	    // 选完文件后，是否自动上传。
	    auto: true,
	
	    // swf文件路径
	    swf: '${pageContext.request.contextPath}/static/www/scripts/Uploader.swf',
	
	    // 文件接收服务端。
	    server: '${pageContext.request.contextPath}/admin/imgFileListUpload?imgType=7&curBranchCompany=${curBranchCompany}',
	    
	     fileNumLimit:30,
	    
	    // 选择文件的按钮
	    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
	    pick: {
	    	id:'#scinter_home_coworker_upload'
	    	//,multiple : false,
	    },
	
	    // 只允许选择图片文件。
	    accept: {
            title: 'Images',
            extensions: 'gif,jpg,jpeg,bmp,png,GIF,JPG,JPEG,BMP,PNG',
            mimeTypes: 'image/*'
        },
	});
	
	// 文件上传成功，显示图片
	uploader4.on('uploadSuccess', function( file,response ) {
	    /* 操作成功刷新页面 */
		var url = response.url;
		var imgId = response.imageId;
		var zoomImgId = "zoom_img_"+Math.floor(Math.random()*100);
		$("#scinter_home_coworkerList").append('<a title="查看大图" id="image_'+imgId+'" target="_blank" href="'+url+'"><img alt="缩略图" id="image_'+imgId+'" src="'+url+'" style="margin-left:10px;width:80px;height:80px;cursor:pointer;"/></a>');
		$("#scinter_home_coworkerList").append('</a>&nbsp;<img title="删除" id="delImage_'+imgId+'" onclick="delImage('+imgId+')" src="${pageContext.request.contextPath}/static/www/css/img/empty.png"/>');
	});
//	实现手机站焦点图片上传
	var uploader5 = WebUploader.create({
		
	    // 选完文件后，是否自动上传。
	    auto: true,
	
	    // swf文件路径
	    swf: '${pageContext.request.contextPath}/static/www/scripts/Uploader.swf',
	
	    // 文件接收服务端。
	    server: '${pageContext.request.contextPath}/admin/imgFileListUpload?imgType=8&curBranchCompany=${curBranchCompany}',
	    
	     fileNumLimit:30,
	    
	    // 选择文件的按钮
	    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
	    pick: {
	    	id:'#Scinter_home_M_turnImgs_upload'
	    	//,multiple : false,
	    },
	
	    // 只允许选择图片文件。
	    accept: {
            title: 'Images',
            extensions: 'gif,jpg,jpeg,bmp,png,GIF,JPG,JPEG,BMP,PNG',
            mimeTypes: 'image/*'
        },
	});
	
	// 文件上传成功，显示图片
	uploader5.on('uploadSuccess', function( file,response ) {
	    /* 操作成功刷新页面 */
		var url = response.url;
		var imgId = response.imageId;
		var zoomImgId = "zoom_img_"+Math.floor(Math.random()*100);
		$("#Scinter_home_M_turnImgsList").append('<a title="查看大图" id="image_'+imgId+'" target="_blank" href="'+url+'"><img alt="缩略图" id="image_'+imgId+'" src="'+url+'" style="margin-left:10px;width:80px;height:80px;cursor:pointer;"/></a>');
		$("#Scinter_home_M_turnImgsList").append('</a>&nbsp;<img title="删除" id="delImage_'+imgId+'" onclick="delImage('+imgId+')" src="${pageContext.request.contextPath}/static/www/css/img/empty.png"/>');
	});
	
//	实现手机站底部二维码图片上传
	var uploader6 = WebUploader.create({
		
	    // 选完文件后，是否自动上传。
	    auto: true,
	
	    // swf文件路径
	    swf: '${pageContext.request.contextPath}/static/www/scripts/Uploader.swf',
	
	    // 文件接收服务端。
	    server: '${pageContext.request.contextPath}/admin/imgFileListUpload?imgType=9&curBranchCompany=${curBranchCompany}',
	    
	     fileNumLimit:30,
	    
	    // 选择文件的按钮
	    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
	    pick: {
	    	id:'#scinter_home_M_twoCodeImg_upload'
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
	uploader6.on('uploadSuccess', function( file,response ) {
		  //增加多个文件显示及删除操作
		 var url = response.url;
		 $("#scinter_home_M_twoCodeImg").val(url);
	 	 $("#scinter_home_M_twoCodeImg_url").attr("src",url);  
	});
   
	
//	实现首页LOGO（手机站）图片上传
	var uploader7 = WebUploader.create({
		
	    // 选完文件后，是否自动上传。
	    auto: true,
	
	    // swf文件路径
	    swf: '${pageContext.request.contextPath}/static/www/scripts/Uploader.swf',
	
	    // 文件接收服务端。
	    server: '${pageContext.request.contextPath}/admin/imgFileListUpload?imgType=10&curBranchCompany=${curBranchCompany}',
	    
	     fileNumLimit:30,
	    
	    // 选择文件的按钮
	    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
	    pick: {
	    	id:'#scinter_home_M_logoImg_upload'
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
	uploader7.on('uploadSuccess', function( file,response ) {
		  //增加多个文件显示及删除操作
		 var url = response.url;
		 $("#scinter_home_M_logoImg").val(url);
	 	 $("#scinter_home_M_logoImg_url").attr("src",url);  
	});
});
</script>
</body>
</html>
