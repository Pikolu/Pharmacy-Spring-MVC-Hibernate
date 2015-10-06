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
package com.pharmacy.controller.contact;

import com.pharmacy.controller.contact.validation.ContactValidator;
import com.pharmacy.user.Contact;
import org.apache.commons.lang.ArrayUtils;
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
 * @author Alexander
 */
@Controller
public class ContactController {

    private static final Logger LOG = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    private ContactValidator contactValidator;

    @RequestMapping(value = "/kontakt", method = RequestMethod.GET)
    private ModelAndView initContactForm() {
        ModelAndView modelAndView = new ModelAndView("contact", "contact", new Contact());
        return modelAndView;
    }

    @RequestMapping(value = "/kontakt", method = RequestMethod.POST)
    private ModelAndView sendContactForm(@ModelAttribute("contact") Contact contact, BindingResult result) {
        ModelAndView modelAndView;
        contactValidator.validate(contact, result);
        if (result.hasErrors()) {
            LOG.info("Contact form has severel errors.", ArrayUtils.toString(result.getAllErrors()));
            modelAndView = new ModelAndView("contact", "contact", contact);
        } else {
            LOG.info("Contact form is correct. {}", contact);
           modelAndView = new ModelAndView("contact", "contact", new Contact());
        }
        return modelAndView;
    }

}
