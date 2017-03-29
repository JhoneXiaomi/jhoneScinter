<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>装修小区</title>
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
            <div title="装修小区信息" data-options="" class="pad10 relative" id="tab1">
                <form id="caseForm" method="post">
                <input type="hidden" id="communityId" name="communityId" value="${communityInfo.communityId}"  />
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
                        	<td class="right" width="10%"><i class="require">*</i>
                        	推荐小区：
                        	</td>
                    		<td>
                    			<label for="status3"><span style="color:#0f681a;font-weight: bold;">是</span><input type="radio" value="是" name="isHot" id="status3" style="vertical-align:middle"/></label>
                    			<label for="status4"><span style="color:red;font-weight: bold;">否</span><input type="radio" value="否" name="isHot" checked="checked" id="status4" style="vertical-align:middle"/></label>&nbsp;&nbsp;
                    		</td>
                        </tr>
                    	<tr>
                    		<td class="right"><i class="require">*</i>小区名称：</td>
                    		<td>
                    			<input class="txt" id="communityName" name="communityName" type="text" value="${communityInfo.communityName}" />
                    		</td>
                    		<td class="right"><i class="require">*</i>案例数量：</td>
                    		<td>
                    			<input class="txt" id="communityCases" name="communityCases" type="number" value="${communityInfo.communityCases}" />
                    		</td>
                    	</tr>
                    	<tr>
                    	    <td class="right"><i class="require">*</i>客户参观量：</td>
                    		<td>
                    			<input class="txt" id="signNumber" name="signNumber" type="number" value="${communityInfo.signNumber}" />
                    		</td>
                    	</tr>
                    	<c:if test="${sessionScope.controlledCompany=='xzzs' }">
	                    	<tr>
	                    	    <td class="right"><i class="require">*</i>优惠链接地址：</td>
	                    		<td>
	                    			<input class="txt" id="activityUrl" name="activityUrl" type="txt" value="${communityInfo.activityUrl}" />
	                    		</td>
	                    		<td colspan="2"><font color="red">示例代码：http://www.baidu.com</font></td>
	                    	</tr>
                    	</c:if>
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
				                    	var status = '${communityInfo.branchCompany }';
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
				                    	var status = '${communityInfo.branchCompany }';
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
				                    	var status = '${communityInfo.branchCompany }';
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
				                    	var status = '${communityInfo.branchCompany }';
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
				                    	var status = '${communityInfo.branchCompany }';
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
                    		
                    			<c:if test="${fn:contains(sessionScope.Role.branchCompany,'hsrbw2')}">
                    				小区缩略图[1040x494]px：
                    			</c:if>
                    			
                    			<c:if test="${fn:contains(sessionScope.Role.branchCompany,'xz')}">
                    				小区缩略图[306x258]px：
                    			</c:if>
                    			<c:if test="${fn:contains(sessionScope.Role.branchCompany,'sc')}">小区缩略图[545x415]px：</c:if>
                    			<c:if test="${fn:contains(sessionScope.Role.branchCompany,'rbw1')}">小区缩略图[545x415]px：</c:if>
                    		 	<c:if test="${fn:contains(sessionScope.Role.branchCompany,'rrl')}">小区缩略图[545x415]px：</c:if>
                    		 </td>
                    		<td colspan="3">
                    			<input type="hidden" id="communityImage" name="communityImage" value="${communityInfo.communityImage }" />
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
                    						<c:if test='${not empty communityInfo.communityImage  }'>
                    							<a target="_blank" class="zoom_img2" href="${communityInfo.communityImage }">
													<img id="big_img2" title="查看大图" src="${communityInfo.communityImage }" style="margin-left:10px;width:80px;height:80px;cursor:pointer;" />
												</a>
											</c:if>
                    						</span>
                    					</td>
                    				</tr>
                    			</table>
                    		</td>
                    		
                    		
                    	</tr>
                    	<tr>
                    		<td class="right" width="10%"><i class="require">*</i>小区描述：</td>
                    		<td colspan="3">
                    			<textarea id="communityDescription" name="communityDescription" style="width:800px;height:135px;">${communityInfo.communityDescription }</textarea>
                    		</td>
                    	</tr>
                    	
                    </tbody>
                </table>
                </form>
				<div class="blank10"></div>
            </div>
            
            <c:if test="${not empty communityInfo.communityId }">
            <div title="小区案例展示" data-options="" class="pad10 relative" id="tab2">
				
				<c:forEach items="${caseList}" var="cases" >
					<p><a style="line-height:1.5;" href="showCase?caseId=${cases.caseId}"> ${cases.caseTitle }</a></p>
				</c:forEach>
			</div>
			</c:if>
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
var status = '${communityInfo.isHot}';
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
		url : "${pageContext.request.contextPath}/admin/delDocumentImage",
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
	
	//小区缩略图上传
	var uploader1 = WebUploader.create({
	
	    // 选完文件后，是否自动上传。
	    auto: true,
	
	    // swf文件路径
	    swf: '${pageContext.request.contextPath}/static/www/scripts/Uploader.swf',
	
	    // 文件接收服务端。
	    server: '${pageContext.request.contextPath}/admin/communityImgFileUpload?communityId='+'${communityInfo.communityId}',
	    
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
		$("#communityImage").val(url);
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
		    url:'${pageContext.request.contextPath}/admin/saveDocument',
			onSubmit : function() {
				
				var role = '${sessionScope.Role.roleName}';
				var branchCompany = '${sessionScope.Role.branchCompany}';
				
				if(role=="超级管理员"){
					
					$("#branchCompany").val($("#company").combobox("getValue"));
				}else{
				
					$("#branchCompany").val(branchCompany);
				}
					
				var communityName = $("#communityName").val();
				if(communityName==""){
					$.messager.alert("操作提示", "对不起，小区名称不能为空！","info");
					$("#communityName").focus();
					return false;
				}
				var communityImage = $("#communityImage").val();
				if(communityImage==""){
					$.messager.alert("操作提示", "对比起，请先上传小区缩略图！","info");
					$("#communityImage").focus();
					return false;
				}
				var communityDescription = $("#communityDescription").val();
				if(communityDescription==""){
					$.messager.alert("操作提示", "对不起，小区描述不能为空！","info");
					$("#communityDescription").focus();
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
		console.info($("table.forms td").eq(1));
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
