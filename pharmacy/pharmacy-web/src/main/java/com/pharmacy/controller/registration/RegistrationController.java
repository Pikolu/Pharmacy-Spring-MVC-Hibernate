/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.controller.registration;

import com.pharmacy.controller.login.validator.UserValidator;
import com.pharmacy.exception.ServiceException;
import com.pharmacy.service.api.UserService;
import com.pharmacy.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    
    private static final Logger LOG = LoggerFactory.getLogger(RegistrationController.class);

    private static final String REGISTRATION = "registration";
    @Autowired
    private UserValidator validator;
    @Autowired
    private UserService userService;
    private ModelAndView modelAndView;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registration(@ModelAttribute("command") User user, BindingResult result) {
        try {
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
        } catch (ServiceException ex) {
            ex.writeLog(LOG);
        }
        return new ModelAndView("redirect:welcome.html", "command", user);
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView showContacts() {
        modelAndView = new ModelAndView(REGISTRATION, "command", new User());
        return modelAndView;
    }
}
