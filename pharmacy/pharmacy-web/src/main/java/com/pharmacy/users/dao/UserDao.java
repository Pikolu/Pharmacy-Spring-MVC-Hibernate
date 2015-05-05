package com.pharmacy.users.dao;

import com.pharmacy.users.model.User;

public interface UserDao {

	User findByUserName(String username);

}