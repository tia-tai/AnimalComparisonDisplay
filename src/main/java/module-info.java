module com.example.animalcomparisondisplay {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.animalcomparisondisplay to javafx.fxml;
    exports com.example.animalcomparisondisplay;
}