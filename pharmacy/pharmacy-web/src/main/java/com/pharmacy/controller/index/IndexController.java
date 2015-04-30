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
import com.pharmacy.evaluation.helper.EvaluationHelper;
import com.pharmacy.payment.PaymentType;
import com.pharmacy.service.api.ArticleService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    public void initPost() {

        Article article;
        article = new Article();
        article.setTitle("Artikle");
        article.setDescriptionLong("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc, ");
        article.setDescriptionShort("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa.");
        article.setImageURL("https://www.shop-apotheke-partner.com/trck/eview/328d0a75a6715d2f400815c7056323a5?prodid=1000002&fid=1");
        article.setDeepLink("https://www.shop-apotheke-partner.com/trck/eclick/328d0a75a6715d2f400815c7056323a5?prodid=1000002&fid=1");
        article.setManufacturer("Novartis Pharma GmbH");
        Price price;
        for (int j = 1; j <= 10; j++) {

            Pharmacy pharmacy = new Pharmacy();
            pharmacy.setName("Apotheke " + j);
            pharmacy.setPaymentTypes(new ArrayList<>(Arrays.asList(PaymentType.values())));
            pharmacy.setLogoURL("http://www.shop-apotheke.com/pix/shop-apotheke-online-apotheke.png");

            for (int z = 1; z <= 10; z++) {
                Evaluation evaluation = new Evaluation();
                evaluation.setTitle("Bewertung title " + 1);
                evaluation.setDescription("Bewertunh Beschreibung " + 1);
                evaluation.setPoints((float) (z + 0.5));
                pharmacy.getEvaluations().add(evaluation);
            }

            price = new Price();
            price.setPrice(j);
            price.setDiscount(j * 10);
            price.setSuggestedRetailPrice(j + 1);
            price.setPharmacy(pharmacy);
            price.setExtraShippingSuffix("portofrei ab 19 Euro");

            article.getPrices().add(price);
        }
        
        articleService.save(article);
    }

    @RequestMapping(value = "/produkte", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView search(@RequestParam String parameter, @RequestParam(required = false) String page) {
        ModelAndView model = new ModelAndView("search");
        setPage(page, model);
        model.addObject("parameter", parameter);
//        List<Article> articles = articleFacade.loadArticlesByParameter(parameter, getFilterOptions());
//        model.addObject("articles", articles);
        return model;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView init(HttpServletRequest request, HttpSession session) {
        return initIndex(request, session);
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView initIndex(HttpServletRequest request, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Article> articles = getSomeArticles();
        modelAndView.addObject("articles", articles);
        List<Pharmacy> pharmacies = getSomePharmacies();
        modelAndView.addObject("pharmacies", pharmacies);
        modelAndView.addObject("evaluationHelper", new EvaluationHelper());
        modelAndView.addObject("evaluations", getSomeEvaluations());
//        initPost();
        return modelAndView;
    }

    @RequestMapping(value = "/apotheke/{pharm}", method = RequestMethod.GET)
    public ModelAndView displayPharmacy(@PathVariable String pharm, HttpServletRequest request, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("pharmacy");
        return modelAndView;
    }

    private List<Article> getSomeArticles() {
        List<Article> articles = new ArrayList<>();
        Article article;
        for (int i = 1; i < 41; i++) {
            article = new Article();
            article.setTitle("Artikle " + i);
            article.setDescriptionLong("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc, ");
            article.setDescriptionShort("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa.");
            article.setImageURL("https://www.shop-apotheke-partner.com/trck/eview/328d0a75a6715d2f400815c7056323a5?prodid=1000002&fid=1");
            articles.add(article);
        }

        return articles;
    }

    private List<Pharmacy> getSomePharmacies() {
        List<Pharmacy> pharmacys = new ArrayList<>();
        Pharmacy pharmacy;
        Evaluation evaluation;
        Price price;
        for (int i = 1; i <= 5; i++) {
            pharmacy = new Pharmacy();
            pharmacy.setName("Apotheke " + i);
            pharmacy.setPaymentTypes(new ArrayList<>(Arrays.asList(PaymentType.values())));
            pharmacy.setLogoURL("http://www.shop-apotheke.com/pix/shop-apotheke-online-apotheke.png");
            for (int j = 0; j < 10; j++) {
                evaluation = new Evaluation();
                evaluation.setPoints((float) (i + 0.5));
                pharmacy.getEvaluations().add(evaluation);
            }
            pharmacys.add(pharmacy);
        }
        return pharmacys;
    }

    private List<Evaluation> getSomeEvaluations() {
        List<Evaluation> evaluations = new ArrayList<>();
        Evaluation evaluation;
        for (int j = 1; j <= 5; j++) {
            evaluation = new Evaluation();
            evaluation.setTitle("Bewertung Bewertung Bewertung Bewertung Bewertung Bewertung Bewertung Bewertung akjsdhajksdha kjdak jdkajs dkajsd kajsnd kjand adjn alksjdn aksjdn kaljdn kajsnd kajnd kajsnd kajsnd kjbf lbgksdfsf nsdf s skjdf skjnfd fkj nsfkj nkjs ndfjks dnfksjfn skjdfgd" + j);
            evaluation.setDescription("Hier ist die Bewertung von der Bewertung Hier ist die Bewertung von der Bewertung Hier ist die Bewertung von der Bewertung Hier ist die Bewertung von der Bewertung Hier ist die Bewertung von der Bewertung Hier ist die Bewertung von der Bewertung Hier ist die Bewertung von der Bewertung " + j);
            evaluation.setPoints((float) (j + 0.5));
            evaluations.add(evaluation);
        }
        return evaluations;
    }

//    @RequestMapping(value = "/index", method = RequestMethod.GET)
//    @Transactional
//    public ModelAndView initIndex(HttpServletRequest request, HttpSession session) {
//        ModelAndView modelAndView = new ModelAndView("index");
//
//        Article article = new Article();
//        article.setTitle("Test");
//
//        Session currentSession = sessionFactory.openSession();
//        Transaction tx2 = currentSession.beginTransaction();
//        currentSession.persist(article);
//        tx2.commit();
//        currentSession.close();
//        
//        return modelAndView;
//    }
}
