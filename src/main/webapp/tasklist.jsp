<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.dto.Task"%>
<%@ page import="com.dao.TaskDao"%>
<%@ page import="com.dto.User"%>

<%
    // Get logged-in user from session
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    TaskDao taskDAO = new TaskDao();
    List<Task> tasks = taskDAO.getTasksByUser(user.getUserid());
%>

<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    <title>Your Tasks</title>
	    <style>
	    		.logout-btn {
	            position: absolute;
	            top: 20px;
	            right: 20px;
	        }
	        body { font-family: Arial; margin: 20px; }
	        table { border-collapse: collapse; width: 80%; }
	        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
	        th { background-color: #f2f2f2; }
	        a { text-decoration: none; color: blue; margin-right: 5px; }
	        .completed { text-decoration: line-through; color: gray; }
	
	    </style>
	</head>
	<body>
	    <h2>Welcome, <%= user.getName() %>!</h2>
	    <a href="Logout" class="logout-btn"><button>Logout</button></a>
	    <a href="addtask.jsp">+ Add New Task</a>
	    <table>
	        <tr>
	            <th>ID</th>
	            <th>Title</th>
	            <th>Status</th>
	            <th>Actions</th>
	        </tr>
	        
	        <%
				int count=1;		        
	            for(Task t : tasks) {
	                String cssClass = t.getStatus().equalsIgnoreCase("completed") ? "completed" : "";
	        %>
	        <tr>
	            <td><%= count++ %></td>
	            <td class="<%= cssClass %>"><%= t.getTitle() %></td>
	            <td><%= t.getStatus() %></td>
	            <td>
	                <a href="updatetask.jsp?id=<%= t.getId() %>">Edit</a>
	                <a href="DeleteTask?id=<%= t.getId() %>" onclick="return confirm('Delete this task?');">Delete</a>
	                <%-- 
					    This link toggles task status:
					    - If current status is "pending", it will mark as "completed"
					    - If current status is "completed", it will mark as "pending"
					--%>
					<a href="ChangeStatus?id=<%= t.getId() %>&status=<%= 
					        t.getStatus().equals("pending") ? "completed" : "pending" %>">
					    
					    <%-- Display button text based on current status --%>
					    <%= t.getStatus().equals("pending") ? "Mark Complete" : "Mark Pending" %>
					</a>
	            </td>
	        </tr>
	        <% } %>
	    </table>
	</body>
</html>
