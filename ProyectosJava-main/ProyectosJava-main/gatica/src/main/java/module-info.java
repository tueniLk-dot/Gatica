module urzua.benjamin {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires annotations;

    opens com.example.urzua_benjamin to javafx.fxml, javafx.graphics;
    opens com.example.urzua_benjamin.control to javafx.fxml;
    opens com.example.urzua_benjamin.dto to javafx.fxml;
    opens com.example.urzua_benjamin.model to javafx.fxml;

    exports com.example.urzua_benjamin;
    exports com.example.urzua_benjamin.control;
    exports com.example.urzua_benjamin.dto;
    exports com.example.urzua_benjamin.model;
}