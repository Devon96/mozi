package hu.alkfejl.view.controller;

import hu.alkfejl.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VetitesekController implements Initializable {

    @FXML
    private void fomenu() throws IOException {
        System.out.println("Valtas fomenube");
        App.changeScene("primary");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
