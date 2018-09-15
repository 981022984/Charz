<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的信息</title>
<script type="text/javascript" src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="../js/json2.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#b2").click(function(){
		testAjaxJson();
	});
	var id = $("#userID").val();
	var name = $("#userName").val();
	//alert(JSON.stringify({"id":id,"name":name}));
	function testAjaxJson(){
		$.ajax({url:"${pageContext.request.contextPath}/json/showCategory",			
					dataType :"json",
					type : "post",
					contenType : "application/json",
					data :{"id":id,"name":name},
					async : true,
					success :function(data){
						var stu = JSON.stringify(data);
						//alert(stu);
						$("#className").html(data.className);
					},
					error :function(){
						alert("数据传输失败");
					}
				});
	}
});
</script>
</head>
<body>
	<form:form commandName="user_S" action="/stuManage/backLoginSuccese/${user_S.id}" method="get"> 
		<fieldset>
       	 	<legend>我的信息</legend>
       	 	<input id="userID" type="hidden" value="${user_S.id}"/>
       	 	<input id="userName" type="hidden" value="${user_S.name}">
       	 	<p>
       	 		<label for="name">姓名：</label>
        		<c:out value="${user_S.name}" default="123"/>
        	</p>
        	<p>
        		<label for="id">学号：</label>
        		<c:out value="${user_S.id}" default="123"/>
        	</p>
        		班级：<span id="className"></span><br>
        	<p id="button1">
        		<input id="submit" type="submit" tabindex="5" value="返回">
        	</p>
        	<p id="button2">
        		<input id="b2" type="button" tabindex="6" value="班级">
        	</p>
    	</fieldset>
    </form:form>
</body>
</html>