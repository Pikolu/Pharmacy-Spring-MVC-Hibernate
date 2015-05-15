/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.exception;

import com.pharmacy.exception.type.ExceptionType;
import java.util.List;

/**
 *
 * @author Alexandr
 */
public class PersistenceException extends ServiceException {

    public PersistenceException(ExceptionType exceptionType) {
        super(exceptionType);
    }

    public PersistenceException(ExceptionType exceptionType, List<ExceptionType> exceptionTypes) {
        super(exceptionType, exceptionTypes);
    }

    public PersistenceException(ExceptionType exceptionType, String... details) {
        super(exceptionType, details);
    }

    public PersistenceException(ExceptionType exceptionType, Throwable throwable) {
        super(exceptionType, throwable);
    }

    public PersistenceException(ExceptionType exceptionType, Throwable throwable, List<ExceptionType> exceptionTypes) {
        super(exceptionType, throwable, exceptionTypes);
    }

    public PersistenceException(ExceptionType exceptionType, Throwable throwable, String... details) {
        super(exceptionType, throwable, details);
    }
    
}
