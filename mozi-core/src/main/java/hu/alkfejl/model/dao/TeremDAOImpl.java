package hu.alkfejl.model.dao;

import hu.alkfejl.config.DBConfig;
import hu.alkfejl.model.bean.Terem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeremDAOImpl implements TeremDAO {
    private final static String DB_STRING = DBConfig.DB_CONN_STR;

    public TeremDAOImpl(){
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.err.println("Nem sikerult betolteni a JDBC drivert");
            e.printStackTrace();
        }
    }


    @Override
    public void createTabla() {
        try (Connection conn = DriverManager.getConnection(DB_STRING); Statement st = conn.createStatement()) {
            st.executeUpdate("CREATE TABLE IF NOT EXISTS Terem(nev VARCHAR PRIMARY KEY, sor INTEGER, oszlop INTEGER)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean add(Terem t) {
        try (Connection conn = DriverManager.getConnection(DB_STRING); PreparedStatement st = conn.prepareStatement("INSERT INTO Terem VALUES(?,?,?);")) {
            st.setString(1, t.getNev());
            st.setInt(2, t.getSor());
            st.setInt(3, t.getOszlop());
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
    public boolean torol(String str) {

        try (Connection conn = DriverManager.getConnection(DB_STRING); PreparedStatement st = conn.prepareStatement("DELETE FROM Terem WHERE nev = ?;")) {
            st.setString(1, str);

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
    public ArrayList<Terem> getTermek() {
        ArrayList<Terem> termek = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_STRING); Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM Terem;");

            while (rs.next()) {
                Terem t = new Terem(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getInt(3)
                );
                termek.add(t);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return termek;
    }
}
