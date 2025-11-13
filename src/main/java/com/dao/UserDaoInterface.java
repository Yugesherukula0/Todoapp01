package com.dao;

import com.dto.User;

public interface UserDaoInterface {
	public boolean addUser(User u);
	public boolean deleteUser(User u);
}
