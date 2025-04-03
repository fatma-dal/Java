<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Customer Name : <c:out value="${name}"></c:out></h1>
	<p> <strong>Item name :</strong> <c:out value="${itemName}"></c:out> </p>
	<p><strong>Price :</strong> <c:out value="${price}"></c:out> </p>
	<p><strong>Description :</strong> <c:out value="${description}"></c:out> </p>
	<p><strong>Vendor :</strong> <c:out value="${vendor}"></c:out> </p>
</body>
</html>