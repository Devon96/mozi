package hu.alkfejl.model.bean;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Terem {

    private StringProperty nev = new SimpleStringProperty();
    private IntegerProperty sor = new SimpleIntegerProperty();
    private IntegerProperty oszlop = new SimpleIntegerProperty();
    private IntegerProperty ferohely = new SimpleIntegerProperty();

    public Terem(String nev, int sor, int oszlop) {
        this.nev.set(nev);
        this.sor.set(sor);
        this.oszlop.set(oszlop);
        this.ferohely.set(sor*oszlop);
    }

    public String getNev() {
        return nev.get();
    }


    public void setNev(String nev) {
        this.nev.set(nev);
    }

    public int getSor() {
        return sor.get();
    }


    public void setSor(int sor) {
        this.sor.set(sor);
    }

    public int getOszlop() {
        return oszlop.get();
    }


    public void setOszlop(int oszlop) {
        this.oszlop.set(oszlop);
    }

    public int getFerohely() {
        return ferohely.get();
    }

    public void setFerohely(int ferohely) {
        this.ferohely.set(ferohely);
    }
}
