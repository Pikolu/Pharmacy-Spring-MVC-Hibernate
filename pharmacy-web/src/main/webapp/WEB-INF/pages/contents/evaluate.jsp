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
            <h1>${pharmacy.name} bewerten</h1>

            <%@include file="../includes/profileSidebar.jsp" %>


            <div class="box" style="margin-left: 250px">
                <div class="box-heading">${pharmacy.name} bewerten</div>
                <div class="box-content">
                    <div class="box-product">
                        <div class="user-account">
                            Möchten Sie jetzt eine neue Bewertung verfassen? Bitte geben Sie den Apothekenname ein.
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
