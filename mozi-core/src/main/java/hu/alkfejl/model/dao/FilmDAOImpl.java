package hu.alkfejl.model.dao;

import hu.alkfejl.model.bean.Film;
import hu.alkfejl.model.bean.Szinesz;
import hu.alkfejl.model.bean.Terem;

import java.sql.*;
import java.util.ArrayList;

public class FilmDAOImpl implements FilmDAO {

    private final static String DB_STRING = "jdbc:sqlite:mozi.db";

    @Override
    public ArrayList<Film> getFilmek() {
        ArrayList<Film> filmek = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_STRING); Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM Film;");

            while (rs.next()) {
                Film f = new Film(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(4),
                        rs.getString(3),
                        rs.getString(6),
                        rs.getInt(5),
                        rs.getString(7)
                );
                filmek.add(f);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filmek;
    }

    @Override
    public boolean addFilm(Film film, ArrayList<Szinesz> szineszek) {//Film(id, cim, rendezo, hossz, korhatar, leiras, kep)
        try (Connection conn = DriverManager.getConnection(DB_STRING); PreparedStatement st = conn.prepareStatement("INSERT INTO Film (cim, rendezo, hossz, korhatar, leiras, kep) VALUES(?,?,?,?,?,?);")) {
            st.setString(1, film.getCim());
            st.setString(2, film.getRendezo());
            st.setInt(3, film.getHossz());
            st.setInt(4, film.getKorhatar());
            st.setString(5, film.getLeiras());
            st.setString(6, film.getKep());
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        Film f = new Film();
        try (Connection conn = DriverManager.getConnection(DB_STRING); PreparedStatement st = conn.prepareStatement("SELECT MAX(id) FROM Film;")) {
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                f.setId(rs.getInt(1));
            }else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        for(Szinesz sz : szineszek){
            if(! addSzinesz(f, sz)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addSzinesz(Film film, Szinesz szinesz) {
        try (Connection conn = DriverManager.getConnection(DB_STRING); PreparedStatement st = conn.prepareStatement("INSERT INTO Szinesz VALUES(?,?);")) {
            st.setInt(1, film.getId());
            st.setString(2, szinesz.getNev());
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
    public void createTabla() {
        /*
        try (Connection conn = DriverManager.getConnection(DB_STRING); Statement st = conn.createStatement()) {
            st.executeUpdate("DROP TABLE Film;");
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        try (Connection conn = DriverManager.getConnection(DB_STRING); Statement st = conn.createStatement()) {
            st.executeUpdate("CREATE TABLE IF NOT EXISTS Szinesz(id INTEGER NOT NULL, nev TEXT NOT NULL);");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection conn = DriverManager.getConnection(DB_STRING); Statement st = conn.createStatement()) {
            st.executeUpdate("CREATE TABLE IF NOT EXISTS Film(id INTEGER PRIMARY KEY AUTOINCREMENT, cim TEXT NOT NULL, rendezo TEXT NOT NULL, hossz INTEGER, korhatar INTEGER, leiras TEXT, kep TEXT);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteSzinesz(Film film, Szinesz sz) {
        try (Connection conn = DriverManager.getConnection(DB_STRING); PreparedStatement st = conn.prepareStatement("DELETE FROM Szinesz WHERE id = ? AND nev = ?;")) {
            st.setInt(1, film.getId());
            st.setString(2, sz.getNev());

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
    public ArrayList<Szinesz> getSzineszek(Film film) {
        ArrayList<Szinesz> szineszek = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_STRING); PreparedStatement st = conn.prepareStatement("SELECT nev FROM Szinesz WHERE id = ?;")) {
            st.setInt(1, film.getId());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Szinesz sz = new Szinesz(rs.getString(1));
                szineszek.add(sz);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return szineszek;
    }

    @Override
    public boolean filmSzerkeszt(Film film) {// Film(id , cim, rendezo, hossz, korhatar, leiras, kep)
        try (Connection conn = DriverManager.getConnection(DB_STRING); PreparedStatement st = conn.prepareStatement("Update Film SET cim = ?, rendezo = ?, hossz = ?, korhatar = ?, leiras = ?, kep = ? WHERE id = ?;")) {
            st.setString(1, film.getCim());
            st.setString(2, film.getRendezo());
            st.setInt(3, film.getHossz());
            st.setInt(4, film.getKorhatar());
            st.setString(5, film.getLeiras());
            st.setString(6, film.getKep());
            st.setInt(7, film.getId());

            int res = st.executeUpdate();
            if (res == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteFilm(Film film) {
        boolean sikeres = true;
        System.out.println("TÖRÖLVE: " + film);
        try (Connection conn = DriverManager.getConnection(DB_STRING); PreparedStatement st = conn.prepareStatement("DELETE FROM Film WHERE id = ?;")) {
            st.setInt(1, film.getId());
            int res = st.executeUpdate();
            if (res != 1) {
                sikeres = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            sikeres = false;
        }

        try (Connection conn = DriverManager.getConnection(DB_STRING); PreparedStatement st = conn.prepareStatement("DELETE FROM Szinesz WHERE id = ?;")) {
            st.setInt(1, film.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            sikeres = false;
        }
        return sikeres;
    }
}
