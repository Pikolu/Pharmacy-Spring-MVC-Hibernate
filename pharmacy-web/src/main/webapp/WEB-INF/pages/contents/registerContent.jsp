<%-- 
    Document   : registerContent
    Created on : 24.08.2013, 21:51:52
    Author     : Alexandr
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="container">
    <div id="content">
        <h1>
            <s:message code="label.loginNow" />
        </h1>
        <div class="box">

            <div class="box-container">
                <p>
                    <s:message code="label.alreadyRegistration" /> 
                <c:url value="/login.html" var="login"></c:url>
                <a href="${login}">
                    <s:message code="label.alreadyRegistrationLogin" />.
                </a>
                </p>
                <c:url value="/registration.html" var="registration"></c:url>
                    <form:form action="${registration}" method="post" id="register">
                    <h2><s:message code="label.yourPersonData" /></h2>
                    <div class="content">
                        <table class="form">
                            <tbody><tr>
                                    <td>
                                        <span class="required">*</span> 
                                        <s:message code="label.firstname" />:
                                    </td>
                                    <td>
                                        <form:input cssClass="q1" path="firstName"/>
                                        <form:errors path="firstName" cssClass="error" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="required">*</span> 
                                        <s:message code="label.lastname" />:
                                    </td>
                                    <td>
                                        <form:input cssClass="q1" path="lastName"/>
                                        <form:errors path="lastName" cssClass="error" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="required">*</span> 
                                        <s:message code="label.email" />:
                                    </td>
                                    <td>
                                        <input class="q1" name="account.email" value="" type="text">
                                        <form:errors path="account.email" cssClass="error" />
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>

                    <h2> <s:message code="label.yourPassword" /></h2>
                    <div class="content">
                        <table class="form">
                            <tbody>
                                <tr>
                                    <td>
                                        <span class="required">*</span> 
                                        <s:message code="label.password" />:
                                    </td>
                                    <td>
                                        <input class="q1" name="account.password" value="" type="password">
                                        <form:errors path="account.password" cssClass="error" />

                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="required">*</span> 
                                        <s:message code="label.passwordRepeat" />:
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
                            <s:message code="label.acceptGeneralTerms" />
                            <c:url value="/help/policies/user-agreement.html" var="agreement"></c:url>
                            <!--/help/policies/user-agreement-->
                            <a class="colorbox cboxElement" href="${agreement}" alt="General Terms">
                                <b><s:message code="label.MFGeneralTerms" /></b>
                            </a> 
                            <input name="acceptedGeneralTerms" value="1" type="checkbox">
                            <form:errors path="acceptedGeneralTerms" cssClass="error" />
                            <a onclick="$('#register').submit();" class="button">
                                <span><s:message code="label.next" /></span>
                            </a>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
