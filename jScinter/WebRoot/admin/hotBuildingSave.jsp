<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>楼盘基本信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/easyui.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/common.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/QA.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/webuploader.css" type="text/css" >
</head>
<body>
<div class="wrapper details notblbew" id="js_layout">
    <div data-options="region:'center'" class="noborder" style="overflow:hidden;">
        <div class="easyui-tabs" data-options="tools:'#tab-tools'" id="tabs"> 
            <div title="楼盘基本信息" data-options="" class="pad10 relative" id="tab1">
                <form id="hotBuildingForm" method="post">
                <input type="hidden" name="branchCompany" id="branchCompany"/>
                <input type="hidden" name="bulidingId" name= "bulidingId" value="${hotBuildingInfo.bulidingId}"  />
       			
                <table class="forms" style="table-layout:fixed;">
                    <tbody>
                    	<tr>
                            <td class="right" width="120"></td>
                            <td width="300"></td>
                            <td class="right" width="120"></td>
                            <td width="300"></td>
                        </tr>
                    	<tr>
                    		<td class="right"><i class="require">*</i>楼盘名称：</td>
                    		<td>
                    			<input class="txt" id="bulidingName" name="bulidingName" type="text" value="${hotBuildingInfo.bulidingName}"/>
                    		</td>
                    		
                    		<td class="right">行政区域：</td>
                    		 <td>
                    		 	<div id="city"> 
								    <select id="sheng_1" class="prov" style="width:70px;"></select>
								    <select id="shi_2" class="city" disabled="disabled" style="width:85px;"></select>
								    <select id="qu_3" class="dist" disabled="disabled" style="width:85px;"></select> 
								</div>
                    			<input class="txt" id="bulidingArea" name="bulidingArea" type="hidden" value="${hotBuildingInfo.bulidingArea}" />
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
				                    	var status = '${hotBuildingInfo.branchCompany }';
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
				                    	var status = '${hotBuildingInfo.branchCompany }';
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
				                    	var status = '${hotBuildingInfo.branchCompany }';
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
				                    	var status = '${hotBuildingInfo.branchCompany }';
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
				                    	var status = '${hotBuildingInfo.branchCompany }';
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
									楼盘照片：[550x355]px:
								</c:if>
								<c:if test="${fn:endsWith(theString,'xz') }">
									楼盘照片：[395*300]px:
								</c:if>
								<c:if test="${fn:endsWith(theString,'rbw1') }">
									楼盘照片：[395*300]px:
								</c:if>
								<c:if test="${fn:endsWith(theString,'rbw2') }">
									楼盘照片：[395*300]px:
								</c:if>
								<c:if test="${fn:endsWith(theString,'rrl') }">
									楼盘照片：[395*300]px:
								</c:if>
                    	</td>
                    		<td>
								<input type="hidden" id="bulidingThumbImg" name="bulidingThumbImg" value="${hotBuildingInfo.bulidingThumbImg}" />
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
                    						<c:if test='${not empty hotBuildingInfo.bulidingThumbImg }'>
                    							<a target="_blank" class="zoom_img1" href="${hotBuildingInfo.bulidingThumbImg}">
													<img title="查看大图" src="${hotBuildingInfo.bulidingThumbImg}" style="margin-left:10px;width:80px;height:80px;cursor:pointer;" />
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
                <div title="关联户型" data-options="" class="pad10 relative" id="tab2">
            	 <table class="forms" style="table-layout:fixed;">
                    <tbody>
                    <c:forEach items="${houseList}" var="house">
                    	<tr><td><a class="nblue" href="showHouseTypeReview?houseTypeId=${house.id}">${house.title}</a></td></tr>
                    </c:forEach>
                      </tbody>
                  </table>
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
jQuery(function($){

	
	//设置easyui-datebox日期只读
	$(".datebox :text").attr("readonly","readonly");
	$(".datetimebox :text").attr("readonly","readonly");
	
	//省市联动初始化
	var bulidingArea = $("#bulidingArea").val();
	if(bulidingArea.length>0){
		var bulidingAreaArr = bulidingArea.split(",");
		$("#city").citySelect({
		    url:"${pageContext.request.contextPath}/static/www/scripts/city.min.json",
		    prov:bulidingAreaArr[0], //省份  
		    city:bulidingAreaArr[1], //城市  
		    dist:bulidingAreaArr[2], //区县  
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
	    server: '${pageContext.request.contextPath}/admin/hotBuildingImgFileUpload?buildingId='+'${hotBuildingInfo.bulidingId}',
	    
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
		$("#bulidingThumbImg").val(url);
		
		if($("#big_img1").attr("src")==""){
			$("#a_big_img1").css("display","inline");
			$("#a_big_img1").attr("href",url);
			$("#big_img1").attr("src",url);
		}else{
			$("#big_img1").attr("src",url);
		}
	    $("#upload_img_span").append('<a title="查看大图" class="zoom_img1" target="_blank" href="'+url+'"><img alt="热点楼盘图片" src="'+url+'" style="margin-left:10px;width:80px;height:80px;cursor:pointer;"/></a>');
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
    
	/*layout*/
    $("#js_layout").layout({fit:true});
	
   
   /*保存 */ 
	$("#js_save").click(function(){
	
	
		$('#hotBuildingForm').form({
		    url:'${pageContext.request.contextPath}/admin/saveHotBuilding',
			onSubmit : function() {
				
				var branchCompany = '${sessionScope.Role.branchCompany}';
				var role = '${sessionScope.Role.roleName}';
				
				if(role=="超级管理员"){
					
					$("#branchCompany").val($("#company").combobox("getValue"));
				}else{
				
					$("#branchCompany").val(branchCompany);
				}
				
				//行政区域赋值
				var bulidingArea = $("#sheng_1").val()+","+$("#shi_2").val()+","+$("#qu_3").val();
				$("#bulidingArea").val(bulidingArea);
				
				var bulidingName = $("#bulidingName").val();
				
				if(bulidingName == ""){
					
					$.messager.alert("操作提示", "楼盘名称不能为空！","info");
					$("#bulidingName").focus();
					return false;	
				}
				
				//表单验证
				var bulidingThumbImg = $("#bulidingThumbImg").val();
				if(bulidingThumbImg==""){
					$.messager.alert("操作提示", "请先上传楼盘照片！","info");
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
		$('#hotBuildingForm').submit();
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
