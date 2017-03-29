<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>户型点评基本信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/easyui.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/common.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/webuploader.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/SYS.css" type="text/css" />
</head>
<body>
<div class="wrapper details notblbew" id="js_layout">
    <div data-options="region:'center'" class="noborder" style="overflow:hidden;">
        <div class="easyui-tabs" data-options="tools:'#tab-tools'" id="tabs"> 
            <div title="户型点评基本信息" data-options="" class="pad10 relative" id="tab1">
                <form id="houseTypeReviewForm" method="post">
                
                <input type="hidden" name="id" name= "id" value="${houseTypeReviewInfo.id}"  />
       			
                <table class="forms" style="table-layout:fixed;">
                    <tbody>
                    	<tr>
                            <td class="right" width="120"></td>
                            <td width="300"></td>
                            <td class="right" width="120"></td>
                            <td width="300"></td>
                        </tr>
                    	<tr>
                    		<td class="right"><i class="require">*</i>点评标题：</td>
                    		<td>
                    			<input class="txt" id="title" name="title" type="text" value="${houseTypeReviewInfo.title}"/>
                    		</td>
                    		<c:if test='${not empty houseTypeReviewInfo.bulidingId }'>
								<td class="right"><i class="require">*</i>关联楼盘：</td>
								<td>
	                    			<a class="ublue" style="margin-left:3px;" href="${pageContext.request.contextPath}/admin/showHotBuilding?buildingId=${houseTypeReviewInfo.bulidingId}">${buildingName }</a>
	                    		              		
	                    		</td> 
                    		</c:if>
                    		<c:if test='${empty houseTypeReviewInfo.bulidingId }'>
								<td class="right"><i class="require">*</i>选择点评楼盘：</td>
								<td>
                    			<select name="bulidingId" id="bulidingId" class="easyui-combobox" 
                    			data-options="panelHeight:'200',editable : false,
                    			valueField: 'bulidingId',      
                     			textField: 'bulidingName',
			                    url:'${pageContext.request.contextPath}/admin/getAllbuildingName',
			                    onLoadSuccess:function(data){
			                    	var bulidingName = '${houseTypeReviewInfo.buildingName}';
			                    	if(bulidingName!=''){
			                   			$('#bulidingName').combobox('setValue',bulidingName);
			                   		}
			                    }"
                    			 style="width:247px;">
                    			 	<option>===请选择===</option>
                    			</select>
                    		</td>
                    		</c:if>
                
                    	</tr>
     
                    	<tr>
                    		<td class="right" width="10%">户型：</td>
                    		<td >
                    			<select name="type" id="type" class="easyui-combobox" 
                    			data-options="panelHeight:'auto',editable : false,
                    			valueField: 'id',
                     			textField: 'text',
                     			url:'${pageContext.request.contextPath}/static/www/json/case_house_type.json',
                     			onLoadSuccess:function(data){
			                    	var type = '${houseTypeReviewInfo.type}';
			                    	if(type!=''){
			                   			$('#type').combobox('setValue',type);
			                   		}
			                    }" style="width:247px;">
                    			 	<option>===请选择===</option>
                    			</select>
                    		</td>
                    		
							<td class="right" width="10%">面积：</td>
                    		<td>
                    			<select name="acreage" id="acreage" class="easyui-combobox" 
                    			data-options="panelHeight:'auto',editable : false,
                    			valueField: 'id',
                     			textField: 'text',
                     			url:'${pageContext.request.contextPath}/static/www/json/case_acreage.json',
                     			onLoadSuccess:function(data){
			                    	var acreage = '${houseTypeReviewInfo.acreage}';
			                    	if(acreage!=''){
			                   			$('#acreage').combobox('setValue',acreage);
			                   		}
			                    }" style="width:247px;">
                    			 	<option>===请选择===</option>
                    			</select>
                    		</td>                    		
                    	</tr>
                    	<tr>
                    		<td class="right" width="10%">点评设计师：</td>
						    <td>
                    			<select name="designer" id="designer" class="easyui-combobox" 
                    			data-options="panelHeight:'200',editable : false,
                    			valueField: 'designerName',      
                     			textField: 'designerName',
                     			url:'${pageContext.request.contextPath}/admin/listAllDesigner',
			                    onLoadSuccess:function(data){
			                    	var designer = '${houseTypeReviewInfo.designer }';
			                    	if(designer!=''){
			                   			$('#designer').combobox('setValue',designer);
			                   		}
			                    }"
			                    style="width:247px;">
                    			 	<option>===请选择===</option>
                    			</select>
                    		</td>  
                    		<td class="right" width="10%">浏览量</td>    
                    		<td colspan="3">
                    		<input class="txt" type="text" id="readNum" name="readNum" value="${empty houseTypeReviewInfo.readNum ? 0:houseTypeReviewInfo.readNum}">                		
                    		
                    		</td>             		
                   		</tr>
                   		
                   		<tr>
                    		<td class="right" width="10%"><i class="require">*</i>户型点评缩略图：</td>
                    		<td colspan="3">
								<input type="hidden" id="thumbImg" name="thumbImg" value="${houseTypeReviewInfo.thumbImg }" />
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
                    						<c:if test='${not empty houseTypeReviewInfo.thumbImg }'>
                    							<a target="_blank" class="zoom_img1" href="${houseTypeReviewInfo.thumbImg }">
													<img title="查看大图" src="${houseTypeReviewInfo.thumbImg }" style="margin-left:10px;width:80px;height:80px;cursor:pointer;" />
												</a>
											</c:if>
                    						</span>
                    					</td>
                    				</tr>
                    			</table>
                    		</td>
                    	</tr>
                    	
                   		
                   		<tr>
                   		  <td class="right" width="10%">户型点评正文：</td>
                   		  <td colspan="3">
                   		  <!-- 加载编辑器的容器 -->
							    <script id="container" name="comment" type="text/plain">${houseTypeReviewInfo.comment}</script>
							    <!-- 配置文件 -->
							    <script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
							    <!-- 编辑器源码文件 -->
							    <script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/ueditor.all.js"></script>
							    <!-- 实例化编辑器 -->
							    <script type="text/javascript">
							        // var ueditor = UE.getEditor('container');
							         //var contents = ueditor.getContent();
							         
									 var ue = UE.getEditor('container', {
									
									      
									        zIndex: 0, //默认900
									        emotionLocalization: true
									    });							        
							    </script>
                   		  </td>
                   		</tr>
                   		
             
                    </tbody>
                </table>
                </form>
				<div class="blank10"></div>
            </div>
        </div>
        <div id="tab-tools" class="">  
            <!--a href="javascript:void(0)" class="ico pop" title="弹出" id="winMax">&nbsp;</a-->
        </div>
    </div>
    <div data-options="region:'south',collapsible:false,height:50" class="noborder hidden">
        <div class="ftbutton border-n">
            <ul class="lists rf">
                <li>
	                
	                <button class="button" type="button" id="js_save">保存</button>
                </li>
            </ul>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/static/www/scripts/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/easyui.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/easyui.datagrid.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/common.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/webuploader.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/jquery.cityselect.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/easyui.datebox.js" type="text/javascript" charset="utf-8"></script>

<script type="text/javascript" charset="utf-8">
jQuery(function($){

	
	//设置easyui-datebox日期只读
	$(".datebox :text").attr("readonly","readonly");
	$(".datetimebox :text").attr("readonly","readonly");
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
		
	
		$('#houseTypeReviewForm').form({
			
		    url:'${pageContext.request.contextPath}/admin/saveHouseTypeReview',
			onSubmit : function() {
				var bulidingId = $("#bulidingId").val();
				var title = $("#title").val();
				if(title ==""){
					
					$.messager.alert("操作提示", "请选择点评楼盘！","info");
					$("#title").focus();
					return false;
				}
				
				/* if(bulidingId=="===请选择==="){
					$.messager.alert("操作提示", "请选择点评楼盘！","info");
					$("#bulidingId").focus();
					return false;	
				} */
			},
			success : function(data) {
				var str=jQuery.parseJSON(data);
				if(str.data=='ok'){
					//刷新父窗口表格
					$.messager.alert("操作提示", "保存成功！","info");
					var row = parent.$("#grid_houseTypeReview").datagrid('getSelected');
				  	var rowIndex = parent.$("#grid_houseTypeReview").datagrid('getRowIndex', row);
				  	parent.rowIndex = rowIndex;
				  	parent.$("#grid_houseTypeReview").datagrid("reload");
				}else{
					$.messager.alert("操作提示", "操作失败！","info");
				}
			}
		});
		//提交表单
		$('#houseTypeReviewForm').submit();
	});
	
   
	//点评缩略图图片上传 初始化Web Uploader
	var uploader = WebUploader.create({
	
	    // 选完文件后，是否自动上传。
	    auto: true,
	
	    // swf文件路径
	    swf: '${pageContext.request.contextPath}/static/www/scripts/Uploader.swf',
	
	    // 文件接收服务端。
	    server: '${pageContext.request.contextPath}/admin/reviewImgFileListUpload?reviewImgId='+'${houseTypeReviewInfo.id}',
	    
	     fileNumLimit:30,
	    
	    // 选择文件的按钮
	    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
	    pick: {
	    	id:'#filePicker'
	    	,multiple : false,
	    },
	
	    // 只允许选择图片文件。
	    accept: {
            title: 'Images',
            extensions: 'gif,jpg,jpeg,bmp,png,GIF,JPG,JPEG,BMP,PNG',
            mimeTypes: 'image/*'
        }
	});
		
	// 文件上传成功，显示图片
	uploader.on('uploadSuccess', function( file,response ) {
		var url = response.data;
		$(".zoom_img1").remove();
		$("#thumbImg").val(url);
	    $("#upload_img_span").append('<a title="查看大图" class="zoom_img1" target="_blank" href="'+url+'"><img alt="缩略图" src="'+url+'" style="margin-left:10px;width:80px;height:80px;cursor:pointer;"/></a>');
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
