package hu.alkfejl.controller;


import hu.alkfejl.model.bean.Foglalas;
import hu.alkfejl.model.dao.FoglalasDAOImpl;
import hu.alkfejl.model.dao.TeremDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/azonositas")
public class FelhasznaloAzonositController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        req.setCharacterEncoding("UTF-8");
        Foglalas foglalas = (Foglalas) req.getSession().getAttribute("foglalas");
        foglalas.setNev(req.getParameter("nev"));
        foglalas.setAzonositokod(req.getParameter("azonositokod"));
        req.getSession().setAttribute("foglalas", foglalas);



        resp.sendRedirect("pages/foglalas.jsp");


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String vetitesId = req.getParameter("vetitesId");

        Foglalas foglalas = new Foglalas();
        foglalas.setVetitesId(Integer.parseInt(vetitesId));

        req.getSession().setAttribute("foglalas", foglalas);
        resp.sendRedirect("pages/felhasznaloAzonositas.jsp");
    }
}
