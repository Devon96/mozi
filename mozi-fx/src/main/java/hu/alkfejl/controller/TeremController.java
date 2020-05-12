package hu.alkfejl.controller;

import hu.alkfejl.model.bean.Terem;
import hu.alkfejl.model.dao.TeremDAO;
import hu.alkfejl.model.dao.TeremDAOImpl;

import java.util.ArrayList;
import java.util.List;

public class TeremController {

    private TeremDAO dao = new TeremDAOImpl();
    private static TeremController single_instance = null;

    private TeremController(){

    }

    public static TeremController getInstance(){
        if(single_instance == null){
            single_instance = new TeremController();
        }
        return single_instance;
    }

    public boolean addTerem(Terem t){
        return dao.add(t);
    }

    public List<Terem> getAll() {

        return dao.getTermek();
    }
    public boolean torol(String str){
        return dao.torol(str);
    }

}
