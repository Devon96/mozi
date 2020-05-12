package hu.alkfejl.view.controller;

import hu.alkfejl.App;
import hu.alkfejl.controller.FilmController;
import hu.alkfejl.controller.TeremController;
import hu.alkfejl.model.bean.*;
import hu.alkfejl.controller.FoglalasController;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    @FXML
    private TextField keres;
    @FXML
    private ComboBox<String> teremCom;
    @FXML
    private ComboBox<String> filmCom;

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
                        System.out.println(f);
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

        teremCom.getItems().add("Összes terem");
        for(Terem t : TeremController.getInstance().getAll()){
            teremCom.getItems().add(t.getNev());
        }
        teremCom.getSelectionModel().select(0);


        filmCom.getItems().add("Összes film");
        for(Film t : FilmController.getInstance().getAll()){
            filmCom.getItems().add(t.getCim());
        }
        filmCom.getSelectionModel().select(0);

    }

    public void refreshTable(){
        List<Foglalas> list = FoglalasController.getInstance().getFoglalasok();
        tabla.setItems(FXCollections.observableList(list));
    }

    @FXML
    private void kereses(){
        List<Foglalas> list = FoglalasController.getInstance().getFoglalasok(keres.getText(), teremCom.getValue(), filmCom.getValue());
        tabla.setItems(FXCollections.observableList(list));
    }

    @FXML
    private void fomenu() throws IOException {
        App.changeScene("primary");
    }
}
