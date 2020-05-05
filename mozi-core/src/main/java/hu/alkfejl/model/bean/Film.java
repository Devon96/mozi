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
    private StringProperty leiras = new SimpleStringProperty();
    private IntegerProperty korhatar = new SimpleIntegerProperty();
    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty kep = new SimpleStringProperty();

    @Override
    public String toString() {
        return "Film{" +
                "cim=" + cim.get() +
                ", hossz=" + hossz.get() +
                ", rendezo=" + rendezo.get() +
                ", leiras=" + leiras.get() +
                ", korhatar=" + korhatar.get() +
                ", id=" + id.get() +
                '}';
    }

    public Film() {
    }

    public Film(Film f) {
        id.set(f.getId());
        cim.set(f.getCim());
        hossz.set(f.getHossz());
        rendezo.set(f.getRendezo());
        leiras.set(f.getLeiras());
        korhatar.set(f.getKorhatar());
    }

    public Film(int id, String cim, int hossz, String rendezo, String leiras, int korhatar, String kep) {
        this.id.set(id);
        this.cim.set(cim);
        this.hossz.set(hossz);
        this.rendezo.set(rendezo);
        this.leiras.set(leiras);
        this.korhatar.set(korhatar);
        this.kep.set(kep);
    }
    public Film(String cim, int hossz, String rendezo, String leiras, int korhatar, String kep) {
        this.cim.set(cim);
        this.hossz.set(hossz);
        this.rendezo.set(rendezo);
        this.leiras.set(leiras);
        this.korhatar.set(korhatar);
        this.kep.set(kep);
    }
    public Film(int id) {
        this.id.set(id);
    }


    public String getKep() {
        return kep.get();
    }

    public void setKep(String kep) {
        this.kep.set(kep);
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

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }
}
