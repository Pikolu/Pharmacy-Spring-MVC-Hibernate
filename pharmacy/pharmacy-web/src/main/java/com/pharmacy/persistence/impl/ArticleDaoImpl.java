/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.persistence.impl;

import com.pharmacy.article.Article;
import com.pharmacy.article.Article_;
import com.pharmacy.exception.PersistenceException;
import com.pharmacy.persistence.api.ArticleDao;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Alexandr
 */
@Repository
public class ArticleDaoImpl extends AbstractJpaDAO<Article> implements ArticleDao {
    
    private final static Logger LOG = LoggerFactory.getLogger(ArticleDaoImpl.class);

    public ArticleDaoImpl() {
        super(Article.class);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Article> loadBestDiscountedArticles() throws PersistenceException {
        LOG.trace("Enter loadBestDiscountedArticles");
        TypedQuery<Article> query = getEntityManager().createNamedQuery("Article.findBestDicount", Article.class);
        query.setMaxResults(15);
        List<Article> articles = query.getResultList();
        LOG.trace("Exit loadBestDiscountedArticles: articles={}", articles);
        return articles;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Article> findArticlesByParameter(String parameter) throws PersistenceException {
        LOG.trace("Enter findArticlesByParameter: parameter={}", parameter);
        ArrayList<Article> articles = new ArrayList<Article>();
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Article> query = builder.createQuery(Article.class);
        Root<Article> root = query.from(Article.class);

        Predicate predicate = builder.like(root.get(Article_.title), "%" + parameter + "%");
        query.where(predicate);
        query.select(root);
        TypedQuery<Article> sqlQuery = getEntityManager().createQuery(query);
        List<Article> searchTitleArticles = sqlQuery.getResultList();
        if (searchTitleArticles.isEmpty()) {
            Predicate predicate2 = builder.like(root.get(Article_.descriptionShort), "%" + parameter + "%");
            query.where(builder.or(predicate, predicate2));
            query.select(root);
            sqlQuery = getEntityManager().createQuery(query);
            List<Article> searchedDescriptionShortArticles = sqlQuery.getResultList();
            articles.addAll(searchedDescriptionShortArticles);
        } else {
            articles.addAll(searchTitleArticles);
        }
        
        LOG.trace("Exit findArticlesByParameter: articles size={}", articles.size());
        return articles;
    }

}
