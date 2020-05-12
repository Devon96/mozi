<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="hu.alkfejl.model.bean.Terem" %>
<%@ page import="hu.alkfejl.model.bean.Foglalas" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>Foglálás</title>
    <link rel="stylesheet" href="../css/alap.css" />
    <link rel="stylesheet" href="../css/foglalas.css" />
</head>
<body>
<jsp:include page="../FoglalasController"/>

<header>
    <a href="/pages/filmek.jsp"><img src="/images/index.png" id="index" alt="Film összehasonlító"/></a>
</header>

<main>
    <h1>Név: ${sessionScope.foglalas.nev}</h1>
    <h1>Terem: ${requestScope.terem.nev}</h1>
<div id="terem">
    <%
        Terem terem = (Terem) request.getAttribute("terem");
        ArrayList<Foglalas> szemelyFoglalasai = (ArrayList<Foglalas>) request.getAttribute("foglalasai");
        ArrayList<Foglalas> foglaltak = (ArrayList<Foglalas>) request.getAttribute("foglaltak");

        int oszlopokszama = terem.getOszlop();
        int sorokszama = terem.getSor();
        int szekszelesseg = 700 / oszlopokszama;
        for(int i = 1; i <= sorokszama; i++){
            for(int j = 1; j <= oszlopokszama; j++){
                boolean szabad = true;
                for(Foglalas foglalas : szemelyFoglalasai){
                    if(foglalas.getSor() == i && foglalas.getOszlop() == j){
                        out.print("<div style='width: " + (szekszelesseg-4) + "px;height:" + (szekszelesseg-4) + "px;' class='UserFoglaltSzek'></div>");
                        szabad = false;
                        break;
                    }
                }
                for(Foglalas foglalas : foglaltak){
                    if(foglalas.getSor() == i && foglalas.getOszlop() == j){
                        out.print("<div style='width: " + (szekszelesseg-4) + "px;height:" + (szekszelesseg-4) + "px;' class='foglaltSzek'></div>");
                        szabad = false;
                        break;
                    }
                }
                if(szabad){
                    out.print("<a href='../Foglal?sor=" + i + "&oszlop=" + j + "'><div style='width: " + (szekszelesseg-4) + "px;height:" + (szekszelesseg-4) + "px;' class='szek'></div></a>");
                }
            }
            out.print("<br class='clear' />");
        }
    %>
    </div>
<br class="clear"/>
    <table>
        <tr>
            <td>Szabad: </td><td><div style="width:50px;height:50px;" class="szek"></div></td>

        </tr>
        <tr>
            <td>Általad foglalt: </td><td><div style="width:50px;height:50px;" class="UserFoglaltSzek"></div></td>
        </tr>
        <tr>
            <td>Foglalt: </td><td><div style="width:50px;height:50px;" class="foglaltSzek"></div></td>
        </tr>
    </table>
    <h1>Foglalásaid szerkesztése és törlése:</h1>
    <div>
        <div>
            <h4>A foglalás a vetítés elötti 24 órában már nem törölhető!</h4>
            <div class="elem"><div class="sor">Sor:</div><div class="oszlop">Oszlop:</div><div class="modosit"></div><div class="torol"></div><br class="clear" /></div>
            <c:forEach var="item" items="${requestScope.foglalasai}">
                <div class="elem">
                <form method="post" action="/UpdateFoglalas?id=${item.id}">
                    <div class="sor"><input name="sor" type="number" min="1" max="${requestScope.terem.sor}" value="${item.sor}" /></div>
                    <div class="oszlop"><input name="oszlop" type="number" min="1" max="${requestScope.terem.oszlop}" value="${item.oszlop}" /></div>
                    <input type="submit" value="Módosít" name="submit" />

                    <c:if test="${torolheto == true}"><a href="../DeleteFoglalas?id=${item.id}"><div class="torol">Töröl:</div></a></c:if>
                <br class="clear" />
                </form>
            </div>
            </c:forEach>
        </div>
    </div>
</main>
</body>
</html>
