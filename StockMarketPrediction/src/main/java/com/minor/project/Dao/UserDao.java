package com.minor.project.Dao;

import com.minor.project.model.User;

public interface UserDao {
	boolean login(String username,String password);
	void signup(User u);
	
}
