/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.controller.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Alexandr
 */
@Controller
public class ErrorController {

    @RequestMapping(value = "/500", method = RequestMethod.GET)
    public ModelAndView errorPage500() {
        ModelAndView modelAndView = new ModelAndView("500");
        return modelAndView;
    }
}
