/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.service.api;

import com.pharmacy.article.Article;
import java.util.List;

/**
 *
 * @author Alexandr
 */
public interface ArticleService {
    
    public void save(Article article);
    
    public List<Article> loadBestDiscountedArticles();
    
}
