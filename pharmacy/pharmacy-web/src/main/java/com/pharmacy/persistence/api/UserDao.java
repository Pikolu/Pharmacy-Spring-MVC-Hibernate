/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.persistence.api;

import com.pharmacy.user.User;

/**
 *
 * @author Alexandr
 */
public interface UserDao {
    
    public User findUserByEmail(String username);

    public User save(User user);
}
