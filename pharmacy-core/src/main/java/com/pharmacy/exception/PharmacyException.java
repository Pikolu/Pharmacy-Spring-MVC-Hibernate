/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.exception;

import com.pharmacy.exception.type.ExceptionType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Alexandr
 */
public class PharmacyException extends Exception {

    private static final long serialVersionUID = 8147685415121127071L;
    protected ExceptionType exceptionType = ExceptionType.PE_0000;
    protected Set<String> details = new HashSet<>();
    static final String LINE_SEPARATOR = System.getProperty("line.separator", "\n");
    private static final Logger LOG = LoggerFactory.getLogger(PharmacyException.class);
    private List<ExceptionType> exceptionTypes = new ArrayList<>();
    
    public PharmacyException(ExceptionType exceptionType) {
        super(exceptionType.toString().concat("::").concat(StringUtils.defaultString(exceptionType.getDescription())));
        
        this.exceptionType = exceptionType;
    }
    
    public PharmacyException(ExceptionType exceptionType, String... details) {
        super(exceptionType.toString().concat("::").concat(StringUtils.defaultString(exceptionType.getDescription())).concat("::").concat(ArrayUtils.toString(details)));
        this.exceptionType = exceptionType;
        Collections.addAll(this.details, details);
    }
    
    public PharmacyException(ExceptionType exceptionType, List<ExceptionType> exceptionTypes) {
        super(exceptionType.toString().concat("::").concat(StringUtils.defaultString(exceptionType.getDescription())).concat("::"));
        this.exceptionType = exceptionType;
        this.exceptionTypes = exceptionTypes;
    }
    
    public PharmacyException(ExceptionType exceptionType, Throwable throwable) {
        super(exceptionType.toString().concat("::").concat(StringUtils.defaultString(exceptionType.getDescription())), throwable);
        this.exceptionType = exceptionType;
    }
    
    public PharmacyException(ExceptionType exceptionType, Throwable throwable, String... details) {
        super(exceptionType.toString().concat("::").concat(StringUtils.defaultString(exceptionType.getDescription())).concat("::").concat(ArrayUtils.toString(details)), throwable);
        this.exceptionType = exceptionType;
        Collections.addAll(this.details, details);
    }
    
    public PharmacyException(ExceptionType exceptionType, Throwable throwable, List<ExceptionType> exceptionTypes) {
        super(exceptionType.toString().concat("::").concat(StringUtils.defaultString(exceptionType.getDescription())), throwable);
        this.exceptionType = exceptionType;
        this.exceptionTypes = exceptionTypes;
    }
    
    public ExceptionType getExceptionType() {
        return exceptionType;
    }
    
    public Set<String> getDetails() {
        return details;
    }
    
    @Override
    public String toString() {
        return "PharmacyException{" + "exceptionType=" + exceptionType + ", description=" + exceptionType.getDescription() + "details=" + details + '}';
    }
    
    @Override
    public String getMessage() {
        
        LOG.trace("Enter: getMessage");
        StringBuilder message = new StringBuilder();
        
        if (!StringUtils.isEmpty(super.getCause().getMessage())) {
            message.append("ExceptionType: ").append(this.exceptionType).append(" | ");
            message.append("Description: ").append(this.exceptionType.getDescription()).append(" | ");
            message.append("Message: ").append(super.getCause().getMessage()).append(" | ");
            LOG.debug("add cause message to PharmacyException");
        } else {
            LOG.debug("no cause or cause is empty");
        }
        
        if (message.length() == 0) {
            LOG.debug("cause does exist");
            message.append("ExceptionType: ").append(this.exceptionType).append(" | ");
            message.append("Description: ").append(this.exceptionType.getDescription()).append(" | ");
            message.append("Details: ");
            for (String string : details) {
                message.append(string).append(", ");
            }
        } else {
            LOG.debug("cause doesn't exist");
            for (String string : details) {
                message.append(string).append(", ");
            }
        }
        
        LOG.trace("Exit: getMessage");
        return message.toString();
    }

    /**
     * This method returns only the message of the exception if any message is set
     *
     * @return the exception message
     */
    public String getMessageOnly() {
        String message = null;
        if (!StringUtils.isEmpty(super.getCause().getMessage())) {
            message = super.getCause().getMessage();
        }
        return message;
    }

    /**
     * write exception in logfile
     * @param logger
     */
    public void writeLog(Logger logger) {
        switch (exceptionType.getLogLevel()) {
            case TRACE:
                logger.trace("Exception: {}", getMessage());
                break;
            case INFO:
                logger.info("Exception: {}", getMessage());
                break;
            case ERROR:
                logger.error("Exception: {}", getMessage());
                break;
            case WARN:
                logger.warn("Exception: {}", getMessage());
                break;
            case DEBUG:
                logger.debug("Exception: {}", getMessage());
                break;
            default:
                break;
        }
    }

    /**
     *
     * @return String with ExceptionTypes
     */
    public String getExceptionTypes() {
        
        LOG.trace("Enter: writeExceptionTypes");
        StringBuffer exceptionsTypes = new StringBuffer();
        for (ExceptionType currentExceptionType : exceptionTypes) {
            exceptionsTypes.append(exceptionsTypes).append("; ");
            LOG.debug("add {} to exceptiontypes", currentExceptionType);
        }
        
        LOG.trace("Exit: writeExceptionTypes");
        return exceptionsTypes.toString();
    }

    /**
     *
     * @return String with ExceptionTypeDescriptions
     */
    public String getExceptionTypesDescription() {
        LOG.trace("Enter: writeExceptionTypesDescription");
        
        StringBuilder exceptionsTypesDescription = new StringBuilder();
        for (ExceptionType currentExceptionType : exceptionTypes) {
            if (!StringUtils.isEmpty(currentExceptionType.getDescription())) {
                exceptionsTypesDescription.append(currentExceptionType.getDescription()).append("; ");
            } else {
                exceptionsTypesDescription.append(currentExceptionType).append("; ");
            }
            
            LOG.debug("add {} to exceptiontypes description", currentExceptionType);
        }
        
        LOG.trace("Exit: writeExceptionTypesDescription");
        return exceptionsTypesDescription.toString();
    }
}
