package com.example.animalcomparisondisplay;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class animalController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
