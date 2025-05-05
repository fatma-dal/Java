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
    <title>Edit Course</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   <div class="container mt-4">
<div class="d-flex justify-content-between mb-5">
<h1>Edit Course </h1>
<a href="/classes" class="btn btn-primary">back to Dash </a>
</div>
<form:form action="/classes/${newCourse.id}/edit" method="POST" modelAttribute="newCourse" class="card p-3">

<input type="hidden" name="_method" value="PUT">
<div class="col-5 mb-4">
<form:label path="name">Classe Name:</form:label>
<form:input path="name" class="form-control"></form:input>
<form:errors path="name" class="badge text-danger"/>
</div>
<div class="col-5 mb-4">
<form:label path="price">Price:</form:label>
<form:input path="price" class="form-control"></form:input>
<form:errors path="price" class="badge text-danger"/>
</div>

<div class="col-5 mb-4">
<form:label path="weekday">Weekday:</form:label>
<form:input path="weekday" class="form-control"></form:input>
<form:errors path="weekday" class="badge text-danger"/>
</div>


<div class="col-5 mb-4">
<form:label path="discription">Discription:</form:label>
<form:input path="discription" class="form-control"></form:input>
<form:errors path="discription" class="badge text-danger"/>
</div>
<div class="col-3">
<button class="btn btn-success">Edit</button>
</div>
  <a href="/delete/${newCourse.id}" class="btn btn-success">Delete</a> 

</form:form>
</body>
</html>

