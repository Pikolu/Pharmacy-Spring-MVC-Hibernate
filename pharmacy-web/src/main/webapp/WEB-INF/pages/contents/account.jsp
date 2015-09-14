<%-- 
    Document   : mainContent
    Created on : 24.08.2013, 21:36:52
    Author     : Alexandr
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="container">
    <div id="notification"> </div>
    <div id="content">
        <h1>Account</h1>
        <div id="column-left">

            <div class="box category">
                <div class="box-heading">Categories</div>
                <div class="box-content">
                    <div class="box-category">
                        <ul>
                            <%--<c:forEach items="#{categoryHandler.categories}" var="category">--%>
                            <%--<c:if test="#{not empty category.children}">--%>
                            <li class="cat-header"> 
                                <!--<p:link class="idCatSubcat" outcome="/categories/{category.directoryName}/{category.directoryName}" value="{category.name}" />-->
                                <c:url value="/account/data" var="data" />
                                <a class="idCatSubcat" href="${data}">Persönliche Daten</a>
                                <%--<c:if test="#{not empty category.children}">--%>
                                <!--                                <span class="close collapsed"></span>
                                                                <ul style="display: none;">
                                
                                                                </ul>-->
                                <%--</c:if>--%>
                            </li>
                            <%--</c:if>--%>
                            <%--</c:forEach>--%>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <div class="box" style="margin-left: 250px">
            <div class="box-heading">Persönliche Daten</div>
            <div class="box-content">
                <div class="box-product">
                    <div class="user-data">
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
                                        <form:input cssClass="q1" path="account.email" />
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
                                        <form:input cssClass="q1" path="account.password" type="password" />
                                    <form:errors path="account.password" cssClass="error" />

                                    </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <span class="required">*</span> 
                                    <s:message code="label.passwordRepeat" />:
                                    </td>
                                    <td>
                                        <form:input cssClass="q1" path="account.passwordConfirm" type="password" />
                                    <form:errors path="account.passwordConfirm" cssClass="error" />

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
