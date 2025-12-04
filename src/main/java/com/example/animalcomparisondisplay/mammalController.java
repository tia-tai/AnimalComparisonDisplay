package com.example.animalcomparisondisplay;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class mammalController {
    public TableView<Mammal> mammalDatatable;

    public TableColumn<Mammal, Integer> rankTable;
    public TableColumn<Mammal, String> nameTable;
    public TableColumn<Mammal, Integer> avgMassTable;
    public TableColumn<Mammal, Integer> maxMassTable;
    public TableColumn<Mammal, Float> avgLengthTable;

    public void initialize()  {
        try {
            Mammal.readMammalData();

            for (Mammal mammal : Mammal.getMammals()) {
                mammalDatatable.getItems().add(mammal);
            }

            rankTable.setCellValueFactory(new PropertyValueFactory<>("rank"));
            nameTable.setCellValueFactory(new PropertyValueFactory<>("name"));
            avgMassTable.setCellValueFactory(new PropertyValueFactory<>("avgMass"));
            maxMassTable.setCellValueFactory(new PropertyValueFactory<>("maxMass"));
            avgLengthTable.setCellValueFactory(new PropertyValueFactory<>("length"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
