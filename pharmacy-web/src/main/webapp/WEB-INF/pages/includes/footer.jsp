<%-- 
    Document   : footer
    Created on : 24.08.2013, 21:26:32
    Author     : Alexandr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="footer-wrap">
    <div id="footer">
        <div class="wrapper">
            <div class="column col-1">
                <h3>Information</h3>
                <ul>
                    <li><a style="padding-left: 0px;" href="#">Über MEDIZIN-FINDER.DE</a></li>
                    <c:url value="/help/policies/user-agreement.html" var="agreement"></c:url>
                    <li><a style="padding-left: 0px;" href="${agreement}">AGB</a></li>
                    <li><a style="padding-left: 0px;" href="#">Impressum</a></li>
                </ul>
            </div>
            <div class="column col-2">
                <h3>Customer Service</h3>
                <ul>
                    
                    <c:url value="/kontakt" var="agreement"></c:url>
                    <li><a style="padding-left: 0px;" href="${agreement}">Kontakt</a></li>
                </ul>
            </div>
<!--            <div class="column col-3">
                <h3>Extras</h3>
                <ul>
                    <li><a style="padding-left: 0px;" href="#">Brands</a></li>
                    <li><a style="padding-left: 0px;" href="#">Gift Vouchers</a></li>
                    <li><a style="padding-left: 0px;" href="#">Affiliates</a></li>
                    <li><a style="padding-left: 0px;" href="#">Specials</a></li>
                </ul>
            </div>-->
            <div class="column col-4">
                <h3>My Account</h3>
                <ul>
                    <li><a style="padding-left: 0px;" href="#">Mein Medizin-Finder</a></li>
                    <!--<li><a style="padding-left: 0px;" href="#">Order History</a></li>-->
                    <!--<li><a style="padding-left: 0px;" href="#">Wish List</a></li>-->
                    <!--<li><a style="padding-left: 0px;" href="#">Newsletter</a></li>-->
                </ul>
            </div>
        </div>
    </div>
    <div class="wrapper">
        <c:url value="/index.html" var="index"></c:url>
        <div id="powered">Copyright 2015 ©  <a href="${index}" style="text-transform: uppercase;">medizin-finder.de</a></div>
    </div>
</div>