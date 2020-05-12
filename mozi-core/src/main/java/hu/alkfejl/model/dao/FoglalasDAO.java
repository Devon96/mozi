package hu.alkfejl.model.dao;

import hu.alkfejl.model.bean.Foglalas;

import java.util.ArrayList;

public interface FoglalasDAO {

    ArrayList<Foglalas> getFoglalasok();
    ArrayList<Foglalas> getFoglalasok(String str, String terem, String film);
    ArrayList<Foglalas> getFoglalasok(Foglalas foglalas);
    ArrayList<Foglalas> getUserFoglalasok(Foglalas foglalas);
    boolean addFoglalas(Foglalas foglalas);
    boolean deleteFoglalas(Foglalas f);
    boolean updateFoglalas(Foglalas foglalas);
    /*void createTabla();*/

}
