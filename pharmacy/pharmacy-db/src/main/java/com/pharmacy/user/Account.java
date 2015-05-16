/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.user;

import com.pharmacy.base.BaseUUID;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 *
 * @author Alexandr
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Account.findAccountByEmail", query = "SELECT a FROM Account a WHERE a.email = :email")})
public class Account extends BaseUUID {

    private String email;
    private String password;
    @Transient
    private String passwordConfirm;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<UserRole> userRole = new HashSet<>(0);

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
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;//DigestUtils.sha256Hex(password);
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
        this.passwordConfirm = passwordConfirm;//DigestUtils.sha256Hex(passwordConfirm);;
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


}
