/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.user;

import com.pharmacy.base.BaseUUID;
import com.pharmacy.wishlist.Wishlist;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Alexandr
 */
@Entity
@Table(name = "enduser")
@NamedQueries({
    @NamedQuery(name = "User.findUserByEmail", query = "SELECT u FROM User u LEFT JOIN u.account a WHERE a.email = :email")
})
public class User extends BaseUUID implements UserDetails {

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
    private boolean acceptedGeneralTerms;

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

    /**
     * @return the acceptedGeneralTerms
     */
    public boolean isAcceptedGeneralTerms() {
        return acceptedGeneralTerms;
    }

    /**
     * @param acceptedGeneralTerms the acceptedGeneralTerms to set
     */
    public void setAcceptedGeneralTerms(boolean acceptedGeneralTerms) {
        this.acceptedGeneralTerms = acceptedGeneralTerms;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> setAuths = new HashSet<>();
        // Build user's authorities
//        for (UserRole userRole : this.getAccount().getUserRole()) {
            setAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
//        }
        List<GrantedAuthority> result = new ArrayList<>(setAuths);
        return result;
    }

    @Override
    public String getPassword() {
        return this.getAccount().getPassword();
    }

    @Override
    public String getUsername() {
        return this.getAccount().getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
