/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.persistence.api;

import com.pharmacy.article.Article;
import com.pharmacy.exception.PersistenceException;
import java.util.List;

/**
 *
 * @author Alexandr
 */
public interface ArticleDao {
        
    public List<Article> loadBestDiscountedArticles() throws PersistenceException;
    
    public Article save(Article article) throws PersistenceException;
    
    public List<Article> findArticlesByParameter(String parameter) throws PersistenceException;
}
