<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Dojo New</title>
</head>
<body>
	<div class="container mt-4 p-3 card" >
		<h1>New Dojo</h1>
		<form:form modelAttribute="dojo" method="POST" action="/dojo/new">
	            <div>
	                
	                <form:label path="name">Name : </form:label>
	                <form:input type="text" path="name" class="form-control"/>
	                <form:errors class="badge text-danger" path="name"/>
	            </div>
	            <div>
	            	<button class="btn btn-primary mt-3">Create</button>
	            </div>
	     </form:form>
	</div>
</body>
</html>