<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>装修首页大图</title>
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
            <div title="首页轮播大图信息" data-options="" class="pad10 relative" id="tab1">
                <form id="caseForm" method="post">
                    <input type="hidden" name="branchCompany" id="branchCompany" value="${homeTurnInfo.branchCompany }"/>
                    <input type="hidden" name="homeimgId" id="homeimgId" value="${homeTurnInfo.homeimgId }"/>
	                <table class="forms" style="table-layout:fixed;">
	                    <tbody>
	                    	<tr>
	                            <td class="right" width="120"></td>
	                            <td width="250"></td>
	                            <td class="right" width="120"></td>
	                        </tr>
	                    	<tr>
	                    		<td class="right"><i class="require">*</i>首页大图名称：</td>
	                    		<td>
	                    			<input class="txt" id="homeimgName" name="homeimgName" type="text" value="${homeTurnInfo.homeimgName}" />
	                    		</td>
	                    	</tr>
	                    	<tr>
	                    		<td class="right"><i class="require">*</i>首页大图ALT：</td>
	                    		<td>
	                    			<input class="txt" id="homeimgAlt" name="homeimgAlt" type="text" value="${homeTurnInfo.homeimgAlt}" />
	                    		</td>
	                    	</tr>
	                    	<tr>
	                    		<td class="right"><i class="require">*</i>首页大图链接地址URL：</td>
	                    		<td>
	                    			<input class="txt" id="caseTitle" name="homeimgUrl" type="text" value="${empty homeTurnInfo.homeimgUrl? 'http://': homeTurnInfo.homeimgUrl }" />
	                    		</td>
	                    		<td >
                	    			 <br/><pre><font color="red">示例代码:http://www.to8to.com/index.html</font></pre> 
	                    		</td>
	                    	</tr>
	                    	<c:if test='${sessionScope.Role.roleName=="超级管理员" }'>
		                    	<c:if test="${sessionScope.controlledCompany=='sczs' }">
		                    	<tr>
		                    		<td class="right" width="10%"><i class="require">*</i>隶属分公司：</td>
		                    		<td colspan="3">
		                    			<select  id="sel_branchCompany" class="easyui-combobox" 
		                    			data-options="panelHeight:'150',editable : false,
		                    			valueField: 'id',
		                     			textField: 'text',
		                     			groupField:'group',
		                     			url:'${pageContext.request.contextPath}/static/www/json/scinter/scinter_company.json',
		                     			onLoadSuccess:function(data){
					                    	var branchCompany = '${homeTurnInfo.branchCompany }';
					                    	if(branchCompany!=''){
					                   			$('#sel_branchCompany').combobox('setValue',branchCompany);
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
		                    			<select  id="sel_branchCompany" class="easyui-combobox" 
		                    			data-options="panelHeight:'150',editable : false,
		                    			valueField: 'id',
		                     			textField: 'text',
		                     			groupField:'group',
		                     			url:'${pageContext.request.contextPath}/static/www/json/xzzs/xz_company.json',
		                     			onLoadSuccess:function(data){
					                    	var branchCompany = '${homeTurnInfo.branchCompany }';
					                    	if(branchCompany!=''){
					                   			$('#sel_branchCompany').combobox('setValue',branchCompany);
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
		                    			<select  id="sel_branchCompany" class="easyui-combobox" 
		                    			data-options="panelHeight:'150',editable : false,
		                    			valueField: 'id',
		                     			textField: 'text',
		                     			groupField:'group',
		                     			url:'${pageContext.request.contextPath}/static/www/json/rbwzs1/rbw_company.json',
		                     			onLoadSuccess:function(data){
					                    	var branchCompany = '${homeTurnInfo.branchCompany }';
					                    	if(branchCompany!=''){
					                   			$('#sel_branchCompany').combobox('setValue',branchCompany);
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
		                    			<select  id="sel_branchCompany" class="easyui-combobox" 
		                    			data-options="panelHeight:'150',editable : false,
		                    			valueField: 'id',
		                     			textField: 'text',
		                     			groupField:'group',
		                     			url:'${pageContext.request.contextPath}/static/www/json/rbwzs2/rbw_company.json',
		                     			onLoadSuccess:function(data){
					                    	var branchCompany = '${homeTurnInfo.branchCompany }';
					                    	if(branchCompany!=''){
					                   			$('#sel_branchCompany').combobox('setValue',branchCompany);
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
		                    			<select  id="sel_branchCompany" class="easyui-combobox" 
		                    			data-options="panelHeight:'150',editable : false,
		                    			valueField: 'id',
		                     			textField: 'text',
		                     			groupField:'group',
		                     			url:'${pageContext.request.contextPath}/static/www/json/rrlzs/rrl_company.json',
		                     			onLoadSuccess:function(data){
					                    	var branchCompany = '${homeTurnInfo.branchCompany }';
					                    	if(branchCompany!=''){
					                   			$('#sel_branchCompany').combobox('setValue',branchCompany);
					                   		}
					                    }" style="width:247px;">
		                    			 	<option>===请选择===</option>
		                    			</select>
		                    		</td>
		                    	</tr>
		                    	</c:if>
	                    	</c:if>
	                    	
	                    	<tr>
	                    		<td class="right" width="10%"><i class="require">*</i>
		                    		首页图片[640x400]px：
	                    		</td>
	                    		<td colspan="3">
	                    			<table>
	                    				<tr>
	                    					<td>
	                    						 <div id="uploader-demo">
												    <!--用来存放item-->
												    <div id="fileList" class="uploader-list">
												    </div>
												    <div id="filePicker">选择图片</div>
												</div>
	                    					</td>
	                   						<td>
												<span id="upload_img_span" style="display:inline;">
													<input type="hidden" name="homeimgSrc" id="homeimgSrc" value="${homeTurnInfo.homeimgSrc }" />
													<c:if test="${not empty homeTurnInfo.homeimgSrc }">
														<a target="_blank" id="homeimgSrc_${homeTurnInfo.homeimgId }" href="${homeTurnInfo.homeimgSrc }" class="zoom_img2">
															<img title="查看大图" src="${homeTurnInfo.homeimgSrc }" style="margin-left:10px;width:80px;height:80px;cursor:pointer;" />
														</a>
													</c:if>
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
	
	//首页大图图片上传 初始化Web Uploader
	var uploader = WebUploader.create({
	
	    // 选完文件后，是否自动上传。
	    auto: true,
	
	    // swf文件路径
	    swf: '${pageContext.request.contextPath}/static/www/scripts/Uploader.swf',
	
	    // 文件接收服务端。
	    server: '${pageContext.request.contextPath}/admin/SyhdlbFileUpload?homeImgId='+'${homeTurnInfo.homeimgId}',
	    
	    fileNumLimit:30,
	    
	    // 选择文件的按钮
	    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
	    pick: {
	    	id:'#filePicker',
	    	multiple : false
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
	uploader.on('uploadSuccess', function( file,response ) {
	    var url = response.data;
		$("#homeimgSrc").val(url);
		$(".zoom_img2").remove();
		var zoomImgId = "zoom_img_"+Math.floor(Math.random()*100);
	    $("#upload_img_span").append('<a title="查看大图" id="'+zoomImgId+'" target="_blank" href="'+url+'"><img alt="缩略图" src="'+url+'" style="margin-left:10px;width:80px;height:80px;cursor:pointer;"/></a>');
	
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
		    url:'${pageContext.request.contextPath}/admin/saveSyhdlbm',
			onSubmit : function() {
				
				var roleName = '${sessionScope.Role.roleName}';
				var branchCompany = '${sessionScope.Role.branchCompany}';
				if("超级管理员" == roleName){
					$("#branchCompany").val($('#sel_branchCompany').combobox('getValue'));
					console.info($('#sel_branchCompany').combobox('getValue'));
				}else{
					console.info("the value of company is:"+branchCompany);
					$("#branchCompany").val(branchCompany);
				}
				//表单验证
				var homeimgName = $("#homeimgName").val();
				if(homeimgName ==""){
					$.messager.alert("操作提示", "对不起，首页大图名称不能为空！","info");
					$("#homeimgName").focus();
					return false;
				}
				
				var homeimgSrc = $("#homeimgSrc").val();
				if(homeimgSrc ==""){
					$.messager.alert("操作提示", "对不起，请先上传轮播图！","info");
					$("#homeimgSrc").focus();
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
