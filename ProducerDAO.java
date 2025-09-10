package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProducerDAO {
    // CREATE
    public void insertProducer(String id, String name, String country, String website) {
        String sql = "INSERT INTO Producer (КодПроизводителя, Название, Страна, ВебCайт) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.setString(2, name);
            stmt.setString(3, country);
            stmt.setString(4, website);

            stmt.executeUpdate();
            System.out.println("Producer added: " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<String> getAllProducers() {
        List<String> producers = new ArrayList<>();
        String sql = "SELECT КодПроизводителя, Название, Страна, ВебCайт FROM Producer";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                producers.add(
                        rs.getString("КодПроизводителя") + " | " +
                                rs.getString("Название") + " | " +
                                rs.getString("Страна") + " | " +
                                rs.getString("ВебCайт")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producers;
    }

    // UPDATE
    public void updateProducer(String id, String newName, String newCountry, String newWebsite) {
        String sql = "UPDATE Producer SET Название=?, Страна=?, ВебCайт=? WHERE КодПроизводителя=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newName);
            stmt.setString(2, newCountry);
            stmt.setString(3, newWebsite);
            stmt.setString(4, id);

            stmt.executeUpdate();
            System.out.println("Producer updated: " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteProducer(String id) {
        String sql = "DELETE FROM Producer WHERE КодПроизводителя=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.executeUpdate();
            System.out.println("Producer deleted: " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}