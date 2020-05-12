package hu.alkfejl.controller;

import hu.alkfejl.model.bean.Foglalas;
import hu.alkfejl.model.dao.FoglalasDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Foglal")
public class Foglal extends HttpServlet {
FoglalasDAOImpl dao = new FoglalasDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Foglalas foglalas = (Foglalas) req.getSession().getAttribute("foglalas");
        foglalas.setVetitesId(Integer.parseInt((String) req.getSession().getAttribute("vetitesId")));

        foglalas.setSor(Integer.parseInt(req.getParameter("sor")));
        foglalas.setOszlop(Integer.parseInt(req.getParameter("oszlop")));
        dao.addFoglalas(foglalas);
        resp.sendRedirect("pages/foglalas.jsp");

    }


}
