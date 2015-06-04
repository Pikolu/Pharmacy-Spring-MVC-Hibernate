/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.article;

import com.pharmacy.base.BaseUUID;
import com.pharmacy.csv.CSVFormat;
import com.pharmacy.evaluation.Evaluation;
import com.pharmacy.payment.PaymentType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Alexandr
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "findAllPharmacies", query = "SELECT p FROM Pharmacy p")
})
public class Pharmacy extends BaseUUID {

    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Evaluation> evaluations;
    @ElementCollection(targetClass = PaymentType.class)
    @Enumerated(EnumType.STRING)
    private Collection<PaymentType> paymentTypes;
    private float shipping;
    @OneToMany(cascade = CascadeType.ALL)
    private List<CSVFormat> csvFormat;
    private String logoURL;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "price_id")
    private Price price;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the evaluations
     */
    public List<Evaluation> getEvaluations() {
        if (evaluations == null) {
            evaluations = new ArrayList<>();
        }
        return evaluations;
    }

    /**
     * @param evaluations the evaluations to set
     */
    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    /**
     * @return the shipping
     */
    public float getShipping() {
        return shipping;
    }

    /**
     * @param shipping the shipping to set
     */
    public void setShipping(float shipping) {
        this.shipping = shipping;
    }

    /**
     * @return the csvFormat
     */
    public List<CSVFormat> getCsvFormat() {
        return csvFormat;
    }

    /**
     * @param csvFormat the csvFormat to set
     */
    public void setCsvFormat(List<CSVFormat> csvFormat) {
        this.csvFormat = csvFormat;
    }

    /**
     * @return the logoURL
     */
    public String getLogoURL() {
        return logoURL;
    }

    /**
     * @param logoURL the logoURL to set
     */
    public void setLogoURL(String logoURL) {
        this.logoURL = logoURL;
    }

    /**
     * @return the price
     */
    public Price getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Price price) {
        this.price = price;
    }

    /**
     * @return the paymentTypes
     */
    public Collection<PaymentType> getPaymentTypes() {
        return paymentTypes;
    }

    /**
     * @param paymentTypes the paymentTypes to set
     */
    public void setPaymentTypes(Collection<PaymentType> paymentTypes) {
        this.paymentTypes = paymentTypes;
    }

    @Override
    public String toString() {
        return "Pharmacy{" + "name=" + name + ", evaluations=" + evaluations + ", paymentTypes=" + paymentTypes + ", shipping=" + shipping + ", csvFormat=" + csvFormat + ", logoURL=" + logoURL + ", price=" + price + '}';
    }

}
