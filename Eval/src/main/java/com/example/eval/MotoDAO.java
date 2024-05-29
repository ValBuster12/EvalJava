package com.example.eval;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MotoDAO {

    public List<Moto> getMotos() {
        List<Moto> motos = new ArrayList<>();
        String sql = "SELECT * FROM tmoto";

        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                double prix = rs.getDouble("prix");
                Moto moto = new Moto(nom, prix);
                motos.add(moto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return motos;
    }

    public void addMoto(Moto moto) {
        String sql = "INSERT INTO tmoto (nom, prix) VALUES (?, ?)";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, moto.getNom());
            stmt.setDouble(2, moto.getPrix());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void clearMotos() {
        String sql = "DELETE FROM tmoto";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
