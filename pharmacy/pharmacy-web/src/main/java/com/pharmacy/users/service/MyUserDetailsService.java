package com.pharmacy.users.service;

import com.pharmacy.service.api.UserService;
import com.pharmacy.user.UserRole;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.pharmacy.users.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Resource
public class MyUserDetailsService implements UserDetailsService, UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

		// Programmatic transaction management
		/*
         return transactionTemplate.execute(new TransactionCallback<UserDetails>() {

         public UserDetails doInTransaction(TransactionStatus status) {
         com.mkyong.users.model.User user = userDao.findByUserName(username);
         List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());

         return buildUserForAuthentication(user, authorities);
         }

         });*/
        com.pharmacy.user.User user = userDao.findUserByEmail(username);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());

        return buildUserForAuthentication(user, authorities);

    }

	// Converts com.mkyong.users.model.User user to
    // org.springframework.security.core.userdetails.User
    private User buildUserForAuthentication(com.pharmacy.user.User user, List<GrantedAuthority> authorities) {
        return new User(user.getEmail(), user.getPassword(), true, true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<>();

        // Build user's authorities
        for (UserRole userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRoleName()));
        }

        List<GrantedAuthority> Result = new ArrayList<>(setAuths);

        return Result;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(com.pharmacy.user.User user) {
        userDao.save(user);
    }

}
