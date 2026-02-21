<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
        body {
            background-color: #f2f2f2;
            font-family: Arial;
        }
        .login-box {
            width: 400px;
            margin: 120px auto;
            padding: 30px;
            background: white;
            box-shadow: 0px 0px 15px #ccc;
            border-radius: 8px;
        }
        h2 {
            text-align: center;
        }
        input {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
        }
        button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
        }
        .error {
            color: red;
            text-align: center;
        }
        .success {
            color: green;
            text-align: center;
        }
    </style>
</head>
<body>

<div class="login-box">
    <h2>Login</h2>

    <form action="login" method="post">

        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}" />

        <input type="text" name="username" placeholder="Username" required />

        <input type="password" name="password" placeholder="Password" required />

        <button type="submit">Login</button>
    </form>

    <% if(request.getParameter("error") != null) { %>
        <div class="error">Invalid username or password</div>
    <% } %>

    <% if(request.getParameter("logout") != null) { %>
        <div class="success">Logged out successfully</div>
    <% } %>
	<% if(request.getParameter("expired") != null) { %>
	    <div class="error">Session expired. Please login again.</div>
	<% } %>

</div>

</body>
</html>