<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<div class="container">


	<h2>Register</h2>

	<div class="container">
		<form:form action="/register" modelAttribute="newUser" class="form-control" method="post">
		
			<div class="form-row">
			 	
				<form:label for="userName" path="userName">User Name:</form:label>
				<form:input type="text" path="userName" class="form-control"/>
				<form:errors path="userName" class="badge text-danger"/>
			</div>
			
			<div class="form-row">
				
				<form:label for="email" path="email">Email:</form:label>
				<form:input type="text" path="email" class="form-control"/>
				<form:errors path="email" class="badge text-danger"/>
			</div>
			
			<div class="form-row">
				
				<form:label for="password" path="password">Password:</form:label>
				<form:input type="pasword" path="password" class="form-control"/>
				<form:errors path="password" class="badge text-danger"/>
			</div>
			
			<div class="form-row">
				
				<form:label for="" path="confirm">Confirm:</form:label>
				<form:input type="confirm" path="confirm" class="form-control"/>
				<form:errors path="confirm" class="badge text-danger"/>
			</div>
			
			<div class="form-row">
				<input type="submit" value="Register" class="btn btn-primary  mt-3"/>
			</div>
			
		</form:form>
	</div>
	<hr>
	<h2>Log In</h2>

	<div class="container">
		<form:form action="/login" modelAttribute="newLogin" class="form-control" method="post">
			<div class="form-row">
				
				<form:label for="email" path="email">Email:</form:label>
				<form:input type="text" path="email" class="form-control"/>
				<form:errors path="email" class="badge text-danger"/>
			</div>
			
			<div>
				
				<form:label for="password" path="password">Password:</form:label>
				<form:input type="password" path="password" class="form-control"/>
				<form:errors path="password" class="badge text-danger"/>
			</div>
			
			<div class="form-row">
				<input type="submit" value="Login" class="btn btn-primary  mt-3"/>
			</div>
		
		</form:form>
	</div>
</div>
</body>
</html>
