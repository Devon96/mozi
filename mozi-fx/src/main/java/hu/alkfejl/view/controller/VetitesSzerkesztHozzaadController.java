package hu.alkfejl.view.controller;

import hu.alkfejl.controller.FilmController;
import hu.alkfejl.controller.TeremController;
import hu.alkfejl.controller.VetitesController;
import hu.alkfejl.model.bean.Film;
import hu.alkfejl.model.bean.Terem;
import hu.alkfejl.model.bean.Vetites;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class VetitesSzerkesztHozzaadController implements Initializable {
    @FXML
    private ComboBox<String> idopontCom;
    @FXML
    private ComboBox<String> teremCom;
    @FXML
    private ComboBox<String> filmCom;
    @FXML
    private Button btn;
    @FXML
    private DatePicker datumCom;

    private Vetites vetites;


    private ArrayList<Film> filmek;
    private ArrayList<Terem> termek;

    public void initData(Vetites v) {

        String[] idopont = v.getDatum().split(" ");
        idopontCom.getSelectionModel().select(idopont[1]);
        teremCom.getSelectionModel().select(v.getTerem());
        filmCom.getSelectionModel().select(v.getFilmid() + "| " + v.getCim());


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(idopont[0], formatter);
        datumCom.setValue(localDate);




        btn.setText("Módosít");
        vetites = v;

        btn.setOnAction(actionEvent -> {

            String[] filmIDString = filmCom.getValue().split("|");


            int filmID = Integer.parseInt(filmIDString[0]);
            String teremNev = teremCom.getValue();

            String idopont2;
            if(datumCom.getValue() != null){
                idopont2 = datumCom.getValue().toString() + " " + idopontCom.getValue();
            }else{
                idopont2 = null;
            }

            v.setFilmid(filmID);
            v.setTerem(teremNev);
            v.setDatum(idopont2);
            if(VetitesController.getInstance().updateVetites(v)){
                Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
                stage.close();
            }

        });

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idopontCom.getItems().addAll( "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00");
        idopontCom.getSelectionModel().select(7);

        filmek = new ArrayList<>();
        termek = new ArrayList<>();

        for(Terem t : TeremController.getInstance().getAll()){
            teremCom.getItems().add(t.getNev());
            termek.add(t);
        }
        for(Film f : FilmController.getInstance().getAll()){
            filmCom.getItems().add(f.getId() + "| " + f.getCim());
            filmek.add(f);
        }

        teremCom.getSelectionModel().select(0);
        filmCom.getSelectionModel().select(0);

    }

    @FXML
    private void megse(ActionEvent event){
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void addVetites(ActionEvent event){
        String[] filmIDString = filmCom.getValue().split("|");


        int filmID = Integer.parseInt(filmIDString[0]);
        String teremNev = teremCom.getValue();

        String idopont;
        if(datumCom.getValue() != null){
            idopont = datumCom.getValue().toString() + " " + idopontCom.getValue();
        }else{
            idopont = null;
        }

        Vetites vetites = new Vetites(filmID, teremNev, idopont);
        if(VetitesController.getInstance().addVetites(vetites)){
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.close();
        }


    }
}
