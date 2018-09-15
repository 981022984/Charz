<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<script type="text/javascript" src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="../js/json2.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#Dept").bind("change",function (){
		showDeptClass();
	});
	function showDeptClass(){
		var deptname = $("#Dept").val();   //获取所选系的名称
		$.ajax({url:"${pageContext.request.contextPath}/json/showDeptClass",
				dataType:"json",
				type : "post",
				contenType : "application/json",
				data :{"DeptName":deptname},
				async : true,
				success :function(data){	
					
					$("#ClassName").empty();
					var obj=document.getElementById('ClassName'); 
					for(var i=0;i<7;i++)
						if(data[i])     //存在班级 
						obj.options.add(new Option(data[i],data[i]));
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
	<form:form commandName="newUser" action="addNewUser" method="POST"> 
		<fieldset>
        	<legend><spring:message code="title.register"/></legend>
        	<p>
        		<td>
        			<label for="DeptName">系别: </label>
            		<form:select id="Dept" path="DeptName" items="${Dept}"/>
        		</td>
        		<td>
        			<label for="ClassName">班级: </label>
            		<form:select id="ClassName" path="ClassName">
            			<c:forEach items="${Class}" var="cla">  
                			<option value="${cla}">${cla}</option>  
        				</c:forEach>
            		</form:select>
        		</td>	
        	</p>
        	<p>
        		<label for="id"><spring:message code="login.userID" /></label>
        		<td><form:input type="text" name="userID" path="id" id="userID"/></td>
        		<td><form:errors path="id" cssStyle="color:red"/></td>
        	</p>
        	<p>
        		<label for="password1"><spring:message code="register.password1" /></label>
        		<td><form:input id="userPassword1" name="userPassword1" path="password" type="password"/></td>
        		<td><form:errors path="password" cssStyle="color:red"/></td>
        	</p>
        	
        	<p>
        		<label for="password2"><spring:message code="register.password2" /></label>
        		<input id="userPassword2" name="userPassword2" type="password"/>
        	</p>
        	<p>
        		<label for="name"><spring:message code="register.name" /></label>
        		<td><form:input id="name" name="name" path="name" type="text"/></td>
        		<td><form:errors path="name" cssStyle="color:red"/></td>
        	</p>
        	<p>
        		<label for="birthday"><spring:message code="register.birthday" /></label>
        		<td><form:input id="birthday" name="birthday" path="birthday" type="text"/></td>
        		<td><form:errors path="birthday" cssStyle="color:red"/></td>
        	</p>

        	<p id="buttons">
        		<input id="submit" type="submit" tabindex="5" value="<spring:message code="register" />">
        	</p>
        </fieldset>	
   </form:form>	
</body>
</html>