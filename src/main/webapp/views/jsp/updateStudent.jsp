<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Update Student</title>
	<style type="text/css">
		<%@ include file="/views/css/style.css"%>
	</style>
 <!-- 	<link rel="stylesheet" href="css/style.css" />  -->
</head>
<body>

	<div class="container">
		<h1 class="heading">Student Management System</h1>
		<ul class="nav">
			<li><a href="viewAllStudent">Display All Student</a></li>
			<li><a href="/">Home</a></li>
		</ul>
		<h2 class="heading">Update Student</h2>
        <div class="add-form">
			<form action="updateStud" method="post">
				<!-- CSRF TOKEN -->
				    <input type="hidden"
				           name="${_csrf.parameterName}"
				           value="${_csrf.token}" />
			    <table>
			        <tr>
			            <th>
			                <label>Student No. :</label>
			            </th>
			            <td>
			                <!-- Show ID (disabled for display only) -->
			                <input type="number" value="${Sno}" disabled>
			                
			                <!-- Hidden field to actually send ID -->
			                <input type="hidden" name="sno" value="${Sno}">
			            </td>
			        </tr>

			        <tr>
			            <th>
			                <label>Student Name :</label>
			            </th>
			            <td>
			                <input type="text" name="name"
			                       value="${Sname}" required>
			            </td>
			        </tr>

			        <tr>
			            <th>
			                <label>Date of Birth :</label>
			            </th>
			            <td>
							<input type="date" name="dob"
							       value="${SDOB != null ? SDOB : ''}" required>
			            </td>
			        </tr>

			        <tr>
			            <th>
			                <label>Date of Joining :</label>
			            </th>
			            <td>
							<input type="date" name="doj"
							       value="${SDOJ != null ? SDOJ : ''}" required>
			            </td>
			        </tr>

			        <tr>
			            <td colspan="2">
			                <input type="submit" value="Update Student">
			            </td>
			        </tr>
			    </table>
			</form>
       </div>
	</div>
	<div>${PrintSwal}</div>
</body>
</html>