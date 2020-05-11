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

@WebServlet("/FoglalasController")
public class FoglalasController extends HttpServlet {
    TeremDAOImpl teremDAO = new TeremDAOImpl();
    FoglalasDAOImpl foglalasDAO = new FoglalasDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Foglalas foglalas = (Foglalas) req.getSession().getAttribute("foglalas");
        req.setAttribute("terem", teremDAO.getTerem(foglalas));
        req.setAttribute("foglaltak", foglalasDAO.getFoglalasok(foglalas));
        req.setAttribute("foglalasai", foglalasDAO.getUserFoglalasok(foglalas));


    }
}
