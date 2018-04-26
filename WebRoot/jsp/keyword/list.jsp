<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>index</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
   
  	<%--<form action="user/saveuser"  method="post">
  	  	<input type="hidden" name="id" value="-1" />
  	
  	<table>
  		<tr>
  			 
  			<th>账号</th>
  			<td><input type="text"  name="username" /> </td>
  		</tr>
  		<tr>
  			 
  			<th>密码</th>
  			<td><input type="text"  name="password" /></td>
  		</tr>
  		<tr>
  			<td colspan="2"><input type="submit" value="添加"> </td>
  		</tr>
  	</table>
  	</form>
  	
  	--%><table>
  		<tr>
  			<th>id</th>
  			<th>关键词</th>
  		</tr>
  		 
  		<c:forEach items="${keywordlist}"  var="keyword">
     	<tr>
  			<td>${keyword.id}</td>
  			<td>${keyword.keys}</td>
  			<%--<td><a href="user/edituser?id=${user.id}">修改</a>&nbsp;&nbsp;&nbsp;<a href="user/deluser?id=${user.id}">删除</a> </td>
  		--%></tr>
     </c:forEach>
  	</table>
    
  </body>
</html>
