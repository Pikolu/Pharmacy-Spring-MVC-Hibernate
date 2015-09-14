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

import com.pharmacy.controller.abstraction.AbstractController;
import com.pharmacy.user.User;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Alexander
 */
@Controller
public class AccountController extends AbstractController {

    private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public ModelAndView initAccount(HttpServletRequest request) {
        ModelAndView model;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            LOG.info("Authentication is failed.");
            model = new ModelAndView();
            model.setViewName("login");
        } else {
            Object principal = auth.getPrincipal();
            if (principal instanceof User) {
                User user = (User) principal;
                model = new ModelAndView("account", "command", user);
            } else {
                LOG.info("Authentication {} is failed.", auth);
                model = new ModelAndView();
                model.setViewName("login");
            }
        }
        return model;

    }

    @RequestMapping(value = "/account/data", method = RequestMethod.GET)
    public ModelAndView initPersonalityData(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth == null) {
                LOG.info("Authentication is failed.");
                model.setViewName("login");
            } else {
                Object principal = auth.getPrincipal();
                if (principal instanceof User) {
                    model.setViewName("data");
                } else {
                    LOG.info("Authentication {} is failed.", auth);
                }
            }
        } catch (Exception ex) {
            handleException(ex, LOG);
        }
        return model;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView processSubmit(@ModelAttribute("command") User User, BindingResult result) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("greeting", User);
        return mv;
    }
}
