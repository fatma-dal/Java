<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
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
		            <th>Burger Name</th>
		            <th>Restaurant Name</th>
		            <th>Rating</th>
		            <th>Action</th>
		        </tr>
		    </thead>
		    <tbody>
		         <c:forEach var="burger" items="${burgers}">
		         	<tr>
		         		<td>${burger.name}</td>
		         		<td>${burger.restName}</td>
		         		<td>${burger.rating}</td>
		         		<td><a href="/burgers/edit/${burger.id}" class="btn btn-primary">edit</a></td>
		         	</tr>
		         </c:forEach>
		    </tbody>
		</table>
		<div class="ml-5 mt-5 ">
			<h1>Add a Burger :</h1>
			<form:form modelAttribute="burger" method="POST" action="/">
	            <div>
	                
	                <form:label path="name">Burger Name : </form:label>
	                <form:input type="text" path="name" class="form-control"/>
	                <form:errors class="badge text-danger" path="name"/>
	            </div>
	            
				<div>
	                
	                <form:label path="restName">Restaurant Name : </form:label>
	                <form:input type="text" path="restName" class="form-control"/>
	                <form:errors class="badge text-danger" path="restName"/>
	            </div>
	            
	            <div>
	                
	                <form:label path="rating">Rating : </form:label>
	                <form:input type="number" path="rating" class="form-control"/>
	                <form:errors class="badge text-danger" path="rating"/>
	            </div>
	            	            
	            <div>
	                <form:label path="note">Note : </form:label>
	                <form:textarea path="note" class="form-control"></form:textarea>
	                <form:errors  class="badge text-danger"  path="note"/>
	            </div>
	            
	            <button type="submit" class="btn btn-primary">Save</button>
        	</form:form>
		</div>
	</div>
</body>
</html>