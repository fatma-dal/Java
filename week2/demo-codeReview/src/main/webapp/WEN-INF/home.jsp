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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	
	<div class="d-lex justify-content-between mt-3">
	<h1>All Cars</h1>
	<div>
	<a href="/cars/new" class="btn btn-danger">Create</a>
	<a href="/logout" class="btn btn-danger">Logout !!</a>
	</div>
	<table class="table">
	<thead>
	<tr>
	<th>Model</th>
	<th>Color</th>
	<th>Owner</th>
	<th>Actions</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${allCars }" var="car">
	<tr>
	<td><a href ="/cars/show/${car.id }">${car.model }</a></td>
	<td>${car.model }</td>
	<td>${car.model }</td>
	<td>
	<a class="btn btn-primary" href="/cars/edit/${car.id }">Edit </a>
	<form action="/cars/${car.id }" method="post">
	<input type="hiden" name="_method" value="delete">
	<input type="Submit" value="Delete">
	</form>
	</td>
	</tr>
	</c:forEach></tbody>
	</table>
	</div>
	
</div>
</body>
</html>