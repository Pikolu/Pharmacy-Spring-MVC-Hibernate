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
public class ServiceException extends ControllerException {

    public ServiceException(ExceptionType exceptionType) {
        super(exceptionType);
    }

    public ServiceException(ExceptionType exceptionType, List<ExceptionType> exceptionTypes) {
        super(exceptionType, exceptionTypes);
    }

    public ServiceException(ExceptionType exceptionType, String... details) {
        super(exceptionType, details);
    }

    public ServiceException(ExceptionType exceptionType, Throwable throwable) {
        super(exceptionType, throwable);
    }

    public ServiceException(ExceptionType exceptionType, Throwable throwable, List<ExceptionType> exceptionTypes) {
        super(exceptionType, throwable, exceptionTypes);
    }

    public ServiceException(ExceptionType exceptionType, Throwable throwable, String... details) {
        super(exceptionType, throwable, details);
    }

}
