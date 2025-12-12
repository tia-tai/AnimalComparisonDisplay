package com.example.animalcomparisondisplay;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class animalApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader mammalLoader = new FXMLLoader(animalApplication.class.getResource("mammalView.fxml"));
        Scene scene = new Scene(mammalLoader.load(), 1000, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public void stop() throws Exception {
        Mammal.saveData();
    }

}
