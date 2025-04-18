<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
 <%@ page isErrorPage="true" %> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

    <!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- Bootstrap 5 CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css" integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I" crossorigin="anonymous">
<!-- Font Awesome CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/styles.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Create Book</title>
</head>
<body>
<div class="container mt-4">
<div class="d-flex justify-content-between mb-5">
<h1>Change your Entry </h1>
<a href="/books" class="btn btn-primary">back to the shelves </a>
</div>
<form:form action="/books/${newBook.id}/edit" method="POST" modelAttribute="newBook" class="card p-3">

<input type="hidden" name="_method" value="PUT">
<div class="col-5 mb-4">
<form:label path="title">Title:</form:label>
<form:input path="title" class="form-control"></form:input>
<form:errors path="title" class="badge text-danger"/>
</div>

<div class="col-5 mb-4">
<form:label path="author">Author :</form:label>
<form:input path="author" class="form-control"></form:input>
<form:errors path="author" class="badge text-danger"/>
</div>

<div class="col-5 mb-4">
<form:label path="thoughts">My thoughts:</form:label>
<form:input path="thoughts" class="form-control"></form:input>
<form:errors path="thoughts" class="badge text-danger"/>
</div>
<div class="col-3">
<button class="btn btn-success">Edit</button>
</div>
</form:form>

</div>
</body>
</html>