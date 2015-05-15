/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.exception.type;

import com.pharmacy.loglevel.LogLevel;

/**
 *
 * @author Alexandr
 */
public enum ExceptionType {

    PE_0000(LogLevel.INFO, "Beschreibung für die GUI", "Beschreibung für die Log-Ausgabe"),
    LOGIN_0001(LogLevel.INFO, "Benutzername oder Passwort ist falsch.", "Could not found user in DB. Check email {} by user.");

    private LogLevel logLevel;
    private String resourceKey;
    private String description;

    private ExceptionType(LogLevel logLevel, String resourceKey, String description) {
        this.logLevel = logLevel;
        this.resourceKey = resourceKey;
        this.description = description;
    }

    /**
     * @return the logLevel
     */
    public LogLevel getLogLevel() {
        return logLevel;
    }

    /**
     * @param logLevel the logLevel to set
     */
    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    /**
     * @return the resourceKey
     */
    public String getResourceKey() {
        return resourceKey;
    }

    /**
     * @param resourceKey the resourceKey to set
     */
    public void setResourceKey(String resourceKey) {
        this.resourceKey = resourceKey;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
