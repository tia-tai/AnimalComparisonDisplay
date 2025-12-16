package com.example.animalcomparisondisplay;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Objects;

public class mammalController{
    public TableView<Mammal> mammalDatatable;

    public TableColumn<Mammal, Integer> rankTable;
    public TableColumn<Mammal, String> nameTable;
    public TableColumn<Mammal, Integer> avgMassTable;
    public TableColumn<Mammal, Integer> maxMassTable;
    public TableColumn<Mammal, Float> avgLengthTable;

    public TextField currentRank;
    public TextField currentName;
    public TextField currentAvgMass;
    public TextField currentAvgLength;
    public TextField currentMaxMass;

    public Button uploadButton;
    public ImageView imageData;
    private FileChooser fileChooser = new FileChooser();

    public TabPane tabs;
    public Image img;

    int currentItem = 0;

    public void initialize()  {
        try {
            Mammal.readMammalData();
            int x = 0;

            for (Mammal mammal : Mammal.getMammals()) {
                mammalDatatable.getItems().add(mammal);
            }

            mammalDatatable.getSelectionModel().select(Mammal.getMammals().get(currentItem));

            rankTable.setCellValueFactory(new PropertyValueFactory<>("rank"));
            nameTable.setCellValueFactory(new PropertyValueFactory<>("name"));
            avgMassTable.setCellValueFactory(new PropertyValueFactory<>("avgMass"));
            maxMassTable.setCellValueFactory(new PropertyValueFactory<>("maxMass"));
            avgLengthTable.setCellValueFactory(new PropertyValueFactory<>("length"));

            Mammal currentMammal = mammalDatatable.getSelectionModel().getSelectedItem();
            currentRank.setText(Integer.toOctalString(currentMammal.getRank()));
            currentName.setText(currentMammal.getName());
            currentAvgLength.setText(Float.toString(currentMammal.getLength()));
            currentAvgMass.setText(Integer.toString(currentMammal.getAvgMass()));
            currentMaxMass.setText(Integer.toString(currentMammal.getMaxMass()));
            if (currentMammal.getImg() != null) {
                imageData.setImage(currentMammal.getImg());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void update() {
        mammalDatatable.getItems().clear();
        try {
            int x = 0;

            for (Mammal mammal : Mammal.getMammals()) {
                mammalDatatable.getItems().add(mammal);
            }

            mammalDatatable.getSelectionModel().select(Mammal.getMammals().get(currentItem));

            rankTable.setCellValueFactory(new PropertyValueFactory<>("rank"));
            nameTable.setCellValueFactory(new PropertyValueFactory<>("name"));
            avgMassTable.setCellValueFactory(new PropertyValueFactory<>("avgMass"));
            maxMassTable.setCellValueFactory(new PropertyValueFactory<>("maxMass"));
            avgLengthTable.setCellValueFactory(new PropertyValueFactory<>("length"));
            Mammal currentMammal = mammalDatatable.getSelectionModel().getSelectedItem();
            currentRank.setText(Integer.toOctalString(currentMammal.getRank()));
            currentName.setText(currentMammal.getName());
            currentAvgLength.setText(Float.toString(currentMammal.getLength()));
            currentAvgMass.setText(Integer.toString(currentMammal.getAvgMass()));
            currentMaxMass.setText(Integer.toString(currentMammal.getMaxMass()));
            if (currentMammal.getImg() != null) {
                imageData.setImage(currentMammal.getImg());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void displayData() throws FileNotFoundException {
        Mammal currentMammal = mammalDatatable.getSelectionModel().getSelectedItem();
        currentRank.setText(Integer.toOctalString(currentMammal.getRank()));
        currentName.setText(currentMammal.getName());
        currentAvgLength.setText(Float.toString(currentMammal.getLength()));
        currentAvgMass.setText(Integer.toString(currentMammal.getAvgMass()));
        currentMaxMass.setText(Integer.toString(currentMammal.getMaxMass()));
        if (currentMammal.getImg() != null) {
            imageData.setImage(currentMammal.getImg());
        } else {
            imageData.setImage(null);
        }
        currentItem = Mammal.getMammals().indexOf(currentMammal);
    }

    public void uploadImage() throws FileNotFoundException {
        uploadButton.setDisable(true);
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );
        File selectedFile = fileChooser.showOpenDialog(null);
        FileInputStream imgInput = new FileInputStream(selectedFile);
        img = new Image(imgInput);
        imageData.setImage(img);
        uploadButton.setDisable(false);
    }

    public void changingView(Event event) throws Exception {
        Tab sourceButton = (Tab) event.getSource();
        Stage stage = (Stage) tabs.getScene().getWindow();
        if (Objects.equals(sourceButton.getText(), "Fish")) {
            FXMLLoader fishLoader = new FXMLLoader(animalApplication.class.getResource("fishView.fxml"));
            Scene fishScene = new Scene(fishLoader.load(), 651, 456);
            stage.setScene(fishScene);
            stage.show();
        } else {
            FXMLLoader birdLoader = new FXMLLoader(animalApplication.class.getResource("birdView.fxml"));
            Scene birdScene = new Scene(birdLoader.load(), 651, 456);
            stage.setScene(birdScene);
            stage.show();
        }
    }

    public void save() throws Exception {
        Mammal currentMammal = mammalDatatable.getSelectionModel().getSelectedItem();
        currentMammal.setAvgMass(Integer.parseInt(currentAvgMass.getText()));
        currentMammal.setMaxMass(Integer.parseInt(currentMaxMass.getText()));
        currentMammal.setName(currentName.getText());
        currentMammal.setRank(Integer.parseInt(currentRank.getText()));
        currentMammal.setLength(Float.parseFloat(currentAvgLength.getText()));
        currentMammal.setImg(imageData.getImage());
        update();
        Mammal.saveData();
    }

    public void delete() throws Exception {
        Mammal currentMammal = mammalDatatable.getSelectionModel().getSelectedItem();
        Mammal.deleteMammalData(currentMammal);
        currentItem = 0;
        update();
    }

    public void add() {
        int avgMass = Integer.parseInt(currentAvgMass.getText());
        int maxMass = Integer.parseInt(currentMaxMass.getText());
        String name = currentName.getText();
        int rank = Integer.parseInt(currentRank.getText());
        float length = Float.parseFloat(currentAvgLength.getText());
        Image image = imageData.getImage();
        new Mammal(rank, name, length, maxMass, avgMass, image);
        currentItem = Mammal.getMammals().toArray().length - 1;
        update();
    }
}
