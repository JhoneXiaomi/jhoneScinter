<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page language="java" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>UserList</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<%--用EL表达式直接调用属性循环输出对象的各个属性值--%>
<table border="1">
	<c:forEach items="${userList }" var="user">
		<tr>
			<td>${user.userId}</td>
			<td>${user.nickName}</td>
			<td>${user.creater}</td>
			<td><fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
		</tr>
	</c:forEach>
</table>

<div id="content">
	<a id="example1" href="${pageContext.request.contextPath}/static/www/images/big_1.jpg"><img src="${pageContext.request.contextPath}/static/www/images/logo.png" /></a>
	<a id="example2" href="${pageContext.request.contextPath}/static/www/images/big_1.jpg"><img src="${pageContext.request.contextPath}/static/www/images/logo.png" /></a>
</div>
<script src="${pageContext.request.contextPath}/static/www/scripts/jquery.1.3.2.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/www/scripts/jquery.imgbox.pack.js" type="text/javascript" charset="utf-8"></script>
<script>
$(function(){
	$("#example1").imgbox();
	$("#example2").imgbox({
		'speedIn'		: 0,
		'speedOut'		: 0,
		'alignment'		: 'center',
		'overlayShow'	: true,
		'allowMultiple'	: false
	});
});
</script>


</body>
</html>