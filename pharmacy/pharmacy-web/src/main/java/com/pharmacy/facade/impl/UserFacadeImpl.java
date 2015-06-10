/*
 * Copyright 2015 Alexandr.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pharmacy.facade.impl;

import com.pharmacy.exception.ServiceException;
import com.pharmacy.facade.api.UserFacade;
import com.pharmacy.service.api.UserService;
import com.pharmacy.user.Account;
import com.pharmacy.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alexandr
 */
@Service
public class UserFacadeImpl implements UserFacade {

    private final static Logger LOG = LoggerFactory.getLogger(UserFacadeImpl.class);

    @Autowired
    private UserService userService;

    @Override
    public User save(User user) throws ServiceException {
        LOG.trace("Enter save: user={}", user);
        User savedUser;
        try {
            savedUser = userService.save(user);
        } catch (ServiceException e) {
            e.writeLog(null);
            throw e;
        }
        LOG.trace("Exit save: savedUser={}", savedUser);
        return savedUser;
    }

}
