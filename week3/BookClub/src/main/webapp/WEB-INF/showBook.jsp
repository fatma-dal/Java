<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
 <%@ page isErrorPage="true" %> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
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
<meta charset="UTF-8">
<title>Read Share</title>
</head>
<body>
	<div class="container mt-4">
		<div class="d-flex justify-content-between mb-4" >
			<h1>${book.title}</h1>
			<a href="/books" class="btn btn-primary">Back to shelves</a>
		</div>
		<h3><Strong style="color:red">${book.user.userName}</Strong> read <Strong style="color:purple">${book.title}</Strong> by <Strong style="color:green">${book.author}</Strong></h3>
		<h4>Here are ${book.user.userName}'s thoughts :</h4>
		<div class="container mt-5">
			<hr>
			<p class="mt-4 mb-4">${book.thoughts}</p>
			<hr>
			<div class="d-flex flex-row gap-3 justify-content-end mt-4">
				<c:if test="${book.user.id.equals(user_id)}">
					<a href="/books/${book.id}/edit" class="btn btn-primary">Edit</a>
					<form action="/delete/${book.id}" method="Post">
						<input type="hidden" name="_method" value="DELETE"/>
						<button class="btn btn-danger">Delete</button>
					</form>
				</c:if>
				<c:if test="${!book.user.id.equals(user_id)}">
					<button disabled class="btn btn-primary">Edit</button>
					<form action="/delete/${book.id}" method="Post">
						<input type="hidden" name="_method" value="DELETE"/>
						<button disabled class="btn btn-danger">Delete</button>
					</form>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>