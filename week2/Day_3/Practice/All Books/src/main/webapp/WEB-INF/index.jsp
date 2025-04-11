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

	<div class="container p-4">
		<h1 class="mb-3 text-center">All Books</h1>
		<table class="table table-striped">
		    <thead>
		        <tr>
		            <th class="table-primary">ID</th>
		            <th>Title</th>
		            <th>Language</th>
		            <th>Number of Pages</th>
		        </tr>
		    </thead>
		    <tbody>
		         <c:forEach var="book" items="${books}">
		         	<tr>
		         		<td class="table-primary">${book.id}</td>
		         		<td><a href="/books/${book.id}">${book.title}</a></td>
		         		<td>${book.language}</td>
		         		<td>${book.numberOfPages}</td>
		         	</tr>
		         </c:forEach>
		    </tbody>
		</table>
	</div>

</body>
</html>