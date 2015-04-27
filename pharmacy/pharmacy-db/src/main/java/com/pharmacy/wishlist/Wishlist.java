/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.wishlist;

import com.pharmacy.article.Article;
import com.pharmacy.base.BaseUUID;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author Alexandr
 */
@Entity
public class Wishlist extends BaseUUID {

    @OneToMany(cascade = CascadeType.ALL)
    private List<Article> articles;

    /**
     * @return the articles
     */
    public List<Article> getArticles() {
        return articles;
    }

    /**
     * @param articles the articles to set
     */
    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
