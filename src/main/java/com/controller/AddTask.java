package com.controller;


import java.io.IOException;
import com.dao.TaskDao;
import com.dto.Task;
import com.dto.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AddTask")
public class AddTask extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false); //  don't create new session if expired
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        //  Get the logged-in user object
        User user = (User) session.getAttribute("user");

        //  Create a task object
        Task task = new Task();
        task.setUserid(user.getUserid());
        task.setTitle(request.getParameter("title"));
        task.setStatus("pending");

        boolean added = new TaskDao().addTask(task);
        if (added) {
            response.sendRedirect("tasklist.jsp"); // make sure your JSP name matches
        } else {
            response.getWriter().println(" Task not added!");
        }
    }
}
