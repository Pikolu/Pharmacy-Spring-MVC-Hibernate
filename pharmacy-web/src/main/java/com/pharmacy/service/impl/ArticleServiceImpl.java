/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.service.impl;

import com.pharmacy.article.Article;
import com.pharmacy.controller.abstraction.DataWithCount;
import com.pharmacy.controller.abstraction.FilterOptions;
import com.pharmacy.exception.ServiceException;
import com.pharmacy.persistence.api.ArticleDao;
import com.pharmacy.service.api.ArticleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Alexandr
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    
    @Autowired
    private ArticleDao articleDao;
    
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(Article article) throws ServiceException {
        articleDao.save(article);
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Article> loadBestDiscountedArticles() throws ServiceException{
        List<Article> articles = articleDao.loadBestDiscountedArticles();
        return articles;
    }

    @Override
    public List<Article> findArticlesByParameter(String parameter) throws ServiceException {
        List<Article> articles = articleDao.findArticlesByParameter(parameter);
        return articles;
    }

    @Override
    public DataWithCount<Article> loadTableContent(String parameter, FilterOptions filterOptions) throws ServiceException {
        DataWithCount<Article> articles = articleDao.loadTableContent(parameter, filterOptions);
        return articles;
    } 
    
}
