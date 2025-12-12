module com.example.animalcomparisondisplay {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires java.desktop;
    requires javafx.swing;


    opens com.example.animalcomparisondisplay to javafx.fxml;
    exports com.example.animalcomparisondisplay;
}