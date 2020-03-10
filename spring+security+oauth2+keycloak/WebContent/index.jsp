<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page session="false" %><!-- 勝手にSessionオブジェクトを生成しないようにする -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
	
  </head>
  
  <body>
<%--    	<a href="<%=basePath%>user/getAllUser">进入用户管理页</a> --%>

<h2>Logged in!</h2>
<a href="/SpringMVCMbaits/userinfo">Get user information.</a>
<form action="/SpringMVCMbaits/logout" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input name="login" value="Logout" type="submit"/>
</form>
</body>
</html>