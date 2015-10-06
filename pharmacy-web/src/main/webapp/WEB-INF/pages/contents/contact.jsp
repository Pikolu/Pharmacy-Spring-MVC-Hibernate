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
            <h1>Kontakt</h1>
            <div class="box">
                <div class="box-heading">Kontakt</div>
                <div class="box-content">
                    <div class="box-product">
                        <c:url value="/kontakt" var="contact"></c:url>
                        <form:form action="${contact}" method="post" id="contactForm" modelAttribute="contact">
                            <div class="content">
                                <table class="form">
                                    <tbody>
                                        <tr>
                                            <td>
                                                <span class="required">*</span> 
                                                Title:
                                            </td>
                                            <td>
                                                <form:input cssClass="q1" path="name"/>
                                                <form:errors path="name" cssClass="error" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <span class="required">*</span> 
                                                Beschreibung:
                                            </td>
                                            <td>
                                                <form:input cssClass="q1" path="email"/>
                                                <form:errors path="email" cssClass="error" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <span class="required">*</span> 
                                                Beschreibung:
                                            </td>
                                            <td>
                                                <input class="q1" name="description" value="" type="text">
                                                <form:errors path="description" cssClass="error" />
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="buttons">
                                <div class="right">
                                    <a onclick="$('#contactForm').submit();" class="button">
                                        <span><s:message code="label.next" /></span>
                                    </a>
                                </div>
                            </div>
                        </form:form>

                    </div>
                </div>
            </div>
        </div>
    </div>
