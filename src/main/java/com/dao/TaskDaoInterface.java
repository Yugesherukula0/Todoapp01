package com.dao;

import java.util.List;

import com.dto.Task;

public interface TaskDaoInterface {
	public boolean addTask(Task task);
	public boolean deleteTask(int id);
	public boolean modifyTask(Task task);
	Task getTaskById(int id);
	List<Task> getTasksByUser(int userid);
	boolean updateStatus(int id, String status); 

}
