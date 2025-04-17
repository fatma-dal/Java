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
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div class="container p-5">
	<h1 class="text-primary">New Ninja</h1>
	<form:form class="col-6 rounded-3 bg-dark text-light p-5" action="/ninjas/new" method="post" modelAttribute="ninja">
        
        <div class="p-3">
            <form:label path="dojo">Dojo :</form:label>

            <form:select path="dojo">
            <c:forEach items="${dojos}" var="one" >
            <option value="${one.id }">${one.name }</option>
            </c:forEach>
            </form:select>
            <form:errors class="row text-danger" path="dojo"/>
        </div>
        <div class="p-3">
            <form:label path="firstName">First Name :</form:label>
            <form:input class="col-6" path="firstName"/>
            <form:errors class="row text-danger" path="firstName"/>
        </div> 
        <div class="p-3">
            <form:label path="lastName">Last Name :</form:label>
            <form:input class="col-6" path="lastName"/>
            <form:errors class="row text-danger" path="lastName"/>
        </div>
        <div class="p-3">
            <form:label path="age">Age :</form:label>
            <form:input type="number" class="col-6" path="age"/>
            <form:errors class="row text-danger" path="age"/>
        </div>
        <input class="col-4 btn btn-success m-3" type="submit" value="Create"/>
    </form:form> </div>
</body>
</html>