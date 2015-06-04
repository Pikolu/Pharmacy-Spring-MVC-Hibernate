/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.service.api;

import com.pharmacy.article.Article;
import com.pharmacy.exception.ServiceException;
import java.util.List;

/**
 *
 * @author Alexandr
 */
public interface ArticleService {
    
    public void save(Article article) throws ServiceException;
    
    public List<Article> loadBestDiscountedArticles() throws ServiceException;

    public List<Article> findArticlesByParameter(String parameter) throws ServiceException;
    
}
