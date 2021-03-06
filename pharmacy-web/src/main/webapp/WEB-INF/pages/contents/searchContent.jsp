<%-- 
    Document   : mainContent
    Created on : 24.08.2013, 21:36:52
    Author     : Alexandr
--%>

<%@page import="java.net.URLEncoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="container">
    <div id="notification"> </div>
    <div id="content">
        <div class="box">
            <div class="box-heading">Suchergebnisse zu ${parameter}</div>
            <div class="box-content">
                <div class="box-product">

                    <c:choose>
                        <c:when test="${empty articles}">
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

                                <c:forEach var="article" items="${articles}">
                                    <tr>
                                        <td style="border-bottom: 1px solid #E5E5E5">

                                            <table style="width: 100%">
                                                <tr>
                                                    <td style="width: 100px">
                                                        <div style="float: left; width: 100px; height: 100px">
                                                            <img alt="${article.name}" src="${article.imageURL}" width="100" height="100" />
                                                        </div>
                                                    </td> 
                                                    <td style="vertical-align: baseline;">
                                                        <div style="margin-left: 25px; float: left;">
                                                            <h4 style="margin: 0px;">
                                                                <c:url var="checkPrice" value="/preisvergleich/${article.articelNumber}/${urlEncoder.encodeURL(article.name)}" />
                                                                <a href="${checkPrice}" >${article.name}</a>
                                                            </h4>
                                                            <br/>
                                                        </div>
                                                    </td>
                                                    <c:set var="bestPrice" value="${articleHelper.getBestDiscount(article.prices)}" />
                                                    <td style="width: 130px; vertical-align: baseline;">
                                                        <div>ab ${bestPrice.price} €</div>
                                                        <div style="color: #D14F4F">${bestPrice.discount} %<span> Ersparnis</span></div>
                                                    </td>
                                                    <td style="width: 155px; text-align: right; padding-right: 20px;">
                                                        <c:url var="checkPrice" value="/preisvergleich/${article.articelNumber}/${urlEncoder.encodeURL(article.name)}" />
                                                        <a class="buttonlight morebutton" href="${checkPrice}">Zum Preisvergleich</a>
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
