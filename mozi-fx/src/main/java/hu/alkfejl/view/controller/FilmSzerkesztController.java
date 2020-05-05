package hu.alkfejl.view.controller;

import hu.alkfejl.App;
import hu.alkfejl.controller.FilmController;
import hu.alkfejl.model.bean.Film;
import hu.alkfejl.model.bean.Szinesz;
import hu.alkfejl.model.bean.Terem;
import hu.alkfejl.utils.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;

import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FilmSzerkesztController implements Initializable {


    @FXML
    private Spinner<Integer> hossz;
    @FXML
    private TextField cim;
    @FXML
    private TextField szinesz;
    @FXML
    private TextField rendezo;
    @FXML
    private TableView<Szinesz> tabla;
    @FXML
    private TableColumn<Szinesz, Integer> nevCol;
    @FXML
    private TableColumn<Szinesz, Void> torolCol;
    @FXML
    private ComboBox<Integer> korhatar;
    @FXML
    private TextArea leiras;
    @FXML
    private Button btn1;
    @FXML
    private Button btn3;
    @FXML
    private ImageView imageView;

    private Film film;
    private ArrayList<Szinesz> szineszek;
    private String kepKod = "";


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        korhatar.getItems().addAll(5, 12, 16, 18);
        korhatar.getSelectionModel().select(1);

        SpinnerValueFactory<Integer> sorValue = new SpinnerValueFactory.IntegerSpinnerValueFactory(30, 400, 120);
        this.hossz.setValueFactory(sorValue);
        this.hossz.setEditable(true);

        szineszek = new ArrayList<>();
        tabla.setItems(FXCollections.observableList(szineszek));


        nevCol.setCellValueFactory(new PropertyValueFactory<>("nev"));

        torolCol.setCellFactory(param -> {
            return new TableCell<>() {
                private final Button deleteBtn = new Button("Töröl");

                {
                    deleteBtn.setOnAction(event -> {
                        Szinesz sz = getTableView().getItems().get(getIndex());
                        szineszek.remove(sz);
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

    public void initData(Film f) {
        cim.setText(f.getCim());
        leiras.setText(f.getLeiras());
        this.film = f;
        SpinnerValueFactory<Integer> sorValue = new SpinnerValueFactory.IntegerSpinnerValueFactory(30, 400, f.getHossz());
        this.hossz.setValueFactory(sorValue);
        this.hossz.setEditable(true);

        switch (f.getKorhatar()){
            case 5:
                korhatar.getSelectionModel().select(0);
                break;
            case 12:
                korhatar.getSelectionModel().select(1);
                break;
            case 16:
                korhatar.getSelectionModel().select(2);
                break;
            case 18:
                korhatar.getSelectionModel().select(3);
                break;
        }


        szineszek.addAll(FilmController.getInstance().getSzineszek(f));
        tabla.setItems(FXCollections.observableList(szineszek));


        nevCol.setCellValueFactory(new PropertyValueFactory<>("nev"));
        btn1.setText("Töröl");
        btn3.setVisible(true);
        rendezo.setText(f.getRendezo());
        btn1.setOnAction(actionEvent -> {
            filmTorol();
        });

        torolCol.setCellFactory(param -> {
            return new TableCell<>() {
                private final Button deleteBtn = new Button("Töröl");

                {
                    deleteBtn.setOnAction(event -> {
                        Szinesz sz = getTableView().getItems().get(getIndex());
                        if(film != null){
                            if(FilmController.getInstance().deleteSzinesz(f, sz)) {
                                refreshTable();
                            }else{
                                Utils.showWarning("Törlés sikertelen");
                            }
                        }
                        szineszek.remove(sz);
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

        kepKod = f.getKep();

        byte[] decodedBytes = Base64.getDecoder().decode(f.getKep());
        ByteArrayInputStream bais = new ByteArrayInputStream(decodedBytes);
        BufferedImage image = null;
        Image img = null;
        try {
            image = ImageIO.read(bais);
            img = convertToFxImage(image);

        } catch (IOException e) {
            e.printStackTrace();
        }
        imageView.setImage(img);


    }

    @FXML
    public void addSzinesz(){

        if (szinesz.getLength() < 3) {
            Utils.showWarning("A színész nevének legalább 3 betőnek kell lennie");
            return;
        }
        if(film != null) {
            if (!FilmController.getInstance().addSzinesz(film, new Szinesz(szinesz.getText()))) {
                Utils.showWarning("Probléma a színész feltöltésénél");
            }
        }else{
            szineszek.add(new Szinesz(szinesz.getText()));
            tabla.setItems(FXCollections.observableList(szineszek));
        }
        refreshTable();
    }
    public void refreshTable(){
        if(film != null){
            List<Szinesz> list = FilmController.getInstance().getSzineszek(film);
            tabla.setItems(FXCollections.observableList(list));
        }else{
            tabla.setItems(FXCollections.observableList(szineszek));
        }
        szinesz.clear();
    }

    @FXML
    public void filmTorol(){
        FilmController.getInstance().filmTorol(film);
        App.changeScene("filmek");
        Stage stage = (Stage) (tabla.getScene().getWindow());
        stage.close();
    }
    @FXML
    public void megse(){
        Stage stage = (Stage) (tabla.getScene().getWindow());
        stage.close();
    }
    @FXML
    public void filmFeltolt(){
        Film film = new Film(cim.getText(), hossz.getValue(), rendezo.getText(), leiras.getText(), korhatar.getValue(), kepKod);
        System.out.println(film);

        FilmController.getInstance().filmFeltolt(film , szineszek);
        App.changeScene("filmek");
        megse();
    }
    @FXML
    public void filmSzerkeszt(){
        Film f = new Film();
        f.setId(film.getId());
        f.setRendezo(rendezo.getText());
        f.setLeiras(leiras.getText());
        f.setKorhatar(korhatar.getValue());
        f.setHossz(hossz.getValue());
        f.setCim(cim.getText());
        f.setKep(kepKod);


        FilmController.getInstance().filmSzerkeszt(f);
        App.changeScene("filmek");
        megse();
    }

    @FXML
    public void kepFeltolt(){


        Stage ablak = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Válassz egy képet");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JPG", "*jpg"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG", "*png"));

        File file = fileChooser.showOpenDialog(ablak);

        byte[] fileContent = new byte[0];
        try {
            fileContent = FileUtils.readFileToByteArray(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        kepKod = Base64.getEncoder().encodeToString(fileContent);
        System.out.println(kepKod);

        ByteArrayInputStream bais = new ByteArrayInputStream(fileContent);
        BufferedImage image = null;
        Image img = null;

        try {
            image = ImageIO.read(bais);
            img = convertToFxImage(image);

        } catch (IOException e) {
            e.printStackTrace();
        }
        imageView.setImage(img);



    }
    private static Image convertToFxImage(BufferedImage image) {
        WritableImage wr = null;
        if (image != null) {
            wr = new WritableImage(image.getWidth(), image.getHeight());
            PixelWriter pw = wr.getPixelWriter();
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    pw.setArgb(x, y, image.getRGB(x, y));
                }
            }
        }
        return new ImageView(wr).getImage();
    }


}















