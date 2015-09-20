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
            <h1>Meine Bewertungen</h1>

            <%@include file="../includes/profileSidebar.jsp" %>


            <div class="box" style="margin-left: 250px">
                <div class="box-heading">Meine Bewertungen</div>
                <div class="box-content">
                    <div class="box-product">
                        <div class="user-account">
                            Möchten Sie jetzt eine neue Bewertung verfassen? Bitte geben Sie den Apothekenname ein.
                            <div style="margin-top: 10px;">
                                <c:url value="/bewertungen" var="evaluation" />
                                <form:form action="${evaluation}" method="GET" id="evaluationSearchForm">
                                    <table class="form">
                                        <tbody>
                                            <tr>
                                                <td>
                                                    Apothekenname:
                                                </td>
                                                <td>
                                                    <input type="text" class="q1" name="pharmacyName" value="${not empty pharmacyName ? pharmacyName : ''}"/>
                                                </td>
                                                <td>
                                                    <a class="buttonlight morebutton" onclick="$('#evaluationSearchForm').submit();" href="#">Suchen</a>
                                                </td>
                                            </tr>
                                    </table>
                                </form:form>
                            </div>
                            <c:choose>
                                <c:when test="${not empty pharmacies}">
                                    <table class="form">
                                        <tbody>
                                            <c:forEach items="${pharmacies}" var="pharmacy" varStatus="status">
                                                <tr style="height: 35px; border-bottom: 1px solid #E5E5E5; ${status.first ? 'border-top: 1px solid #E5E5E5;' : ''}">
                                                    <td>
                                                        <img width="85" height="35" src="${pharmacy.logoURL}" alt="${pharmacy.name}"/>
                                                    </td>
                                                    <td>
                                                        ${pharmacy.name}
                                                    </td>
                                                    <td style="text-align: right">
                                                        <c:url value="/bewerten/${pharmacy.name}" var="pharmacyURL"/>
                                                        <a class="buttonlight morebutton" href="${pharmacyURL}">Diese Apotheken bewerten</a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </c:when>
                                <c:otherwise>
                                    Es wurden keine Apotheken gefunden. Bitte führen Sie die Abfrage erneunt aus.
                                </c:otherwise>
                            </c:choose>
                            <%--<c:if test="${not empty pharmacies}">--%>

                            <%--</c:if>--%>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
