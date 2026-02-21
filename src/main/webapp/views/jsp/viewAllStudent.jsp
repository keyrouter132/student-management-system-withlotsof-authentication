<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Display All Student</title>
	
	<style type="text/css">
	<%@ include file="/views/css/style.css"%>
	

table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  border: 1px solid black;
  padding: 10px;
}

th {
  background-color: lightgray;
}

table tr:hover {
  background-color: lightblue;
}

th, td {
  font-size: 12px;
  font-family: Arial, sans-serif;
  font-weight: bold;
}
	
	</style>
	
 <!-- 	<link rel="stylesheet" href="css/style.css" />  -->
</head>
<body>

	<div class="container">
		<h1 class="heading">Student Management System</h1>
		<ul class="nav">
			<li><a href="/">Home</a></li>
		</ul>
		<h2 class="heading">Display All Student</h2>
        <div class="add-form">
         <table>
			<c:forEach var="student" items="${students}">
			    <tr>
			        <td>${student.sno}</td>
			        <td>${student.name}</td>
			        <td>${student.dob}</td>
			        <td>${student.doj}</td>
			    </tr>
			</c:forEach>
                     
            </table>
         
         
       </div>
	</div>
</body>
</html>