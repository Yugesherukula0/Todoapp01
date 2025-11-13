package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.Task;
import com.utility.DbConnection;

public class TaskDao implements TaskDaoInterface {
	private Connection con;

	public TaskDao() {
		try {
			con = new DbConnection().dbConnect();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean addTask(Task task) {
	    try {
	        // 1️ Check if the user exists
	        PreparedStatement pstCheck = con.prepareStatement("SELECT userid FROM user WHERE userid = ?");
	        pstCheck.setInt(1, task.getUserid());
	        ResultSet rs = pstCheck.executeQuery();

	        if (!rs.next()) {
	            System.out.println(" Cannot add task: user with ID " + task.getUserid() + " does not exist.");
	            return false;
	        }

	        // 2️ Insert the task
	        PreparedStatement pst = con.prepareStatement("INSERT INTO task(userid, title, status) VALUES (?, ?, ?)");
	        pst.setInt(1, task.getUserid());
	        pst.setString(2, task.getTitle());
	        pst.setString(3, task.getStatus());

	        int n = pst.executeUpdate();
	        return n > 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return false;
	}


	@Override
	public boolean deleteTask(int id) {
		try {
			PreparedStatement pst=con.prepareStatement("delete from task where id=?");
			pst.setInt(1, id);
			int n=pst.executeUpdate();
			return n>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean modifyTask(Task task) {
		try {
			PreparedStatement pst=con.prepareStatement("update task set title=? ,status=? where id=? ");
			pst.setString(1, task.getTitle());
			pst.setString(2, task.getStatus());
			pst.setInt(3, task.getId());
			int n=pst.executeUpdate();
			return n>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Task getTaskById(int id) {
		Task task=null;
		try {
			PreparedStatement pst=con.prepareStatement("select id,title,status from task where id=?");
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				task=new Task();
				task.setId(rs.getInt("id"));
				task.setTitle(rs.getString("title"));
				task.setStatus(rs.getString("status"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return task;
	}

	@Override
	public List<Task> getTasksByUser(int userid) {
		List<Task> tasks=new ArrayList<Task>();
		try {
			PreparedStatement pst=con.prepareStatement("select id,title,status from task where userid=?");
			pst.setInt(1, userid);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Task t=new Task();
				t.setId(rs.getInt("id"));
				t.setTitle(rs.getString("title"));
				t.setStatus(rs.getString("status"));
				tasks.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tasks;
	}

	@Override
	public boolean updateStatus(int id, String status) {
		try {
			PreparedStatement pst=con.prepareStatement("update task set status=? where id=? ");
			pst.setString(1, status);
			pst.setInt(2, id);
			int n=pst.executeUpdate();
			return n>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
