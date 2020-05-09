package hu.alkfejl.controller;

import hu.alkfejl.model.dao.FilmDAO;
import hu.alkfejl.model.dao.FilmDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/FilmekController")
public class FilmekController extends HttpServlet {
    private FilmDAO dao = new FilmDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("filmList", dao.getFilmek());
    }






}




