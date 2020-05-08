package hu.alkfejl.view.controller;

import hu.alkfejl.App;
import hu.alkfejl.controller.FilmController;
import hu.alkfejl.model.bean.Film;
import hu.alkfejl.model.bean.Foglalas;
import hu.alkfejl.controller.FoglalasController;
import hu.alkfejl.model.bean.Szinesz;
import hu.alkfejl.model.bean.Vetites;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class FoglalasokController implements Initializable {

    @FXML
    TableView<Foglalas> tabla;
    @FXML
    private TableColumn<Foglalas, String> nevCol;
    @FXML
    private TableColumn<Foglalas, String> filmCol;
    @FXML
    private TableColumn<Foglalas, String> idoCol;
    @FXML
    private TableColumn<Foglalas, String> teremCol;
    @FXML
    private TableColumn<Foglalas, Integer> sorCol;
    @FXML
    private TableColumn<Foglalas, Integer> oszlopCol;
    @FXML
    private TableColumn<Foglalas, Void> torolCol;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        List<Foglalas> list = hu.alkfejl.controller.FoglalasController.getInstance().getFoglalasok();

        tabla.setItems(FXCollections.observableList(list));

        nevCol.setCellValueFactory(new PropertyValueFactory<>("nev"));
        filmCol.setCellValueFactory(new PropertyValueFactory<>("filmcim"));
        idoCol.setCellValueFactory(new PropertyValueFactory<>("idopont"));
        teremCol.setCellValueFactory(new PropertyValueFactory<>("terem"));
        sorCol.setCellValueFactory(new PropertyValueFactory<>("sor"));
        oszlopCol.setCellValueFactory(new PropertyValueFactory<>("oszlop"));

        torolCol.setCellFactory(param -> {
            return new TableCell<>() {
                private final Button deleteBtn = new Button("Töröl");

                {
                    deleteBtn.setOnAction(event -> {
                        Foglalas f = getTableView().getItems().get(getIndex());
                        FoglalasController.getInstance().deleteFoglalas(f);
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
        List<Foglalas> list = FoglalasController.getInstance().getFoglalasok();
        tabla.setItems(FXCollections.observableList(list));
    }

    @FXML
    private void fomenu() throws IOException {
        System.out.println("Valtas fomenube");
        App.changeScene("primary");
    }
}
