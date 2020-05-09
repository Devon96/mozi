package hu.alkfejl.model.bean;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Vetites {
    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty cim = new SimpleStringProperty();
    private IntegerProperty filmid = new SimpleIntegerProperty();
    private StringProperty terem = new SimpleStringProperty();
    private StringProperty datum = new SimpleStringProperty();

    public Vetites() { }

    public Vetites(StringProperty terem, IntegerProperty filmid, StringProperty datum) {
        this.terem = terem;
        this.datum = datum;
        this.filmid = filmid;
    }

    public Vetites(int id, String cim, int filmid, String terem, String datum) {
        this.id.set(id);
        this.cim.set(cim);
        this.terem.set(terem);
        this.datum.set(datum);
        this.filmid.set(filmid);
    }

    public Vetites(int filmid, String terem, String datum) {
        this.terem.set(terem);
        this.datum.set(datum);
        this.filmid.set(filmid);
    }

    public Vetites(int id, String datum) {
        this.datum.set(datum);
        this.id.set(id);
    }

    @Override
    public String toString() {
        return "Vetites{" +
                "id=" + id.get() +
                ", cim=" + cim.get() +
                ", terem=" + terem.get() +
                ", datum=" + datum.toString() +
                '}';
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

    public String getCim() {
        return cim.get();
    }

    public StringProperty cimProperty() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim.set(cim);
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

    public String getDatum() {
        return datum.get();
    }

    public void setDatum(String datum) {
        this.datum.set(datum);
    }

    public int getFilmid() {
        return filmid.get();
    }

    public IntegerProperty filmidProperty() {
        return filmid;
    }

    public void setFilmid(int filmid) {
        this.filmid.set(filmid);
    }
}
