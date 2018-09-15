<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录失败</title>
</head>
<body>
	<h6>登录失败！请重新登录...</h6>
	<form:form commandName="user_S" action="firstLogin_V" method="post"> 
		<fieldset>
        	<legend><spring:message code="title.login"/></legend>
        	<p>
        		<label for="id"><spring:message code="login.userID" /></label>
        		<form:input id="userID" path="id"/>
        	</p>
        	<p>
        		<label for="password"><spring:message code="login.password" /></label>
        		<form:input id="userPassword" path="password" type="password"/>
        	</p>
        	<p id="buttons">
        		<input id="submit" type="submit" tabindex="5" value="<spring:message code="login.button" />">
        	</p>
        	<p>
        		<a href="/stuManage/userRegister"><spring:message code="login.register"/></a>
        	</p>
        </fieldset>
	</form:form>
</body>
</html>