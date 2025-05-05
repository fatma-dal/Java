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
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   <div class="container mt-3">
   	<div class="d-flex justify-content-between mt-3">
   		<h1>All Cars</h1>
   		<div>
   			<a href="/cars/new" class="btn btn-info">Create</a>
   			<a href="/logout" class="btn btn-danger">Logout</a>
   		</div>
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
   					<td> <a href="/cars/show/${car.id }"> ${car.model} </a> </td>
   					<td> ${car.color} </td>
   					<td> ${car.owner.userName} </td>
   					<td> 
   						<a class="btn btn-primary" href="/cars/edit/${car.id }">Edit</a>
   						<form action="/cars/${car.id }" method="post">
   							<input type="hidden" name="_method" value="delete">
   							<input class="btn btn-danger" type="submit" value="Delete"></input>
   						</form>
   					</td>
   				</tr>
   			</c:forEach>
   		</tbody>
   	</table>
   </div>
</body>
</html>

