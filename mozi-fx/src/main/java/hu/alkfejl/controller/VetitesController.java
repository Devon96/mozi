package hu.alkfejl.controller;

import hu.alkfejl.model.bean.Vetites;
import hu.alkfejl.model.dao.VetitesDAO;
import hu.alkfejl.model.dao.VetitesDAOImpl;
import hu.alkfejl.utils.Utils;

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


    public void deleteVetites(Vetites v) {
        if(Utils.validalas("Töröl", "Törlés", "Biztos törlöd ezt a vetítést?", "Igen", "Mégse")){
            if(! dao.deleteVetites(v)){
                Utils.showWarning("Sikertelen törlés");
            }
        }
    }

    public boolean addVetites(Vetites vetites) { ;
        if(vetites.getDatum() == null){
            Utils.showWarning("Meg kell adni a dátumot.");
            return false;
        }
        if(! dao.addVetites(vetites)){
            Utils.showWarning("A vetítés hozzáadása sikertelen");
            return false;
        }
        return true;
    }

    public boolean updateVetites(Vetites v) {
        if(v.getDatum() == null){
            Utils.showWarning("Meg kell adni dátumot");
            return false;
        }
        if(dao.updateVetites(v)){
            return true;
        }
        Utils.showWarning("A szerkesztés sikertelen");
        return false;
    }
}
