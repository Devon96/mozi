package hu.alkfejl.model.bean;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Foglalas {

    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty nev = new SimpleStringProperty();
    private StringProperty filmcim = new SimpleStringProperty();
    private StringProperty idopont = new SimpleStringProperty();
    private StringProperty terem = new SimpleStringProperty();
    private IntegerProperty sor = new SimpleIntegerProperty();
    private IntegerProperty oszlop = new SimpleIntegerProperty();

    public Foglalas() { }

    public Foglalas(int id, String nev, String filmcim, String idopont, String terem, int sor, int oszlop) {
        this.id.set(id);
        this.nev.set(nev);
        this.filmcim.set(filmcim);
        this.idopont.set(idopont);
        this.terem.set(terem);
        this.sor.set(sor);
        this.oszlop.set(oszlop);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getNev() {
        return nev.get();
    }

    public StringProperty nevProperty() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev.set(nev);
    }

    public String getIdopont() {
        return idopont.get();
    }

    public StringProperty idopontProperty() {
        return idopont;
    }

    public void setIdopont(String idopont) {
        this.idopont.set(idopont);
    }

    public String getFilmcim() {
        return filmcim.get();
    }

    public StringProperty filmcimProperty() {
        return filmcim;
    }

    public void setFilmcim(String filmcim) {
        this.filmcim.set(filmcim);
    }

    public String getTerem() {
        return terem.get();
    }

    public StringProperty teremProperty() {
        return terem;
    }

    public void setTerem(String terem) {
        this.terem.set(terem);
    }

    public int getSor() {
        return sor.get();
    }

    public IntegerProperty sorProperty() {
        return sor;
    }

    public void setSor(int sor) {
        this.sor.set(sor);
    }

    public int getOszlop() {
        return oszlop.get();
    }

    public IntegerProperty oszlopProperty() {
        return oszlop;
    }

    public void setOszlop(int oszlop) {
        this.oszlop.set(oszlop);
    }
}
