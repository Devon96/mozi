package hu.alkfejl.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class Utils {
    public static void showWarning(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Hiba");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    public static boolean validalas(String cim, String fejlec, String uzenet, String btnIgaz, String btnHamis) {
        ButtonType igen = new ButtonType(btnIgaz, ButtonBar.ButtonData.OK_DONE);
        ButtonType megse = new ButtonType(btnHamis, ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, uzenet , igen, megse);
        alert.setHeaderText(fejlec);
        alert.setTitle(cim);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.orElse(megse) == igen) {
            return true;
        }
        return false;
    }


}
