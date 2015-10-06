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
package com.pharmacy.controller.imprint;

import eu.bitwalker.useragentutils.UserAgent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Alexander
 */
@Controller
public class ImprintController {
    
        private final static Logger LOG = LoggerFactory.getLogger(ImprintController.class);

    
    @RequestMapping(value = "/impressum", method = RequestMethod.GET)
    public ModelAndView initImprint(HttpServletRequest request, HttpSession session) {
                
        LOG.info("User information {}", request.getHeader("User-Agent"));
        
        ModelAndView modelAndView = new ModelAndView("imprint");
        
        return modelAndView;
    }
}
