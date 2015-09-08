/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.controller.index;

import com.pharmacy.article.Article;
import com.pharmacy.article.Pharmacy;
import com.pharmacy.article.helper.ArticleHelper;
import com.pharmacy.article.helper.URLHelper;
import com.pharmacy.controller.abstraction.AbstractController;
import com.pharmacy.controller.abstraction.DataWithCount;
import com.pharmacy.exception.ServiceException;
import com.pharmacy.service.api.ArticleService;
import com.pharmacy.service.api.PharmacyService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    
    private final static Logger LOG = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private ArticleService articleService;
    @Autowired
    private PharmacyService pharmacyService;

    @RequestMapping(value = "/produkte", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView search(@RequestParam String parameter, @RequestParam(required = false) String page) {
        LOG.trace("Enter search: parameter={}, page={}", parameter, page);
        ModelAndView model = new ModelAndView("search");
        int currentpage;
        try {
            if (page == null) {
                currentpage = 1;
            } else {
                currentpage = Integer.valueOf(page);
            }
            getFilterOptions().setCurrentPage(currentpage);
            DataWithCount<Article> articles = articleService.loadTableContent(parameter, getFilterOptions());
            setPage(page, model, articles.getCount());
            model.addObject("articles", articles.getResultList());
            model.addObject("parameter", parameter);
            model.addObject("articleHelper", new ArticleHelper());
            model.addObject("urlEncoder", new URLHelper());
        } catch (ServiceException ex) {
            ex.writeLog(LOG);
        }
        LOG.trace("Exit search: model={}", model);
        return model;

    }

    @RequestMapping(value = "/apotheke/{pharm}", method = RequestMethod.GET)
    public ModelAndView displayPharmacy(@PathVariable String pharm, HttpServletRequest request, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("pharmacy");
        Pharmacy pharmacy = pharmacyService.getPharmacyByName(pharm);
        modelAndView.addObject("pharmacy", pharmacy);
        return modelAndView;
    }
}
