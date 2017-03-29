<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>留言评论</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/easyui.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/common.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/www/css/SYS.css" type="text/css" />
</head>
<body>
<div class="wrapper details notblbew" id="js_layout">
    <div data-options="region:'center'" class="noborder" style="overflow:hidden;">
        <div class="easyui-tabs" data-options="tools:'#tab-tools'" id="tabs"> 
            <div title="留言评论" data-options="" class="pad10 relative" id="tab1">
                <form id="commentForm" method="post"> 
                <input type="hidden" name="commentId" id="commentId" value="${commentInfo.commentId}"/>
                <table class="forms" style="table-layout:fixed;">
                    <tbody>
                    	<tr>
                            <td class="right" width="120"></td>
                            <td width="300"></td>
                            <td class="right" width="120"></td>
                            <td width="300"></td>
                        </tr>
                        
                    	<tr>
                    		<td class="right"><i class="require">*</i>访客姓名：</td>
                    		<td>
                    			<input class="txt" id="visitorName" name="visitorName" type="text" value="${commentInfo.visitorName}"/>
                    		</td>
                    		<td class="right"><i class="require">*</i>访客电话：</td>
                    		<td>
                    			<input class="txt" id="visitorPhone" name="visitorPhone" type="text" value="${commentInfo.visitorPhone}" />
                    		</td>
                    	</tr>
                    	
                    	<tr>
                    		<td class="right">留言分类：</td>
                  			<td>                  				
                    			
								<select name="type" id="type" class="easyui-combobox" 
	                    			data-options="panelHeight:'auto',editable : false,
	                    			valueField: 'id',      
	                     			textField: 'text',
	                     			url:'${pageContext.request.contextPath}/static/www/json/comment_type.json',
	                     			onLoadSuccess:function(data){
				                    	var type = '${commentInfo.type}';
				                    	if(type!=''){
				                   			$('#type').combobox('setValue',type);
				                   		}
				                    }" style="width:247px;">
	                    			 		<option>===请选择===</option>
                    			</select>                         			
                    		 </td>
                    		<td class="right" width="10%">状态：</td>
                    		<td>
							   <select name="status" id="status" class="easyui-combobox" 
	                    			data-options="panelHeight:'auto',editable : false,
	                    			valueField: 'id',      
	                     			textField: 'text',
	                     			url:'${pageContext.request.contextPath}/static/www/json/comment_status.json',
	                     			onLoadSuccess:function(data){
				                    	var status = '${commentInfo.status}';
				                    	if(status!=''){
				                   			$('#status').combobox('setValue',status);
				                   		}
				                    }" style="width:247px;">
	                    			 		<option>===请选择===</option>
                    			</select>                   				
                    		</td>
                    	</tr>
                    	
                    	<tr>
                    		
                    		<td class="right">访客Ip</td>
                    		<td>
                    			<input class="txt" id="visitorIp" name="visitorIp" type="text" value="${commentInfo.visitorIp}" />
                    		</td>
                    		
                    		<td class="right" width="10%">关联案例：</td>
                    		<td>
                    			<a class="ublue" style="margin-left:3px;" href="${pageContext.request.contextPath}/admin/showCase?caseId=${commentInfo.caseId}">济南水岸世家 170平法式室内装修设计</a>
                    			<input type="hidden" id="caseId" name="caseId" value="${commentInfo.caseId}">                		
                    		</td>
                    	</tr>
                    	
                    	<tr>
                    		<td class="right" width="10%">留言时间：</td>
                    		<td colspan="3"><input class="txt" disabled="disabled" id="createTime" name="createTime" type="text" value="<fmt:formatDate value="${commentInfo.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>" />
                    	</tr>
                    	
                    	<tr>
                    		<td class="right" width="10%"><i class="require"></i>评论内容:</td>
                    		<td colspan="3">
                    			<textarea id="commentDesc" name="commentDesc" style="width:450px;height:120px;">${commentInfo.commentDesc}</textarea>
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
	//设置easyui-datebox日期只读
	$(".datebox :text").attr("readonly","readonly");
	$(".datetimebox :text").attr("readonly","readonly");
	$("#visitorIp").prop('readonly','readonly');
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
		
	  $('#commentForm').form({
		    url:'${pageContext.request.contextPath}/admin/saveComment',
			onSubmit : function() {
				//保存之前验证访客姓名、访客电话不为空
				var visitorName = $("#visitorName").val();
				var visitorPhone = $("#visitorPhone").val();
				
				if(visitorName==""){
					$.messager.alert("操作提示", "访客姓名不能为空！","info");
					$("#visitorName").focus();
					return false;
				}
				if(visitorPhone==""){
					$.messager.alert("操作提示", "访客电话不能为空！","info");
					$("#visitorPhone").focus();
					return false;
				}
				
			},
			success : function(data) {
				var str=jQuery.parseJSON(data);
				if(str.data=='ok'){
					//刷新父窗口表格
					$.messager.alert("操作提示", "保存成功！","info");
					var row = parent.$("#grid_comment").datagrid('getSelected');
				  	var rowIndex = parent.$("#grid_comment").datagrid('getRowIndex', row);
				  	parent.rowIndex = rowIndex;
					parent.$("#grid_comment").datagrid('reload');
				}else{
					$.messager.alert("操作提示", "操作失败！","info");
				}
			}
		});
		//提交表单
		$('#commentForm').submit(); 
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
