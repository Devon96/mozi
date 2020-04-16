import hu.alkfejl.model.bean.Film;
import hu.alkfejl.model.dao.FilmDAO;
import hu.alkfejl.model.dao.FilmDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/film")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        FilmDAO dao = new FilmDAOImpl();
        PrintWriter pw = resp.getWriter();

        for(Film f : dao.getFilmek()){
            pw.println(f);
        }
    }
}
