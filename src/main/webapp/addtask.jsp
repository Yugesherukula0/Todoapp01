<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.dto.User"%>

<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    <title>Add Task</title>
	    <style>
	        body { font-family: Arial; margin: 20px; }
	        form { width: 300px; }
	        input[type=text] { width: 100%; padding: 8px; margin: 8px 0; box-sizing: border-box; }
	        input[type=submit] { padding: 8px 16px; }
	    </style>
	</head>
	<body>
	    <h2>Add Task</h2>
	    <form action="AddTask" method="post">
	        <label>Task Title:</label><br>
	        <input type="text" name="title" required><br>
	        <input type="submit" value="Add Task">
	    </form>
	    <br>
	    <a href="tasklist.jsp">Back to Task List</a>
	</body>
</html>
