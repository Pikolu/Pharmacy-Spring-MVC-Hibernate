<%-- 
    Document   : logInContent
    Created on : 24.08.2013, 21:39:30
    Author     : Alexandr
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<div id="container">
    <div id="content">
        <h1>Einloggen</h1>
        <div class="box-container">
            <div class="login-content">
                <div class="left">
                    <h2>Neu bei medizin-finder.de?</h2>
                    <div class="content">
                        <h2 style="color: black; font-size: 16px">Jetzt bei medizin-finder.de anmelden</h2>
                        <c:url value="/registration.html" var="registration"></c:url>
                        <a href="${registration}" class="button">
                            <span>Anmelden</span>
                        </a>
                    </div>
                </div>
                <div class="right">
                    <!--<h2>Returning Customer</h2>-->
                    <form id="login" name='loginForm' action="<c:url value='/j_spring_security_check' />" method='POST'>
                        <div class="content">
                            <!--<p>I am a returning customer</p>-->
                            <c:if test="${not empty error}">
                                <div class="error">${error}</div>
                            </c:if>
                            <b class="padd-form">E-Mail Adresse:</b>
                            <input class="q1 margen-bottom" name="username" value="" type="text">
                            <b class="padd-form">Password:</b>
                            <input class="q1 margen-bottom" name="password" value="" type="password">
                            <br>
                            <div>
                                <c:url value="/forgotpassword.html" var="forgotpassword"></c:url>
                                <a class="link-login" href="${forgotpassword}">Passwort vergessen?</a>
                            </div>
                            <a onclick="$('#login').submit();" class="button"><span>Login</span></a>

                            <input type="hidden" name="${_csrf.parameterName}"
                                   value="${_csrf.token}" />
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
<!--    <script data-rocketoptimized="true" type="text/rocketscript">
        $('#login input').keydown(function(e) {
        if (e.keyCode == 13) {
        $('#login').submit();
        }
        });
        //</script>-->

</div>
