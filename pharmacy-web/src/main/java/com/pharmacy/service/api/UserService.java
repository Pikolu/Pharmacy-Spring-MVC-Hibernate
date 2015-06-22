/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.service.api;

import com.pharmacy.exception.ServiceException;
import com.pharmacy.user.Account;
import com.pharmacy.user.User;

/**
 *
 * @author Alexandr
 */
public interface UserService {

    public User save(User user) throws ServiceException;

    public Account findAccoutByEmail(String email) throws ServiceException;
    
}
