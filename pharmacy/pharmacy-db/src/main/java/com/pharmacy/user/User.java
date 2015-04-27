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
@Table(name = "employee")
@NamedQueries({
        @NamedQuery(name = "User.findUserByEmail", query = "SELECT u FROM User u WHERE u.email = :email")})
public class User extends BaseUUID {

    @Column(length = 32)
    private String firstName;
    @Column(length = 32)
    private String lastName;
    private String email;
    @Column(length = 32)
    private String phone;
    private String password;
    @Transient
    private String passwordConfirm;
    private boolean newslatter = false;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    private Wishlist wishlist;

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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
//        if (password != null && !password.isEmpty()) {
//            this.password = DigestUtils.sha512Hex(password);
//        }
    }

    /**
     * @return the passwordConfirm
     */
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    /**
     * @param passwordConfirm the passwordConfirm to set
     */
    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("User {");
        result.append(" firstName: ").append(firstName);
        result.append(" lastName: ").append(lastName);
        result.append(" email: ").append(email);
        result.append(" phone: ").append(phone);
        result.append(" address: ").append(address);
        result.append(" password: ").append(password);
        result.append(" passwordConfirm: ").append(passwordConfirm);
        result.append("}");
        return result.toString();
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
}
