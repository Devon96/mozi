package hu.alkfejl.controller;


import hu.alkfejl.model.bean.Foglalas;
import hu.alkfejl.model.bean.Vetites;
import hu.alkfejl.model.dao.FoglalasDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/DeleteFoglalas")
public class DeleteFoglalas extends HttpServlet {
    FoglalasDAOImpl dao = new FoglalasDAOImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Foglalas foglalas = new Foglalas();
        foglalas.setId(Integer.parseInt(req.getParameter("id")));
        dao.deleteFoglalas(foglalas);

        resp.sendRedirect("pages/foglalas.jsp");
    }
}
