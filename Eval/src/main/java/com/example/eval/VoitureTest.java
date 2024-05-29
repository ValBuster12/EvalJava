package com.example.eval;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class VoitureTest {

    @Test
    public void testGettersSetters() {
        Voiture voiture = new Voiture("Renault", 15000);

        // Test des getters
        assertEquals("Renault", voiture.getNom());
        assertEquals(15000, voiture.getPrix());

        // Test des setters
        voiture.setNom("Peugeot");
        voiture.setPrix(18000);
        assertEquals("Peugeot", voiture.getNom());
        assertEquals(18000, voiture.getPrix());
    }
}
