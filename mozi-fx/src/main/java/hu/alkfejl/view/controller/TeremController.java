package hu.alkfejl.view.controller;

import hu.alkfejl.App;
//import hu.alkfejl.model.bean.Terem;
import hu.alkfejl.model.bean.Terem;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TeremController implements Initializable {

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


    @FXML
    private void fomenu() throws IOException {
        App.changeScene("primary");
    }

    @FXML
    public void addTerem(){

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/hu/alkfejl/view/addTerem.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Terem hozzáadása");
            stage.setResizable(false);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void torol(){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/hu/alkfejl/view/teremTorol.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Terem törlése");
            stage.setResizable(false);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Terem> list = hu.alkfejl.controller.TeremController.getInstance().getAll();

        tabla.setItems(FXCollections.observableList(list));

        nevCol.setCellValueFactory(new PropertyValueFactory<>("nev"));
        sorCol.setCellValueFactory(new PropertyValueFactory<>("sor"));
        oszlopCol.setCellValueFactory(new PropertyValueFactory<>("oszlop"));
        helyCol.setCellValueFactory(new PropertyValueFactory<>("ferohely"));
    }
}
