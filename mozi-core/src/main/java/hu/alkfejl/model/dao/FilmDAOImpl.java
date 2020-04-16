package hu.alkfejl.model.dao;

import hu.alkfejl.model.bean.Film;

import java.util.ArrayList;

public class FilmDAOImpl implements FilmDAO {

    @Override
    public ArrayList<Film> getFilmek() {
        ArrayList<Film> filmek = new ArrayList<>();
        filmek.add(new Film("Bosszúállók: Végjáték", 190, "Krisztof a rénszarvas", "Ez egy nagyon jó film de téééényleg", 12));
        filmek.add(new Film("Blöff", 150, "Guy Ritchie", "Szakadtam a nevetéstől", 16));
        return filmek;
    }

    @Override
    public boolean addFilm(Film film) {
        return true;
    }
}
