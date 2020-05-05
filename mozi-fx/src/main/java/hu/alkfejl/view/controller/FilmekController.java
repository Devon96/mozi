package hu.alkfejl.view.controller;

import hu.alkfejl.App;
import hu.alkfejl.controller.FilmController;
import hu.alkfejl.model.bean.Film;
import hu.alkfejl.model.bean.Terem;
import hu.alkfejl.model.dao.TeremDAO;
import hu.alkfejl.model.dao.TeremDAOImpl;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FilmekController implements Initializable {

    @FXML
    private TableView<Film> tabla;
    @FXML
    private TableColumn<Film, String> cimCol;
    @FXML
    private TableColumn<Film, String> rendezoCol;
    @FXML
    private TableColumn<Film, Integer> hosszCol;
    @FXML
    private TableColumn<Film, Integer> korhatarCol;
    @FXML
    private TableColumn<Film, Void> szerkesztCol;



    @FXML
    private void fomenu() throws IOException {
        System.out.println("Valtas fomenube");
        App.changeScene("primary");
    }

    @FXML
    private void filmHozzaad() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/hu/alkfejl/view/filmSzerkeszt.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Film hozzáadása");
            stage.setResizable(false);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Film> list = FilmController.getInstance().getAll();

        tabla.setItems(FXCollections.observableList(list));

        cimCol.setCellValueFactory(new PropertyValueFactory<>("cim"));
        rendezoCol.setCellValueFactory(new PropertyValueFactory<>("rendezo"));
        hosszCol.setCellValueFactory(new PropertyValueFactory<>("hossz"));
        korhatarCol.setCellValueFactory(new PropertyValueFactory<>("korhatar"));


        szerkesztCol.setCellFactory(param -> {
            return new TableCell<>() {
                private final Button szerkesztButton = new Button("Szerkesztés");

                {
                    szerkesztButton.setOnAction(event -> {
                        Film f = getTableView().getItems().get(getIndex());

                        Parent root = null;
                        try {
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("/hu/alkfejl/view/filmSzerkeszt.fxml"));
                            Parent parent = loader.load();
                            Scene scene = new Scene(parent);
                            Stage stage = new Stage();
                            stage.setScene(scene);
                            FilmSzerkesztController fszc = loader.getController();
                            fszc.initData(f);
                            stage.setTitle("Film szerkesztése és törlése");
                            stage.setResizable(false);
                            stage.showAndWait();


                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                }

                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(szerkesztButton);
                    }
                }
            };

        });
    }

}
