package com.controller;

import java.io.IOException;
import com.dao.TaskDao;
import com.dto.Task;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateTask")
public class UpdateTask extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        TaskDao dao = new TaskDao();
        Task task = dao.getTaskById(id); // Make sure this method exists!

        if (task != null) {
            request.setAttribute("task", task);
            request.getRequestDispatcher("updatetask.jsp").forward(request, response);
        } else {
            response.getWriter().println("Task not found for ID: " + id);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String status = request.getParameter("status");

        Task task = new Task();
        task.setId(id);
        task.setTitle(title);
        task.setStatus(status);

        TaskDao dao = new TaskDao();
        boolean updated = dao.modifyTask(task);

        if (updated) {
            response.sendRedirect("tasklist.jsp");
        } else {
            response.getWriter().println(" Failed to update task");
        }
    }
}
