package hu.alkfejl.view.controller;

import hu.alkfejl.App;
import hu.alkfejl.controller.FilmController;
import hu.alkfejl.controller.VetitesController;
import hu.alkfejl.model.bean.Film;
import hu.alkfejl.model.bean.Szinesz;
import hu.alkfejl.model.bean.Vetites;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
    private TableColumn<Vetites, String> idoCol;
    @FXML
    private TableColumn<Vetites, Void> torolCol;
    @FXML
    private TableColumn<Vetites, Void> szerkesztCol;

    @FXML
    private void fomenu() throws IOException {
        App.changeScene("primary");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<Vetites> list = VetitesController.getInstance().getVetitesek();

        tabla.setItems(FXCollections.observableList(list));

        cimCol.setCellValueFactory(new PropertyValueFactory<>("cim"));
        teremCol.setCellValueFactory(new PropertyValueFactory<>("terem"));
        idoCol.setCellValueFactory(new PropertyValueFactory<>("datum"));


        torolCol.setCellFactory(param -> {
            return new TableCell<>() {
                private final Button deleteBtn = new Button("Töröl");

                {
                    deleteBtn.setOnAction(event -> {
                        Vetites v = getTableView().getItems().get(getIndex());
                        VetitesController.getInstance().deleteVetites(v);
                        refreshTable();
                    });

                }
                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(deleteBtn);
                    }
                }
            };
        });

        szerkesztCol.setCellFactory(param -> {
            return new TableCell<>() {
                private final Button deleteBtn = new Button("Szerkesztés");

                {
                    deleteBtn.setOnAction(event -> {
                        Vetites v = getTableView().getItems().get(getIndex());



                        Parent root = null;
                        try {
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("/hu/alkfejl/view/vetitesSzerkesztHozzaad.fxml"));
                            Parent parent = loader.load();
                            Scene scene = new Scene(parent);
                            Stage stage = new Stage();
                            stage.setScene(scene);
                            VetitesSzerkesztHozzaadController fszc = loader.getController();
                            fszc.initData(v);
                            stage.setTitle("Vetítés");
                            stage.setResizable(false);
                            stage.showAndWait();


                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        refreshTable();
                    });

                }
                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(deleteBtn);
                    }
                }
            };
        });

    }
    public void refreshTable(){
        List<Vetites> list = VetitesController.getInstance().getVetitesek();
        tabla.setItems(FXCollections.observableList(list));
    }

    public void hozzaad(){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/hu/alkfejl/view/vetitesSzerkesztHozzaad.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Vetítés hozzáadása");
            stage.setResizable(false);
            stage.showAndWait();

            refreshTable();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
