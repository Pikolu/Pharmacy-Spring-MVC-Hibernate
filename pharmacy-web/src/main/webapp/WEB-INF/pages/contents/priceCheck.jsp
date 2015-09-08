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
        <div class="box">
            <div class="box-heading">Preisvergleich ${name}</div>
            <div class="box-content">
                <div class="box-product">

                    <c:choose>
                        <c:when test="${empty article.prices}">
                            <div style="padding: 10px;">
                                <h2>Zu Ihrer Suche wurde leider nichts gefunden</h2>
                                <h3>Für den Suchbegriff wurden keine Produkte gefunden.</h3>

                                <h3>Hinweise zur Suche:</h3>
                                <ul>
                                    <li>
                                        Bitte achten Sie auf die richtige Schreibweise des Suchwortes
                                    </li>
                                    <li>
                                        Vermeiden Sie Umlaute oder Sonderzeichen
                                    </li>
                                </ul>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <table border="0" cellpadding="5" cellspacing="0" style="width: 100%">

                                <c:forEach var="price" items="${article.prices}">
                                    <tr>
                                        <td style="border-bottom: 1px solid #E5E5E5">

                                            <table id="priceCheck" style="width: 100%">
                                                <tr>
                                                    <td class="icon" style="width: 100px">
                                                        <div style="float: left; width: 100px; height: 100px">
                                                            <a href="${article.deepLink}">
                                                                <img alt="${price.pharmacy.name}" src="${price.pharmacy.logoURL}" width="100" height="100" />
                                                            </a>
                                                        </div>
                                                    </td> 
                                                    <td style="vertical-align: baseline;">
                                                        <div style="margin-left: 25px; float: left;">
                                                            <h4 style="margin: 0px;">
                                                                <%--<c:url value="/produkte/${article.articelNumber}/${article.name}" var="check" />--%>
                                                                <a href="${article.deepLink}" >${article.name}</a>
                                                            </h4>
                                                            <br/>
                                                            <div id="fixed_${price.pharmacy.id}"></div>
                                                            <span style="font-size: 15px;">${price.pharmacy.evaluations.size()} Bewertungen</span>
                                                            <script type="text/javascript">
                                                                jQuery('#fixed_${price.pharmacy.id}').raty({
                                                                    readOnly: true,
                                                                    start: ${price.pharmacy.totalEvaluationPoints},
                                                                    path: '../../resources/images/raiting/'
                                                                });
                                                            </script>
                                                            <br />

                                                            <c:url value="/apotheke/${price.pharmacy.name}.html" var="pharmacyURL" />
                                                            <a href="${pharmacyURL}">Apothekenprofil</a>
                                                            <br /><br />
                                                            <c:forEach items="${price.pharmacy.paymentTypes}" var="payment" >
                                                                <c:if test="${payment.name() eq 'PAY_PAL'}">
                                                                    <img src="<c:url value="/resources/images/payment/paypal.png" />" />
                                                                </c:if>

                                                                <c:if test="${payment.name() eq 'KREDIT_CARD'}">
                                                                    <span>
                                                                        <img src="<c:url value="/resources/images/payment/creditcard.png" />" />
                                                                    </span>
                                                                </c:if>

                                                                <c:if test="${payment.name() eq 'DIRECT_BANKING'}">
                                                                    <span>
                                                                        <img src="<c:url value="/resources/images/payment/sofortüberweisung.png" />" />
                                                                    </span>
                                                                </c:if>

                                                                <c:if test="${payment.name() eq 'DEBIT'}">
                                                                    <span>
                                                                        <img src="<c:url value="/resources/images/payment/lastschrift.png" />" />
                                                                    </span>
                                                                </c:if>

                                                                <c:if test="${payment.name() eq 'DEBIT'}">
                                                                    <span>
                                                                        <img src="<c:url value="/resources/images/payment/rechnung.png" />" />
                                                                    </span>
                                                                </c:if>
                                                            </c:forEach>
                                                        </div>
                                                    </td>
                                                    <%--<c:set var="bestPrice" value="${articleHelper.getBestDiscount(article.prices)}" />--%>
                                                    <td style="width: 130px; vertical-align: baseline;">
                                                        <!--<div>ab ${bestPrice.price} €</div>-->
<!--                                                        <div style="color: #D14F4F">${bestPrice.discount} %<span> Ersparnis</span></div>-->
                                                    </td>
                                                    <td style="width: 130px; text-align: right; padding-right: 20px;">
                                                        <%--<c:url value="/check/${article.articelNumber}/${article.name}" var="checkPrice" />--%>
                                                        <a href="${article.deepLink}">Hier bestellen</a>
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                </c:forEach>


                            </table>



                            <%--For displaying Page numbers. 
                            The when condition does not display a link for the current page--%>
                            <table border="0" cellpadding="5" cellspacing="5" style="margin: auto;">
                                <tr>
                                    <%--For displaying Previous link except for the 1st page --%>
                                    <td>
                                        <c:if test="${currentPage > 1}">

                                            <c:url value="/produkte" var="produkte">
                                                <c:param name="page" value="${currentPage - 1}" />
                                                <c:param name="parameter" value="${parameter}" />
                                            </c:url>
                                            <a href="${produkte}" style="float: right;">Zurück</a>
                                        </td>
                                    </c:if>
                                    <c:forEach begin="${firstPage}" end="${lastPage}" var="i">
                                        <c:choose>
                                            <c:when test="${currentPage eq i}">
                                                <td style="width: 10px;">${i}</td>
                                            </c:when>
                                            <c:otherwise>
                                                <td style="width: 10px;">
                                                    <c:url value="/produkte" var="produkte">
                                                        <c:param name="page" value="${i}" />
                                                        <c:param name="parameter" value="${parameter}" />
                                                    </c:url>
                                                    <a href="${produkte}">${i}</a>
                                                </td>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                    <td>
                                        <c:if test="${currentPage < lastPage}">
                                            <c:url value="/produkte" var="account">
                                                <c:param name="page" value="${currentPage + 1}" />
                                                <c:param name="parameter" value="${parameter}" />
                                            </c:url>                                            
                                            <a href="${account}" style="float: left;">Weiter</a>
                                        </c:if>
                                    </td>
                            </table>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
</div>
