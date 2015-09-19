<%-- 
    Document   : mainContent
    Created on : 24.08.2013, 21:36:52
    Author     : Alexandr
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html xmlns:th="http://www.thymeleaf.org">
    <%@page contentType="text/html" pageEncoding="UTF-8" %>
    <div id="container">
        <div id="notification"></div>
        <div id="content">
            <h1>Account</h1>

            <div id="column-left">
                <div class="box category">
                    <div class="box-heading">Alle Kategorien</div>
                    <div class="box-content">
                        <div class="box-category">
                            <ul>
                                <li class="cat-header">
                                    <c:url value="/account" var="account"/>
                                    <a class="idCatSubcat" href="${account}">Persönliche Daten</a>
                                </li>
                                <li class="cat-header">
                                    <c:url value="/account" var="account"/>
                                    <a class="idCatSubcat" href="${account}">Meine Bewertungen</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>


            <div class="box" style="margin-left: 250px">
                <div class="box-heading">Persönliche Daten</div>
                <div class="box-content">
                    <div class="box-product">
                        <div class="user-account">
                            <spring:url value="/account" var="account" />
                            <form:form action="${account}" method="post" id="register" modelAttribute="userForm">
                            <h2><s:message code="label.yourPersonData"/></h2>
                            <form:hidden cssClass="q1" path="id" />
                            <div class="content">
                                <table class="form">
                                    <tbody>
                                    <tr>
                                        <td>
                                            <span class="required">*</span>
                                            <s:message code="label.firstname"/>:
                                        </td>
                                        <td>
                                            <form:input cssClass="q1" path="firstName" />
                                            <form:errors path="firstName" cssClass="error"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <span class="required">*</span>
                                            <s:message code="label.lastname"/>:
                                        </td>
                                        <td>
                                            <form:input cssClass="q1" path="lastName" />
                                            <form:errors path="lastName" cssClass="error"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <span class="required">*</span>
                                            <s:message code="label.email"/>:
                                        </td>
                                        <td>
                                            <form:input cssClass="q1" path="account.email" />
                                            <form:errors path="account.email" cssClass="error"/>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>

                            <h2><s:message code="label.yourPassword"/></h2>

                            <div class="content">
                                <table class="form">
                                    <tbody>
                                    <tr>
                                        <td>
                                            <span class="required">*</span>
                                            <s:message code="label.password"/>:
                                        </td>
                                        <td>
                                            <input class="q1" name="account.password" value="" type="password">
                                            <form:errors path="account.password" cssClass="error"/>

                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <span class="required">*</span>
                                            <s:message code="label.passwordRepeat"/>:
                                        </td>
                                        <td>
                                            <input class="q1" name="account.passwordConfirm" value="" type="password">
                                            <form:errors path="account.passwordConfirm" cssClass="error"/>

                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="buttons">
                                <div class="right">
                                    <a onclick="$('#register').submit();" class="button">
                                        <span>Speichern</span>
                                    </a>
                                </div>
                            </div>
                        </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
