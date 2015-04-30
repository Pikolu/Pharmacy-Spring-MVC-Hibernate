/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.service.impl;

import com.pharmacy.article.Article;
import com.pharmacy.persistence.api.ArticleDao;
import com.pharmacy.service.api.ArticleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alexandr
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    
    @Autowired
    private ArticleDao articleDao;
    
    @Override
    public void save(Article article) {
        articleDao.save(article);
    }
    
    @Override
    public List<Article> loadBestDiscountedArticles() {
        List<Article> articles = articleDao.loadBestDiscountedArticles();
        return articles;
    }
}
