<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        .page-header {
            border-bottom: 1px solid #000;
            padding-bottom: 10px;
            margin-bottom: 25px;
        }

    </style>
    <title>Add a Book</title>
</head>



<body class="container mt-4">
    <div class="page-header d-flex justify-content-between align-items-center">
        <h2>Add car !</h2>
        <a href="/home" class="text-primary">Go Back</a>
    </div>
    <div class="row">
        <div class="col-md-8">
            <form:form modelAttribute="Books" action="/books/create" method="POST">
                <div class="form-group mb-3">
                    <form:label path="model">model</form:label>
                    <form:input path="model" class="form-control"/>
                    <form:errors path="model" class="text-danger"/>
                </div>

                <div class="form-group mb-3">
                    <form:label path="color">color</form:label>
                    <form:input path="color" class="form-control"/>
                    <form:errors path="color" class="text-danger"/>
                </div>
                <div class="form-group mb-3">
                    <form:label path="price">price</form:label>
                    <form:input path="price" type="number" class="form-control"/>
                    <form:errors path="price" class="text-danger"/>
                </div>
                 <div class="form-group mb-3">
                    <form:label path="price">Release Date</form:label>
                    <form:input path="price" type="date" class="form-control"/>
                    <form:errors path="price" class="text-danger"/>
                </div>
                <div class="text-end mt-4">
                    <button class="btn btn-dark">Submit</button>
                </div>
            </form:form>
        </div>

        <div class="col-md-4">
        </div>
    </div>

</body>
</html>