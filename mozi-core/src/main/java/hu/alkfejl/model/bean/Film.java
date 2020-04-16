package hu.alkfejl.model.bean;

import java.util.ArrayList;

public class Film {
    String cim;
    int hossz;
    String rendezo;
    ArrayList<String> szereplok;
    String leiras;
    int korhatar;



    public Film(String cim, int hossz, String rendezo, ArrayList<String> szereplok, String leiras, int korhatar) {
        this.cim = cim;
        this.hossz = hossz;
        this.rendezo = rendezo;
        this.szereplok = szereplok;
        this.leiras = leiras;
        this.korhatar = korhatar;
    }

    public Film() {
    }

    public Film(String cim, int hossz, String rendezo, String leiras, int korhatar) {
        this.cim = cim;
        this.hossz = hossz;
        this.rendezo = rendezo;
        this.leiras = leiras;
        this.korhatar = korhatar;
    }

    @Override
    public String toString() {
        return "Film{" +
                "cim='" + cim + '\'' +
                ", hossz=" + hossz +
                ", rendezo='" + rendezo + '\'' +
                ", leiras='" + leiras + '\'' +
                ", korhatar=" + korhatar +
                '}';
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public int getHossz() {
        return hossz;
    }

    public void setHossz(int hossz) {
        this.hossz = hossz;
    }

    public String getRendezo() {
        return rendezo;
    }

    public void setRendezo(String rendezo) {
        this.rendezo = rendezo;
    }

    public ArrayList<String> getSzereplok() {
        return szereplok;
    }

    public void setSzereplok(ArrayList<String> szereplok) {
        this.szereplok = szereplok;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    public int getKorhatar() {
        return korhatar;
    }

    public void setKorhatar(int korhatar) {
        this.korhatar = korhatar;
    }
}
