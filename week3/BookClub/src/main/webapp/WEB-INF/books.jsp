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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Books</title>
</head>
<body>
	<div class="container mt-4">
		<div class="d-flex justify-content-between items-aling-center">
			<div>
				<h1>Welcome ,${user.userName}</h1>
				<p> Books from everyone's shelves :
			</div>
			<div class="d-flex flex-column gap-4">
				<a href="/logout" class="btn btn-danger">Logout !!</a>
				<a href="/books/new" class="btn btn-primary">+Add a to my shelf!</a>
			</div>	
		</div>
		<table class="table table-Striped mt-4">
			<thead>
				<tr>
					<th class="table-secondary">Id</th>
					<th>Title</th>
					<th>Author Name</th>
					<th>Posted By</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${books}">
					<tr>
						<td class="table-secondary" >${book.id}</td>
						<td><a href="/books/${book.id}">${book.title}</a></td>
						<td>${book.author}</td>
						<td>${book.user.userName}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>