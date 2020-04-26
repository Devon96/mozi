package hu.alkfejl.controller;
/*
import hu.alkfejl.model.bean.Terem;
import hu.alkfejl.model.dao.TeremDAO;
import hu.alkfejl.model.dao.TeremDAOImpl;*/

import java.util.ArrayList;
import java.util.List;

public class TeremController {

    //private TeremDAO dao = new TeremDAOImpl();
    private static TeremController single_instance = null;

    private TeremController(){

    }

    public static TeremController getInstance(){
        if(single_instance == null){
            single_instance = new TeremController();
        }
        return single_instance;
    }

    /*public List<Terem> getAll() {
        ArrayList<Terem> list = new ArrayList<>();
        list.add(new Terem("J1", 40, 20));
        list.add(new Terem("J2", 27, 15));
        list.add(new Terem("B1", 30, 42));



        return list;
        return null;
    }*/
}
