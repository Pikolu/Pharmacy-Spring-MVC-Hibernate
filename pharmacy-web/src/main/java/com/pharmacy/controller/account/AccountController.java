/*
 * Copyright 2015 Alexander.
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
package com.pharmacy.controller.account;

import com.pharmacy.controller.login.validator.UserValidator;
import com.pharmacy.exception.ServiceException;
import com.pharmacy.service.api.UserService;
import com.pharmacy.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Alexander
 */
@Controller
public class AccountController {

    private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private UserValidator validator;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public ModelAndView initAccount(HttpServletRequest request) {
        ModelAndView model;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getPrincipal() instanceof User) {
            User user = (User) auth.getPrincipal();
            model = new ModelAndView("account", "command", user);
        } else {
            model = new ModelAndView("login");
        }
        return model;
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public ModelAndView registration(@ModelAttribute("command") User user, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = null;
        try {
            validator.validate(user, result, true);
            if (result.hasErrors()) {
                modelAndView = new ModelAndView("account", "command", user);
                modelAndView.getModel().putAll(result.getModel());
            } else {
                userService.save(user);
                modelAndView = new ModelAndView("account", "command", user);
            }
        } catch (ServiceException e) {
            e.writeLog(LOG);
        }
        return modelAndView;
    }

}
