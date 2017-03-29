<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>报修表单基本信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/easyui.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/common.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/SYS.css" type="text/css" />
</head>
<body>
<div class="wrapper details notblbew" id="js_layout">
    <div data-options="region:'center'" class="noborder" style="overflow:hidden;">
        <div class="easyui-tabs" data-options="tools:'#tab-tools'" id="tabs"> 
            <div title="报修单基本信息" data-options="" class="pad10 relative" id="tab1">
                <form id="repairForm" method="post">
                
                <input type="hidden" name="id" value="${repairInfo.id}"  />
       			
                <table class="forms" style="table-layout:fixed;">
                    <tbody>
                    	<tr>
                            <td class="right" width="120"></td>
                            <td width="300"></td>
                            <td class="right" width="120"></td>
                            <td width="300"></td>
                        </tr>
                    	<tr>
                    		<td class="right"><i class="require">*</i>报修编号：</td>
                    		<td><input class="txt" id="repairId" name="repairId" type="text" value="${repairInfo.repairId}" readonly="readonly"/>
                    		</td>
                    		<td class="right"><i class="require">*</i>楼盘(小区)名称：</td>
                    		<td>
                    			<input class="txt" id="buildName" name="buildName" type="text" value="${repairInfo.buildName}"/>
                    		</td>
                    		
                    	</tr>
                    	
                    	
                    	<tr>
                    		<td class="right"><i class="require">*</i>客户姓名：</td>
                    		<td>
                    			<input class="txt" id="clientName" name="clientName" type="text" value="${repairInfo.clientName}" />
                    		</td>
                    		<td class="right">性别：</td>
                    		<td>
                    			<label for="sex_1">男<input type="radio" value="男" name="sex" id="sex_1" style="vertical-align:middle"/></label>&nbsp;&nbsp;
                    			<label for="sex_2">女<input type="radio" value="女" name="sex" id="sex_2" style="vertical-align:middle"/></label>
                    		</td>
                    	</tr>
                    	
                    	<tr>
                    			<td class="right" width="10%">原设计师：</td>
                    		    <td>
	                    			<select name="chargeDesigner" id="chargeDesigner" class="easyui-combobox" 
	                    			data-options="panelHeight:'200',editable : false,
	                    			valueField: 'designerName',      
	                     			textField: 'designerName',
				                    url:'${pageContext.request.contextPath}/admin/listAllDesigner',
				                    onLoadSuccess:function(data){
				                    	var chargeDesigner = '${repairInfo.chargeDesigner }';
				                    	if(chargeDesigner!=''){
				                   			$('#chargeDesigner').combobox('setValue',chargeDesigner);
				                   		}
				                    }"
	                    			 style="width:247px;">
	                    			 	<option>===请选择===</option>
	                    			</select>
                    		   </td>  
                    		
     
                    		<td class="right" width="10%">原工程经理：</td>
                    		<td><input class="txt" id="chargeManager" name="chargeManager" type="text" value="${repairInfo.chargeManager}" /></td>	
                    	</tr>
                    	
                    	<tr>
                    		
                    		<td class="right" width="10%"><i class="require">*</i>客户手机号：</td>
                    		<td><input class="txt" id="phone" name="phone" type="text" value="${repairInfo.phone}" /></td>
                    		<td class="right">行政区域：</td>
                    		 <td>
                    		 	<div id="city"> 
								    <select id="sheng_1" class="prov" style="width:70px;"></select>
								    <select id="shi_2" class="city" disabled="disabled" style="width:85px;"></select>
								    <select id="qu_3" class="dist" disabled="disabled" style="width:85px;"></select> 
								</div>
                    			<input class="txt" id="address" name="address" type="hidden" value="${repairInfo.address}" />
                    		 </td>
                    	</tr>
                    	
                    	<tr>
                    		 
                            <td class="right"><i class="require">*</i>维修类别:</td>
                    		<td>
                    			<select name="repairType" id="repairType" class="easyui-combobox" 
                    			data-options="panelHeight:'auto',editable : false,
                    			valueField: 'id',      
                     			textField: 'text',
                     			url:'${pageContext.request.contextPath}/static/www/json/repair_type.json',
                     			onLoadSuccess:function(data){
			                    	var repairType = '${repairInfo.repairType}';
			                    	if(repairType!=''){
			                   			$('#repairType').combobox('setValue',repairType);
			                   		}
			                   			
			                   		
			                    }" style="width:247px;">
                    			 	<option>===请选择===</option>
                    			</select>
                    		</td>
                    		<td class="right" width="10%">维修单状态：</td>
                    		<td><!-- 1正常2待审3删除 -->
                    			
                    			<label for="status1"><span style="color:red;font-weight: bold;">未处理</span><input type="radio" value="0" name="repairStatus" checked="checked" id="status1" style="vertical-align:middle"/></label>
                    			<label for="status2"><span style="color:#FFD700;font-weight: bold;">处理中</span><input type="radio" value="1" name="repairStatus" id="status2" style="vertical-align:middle"/></label>
                    			<label for="status3"><span style="color:#00EE00;font-weight: bold;">已处理</span><input type="radio" value="2" name="repairStatus" id="status3" style="vertical-align:middle"/></label>
                    
                    		</td>
      
                    	</tr>
                    	
                    	<tr>
                    		<td class="right" width="10%">装修开工日期：</td>
                    		<td><input class="easyui-datebox" id="startDate" name="startDate" type="text" style="width:248px;" value="<fmt:formatDate value="${repairInfo.startDate}" pattern="yyyy-MM-dd"/>" />
                    		<%-- <td><input class="txt" id="startDate" name="startDate" type="text" value="${empty repairInfo.startDate ? sessionScope.repairInfo.startDate : repairInfo.startDate}" /></td> --%>
                    		<td class="right" width="10%">预约维修时间：</td>
                    		<td><input class="easyui-datetimebox" id="repairTime" name="repairTime" type="text" style="width:248px;" value="<fmt:formatDate value="${repairInfo.repairTime}" pattern="yyyy-MM-dd HH:mm:ss"/>" />
                    			<c:if test='${sessionScope.Role.roleName!="超级管理员" }'>
                    			<!-- 用户隶属分公司信息 -->
                    			<input type="hidden" id="branchCompany" name="branchCompany" value="${empty repairInfo.branchCompany ? sessionScope.Role.branchCompany : repairInfo.branchCompany}"/>
                    			</c:if>
                    		</td>
                    	</tr>
                    	<c:if test='${sessionScope.Role.roleName=="超级管理员" }'>
                    	<tr>
                    		<td class="right" width="10%"><i class="require">*</i>隶属分公司：</td>
                    		<td colspan="3">
                    			<select name="branchCompany" id="branchCompany" class="easyui-combobox" 
                    			data-options="panelHeight:'auto',editable : false,
                    			valueField: 'id',
                     			textField: 'text',
                     			url:'${pageContext.request.contextPath}/static/www/json/scinter_company.json',
                     			onLoadSuccess:function(data){
			                    	var status = '${repairInfo.branchCompany }';
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
                    		<td class="right" width="10%"><i class="require"></i>备注：</td>
                    		<td colspan="3">
                    			<textarea id="note" name="note" style="width:790px;height:120;">${repairInfo.note }</textarea>
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
	
	//选择在线报修状态
	var status = '${repairInfo.repairStatus}';
	if(status=="0"){		
		$("#status1").attr("checked","checked");
	}
	if(status=="1"){
		$("#status2").attr("checked","checked");
	}
	if(status=="2"){
		$("#status3").attr("checked","checked");
	}
	
//	判断是否包含报修单的编号
	var repairId = $("#repairId").val();
	if(repairId == ""){
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
   	  $("#repairId").val(dateTime);
	}
	//设置性别的基本信息
	var sex_mes = '${repairInfo.sex}';

	if(sex_mes == "男"){
		$("#sex_1").attr("checked","checked");
	}else{
		$("#sex_2").attr("checked","checked");
	}
	//设置easyui-datebox日期只读
	$(".datebox :text").attr("readonly","readonly");
	$(".datetimebox :text").attr("readonly","readonly");
	
	//省市联动初始化
	var address = $("#address").val();
	if(address.length>0){
		var addressArr = address.split(",");
		$("#city").citySelect({
		    url:"${pageContext.request.contextPath}/static/www/scripts/city.min.json",
		    prov:addressArr[0], //省份  
		    city:addressArr[1], //城市  
		    dist:addressArr[2], //区县  
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
	
		
		$('#repairForm').form({
		    url:'${pageContext.request.contextPath}/admin/saveRepair',
			onSubmit : function() {
				
				//行政区域赋值
				var address = $("#sheng_1").val()+","+$("#shi_2").val()+","+$("#qu_3").val();
				$("#address").val(address);
				
				//进行用户名的非空验证
				var clientName = $("#clientName").val();
				
				/* var repairType = $("#repairType").val(); */
				if(clientName==""){
					$.messager.alert("操作提示", "客户名称不能为空！","info");
					$("#clientName").focus();
					return false;
				}
				//进行楼盘名称非空验证
				var buildName = $("#buildName").val();
				if(buildName==""){
					$.messager.alert("操作提示", "楼盘名称不能为空！","info");
					$("#buildName").focus();
					return false;
				}
				
				//进行客户手机号非空验证
				var phone = $("#phone").val();
				if(phone==""){
					$.messager.alert("操作提示", "手机号不能为空！","info");
					$("#phone").focus();
					return false;
				}
				
			},
			success : function(data) {
				var str=jQuery.parseJSON(data);
				if(str.data=='ok'){
					//刷新父窗口表格
					$.messager.alert("操作提示", "保存成功！","info");
					var row = parent.$("#grid_repair").datagrid('getSelected');
				  	var rowIndex = parent.$("#grid_repair").datagrid('getRowIndex', row);
				  	parent.rowIndex = rowIndex;
					parent.$("#grid_repair").datagrid("reload");
				}else{
					$.messager.alert("操作提示", "操作失败！","info");
				}
			}
		});
		//提交表单
		$('#repairForm').submit();
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
