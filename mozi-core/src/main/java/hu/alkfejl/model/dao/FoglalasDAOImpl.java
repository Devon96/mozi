package hu.alkfejl.model.dao;

import hu.alkfejl.config.DBConfig;
import hu.alkfejl.model.bean.Foglalas;

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
        foglalasok.add(new Foglalas(1, "Jánoska", "Bosszúállók", "2020-11-11 14:00", "Nagyterem", 11, 21));
        foglalasok.add(new Foglalas(2, "Csuka Józsi", "Bosszúállók", "2020-11-11 14:00", "Nagyterem", 12, 21));
        return foglalasok;
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
    public void createTabla() {

        try (Connection conn = DriverManager.getConnection(DB_STRING); Statement st = conn.createStatement()) {
            st.executeUpdate("CREATE TABLE IF NOT EXISTS Foglalas(id INTEGER PRIMARY KEY AUTOINCREMENT, nev TEXT NOT NULL, jelszo TEXT NOT NULL, sor INTEGER, oszlop INTEGER, vetites_id INTEGER, FOREIGN KEY(vetites_id) REFERENCES Vetites(id));");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
