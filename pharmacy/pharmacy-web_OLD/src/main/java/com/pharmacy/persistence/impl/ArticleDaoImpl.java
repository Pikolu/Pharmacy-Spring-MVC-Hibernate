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
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Alexandr
 */
@Repository
public class ArticleDaoImpl implements ArticleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void save(Article article) {
        Session currentSession = sessionFactory.openSession();
        currentSession.save(article);
//        Transaction tx2 = currentSession.beginTransaction();
//        currentSession.merge(article);
//        tx2.commit();
        currentSession.close();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Article> loadBestDiscountedArticles() {
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.getNamedQuery("Article.findBestDicount");
        query.setMaxResults(15);
        List<Article> articles = query.list();
        return articles;
    }

}
