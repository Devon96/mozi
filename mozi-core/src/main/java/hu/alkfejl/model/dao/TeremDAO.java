package hu.alkfejl.model.dao;

import hu.alkfejl.model.bean.Film;
import hu.alkfejl.model.bean.Terem;

import java.util.ArrayList;

public interface TeremDAO {

    ArrayList<Terem> getTermek();

    void createTabla();
    boolean add(Terem t);

    boolean torol(String str);
}
