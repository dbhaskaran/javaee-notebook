<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Create Student</title>
</head>
<body>
<!-- Default form contact -->
<div class="col-sm-2" style="background-color: #eee;">
<form class="text-center border border-light p-5" action="saveStudent" method="post">

    <p class="h4 mb-4">Create Student</p>
    <input type="text" name="name" class="form-control" placeholder="Enter Name">
    <input type="text" name="course" class="form-control" placeholder="Enter Course">
    <input type="text" name="fee" class="form-control" placeholder="Enter Fee">
    <!-- Send button -->
    <button class="btn btn-primary" type="submit">Send</button>

</form>
</div>
${msg}
<a href="displayStudents">View All</a>
</body>
</html>