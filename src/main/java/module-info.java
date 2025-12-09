module com.example.animalcomparisondisplay {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;


    opens com.example.animalcomparisondisplay to javafx.fxml;
    exports com.example.animalcomparisondisplay;
}