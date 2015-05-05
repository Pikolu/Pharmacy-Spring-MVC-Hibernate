<%-- 
    Document   : produkte
    Created on : 11.04.2015, 10:18:01
    Author     : Alexandr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:genericpage>
    <jsp:attribute name="head">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
        <link href="<c:url value="/resources/css/default.css" />" rel="stylesheet">
    </jsp:attribute>
    <jsp:attribute name="header">
        <%@include file="includes/header.jsp" %>
    </jsp:attribute>
    <jsp:attribute name="footer">
        <%@include file="includes/footer.jsp" %>
    </jsp:attribute>
    <jsp:body>
        <%@include file="contents/searchContent.jsp" %>
    </jsp:body>
</t:genericpage>