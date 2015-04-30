/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.service.impl;

import com.pharmacy.persistence.api.UserDao;
import com.pharmacy.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alexandr
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
     
    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("", "", null);
    }

    @Override
    public void save(com.pharmacy.user.User user) {
        
        userDao.save(user);
    }

}
