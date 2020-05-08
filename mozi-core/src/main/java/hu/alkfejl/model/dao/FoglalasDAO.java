package hu.alkfejl.model.dao;

import hu.alkfejl.model.bean.Foglalas;

import java.util.ArrayList;

public interface FoglalasDAO {

    ArrayList<Foglalas> getFoglalasok();
    boolean deleteFoglalas(Foglalas f);
    void createTabla();

}
