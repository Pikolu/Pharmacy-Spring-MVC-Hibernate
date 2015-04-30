<%-- 
    Document   : registerContent
    Created on : 24.08.2013, 21:51:52
    Author     : Alexandr
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="container">
    <div id="content">
        <h1>Register Account</h1>
        <div class="box-container">
            <p>
                If you already have an account with us, please login at the 
            <c:url value="/login.html" var="login"></c:url>
            <a href="${login}">login page</a>
            .
            </p>
            <c:url value="/registration.html" var="registration"></c:url>
            <form:form action="${registration}" method="post" id="register">
                <h2>Your Personal Details</h2>
                <div class="content">
                    <table class="form">
                        <tbody><tr>
                                <td>
                                    <span class="required">*</span> 
                                    First Name:
                                </td>
                                <td>
                                    <form:input cssClass="q1" path="firstName"/>
                                    <form:errors path="firstName" cssClass="error" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <span class="required">*</span> 
                                    Last Name:
                                </td>
                                <td>
                                    <form:input cssClass="q1" path="lastName"/>
                                    <form:errors path="lastName" cssClass="error" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <span class="required">*</span> 
                                    E-Mail:
                                </td>
                                <td>
                                    <input class="q1" name="email" value="" type="text">
                                    <form:errors path="email" cssClass="error" />
                                </td>
                            </tr>
                            <tr>
                                <td>Telephone:</td>
                                <td>
                                    <input class="q1" name="phone" value="" type="text">
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <h2>Your Address</h2>
                <div class="content">
                    <table class="form">
                        <tbody>
                            <tr>
                                <td>Company:</td>
                                <td>
                                    <form:input cssClass="q1" path="address.company"/>
                                </td>
                            </tr>
                            <tr style="display: none;">
                                <td>Business Type:</td>
                                <td> 
                                    <input name="customer_group_id" value="1" id="customer_group_id1" checked="checked" type="radio">
                                    <label for="customer_group_id1">Default</label>
                                    <br>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <span class="required">*</span> 
                                    Address:
                                </td>
                                <td>
                                    <input class="q1" name="address.address" value="" type="text" />
                                    <form:errors path="address.address" cssClass="error" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <span class="required">*</span> 
                                    City:
                                </td>
                                <td>
                                    <input class="q1" name="address.city" value="" type="text">
                                    <form:errors path="address.city" cssClass="error" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <span id="postcode-required" class="required">*</span> 
                                    Post Code:
                                </td>
                                <td>
                                    <input class="q1" name="address.postCode" value="" type="text">
                                    <form:errors path="address.postCode" cssClass="error" />
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <h2>Your Password</h2>
                <div class="content">
                    <table class="form">
                        <tbody>
                            <tr>
                                <td>
                                    <span class="required">*</span> 
                                    Password:
                                </td>
                                <td>
                                    <input class="q1" name="password" value="" type="password">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <span class="required">*</span> 
                                    Password Confirm:
                                </td>
                                <td>
                                    <input class="q1" name="passwordConfirm" value="" type="password">
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <h2>Newsletter</h2>
                <div class="content">
                    <table class="form">
                        <tbody>
                            <tr>
                                <td>Subscribe:</td>
                                <td> 
                                    <input name="newsletter" value="1" type="radio">
                                    Yes 
                                    <input name="newsletter" value="0" checked="checked" type="radio">
                                    No 
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <div class="right">
                        I have read and agree to the 
                        <a class="colorbox cboxElement" href="#" alt="Privacy Policy">
                            <b>Privacy Policy</b>
                        </a> 
                        <input name="agree" value="1" type="checkbox">
                        <a onclick="$('#register').submit();" class="button">
                            <span>Continue</span>
                        </a>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>
