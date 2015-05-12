/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.controller.login.validator;

import com.pharmacy.user.Account;
import com.pharmacy.user.User;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Alexandr
 */
@Service
public class UserValidator implements Validator {
    
    Logger LOG = LoggerFactory.getLogger(UserValidator.class);

    private static final String EMAIL_PATTERN
            = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    public void validate(Object target, Errors errors) {
        LOG.trace("Enter validate: target={}, errors={}", target, errors);
        User user = (User) target;

        if (user.getFirstName() == null || user.getFirstName().isEmpty()) {
            errors.rejectValue("firstName", "empty.user.firstname");
        }
        if (user.getLastName() == null || user.getLastName().isEmpty()) {
            errors.rejectValue("lastName", "empty.user.lastname");
        }
        Account account = user.getAccount();
        if (account.getEmail() == null || account.getEmail().isEmpty()) {
            errors.rejectValue("account.email", "empty.user.email");
        } else if (!isValidEmailAddress(account.getEmail())) {
            errors.rejectValue("account.email", "invalid.user.email");
        }
        if (account.getPassword() == null || account.getPassword().isEmpty()) {
            errors.rejectValue("account.password", "empty.user.password");
        } else if (account.getPasswordConfirm() == null || account.getPasswordConfirm().isEmpty()) {
            errors.rejectValue("account.passwordConfirm", "empty.user.passwordRepeat");
        } else if (!(account.getPassword().equals(account.getPasswordConfirm()))) {
            errors.rejectValue("account.password", "notmatch.user.password");
        }
        LOG.debug("exit");
    }

    private boolean isValidEmailAddress(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        boolean result = matcher.matches();
        return result;
    }

    @Override
    public boolean supports(Class type) {
        return User.class.isAssignableFrom(type);
    }
}
