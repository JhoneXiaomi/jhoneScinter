<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>新闻信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/easyui.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/common.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/QA.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/webuploader.css" type="text/css" >
</head>
<body>
<div class="wrapper details notblbew" id="js_layout">
    <div data-options="region:'center'" class="noborder">
        <div class="easyui-tabs" data-options="tools:'#tab-tools'" id="tabs"> 
            <div title="新闻基本信息" data-options="" class="pad10 relative" id="tab1">
				<form id="newsForm" method="post">
				<input type="hidden" id="branchCompany" name="branchCompany"  />
                <input type="hidden" id="newsId" name="newsId" value="${newsInfo.newsId}"  />
                <input type="hidden" id="seoTitle" name="seoTitle" value="${newsInfo.seoTitle}"  />
                <input type="hidden" id="seoKeyword" name="seoKeyword" value="${newsInfo.seoKeyword}"  />
                <input type="hidden" id="seoDesc" name="seoDesc" value="${newsInfo.seoDesc}"  />
                <input type="hidden" id="scinterNewsSeoTitleStr" name="scinterNewsSeoTitleStr" value="${newsInfo.scinterNewsSeoTitleStr}"  />
                <input type="hidden" id="scinterNewsSeoKeywordStr" name="scinterNewsSeoKeywordStr" value="${newsInfo.scinterNewsSeoKeywordStr}"  />
                <input type="hidden" id="scinterNewsSeoDescStr" name="scinterNewsSeoDescStr" value="${newsInfo.scinterNewsSeoDescStr}"  />
                <table class="forms" style="table-layout:fixed;">
                    <tbody>
                    	<tr>
                            <td class="right" width="120"></td>
                            <td width="300"></td>
                            <td class="right" width="120"></td>
                            <td width="300"></td>
                        </tr>
                        <tr>
                        	<td class="right" width="10%"><i class="require">*</i>推荐新闻：</td>
                    		<td>
                    			<label for="status3"><span style="color:#0f681a;font-weight: bold;">是</span><input type="radio" value="是" name="isHotNews" id="status3" style="vertical-align:middle"/></label>
                    			<label for="status4"><span style="color:red;font-weight: bold;">否</span><input type="radio" value="否" name="isHotNews" checked="checked" id="status4" style="vertical-align:middle"/></label>&nbsp;&nbsp;
                    		</td>
                        </tr>
                    	<tr>
                    		<td class="right"><i class="require">*</i>新闻标题：</td>
                    		<td>
                    			<input class="txt" id="title" name="title" type="text" value="${newsInfo.title}" />
                    		</td>
                    		<td class="right"><i class="require">*</i>关键字：</td>
                    		<td><input class="txt" id="keywords" name="keywords" type="text" value="${newsInfo.keywords}" />
                    		</td>
                    	</tr>
                    	
                    	<tr>
                    		<td class="right" width="10%"><i class="require">*</i>新闻作者：</td>
                    		<td>
                    			<input class="txt" id="author" name="author" type="text" value="${empty newsInfo.author ? sessionScope.UserInfo.nickName : newsInfo.author}" />
                    		</td>
                    		<td class="right" width="10%">来源：</td>
                    		<td>
                    			<input class="txt" id="source" name="source" type="text" value="${newsInfo.source}" />
                    		</td>
                    	</tr>
                    	
                    	<tr>
                    		<td class="right" width="10%"><i class="require">*</i>新闻类别：</td>
                    		<td>
                    			<select name="type" id="type" class="easyui-combobox" 
                    			data-options="panelHeight:'auto',editable : true,
                    			valueField: 'id',
                     			textField: 'text',
                     			url:'${pageContext.request.contextPath}/static/www/json/scNews_type.json',
                     			onLoadSuccess:function(data){
			                    	var type = '${newsInfo.type }';
			                    	if(type!=''){
			                   			$('#type').combobox('setValue',type);
			                   		}
			                    }" style="width:247px;">
                    			 	<option>===请选择===</option>
                    			</select>
                    		</td>
                    		<td class="right" width="10%"><i class="require">*</i>浏览量：</td>
                    		<td><input class="txt" id="readNum" name="readNum" type="number" value="${newsInfo.readNum}" />
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
				                    	var status = '${newsInfo.branchCompany }';
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
				                    	var status = '${newsInfo.branchCompany }';
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
				                    	var status = '${newsInfo.branchCompany }';
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
				                    	var status = '${newsInfo.branchCompany }';
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
				                    	var status = '${newsInfo.branchCompany }';
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
								缩略图:[宽:390*高:297]px：
							</c:if>
							<c:if test="${fn:endsWith(theString,'xz') }">
								缩略图:[宽:250*高:208]px：
							</c:if>
							<c:if test="${fn:endsWith(theString,'rbw1') }">
								缩略图：[宽:260*高:189]px：
							</c:if>
							<c:if test="${fn:endsWith(theString,'rbw2') }">
								缩略图：[宽:260*高:189]px：
							</c:if>
                    		<c:if test="${fn:endsWith(theString,'rrl') }">
								缩略图：[宽:260*高:189]px：
							</c:if>
                    		</td>
                    		<td>
                    			<table>
	                    			<tr>
	                    			<td>
	                    	  <%-- <input type="hidden" id="thumbImg" name="thumbImg" value="${newsInfo.thumbImg }" /> --%>
	                    			<input type="hidden" id="thumbImg" name="thumbImg" value="${newsInfo.thumbImg }" />
	           
	                    			<div id="uploader-demo">
									    <!--用来存放item-->
									    <div id="fileList" class="uploader-list"></div>
									    <div id="filePicker">选择图片</div>
									</div>
									</td>
									<td>
									<span id="upload_img_span" style="display:inline;">
	                   						<c:if test='${not empty newsInfo.thumbImg }'>
	                   							<a target="_blank" class="zoom_img" href="${newsInfo.thumbImg }">
													<img title="查看大图" src="${newsInfo.thumbImg }" style="margin-left:10px;width:80px;height:80px;cursor:pointer;" />
												</a>
											</c:if>
	                    			</span>
	                    			</td>
	                    			</tr>
                    			</table>
                    		</td>
                    		<td><input type="hidden" name="status" value="${newsInfo.status }"></td>
                    		<!-- <td class="right" width="10%"><i class="require">*</i>发布状态：</td>
                    		<td>1正常2待审3删除
                    			<label for="status2"><span style="color:red;font-weight: bold;">待审</span><input type="radio" value="2" name="status" id="status2" style="vertical-align:middle"/></label>
                    			<label for="status1"><span style="color:#0f681a;font-weight: bold;">正常</span><input type="radio" value="1" name="status" checked="checked" id="status1" style="vertical-align:middle"/></label>&nbsp;&nbsp;
                    		</td> -->
                    	</tr>
                    	
                    	
                    	<tr>
                    		<td class="right" width="10%"><i class="require">*</i>新闻正文：</td>
                    		<td colspan="3" width="80%">
                    			<!-- 加载编辑器的容器 -->
							    <script id="container" name="contents" type="text/plain">${newsInfo.contents}</script>
							    <!-- 配置文件 -->
							    <script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
							    <!-- 编辑器源码文件 -->
							    <script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/ueditor.all.js"></script>
							    <!-- 实例化编辑器 -->
							    <script type="text/javascript">
							        var ueditor = UE.getEditor('container');
							        //var contents = ueditor.getContent();
							    </script>
                    		</td>
                    	</tr>
                    	
                    </tbody>
                </table>
				</form>
				<div class="blank10"></div>
            </div>
            
            <div title="SEO信息" data-options="" class="pad10 relative" id="tab2">
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
                    			<input class="txt" id="seoTitle_str" type="text" value="${newsInfo.seoTitle}" />
                    		</td>
                    	</tr>
                    	<tr>
                    		<td class="right"><i class="require">*</i>SEO关键字：</td>
                    		<td>
                    			<textarea id="seoKeyword_str" style="width:500px;height:80px;">${newsInfo.seoKeyword }</textarea>
                    		</td>
                    	</tr>
                    	<tr>
                    		<td class="right"><i class="require">*</i>SEO描述：</td>
                    		<td>
                    			<textarea id="seoDesc_str" style="width:500px;height:80px;">${newsInfo.seoDesc }</textarea>
                    		</td>
                    	</tr>
                    </tbody>
                </table>
                <div class="blank10"></div>
            </div>
        </div>
        <div id="tab-tools" class="">
            <a href="javascript:void(0)" class="ico pop" title="全屏" id="winMax">&nbsp;</a>
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

<script type="text/javascript" charset="utf-8">
jQuery(function($){
	//选择新闻状态
	var status = '${newsInfo.status}';
	if(status=="1"){		
		$("#status1").attr("checked","checked");
	}
	if(status=="2"){
		$("#status2").attr("checked","checked");
	}
	
	//选择推荐状态
	var status = '${newsInfo.isHotNews}';
	if(status=="是"){		
		$("#status3").attr("checked","checked");
	}
	if(status=="否"){
		$("#status4").attr("checked","checked");
	}
	
	//省市联动
	$("#city").citySelect({prov:"北京",nodata:"none"});
	$("#sheng_1").change(function(){
		//alert($("#sheng_1").val());
	});
	
	//图片上传
	// 初始化Web Uploader
	var uploader = WebUploader.create({
	
	    // 选完文件后，是否自动上传。
	    auto: true,
	
	    // swf文件路径
	    swf: '${pageContext.request.contextPath}/static/www/scripts/Uploader.swf',
	
	    // 文件接收服务端。
	    server: '${pageContext.request.contextPath}/admin/newsThumbImgUpload?newsId=${newsInfo.newsId}',
	    
	    fileNumLimit: 5,
	    
	    // 选择文件的按钮。可选。
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
		$(".zoom_img").remove();
		$("#thumbImg").val(url);
	    $("#upload_img_span").append('<a title="查看大图" class="zoom_img" target="_blank" href="'+url+'"><img alt="缩略图" src="'+url+'" style="margin-left:10px;width:80px;height:80px;cursor:pointer;"/></a>');
	});
	
	
	/*layout*/
    $("#js_layout").layout({fit:true});
	
    /*保存 */
	$("#js_save").click(function(){
		$('#newsForm').form({
		    url:'${pageContext.request.contextPath}/admin/saveNews',
			onSubmit : function() {
				//隐藏表单赋值
				// alert(UE.getEditor('container').getAllHtml());
				var seoTitle = $("#seoTitle_str").val();
				var seoKeyword = $("#seoKeyword_str").val();
				var seoDesc = $("#seoDesc_str").val();
				$("#scinterNewsSeoTitleStr").val(scinterNewsSeoTitleStr);
				$("#scinterNewsSeoKeywordStr").val(scinterNewsSeoKeywordStr);
				$("#scinterNewsSeoDescStr").val(scinterNewsSeoDescStr);
				$("#seoTitle").val(seoTitle);
				$("#seoKeyword").val(seoKeyword);
				$("#seoDesc").val(seoDesc);
				
				var role = '${sessionScope.Role.roleName}';
				var branchCompany = '${sessionScope.Role.branchCompany}';
				
				if(role=="超级管理员"){
					
					$("#branchCompany").val($("#company").combobox("getValue"));
				}else{
				
					$("#branchCompany").val(branchCompany);
				}
				
				//表单验证
				var thumbImg = $("#thumbImg").val();
				if(thumbImg==""){
					$.messager.alert("操作提示", "请先上传文章缩略图！","info");
					return false;
				}
				
			},
			success : function(data) {
				var str=jQuery.parseJSON(data);
				if(str.data=='ok'){
					$.messager.alert("操作提示", "保存成功！","info");
					//刷新父窗口表格
					$.messager.alert("操作提示", "保存成功！","info");
					var row = parent.$("#grid_recheck").datagrid('getSelected');
				  	var rowIndex = parent.$("#grid_recheck").datagrid('getRowIndex', row);
				  	parent.rowIndex = rowIndex;
					parent.$("#grid_recheck").datagrid("reload");
					
					//location.href = "${pageContext.request.contextPath}/admin/newsList.jsp";
				}else{
					$.messager.alert("操作提示", "操作失败！","info");
				}
			}
		});
		//提交表单
		$('#newsForm').submit();
	});
    
    /*tabs切换*/
    $("#tabs").tabs({fit:true,tools:'#tab-tools',onSelect:function(title,index){
        var tab=$("#tabs").tabs("getTab",index),loaded = tab.attr("loaded");
        if(loaded=="true")
            return;
        else
            tab.attr("loaded",true);
    }});
	
    /*全屏按钮*/
	$("#winMax").click(function(){
		var newsId = '${newsInfo.newsId}';
		parent.hideCenter(newsId);
	});
    
	//自适应窗口大小
     winResize=function(){
        var winWidth = $(window).width(),winHeight=$(window).height();
        $("#js_layout").layout("resize",{width:winWidth,height:winHeight});
		var tdW2=$("table.forms td").eq(1).width();
		var tdW3=$("table.forms td").eq(2).width();
		$("div.equalW").width(tdW2+tdW3+247+12+2);
		tableAlign("tab1");
		
		
   };
    $(window).wresize(winResize);
    winResize();
});
</script>
</body>
</html>
