/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.persistence.impl;

import com.pharmacy.article.Article;
import com.pharmacy.article.Article_;
import com.pharmacy.controller.abstraction.DataWithCount;
import com.pharmacy.controller.abstraction.FilterOptions;
import com.pharmacy.exception.PersistenceException;
import com.pharmacy.persistence.api.ArticleDao;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.apache.commons.lang.ArrayUtils;
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
        ArrayList<Article> articles = new ArrayList<>();
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Article> query = builder.createQuery(Article.class);
        Root<Article> root = query.from(Article.class);

        Predicate predicate = builder.like(root.get(Article_.name), "%" + parameter + "%");
        query.where(predicate);
        query.select(root);
        TypedQuery<Article> sqlQuery = getEntityManager().createQuery(query);
        List<Article> searchTitleArticles = sqlQuery.getResultList();
        if (searchTitleArticles.isEmpty()) {
            Predicate predicate2 = builder.like(root.get(Article_.description), "%" + parameter + "%");
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

    @Override
    public List<Article> findArticlesByParameter(String parameter, FilterOptions filterOptions) {
        LOG.trace("Enter findArticlesByParameter: parameter={}", parameter);

        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Article> query = builder.createQuery(Article.class);
        Root<Article> root = query.from(Article.class);

//        query.orderBy(builder.asc(root.get(Article_.name)));
        Predicate[] predicates = getSearchPredicate(parameter, builder, root);
        query.where(builder.or(predicates));
        query.select(root);

        TypedQuery<Article> sqlQuery = getEntityManager().createQuery(query);
        sqlQuery.setFirstResult((filterOptions.getCurrentPage() - 1) * filterOptions.getRecordsPerPage());
        sqlQuery.setMaxResults(filterOptions.getRecordsPerPage());
        List<Article> articles = sqlQuery.getResultList();

        LOG.trace("Exit findArticlesByParameter: articles size={}", articles.size());
        return articles;
    }

    private Predicate[] getSearchPredicate(String parameter, CriteriaBuilder builder, Root<Article> root) {
        List<Predicate> predicates = new ArrayList<>();
        
        Expression<String> lowerName = builder.lower(root.get(Article_.name));
        Expression<String> lowerDescription = builder.lower(root.get(Article_.description));
                
        Predicate predicate = builder.like(lowerName, "%" + parameter.toLowerCase() + "%");
        Predicate predicate2 = builder.like(lowerDescription, "%" + parameter.toLowerCase() + "%");
        predicates.add(predicate);
        predicates.add(predicate2);
        return predicates.toArray(new Predicate[predicates.size()]);
    }

    @Override
    public DataWithCount<Article> loadTableContent(String parameter, FilterOptions filterOptions) throws PersistenceException {
        Long count = getCount(parameter);
        List<Article> articles = findArticlesByParameter(parameter, filterOptions);
        DataWithCount<Article> dataWithCount = new DataWithCount<>();
        dataWithCount.setCount(count);
        dataWithCount.setResultList(articles);
        return dataWithCount;
    }

    public Long getCount(String parameter) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);
        Root<Article> root = query.from(Article.class);
        query.select(builder.count(root));
        Predicate[] predicates = getSearchPredicate(parameter, builder, root);

        query.where(builder.or(predicates));
        TypedQuery<Long> sqlQuery = getEntityManager().createQuery(query);
        return sqlQuery.getSingleResult();
    }

    @Override
    public Article findArticleByArticelNumber(String articelNumber) {
        Article article = null;
        TypedQuery<Article> query = getEntityManager().createNamedQuery("findArticleByArticleNumber", Article.class);
        query.setParameter("articelNumber", Integer.valueOf(articelNumber));
        try {
            article = query.getSingleResult();
        } catch (NoResultException e) {
            //do nothing
        }
        return article;
    }

}
