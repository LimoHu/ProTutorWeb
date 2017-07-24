<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<script src="static/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
$(function(){
	$.ajax({
		type:"get",  
        url:"",  
        dataType:"json",  
        success:function(data){
        	
        },
        error:function(data){
        	console.log("请求出错！");
        }
	});
});

</script>
</head>
<body>
<div style="margin-top:200px;margin-left: 300px; ">
	
		<table border="1" style="text-align: center;border:">
			<tr>
				<th width="100px;">id</th>
				<th width="100px;">name</th>
				<th width="100px;">price</th>
				<th width="100px;">detail</th>
				<th width="100px;">pic</th>
				<th width="200px;">createtime</th>
			</tr>
			
		<c:forEach items="${itemsList}" var="item">
			<tr>
				<td>${item.id}</td>
				<td>${item.name}</td>
				<td>${item.price}</td>
				<td>${item.detail}</td>
				<td>${item.pic}</td>
				<td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
			</tr>
		</c:forEach>
		
		</table>
	
	</div>
</body>
</html>