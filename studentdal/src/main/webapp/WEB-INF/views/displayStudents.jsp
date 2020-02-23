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
<title>Display Student</title>
</head>
<body>

	<h2>Students:</h2>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Course</th>
			<th>Fee</th>
		</tr>
			<c:forEach items="${students}" var="student">
			<tr>
			<td>${student.id}</td>
			<td>${student.name}</td>
			<td>${student.course}</td>
			<td>${student.fee}</td>
			<td><a href="deleteStudent?id=${student.id}">Delete</a></td>
			<td><a href="editStudent?id=${student.id}">Edit</a></td>
			</tr>
			</c:forEach>
		<a href="createStudent">Add Student</a>
	</table>
</body>
</html>