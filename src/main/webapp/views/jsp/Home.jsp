<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
	<title>Student Management System</title>
	<style type="text/css">
		<%@ include file="/views/css/style.css"%>
	</style>
</head>
<body>
	<div class="container">
		<h1 class="heading">Student Management System</h1>
		<ul class="nav">

		    <sec:authorize access="hasRole('ADMIN')">
		        <li><a href="addStudent">Add Student</a></li>
		        <li><a href="deleteStudent">Delete Student</a></li>
		        <li><a href="updateStudent">Update Student</a></li>
		    </sec:authorize>

		    <li><a href="viewAllStudent">Display All Student</a></li>

		</ul>
	 	<marquee><h1 class="heading">Welcome to Student Management System</h1></marquee>
		<form action="logout" method="post" style="display:inline;">

		    <input type="hidden"
		           name="${_csrf.parameterName}"
		           value="${_csrf.token}" />

		    <button type="submit">Logout</button>
		</form>
	</div>
	<div>${PrintSwal}</div>
</body>
</html>
