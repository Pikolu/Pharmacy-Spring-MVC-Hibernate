/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.persistence.impl;

import com.pharmacy.article.Article;
import com.pharmacy.persistence.api.ArticleDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Alexandr
 */
@Repository
public class ArticleDaoImpl implements ArticleDao {

//    @Autowired
//    private SessionFactory sessionFactory;
    @PersistenceContext(unitName = "PharmacyUnit")
    private EntityManager entityManager;

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void save(Article article) {
//        Session currentSession = sessionFactory.openSession();
//        currentSession.save(article);
//        Transaction tx2 = currentSession.beginTransaction();
//        currentSession.merge(article);
//        tx2.commit();
//        currentSession.close();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Article> loadBestDiscountedArticles() {
        
        Article article = new Article();
        article.setTitle("asdasd");
        entityManager.merge(article);
        
//        TypedQuery<Article> query = entityManager.createNamedQuery("Article.findBestDicount", Article.class);
//        query.setMaxResults(15);
//        List<Article> articles = query.getResultList();
//        Session currentSession = sessionFactory.openSession();
//        Query query = currentSession.getNamedQuery("Article.findBestDicount");
//        query.setMaxResults(15);
//        List<Article> articles = query.list();
        return null;
    }

}
