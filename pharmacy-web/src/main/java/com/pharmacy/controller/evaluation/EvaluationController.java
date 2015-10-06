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
import com.pharmacy.evaluation.helper.EvaluationValidator;
import com.pharmacy.exception.ServiceException;
import com.pharmacy.service.api.PharmacyService;
import com.pharmacy.user.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    @Inject
    private PharmacyService pharmacyService;
    @Autowired
    private EvaluationValidator evaluationValidator;

    @RequestMapping(value = "/bewertungen", method = RequestMethod.GET)
    public ModelAndView initEvaluations(@RequestParam(required = false) String pharmacyName) {

        ModelAndView model = new ModelAndView();

        // check if user is login
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getPrincipal() instanceof User) {
            model.setViewName("evaluation");
            if (StringUtils.isNotBlank(pharmacyName)) {
                List<Pharmacy> pharmacies = null;
                try {
                    pharmacies = pharmacyService.findPharmaciesByName(pharmacyName);
                } catch (ServiceException ex) {
                    Logger.getLogger(EvaluationController.class.getName()).log(Level.SEVERE, null, ex);
                }
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
        Pharmacy pharmacy = null;
        try {
            pharmacy = pharmacyService.getPharmacyByName(pharm);
        } catch (ServiceException ex) {
            Logger.getLogger(EvaluationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        modelAndView.addObject("evaluation", new Evaluation());
        modelAndView.addObject("pharmacy", pharmacy);
        return modelAndView;
    }

    @RequestMapping(value = "/{pharmId}/bewerten", method = RequestMethod.POST)
    public ModelAndView registration(@ModelAttribute("evaluation") Evaluation evaluation, @PathVariable String pharmId, BindingResult result) {
        ModelAndView modelAndView = null;
        try {
            evaluationValidator.validate(evaluation, result);
            if (result.hasErrors()) {
                modelAndView = new ModelAndView("evaluate");
                Pharmacy pharmacy = pharmacyService.getPharmacyById(pharmId);
                modelAndView.addObject("pharmacy", pharmacy);
            } else {
                pharmacyService.saveEvaluation(pharmId, evaluation);
            }  
        } catch (ServiceException ex) {
            
        }
        return modelAndView;

    }

}
