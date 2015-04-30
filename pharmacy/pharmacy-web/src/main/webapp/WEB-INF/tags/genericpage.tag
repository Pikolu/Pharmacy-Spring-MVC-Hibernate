<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="head" fragment="true" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@attribute name="title" fragment="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title><jsp:invoke fragment="title"/></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <script src="<c:url value="/resources/js/jquery-1.11.2.min.js" />" type="text/javascript"></script>
        <!--<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>-->

        <link rel="icon" type="image/png" href="images/sitelogo.png" />
        <!-- commented, remove this line to use IE & iOS favicons -->
        <link rel="shortcut icon" href="images/favicon.ico" />

        <!--<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script>-->

        <!-- CSS STYLE -->
        <link href="<c:url value="/resources/css/default.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/default.css" />" rel="style">
        <link href="<c:url value="/resources/css/services-plugin/settings.css" />" rel="stylesheet">
        <!--        <h:outputStylesheet library="css" name="style.css" />
                <h:outputStylesheet library="css" name="default.css" />
                <h:outputStylesheet library="css/services-plugin" name="settings.css" />-->

        <!-- ANIMATE AND EASING LIBRARIES -->
        <script src="<c:url value="/resources/js/jquery.easing.1.3.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/jquery.cssAnimate.mini.js" />" type="text/javascript"></script>
        <!--        <h:outputScript library="js" name="jquery.easing.1.3.js" />
                <h:outputScript library="js" name="jquery.cssAnimate.mini.js" />-->

        <!-- TOUCH AND MOUSE WHEEL SETTINGS -->
        <script src="<c:url value="/resources/js/jquery.touchwipe.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/jquery.mousewheel.min.js" />" type="text/javascript"></script>
        <!--        <h:outputScript library="js" name="jquery.touchwipe.min.js" />
                <h:outputScript library="js" name="jquery.mousewheel.min.js" />-->

        <!-- jQuery SERVICES Slider  -->
        <script src="<c:url value="/resources/js/jquery.themepunch.services.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/jquery.raty.min.js" />" type="text/javascript"></script>
        <!--<h:outputScript library="js" name="jquery.themepunch.services.min.js" />-->

        <!-- FONT IMPORT -->
        <link href='http://fonts.googleapis.com/css?family=PT+Sans+Narrow:400,700' rel='stylesheet' type='text/css' />



    </head>
    <body>
        <jsp:invoke fragment="header"/>
        <div class="main-container">
            <jsp:doBody/>
            <jsp:invoke fragment="footer"/>
        </div>
    </body>
</html>