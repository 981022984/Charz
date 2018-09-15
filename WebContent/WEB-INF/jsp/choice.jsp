<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>选择测试</title>
</head>
<body>
	<form:form method="post">
		<fieldset>
			<p>
				<a href="/stuManage/testInterface?userID=${userID}&tpNo=1001">大学生心理健康测试</a>
			</p>
		</fieldset>
	</form:form>
</body>
</html>