package com.example.eval;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import static org.testng.AssertJUnit.assertEquals;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class VoitureDAOTest {

    private VoitureDAO voitureDAO;

    @BeforeTest
    public void setUp() throws SQLException {
        voitureDAO = new VoitureDAO();
        clearDatabase();
    }

    @AfterTest
    public void tearDown() throws SQLException {
        clearDatabase();
    }

    private void clearDatabase() throws SQLException {
        try (Connection conn = DatabaseUtil.getConnection()) {
            String sql = "DELETE FROM tvoiture";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
        }
    }

    @Test
    public void testAddVoiture() throws SQLException {
        int initialCount = getVoitureCount();

        Voiture voiture = new Voiture("Test Car", 10000);
        voitureDAO.addVoiture(voiture);

        int newCount = getVoitureCount();
        assertEquals(initialCount + 1, newCount);
    }

    @Test
    public void testGetVoitures() {
        Voiture voiture1 = new Voiture("Test Car 1", 10000);
        Voiture voiture2 = new Voiture("Test Car 2", 20000);
        voitureDAO.addVoiture(voiture1);
        voitureDAO.addVoiture(voiture2);

        List<Voiture> voitures = voitureDAO.getVoitures();
        assertEquals(2, voitures.size());
    }

    @Test
    public void testClearVoitures() throws SQLException {
        Voiture voiture1 = new Voiture("Test Car 1", 10000);
        Voiture voiture2 = new Voiture("Test Car 2", 20000);
        voitureDAO.addVoiture(voiture1);
        voitureDAO.addVoiture(voiture2);

        voitureDAO.clearVoitures();

        int count = getVoitureCount();
        assertEquals(0, count);
    }

    private int getVoitureCount() throws SQLException {
        try (Connection conn = DatabaseUtil.getConnection()) {
            String sql = "SELECT COUNT(*) FROM tvoiture";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;
    }
}
