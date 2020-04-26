package hu.alkfejl.model.bean;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public class Film {
    private StringProperty cim = new SimpleStringProperty();
    private IntegerProperty hossz = new SimpleIntegerProperty();
    private StringProperty rendezo = new SimpleStringProperty();
    private ArrayList<String> szereplok;
    private StringProperty leiras = new SimpleStringProperty();
    private IntegerProperty korhatar = new SimpleIntegerProperty();



    public Film(String cim, int hossz, String rendezo, ArrayList<String> szereplok, String leiras, int korhatar) {
        this.cim.set(cim);
        this.hossz.set(hossz);
        this.rendezo.set(rendezo);
        this.szereplok = szereplok;
        this.leiras.set(leiras);
        this.korhatar.set(korhatar);
    }

    public Film() {
    }

    public Film(String cim, int hossz, String rendezo, String leiras, int korhatar) {
        this.cim.set(cim);
        this.hossz.set(hossz);
        this.rendezo.set(rendezo);
        this.leiras.set(leiras);
        this.korhatar.set(korhatar);
    }



    public String getCim() {
        return cim.get();
    }

    public void setCim(String cim) {
        this.cim.set(cim);
    }

    public int getHossz() {
        return hossz.get();
    }

    public void setHossz(int hossz) {
        this.hossz.set(hossz);
    }

    public String getRendezo() {
        return rendezo.get();
    }

    public void setRendezo(String rendezo) {
        this.rendezo.set(rendezo);
    }

    public ArrayList<String> getSzereplok() {
        return szereplok;
    }

    public void setSzereplok(ArrayList<String> szereplok) {
        this.szereplok = szereplok;
    }

    public String getLeiras() {
        return leiras.get();
    }

    public void setLeiras(String leiras) {
        this.leiras.set(leiras);
    }

    public int getKorhatar() {
        return korhatar.get();
    }

    public void setKorhatar(int korhatar) {
        this.korhatar.set(korhatar);
    }
}
