package com.example.animalcomparisondisplay;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    }

    public void previousFish() {
        if (currentFish < Fish.getFishes().size()+1) {
            currentFish = currentFish - 1;
        } else {
            currentFish = 0;
        }
        Fish prevFish = Fish.getFishes().get(currentFish);
        fishTitleText.setText(prevFish.getName());
        fishBinomialName.setText(prevFish.getBinomialName());
        fishTaxonomicClass.setText(prevFish.getTaxonomicClass());
        fishRank.setText(String.valueOf(prevFish.getRank()));
        fishLength.setText(String.valueOf(prevFish.getLength()));
        fishMass.setText(String.valueOf(prevFish.getMaxMass()));
//        pictureView.setImage(eaglesImages.get(currentImageNumber));
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

    }


