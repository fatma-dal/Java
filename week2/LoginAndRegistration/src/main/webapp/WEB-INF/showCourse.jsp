<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Course</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<div class="container mt-4">
		<div class="d-flex justify-content-between mb-4" >
			<h1>${course.name}</h1>
			<a href="/classes" class="btn btn-primary">Back to Dashboard</a>
		</div>
		<h3><Strong style="color:red">${course.user.userName}</Strong> read <Strong style="color:purple">${course.name}</Strong> by <Strong style="color:green">${course.discription}</Strong></h3>
		<h4> ${course.user.userName}</h4>
		<div class="container mt-5">
			<hr>
			<p class="mt-4 mb-4">${course.discriptions}</p>
			<hr>
			<div class="d-flex flex-row gap-3 justify-content-end mt-4">
				<c:if test="${course.user.id.equals(user_id)}">
					<a href="/classes/${course.id}/edit" class="btn btn-primary">Edit</a>
					<form action="/delete/${course.id}" method="Post">
						<input type="hidden" name="_method" value="DELETE"/>
						<button class="btn btn-danger">Delete</button>
					</form>
				</c:if>
				<c:if test="${!course.user.id.equals(user_id)}">
					<button disabled class="btn btn-primary">Edit</button>
					<form action="/delete/${course.id}" method="Post">
						<input type="hidden" name="_method" value="DELETE"/>
						<button disabled class="btn btn-danger">Delete</button>
					</form>
				</c:if>
			</div>
		</div>
	</div>



</body>
</html>