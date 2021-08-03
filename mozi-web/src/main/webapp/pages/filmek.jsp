<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<html>

<%@ include file="./fragments/head.jspf" %>

<body>
<link rel="stylesheet" href="../css/filmek.css" />
<jsp:include page="../FilmekController"/>
<%@ include file="./fragments/header.jspf" %>

<section class="container-fluid">
    <div class="container-lg">
        <h1>Vetitett filmek</h1>
    </div>
</section>

<section class="container-fluid">
    <div class="container-lg">
        <form method="post" action="/pages/filmek.jsp">
            <div class="row">
                <div class="col-8">
                    <input class="form-control" name="kulcsszo" type="text" placeholder="Filmcímrészlet" />
                </div>
                <div class="col-4">
                    <input class="btn btn-primary" type="submit" value="Keresés" />
                </div>

            </div>
        </form>
    </div>
</section>

<section>

    <div class="container-fluid">

        <div class="row">

            <c:forEach var="item" items="${requestScope.filmList}" >

                <div class="col-12 col-sm-6 col-md-3 col-lg-2 col-xl-1 movie">

                    <div class="card">

                        <a class="movie" href="../Filmleiras?filmId=${item.id}">

                            <img class="card-img-top" src="data:image/jpeg;base64,${item.kep}" alt="Card image cap">
                            <div class="card-body title p-2">
                                ${item.cim}
                            </div>

                        </a>

                    </div>

                </div>

            </c:forEach>

        </div>

    </div>

</section>

<script src="/bootstrap-5.0.2-dist/js/bootstrap.min.js" crossorigin="anonymous"></script>
</body>
</html>
