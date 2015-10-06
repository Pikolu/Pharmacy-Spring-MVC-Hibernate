/*
 * Copyright 2015 Alexander.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pharmacy.controller.contact.validation;

import com.pharmacy.user.Contact;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Alexander
 */
@Component
public class ContactValidator implements Validator {

    private static final Logger LOG = LoggerFactory.getLogger(ContactValidator.class);

    @Override
    public boolean supports(Class<?> clazz) {
        return Contact.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Contact contact = (Contact) target;
        LOG.info("Validate contact form. {}", contact);

        if (StringUtils.isBlank(contact.getName())) {

        }

        if (StringUtils.isBlank(contact.getDescription())) {

        }

        if (StringUtils.isBlank(contact.getEmail())) {

        }
    }

}
