package hu.alkfejl.model.dao;

import hu.alkfejl.model.bean.Film;
import hu.alkfejl.model.bean.Foglalas;
import hu.alkfejl.model.bean.Vetites;

import java.util.ArrayList;

public interface VetitesDAO {

    ArrayList<Vetites> getVetitesek();
    ArrayList<Vetites> getVetitesek(Film film);
    boolean addVetites(Vetites vetites);
    boolean updateVetites(Vetites vetites);
    boolean deleteVetites(Vetites vetites);
    Vetites getVetites(Foglalas foglalas);
}
