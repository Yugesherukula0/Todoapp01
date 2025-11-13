<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    <title>Welcome | User Portal</title>
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
	    <style>
	        body {
	            background: #f8f9fa;
	            min-height: 100vh;
	            display: flex;
	            justify-content: center;
	            align-items: center;
	            font-family: Arial, sans-serif;
	        }
	        .card {
	            padding: 30px;
	            border-radius: 12px;
	            box-shadow: 0 0 10px rgba(0,0,0,0.1);
	            background: white;
	            text-align: center;
	            width: 350px;
	        }
	        .btn-custom {
	            width: 100%;
	            margin-top: 10px;
	        }
	        .divider {
	            height: 1px;
	            background: #ddd;
	            margin: 20px 0;
	        }
	    </style>
	</head>
	<body>
	    <div class="card">
	        <h3 class="mb-3">Welcome!</h3>
	
	        <p>👤 New user? Click Register</p>
	        <a href="register.jsp" class="btn btn-primary btn-custom">Register</a>
	
	        <div class="divider"></div>
	
	        <p>👤 Existing user? Click Login</p>
	        <a href="login.jsp" class="btn btn-success btn-custom">Login</a>
	    </div>
	</body>
</html>
