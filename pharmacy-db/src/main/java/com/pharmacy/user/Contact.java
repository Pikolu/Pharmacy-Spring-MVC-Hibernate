/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.user;

import com.pharmacy.base.BaseUUID;
import javax.persistence.Entity;

/**
 *
 * @author Alexander
 */
@Entity
public class Contact extends BaseUUID {

    private String email;
    private boolean sendEmailToMyAddress;

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
     * @return the sendEmailToMyAddress
     */
    public boolean isSendEmailToMyAddress() {
        return sendEmailToMyAddress;
    }

    /**
     * @param sendEmailToMyAddress the sendEmailToMyAddress to set
     */
    public void setSendEmailToMyAddress(boolean sendEmailToMyAddress) {
        this.sendEmailToMyAddress = sendEmailToMyAddress;
    }

    @Override
    public String toString() {
        return "Contact{" + "email=" + email + ", sendEmailToMyAddress=" + sendEmailToMyAddress + '}';
    }
}
