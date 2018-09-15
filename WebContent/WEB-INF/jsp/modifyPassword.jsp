<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
</head>
<body>
	<form:form commandName="user" action="confirm" method="post"> 
		<fieldset>
       	 	<legend>密码修改</legend>
       	 	<!--<c:set var="id" value="${user.id}" scope="request"/>-->
       	 	<input type="hidden" name="userID" value="${user.id}">
       	 	<p>
       	 		<label for="name">用户名：</label>
        		<c:out value="${user.id}" default="123"/>
        	</p>
       	 	<p>
        		<label>原&nbsp;&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
        		<input id="oldPassword" name="oldPassword" type="password"/>
        	</p>
        	<p>
        		<label>新&nbsp;&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
        		<input id="newPassword1" name="newPassword1" type="password"/>
        	</p>
        	<p>
        		<label>确认新密码：</label>
        		<input id="newPassword2" name="newPassword2" type="password"/>
        	</p>
        	<p id="buttons">
        		<input id="submit" type="submit" tabindex="5" value="确认">
        	</p>
       	</fieldset>
    </form:form>
</body>
</html>