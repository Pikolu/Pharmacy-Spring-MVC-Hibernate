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
package com.pharmacy.controller.evaluation;

import com.pharmacy.article.Pharmacy;
import com.pharmacy.controller.abstraction.AbstractController;
import com.pharmacy.evaluation.Evaluation;
import com.pharmacy.service.api.PharmacyService;
import com.pharmacy.user.User;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Alexander
 */
@Controller
public class EvaluationController extends AbstractController {
    
    @Autowired
    private PharmacyService pharmacyService;

    @RequestMapping(value = "/bewertungen", method = RequestMethod.GET)
    public ModelAndView initEvaluations(@RequestParam(required = false) String pharmacyName) {

        ModelAndView model = new ModelAndView();

        // check if user is login
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getPrincipal() instanceof User) {
            model.setViewName("evaluation");
            if (StringUtils.isNotBlank(pharmacyName)) {
                List<Pharmacy> pharmacies = pharmacyService.findPharmaciesByName(pharmacyName);
                model.addObject("pharmacyName", pharmacyName);
                model.addObject("pharmacies", pharmacies);
            }

        } else {
            model.setViewName("login");
        }

        return model;
    }

    @RequestMapping(value = "/bewerten/{pharm}", method = RequestMethod.GET)
    public ModelAndView displayPharmacy(@PathVariable String pharm, HttpServletRequest request, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("evaluate");
        Pharmacy pharmacy = pharmacyService.getPharmacyByName(pharm);
        modelAndView.addObject("evaluation", new Evaluation());
        modelAndView.addObject("pharmacy", pharmacy);
        return modelAndView;
    }


    @RequestMapping(value = "/bewerten", method = RequestMethod.POST)
    public ModelAndView registration(@ModelAttribute("evaluation") Evaluation evaluation, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView("evaluate");
        return modelAndView;
    }

}
