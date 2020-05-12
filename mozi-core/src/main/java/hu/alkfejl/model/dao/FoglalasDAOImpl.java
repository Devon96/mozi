package hu.alkfejl.model.dao;

import hu.alkfejl.config.DBConfig;
import hu.alkfejl.model.bean.Film;
import hu.alkfejl.model.bean.Foglalas;
import hu.alkfejl.model.bean.Terem;

import java.sql.*;
import java.util.ArrayList;

public class FoglalasDAOImpl implements FoglalasDAO {

    private final static String DB_STRING = DBConfig.DB_CONN_STR;

    public FoglalasDAOImpl(){
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.err.println("Nem sikerult betolteni a JDBC drivert");
            e.printStackTrace();
        }
    }


    @Override
    public ArrayList<Foglalas> getFoglalasok() {
        ArrayList<Foglalas> foglalasok = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_STRING); Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT Foglalas.id, Foglalas.nev, Film.cim, Vetites.idopont, Terem.nev, Foglalas.sor, Foglalas.oszlop FROM Foglalas, Film, Vetites, Terem WHERE Foglalas.vetites_id = Vetites.id AND Vetites.filmid = Film.id AND Terem.nev = Vetites.terem;");

            while (rs.next()) {
                Foglalas f = new Foglalas(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7)
                );
                foglalasok.add(f);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foglalasok;
    }

    @Override
    public ArrayList<Foglalas> getFoglalasok(Foglalas foglalas) {
        ArrayList<Foglalas> foglalasok = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_STRING); PreparedStatement st = conn.prepareStatement("SELECT sor, oszlop FROM Foglalas WHERE vetites_id = ? AND ( nev != ? OR jelszo != ? );")) {
            st.setInt(1, foglalas.getVetitesId());
            st.setString(2, foglalas.getNev());
            st.setString(3, foglalas.getAzonositokod());
            ResultSet rs = st.executeQuery();

            while(rs.next()) {
                Foglalas f = new Foglalas(
                        rs.getInt(1),
                        rs.getInt(2)
                );
                foglalasok.add(f);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foglalasok;
    }

    @Override
    public ArrayList<Foglalas> getFoglalasok(String str, String terem, String film) {
        ArrayList<Foglalas> foglalasok = new ArrayList<>();
        str = str.toUpperCase();
        str = "%" + str + "%";

        try (Connection conn = DriverManager.getConnection(DB_STRING); PreparedStatement st = conn.prepareStatement("SELECT Foglalas.id, Foglalas.nev, Film.cim, Vetites.idopont, Terem.nev, Foglalas.sor, Foglalas.oszlop FROM Foglalas, Film, Vetites, Terem WHERE Foglalas.vetites_id = Vetites.id AND Vetites.filmid = Film.id AND Terem.nev = Vetites.terem AND UPPER(Foglalas.nev) LIKE ? AND Terem.nev LIKE ? AND Film.cim LIKE ?;")) {
            st.setString(1, str);
            st.setString(2, terem);
            st.setString(3, film);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Foglalas f = new Foglalas(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7)
                );
                foglalasok.add(f);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foglalasok;
    }

    @Override
    public ArrayList<Foglalas> getUserFoglalasok(Foglalas foglalas) {
        ArrayList<Foglalas> foglalasok = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_STRING); PreparedStatement st = conn.prepareStatement("SELECT id, sor, oszlop FROM Foglalas WHERE vetites_id = ? AND nev = ? AND jelszo = ?;")) {
            st.setInt(1, foglalas.getVetitesId());
            st.setString(2, foglalas.getNev());
            st.setString(3, foglalas.getAzonositokod());
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Foglalas f = new Foglalas(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3)
                );
                foglalasok.add(f);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foglalasok;
    }

    @Override
    public boolean addFoglalas(Foglalas foglalas) {
        try (Connection conn = DriverManager.getConnection(DB_STRING); PreparedStatement st = conn.prepareStatement("INSERT INTO Foglalas (nev, jelszo, sor, oszlop, vetites_id) VALUES(?,?,?,?,?);")) {
            st.setString(1, foglalas.getNev());
            st.setString(2, foglalas.getAzonositokod());
            st.setInt(3, foglalas.getSor());
            st.setInt(4, foglalas.getOszlop());
            st.setInt(5, foglalas.getVetitesId());
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
    public boolean deleteFoglalas(Foglalas f) {
        try (Connection conn = DriverManager.getConnection(DB_STRING); PreparedStatement st = conn.prepareStatement("DELETE FROM Foglalas WHERE id = ?;")) {
            st.setInt(1, f.getId());

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
    public boolean updateFoglalas(Foglalas foglalas) {
        try (Connection conn = DriverManager.getConnection(DB_STRING); PreparedStatement st = conn.prepareStatement("Update Foglalas SET sor = ?, oszlop = ? WHERE id = ?;")) {
            st.setInt(1, foglalas.getSor());
            st.setInt(2, foglalas.getOszlop());
            st.setInt(3, foglalas.getId());

            int res = st.executeUpdate();
            if (res == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
