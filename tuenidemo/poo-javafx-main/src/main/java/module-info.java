module com.docente.ventanitados {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.docente.ventanitados to javafx.fxml;

    // AGREGA ESTA LÍNEA:
    opens com.docente.ventanitados.controller to javafx.fxml;
    opens com.docente.ventanitados.model to javafx.fxml;
    opens com.docente.ventanitados.dto to javafx.fxml;

    exports com.docente.ventanitados;
    exports com.docente.ventanitados.dto;
}