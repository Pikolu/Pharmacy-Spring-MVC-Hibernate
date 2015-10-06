<%-- 
    Document   : mainContent
    Created on : 24.08.2013, 21:36:52
    Author     : Alexandr
--%>
 <%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html xmlns:th="http://www.thymeleaf.org">
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
                            <c:url value="/${pharmacy.id}/bewerten" var="evaluationURL" />
                            <form:form id="evaluationForm" modelAttribute="evaluation" method="POST" action="${evaluationURL}">
                                <div>
                                    <h2><span class="required">*</span>Überschrift</h2>
                                    <form:input cssStyle="width: 100%" path="name" />
                                    <form:errors path="name" cssClass="error" />
                                </div>
                                <div class="evaluation-box-margin-top">
                                    <h2><span class="required">*</span>Beschreibung</h2>
                                    <form:textarea path="description" cssStyle="width: 100%; resize: none; height: 200px" />
                                     <form:errors path="description" cssClass="error" />
                                </div>
                                <div class="evaluation-box-margin-top">
                                    <h3>Bewerten Sie diesen Einkauf detailliert</h3>
                                </div>
                                <div class="evaluation-box-margin-top">
                                    <h2><span class="required">*</span>Wie genau entsprach der Artikel der Beschreibung?</h2>
                                    <form:select path="descriptionPoints">
                                        <form:option value="0">0</form:option>
                                        <form:option value="1">1</form:option>
                                        <form:option value="2">2</form:option>
                                        <form:option value="3">3</form:option>
                                        <form:option value="4">4</form:option>
                                        <form:option value="5">5</form:option>   
                                    </form:select>
                                </div>
                                <div class="evaluation-box-margin-top">
                                    <h2><span class="required">*</span>Wie schnell hat der Verkäufer den Artikel verschickt?</h2>
                                    <form:select path="shippingPoints">
                                        <form:option value="0">0</form:option>
                                        <form:option value="1">1</form:option>
                                        <form:option value="2">2</form:option>
                                        <form:option value="3">3</form:option>
                                        <form:option value="4">4</form:option>
                                        <form:option value="5">5</form:option>   
                                    </form:select>
                                </div>
                                <div class="evaluation-box-margin-top">
                                    <h2><span class="required">*</span>Wie angemessen waren die Verpackungs- und Versandkosten?</h2>
                                    <form:select path="shippingPricePoints">
                                        <form:option value="0">0</form:option>
                                        <form:option value="1">1</form:option>
                                        <form:option value="2">2</form:option>
                                        <form:option value="3">3</form:option>
                                        <form:option value="4">4</form:option>
                                        <form:option value="5">5</form:option>   
                                    </form:select>
                                </div>
                                
                                <a onclick="$('#evaluationForm').submit();" class="button" style="float: right"><span>Speichern</span></a>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
