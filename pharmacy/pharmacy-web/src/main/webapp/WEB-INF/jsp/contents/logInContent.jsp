<%-- 
    Document   : logInContent
    Created on : 24.08.2013, 21:39:30
    Author     : Alexandr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="container">
    <div id="content">
        <h1>Account Login</h1>
        <div class="box-container">
            <div class="login-content">
                <div class="left">
                    <h2>New Customer</h2>
                    <div class="content">
                        <p><b>Register Account</b></p>
                        <p>By creating an account you will be able to shop faster, be up to date on an order's status, and keep track of the orders you have previously made.</p>
                        <c:url value="/registration.html" var="registration"></c:url>
                        <a href="${registration}" class="button"><span>Continue</span></a></div>
                </div>
                <div class="right">
                    <h2>Returning Customer</h2>
                    <c:url value="/login.html" var="login"></c:url>
                    <form action="${login}" method="post" id="login">
                        <div class="content">
                            <p>I am a returning customer</p>
                            <b class="padd-form">E-Mail Address:</b>
                            <input class="q1 margen-bottom" name="email" value="" type="text">
                            <b class="padd-form">Password:</b>
                            <input class="q1 margen-bottom" name="password" value="" type="password">
                            <br>
                            <div>
                                <a class="link-login" href="#">Forgotten Password</a>
                            </div>
                            <a onclick="$('#login').submit();" class="button"><span>Login</span></a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script data-rocketoptimized="true" type="text/rocketscript"><!--
        $('#login input').keydown(function(e) {
        if (e.keyCode == 13) {
        $('#login').submit();
        }
        });
        //--></script>

</div>
