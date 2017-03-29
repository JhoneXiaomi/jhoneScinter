<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>新建角色</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/easyui.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/common.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/QA.css" type="text/css" />
</head>
<body>
<div class="wrapper details notblbew" id="js_layout">
    <div data-options="region:'center'" class="noborder" style="overflow:hidden;">
        <div class="easyui-tabs" data-options="tools:'#tab-tools'" id="tabs"> 
            <div title="订单基本信息" data-options="" class="pad10 relative" id="tab1">
                <form id="orderForm" method="post">
                
                <input type="hidden" name="id" value="${orderInfo.id}"  />
                <table class="forms" style="table-layout:fixed;">
                    <tbody>
                    	<tr>
                            <td class="right" width="120"></td>
                            <td width="300"></td>
                            <td class="right" width="120"></td>
                            <td width="300"></td>
                        </tr>
                    	<tr>
                    		<td class="right"><i class="require">*</i>订单编号：</td>
                    		<td><input class="txt" id="orderId" name="orderId" type="text" value="${orderInfo.orderId}" readonly="readonly"/>
                    		</td>
                            
                            <td class="right">楼盘(小区)名称：</td>
                    		<td><input class="txt" id="address" name="address" type="text" value="${orderInfo.address}" />
                    		</td>
                    	</tr>
                    	
                    	<tr>
                    		<td class="right"><i class="require">*</i>业主姓名：</td>
                    		<td><input class="txt" id="clientName" name="clientName" type="text" value="${orderInfo.clientName}" />
                    		</td>
                            
                             <td class="right">行政区域：</td>
                    		 <td>
                    		 	<div id="city"> 
								    <select id="sheng_1" class="prov" style="width:70px;"></select>
								    <select id="shi_2" class="city" disabled="disabled" style="width:85px;"></select>
								    <select id="qu_3" class="dist" disabled="disabled" style="width:85px;"></select> 
								</div>
                    			<input class="txt" id="area" name="area" type="hidden" value="${orderInfo.area}" />
                    		 </td>
                    	</tr>
                    	
                    	<tr>
                    		<td class="right">性别：</td>
                    		<td>
                    			<label for="sex_1">男<input type="radio" value="男" name="sex" id="sex_1" style="vertical-align:middle"/></label>&nbsp;&nbsp;
                    			<label for="sex_2">女<input type="radio" value="女" name="sex" id="sex_2" style="vertical-align:middle"/></label>
                    		</td>
                    		
                    		<td class="right"><i class="require">*</i>电话：</td>
                    		<td><input class="txt" id="phone" name="phone" type="text" value="${orderInfo.phone}" />
                    		</td>
                    	</tr>
                    	
                    	<tr>
                    		<td class="right"><i class="require">*</i>户型：</td>
                    		<td>
                   				<select name="houseType" id="houseType" class="easyui-combobox" 
                    			data-options="panelHeight:'auto',editable : true,
                    			valueField: 'id',      
                     			textField: 'text',
                     			url:'${pageContext.request.contextPath}/static/www/json/case_house_type.json',
                     			onLoadSuccess:function(data){
			                    	var houseType = '${orderInfo.houseType}';
			                    	if(houseType!=''){
			                   			$('#houseType').combobox('setValue',houseType);
			                   		}
			                    }" style="width:247px;">
                    			 	<option>===请选择===</option>
                    			</select>
                    		</td>
                            
                            <td class="right">使用面积：</td>
                    		<td>
                    			<select name="acreage" id="acreage" class="easyui-combobox" 
                    			data-options="panelHeight:'auto',editable : true,
                    			valueField: 'id',      
                     			textField: 'text',
                     			url:'${pageContext.request.contextPath}/static/www/json/case_acreage.json',
                     			onLoadSuccess:function(data){
			                    	var acreage = '${orderInfo.acreage}';
			                    	if(acreage!=''){
			                   			$('#acreage').combobox('setValue',acreage);
			                   		}
			                    }" style="width:247px;">
                    			 	<option>===请选择===</option>
                    			</select>
                    		</td>
                    	</tr>
                    	
                    	<tr>
                    		<td class="right"><i class="require">*</i>装修风格：</td>
                    		<td>
                    			<select name="style" id="style" class="easyui-combobox" 
                    			data-options="panelHeight:'auto',editable : true,
                    			valueField: 'id',      
                     			textField: 'text',
                     			url:'${pageContext.request.contextPath}/static/www/json/case_style.json',
                     			onLoadSuccess:function(data){
			                    	var style = '${orderInfo.style}';
			                    	if(style!=''){
			                   			$('#style').combobox('setValue',style);
			                   		}
			                    }" style="width:247px;">
                    			 	<option>===请选择===</option>
                    			</select>
                    		    
                    		</td>
                            
                            <td class="right">装修预算：</td>
                    		<td><input class="txt" id="budget" name="budget" type="text" value="${orderInfo.budget}" />
                    		</td>
                    	</tr>
                    	
                    	<tr>
                    		<td class="right"><i class="require">*</i>预约设计师：</td>
                    		<td>
                    			<select name="designer" id="designer" class="easyui-combobox" 
                    			data-options="panelHeight:'200',editable : false,
                    			valueField: 'designerName',      
                     			textField: 'designerName',
                     			url:'${pageContext.request.contextPath}/admin/listAllDesigner',
			                    onLoadSuccess:function(data){
			                    	var orderDesigner = '${orderInfo.designer }';
			                    	if(orderDesigner!=''){
			                   			$('#designer').combobox('setValue',orderDesigner);
			                   		}
			                    }"
			                    style="width:247px;">
                    			 	<option>===请选择===</option>
                    			</select>
                    		</td>
                            
                            <td class="right">开工日期：</td>
                    		<td><input class="easyui-datebox" id="startDate" name="startDate" type="text" style="width:248px;" value="<fmt:formatDate value="${orderInfo.startDate}" pattern="yyyy-MM-dd"/>" />
                    		</td>
                    	</tr>
                    	
                    	<tr>
                    		<td class="right">订单分类：</td>
                    		<td>
                    			<select name="sourceType" id="sourceType" class="easyui-combobox" 
                    			data-options="panelHeight:'auto',editable : false,
                    			valueField: 'id',      
                     			textField: 'text',
                     			url:'${pageContext.request.contextPath}/static/www/json/sourceType.json',
                     			onLoadSuccess:function(data){
			                    	var type = '${orderInfo.sourceType}';
			                    	if(type!=''){
			                   			$('#sourceType').combobox('setValue',type);
			                   		}
			                    }" style="width:247px;">
                    			 		<option>===请选择===</option>
                    			</select>
                    		</td>
                    		<td class="right">订单状态：</td>
                            <td>
                            
                    			<label for="status1"><span style="color:red;font-weight: bold;">未处理</span><input type="radio" value="0" name="orderStatus" checked="checked" id="status1" style="vertical-align:middle"/></label>
                    			<label for="status2"><span style="color:#FFD700;font-weight: bold;">处理中</span><input type="radio" value="1" name="orderStatus" id="status2" style="vertical-align:middle"/></label>
                    			<label for="status3"><span style="color:#00EE00;font-weight: bold;">已处理</span><input type="radio" value="2" name="orderStatus" id="status3" style="vertical-align:middle"/></label>
                    			<c:if test='${sessionScope.Role.roleName != "超级管理员" }'>
                    			<!-- 用户隶属分公司信息 -->
                    			<input type="hidden" id="branchCompany" name="branchCompany" value="${empty orderInfo.branchCompany ? sessionScope.Role.branchCompany : orderInfo.branchCompany}"/>
                            	</c:if>
                            </td>
                    	</tr>
                    	
                    	<c:if test='${sessionScope.Role.roleName=="超级管理员" }'>
                    	<tr>
                    		<td class="right" width="10%"><i class="require">*</i>隶属分公司：</td>
                    		<td colspan="3">
                    			<select name="branchCompany" id="branchCompany" class="easyui-combobox" 
                    			data-options="panelHeight:'200',editable : false,
                    			valueField: 'id',
                     			textField: 'text',
                     			groupField:'group',
                     			url:'${pageContext.request.contextPath}/static/www/json/scinter_company.json',
                     			onLoadSuccess:function(data){
			                    	var status = '${orderInfo.branchCompany }';
			                    	if(status!=''){
			                   			$('#branchCompany').combobox('setValue',status);
			                   		}
			                    }" style="width:247px;">
                    			 	<option>===请选择===</option>
                    			</select>
                    		</td>
                    	</tr>
                    	</c:if>
                    	
                    	<tr>
                    		<td class="right" width="10%"><i class="require"></i>订单备注：</td>
                    		<td colspan="3">
                    			<textarea id="note" name="note" style="width:790px;height:120px;">${orderInfo.note }</textarea>
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

<script type="text/javascript" charset="utf-8">
jQuery(function($){
	
	//选择在线订单状态
	var status = '${orderInfo.orderStatus}';
	if(status=="0"){		
		$("#status1").attr("checked","checked");
	}
	if(status=="1"){
		$("#status2").attr("checked","checked");
	}
	if(status=="2"){
		$("#status3").attr("checked","checked");
	}
	
	var orderId = $("#orderId").val();
	if(orderId == ""){
		var now = new Date();
	    var year = now.getFullYear();
	    var month =(now.getMonth() + 1).toString();
	    var day = (now.getDate()).toString();
	    var hour = (now.getHours()).toString();
	    var minute = (now.getMinutes()).toString();
	    var second = (now.getSeconds()).toString();
	    var ms = (now.getMilliseconds()).toString();
	    if (month.length == 1) {
	        month = "0" + month;
	    }
	    if (day.length == 1) {
	        day = "0" + day;
	    }
	    if (hour.length == 1) {
	        hour = "0" + hour;
	    }
	    if (minute.length == 1) {
	        minute = "0" + minute;
	    }
	      if (second.length == 1) {
	        second = "0" + second;
	    } 
	    var dateTime = year + month +  day + hour + minute + second + ms;
   	    $("#orderId").val(dateTime);
	}
//	设置性别的基本信息
	var sex_mes = '${orderInfo.sex}';

	if(sex_mes == "男"){
		$("#sex_1").attr("checked","checked");
		
	}else{
		
		$("#sex_2").attr("checked","checked");
	}
	//设置easyui-datebox日期只读
	$(".datebox :text").attr("readonly","readonly");
	
	//省市联动初始化
	var area = $("#area").val();
	if(area.length>0){
		var areaArr = area.split(",");
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
		$('#orderForm').form({
		    url:'${pageContext.request.contextPath}/admin/saveOrderInfo',
			onSubmit : function() {
				
				//行政区域赋值
				var area = $("#sheng_1").val()+","+$("#shi_2").val()+","+$("#qu_3").val();
				$("#area").val(area);
				
				var clientName =$("#clientName").val();
				var phone = $("#phone").val();
				
//				验证客户名不能为空
				if(clientName == ""){
					$.messager.alert("操作提示", "客户名称不能为空！","info");
					$("#clientName").focus();
					return false;
				}
//				验证手机号码不能为空
				if(phone ==""){
					$.messager.alert("操作提示", "手机号码不能为空！","info");
					$("#phone").focus();
					return false;
				}
			},
			success : function(data) {
				var str=jQuery.parseJSON(data);
				if(str.data=='ok'){
					//刷新父窗口表格
					$.messager.alert("操作提示", "保存成功！","info");
					var row = parent.$("#grid_order").datagrid('getSelected');
				  	var rowIndex = parent.$("#grid_order").datagrid('getRowIndex', row);
				  	parent.rowIndex = rowIndex;
					parent.$("#grid_order").datagrid("reload");
				}else{
					$.messager.alert("操作提示", "操作失败！","info");
				}
			}
		});
		//提交表单
		$('#orderForm').submit();
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
