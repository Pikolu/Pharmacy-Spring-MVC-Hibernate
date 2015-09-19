<%-- 
    Document   : prifileSidebar
    Created on : 20.09.2015, 00:56:22
    Author     : Alexander
--%>

<div id="column-left">
    <div class="box category">
        <div class="box-heading">Alle Kategorien</div>
        <div class="box-content">
            <div class="box-category">
                <ul>
                    <li class="cat-header">
                    <c:url value="/account" var="account"/>
                    <a class="idCatSubcat" href="${account}">Persönliche Daten</a>
                    </li>
                    <li class="cat-header">
                    <c:url value="/bewertung" var="evaluation"/>
                    <a class="idCatSubcat" href="${evaluation}">Meine Bewertungen</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
