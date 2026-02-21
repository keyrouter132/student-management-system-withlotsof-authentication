<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register Student</title>
    <style type="text/css">
        <%@ include file="/views/css/style.css"%>
    </style>
 <!--   <link rel="stylesheet" href="css/style.css" />  -->
</head>
<body>

    <div class="container">
        <h1 class="heading">Student Management System</h1>
        <ul class="nav">
            <li><a href="viewAllStudent">Display All Student</a></li>
            <li><a href="/">Home</a></li>
        </ul>
        <h2 class="heading">Register Student</h2>
        <div class="add-form">
			<form action="addStud" method="post">
				<input type="hidden"
				           name="${_csrf.parameterName}"
				           value="${_csrf.token}" />
			    <table>
			        <tr>
			            <th>Student No. :</th>
			            <td>
			                <input type="number" name="sno" required>
			            </td>
			        </tr>

			        <tr>
			            <th>Student Name :</th>
			            <td>
			                <input type="text" name="name" required>
			            </td>
			        </tr>

			        <tr>
			            <th>Date of Birth :</th>
			            <td>
			                <input type="date" name="dob" required>
			            </td>
			        </tr>

			        <tr>
			            <th>Date of Joining :</th>
			            <td>
			                <input type="date" name="doj" required>
			            </td>
			        </tr>

			        <tr>
			            <td colspan="2">
			                <input type="submit" value="Add Student">
			            </td>
			        </tr>
			    </table>
			</form>
       </div>
    </div>
    <div>${PrintSwal}</div>
</body>
</html>