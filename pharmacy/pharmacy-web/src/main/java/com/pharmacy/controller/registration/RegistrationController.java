/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.controller.registration;

import com.pharmacy.controller.login.validator.UserValidator;
import com.pharmacy.service.api.UserService;
import com.pharmacy.user.User;
import com.pharmacy.users.service.MyUserDetailsService;
import javax.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Alexandr
 */
@Controller
public class RegistrationController {

    private static final String REGISTRATION = "registration";
    @Autowired
    private UserValidator validator;
    @Autowired
    private UserService userService;
    private ModelAndView modelAndView;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registration(@ModelAttribute("command") User user, BindingResult result) {
        validator.validate(user, result);
        if (result.hasErrors()) {
            if (modelAndView == null) {
                modelAndView = new ModelAndView("redirect:registration.html", "command", new User());
            }
            modelAndView.getModel().putAll(result.getModel());
            return modelAndView;
        } else {
            userService.save(user); 
        }

        return new ModelAndView("redirect:welcome.html", "command", user);
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView showContacts() {
        modelAndView = new ModelAndView(REGISTRATION, "command", new User());
        return modelAndView;
    }
}
