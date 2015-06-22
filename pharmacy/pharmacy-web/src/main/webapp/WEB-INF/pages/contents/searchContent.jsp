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
                                            <div style="float: left; width: 150px; height: 150px">
                                                <img alt="${article.name}" src="${article.imageURL}" width="150" height="150" />
                                            </div>

                                            <div style="margin-left: 25px; float: left; width: 40%;">
                                                <h4>
                                                    <c:url value="/produkte/${article.articelNumber}/${article.name}" var="check" />
                                                    <a href="${check}" >${article.name}</a>
                                                </h4>
                                                <br/>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>



                            <%--For displaying Page numbers. 
                            The when condition does not display a link for the current page--%>
<<<<<<< HEAD
                            <table border="0" cellpadding="5" cellspacing="5" style="margin: auto;">
=======
                            <table border="0" cellpadding="5" cellspacing="5" style="width: 100%; margin: auto;">
>>>>>>> fbaa97006defbebd6ef8396250363a344bf3cd29
                                <tr>
                                    <%--For displaying Previous link except for the 1st page --%>
                                    <td>
                                        <c:if test="${currentPage > 0}">

                                            <c:url value="/produkte" var="produkte">
                                                <c:param name="page" value="${currentPage - 1}" />
                                                <c:param name="parameter" value="${parameter}" />
                                            </c:url>
<<<<<<< HEAD
                                            <a href="${produkte}" style="float: right;">Zurück</a>
                                        </td>
                                    </c:if>
=======
                                            <a href="${produkte}">Zurück</a>
                                        </c:if>
                                    </td>
>>>>>>> fbaa97006defbebd6ef8396250363a344bf3cd29
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
<<<<<<< HEAD
                                    <c:if test="${currentPage != lastPage}">
                                        <td>
=======
                                    <td>
                                        <c:if test="${currentPage == lastPage}">

>>>>>>> fbaa97006defbebd6ef8396250363a344bf3cd29
                                            <c:url value="/produkte" var="account">
                                                <c:param name="page" value="${currentPage + 1}" />
                                                <c:param name="parameter" value="${parameter}" />
                                            </c:url>
<<<<<<< HEAD
                                            <a href="${account}" style="float: left;">Weiter</a>
                                        </td>
                                    </c:if>
=======
                                            <a href="${account}">Weiter</a>
                                        </c:if>

                                    </td>
>>>>>>> fbaa97006defbebd6ef8396250363a344bf3cd29
                                </tr>
                            </table>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
</div>
