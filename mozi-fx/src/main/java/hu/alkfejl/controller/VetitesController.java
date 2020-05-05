package hu.alkfejl.controller;

import hu.alkfejl.model.bean.Vetites;
import hu.alkfejl.model.dao.VetitesDAO;
import hu.alkfejl.model.dao.VetitesDAOImpl;

import java.util.ArrayList;

public class VetitesController {

    private VetitesDAO dao = new VetitesDAOImpl();
    private static VetitesController single_instance = null;

    private VetitesController(){ }

    public static VetitesController getInstance(){
        if(single_instance == null){
            single_instance = new VetitesController();
        }
        return single_instance;
    }

    public ArrayList<Vetites> getVetitesek(){
        return dao.getVetitesek();
    }



}
