<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试界面</title>
</head>
<body>
	<form:form action="getScore?userID=${userID}&tpNo=${tpNo}" method="POST">
		<fieldset>	
			<legend>测试</legend>
			<c:forEach items="${tqQuestions}" var="tq">
    			<p><td>${tq.tqName}</td></p>
    			<p><input type="radio" value="${tq.scores[0]}" name="${tq.tqNo}">${tq.options[0]}</input></p>
    			<p><input type="radio" value="${tq.scores[1]}" name="${tq.tqNo}">${tq.options[1]}</input></p>
    			<p><input type="radio" value="${tq.scores[2]}" name="${tq.tqNo}">${tq.options[2]}</input></p>
				<p><input type="radio" value="${tq.scores[3]}" name="${tq.tqNo}">${tq.options[3]}</input></p>			
			</c:forEach>
			<p id="buttons">
        		<input id="submit" type="submit" tabindex="5" value="提交">
        	</p>	
		</fieldset>
	</form:form>
</body>
</html>