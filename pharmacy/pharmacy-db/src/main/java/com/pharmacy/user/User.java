/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.user;

import com.pharmacy.base.BaseUUID;
import com.pharmacy.wishlist.Wishlist;
import java.util.HashSet;
import java.util.Set;

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
    @OneToMany(cascade = CascadeType.ALL)
    private Set<UserRole> userRole = new HashSet<>(0);

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
     * @return the userRole
     */
    public Set<UserRole> getUserRole() {
        return userRole;
    }

    /**
     * @param userRole the userRole to set
     */
    public void setUserRole(Set<UserRole> userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "User{" + "firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone + ", password=" + password + ", passwordConfirm=" + passwordConfirm + ", newslatter=" + newslatter + ", address=" + address + ", wishlist=" + wishlist + ", userRole=" + userRole + '}';
    }
}
