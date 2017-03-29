<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>设计师信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/easyui.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/common.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/QA.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/webuploader.css" type="text/css" >
</head>
<body>
<div class="wrapper details notblbew" id="js_layout">
    <div data-options="region:'center'" class="noborder">
        <div class="easyui-tabs" data-options="tools:'#tab-tools'" id="tabs"> 
            <div title="基本信息" data-options="" class="pad10 relative" id="tab1">
                <form id="designerForm" method="post">
                <input type="hidden" id="designerId" name="designerId" value="${designer.designerId}"  />
                <input type="hidden" id="branchCompany" name="branchCompany"  />
                <table class="forms" style="table-layout:fixed;">
                    <tbody>
                    	<tr>
                            <td class="right" width="120"></td>
                            <td width="300"></td>
                            <td class="right" width="120"></td>
                            <td width="300"></td>
                        </tr>
                    	<tr>
                    		<td class="right"><i class="require">*</i>姓名：</td>
                    		<td>
                    			<input class="txt" id="designerName" name="designerName" type="text" value="${designer.designerName}" />
                    		</td>
                    		<td class="right">职称：</td>
                    		<td><input class="txt" id="designerTitle" name="designerTitle" type="text" value="${designer.designerTitle}" />
                    		</td>
                    	</tr>
                    	
                    	<tr>
                    		<c:choose>
                    		
                    			<c:when test="${sessionScope.Role.branchCompany=='bjxz' }">
									<td class="right" width="10%">从业时间：</td>
		                    		<td>
		                    			<input id="designerWorkTime" name="designerWorkTime" style="width:248px;" type="number" value="${designer.designerWorkTime}" />
		                    		</td>                    			
                    			</c:when>
                    			<c:otherwise>
                    			
	                    			<td class="right" width="10%">从业时间：</td>
		                    		<td>
		                    			<input class="easyui-datebox" id="designerWorkTime" name="designerWorkTime" style="width:248px;" type="text" value="${designer.designerWorkTime}" />
		                    		</td>
                    			</c:otherwise>
                    		</c:choose>
                    		<td class="right" width="10%">设计风格：</td>
                    		<td><input class="txt" id="designerStyle" name="designerStyle" type="text" value="${designer.designerStyle}" /></td>
                    	</tr>
                    	
                    	
                    	<tr>
                    		<td class="right" width="10%">毕业院校：</td>
                    		<td>
                    			<input class="txt" id="designerSchool" name="designerSchool" type="text" value="${designer.designerSchool}" />
                    		</td>
                    		<td class="right" width="10%">籍贯：</td>
                    		<td>
                    			<div id="city">
								    <select id="sheng_1" class="prov" style="width:70px;"></select>
								    <select id="shi_2" class="city" disabled="disabled" style="width:85px;"></select>
								    <select id="qu_3" class="dist" disabled="disabled" style="width:85px;"></select> 
								    <input type="hidden" id="designerBirthPlace" name="designerBirthPlace" value="${designer.designerBirthPlace}"  />
								</div>
                    		</td>
                    	</tr>
                    	
                    	<tr>
                    		<td class="right" width="10%">性别</td>
                    		<td>
                    			<label for="sex_1">男<input type="radio"  value="男" checked="checked" name="designerSex" id="sex_1" style="vertical-align:middle"/></label>&nbsp;&nbsp;
                    			<label for="sex_2">女<input type="radio" value="女" name="designerSex" id="sex_2" style="vertical-align:middle"/></label>
                    		</td>
                    		
                    		<td class="right" width="10%">人气/浏览量：</td>
                    		<td>
                    			<input class="txt" id="designerPopularity" name="designerPopularity" type="text" value="${designer.designerPopularity}" />
                    		</td>
                    		
                    	</tr>
                    	
                    	<tr>
                    		<td class="right"><i class="require">*</i>隶属部门：</td>
                    		<td>
                    		 	<select name="designerDept" id="designerDept" class="easyui-combobox" 
                    			data-options="panelHeight:'auto',editable : false,
                    			valueField: 'id',
                     			textField: 'text',
			                    url:'${pageContext.request.contextPath}/static/www/json/designer_dept.json',
			                    onLoadSuccess:function(data){
			                    	var designerDept = '${designer.designerDept }';
			                    	if(designerDept!=''){
			                   			$('#designerDept').combobox('setValue',designerDept);
			                   		}
			                    }"
                    			 style="width:247px;">
                    			 	<option>===请选择===</option>
                    			</select>
                    		 	
                    		</td>
                    		<td class="right">设计费用(元/平方米)：</td>
                    		<td>
                    			<input class="txt" id="designerPrice" name="designerPrice" type="text" value="${designer.designerPrice}" />
                    		</td>
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
				                    	var status = '${designer.branchCompany }';
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
				                    	var status = '${designer.branchCompany }';
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
				                    	var status = '${designer.branchCompany }';
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
				                    	var status = '${designer.branchCompany }';
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
				                    	var status = '${designer.branchCompany }';
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
                    		<td class="right" width="10%"><i class="require">*</i>
                    		<c:set var="theString" value="${sessionScope.Role.branchCompany }"/>
							<c:if test="${fn:endsWith(theString,'sc') }">
								个人照片[宽:240*高:280]px：
							</c:if>
							<c:if test="${fn:endsWith(theString,'xz') }">
								个人照片[宽:240*高:263]px：
							</c:if>
							<c:if test="${fn:endsWith(theString,'rbw1') }">
								个人照片[宽:240*高:280]px：
							</c:if>
                    		<c:if test="${fn:endsWith(theString,'rbw2') }">
								个人照片[宽:240*高:280]px：
							</c:if>
                    		<c:if test="${fn:endsWith(theString,'rrl') }">
								个人照片[宽:240*高:280]px：
							</c:if>
                    		</td>
                    		<td>
								<input type="hidden" id="designerPhotoImg" name="designerPhotoImg" value="${designer.designerPhotoImg }" />
                    			<table>
                    				<tr>
                    					<td>
                    						<div id="uploader-demo">
											    <!--用来存放item-->
											    <div id="fileList" class="uploader-list"></div>
											    <div id="filePicker">选择图片</div>
											</div>
                    					</td>
                    					<td>
                    						<span id="upload_img_span" style="display:inline;">
                    						<c:if test='${not empty designer.designerPhotoImg }'>
                    							<a target="_blank" class="zoom_img1" href="${designer.designerPhotoImg }">
													<img title="查看大图" src="${designer.designerPhotoImg }" style="margin-left:10px;width:80px;height:80px;cursor:pointer;" />
												</a>
											</c:if>
                    						</span>
                    					</td>
                    				</tr>
                    			</table>
                    		</td>
                    		<td class="right" width="10%"><i class="require">*</i>资格证书：</td>
                    		<td>
								<input type="hidden" id="designerCertificateImg" name="designerCertificateImg" value="${designer.designerCertificateImg }" />
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
                    						<c:if test='${not empty designer.designerCertificateImg }'>
                    							<a target="_blank" class="zoom_img2" href="${designer.designerCertificateImg }">
													<img title="查看大图" src="${designer.designerCertificateImg }" style="margin-left:10px;width:80px;height:80px;cursor:pointer;" />
												</a>
											</c:if>
                    						</span>
                    					</td>
                    				</tr>
                    			</table>
                    		</td>
                    	</tr>
                    	
                    	<tr>
                    		<td class="right" width="10%">个人简介：</td>
                    		<td colspan="3">
                    			<textarea id="designerProfile" name="designerProfile" style="width:795px;height:200px;">${designer.designerProfile }</textarea>
                    		</td>
                    	</tr>
                    	<tr>
                    		<td class="right" width="10%"><i class="require">*</i>设计理念：</td>
                    		<td colspan="3">
                    			<textarea id="designerIdea" name="designerIdea" style="width:795px;height:200px;">${designer.designerIdea }</textarea>
                    		</td>
                    	</tr>
                    	
                    	
                    	
                    </tbody>
                </table>
                </form>
				<div class="blank10"></div>
            </div>
            
            <div title="设计案例" data-options="" class="pad10 relative" id="tab2">
            	 <table class="forms" style="table-layout:fixed;">
                    <tbody>
                    <c:forEach items="${caseList }" var="item">
                    	<tr><td><a class="nblue" href="showCase?caseId=${item.caseId }">${item.caseTitle }</a></td></tr>
                    </c:forEach>
                      </tbody>
                  </table>
            </div>
            
            <div title="个人照片及证书" data-options="" class="pad10 relative" id="tab3">
            	<table class="forms" style="table-layout:fixed;">
                    <tbody>
            			<tr>
            				<td>
            						<c:if test='${not empty designer.designerPhotoImg}'>
                  						<a target="_blank" href="${designer.designerPhotoImg}">
											<img id="big_img1" title="查看大图" src="${designer.designerPhotoImg}" style="margin-left:10px;width:500px;height:500px;cursor:pointer;" />
										</a>
									</c:if>
									<c:if test='${empty designer.designerPhotoImg}'>
                  						<a id="a_big_img1" target="_blank" href="${designer.designerPhotoImg}" style="display:none;">
											<img id="big_img1" title="查看大图" src="${designer.designerPhotoImg}" style="margin-left:10px;width:500px;height:500px;cursor:pointer;" />
										</a>
									</c:if>
            				</td>
            				<td>
            						<c:if test='${not empty designer.designerCertificateImg }'>
										<a target="_blank" href="${designer.designerCertificateImg }">
											<img id="big_img2" title="查看大图" src="${designer.designerCertificateImg }"
											style="margin-left: 10px; width: 500px; height: 500px; cursor: pointer;" />
										</a>
									</c:if>
									<c:if test='${empty designer.designerCertificateImg }'>
										<a id="a_big_img2" target="_blank" href="${designer.designerCertificateImg }" style="display:none;">
											<img id="big_img2" title="查看大图" src="${designer.designerCertificateImg }"
											style="margin-left: 10px; width: 500px; height: 500px; cursor: pointer;" />
										</a>
									</c:if>
							</td>
            			</tr>
                	</tbody>
                </table>    	
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
<script src="${pageContext.request.contextPath}/static/www/scripts/easyui.datebox.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" charset="utf-8">
jQuery(function($){
	//设置easyui-datebox日期只读
	$(".datebox :text").attr("readonly","readonly");
	
	//选择性别
	var designerSex = '${designer.designerSex}';
	if("男"==designerSex){		
		$("#sex_1").attr("checked","checked");
	}
	if("女"==designerSex){	
		$("#sex_2").attr("checked","checked");
	}
	
	//省市联动初始化
	var designerBirthPlace = $("#designerBirthPlace").val();
	if(designerBirthPlace.length>0){
		var areaArr = designerBirthPlace.split(",");
		$("#city").citySelect({
		    url:"${pageContext.request.contextPath}/static/www/scripts/city.min.json",
		    prov:areaArr[0], //省份  
		    city:areaArr[1], //城市  
		    dist:areaArr[2], //区县  
		    nodata:"none" //当子集无数据时，隐藏select  
		});
	}else{
		$("#city").citySelect({prov:"北京",nodata:"none"});
	}
	
	//图片上传
	// 初始化Web Uploader
	var uploader = WebUploader.create({
	
	    // 选完文件后，是否自动上传。
	    auto: true,
	
	    // swf文件路径
	    swf: '${pageContext.request.contextPath}/static/www/scripts/Uploader.swf',
	
	    // 文件接收服务端。
	    server: '${pageContext.request.contextPath}/admin/designerImgFileUpload?t=1&designerId='+'${designer.designerId}',
	    
	     fileNumLimit:30,
	    
	    // 选择文件的按钮
	    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
	    pick: {
	    	id:'#filePicker',
	    	multiple : false,
	    },
	
	    // 只允许选择图片文件。
	    accept: {
            title: 'Images',
            extensions: 'gif,jpg,jpeg,bmp,png,GIF,JPG,JPEG,BMP,PNG',
            mimeTypes: 'image/*'
        },
	});
	
	// 文件上传成功，显示图片。
	uploader.on('uploadSuccess', function( file,response ) {
		var url = response.data;
		$(".zoom_img1").remove();
		$("#designerPhotoImg").val(url);
		
		if($("#big_img1").attr("src")==""){
			$("#a_big_img1").css("display","inline");
			$("#a_big_img1").attr("href",url);
			$("#big_img1").attr("src",url);
		}else{
			$("#big_img1").attr("src",url);
		}
	    $("#upload_img_span").append('<a title="查看大图" class="zoom_img1" target="_blank" href="'+url+'"><img alt="缩略图" src="'+url+'" style="margin-left:10px;width:80px;height:80px;cursor:pointer;"/></a>');
	});
	
	var uploader1 = WebUploader.create({
		
	    // 选完文件后，是否自动上传。
	    auto: true,
	
	    // swf文件路径
	    swf: '${pageContext.request.contextPath}/static/www/scripts/Uploader.swf',
	
	    // 文件接收服务端。
	    server: '${pageContext.request.contextPath}/admin/designerImgFileUpload?t=2&designerId='+'${designer.designerId}',
	    
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
	
	// 文件上传成功，显示图片。
	uploader1.on('uploadSuccess', function( file,response ) {
		var url = response.data;
		$(".zoom_img2").remove();
		$("#designerCertificateImg").val(url);
		if($("#big_img2").attr("src")==""){
			$("#a_big_img2").css("display","inline");
			$("#a_big_img2").attr("href",url);
			$("#big_img2").attr("src",url);
		}else{
			$("#big_img1").attr("src",url);
		}
	    $("#upload_img_span1").append('<a title="查看大图" class="zoom_img2" target="_blank" href="'+url+'"><img alt="缩略图" src="'+url+'" style="margin-left:10px;width:80px;height:80px;cursor:pointer;"/></a>');
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
		$('#designerForm').form({
		    url:'${pageContext.request.contextPath}/admin/saveDesigner',
			onSubmit : function() {
				
				var role = '${sessionScope.Role.roleName}';
				var branchCompany = '${sessionScope.Role.branchCompany}';
				
				if(role=="超级管理员"){
					
					$("#branchCompany").val($("#company").combobox("getValue"));
				}else{
				
					$("#branchCompany").val(branchCompany);
				}
				
				var areaStr = $("#sheng_1").val()+","+$("#shi_2").val()+","+$("#qu_3").val();
				//行政区域赋值
				$("#designerBirthPlace").val(areaStr);
				
				var designerName = $("#designerName").val();
				var designerPhotoImg = $("#designerPhotoImg").val();
				if(designerName==""){
					
					$.messager.alert("操作提示", "请填写设计师姓名！","info");
					return false;
				}
				if(designerPhotoImg==""){
					$.messager.alert("操作提示", "请先上传设计师照片！","info");
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
		$('#designerForm').submit();
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