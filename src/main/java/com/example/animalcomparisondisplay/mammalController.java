package com.example.animalcomparisondisplay;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class mammalController {
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

    public void initialize()  {
        try {
            Mammal.readMammalData();
            int x = 0;

            for (Mammal mammal : Mammal.getMammals()) {
                mammalDatatable.getItems().add(mammal);
                if (x==0) {
                    mammalDatatable.getSelectionModel().select(mammal);
                    x++;
                }
            }

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
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void displayData() {
        Mammal currentMammal = mammalDatatable.getSelectionModel().getSelectedItem();
        currentRank.setText(Integer.toOctalString(currentMammal.getRank()));
        currentName.setText(currentMammal.getName());
        currentAvgLength.setText(Float.toString(currentMammal.getLength()));
        currentAvgMass.setText(Integer.toString(currentMammal.getAvgMass()));
        currentMaxMass.setText(Integer.toString(currentMammal.getMaxMass()));
    }
}
