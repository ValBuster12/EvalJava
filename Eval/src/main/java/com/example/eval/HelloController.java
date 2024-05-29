package com.example.eval;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.List;

public class HelloController {

    @FXML
    private TextField imputNom;

    @FXML
    private TextField imputPrix;

    @FXML
    private TableView<Voiture> tabVoiture;

    @FXML
    private TableView<Moto> tabMoto;

    @FXML
    private TableColumn<Voiture, String> colNomVoiture;

    @FXML
    private TableColumn<Voiture, Double> colPrixVoiture;

    @FXML
    private TableColumn<Moto, String> colNomMoto;

    @FXML
    private TableColumn<Moto, Double> colPrixMoto;

    @FXML
    private Button btnAjouterVoiture;

    @FXML
    private Button btnAjouterMoto;

    @FXML
    private Button btnViderVoiture;

    @FXML
    private Button btnViderMoto;

    private ObservableList<Voiture> voitures;
    private ObservableList<Moto> motos;

    private VoitureDAO voitureDAO;
    private MotoDAO motoDAO;

    @FXML
    public void initialize() {
        voitureDAO = new VoitureDAO();
        motoDAO = new MotoDAO();

        voitures = FXCollections.observableArrayList();
        motos = FXCollections.observableArrayList();

        colNomVoiture.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrixVoiture.setCellValueFactory(new PropertyValueFactory<>("prix"));

        colNomMoto.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrixMoto.setCellValueFactory(new PropertyValueFactory<>("prix"));

        tabVoiture.setItems(voitures);
        tabMoto.setItems(motos);

        btnAjouterVoiture.setOnAction(event -> ajouterVoiture());
        btnAjouterMoto.setOnAction(event -> ajouterMoto());

        btnViderVoiture.setOnAction(event -> viderVoitures());
        btnViderMoto.setOnAction(event -> viderMotos());

        loadVoitures();
        loadMotos();
    }

    private void ajouterVoiture() {
        String nom = imputNom.getText();
        double prix = Double.parseDouble(imputPrix.getText());
        Voiture voiture = new Voiture(nom, prix);
        voitureDAO.addVoiture(voiture);
        voitures.add(voiture);
        imputNom.clear();
        imputPrix.clear();
    }

    private void ajouterMoto() {
        String nom = imputNom.getText();
        double prix = Double.parseDouble(imputPrix.getText());
        Moto moto = new Moto(nom, prix);
        motoDAO.addMoto(moto);
        motos.add(moto);
        imputNom.clear();
        imputPrix.clear();
    }

    private void viderVoitures() {
        voitureDAO.clearVoitures();
        voitures.clear();
    }

    private void viderMotos() {
        motoDAO.clearMotos();
        motos.clear();
    }

    private void loadVoitures() {
        List<Voiture> list = voitureDAO.getVoitures();
        voitures.addAll(list);
    }

    private void loadMotos() {
        List<Moto> list = motoDAO.getMotos();
        motos.addAll(list);
    }
}
