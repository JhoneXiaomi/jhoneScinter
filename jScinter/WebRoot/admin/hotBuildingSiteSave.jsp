<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>在建工地</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/easyui.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/common.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/QA.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/webuploader.css" type="text/css" >
</head>
<body>
<div class="wrapper details notblbew" id="js_layout">
    <div data-options="region:'center'" class="noborder" style="overflow:hidden;">
        <div class="easyui-tabs" data-options="tools:'#tab-tools'" id="tabs"> 
            <div title="工地信息" data-options="" class="pad10 relative" id="tab1">
                <form id="grid_hotBuildingSite" method="post">
                
                <input type="hidden" name="id" name="id" value="${hotBuildingSiteInfo.id}"  />
       			
                <table class="forms" style="table-layout:fixed;">
                    <tbody>
                    	<tr>
                            <td class="right" width="120"></td>
                            <td width="300"></td>
                            <td class="right" width="120"></td>
                            <td width="300"></td>
                        </tr>
                    	<tr>
                    		<td class="right"><i class="require">*</i>工地名称：</td>
                    		<td>
                    			<input class="txt" id="siteName" name="siteName" type="text" value="${hotBuildingSiteInfo.siteName}"/>
                    		</td>
                    		
                    		<td class="right">施工阶段：</td>
                    		<td>
                    			<select name="siteStatus" id="siteStatus" class="easyui-combobox" 
                    			data-options="panelHeight:'auto',editable : false,
                    			valueField: 'id',
                     			textField: 'text',
                     			url:'${pageContext.request.contextPath}/static/www/json/site_status.json',
                     			onLoadSuccess:function(data){
			                    siteStatus = '${hotBuildingSiteInfo.siteStatus}';
			                    	if(siteStatus!=''){
			                   			$('#siteStatus').combobox('setValue',siteStatus);
			                   		}
			                    }" style="width:247px;">
                    			 	<option>===请选择===</option>
                    			</select>
                    		</td>
            
                    	</tr>
                    	
                    	<tr>
                    		<td class="right" width="10%"><i class="require">*</i>案例设计师：</td>
                    		<td>
                    			<select name="designerId" id="designerId" class="easyui-combobox" 
                    			data-options="panelHeight:'200',editable : false,
                    			valueField: 'designerId',
                     			textField: 'designerName',
                     			url:'${pageContext.request.contextPath}/admin/listAllDesigner',
                     			onLoadSuccess:function(data){
			                    	var designerName = '${hotBuildingSiteInfo.designerId}';
			                    	if(designerName!=''){
			                   			$('#designerId').combobox('setValue',designerName);
			                   		}
			                    }" style="width:247px;">
                    			 	<option value="===请选择===">===请选择===</option>
                    			</select>
                    		</td>
                    	
                    		<td class="right" width="10%"></td>
                    		<td>
                    		<c:if test='${sessionScope.Role.roleName!="超级管理员" }'>
                    			<!-- 用户隶属分公司信息 -->
                    			<input type="hidden" id="branchCompany" name="branchCompany" value="${empty hotBuildingSiteInfo.branchCompany ? sessionScope.Role.branchCompany : hotBuildingSiteInfo.branchCompany}"/>
                    		</c:if>
                    		<c:if test='${sessionScope.Role.roleName=="超级管理员" }'>
                    			<select name="branchCompany" id="branchCompany" class="easyui-combobox" 
                    			data-options="panelHeight:'200',editable : false,
                    			valueField: 'id',
                     			textField: 'text',
                     			url:'${pageContext.request.contextPath}/static/www/json/scinter_company.json',
                     			onLoadSuccess:function(data){
			                    	var branchCompany = '${hotBuildingSiteInfo.branchCompany}';
			                    	if(branchCompany!=''){
			                   			$('#branchCompany').combobox('setValue',branchCompany);
			                   		}
			                    }" style="width:247px;">
                    			 	<option>===请选择===</option>
                    			</select>
                    		</c:if>
                    		</td>
                    		
                    	</tr>
     
                    	<tr>
                    		<td class="right" width="10%">房屋户型：</td>
                    		<td>
                    			<select name="houseType" id="houseType" class="easyui-combobox" 
                    			data-options="panelHeight:'auto',editable : false,
                    			valueField: 'id',
                     			textField: 'text',
                     			url:'${pageContext.request.contextPath}/static/www/json/case_house_type.json',
                     			onLoadSuccess:function(data){
			                    	var houseType = '${hotBuildingSiteInfo.houseType}';
			                    	if(houseType!=''){
			                   			$('#houseType').combobox('setValue',houseType);
			                   		}
			                    }" style="width:247px;">
                    			 	<option>===请选择===</option>
                    			</select>
                    		</td>
                    		<td class="right" width="10%">浏览量：</td>
                    		<td>
								<input type="number" class="txt" id="readNum" name="readNum" value="${hotBuildingSiteInfo.readNum}" />
                    		</td>
                    		
                    	</tr>
                    	<tr>
                    	    <td class="right">装修费用(万元)：</td>
                    	    <td>
                    	    	<input class="txt" id="costs" name="costs" type="number" value="${hotBuildingSiteInfo.costs}"/>
                    		</td>
                    		<td class="right">建筑面积(平方米)：</td>
                    		<td>
                    			<input type="number" class="txt" id="houseAcreage" name="houseAcreage" value="${hotBuildingSiteInfo.houseAcreage}"/>
                    		</td>
                    	</tr>
                    		<tr>
                    	    <td class="right" width="10%">装修风格：</td>
                   	    	<td>
                    			<select name="houseStyle" id="houseStyle" class="easyui-combobox" 
                    			data-options="panelHeight:'auto',editable : false,
                    			valueField: 'id',
                     			textField: 'text',
                     			url:'${pageContext.request.contextPath}/static/www/json/case_style.json',
                     			onLoadSuccess:function(data){
			                    	var houseStyle = '${hotBuildingSiteInfo.houseStyle}';
			                    	if(houseStyle!=''){
			                   			$('#houseStyle').combobox('setValue',houseStyle);
			                   		}
			                    }" style="width:247px;">
                    			 	<option>===请选择===</option>
                    			</select>
                    		</td>
                    		<td class="right" width="10%">项目经理：</td>
                    		<td>
								<input class="txt" id="manager" name="manager" value="${hotBuildingSiteInfo.manager}" />
                    		</td>
                    	</tr>
                    	
                    	<tr>
                    		<td class="right" width="10%"><i class="require">*</i>
                    		
                    		    <c:set var="theString" value="${sessionScope.Role.branchCompany }"/>
								<c:if test="${fn:endsWith(theString,'sc') }">
									工地照片：[280*232]px:
								</c:if>
								<c:if test="${fn:endsWith(theString,'xz') }">
									工地照片：[280*232]px:
								</c:if>
								<c:if test="${fn:endsWith(theString,'rbw1') }">
									工地照片：[280*232]px:
								</c:if>
								<c:if test="${fn:endsWith(theString,'rbw2') }">
									工地照片：[280*232]px:
								</c:if>
								<c:if test="${fn:endsWith(theString,'rrl') }">
									工地照片：[280*232]px:
								</c:if>
                    		
                    		</td>
                    		<td colspan="3">
								<input type="hidden" id="siteThumbImg" name="siteThumbImg" value="${hotBuildingSiteInfo.siteThumbImg }" />
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
                    						<c:if test='${not empty hotBuildingSiteInfo.siteThumbImg }'>
                    							<a target="_blank" class="zoom_img2" href="${hotBuildingSiteInfo.siteThumbImg }">
													<img title="查看大图" src="${hotBuildingSiteInfo.siteThumbImg }" style="margin-left:10px;width:80px;height:80px;cursor:pointer;" />
												</a>
											</c:if>
                    						</span>
                    					</td>
                    				</tr>
                    			</table>
                    		</td>
                    	</tr>
                    	
                    	<tr>
                    		<td class="right" width="10%"><i class="require">*</i>施工阶段：
                    			<select style="width:80px;" name="imageType" id="imageType">
							    	<option value="1">准备</option>
							    	<option value="2">水电</option>
							    	<option value="3">泥木</option>
							    	<option value="4">油漆</option>
							    	<option value="5">竣工安装</option>
							    	<option value="6">入住</option>
							    	<option value="7">其他</option>							    	
				                </select>
                    		</td>
                    		<td colspan="3">
                    			<table>
                    				<tr>
                    					<td>
                    					<div id="uploader-demo">
										    <!--用来存放item-->
										    <div id="fileList" class="uploader-list">
										    </div>
										    <div id="filePicker">施工图片</div>
										</div>
                    					</td>
                   						<td><input type="hidden" name="siteImageIdArr" id="siteImageIdArr"/>
	                   						<span id="upload_img_span" style="display:inline;">
												<c:forEach items="${hotBuildingSiteListInfo }" var="buildingImage">
													<a target="_blank" id="caseImage_${buildingImage.imageId }" href="${buildingImage.imageUrl }">
														<img title="查看大图" src="${buildingImage.imageUrl }" style="margin-left:10px;width:80px;height:80px;cursor:pointer;" id="buildingImage_${buildingImage.imageId }"/>
													</a>&nbsp;<img title="删除" id="delBuildingImage_${buildingImage.imageId }" onclick="delBuildingImage('${buildingImage.imageId }')" src="${pageContext.request.contextPath}/static/www/css/img/empty.png"/>
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
            
            <div title="施工图片" data-options="" class="pad10 relative" id="tab2">
            	<c:forEach items="${hotBuildingSiteListInfo}" var="cm" varStatus="status" >
					<a target="_blank" title="查看大图" href="${fn:substring(cm.imageUrl, 0, 27)}_logo${fn:substring(cm.imageUrl, 27, 31)}"><img src="${fn:substring(cm.imageUrl, 0, 27)}_logo${fn:substring(cm.imageUrl, 27, 31)}" style="width:160px;height:160px;" /></a>
					<c:if test="${(status.index+1) % 6 == 0}" > 
						<br/>
		            </c:if>
				</c:forEach>
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
<script src="${pageContext.request.contextPath}/static/www/scripts/jquery.cityselect.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/webuploader.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/easyui.datebox.js" type="text/javascript" charset="utf-8"></script>

<script type="text/javascript" charset="utf-8">


//delBuildingImage
function delBuildingImage(buildingImageId){
	$.ajax({
		type : "POST",
		dataType : "json",
		async: false,
		url : "${pageContext.request.contextPath}/admin/delBuildingImage",
		data : "buildingImageId=" + buildingImageId,
		success : function(data) {
			if (data.data == "ok") {
				$("#buildingImage_"+buildingImageId).remove();
				$("#delBuildingImage_"+buildingImageId).remove();
			}
		}
	});
	
}
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
    
	/*layout*/
    $("#js_layout").layout({fit:true});
	
   
   /*保存 */ 
	$("#js_save").click(function(){
	
	
		$('#grid_hotBuildingSite').form({
		    url:'${pageContext.request.contextPath}/admin/saveHotBuildingSite',
			onSubmit : function() {
				
				var siteName = $("#siteName").val();
				if(siteName ==""){
					$.messager.alert("操作提示", "在建工地名称不能为空！","info");
					$("#siteName").focus();
					return false;
				}
				

				var designerId = $('#designerId').combobox('getValue');
				if(designerId =="===请选择==="){
					$.messager.alert("操作提示", "请先选择案例设计师！","info");
					$("#designerId").focus();
					return false;
				}
				
			},
			success : function(data) {
				var str=jQuery.parseJSON(data);
				if(str.data=='ok'){
					//刷新父窗口表格
					$.messager.alert("操作提示", "保存成功！","info");
					var row = parent.$("#grid_hotBuilding").datagrid('getSelected');
				  	var rowIndex = parent.$("#grid_hotBuilding").datagrid('getRowIndex', row);
				  	parent.rowIndex = rowIndex;
					parent.$("#grid_hotBuilding").datagrid("reload");
				}else{
					$.messager.alert("操作提示", "操作失败！","info");
				}
			}
		});
		//提交表单
		$('#grid_hotBuildingSite').submit();
	});
	
   
	//工地图片上传 初始化Web Uploader
	var uploader = WebUploader.create({
	
	    // 选完文件后，是否自动上传。
	    auto: true,
	
	    // swf文件路径
	    swf: '${pageContext.request.contextPath}/static/www/scripts/Uploader.swf',
	
	    // 文件接收服务端。
	    server: '${pageContext.request.contextPath}/admin/siteImgFileListUpload?siteId='+'${hotBuildingSiteInfo.id}',
	    
	     fileNumLimit:30,
	    
	    // 选择文件的按钮
	    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
	    pick: {
	    	id:'#filePicker'
	    	//,multiple : false,
	    },
	
	    // 只允许选择图片文件。
	    accept: {
            title: 'Images',
            extensions: 'gif,jpg,jpeg,bmp,png,GIF,JPG,JPEG,BMP,PNG',
            mimeTypes: 'image/*'
        }
	});
	
	//文件开始上传 设置传递参数
	uploader.on('startUpload', function( file,response ) {
		uploader.option( 'formData', {siteId:'${hotBuildingSiteInfo.id}',imageType:$("#imageType").val()});
	});
	
	// 文件上传成功，显示图片
	var imageIdArr = $("#siteImageIdArr").val();
	uploader.on('uploadSuccess', function( file,response ) {
		//增加多个文件显示及删除操作
		var url = response.url;
		var imgId = response.imageId;
		imageIdArr = imageIdArr +","+ imgId;
		$("#caseImageIdArr").val(imageIdArr);
	    var zoomImgId = "zoom_img_"+Math.floor(Math.random()*100);
	    $("#upload_img_span").append('<a title="查看大图" id="'+zoomImgId+'" target="_blank" href="'+url+'"><img alt="缩略图" id="buildingImage_'+imgId+'" src="'+url+'" style="margin-left:10px;width:80px;height:80px;cursor:pointer;"/></a>');
	    $("#upload_img_span").append('&nbsp;<img title="删除" id="delCaseImage_'+imgId+'" onclick="delCaseImage('+imgId+')" src="${pageContext.request.contextPath}/static/www/css/img/empty.png"/>');
	
	});
	
	
	//工地缩略图上传
	var uploader1 = WebUploader.create({
		
	    // 选完文件后，是否自动上传。
	    auto: true,
	
	    // swf文件路径
	    swf: '${pageContext.request.contextPath}/static/www/scripts/Uploader.swf',
	
	    // 文件接收服务端 siteThumbImgFileUpload
	    server: '${pageContext.request.contextPath}/admin/siteThumbImgFileUpload?siteId='+'${hotBuildingSiteInfo.id}',
	    
	     fileNumLimit:30,
	    
	    // 选择文件的按钮
	    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
	    pick: {
	    	id:'#filePicker1',
	    	multiple : false,
	    },
	
	    // 只允许选择图片文件。
	    accept: {
            title: 'Images',
            extensions: 'gif,jpg,jpeg,bmp,png,GIF,JPG,JPEG,BMP,PNG',
            mimeTypes: 'image/*'
        },
	});
	
	// 缩略图文件上传成功，显示图片。
	uploader1.on('uploadSuccess', function( file,response ) {
		var url = response.data;
		$(".zoom_img2").remove();
		$("#siteThumbImg").val(url);
	    $("#upload_img_span1").append('<a title="查看大图" class="zoom_img2" target="_blank" href="'+url+'"><img alt="缩略图" src="'+url+'" style="margin-left:10px;width:80px;height:80px;cursor:pointer;"/></a>');
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
