package hu.alkfejl.view.controller;

import hu.alkfejl.App;
import hu.alkfejl.model.bean.Terem;
import hu.alkfejl.utils.Utils;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AddTeremController implements Initializable {
    @FXML
    private Spinner<Integer> sorSpin;
    @FXML
    private Spinner<Integer> oszlopSpin;
    @FXML
    private TextField nevField;
    @FXML
    private TableView<Terem> tabla;



    private void tablaFrissit(){
        App.changeScene("termek");
    }


    @FXML
    private void megse(ActionEvent event){
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
    @FXML
    private void ment(ActionEvent event){
        if (nevField.getText().length() < 2) {
            Utils.showWarning("A terem neve legalább két betű kell hogy legyen");
            return;
        }
        if (sorSpin.getValue() < 1) {
            Utils.showWarning("Legalább egy sor kell a terembe");
            return;
        }
        if (oszlopSpin.getValue() < 1) {
            Utils.showWarning("Legalább egy oszlop kell a terembe");
            return;
        }
        int sor;
        int oszlop;
        String nev;

        try {
            sor = sorSpin.getValue();
            oszlop = oszlopSpin.getValue();
            nev = nevField.getText();
        } catch (NumberFormatException nfe) {
            Utils.showWarning("Hiba a paraméterekkel");
            return;
        }

        Terem t = new Terem(nev, sor, oszlop);

        if (hu.alkfejl.controller.TeremController.getInstance().addTerem(t)) {
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.close();
        } else {
            Utils.showWarning("Nem sikerult hozzáadni a rermet");
            return;
        }
        tablaFrissit();
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<Integer> sorValue = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 20);
        this.sorSpin.setValueFactory(sorValue);
        this.sorSpin.setEditable(true);

        SpinnerValueFactory<Integer> oszlopValue = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 20);
        this.oszlopSpin.setValueFactory(oszlopValue);
        this.oszlopSpin.setEditable(true);

    }
}
