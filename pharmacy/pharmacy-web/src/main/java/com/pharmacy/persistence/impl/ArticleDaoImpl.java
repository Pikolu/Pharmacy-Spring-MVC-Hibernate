/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.persistence.impl;

import com.pharmacy.article.Article;
import com.pharmacy.persistence.api.ArticleDao;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alexandr
 */
@Repository
public class ArticleDaoImpl implements ArticleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Article article) {
        Session currentSession = sessionFactory.openSession();
        Transaction tx2 = currentSession.beginTransaction();
        currentSession.merge(article);
        tx2.commit();
        currentSession.close();
    }

    @Override
    public List<Article> loadBestDiscountedArticles() {
        List<Article> articles = new ArrayList<>();
        Session currentSession = sessionFactory.openSession();
        Transaction tx2 = currentSession.beginTransaction();
        tx2.commit();
        currentSession.close();
        return articles;
    }

}
