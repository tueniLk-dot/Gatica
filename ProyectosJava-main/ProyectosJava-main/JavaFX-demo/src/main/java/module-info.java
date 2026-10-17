module com.example.javafxdemo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires java.compiler;

    opens com.example.javafxdemo to javafx.fxml;
    exports com.example.javafxdemo;
    exports com.example.javafxdemo.controller;
    opens com.example.javafxdemo.controller to javafx.fxml;
}