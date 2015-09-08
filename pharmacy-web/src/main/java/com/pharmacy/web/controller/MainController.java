package com.pharmacy.web.controller;

import com.pharmacy.article.Article;
import com.pharmacy.article.Pharmacy;
import com.pharmacy.article.helper.ArticleHelper;
import com.pharmacy.article.helper.URLHelper;
import com.pharmacy.evaluation.helper.EvaluationHelper;
import com.pharmacy.exception.ControllerException;
import com.pharmacy.exception.ServiceException;
import com.pharmacy.exception.type.ExceptionType;
import com.pharmacy.service.api.ArticleService;
import com.pharmacy.service.api.EvaluationService;
import com.pharmacy.service.api.PharmacyService;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

    @Inject
    private ArticleService articleService;
    @Inject
    private PharmacyService pharmacyService;
    @Inject
    private EvaluationService evaluationService;

    @RequestMapping(value = {"/", "/index", "/welcome**"}, method = RequestMethod.GET)
    public ModelAndView defaultPage() {
        ModelAndView modelAndView = null;
        try {
            modelAndView = new ModelAndView("index");
            List<Article> articles = articleService.loadBestDiscountedArticles();
            modelAndView.addObject("articles", articles);
            List<Pharmacy> pharmacies = pharmacyService.findBestPharmacies();
            modelAndView.addObject("pharmacies", pharmacies);
            modelAndView.addObject("evaluationHelper", new EvaluationHelper());
            modelAndView.addObject("articleHelper", new ArticleHelper());
            modelAndView.addObject("evaluations", evaluationService.getLastEvaluations());
            modelAndView.addObject("urlEncoder", new URLHelper());

        } catch (ServiceException ex) {
            ex.writeLog(LOG);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security + Hibernate Example");
        model.addObject("message", "This page is for ROLE_ADMIN only!");
        model.setViewName("admin");

        return model;

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            try {
                getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION");
            } catch (ControllerException ex) {
                model.addObject("error", ex.getExceptionType().getResourceKey());
                ex.writeLog(LOG);
            }
        }
        if (logout != null) {
            model.setViewName("redirect:index");
            model.getModel();
        } else {
            model.setViewName("login");
        }
        return model;

    }

    // customize the error message
    private void getErrorMessage(HttpServletRequest request, String key) throws ControllerException {
        Exception exception = (Exception) request.getSession().getAttribute(key);
        if (exception != null) {
            throw new ControllerException(ExceptionType.LOGIN_0002, exception);
        } else {
            throw new ControllerException(ExceptionType.LOGIN_0003);
        }
    }

    // for 403 access denied page
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {

        ModelAndView model = new ModelAndView();

        // check if user is login
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            model.addObject("username", userDetail.getUsername());
        }
        model.setViewName("403");
        return model;

    }

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public ModelAndView initAccount(HttpServletRequest request) {
        Map map = request.getParameterMap();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView model = new ModelAndView();
        model.setViewName("account");
        return model;

    }
}
