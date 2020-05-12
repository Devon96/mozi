package hu.alkfejl.controller;

import hu.alkfejl.model.bean.Film;
import hu.alkfejl.model.bean.Szinesz;
import hu.alkfejl.model.bean.Terem;
import hu.alkfejl.model.dao.FilmDAO;
import hu.alkfejl.model.dao.FilmDAOImpl;
import hu.alkfejl.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class FilmController {

    private FilmDAOImpl dao = new FilmDAOImpl();

    private static FilmController single_instance = null;
    private FilmController(){

    }
    public static FilmController getInstance(){
        if(single_instance == null){
            single_instance = new FilmController();
        }
        return single_instance;
    }
    public List<Film> getAll() {

        return dao.getFilmek();
    }

    public boolean deleteSzinesz(Film film, Szinesz sz) {
        return dao.deleteSzinesz(film, sz);
    }
    public ArrayList<Szinesz> getSzineszek(Film film) {
        return dao.getSzineszek(film);
    }

    public boolean addSzinesz(Film film, Szinesz szinesz){
        return dao.addSzinesz(film, szinesz);
    }

    public void filmTorol(Film film) {
        if(Utils.validalas("Töröl", "Törlés", "Biztos törlöd ezt a filmet?", "Igen", "Mégse")){
            if(! dao.deleteFilm(film)){
                Utils.showWarning("Sikertelen törlés");
            }
        }
    }

    public void filmFeltolt(Film film, ArrayList<Szinesz> szineszek) {
        String hibak = "";
        if(film.getCim().length() < 2){
            hibak += "A filmcímnek legalább két karakternek kell lennie.\n";
        }
        if(film.getRendezo().length() < 4){
            hibak += "A rendezőnek legalább négy karakternek kell lennie.\n";
        }
        if(film.getLeiras().length() < 8){
            hibak += "A leírásnak legalább nyolc karakternek kell lennie.\n";
        }
        if(szineszek.isEmpty()){
            hibak += "Legalább egy színészt meg kell adni.\n";
        }
        if(film.getKep().length() < 10){
            hibak += "Borítóképet fel kell tölteni.\n";
        }
        if(hibak.equals("")){
            if(! dao.addFilm(film, szineszek)){
                Utils.showWarning("A film hozzáadása sikertelen");
            }
        }else{
            Utils.showWarning(hibak);
        }
    }

    public void filmSzerkeszt(Film film) {
        if(Utils.validalas("Film szerkesztése", "Film szerkesztése", "Biztos megváltoztatod a film adatait?", "Igen", "Nem")){
            String hibak = "";
            if(film.getCim().length() < 2){
                hibak += "A filmcímnek legalább két karakternek kell lennie.\n";
            }
            if(film.getRendezo().length() < 4){
                hibak += "A rendezőnek legalább négy karakternek kell lennie.\n";
            }
            if(film.getLeiras().length() < 8){
                hibak += "A leírásnak legalább nyolc karakternek kell lennie.\n";
            }
            if(film.getKep().length() < 10){
                hibak += "Borítóképet fel kell tölteni.\n";
            }
            if(hibak.equals("")){
                if(! dao.filmSzerkeszt(film)){
                    Utils.showWarning("A film szerkesztése sikertelen");
                }
            }else{
                Utils.showWarning(hibak);
            }
        }
    }

    public void createTables() {
        dao.createTabla();
    }
}
