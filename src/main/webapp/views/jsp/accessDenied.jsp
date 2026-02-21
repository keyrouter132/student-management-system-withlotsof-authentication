<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Access Denied</title>
    <style>
        body {
            font-family: Arial;
            text-align: center;
            background-color: #f8f8f8;
            padding-top: 100px;
        }
        .box {
            background: white;
            display: inline-block;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 0 20px rgba(0,0,0,0.1);
        }
        h1 {
            color: red;
        }
        a {
            display: inline-block;
            margin-top: 20px;
            text-decoration: none;
            color: white;
            background: #007bff;
            padding: 10px 20px;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <div class="box">
        <h1>403 - Access Denied</h1>
        <p>You do not have permission to perform this action.</p>
        <a href="/">Go Back Home</a>
    </div>
</body>
</html>