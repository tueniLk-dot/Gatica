module com.example.benja {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.benja to javafx.fxml;
    exports com.example.benja;
    exports com.example.benja.control;
    opens com.example.benja.control to javafx.fxml;
    exports com.example.benja.dto;}