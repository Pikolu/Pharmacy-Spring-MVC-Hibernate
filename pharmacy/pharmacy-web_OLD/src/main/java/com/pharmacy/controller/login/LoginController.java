/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.controller.login;

import com.pharmacy.service.api.UserService;
import com.pharmacy.user.User;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;

    }

    // customize the error message
    private String getErrorMessage(HttpServletRequest request, String key) {

        Exception exception = (Exception) request.getSession().getAttribute(key);

        String error = "";
        if (exception instanceof BadCredentialsException) {
            error = "Invalid username and password!";
        } else if (exception instanceof LockedException) {
            error = exception.getMessage();
        } else {
            error = "Invalid username and password!";
        }

        return error;
    }

//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public @ResponseBody
//    ModelAndView init() {
//        ModelAndView model = new ModelAndView("login");
//        return model;
//    }
}
