module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.demo.Controller to javafx.fxml;
    opens com.example.demo to javafx.fxml;
    opens com.example.demo.Dto to javafx.base;
    opens com.example.demo.Modeller to javafx.base;

    exports com.example.demo;
}
