package com.example.animalcomparisondisplay;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class FishController {
    public TextField fishTitleText;
    public TextField fishBinomialName;
    public TextField fishTaxonomicClass;
    public TextField fishRank;
    public TextField fishLength;
    public TextField fishMass;
    public Button nextImageRight;
    public Button nextImageLeft;
    public TextArea toStringText;
    public ImageView fishImage;
    public FileChooser imageFileChooser = new FileChooser();

    int currentFish = 0;

    public void initialize() throws Exception {
        Fish.readFishData();
        Fish firstFish = Fish.getFishes().get(currentFish);
        fishTitleText.setText(firstFish.getName());
        fishBinomialName.setText(firstFish.getBinomialName());
        fishTaxonomicClass.setText(firstFish.getTaxonomicClass());
        fishRank.setText(String.valueOf(firstFish.getRank()));
        fishLength.setText(String.valueOf(firstFish.getLength()));
        fishMass.setText(String.valueOf(firstFish.getMaxMass()));
        fishImage.setImage(firstFish.getFishImage());
    }

    public void nextFish() {
        if (currentFish < Fish.getFishes().size()-1) {
            currentFish = currentFish + 1;
        } else {
            currentFish = 0;
        }
        Fish nextFish = Fish.getFishes().get(currentFish);
        fishTitleText.setText(nextFish.getName());
        fishBinomialName.setText(nextFish.getBinomialName());
        fishTaxonomicClass.setText(nextFish.getTaxonomicClass());
        fishRank.setText(String.valueOf(nextFish.getRank()));
        fishLength.setText(String.valueOf(nextFish.getLength()));
        fishMass.setText(String.valueOf(nextFish.getMaxMass()));
        fishImage.setImage(nextFish.getFishImage());
    }

    public void previousFish() {
        if (currentFish > 0) {
            currentFish = currentFish - 1;
        } else {
            currentFish = Fish.getFishes().size()-1;
        }
        Fish prevFish = Fish.getFishes().get(currentFish);
        fishTitleText.setText(prevFish.getName());
        fishBinomialName.setText(prevFish.getBinomialName());
        fishTaxonomicClass.setText(prevFish.getTaxonomicClass());
        fishRank.setText(String.valueOf(prevFish.getRank()));
        fishLength.setText(String.valueOf(prevFish.getLength()));
        fishMass.setText(String.valueOf(prevFish.getMaxMass()));
        fishImage.setImage(prevFish.getFishImage());
    }

    public void nextButtonClicked() {
        if (currentFish < Fish.getFishes().size() - 1) {
            currentFish = currentFish + 1;
        } else {
            currentFish = 0;


        }
    }
        public void nextNextButtonClicked () {
   //         pictureView.setImage(CJGJ);
            if (currentFish < 1) {
                currentFish = currentFish + 11;
            }
            if (currentFish < Fish.getFishes().size() + 1) {
                currentFish = currentFish - 1;
            } else {
                currentFish = 0;
            }
      //      pictureView.setImage(Fish.getFishes().get(currentFish));


        }
        public void addPicture() throws Exception {
            Stage mainStage = (Stage)fishTitleText.getScene().getWindow();
            File selectedFile = imageFileChooser.showOpenDialog(mainStage);
            if (selectedFile == null) {
                return;
            }
            FileInputStream input = new FileInputStream(selectedFile);
            Image newImage = new Image(input);

            // store new Image in the selected Model Movie object
            Fish fishToChange = Fish.getFishes().get(currentFish);
            fishToChange.setFishImage(newImage);

            // display Image in the GUI
            fishImage.setImage(newImage);
        }

        public void editAnimalName() {
            String newName = fishTitleText.getText();
            Fish fishToChange = Fish.getFishes().get(currentFish);
            fishToChange.setName(newName);
    }
        public void editBinomialName() {
            String newBinomialName = fishBinomialName.getText();
            Fish fishToChange = Fish.getFishes().get(currentFish);
            fishToChange.setBinomialName(newBinomialName);
    }
        public void editTaxonomicClass() {
            String newTaxonomicClass = fishTaxonomicClass.getText();
            Fish fishToChange = Fish.getFishes().get(currentFish);
            fishToChange.setTaxonomicClass(newTaxonomicClass);
    }
        public void editRank() {
            String newRankString = fishRank.getText();
            Integer newRank = Integer.parseInt(newRankString);
            Fish fishToChange = Fish.getFishes().get(currentFish);
            fishToChange.setRank(newRank);
    }
        public void editLength() {
            String newLength = fishLength.getText();
            Fish fishToChange = Fish.getFishes().get(currentFish);
            fishToChange.setLength(Float.parseFloat(newLength));
    }
        public void editMaxMass() {
            String newMaxMassString = fishMass.getText();
            Integer newMaxMass = Integer.parseInt(newMaxMassString);
            Fish fishToChange = Fish.getFishes().get(currentFish);
            fishToChange.setMaxMass(newMaxMass);
    }
}



