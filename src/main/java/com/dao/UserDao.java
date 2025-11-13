package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dto.User;
import com.utility.DbConnection;

public class UserDao implements UserDaoInterface{
	
	static boolean status;
	private Connection con;
	
	public UserDao() {
		try {
			con=new DbConnection().dbConnect();
			
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public boolean addUser(User u) {
		try {
			PreparedStatement pst=con.prepareStatement("insert into user(name,email,password) values(?,?,?)");
			pst.setString(1, u.getName());
			pst.setString(2, u.getEmail());
			pst.setString(3, u.getPassword());
			int n = pst.executeUpdate();
			return n>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public boolean deleteUser(User u) {
		try {
			PreparedStatement pst =con.prepareStatement("delete from user where email = ?");
			pst.setString(1,u.getEmail());
			int n=pst.executeUpdate();
			return n>0;
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	 public User loginUser(String email, String password) {
	        String query = "SELECT * FROM user WHERE email=? AND password=?";
	        User user=null;
	        try (PreparedStatement pst = con.prepareStatement(query)) {
	            pst.setString(1, email);
	            pst.setString(2, password);
	            ResultSet rs = pst.executeQuery();

	            if (rs.next()) {
	                user = new User();
	                user.setUserid(rs.getInt("userid"));
	                user.setName(rs.getString("name"));
	                user.setEmail(rs.getString("email"));
	                user.setPassword(rs.getString("password"));
	                return user;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return user;
	    }

}
