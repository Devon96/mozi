package hu.alkfejl.view.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import hu.alkfejl.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PrimaryController implements Initializable {
    Parent root = null;

    @FXML
    private void termek() {
        App.changeScene("termek");
    }
    @FXML
    private void filmek() {
        App.changeScene("filmek");
    }
    @FXML
    private void vetitesek() {
        App.changeScene("vetitesek");
    }
    @FXML
    private void foglalasok() {
        App.changeScene("foglalas");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

