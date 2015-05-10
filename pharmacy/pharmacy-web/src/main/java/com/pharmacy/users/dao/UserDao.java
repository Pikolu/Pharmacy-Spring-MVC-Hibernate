package com.pharmacy.users.dao;

import com.pharmacy.user.User;

public interface UserDao {

    public User findUserByEmail(String username);

    public void save(User user);

}
