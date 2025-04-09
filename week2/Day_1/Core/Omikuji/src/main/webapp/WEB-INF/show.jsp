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
	<div class="container p-3">
		<div class="border p-2" style="background-color:lightblue ; width:200px;">
			<p>
				In <c:out value="${numb}"/> years,you will live in <c:out value="${city}"/> with <c:out value="${name}"/>
				as your roommate,<c:out value="${prof}"/> for living. the next time you see a <c:out value="${thing}"/>
				,you will have good luck.Also,<c:out value="${nice}"/>
			</p>
		</div>
		<a href="/omikuji">Go back</a>
	</div>
</body>
</html>