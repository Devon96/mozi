package hu.alkfejl.model.dao;

import hu.alkfejl.model.bean.Vetites;
import javafx.beans.property.IntegerProperty;

import java.util.ArrayList;
import java.util.Date;

public class VetitesDAOImpl implements VetitesDAO {


    @Override
    public ArrayList<Vetites> getVetitesek() {
        ArrayList<Vetites> vetitesek = new ArrayList<>();

        // id, cim, filmid, terem, datum
        vetitesek.add(new Vetites(1, "Blöff", 1, "T1", new Date()));
        vetitesek.add(new Vetites(2, "Blöff", 1, "T2", new Date()));
        vetitesek.add(new Vetites(3, "Elrabolva", 2, "J1", new Date()));

        return vetitesek;
    }

    @Override
    public boolean addVetites(Vetites vetites) {
        return false;
    }

    @Override
    public boolean updateVetites(Vetites vetites) {
        return false;
    }
}
