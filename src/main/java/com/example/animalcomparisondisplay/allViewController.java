package com.example.animalcomparisondisplay;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.util.Objects;

public class allViewController {
    public TabPane tabs;

    public allViewController(TabPane tabs) {
        this.tabs = tabs;
    }

    public void changeView(Event event) throws Exception {
        Tab sourceButton = (Tab) event.getSource();
        Stage stage = (Stage) tabs.getScene().getWindow();
        if (Objects.equals(sourceButton.getText(), "Fish")) {
            FXMLLoader fishLoader = new FXMLLoader(animalApplication.class.getResource("fishView.fxml"));
            Scene fishScene = new Scene(fishLoader.load(), 320, 240);
            stage.setScene(fishScene);
            stage.show();
        } else {
            FXMLLoader birdLoader = new FXMLLoader(animalApplication.class.getResource("birdView.fxml"));
            Scene birdScene = new Scene(birdLoader.load(), 320, 240);
            stage.setScene(birdScene);
            stage.show();
        }
    }
}
