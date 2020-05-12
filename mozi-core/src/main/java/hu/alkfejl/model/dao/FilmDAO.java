package hu.alkfejl.model.dao;

import hu.alkfejl.model.bean.Film;
import hu.alkfejl.model.bean.Szinesz;

import java.util.ArrayList;

public interface FilmDAO {

    ArrayList<Film> getFilmek();
    ArrayList<Film> getFilmek(String str);
    boolean addFilm(Film film, ArrayList<Szinesz> szineszek);
    boolean addSzinesz(Film film, Szinesz szinesz);
    void createTabla();
    Film getFilm(int id);

    boolean deleteSzinesz(Film film, Szinesz sz);

    ArrayList<Szinesz> getSzineszek(Film film);

    boolean filmSzerkeszt(Film film);
}
