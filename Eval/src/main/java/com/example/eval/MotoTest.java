package com.example.eval;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class MotoTest {

    @Test
    public void testGettersSetters() {
        Moto moto = new Moto("Yamaha", 12000);

        // Test des getters
        assertEquals("Yamaha", moto.getNom());
        assertEquals(12000, moto.getPrix());

        // Test des setters
        moto.setNom("Honda");
        moto.setPrix(14000);
        assertEquals("Honda", moto.getNom());
        assertEquals(14000, moto.getPrix());
    }
}
