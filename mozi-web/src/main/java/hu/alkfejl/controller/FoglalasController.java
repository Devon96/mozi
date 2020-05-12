package hu.alkfejl.controller;

import hu.alkfejl.model.bean.Foglalas;
import hu.alkfejl.model.bean.Vetites;
import hu.alkfejl.model.dao.FoglalasDAOImpl;
import hu.alkfejl.model.dao.TeremDAOImpl;
import hu.alkfejl.model.dao.VetitesDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@WebServlet("/FoglalasController")
public class FoglalasController extends HttpServlet {
    TeremDAOImpl teremDAO = new TeremDAOImpl();
    FoglalasDAOImpl foglalasDAO = new FoglalasDAOImpl();
    VetitesDAOImpl vetitesDAO = new VetitesDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Foglalas foglalas = (Foglalas) req.getSession().getAttribute("foglalas");
        req.setAttribute("terem", teremDAO.getTerem(foglalas));
        req.setAttribute("foglaltak", foglalasDAO.getFoglalasok(foglalas));
        req.setAttribute("foglalasai", foglalasDAO.getUserFoglalasok(foglalas));

        Vetites vetites = vetitesDAO.getVetites(foglalas);
        String idopont = vetites.getDatum();


        Date date = Calendar.getInstance().getTime();

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date vetitesido = null;
        try {
            vetitesido = format.parse(idopont);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (vetitesido.compareTo(date) <= 0) {
            req.setAttribute("torolheto", false);
        }else{
            req.setAttribute("torolheto", true);
        }


    }
}
