package hu.alkfejl;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        changeScene("primary");
        stage.setTitle("Mozi");
        stage.setScene(scene);
        stage.show();
    }

     public static void changeScene(String str){
         try{
             Parent root = FXMLLoader.load(App.class.getResource("/hu/alkfejl/view/"+str+".fxml"));
             scene = new Scene(root);
             stage.setScene(scene);
             stage.setResizable(false);
         }catch (Exception e){
             e.printStackTrace();
                System.out.println("HIBA az fxmlLoaderrel");
         }


     }



    public static void main(String[] args) {
        launch();
    }

}