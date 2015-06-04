/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.controller.index;

import com.pharmacy.article.Article;
import com.pharmacy.article.Pharmacy;
import com.pharmacy.article.Price;
import com.pharmacy.controller.abstraction.AbstractController;
import com.pharmacy.evaluation.Evaluation;
import com.pharmacy.exception.ServiceException;
import com.pharmacy.payment.PaymentType;
import com.pharmacy.service.api.ArticleService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
public class IndexController extends AbstractController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/produkte", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView search(@RequestParam String parameter, @RequestParam(required = false) String page) {
        ModelAndView model = new ModelAndView("search");

        try {
            List<Article> articles = articleService.findArticlesByParameter(parameter);
            setPage(page, model);
            model.addObject("articles", articles);
            model.addObject("parameter", parameter);
        } catch (ServiceException ex) {
            ex.writeLog(null);
        }
        return model;

    }

    @RequestMapping(value = "/apotheke/{pharm}", method = RequestMethod.GET)
    public ModelAndView displayPharmacy(@PathVariable String pharm, HttpServletRequest request, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("pharmacy");
        return modelAndView;
    }
}
