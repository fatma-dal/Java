<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>
	<div class="container d-flex flex-column p-3  ">
		<h1 class="mb-5" style="color:pink"> Fruit Store</h1>
		<table class="table table-striped" style="border:35px solid pink">
			<thead>
				<tr>
					<th>Name</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${fruits}">
					<tr>
						<td><c:out value="${item.name}"></c:out> </td>
						<td><c:out value="${item.price}"></c:out> </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>