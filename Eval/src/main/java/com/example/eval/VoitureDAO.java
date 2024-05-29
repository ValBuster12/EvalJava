package com.example.eval;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VoitureDAO {

    public List<Voiture> getVoitures() {
        List<Voiture> voitures = new ArrayList<>();
        String sql = "SELECT * FROM tvoiture";

        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                double prix = rs.getDouble("prix");
                Voiture voiture = new Voiture(nom, prix);
                voitures.add(voiture);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return voitures;
    }

    public void addVoiture(Voiture voiture) {
        String sql = "INSERT INTO tvoiture (nom, prix) VALUES (?, ?)";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, voiture.getNom());
            stmt.setDouble(2, voiture.getPrix());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void clearVoitures() {
        String sql = "DELETE FROM tvoiture";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
