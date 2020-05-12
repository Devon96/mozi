<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="../css/alap.css" />
    <link rel="stylesheet" href="../css/azonosit.css" />
    <title>Azonosítás</title>
</head>
<body>
<header>
    <a href="/pages/filmek.jsp"><img src="/images/index.png" id="index" alt="Film összehasonlító"/></a>
</header>

    <div id="formdiv">

        <h3>Adj meg egy nevet amire foglalod a jegyet és egy azonosítót aminvel késöbb azonosítod magad a jegy módosítáásához vagy lemondásához.</h3>
        <form action="/azonositas" method="post">
            <input class="input" minlength="3" name="nev" type="text" onkeyup="btnActivation()" placeholder="Név" required />
            <input class="input" minlength="3" name="azonositokod" type="password" placeholder="Azonosítókód" required />
            <input class="gomb" type="submit" value="Tovább a foglaláshoz" />
        </form>
    </div>

</body>
</html>
