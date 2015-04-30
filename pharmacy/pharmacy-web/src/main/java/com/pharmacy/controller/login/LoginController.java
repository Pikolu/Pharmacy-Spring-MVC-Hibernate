/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.controller.login;

import com.pharmacy.service.api.UserService;
import com.pharmacy.user.User;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Alexandr
 */
@Controller
public class LoginController {
    
    @Inject
    private UserService userService;

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public ModelAndView login(@ModelAttribute("command") @Valid User user, BindingResult result) {
////        if (result.hasErrors()) {
//////            if (modelAndView == null) {
//////                modelAndView = new ModelAndView("redirect:registration.html", "command", new User());
//////            }
//////            modelAndView.getModel().putAll(result.getModel());
//////            return modelAndView;
////        } else {
//////            userService.save(user); 
////        }
//
//        return new ModelAndView("redirect:index.html", "command", user);
//    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView init() {
        ModelAndView model = new ModelAndView("login");
        return model;
    }
}
