package hu.alkfejl.model.dao;

import hu.alkfejl.model.bean.Terem;

import java.util.ArrayList;
import java.util.List;

public class TeremDAOImpl implements TeremDAO {


    @Override
    public ArrayList<Terem> getTermek() {
        ArrayList<Terem> termek = new ArrayList<>();

        termek.add(new Terem("J1", 19, 40));
        termek.add(new Terem("J2", 19, 40));
        termek.add(new Terem("B1", 15, 34));
        termek.add(new Terem("B2", 18, 34));
        termek.add(new Terem("J3", 17, 27));

        return termek;
    }

    @Override
    public boolean addFilm(Terem terem) {
        return false;
    }
}
