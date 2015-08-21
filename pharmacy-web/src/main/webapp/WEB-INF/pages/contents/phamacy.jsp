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
        <h1>Apotheke: ${pharm}</h1>
        <div class="box">
            <div class="box-heading">Anschrift</div>
            <div class="box-content">
                <div class="box-product">
                    <div style="padding: 10px 10px 10px 18px">
                        <h3 style="margin: 0px;">${pharm}</h3>
                        <span><s:message code="label.gender_${pharmacy.user.genderType}" /> ${pharmacy.user.firstName} ${pharmacy.user.lastName}</span>
                        <br />
                        <span>${pharmacy.address.address}</span>
                        <br />
                        <span>${pharmacy.address.postCode} ${pharmacy.address.city}</span>
                        <br /><br />
                        <span>Telefon: ${pharmacy.user.phoneNumber}</span>
                        <br />
                        <span>Telefax: ${pharmacy.user.fax}</span>
                        <br />
                        <span>E-Mail: <a href="mailto:${pharmacy.user.email}">${pharmacy.user.email}</a></span>
                        <br />
                        <span>Internet: <a href="${pharmacy.user.homePage}">${pharmacy.user.homePage}</a></span>
                    </div>
                </div>
            </div>
        </div>

        <div class="box">
            <div class="box-heading">Zahlungsarten / Versand</div>
            <div class="box-content">
                <div class="box-product">
                    Hier kommt der Inhalt einer Apotheke
                </div>
            </div>
        </div>

        <div class="box">
            <div class="box-heading">Bewertungen</div>
            <div class="box-content">
                <div class="box-product">
                    Hier kommt der Inhalt einer Apotheke
                </div>
            </div>
        </div>
    </div>
</div>
