<%-- 
    Document   : mainContent
    Created on : 24.08.2013, 21:36:52
    Author     : Alexandr
--%>

<%@page import="java.util.List"%>
<%--<%@page import="com.pharmacy.article.Pharmacy"%>
<%@page import="com.pharmacy.evaluation.helper.EvaluationHelper"%>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="container">
    <div id="content">
        <div class="example-wrapper">
            <div id="services-example-1" class="theme1">
                <ul>
                    <!--	###############		-	SLIDE 4	-	###############	 -->
                    <c:forEach items="${articles}" var="article">
                        <li>
                            <img width="150" height="110" class="thumb" src="${article.imageURL}" data-bw="${article.imageURL}" />
                            <div style="margin-top:16px"></div>
                            <h2 style="height: 75px">${article.name}</h2>
                            <p style="height: 100px; vertical-align: bottom;">${article.description}</p>
                            <div style="float: left; width: 60%">
                                ab
                                <c:set var="bestPrice" value="${articleHelper.getBestDiscount(article.prices)}" />
                                <span style="font-size: 18px; color:#E31010">${bestPrice.price} €</span>

                                <!--<h:outputText style="font-size: 18px; color:#E31010" value="{article.price} €" />-->
                            </div>
                            <div>
                                <span style="float:left;width:40%;line-height:1em; font-size: 18px; color: #E31010">${bestPrice.discount} %</span>
                                <span>Ersparnis</span>
                                <!--<h:outputText style="float:left;width:40%;line-height:1em; font-size: 18px; color: #E31010" value="{article.discount} % " />-->
                                <!--<h:outputText value="Ersparnis"/>-->
                            </div>
                            <a class="buttonlight morebutton" href="#">Siehe mehr</a>

                            <!--
                            ***********************************************************************************************************
                                    -	HERE YOU CAN DEFINE THE EXTRA PAGE WHICH SHOULD BE SHOWN IN CASE THE "BUTTON" HAS BEED PRESSED -
                            ***********************************************************************************************************
                            -->
                            <div class="page-more">
                                <img width="150" height="110" class="big-image" src="${article.imageURL}" />
                                <div style="overflow-y: scroll; height: 400px;">
                                    <div class="details_double">
                                        <h2>${article.name}</h2>
                                        <p>${article.descriptionLong}</p>
                                    </div>
                                </div>
                                <div  class="closer"></div>
                            </div>
                        </li>
                    </c:forEach>
                </ul>

                <!--	###############		-	TOOLBAR (LEFT/RIGHT) BUTTONS	-	###############	 -->
                <div class="toolbar">
                    <div class="left"></div><div class="right"></div>
                </div>
            </div>

        </div>
        <script type="text/javascript">

            var tpj = jQuery;
            tpj.noConflict();

            tpj(document).ready(function () {

                if (tpj.fn.cssOriginal != undefined)
                    tpj.fn.css = tpj.fn.cssOriginal;

                tpj('#services-example-1').services(
                        {
                            width: 920,
                            height: 450,
                            slideAmount: 5,
                            slideSpacing: 30,
                            carousel: "on",
                            touchenabled: "off",
                            mouseWheel: "off",
                            hoverAlpha: "off", // Turns Alpha Fade on/off by Hovering
                            slideshow: 5000, // 0 = No SlideShow, 1000 = 1 sec Slideshow (rotating automatically)
                            hovereffect: "off", // All Hovereffect on/off
                            callBack: function () {
                            }		//Callback any Function after loaded

                        });
            });
        </script>

        <div class="box" style="margin-top: 20px; float: left; width: 49%; border-bottom: none;">
            <div class="box-heading">TOP-Apotheken und Anbieter</div>
            <div class="box-content box-evaluation">
                <c:choose>
                    <c:when test="${empty pharmacies}">
                        <div style="border-bottom: 1px solid #E5E5E5; padding: 5px 0px 5px 10px;">
                            Zurzeit gibt es keine Anbieter mit vorhandenen Bewertungen.
                        </div>
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${pharmacies}" var="pharmacy">
                            <div class="evaluation-box" style="height: 60px; border-bottom: 1px solid #E5E5E5; padding: 5px 0px 5px 10px;">
                                <h2>
                                    <c:url value="/apotheke/${pharmacy.name}.html" var="pharmacyURL" />
                                    <a href="${pharmacyURL}">${pharmacy.name}</a>
                                </h2>
                                <div style="float:left">
                                    <img width="86" height="34" alt="${pharmacy.name}" src="${pharmacy.logoURL}" />    
                                </div>

                                <div id="fixed_${pharmacy.id}" style="margin-left: 165px"></div>
                                <span style="margin-left: 72px">${pharmacy.evaluations.size()} Bewertungen</span>
                                <script type="text/javascript">
                                    console.log("#fixed_${pharmacy.id}");
                                    jQuery('#fixed_${pharmacy.id}').raty({
                                        readOnly: true,
                                        start: ${evaluation.points},
                                        path: 'resources/images/raiting/'
                                    });
                                </script>
                            </div>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>

            </div>
        </div>

        <div class="box" style="margin-top: 20px; margin-left: 51%; border-bottom: none;">
            <div class="box-heading">Aktuelle Bewertungen</div>
            <div class="box-content box-evaluation">
                <c:choose>
                    <c:when test="${empty evaluations}">
                        <div style="border-bottom: 1px solid #E5E5E5; padding: 5px 0px 5px 10px;">
                            Zurzeit gibt es keine Bewertungen.
                        </div>
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${evaluations}" var="evaluation">
                            <div class="evaluation-box" style="height: 60px; border-bottom: 1px solid #E5E5E5; padding: 5px 0px 5px 10px;">
                                <span style="float: left">${evaluation.creationDate}</span>
                                <span style="float: left">&nbsp; | &nbsp;</span>
                                <div id="fixed_${evaluation.id}"></div>

                                <h2 class="ellipsis">${evaluation.name}</h2>
                                <div class="ellipsis" >${evaluation.description}</div>
                                <script type="text/javascript">
                                    jQuery('#fixed_${evaluation.id}').raty({
                                        readOnly: true,
                                        start: ${evaluation.points},
                                        path: 'resources/images/raiting/'
                                    });
                                </script>
                            </div>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</div>
