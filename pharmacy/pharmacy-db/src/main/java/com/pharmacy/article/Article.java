/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.article;

import com.pharmacy.base.BaseUUID;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * @author Alexandr
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Article.findBestDicount", query = "SELECT a FROM Article a "
            + "LEFT JOIN a.prices p "
            + "WHERE p.discount = (SELECT MAX(pr.discount) FROM Article ar LEFT JOIN ar.prices pr)"),
    @NamedQuery(name = "Article.findArticleByName", query = "SELECT a FROM Article a WHERE a.title = :title")
})
public class Article extends BaseUUID {

    private int articelNumber;
    private String categoryName;
    @Column(unique = true)
    private String title;
    private String descriptionShort;
    @Column(length = 50000)
    private String descriptionLong;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @Column(length = 5000)
    private String imageURL;
    @Column(length = 5000)
    private String deepLink;
    private String keyWords;
    private String manufacturer;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "article_id")
    private List<Price> prices;

    /**
     * @return the articelNumber
     */
    public int getArticelNumber() {
        return articelNumber;
    }

    /**
     * @param articelNumber the articelNumber to set
     */
    public void setArticelNumber(int articelNumber) {
        this.articelNumber = articelNumber;
    }

    /**
     * @return the categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName the categoryName to set
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the currency
     */
    public Currency getCurrency() {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    /**
     * @return the imageURL
     */
    public String getImageURL() {
        return imageURL;
    }

    /**
     * @param imageURL the imageURL to set
     */
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    /**
     * @return the deepLink
     */
    public String getDeepLink() {
        return deepLink;
    }

    /**
     * @param deepLink the deepLink to set
     */
    public void setDeepLink(String deepLink) {
        this.deepLink = deepLink;
    }

    /**
     * @return the keyWords
     */
    public String getKeyWords() {
        return keyWords;
    }

    /**
     * @param keyWords the keyWords to set
     */
    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    /**
     * @return the Manufacturer
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * @param manufacturer the Manufacturer to set
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * @return the descriptionShort
     */
    public String getDescriptionShort() {
        return descriptionShort;
    }

    /**
     * @param descriptionShort the descriptionShort to set
     */
    public void setDescriptionShort(String descriptionShort) {
        this.descriptionShort = descriptionShort;
    }

    /**
     * @return the descriptionLong
     */
    public String getDescriptionLong() {
        return descriptionLong;
    }

    /**
     * @param descriptionLong the descriptionLong to set
     */
    public void setDescriptionLong(String descriptionLong) {
        this.descriptionLong = descriptionLong;
    }

    /**
     * @return the prices
     */
    public List<Price> getPrices() {
        if (prices == null) {
            prices = new ArrayList<>();
        }
        return prices;
    }

    /**
     * @param prices the prices to set
     */
    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    @Override
    public String toString() {
        return "Article{" + "articelNumber=" + articelNumber + ", categoryName=" + categoryName + ", title=" + title + ", descriptionShort=" + descriptionShort + ", descriptionLong=" + descriptionLong + ", currency=" + currency + ", imageURL=" + imageURL + ", deepLink=" + deepLink + ", keyWords=" + keyWords + ", manufacturer=" + manufacturer + ", prices=" + prices + '}';
    }

}
