<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    <title>Register | User Portal</title>
	    <!-- Bootstrap CSS -->
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
	    <style>
	        body {
	            background-color: #f8f9fa;
	        }
	        .card {
	            border-radius: 12px;
	            box-shadow: 0 4px 20px rgba(0,0,0,0.1);
	        }
	        .btn-primary {
	            background-color: #0078d7;
	            border-color: #0078d7;
	        }
	        .btn-primary:hover {
	            background-color: #005fa3;
	            border-color: #005fa3;
	        }
	        .form-control:focus {
	            border-color: #0078d7;
	            box-shadow: 0 0 0 0.2rem rgba(0,120,215,.25);
	        }
	    </style>
	</head>
	<body>
	    <div class="container d-flex justify-content-center align-items-center" style="min-height: 100vh;">
	        <div class="card p-4" style="width: 100%; max-width: 400px;">
	            <h3 class="text-center mb-4">User Registration</h3>
	            <form method="post" action="Registration">
	                <div class="mb-3">
	                    <input type="text" class="form-control" name="name" placeholder="Enter your Name" required>
	                </div>
	                <div class="mb-3">
	                    <input type="email" class="form-control" name="email" placeholder="Enter your Email" required>
	                </div>
	                <div class="mb-3">
	                    <input type="password" class="form-control" name="password" placeholder="Enter your Password" required>
	                </div>
	                <button type="submit" class="btn btn-primary w-100">Register</button>
	            </form>
	            <p class="text-center mt-3">
	                Already have an account? <a href="login.jsp">Login</a>
	            </p>
	        </div>
	    </div>
	
	    <!-- Bootstrap JS (optional, for components) -->
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
	</body>
</html>
