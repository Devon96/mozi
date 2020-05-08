package hu.alkfejl.controller;

import hu.alkfejl.model.bean.Foglalas;
import hu.alkfejl.model.dao.FoglalasDAO;
import hu.alkfejl.model.dao.FoglalasDAOImpl;
import hu.alkfejl.model.dao.VetitesDAO;
import hu.alkfejl.model.dao.VetitesDAOImpl;
import hu.alkfejl.utils.Utils;

import java.util.ArrayList;

public class FoglalasController {

    private FoglalasDAOImpl dao = new FoglalasDAOImpl();
    private static FoglalasController single_instance = null;

    private FoglalasController(){}

    public static FoglalasController getInstance(){
        if(single_instance == null){
            single_instance = new FoglalasController();
        }
        return single_instance;
    }

    public ArrayList<Foglalas> getFoglalasok(){
        dao.createTabla();
        return dao.getFoglalasok();
    }

    public void deleteFoglalas(Foglalas f) {
        if(! dao.deleteFoglalas(f)){
            Utils.showWarning("Sikertelen törlés!");
        }
    }
}
