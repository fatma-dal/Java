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
		<h1 class="text-center">Send an Omikuji!</h1>
		<div class="border p-3">
			<form class="col-6 border rounded p-5 " action="/postForm" method="POST">
            <div class="form-group">
                <label for="numb">Pick any number from 5 to 25</label>
                <input type="number" class="form-control"  name="numb">
              </div>
             <div class="form-group">
               <label for="city">Enter the name of any city:</label>
               <input type="text" class="form-control"  name="city">
             </div>
             <div class="form-group">
               <label for="name">Enter the name of any real person:</label>
               <input type="text" class="form-control"  name="name">
             </div>
             <div class="form-group">
               <label for="prof">Enter professional endeavor or hobby:</label>
               <input type="text" class="form-control"  name="prof">
             </div>
             <div class="form-group">
               <label for="thing">Enter any type of living thing:</label>
               <input type="text" class="form-control" name="thing">
             </div>
             <div class="form-group">
               <label for="nice">Say something nice to someone :</label>
               <textarea class="form-control"  name="nice" rows="" cols=""></textarea>
             </div>
             <p>Send and show a friend</p>
             <div class="text-end">
                  <button type="submit" class="btn btn-primary">Send</button>
             </div>
        </form>
        
		</div>
	</div>
</body>
</html>