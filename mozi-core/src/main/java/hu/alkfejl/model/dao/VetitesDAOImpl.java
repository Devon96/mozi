package hu.alkfejl.model.dao;

import hu.alkfejl.config.DBConfig;
import hu.alkfejl.model.bean.Film;
import hu.alkfejl.model.bean.Foglalas;
import hu.alkfejl.model.bean.Szinesz;
import hu.alkfejl.model.bean.Vetites;
import javafx.beans.property.IntegerProperty;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class VetitesDAOImpl implements VetitesDAO {

    private final static String DB_STRING = DBConfig.DB_CONN_STR;

    public VetitesDAOImpl(){
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.err.println("Nem sikerult betolteni a JDBC drivert");
            e.printStackTrace();
        }
    }


    @Override
    public ArrayList<Vetites> getVetitesek() {
        ArrayList<Vetites> vetitesek = new ArrayList<>();


        try (Connection conn = DriverManager.getConnection(DB_STRING); PreparedStatement st = conn.prepareStatement("SELECT Vetites.id, Film.cim, Film.id, terem, idopont FROM Vetites, Film, Terem WHERE Film.id = filmid AND Vetites.terem = Terem.nev;")) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Vetites v = new Vetites(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                vetitesek.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vetitesek;

    }

    @Override
    public ArrayList<Vetites> getVetitesek(Film film) {
        ArrayList<Vetites> vetitesek = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_STRING); PreparedStatement st = conn.prepareStatement("SELECT id, idopont FROM Vetites WHERE filmid = ?;")) {
            st.setInt(1, film.getId());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Vetites v = new Vetites(rs.getInt(1), rs.getString(2));
                vetitesek.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vetitesek;
    }

    @Override
    public boolean addVetites(Vetites vetites) {


        try (Connection conn = DriverManager.getConnection(DB_STRING); PreparedStatement st = conn.prepareStatement("INSERT INTO Vetites (filmid, terem, idopont) VALUES(?,?,?);")) {
            st.setInt(1, vetites.getFilmid());
            st.setString(2, vetites.getTerem());
            st.setString(3, vetites.getDatum());
            int res = st.executeUpdate();
            if (res == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateVetites(Vetites vetites) {

        try (Connection conn = DriverManager.getConnection(DB_STRING); PreparedStatement st = conn.prepareStatement("Update Vetites SET filmid = ?, terem = ?, idopont = ? WHERE id = ?;")) {
            st.setInt(1, vetites.getFilmid());
            st.setString(2, vetites.getTerem());
            st.setString(3, vetites.getDatum());
            st.setInt(4, vetites.getId());

            int res = st.executeUpdate();
            if (res == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean deleteVetites(Vetites vetites) {


        try (Connection conn = DriverManager.getConnection(DB_STRING); PreparedStatement st = conn.prepareStatement("DELETE FROM Vetites WHERE id = ?;")) {
            st.setInt(1, vetites.getId());

            int res = st.executeUpdate();
            if (res == 1) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;


    }

    @Override
    public Vetites getVetites(Foglalas foglalas) {

        try (Connection conn = DriverManager.getConnection(DB_STRING); PreparedStatement st = conn.prepareStatement("SELECT id, idopont FROM Vetites WHERE id = ?;")) {
            st.setInt(1, foglalas.getVetitesId());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Vetites v = new Vetites(rs.getInt(1), rs.getString(2));
                return v;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
