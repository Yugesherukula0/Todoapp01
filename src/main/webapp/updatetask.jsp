<%-- 
<%@ page import="com.dto.Task" %>
<%
    Task task = (Task) request.getAttribute("task");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Update Task</title>
</head>
<body>
    <h2>Update Task</h2>
    <form method="post" action="UpdateTask">
        <input type="hidden" name="id" value="<%= task.getId() %>">
        Title: <input type="text" name="title" value="<%= task.getTitle() %>" required><br><br>
        Status:
        <select name="status">
            <option value="pending" <%= task.getStatus().equals("pending") ? "selected" : "" %>>Pending</option>
            <option value="completed" <%= task.getStatus().equals("completed") ? "selected" : "" %>>Completed</option>
        </select><br><br>
        <input type="submit" value="Update Task">
    </form>
</body>
</html>
--%>
<%@ page import="com.dao.TaskDao, com.dto.Task" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    TaskDao dao = new TaskDao();
    Task task = dao.getTaskById(id);
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Task</title>
</head>
<body>
    <h2>Update Task</h2>

    <form method="post" action="UpdateTask">
        <input type="hidden" name="id" value="<%= task.getId() %>">

        Title: <input type="text" name="title" value="<%= task.getTitle() %>" required><br><br>

        Status:
        <select name="status">
            <option value="pending" <%= "pending".equals(task.getStatus()) ? "selected" : "" %>>Pending</option>
            <option value="completed" <%= "completed".equals(task.getStatus()) ? "selected" : "" %>>Completed</option>
        </select><br><br>

        <input type="submit" value="Update">
    </form>
</body>
</html>

