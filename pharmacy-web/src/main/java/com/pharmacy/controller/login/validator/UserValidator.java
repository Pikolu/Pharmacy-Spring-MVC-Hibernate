/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.controller.login.validator;

import com.pharmacy.exception.ServiceException;
import com.pharmacy.service.api.UserService;
import com.pharmacy.user.Account;
import com.pharmacy.user.User;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Alexandr
 */
@Component
public class UserValidator implements Validator {

    private static final Logger LOG = LoggerFactory.getLogger(UserValidator.class);

    @Autowired
    private UserService userService;

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    @Override
    public void validate(Object target, Errors errors) {
        LOG.trace("Enter validate: target={}, errors={}", target, errors);
        User user = (User) target;

        if (user.getFirstName() == null || user.getFirstName().isEmpty()) {
            errors.rejectValue("firstName", "message.EmptyFirstname");
        }
        if (user.getLastName() == null || user.getLastName().isEmpty()) {
            errors.rejectValue("lastName", "message.EmptyLastname");
        }

        LOG.debug("exit");
    }

    public void validate(Object target, Errors errors, boolean register) {

        User user = (User) target;

        validate(target, errors);
        Account account = user.getAccount();

        if (account.getEmail() == null || account.getEmail().isEmpty()) {
            errors.rejectValue("account.email", "message.EmptyEmail");
        } else if (!isValidEmailAddress(account.getEmail())) {
            errors.rejectValue("account.email", "message.InvalidEmail");
        }
        if (register) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User oldUser = (User) auth.getPrincipal();
            if (!oldUser.getAccount().getEmail().equals(user.getAccount().getEmail())) {
                checkEmail(account, errors);
            }
        } else {
            checkEmail(account, errors);
            if (!user.isAcceptedGeneralTerms()) {
                errors.rejectValue("acceptedGeneralTerms", "message.NoacceptedGeneralTerms");
            }
        }

        if (account.getPassword() == null || account.getPassword().isEmpty()) {
            errors.rejectValue("account.password", "message.EmptyPassword");
        } else if (!isPasswordValid(account.getPassword())) {
//            errors.rejectValue("account.password", "message.NotmatchPassword");
        } else if (account.getPasswordConfirm() == null || account.getPasswordConfirm().isEmpty()) {
            errors.rejectValue("account.passwordConfirm", "message.EmptyPasswordRepeat");
        } else if (!(account.getPassword().equals(account.getPasswordConfirm()))) {
            errors.rejectValue("account.password", "message.NotmatchPassword");
        }

    }

    private void checkEmail(Account account, Errors errors) {
        try {
            Account existAccout = userService.findAccoutByEmail(account.getEmail());
            if (existAccout != null) {
                errors.rejectValue("account.email", "message.DupplicateEmail");
            }
        } catch (ServiceException ex) {
            ex.writeLog(LOG);
        }
    }

    private boolean isPasswordValid(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        boolean result = matcher.matches();
        return result;
    }

    private boolean isValidEmailAddress(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        boolean result = matcher.matches();
        return result;
    }

    @Override
    public boolean supports(Class type) {
        return User.class.equals(type);
    }
}
