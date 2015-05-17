<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row-1bg">
    <div class="row-1">
        <div class="pre-header">
            <div class="pre-header-container">
                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal.name != null}">
                        <div id="welcome">
                            Hallo!

                            <c:url value="/j_spring_security_logout" var="logoutUrl" />

                            <form action="${logoutUrl}" method="post" id="logoutForm">
                                <input type="hidden" name="${_csrf.parameterName}"
                                       value="${_csrf.token}" />
                            </form>
                            <script>
                                function formSubmit() {
                                    document.getElementById("logoutForm").submit();
                                }
                            </script>




                            <c:if test="${pageContext.request.userPrincipal.name != null}">
                                <c:url value="/account" var="account"></c:url>
                                <!--name="user" value=""-->
                                <c:set var="user" value="${pageContext.request.userPrincipal.principal}"/>
                                <a href="${account}">${user.firstName}, ${user.lastName}</a>
                                | <a href="javascript:formSubmit()">Ausloggen</a>
                            </c:if>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div id="welcome">
                            Hallo!
                            <c:url value="/login" var="login"></c:url>
                            <a href="${login}">Einloggen</a>
                            oder
                            <c:url value="/registration.html" var="registration"></c:url>
                            <a href="${registration}">Registrieren!</a>
                        </div>
                    </c:otherwise>
                </c:choose> 

                <div class="clear"></div>
            </div>
        </div>
        <div id="header">
            <div class="header-container">
                <!--                <div class="right-header">
                                    <div class="header-top1">
                                        <div class="" id="cart"><div class="heading">
                                                <b>Einkaufszettel:</b>
                                                <a>	
                                                    <span class="sc-button"></span>
                
                
                                                    <span id="cart-total">0 Artikel(n) - <strong>$0.00</strong></span>
                
                                                    <span class="clear"></span>
                                                </a>
                                            </div>
                                            <div class="content">
                
                                                <div class="empty">Your shopping cart is empty!</div>
                                            </div>
                                                
                                        </div>
                
                                        <div class="clear"></div>
                                    </div>
                                </div>-->
                <div id="logo">
                    <c:url value="/index.html" var="index"></c:url>
                    <a href="${index}">
                        <img src="<c:url value="/resources/images/logo1.png" />" />
                    </a>
                </div>
                <c:url value="/produkte.html" var="produkte"></c:url>
                    <form:form action="${produkte}" method="GET" id="searchForm">
                    <div id="search">
                        <div class="button-search"></div>
                        <span class="search-bg">
                            <input class="input" type="text" name="parameter" value="${not empty parameter ? parameter : ''}">
                        </span>
                    </div>
                </form:form>
                <div class="" id="cart"><div class="heading">
                        <b>Einkaufszettel:</b>
                        <a>	
                            <span class="sc-button"></span>
                            <span id="cart-total">0 Artikel(n) - <strong>$0.00</strong></span>
                            <span class="clear"></span>
                        </a>
                    </div>
                    <div class="content">
                        <div class="empty">Your shopping cart is empty!</div>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
            <script type="text/javascript">
                $(".button-search").click(function () {
                    jQuery('#searchForm').submit();
                });
            </script>
        </div>
    </div>
</div>