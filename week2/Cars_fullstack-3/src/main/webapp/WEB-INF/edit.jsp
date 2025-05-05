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
   <form:form action="/cars/update/${car.id }" method="post" modelAttribute="car">
   		<input type="hidden" name="_method" value="put">
   		
   		<form:label path="model" class="form-label">Model</form:label>
   		<form:input path="model"  class="form-control"/>
   		<form:errors path="model"  class="text-danger"/>
   		<br>
   		<form:label path="color" class="form-label">Color</form:label>
   		<form:input path="color"  class="form-control"/>
   		<form:errors path="color"  class="text-danger"/>
   		<br>
   		<form:label path="price" class="form-label">Price</form:label>
   		<form:input path="price" type="number" class="form-control"/>
   		<form:errors path="price"  class="text-danger"/>
   		<br>
   		<form:label path="releaseDate" class="form-label">Release Date</form:label>
   		<form:input path="releaseDate" type="date" class="form-control"/>
   		<form:errors path="releaseDate"  class="text-danger"/>
   		<br>
   		<input type="submit" value="Update" class="btn btn-success">
   		
   </form:form>
</body>
</html>

