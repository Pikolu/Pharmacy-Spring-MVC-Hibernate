/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.user;

import com.pharmacy.base.BaseUUID;
import com.pharmacy.wishlist.Wishlist;

import javax.persistence.*;

/**
 * @author Alexandr
 */
@Entity
@Table(name = "enduser")
public class User extends BaseUUID {

    @Column(length = 32)
    private String firstName;
    @Column(length = 32)
    private String lastName;
    @Column(length = 32)
    private String phone;
    private boolean newslatter = false;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    private Wishlist wishlist;
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the newslatter
     */
    public boolean isNewslatter() {
        return newslatter;
    }

    /**
     * @param newslatter the newslatter to set
     */
    public void setNewslatter(boolean newslatter) {
        this.newslatter = newslatter;
    }

    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * @return the wishlist
     */
    public Wishlist getWishlist() {
        return wishlist;
    }

    /**
     * @param wishlist the wishlist to set
     */
    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }

    /**
     * @return the account
     */
    public Account getAccount() {
        if (account == null) {
            account = new Account();
        }
        return account;
    }

    /**
     * @param account the account to set
     */
    public void setAccount(Account account) {
        this.account = account;
    }
}
