<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试结果</title>
</head>
<body>
	<from>
		<fieldset>
			<legend>你好，用户:${userID}</legend>
			<p>
				<textarea rows="20" cols="50" disabled="disabled" >${analysis}</textarea>
			</p>
		</fieldset>
	</from>
</body>
</html>