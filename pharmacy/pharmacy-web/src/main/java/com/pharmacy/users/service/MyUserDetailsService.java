package com.pharmacy.users.service;

import com.pharmacy.exception.PersistenceException;
import com.pharmacy.exception.ServiceException;
import com.pharmacy.exception.type.ExceptionType;
import com.pharmacy.persistence.api.AccountDao;
import com.pharmacy.persistence.api.UserDao;
import com.pharmacy.service.api.UserService;
import com.pharmacy.user.Account;
import com.pharmacy.user.User;
import com.pharmacy.user.UserRole;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyUserDetailsService implements UserDetailsService, UserService {

    private static final Logger LOG = LoggerFactory.getLogger(MyUserDetailsService.class);

    @Autowired
    private AccountDao accountDao;
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        User user = null;
        try {
            user = getUserDao().findUserByEmail(email);
            if (user == null) {
                throw new ServiceException(ExceptionType.LOGIN_0004);
            }
        } catch (PersistenceException ex) {
            ex.writeLog(LOG);
            throw new UsernameNotFoundException(ex.getExceptionType().getResourceKey(), ex);
        } catch (ServiceException ex) {
            ex.writeLog(LOG);
            throw new UsernameNotFoundException(ex.getExceptionType().getResourceKey(), ex);
        }
        return user;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(com.pharmacy.user.User user) throws ServiceException {
        try {
            Account account = user.getAccount();
            Set<UserRole> userRoles = new HashSet<>();
            UserRole userRole = new UserRole();
            userRole.setRoleName("ROLE_USER");
            userRole.setUser(user);
            userRole.setUserRoleId(1);
            userRoles.add(userRole);
            account.setUserRole(userRoles);
            getUserDao().save(user);
//            sendEmail(user.getAccount().getEmail());
        } catch (PersistenceException ex) {
            ex.writeLog(LOG);
            throw ex;
        }
    }

    private void sendEmail(String email) {
        final String username = "smokkymoo@gmail.com";
        final String password = "K.568134";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("smokkymoo@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email));
            message.setSubject("Testing Subject");
            message.setText("Dear Mail Crawler,"
                    + "\n\n No spam to my email, please!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @return the accountDao
     */
    public AccountDao getAccountDao() {
        return accountDao;
    }

    /**
     * @param accountDao the accountDao to set
     */
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account findAccoutByEmail(String email) throws ServiceException {
        Account account;
        try {
            account = accountDao.findAccountByEmail(email);
        } catch (PersistenceException e) {
            e.writeLog(LOG);
            throw e;
        }
        return account;
    }

    /**
     * @return the userDao
     */
    public UserDao getUserDao() {
        return userDao;
    }

    /**
     * @param userDao the userDao to set
     */
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

}
