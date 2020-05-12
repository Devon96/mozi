package hu.alkfejl.controller;


import hu.alkfejl.model.bean.Foglalas;
import hu.alkfejl.model.dao.FoglalasDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet("/UpdateFoglalas")
public class UpdateFoglalas extends HttpServlet {
FoglalasDAOImpl foglalasDAO = new FoglalasDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");


        Foglalas foglalas = (Foglalas) req.getSession().getAttribute("foglalas");

        foglalas.setId(Integer.parseInt(req.getParameter("id")));

        foglalas.setOszlop(Integer.parseInt(req.getParameter("oszlop")));
        foglalas.setSor(Integer.parseInt(req.getParameter("sor")));


        for(Foglalas f : foglalasDAO.getFoglalasok(foglalas)){
            if(f.getOszlop() == foglalas.getOszlop() && f.getSor() == foglalas.getSor()){
                System.out.println("A hely már foglalt");
                resp.sendRedirect("pages/foglalas.jsp");
                return;
            }
        }
        for(Foglalas f : foglalasDAO.getUserFoglalasok(foglalas)){
            if(f.getOszlop() == foglalas.getOszlop() && f.getSor() == foglalas.getSor()){
                System.out.println("A hely már foglalt");
                resp.sendRedirect("pages/foglalas.jsp");
                return;
            }
        }

        foglalasDAO.updateFoglalas(foglalas);
        resp.sendRedirect("pages/foglalas.jsp");
    }
}
