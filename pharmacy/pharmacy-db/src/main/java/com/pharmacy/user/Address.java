/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.user;

import com.pharmacy.base.BaseUUID;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Alexandr
 */
@Entity
public class Address extends BaseUUID {

    private String company;
    @Column(length = 128)
    private String address;
    @Column(length = 128)
    private String city;
    @Column(length = 10)
    private String postCode;
    private String country;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Address {");
        result.append(" Company: ").append(company);
        result.append(" address: ").append(address);
        result.append(" City: ").append(city);
        result.append(" PostCode: ").append(postCode);
        result.append(" Country: ").append(country);
        result.append("}");
        return result.toString();
    }
}
