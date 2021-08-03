<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<html>
<%@ include file="fragments/head.jspf" %>
<body>
<link rel="stylesheet" href="../css/azonosit.css" />
<%@ include file="./fragments/header.jspf" %>

<section class="container-fluid">
    <div class="container-md">
        <div class="row">
            <div class="col-12">
                <h3>Adj meg egy nevet amire foglalod a jegyet és egy azonosítót aminvel késöbb azonosítod magad a jegy módosítáásához vagy lemondásához.</h3>
            </div>
        </div>
    </div>

    <div class="container login">
        <div class="row justify-content-center">
            <div class="col-12 col-sm-6 col-md-4">
                <div class="card">
                    <div class="card-body">
                        <form action="/azonositas" method="post" autocomplete="off">
                            <div class="form-group">
                                <input type="text" class="form-control" name="nev" minlength="3" placeholder="Név" required>
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" name="azonositokod" placeholder="Azonosítókód" minlength="3" required>
                            </div>
                            <button type="submit" id="sendlogin" class="btn btn-primary">Tovább a foglaláshoz</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    </div>

</section>

</body>
</html>
