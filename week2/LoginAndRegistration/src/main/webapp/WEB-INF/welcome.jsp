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
<div class="container d-flex ">
	<h1>Welcome  <c:out value="${user.userName}"></c:out> </h1>
	<a href="/logout" class="btn btn-danger">Logout !!</a>
</div>

<div class="container">
<div><p>Course Schedule</p></div>
<table class="table">
<thead>
<th>Class Name</th>
<th>Weekday</th>
<th>Price</th>
</thead>
<tbody>
<c:forEach var="c" items="${course}">

<tr>
<td>${c.name} <a href="/classes/${c.id}/edit">Edit</a></td>

<td>${c.weekday}</td>
<td>${c.price}</td>
</tr>
</c:forEach>
</tbody>
</table>
<div>
	<a href="/classes/new" class="btn btn-primary">+ New course</a>
</div>
</div>


</body>
</html>