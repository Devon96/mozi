package hu.alkfejl.model.dao;

import hu.alkfejl.model.bean.Vetites;

import java.util.ArrayList;

public interface VetitesDAO {

    ArrayList<Vetites> getVetitesek();
    boolean addVetites(Vetites vetites);
    boolean updateVetites(Vetites vetites);
    boolean deleteVetites(Vetites vetites);
    void createTabla();
}
