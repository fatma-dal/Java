<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div class="container p-5">
	<div class="d-flex justify-content-between align-items-center p-5">
	<h1 class="">Your Gold : <span class="border border-3 ms-3 p-1">${gold}</span></h1>
	<form action="/form" method="POST" >
			<input type="hidden" name='name' value="reset">
			<button class="btn btn-danger">Reset</button>
	</form>
	</div>
	<div class="row m-5">
		<form action="/form" method="POST" class="col border border-3 rounded border-dark p-4 m-1 text-center">
			<h2>Farm</h2>
			<input type="hidden" name='name' value="farm">
			<p>(earns 10-20 gold)</p>
			<button class="btn btn-primary">Find Gold!</button>
		</form>
		<form action="/form" method="POST" class="col border border-3 rounded border-dark p-4 m-1 text-center">
			<h2>Cave</h2>
			<input type="hidden" name='name' value="cave">
			<p>(earns 5-10 gold)</p>
			<button class="btn btn-success">Find Gold!</button>
		</form>
		<form action="/form" method="POST" class="col border border-3 rounded border-dark p-4 m-1 text-center">
			<h2>House</h2>
			<input type="hidden" name='name' value="house">
			<p>(earns 2-5 gold)</p>
			<button class="btn btn-info">Find Gold!</button>
		</form>
		<form action="/form" method="POST" class="col border border-3 rounded border-dark p-4 m-1 text-center">
			<h2>Quest</h2>
			<input type="hidden" name='name' value="quest">
			<p>(earns/takes 0-50 gold)</p>
			<button class="btn btn-warning">Find Gold!</button>
		</form>
		<form action="/form" method="POST" class="col border border-3 rounded border-dark p-4 m-1 text-center">
			<h2>Spa</h2>
			<input type="hidden" name='name' value="spa">
			<p>(loose 5-20 gold)</p>
			<button class="btn btn-warning">Go to Spa</button>
		</form>
	</div>
	<div class="m-5">
		<h3 class="m-3">Activities:</h3>
		<div class="border border-3 border-dark p-3">
			<c:forEach var="msgn" items="${earns}">
				<p class="text-success">${msgn}</p>
			</c:forEach>
			
			<c:forEach var="msgF" items="${lose}">
				<p class="text-danger">${msgF}</p>
			</c:forEach>
		</div>
	</div>
</div>
</body>
</html>