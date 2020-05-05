package hu.alkfejl.view.controller;

import hu.alkfejl.App;
import hu.alkfejl.controller.TeremController;
import hu.alkfejl.model.bean.Terem;
import hu.alkfejl.utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class TeremTorolController implements Initializable {

    @FXML
    ComboBox<String> termek;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(Terem t : TeremController.getInstance().getAll()){
            termek.getItems().add(t.getNev());
        }
    }


    @FXML
    public void teremTorol(ActionEvent event) {
        if(TeremController.getInstance().torol(termek.getValue())){
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.close();
            App.changeScene("termek");
        }else{
            Utils.showWarning("Sikertelen törlés");
        }
    }

}

