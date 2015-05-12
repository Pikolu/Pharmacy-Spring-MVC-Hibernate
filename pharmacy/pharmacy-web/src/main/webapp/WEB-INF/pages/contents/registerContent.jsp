<%-- 
    Document   : registerContent
    Created on : 24.08.2013, 21:51:52
    Author     : Alexandr
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="container">
    <div id="content">
        <h1>Jetzt bei medizin-finder.de anmelden</h1>
        <div class="box-container">
            <p>
                Sie haben sich schon angemeldet? 
            <c:url value="/login.html" var="login"></c:url>
            <a href="${login}">Einloggen</a>
            .
            </p>
            <c:url value="/registration.html" var="registration"></c:url>
                <form:form action="${registration}" method="post" id="register">
                <h2>Ihre persönliche Daten</h2>
                <div class="content">
                    <table class="form">
                        <tbody><tr>
                                <td>
                                    <span class="required">*</span> 
                                    Vorname:
                                </td>
                                <td>
                                    <form:input cssClass="q1" path="firstName"/>
                                    <form:errors path="firstName" cssClass="error" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <span class="required">*</span> 
                                    Nachname:
                                </td>
                                <td>
                                    <form:input cssClass="q1" path="lastName"/>
                                    <form:errors path="lastName" cssClass="error" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <span class="required">*</span> 
                                    E-Mail:
                                </td>
                                <td>
                                    <input class="q1" name="account.email" value="" type="text">
                                    <form:errors path="account.email" cssClass="error" />
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                
                <h2>Ihr Passwort</h2>
                <div class="content">
                    <table class="form">
                        <tbody>
                            <tr>
                                <td>
                                    <span class="required">*</span> 
                                    Passwort:
                                </td>
                                <td>
                                    <input class="q1" name="account.password" value="" type="password">
                                    <form:errors path="account.password" cssClass="error" />

                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <span class="required">*</span> 
                                    Passwort wiederholen
                                </td>
                                <td>
                                    <input class="q1" name="account.passwordConfirm" value="" type="password">
                                    <form:errors path="account.passwordConfirm" cssClass="error" />

                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <div class="right">
                        Mit meiner Anmeldung akzeptiere ich die 
                        <a class="colorbox cboxElement" href="#" alt="Privacy Policy">
                            <b>medizin-finder.de AGB</b>
                        </a> 
                        <input name="agree" value="1" type="checkbox">
                        <a onclick="$('#register').submit();" class="button">
                            <span>Continue</span>
                        </a>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>
