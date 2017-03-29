<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>装修问答</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/easyui.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/common.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/QA.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/webuploader.css" type="text/css" />
</head>
<body>
<div class="wrapper details notblbew" id="js_layout">
    <div data-options="region:'center'" class="noborder" style="overflow:hidden;">
        <div class="easyui-tabs" data-options="tools:'#tab-tools'" id="tabs"> 
            <div title="装修问答" data-options="" class="pad10 relative" id="tab1">
                <form id="faqForm" method="post">      
                <input type="hidden" name="faqId" id = "faqId" value="${faqInfo.faqId}"/>
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
                    		<td class="right" width="10%"><i class="require">*</i>问答缩略图</td>
                    		<td colspan="3">
                    			
                    			<input type="hidden" id="faqImage" name="faqImage" value="${faqInfo.faqImage }" />
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
                    						<c:if test='${not empty faqInfo.faqImage }'>
                    							<a target="_blank" class="zoom_img2" href="${faqInfo.faqImage }">
													<img id="big_img2" title="查看大图" src="${faqInfo.faqImage }" style="margin-left:10px;width:80px;height:80px;cursor:pointer;" />
												</a>
											</c:if>
                    						</span>
                    					</td>
                    				</tr>
                    			</table>
                    			
                    		</td>
                    	</tr>
                        <tr>
                    		<td class="right">问题类型：</td>
                    		<td>
                    			<select name="faqType" id="faqType" class="easyui-combobox" 
	                    			data-options="panelHeight:'auto',editable : false,
	                    			valueField: 'id',      
	                     			textField: 'text',
				                    url:'${pageContext.request.contextPath}/static/www/json/faq_type.json',
				                    onLoadSuccess:function(data){
				                    	var faqType = '${faqInfo.faqType }';
				                    	if(faqType!=''){
				                   			$('#faqType').combobox('setValue',faqType);
				                   		}
				                    }"
	                    			 style="width:247px;">
	                    			 	<option>===请选择===</option>
	                    			</select>
                    		</td>
                    		<td class="right"></td>
                    		<td>
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
                    		</td>
                    		
                    		
                    	</tr>
                    	<tr>
                    		<td class="right">装修问题描述：</td>
                            <td colspan="3">
                    			<textarea id="faqDesc" name="faqDesc" style="width:790px;height:120px;">${faqInfo.faqDesc}</textarea>
                    		</td>
                    	</tr>
                    	
                    	
                   
                    	<tr>
                    		<td class="right">装修问题答案：</td>
                    		<td colspan="3">
                    			<textarea id="faqAnswer" name="faqAnswer" style="width:790px;height:120px;">${faqInfo.faqAnswer}</textarea>
                    		</td>
                    	</tr>
                    	
                    </tbody>
                </table>
                </form>
				<div class="blank10"></div>
            </div>
        </div>
        <div id="tab-tools" class="">  
          
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
<script src="${pageContext.request.contextPath}/static/www/scripts/easyui.datebox.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/webuploader.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" charset="utf-8">

//delFaqImage
function delFaqImage(faqImageId){
	$.ajax({
		type : "POST",
		dataType : "json",
		async: false,
		url : "${pageContext.request.contextPath}/admin/delFaqImage",
		data : "faqImageId=" + faqImageId,
		success : function(data) {
			if (data.data == "ok") {
				$("#faqImage_"+faqImageId).remove();
				$("#delFaqImage_"+faqImageId).remove();
			}
		}
	});
	
}


//案例缩略图上传
// 初始化Web Uploader
var uploader1 = WebUploader.create({

    // 选完文件后，是否自动上传。
    auto: true,

    // swf文件路径
    swf: '${pageContext.request.contextPath}/static/www/scripts/Uploader.swf',

    // 文件接收服务端。
    server: '${pageContext.request.contextPath}/admin/faqThumbImgFileUpload?faqId='+'${faqInfo.faqId}',
    
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
	console.info(url);
	$("#faqImage").val(url);
	$(".zoom_img2").remove();
	 var zoomImgId = "zoom_img_"+Math.floor(Math.random()*100);
    $("#upload_img_span1").append('<a title="查看大图" id="'+zoomImgId+'" target="_blank" href="'+url+'"><img alt="缩略图" src="'+url+'" style="margin-left:10px;width:80px;height:80px;cursor:pointer;"/></a>');
});
jQuery(function($){

	
	
	//设置easyui-datebox日期只读
	$(".datebox :text").attr("readonly","readonly");
	
	
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
		$('#faqForm').form({
		    url:'${pageContext.request.contextPath}/admin/saveFaq',
			onSubmit : function() {
				

				var role = '${sessionScope.Role.roleName}';
				var branchCompany = '${sessionScope.Role.branchCompany}';
				
				if(role=="超级管理员"){
					
					$("#branchCompany").val($("#company").combobox("getValue"));
				}else{
				
					$("#branchCompany").val(branchCompany);
				}
				
				var updater = $("#updater").val();
				if(updater==""){
					$.messager.alert("操作提示", "更新者姓名不能为空！","info");
					
					$("#updater").focus();
					return false;
				}
				
			},
			success : function(data) {
				var str=jQuery.parseJSON(data);
				if(str.data=='ok'){
					//刷新父窗口表格
					$.messager.alert("操作提示", "保存成功！","info");
					var row = parent.$("#grid_faq").datagrid('getSelected');
				  	var rowIndex = parent.$("#grid_faq").datagrid('getRowIndex', row);
				  	parent.rowIndex = rowIndex;
					parent.$("#grid_faq").datagrid('reload');
				}else{
					$.messager.alert("操作提示", "操作失败！","info");
				}
			}
		});
		//提交表单
		$('#faqForm').submit();
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
