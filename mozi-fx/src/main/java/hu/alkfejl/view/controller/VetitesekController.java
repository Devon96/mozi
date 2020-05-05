package hu.alkfejl.view.controller;

import hu.alkfejl.App;
import hu.alkfejl.controller.FilmController;
import hu.alkfejl.controller.VetitesController;
import hu.alkfejl.model.bean.Film;
import hu.alkfejl.model.bean.Vetites;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class VetitesekController implements Initializable {

    @FXML
    TableView<Vetites> tabla;
    @FXML
    private TableColumn<Vetites, String> cimCol;
    @FXML
    private TableColumn<Vetites, String> teremCol;
    @FXML
    private TableColumn<Vetites, Date> idoCol;
    @FXML
    private TableColumn<Vetites, Void> torolCol;
    @FXML
    private TableColumn<Vetites, Void> szerkesztCol;

    @FXML
    private void fomenu() throws IOException {
        System.out.println("Valtas fomenube");
        App.changeScene("primary");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<Vetites> list = VetitesController.getInstance().getVetitesek();

        tabla.setItems(FXCollections.observableList(list));

        cimCol.setCellValueFactory(new PropertyValueFactory<>("cim"));
        teremCol.setCellValueFactory(new PropertyValueFactory<>("terem"));
        idoCol.setCellValueFactory(new PropertyValueFactory<>("datum"));




    }
}
