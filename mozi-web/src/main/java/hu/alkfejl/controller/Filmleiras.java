package hu.alkfejl.controller;

import hu.alkfejl.model.bean.Film;
import hu.alkfejl.model.bean.Szinesz;
import hu.alkfejl.model.bean.Vetites;
import hu.alkfejl.model.dao.FilmDAO;
import hu.alkfejl.model.dao.FilmDAOImpl;
import hu.alkfejl.model.dao.VetitesDAO;
import hu.alkfejl.model.dao.VetitesDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Filmleiras")
public class Filmleiras extends HttpServlet {
    private FilmDAO filmDAO = new FilmDAOImpl();
    private VetitesDAO vetitesDAO = new VetitesDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filmId = req.getParameter("filmId");

        if(filmId != null && !filmId.isEmpty()){
            int id = Integer.parseInt(filmId);
            Film film = filmDAO.getFilm(id);
            ArrayList<Vetites> vetitesek = vetitesDAO.getVetitesek(film);
            req.setAttribute("film", film);
            req.setAttribute("vetitesek", vetitesek);
            req.setAttribute("szineszek", filmDAO.getSzineszek(film));
            for(Vetites i : vetitesek){
                System.out.println(i);
            }

        }

        req.getRequestDispatcher("pages/filmleiras.jsp").forward(req, resp);
    }
}
