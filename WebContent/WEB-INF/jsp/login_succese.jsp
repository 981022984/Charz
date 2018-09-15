<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录成功</title>
</head>
<body>
	<form:form commandName="user_S" action="/stuManage/exit?userID=${userID}" method="post"> 
		<fieldset>
        	<legend>欢迎您！<c:out value="${user_S.name}" default="***"/></legend>
        	<p>
        		<a href="/stuManage/readyTest?userID=${userID}">开始考试</a>
        	</p>
        	<p>
        		<a href="/stuManage/show_information?userID=${userID}">查看信息</a>
        	</p>
        	<p>
        		<a href="/stuManage/modify_password?userID=${userID}">修改密码</a>
        	</p>
        	<p id="buttons">
        		<input id="submit" type="submit" tabindex="5" value="注销">
        	</p>
        </fieldset>
	</form:form>
</body>
</html>