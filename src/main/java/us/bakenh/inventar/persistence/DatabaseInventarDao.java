package us.bakenh.inventar.persistence;

import us.bakenh.inventar.domain.model.InventarEintrag;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DatabaseInventarDao implements InventarDao {

    private final Connection con;

    public DatabaseInventarDao() throws RuntimeException {

        String url = "jdbc:mysql://localhost:3306/yourdatabase"; // Replace with your database URL
        String user = "root"; // Replace with your username
        String password = "yourpassword"; // Replace with your password

        try {
            this.con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Es konnte keine Verbindung zur Datenbank aufgebaut werden.", e);
        }
    }

    @Override
    public void createEintrag(InventarEintrag inventarEintrag) {

        try {

            Statement statement = con.createStatement();

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS eintraege (" +
                    "bezeichnung VARCHAR(255)," +
                    "anzahl INT" +
                    ");");


            statement.executeUpdate(String.format("INSERT INTO eintraege (bezeichnung, anzahl) VALUES  ('%s', %s)",
                    inventarEintrag.getBezeichnung(), inventarEintrag.getAnzahl()));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public InventarEintrag getEintragByIndex(int index) {
        return getAllEintraege().get(index);
    }

    @Override
    public void deleteEintrag(InventarEintrag inventarEintrag) {
        try {

            Statement statement = con.createStatement();

            statement.executeUpdate(String.format("DELETE FROM eintraege WHERE bezeichnung='%s' AND anzahl=%s",
                    inventarEintrag.getBezeichnung(), inventarEintrag.getAnzahl()));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public InventarEintrag deleteEintragByIndex(int index) {

        InventarEintrag inventarEintrag = getAllEintraege().get(index);

        deleteEintrag(inventarEintrag);

        return inventarEintrag;
    }

    @Override
    public List<InventarEintrag> getAllEintraege() {

        List<InventarEintrag> list = new ArrayList<>();

        try {

            Statement statement = con.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM eintraege");

            while (resultSet.next()) {

                InventarEintrag inventarEintrag = new InventarEintrag(
                        resultSet.getString("bezeichnung"),
                        resultSet.getInt("anzahl"));

                list.add(inventarEintrag);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Collections.unmodifiableList(list);
    }
}
