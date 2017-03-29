<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>装修案例</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/easyui.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/common.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/QA.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/webuploader.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/imgbox.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/zoomImg.css" type="text/css" />
</head>
<body>
<div class="wrapper details notblbew" id="js_layout">
    <div data-options="region:'center'" class="noborder">
        <div class="easyui-tabs" data-options="tools:'#tab-tools'" id="tabs">
            <div title="装修案例信息" data-options="" class="pad10 relative" id="tab1">
                <form id="caseForm" method="post">
                <input type="hidden" id="branchCompany" name="branchCompany"  />
                <input type="hidden" id="communityId" name="communityId" value="${caseInfo.communityId }"/>
                <input type="hidden" id="caseId" name="caseId" value="${caseInfo.caseId}"  />
                <input type="hidden" id="scinterCasesSeoTitleStr" name="scinterCasesSeoTitleStr" value="${caseInfo.scinterCasesSeoTitleStr}"  />
                <input type="hidden" id="scinterCasesSeoKeywordStr" name="scinterCasesSeoKeywordStr" value="${caseInfo.scinterCasesSeoKeywordStr}"  />
                <input type="hidden" id="scinterCasesSeoDescStr" name="scinterCasesSeoDescStr" value="${caseInfo.scinterCasesSeoDescStr}"  />
                <input type="hidden" id="seoTitle" name="seoTitle" value="${caseInfo.seoTitle}"  />
                <input type="hidden" id="seoKeyword" name="seoKeyword" value="${caseInfo.seoKeyword}"  />
                <input type="hidden" id="seoDesc" name="seoDesc" value="${caseInfo.seoDesc}"  />
                <table class="forms" style="table-layout:fixed;">
                    <tbody>
                    	<tr>
                            <td class="right" width="120"></td>
                            <td width="300"></td>
                            <td class="right" width="120"></td>
                            <td width="300"></td>
                        </tr>
                         <tr>
                        	<td class="right" width="10%"><i class="require">*</i>
                        	推荐案例：
                        	</td>
                    		<td>
                    			<label for="status3"><span style="color:#0f681a;font-weight: bold;">是</span><input type="radio" value="是" name="isHotCase" id="status3" style="vertical-align:middle"/></label>
                    			<label for="status4"><span style="color:red;font-weight: bold;">否</span><input type="radio" value="否" name="isHotCase" checked="checked" id="status4" style="vertical-align:middle"/></label>&nbsp;&nbsp;
                    		</td>
                        </tr>
                    	<tr>
                    		<td class="right"><i class="require">*</i>案例名称：</td>
                    		<td>
                    			<input class="txt" id="caseTitle" name="caseTitle" type="text" value="${caseInfo.caseTitle}" />
                    		</td>
                    		<td class="right" width="10%"><i class="require">*</i>小区名称：</td>
                    		<c:choose>
                    	
                    		<c:when test="${sessionScope.Role.roleName=='超级管理员' }">
                    		     <c:if test="${sessionScope.controlledCompany=='rbwzs2' }">
	                    				<td>
	                    		   	 	<input type="hidden" id="caseCommunity" name="caseCommunity" />   
		                    				<select name="selCommunityId" id="selCommunityId" class="easyui-combobox" 
		                    				data-options="panelHeight:'200',editable : false,
		                    				valueField: 'communityId',      
		                     				textField: 'communityName',
					                    	url:'${pageContext.request.contextPath}/admin/getAllCommunitys',
					                    	onLoadSuccess:function(data){
					                    		var caseCommunity = '${caseInfo.caseCommunity }';
					                    		var communityId = '${caseInfo.communityId }';
					                    		if(caseCommunity!=''){
					                   				$('#selCommunityId').combobox('setText',caseCommunity);
					                   				$('#selCommunityId').combobox('setValue',communityId);
					                   			}
					                    	}"
		                    				 style="width:247px;">
		                    				 	<option value="===请选择===">===请选择===</option>
		                    				</select> 
	                    				</c:if>
                    				
                    				<c:if test="${fn:contains(sessionScope.controlledCompany,'xzzs')}">
                    				<td><input class="txt" id="caseCommunity" name="caseCommunity" type="text" value="${caseInfo.caseCommunity}" /></td>
                    				</c:if>
                    				<c:if test="${fn:contains(sessionScope.controlledCompany,'sczs')}">
                    				<td><input class="txt" id="caseCommunity" name="caseCommunity" type="text" value="${caseInfo.caseCommunity}" /></td>
                    				</c:if>
                    				<c:if test="${fn:contains(sessionScope.controlledCompany,'rbwzs1')}">
                    				<td><input class="txt" id="caseCommunity" name="caseCommunity" type="text" value="${caseInfo.caseCommunity}" /></td>
                    				</c:if>
                    				<c:if test="${fn:contains(sessionScope.controlledCompany,'rrlzs')}">
                    				<td><input class="txt" id="caseCommunity" name="caseCommunity" type="text" value="${caseInfo.caseCommunity}" /></td>
                    				</c:if>
                    		</c:when>
                    				<c:otherwise>
	                    				
	                    				<c:if test="${sessionScope.controlledCompany=='rbwzs2' }">
	                    				<td>
	                    		   	 	<input type="hidden" id="caseCommunity" name="caseCommunity" />   
		                    				<select name="selCommunityId" id="selCommunityId" class="easyui-combobox" 
		                    				data-options="panelHeight:'200',editable : false,
		                    				valueField: 'communityId',      
		                     				textField: 'communityName',
					                    	url:'${pageContext.request.contextPath}/admin/getAllCommunitys',
					                    	onLoadSuccess:function(data){
					                    		var caseCommunity = '${caseInfo.caseCommunity }';
					                    		if(caseCommunity!=''){
					                   				$('#selCommunityId').combobox('setText',caseCommunity);
					                   			}
					                    	}"
		                    				 style="width:247px;">
		                    				 	<option value="===请选择===">===请选择===</option>
		                    				</select> 
	                    				</c:if>
	                    				<c:if test="${fn:contains(sessionScope.controlledCompany,'xzzs')}">
	                    				<c:choose>
	                    				
	                    					<c:when test="${fn:contains(sessionScope.Role.branchCompany,'bjxz')}">
	                    						<td><input class="txt" id="caseCommunity" name="caseCommunity" type="text" value="${caseInfo.caseCommunity}" /></td>
	                    					</c:when>
	                    					<c:otherwise>
												<td>
			                    		   	 	<input type="hidden" id="caseCommunity" name="caseCommunity" />   
			                    				<select name="selCommunityId" id="selCommunityId" class="easyui-combobox" 
			                    				data-options="panelHeight:'200',editable : false,
			                    				valueField: 'communityId',      
			                     				textField: 'communityName',
						                    	url:'${pageContext.request.contextPath}/admin/getAllCommunitys',
						                    	onLoadSuccess:function(data){
						                    		var caseCommunity = '${caseInfo.caseCommunity }';
						                    		if(caseCommunity!=''){
						                   				$('#selCommunityId').combobox('setText',caseCommunity);
						                   			}
						                    	}"
			                    				 style="width:247px;">
			                    				 	<option value="===请选择===">===请选择===</option>
			                    				</select>                    					
	                    					</c:otherwise>
	                    				</c:choose>
	                    				
	                    				</c:if>
	                    				<c:if test="${fn:contains(sessionScope.controlledCompany,'sczs')}">
	                    				<td><input class="txt" id="caseCommunity" name="caseCommunity" type="text" value="${caseInfo.caseCommunity}" /></td>
	                    				</c:if>
	                    				<c:if test="${fn:contains(sessionScope.controlledCompany,'rbwzs1')}">
	                    				<td><input class="txt" id="caseCommunity" name="caseCommunity" type="text" value="${caseInfo.caseCommunity}" /></td>
	                    				</c:if>
	                    				<c:if test="${fn:contains(sessionScope.controlledCompany,'rrlzs')}">
	                    				<td><input class="txt" id="caseCommunity" name="caseCommunity" type="text" value="${caseInfo.caseCommunity}" /></td>
	                    				</c:if>
                    				</c:otherwise>
                    		</c:choose>
                    		
                    		
                    	</tr>
                    	
                    	<tr>
                    		<td class="right" width="10%"><i class="require">*</i>房屋面积/平方米：</td>
                    		<td>
                    			<input class="txt" id="caseAcreage" name="caseAcreage" type="number" value="${caseInfo.caseAcreage}" />
                    		</td>
                    		<td class="right" width="10%">行政区域：</td>
                    		<td>
                    			<div id="city"> 
								    <select id="sheng_1" class="prov" style="width:70px;"></select>
								    <select id="shi_2" class="city" disabled="disabled" style="width:85px;"></select>
								    <select id="qu_3" class="dist" disabled="disabled" style="width:85px;"></select> 
								</div>
                    			<input class="txt" id="caseArea" name="caseArea" type="hidden" value="${caseInfo.caseArea}" />
                    		</td>
                    	</tr>
                    	
                    	<tr>
                    		<td class="right" width="10%"><i class="require">*</i>设计师：</td>
                    		<td>
                    		    <input type="hidden" id="caseDesigner" name="caseDesigner" value="${caseInfo.caseDesigner }"/>   
                    			<select name="designerId" id="designerId" class="easyui-combobox" 
                    			data-options="panelHeight:'200',editable : false,
                    			valueField: 'designerId',      
                     			textField: 'designerName',
			                    url:'${pageContext.request.contextPath}/admin/listAllDesigner',
			                    onLoadSuccess:function(data){
			                    	var designerId = '${caseInfo.designerId }';
			                    	if(designerId!=''){
			                   			$('#designerId').combobox('setValue',designerId);
			                   		}
			                    }"
                    			 style="width:247px;">
                    			 	<option>===请选择===</option>
                    			</select>
                    		</td>
                    		<td class="right" width="10%"><i class="require">*</i>装修费用/万元：</td>
                    		<td><input class="txt" id="caseMoney" name="caseMoney" type="number" value="${caseInfo.caseMoney}" /></td>
                    	</tr>
                    	
                    	<tr>
                    		<td class="right"><i class="require">*</i>案例户型：</td>
                    		<td>
                    		 	<select name="caseHouseType" id="caseHouseType" class="easyui-combobox" 
                    			data-options="panelHeight:'auto',editable : false,
                    			valueField: 'id',      
                     			textField: 'text',
			                    url:'${pageContext.request.contextPath}/static/www/json/case_house_type.json',
			                    onLoadSuccess:function(data){
			                    	var houseType = '${caseInfo.caseHouseType }';
			                    	if(houseType!=''){
			                   			$('#caseHouseType').combobox('setValue',houseType);
			                   		}
			                    }"
                    			 style="width:247px;">
                    			 	<option>===请选择===</option>
                    			</select>
                    		 	
                    		</td>
                    		<td class="right"><i class="require">*</i>设计风格：</td>
                    		<td>
                    			<select name="caseStyle" id="caseStyle" class="easyui-combobox" 
                    			data-options="panelHeight:'auto',editable : false,height:'50px',
                    			valueField: 'id',
                     			textField: 'text',
                     			url:'${pageContext.request.contextPath}/static/www/json/case_style.json',
                     			onLoadSuccess:function(data){
			                    	var caseStyle = '${caseInfo.caseStyle}';
			                    	if(caseStyle!=''){
			                   			$('#caseStyle').combobox('setValue',caseStyle);
			                   		}
			                    }" style="width:247px;">
                    			 	<option>===请选择===</option>
                    			</select>
                    		</td>
                    	</tr>
                    	<tr>
                    	
	                    	<td class="right" width="10%"><i class="require">*</i>浏览量（次）：</td>
	                    	<td><input class="txt" id="caseReadNum" name="caseReadNum" type="number" value="${caseInfo.caseReadNum}" /></td>
                    	</tr>
                    	<c:choose>
                    	
                    		<c:when test="${sessionScope.Role.roleName=='超级管理员' }">
                    		<c:if test="${sessionScope.controlledCompany=='sczs' }">
	                    	<tr>
	                    		<td class="right" width="10%"><i class="require">*</i>隶属分公司：</td>
	                    		<td colspan="3">
	                    			<select name="company" id="company" class="easyui-combobox" 
	                    			data-options="panelHeight:'200',editable : false,
	                    			valueField: 'id',
	                     			textField: 'text',
	                     			groupField:'group',
	                     			url:'${pageContext.request.contextPath}/static/www/json/scinter/scinter_company.json',
	                     			onLoadSuccess:function(data){
				                    	var status = '${caseInfo.branchCompany }';
				                    	if(status!=''){
				                   			$('#company').combobox('setValue',status);
				                   		}
				                    }" style="width:247px;">
	                    			 	<option>===请选择===</option>
	                    			</select>
	                    		</td>
	                    	</tr>
	                    	</c:if>
	                    	<c:if test="${sessionScope.controlledCompany=='xzzs' }">
	                    	<tr>
	                    		<td class="right" width="10%"><i class="require">*</i>隶属分公司：</td>
	                    		<td colspan="3">
	                    			<select name="company" id="company" class="easyui-combobox" 
	                    			data-options="panelHeight:'200',editable : false,
	                    			valueField: 'id',
	                     			textField: 'text',
	                     			groupField:'group',
	                     			url:'${pageContext.request.contextPath}/static/www/json/xzzs/xz_company.json',
	                     			onLoadSuccess:function(data){
				                    	var status = '${caseInfo.branchCompany }';
				                    	if(status!=''){
				                   			$('#company').combobox('setValue',status);
				                   		}
				                    }" style="width:247px;">
	                    			 	<option>===请选择===</option>
	                    			</select>
	                    		</td>
	                    	</tr>
	                    	</c:if>
	                    	<c:if test="${sessionScope.controlledCompany=='rbwzs1' }">
	                    	<tr>
	                    		<td class="right" width="10%"><i class="require">*</i>隶属分公司：</td>
	                    		<td colspan="3">
	                    			<select name="company" id="company" class="easyui-combobox" 
	                    			data-options="panelHeight:'200',editable : false,
	                    			valueField: 'id',
	                     			textField: 'text',
	                     			groupField:'group',
	                     			url:'${pageContext.request.contextPath}/static/www/json/rbwzs1/rbw_company.json',
	                     			onLoadSuccess:function(data){
				                    	var status = '${caseInfo.branchCompany }';
				                    	if(status!=''){
				                   			$('#company').combobox('setValue',status);
				                   		}
				                    }" style="width:247px;">
	                    			 	<option>===请选择===</option>
	                    			</select>
	                    		</td>
	                    	</tr>
	                    	</c:if>
	                    	<c:if test="${sessionScope.controlledCompany=='rbwzs2' }">
	                    	<tr>
	                    		<td class="right" width="10%"><i class="require">*</i>隶属分公司：</td>
	                    		<td colspan="3">
	                    			<select name="company" id="company" class="easyui-combobox" 
	                    			data-options="panelHeight:'200',editable : false,
	                    			valueField: 'id',
	                     			textField: 'text',
	                     			groupField:'group',
	                     			url:'${pageContext.request.contextPath}/static/www/json/rbwzs2/rbw_company.json',
	                     			onLoadSuccess:function(data){
				                    	var status = '${caseInfo.branchCompany }';
				                    	if(status!=''){
				                   			$('#company').combobox('setValue',status);
				                   		}
				                    }" style="width:247px;">
	                    			 	<option>===请选择===</option>
	                    			</select>
	                    		</td>
	                    	</tr>
	                    	</c:if>
	                    	<c:if test="${sessionScope.controlledCompany=='rrlzs' }">
	                    	<tr>
	                    		<td class="right" width="10%"><i class="require">*</i>隶属分公司：</td>
	                    		<td colspan="3">
	                    			<select name="company" id="company" class="easyui-combobox" 
	                    			data-options="panelHeight:'200',editable : false,
	                    			valueField: 'id',
	                     			textField: 'text',
	                     			groupField:'group',
	                     			url:'${pageContext.request.contextPath}/static/www/json/rrlzs/rrl_company.json',
	                     			onLoadSuccess:function(data){
				                    	var status = '${caseInfo.branchCompany }';
				                    	if(status!=''){
				                   			$('#company').combobox('setValue',status);
				                   		}
				                    }" style="width:247px;">
	                    			 	<option>===请选择===</option>
	                    			</select>
	                    		</td>
	                    	</tr>
	                    	</c:if>
                    		</c:when>
                    	</c:choose>
                    	
                    	<tr>
                    		<td class="right" width="10%"><i class="require">*</i>案例描述：</td>
                    		<td colspan="3">
                    			<textarea id="caseDesc" name="caseDesc" style="width:800px;height:135px;">${caseInfo.caseDesc }</textarea>
                    		</td>
                    	</tr>
                    	
                    	<tr>
                    		<td class="right" width="10%"><i class="require">*</i>
                    		<c:set var="theString" value="${sessionScope.Role.branchCompany }"/>
							<c:if test="${fn:endsWith(theString,'sc') }">
								案例缩略图[545x415]px：
							</c:if>
							<c:if test="${fn:endsWith(theString,'xz') }">
								案例缩略图[380x315]px：
							</c:if>
							<c:if test="${fn:endsWith(theString,'rbw1') }">
								案例缩略图[420x320]px：
							</c:if>
							<c:if test="${fn:endsWith(theString,'rbw2') }">
								案例缩略图[590x410]px：
							</c:if>
                    		<c:if test="${fn:endsWith(theString,'rrl') }">
								案例缩略图[420x320]px：
							</c:if>
                    		</td>
                    		<td colspan="3">
                    			
                    			<input type="hidden" id="caseThumbImg" name="caseThumbImg" value="${caseInfo.caseThumbImg }" />
                    			<table>
                    				<tr>
                    					<td>
                    						<div id="uploader-demo1">
											    <!--用来存放item-->
											    <div id="fileList1" class="uploader-list"></div>
											    <div id="filePicker1">选择图片</div>
											</div>
                    					</td>
                    					<td>
                    						<span id="upload_img_span1" style="display:inline;">
                    						<c:if test='${not empty caseInfo.caseThumbImg }'>
                    							<a target="_blank" class="zoom_img2" href="${caseInfo.caseThumbImg }">
													<img id="big_img2" title="查看大图" src="${caseInfo.caseThumbImg }" style="margin-left:10px;width:80px;height:80px;cursor:pointer;" />
												</a>
											</c:if>
                    						</span>
                    					</td>
                    				</tr>
                    			</table>
                    			
                    		</td>
                    	</tr>
                    	
                    	<tr>
                    		<td class="right" width="10%"><i class="require">*</i>
	                    		<c:set var="theString" value="${sessionScope.Role.branchCompany }"/>
								<c:if test="${fn:endsWith(theString,'sc') }">
									案例图片[812x540]px：
								</c:if>
								<c:if test="${fn:endsWith(theString,'xz') }">
									案例图片[880x556]px：
								</c:if>
								<c:if test="${fn:endsWith(theString,'rbw1') }">
									案例图片[880x500]px：
								</c:if>
								<c:if test="${fn:endsWith(theString,'rbw2') }">
									案例图片[880x500]px：
								</c:if>
								<c:if test="${fn:endsWith(theString,'rrl') }">
									案例图片[880x500]px：
								</c:if>
                    		</td>
                    		<td colspan="3">
                    			<table>
                    				<tr>
                    					<td>
                    						<!-- 
                    						<div class="uploadFile lf relative"><input type="file" class="fileTxt"/></div><span class="relative lf promptImg"></span>
                    						 -->
                    						 <div id="uploader-demo">
											    <!--用来存放item-->
											    <div id="fileList" class="uploader-list">
											    </div>
											    <div id="filePicker">选择图片</div>
											</div>
                    					</td>
                   						<td>
											<span id="upload_img_span" style="display:inline;">
												<input type="hidden" name="caseImageIdArr" id="caseImageIdArr" value="" />
												<c:forEach items="${caseImgShowList }" var="caseImage">
													<a target="_blank" id="caseImage_${caseImage.imageId }" href="${caseImage.imageUrl }">
														<img title="查看大图" src="${caseImage.imageUrl }" style="margin-left:10px;width:80px;height:80px;cursor:pointer;" />
													</a>&nbsp;<img title="删除" id="delCaseImage_${caseImage.imageId }" onclick="delCaseImage('${caseImage.imageId }')" src="${pageContext.request.contextPath}/static/www/css/img/empty.png"/>
												</c:forEach>
											</span>
                    					</td>
                    				</tr>
                    			</table>
                    		</td>
                    		
                    	</tr>
                    		
                    </tbody>
                </table>
                </form>
				<div class="blank10"></div>
            </div>
            
            <c:if test="${not empty caseInfo.caseId }">
            <div title="案例图片展示" data-options="" class="pad10 relative" id="tab2">
				
				<c:forEach items="${caseImgShowList}" var="cm" varStatus="status" >
					<a target="_blank" title="查看大图" href="${fn:substring(cm.imageUrl, 0, 27)}_logo${fn:substring(cm.imageUrl, 27, 31)}"><img src="${fn:substring(cm.imageUrl, 0, 27)}_logo${fn:substring(cm.imageUrl, 27, 31)}" style="width:160px;height:160px;" /></a>
					<c:if test="${(status.index+1) % 6 == 0}" > 
						<br/>
		            </c:if>
				</c:forEach>
				
			</div>
			</c:if>
			
			<div title="SEO信息" data-options="" class="pad10 relative" id="tab3">
            	<table class="forms" style="table-layout:fixed;">
                    <tbody>
                    	<tr>
                            <td class="right" width="120"></td>
                            <td width="300"></td>
                            <td class="right" width="120"></td>
                            <td width="300"></td>
                        </tr>
                    	<tr>
                    		<td class="right"><i class="require">*</i>SEO标题：</td>
                    		<td>
                    			<input class="txt" id="seoTitle_str" style="width:503px;" type="text" value="${caseInfo.seoTitle}" />
                    		</td>
                    	</tr>
                    	<tr>
                    		<td class="right"><i class="require">*</i>SEO关键字：</td>
                    		<td>
                    			<textarea id="seoKeyword_str" style="width:500px;height:80px;">${caseInfo.seoKeyword }</textarea>
                    		</td>
                    	</tr>
                    	<tr>
                    		<td class="right"><i class="require">*</i>SEO描述：</td>
                    		<td>
                    			<textarea id="seoDesc_str" style="width:500px;height:80px;">${caseInfo.seoDesc }</textarea>
                    		</td>
                    	</tr>
                    </tbody>
                </table>
                <div class="blank10"></div>
            </div>
            
        </div>
        <div id="tab-tools" class="">
            <a href="javascript:void(0)" class="ico pop" title="弹出" id="winMax">&nbsp;</a>
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
<script src="${pageContext.request.contextPath}/static/www/scripts/jquery.cityselect.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/webuploader.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/jquery.imagebox.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" charset="utf-8">

//选择推荐状态
var status = '${caseInfo.isHotCase}';
if(status=="是"){		
	$("#status3").attr("checked","checked");
}
if(status=="否"){
	$("#status4").attr("checked","checked");
}

//delCaseImage
function delCaseImage(caseImageId){
	$.ajax({
		type : "POST",
		dataType : "json",
		async: false,
		url : "${pageContext.request.contextPath}/admin/delCaseImage",
		data : "caseImageId=" + caseImageId,
		success : function(data) {
			if (data.data == "ok") {
				$("#caseImage_"+caseImageId).remove();
				$("#delCaseImage_"+caseImageId).remove();
			}
		}
	});
	
}

//关闭提醒消息
function closebox(){
	$(".thickdiv,.thickbox").hide();
}
$(".thickclose").bind("click",function(){
	$(".thickdiv,.thickbox").hide();
});

jQuery(function($){
	//省市联动初始化
	var caseArea = $("#caseArea").val();
	if(caseArea.length>0){
		var caseAreaArr = caseArea.split(",");
		$("#city").citySelect({
		    url:"${pageContext.request.contextPath}/static/www/scripts/city.min.json",
		    prov:caseAreaArr[0], //省份  
		    city:caseAreaArr[1], //城市  
		    dist:caseAreaArr[2], //区县  
		    nodata:"none" //当子集无数据时，隐藏select  
		});
	}else{
		$("#city").citySelect({prov:"北京",nodata:"none"});
	}
	
	//案例图片上传 初始化Web Uploader
	var uploader = WebUploader.create({
	
	    // 选完文件后，是否自动上传。
	    auto: true,
	
	    // swf文件路径
	    swf: '${pageContext.request.contextPath}/static/www/scripts/Uploader.swf',
	
	    // 文件接收服务端。
	    server: '${pageContext.request.contextPath}/admin/caseImgFileListUpload?caseId='+'${caseInfo.caseId}',
	    
	     fileNumLimit:30,
	    
	    // 选择文件的按钮
	    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
	    pick: {
	    	id:'#filePicker'
	    	//multiple : false,
	    },
	    // 是否同意裁剪。
	    crop: false,
	    
	    // 只允许选择图片文件。
	    accept: {
            title: 'Images',
            extensions: 'gif,jpg,jpeg,bmp,png,GIF,JPG,JPEG,BMP,PNG',
            mimeTypes: 'image/*'
        },
	});
	
	// 文件上传成功，显示图片。
	var imageIdArr = $("#caseImageIdArr").val();
	uploader.on('uploadSuccess', function( file,response ) {
	    //增加多个文件显示及删除操作
		var url = response.url;
		var imgId = response.imageId;
		imageIdArr = imageIdArr +","+ imgId;
		$("#caseImageIdArr").val(imageIdArr);
	    var zoomImgId = "zoom_img_"+Math.floor(Math.random()*100);
	    $("#upload_img_span").append('<a title="查看大图" id="'+zoomImgId+'" target="_blank" href="'+url+'"><img alt="缩略图" id="caseImage_'+imgId+'" src="'+url+'" style="margin-left:10px;width:80px;height:80px;cursor:pointer;"/></a>');
	    $("#upload_img_span").append('&nbsp;<img title="删除" id="delCaseImage_'+imgId+'" onclick="delCaseImage('+imgId+')" src="${pageContext.request.contextPath}/static/www/css/img/empty.png"/>');
	});
	
	//案例缩略图上传
	// 初始化Web Uploader
	var uploader1 = WebUploader.create({
	
	    // 选完文件后，是否自动上传。
	    auto: true,
	
	    // swf文件路径
	    swf: '${pageContext.request.contextPath}/static/www/scripts/Uploader.swf',
	
	    // 文件接收服务端。
	    server: '${pageContext.request.contextPath}/admin/caseThumbImgFileUpload?caseId='+'${caseInfo.caseId}',
	    
	    fileNumLimit:30,
	    
	    // 选择文件的按钮
	    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
	    pick: {
	    	id:'#filePicker1'
	    	,multiple : false,//不允许多选
	    },
	
	    // 只允许选择图片文件。
	    accept: {
            title: 'Images',
            extensions: 'gif,jpg,jpeg,bmp,png,GIF,JPG,JPEG,BMP,PNG',
            mimeTypes: 'image/*'
        },
	});
	
	// 文件上传成功，显示缩略图图片。
	uploader1.on('uploadSuccess', function( file,response ) {
		var url = response.data;
		$("#caseThumbImg").val(url);
		$(".zoom_img2").remove();
		 var zoomImgId = "zoom_img_"+Math.floor(Math.random()*100);
	    $("#upload_img_span1").append('<a title="查看大图" id="'+zoomImgId+'" target="_blank" href="'+url+'"><img alt="缩略图" src="'+url+'" style="margin-left:10px;width:80px;height:80px;cursor:pointer;"/></a>');
	});
	
    /*弹出按钮*/
    if(window.top==window.self){
        $("#winMax").hide();
    }else{
        $("#winMax").winOpen({url:location.href,event:"click",width:800,height:600,beforeOpen:function(){
            parent.hideSouth();
            return true;
        }});
    }
    
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
	
	/*layout*/
    $("#js_layout").layout({fit:true});
	
    /*保存 */
	$("#js_save").click(function(){
		$('#caseForm').form({
		    url:'${pageContext.request.contextPath}/admin/saveCase',
			onSubmit : function() {
				//行政区域赋值
				var caseAreaStr = $("#sheng_1").val()+","+$("#shi_2").val()+","+$("#qu_3").val();
				$("#caseArea").val(caseAreaStr);
				//隐藏表单赋值
				
				var seoTitle = $("#seoTitle_str").val();
				var seoKeyword = $("#seoKeyword_str").val();
				var seoDesc = $("#seoDesc_str").val();
				$("#scinterCasesSeoTitleStr").val(scinterCasesSeoTitleStr);
				$("#scinterCasesSeoKeywordStr").val(scinterCasesSeoKeywordStr);
				$("#scinterCasesSeoDescStr").val(scinterCasesSeoDescStr);
				$("#seoTitle").val(seoTitle);
				$("#seoKeyword").val(seoKeyword);
				$("#seoDesc").val(seoDesc);		
				$("#caseDesigner").val($("#designerId").combobox("getText"));
				
				var branchCompany = '${sessionScope.Role.branchCompany}';
				var role = '${sessionScope.Role.roleName}';
				
				if(role=="超级管理员"){
					
					$("#branchCompany").val($("#company").combobox("getValue"));
				}else{
				
					$("#branchCompany").val(branchCompany);
				}
				
				var controlledCompany =  '${sessionScope.controlledCompany}';
				
				if(controlledCompany == "rbwzs2"){
					
					var caseCommunity = $("#selCommunityId").combobox("getText");
					if(caseCommunity == "===请选择==="){
						$.messager.alert("操作提示", "对不起，请选择小区！","info");
						$("#caseCommunity").focus();
						return false;
				     }
					var communiId = '${caseInfo.communityId }';
					console.info("caseCommunity :"+$("#selCommunityId").combobox("getText"));
					console.info("communityId :"+communiId);
					$("#caseCommunity").val($("#selCommunityId").combobox("getText"));
					if(communiId != "")
					    $("#communityId").val(communiId);
					else
						$("#communityId").val($("#selCommunityId").combobox("getValue"));
					
				}else{
					$("#communityId").val(0);
				}
				//表单验证
				var caseName = $("#caseTitle").val();
				if(caseName==""){
					$.messager.alert("操作提示", "案例名称不能为空！","info");
					$("#caseTitle").focus();
					return false;
				}
				
				var designerVal = $("#designerId").combobox("getValue");
				if(designerVal=="" || designerVal == "===请选择==="){
					$.messager.alert("操作提示", "请选择案例对应的设计师！","info");
					return false;
				}
				
				var caseThumbImg = $("#caseThumbImg").val();
				if(caseThumbImg==""){
					$.messager.alert("操作提示", "请先上传案例缩略图！","info");
					return false;
				}
			},
			success : function(data) {
		
				var str=jQuery.parseJSON(data);
				if(str.data=='ok'){
					//刷新父窗口表格
					$.messager.alert("操作提示", "保存成功！","info");
					var row = parent.$("#grid_recheck").datagrid('getSelected');
				  	var rowIndex = parent.$("#grid_recheck").datagrid('getRowIndex', row);
				  	parent.rowIndex = rowIndex;
					parent.$("#grid_recheck").datagrid('reload');
				  	
				}else{
					$.messager.alert("操作提示", "操作失败！","info");
				} 
			}
		});
		//提交表单
		$('#caseForm').submit();
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
