package com.pharmacy.users.service;

import com.pharmacy.persistence.api.AccountDao;
import com.pharmacy.persistence.api.UserDao;
import com.pharmacy.service.api.UserService;
import com.pharmacy.user.Account;
import com.pharmacy.user.UserRole;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyUserDetailsService implements UserDetailsService, UserService {

    @Autowired
    private AccountDao accountDao;
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        Account account = getAccountDao().findAccountByEmail(email);
        List<GrantedAuthority> authorities = buildUserAuthority(account.getUserRole());

        return buildUserForAuthentication(account, authorities);

    }

    private User buildUserForAuthentication(Account account, List<GrantedAuthority> authorities) {
        return new User(account.getEmail(), account.getPassword(), true, true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<>();

        // Build user's authorities
        for (UserRole userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRoleName()));
        }

        List<GrantedAuthority> Result = new ArrayList<>(setAuths);

        return Result;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(com.pharmacy.user.User user) {
        Account account = user.getAccount();
        Set<UserRole> userRoles = new HashSet<>();
        UserRole userRole = new UserRole();
        userRole.setRoleName("ROLE_USER");
        userRole.setUser(user);
        userRole.setUserRoleId(1);
        userRoles.add(userRole);
        account.setUserRole(userRoles);
        userDao.save(user);
        sendEmail(user.getAccount().getEmail());
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

}
