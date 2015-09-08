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
                        <span>${pharmacy.user.address.address}</span>
                        <br />
                        <span>${pharmacy.user.address.postCode} ${pharmacy.user.address.city}</span>
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
                    <div style="padding: 10px 10px 10px 18px">
                        <div>
                            <h2>Zahlungsarten</h2>
                            <hr/>
                            <c:forEach items="${pharmacy.paymentTypes}" var="payment">
                                <c:if test="${payment.name() eq 'PAY_PAL'}">
                                    <div style="margin: 5px 0 5px 0;">
                                        <img src="<c:url value="/resources/images/payment/paypal.png" />" />
                                    </div>
                                </c:if>

                                <c:if test="${payment.name() eq 'KREDIT_CARD'}">
                                    <div style="margin: 5px 0 5px 0;">
                                        <img src="<c:url value="/resources/images/payment/creditcard.png" />" />
                                    </div>
                                </c:if>

                                <c:if test="${payment.name() eq 'DIRECT_BANKING'}">
                                    <div style="margin: 5px 0 5px 0;">
                                        <img src="<c:url value="/resources/images/payment/sofortüberweisung.png" />" />
                                    </div>
                                </c:if>

                                <c:if test="${payment.name() eq 'DEBIT'}">
                                    <div style="margin: 5px 0 5px 0;">
                                        <img src="<c:url value="/resources/images/payment/lastschrift.png" />" />
                                    </div>
                                </c:if>

                                <c:if test="${payment.name() eq 'DEBIT'}">
                                    <div style="margin: 5px 0 5px 0;">
                                        <img src="<c:url value="/resources/images/payment/rechnung.png" />" />
                                    </div>
                                </c:if>
                            </c:forEach>
                        </div>
                        <div style="margin-top: 50px">
                            <h2>Versandkosten</h2>
                            <hr/>
                             Portofrei ab ${pharmacy.shipping} €.
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="box">
            <div class="box-heading">Bewertungen</div>
            <div class="box-content">
                <div class="box-product">
                             <div class="box-content box-evaluation">
                <c:forEach items="${pharmacy.evaluations}" var="evaluation">
                    <div class="evaluation-box" style="height: 60px; border-bottom: 1px solid #E5E5E5; padding: 5px 0px 5px 10px;">
                        <span style="float: left">${evaluation.creationDate}</span>
                        <span style="float: left">&nbsp; | &nbsp;</span>
                        <div id="fixed_${evaluation.id}"></div>
                        
                        <h2 class="ellipsis">${evaluation.name}</h2>
                        <div class="ellipsis" >${evaluation.description}</div>
                        <script type="text/javascript">
                            jQuery('#fixed_${evaluation.id}').raty({
                                readOnly: true,
                                start: 2,
                                path: 'resources/images/raiting/'
                            });
                        </script>
                    </div>
                </c:forEach>
            </div>
                </div>
            </div>
        </div>
    </div>
</div>
