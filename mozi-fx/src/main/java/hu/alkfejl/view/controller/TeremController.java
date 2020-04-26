package hu.alkfejl.view.controller;

import hu.alkfejl.App;
//import hu.alkfejl.model.bean.Terem;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TeremController implements Initializable {
/*
    @FXML
    private TableView<Terem> tabla;

    @FXML
    private TableColumn<Terem, String> nevCol;

    @FXML
    private TableColumn<Terem, Integer> sorCol;

    @FXML
    private TableColumn<Terem, Integer> oszlopCol;

    @FXML
    private TableColumn<Terem, Integer> helyCol;

*/
    @FXML
    private void fomenu() throws IOException {
        System.out.println("Valtas fomenube");
        App.changeScene("primary");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*List<Terem> list = hu.alkfejl.controller.TeremController.getInstance().getAll();

        tabla.setItems(FXCollections.observableList(list));

        nevCol.setCellValueFactory(new PropertyValueFactory<>("nev"));
        sorCol.setCellValueFactory(new PropertyValueFactory<>("sor"));
        oszlopCol.setCellValueFactory(new PropertyValueFactory<>("oszlop"));
        helyCol.setCellValueFactory(new PropertyValueFactory<>("ferohely"));
*/
    }
}
