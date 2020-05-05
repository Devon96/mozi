package hu.alkfejl.model.bean;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Szinesz {
    private StringProperty nev = new SimpleStringProperty();

    public Szinesz(String nev) {
        this.nev.set(nev);
    }
    public Szinesz() { }

    public String getNev() {
        return nev.get();
    }

    public void setNev(String nev) {
        this.nev.set(nev);
    }

    @Override
    public String toString() {
        return "Szinesz{" +
                "nev=" + nev.get() +
                '}';
    }
}
