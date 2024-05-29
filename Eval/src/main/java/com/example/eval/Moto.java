package com.example.eval;

public class Moto {
    private String nom;
    private double prix;

    // Constructeur
    public Moto(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
