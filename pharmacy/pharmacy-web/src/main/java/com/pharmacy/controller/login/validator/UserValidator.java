/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.controller.login.validator;

//import com.moneta.user.Address;
//import com.moneta.user.User;
//import javax.mail.internet.AddressException;
//import javax.mail.internet.InternetAddress;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import com.pharmacy.user.Address;
import com.pharmacy.user.User;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Alexandr
 */
@Service
public class UserValidator implements Validator {

    private static final String EMAIL_PATTERN
            = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    public void validate(Object target, Errors errors) {

        User user = (User) target;

        if (user.getFirstName() == null || user.getFirstName().isEmpty()) {
            errors.rejectValue("firstName", "empty.user.firstname");
        }
        if (user.getLastName() == null || user.getLastName().isEmpty()) {
            errors.rejectValue("lastName", "empty.user.lastname");
        }
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            errors.rejectValue("email", "empty.user.email");
        } else if (!isValidEmailAddress(user.getEmail())) {
            errors.rejectValue("email", "invalid.user.email");
        }
        Address address = user.getAddress();
        if (address.getAddress() == null || address.getAddress().isEmpty()) {
            errors.rejectValue("address.address", "labelRegistrationNoAddress");
        }
        if (address.getCity() == null || address.getCity().isEmpty()) {
            errors.rejectValue("address.city", "labelRegistrationNoCity");
        }
        if (address.getPostCode() == null || address.getPostCode().isEmpty()) {
            errors.rejectValue("address.postCode", "labelRegistrationNoPostCode");
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            errors.rejectValue("password", "empty.user.password");
        } else if (user.getPasswordConfirm() == null || user.getPasswordConfirm().isEmpty()) {
            errors.rejectValue("passwordConfirm", "empty.user.passwordRepeat");
        } else if (!(user.getPassword().equals(user.getPasswordConfirm()))) {
            errors.rejectValue("password", "notmatch.user.password");
        }
//        logger.debug("exit");
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
