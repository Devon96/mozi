package hu.alkfejl.model.dao;

import hu.alkfejl.model.bean.Film;

import java.util.ArrayList;

public interface FilmDAO {

    ArrayList<Film> getFilmek();
    boolean addFilm(Film film);
}
