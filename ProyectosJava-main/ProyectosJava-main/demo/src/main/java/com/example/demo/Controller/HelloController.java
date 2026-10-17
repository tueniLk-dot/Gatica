package com.example.demo.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
public class HelloController {
    @FXML private TextField txtNombre;
    @FXML private CheckBox chkAcepto;

    @FXML
    private void onGuardar() {
        String nombre = txtNombre.getText().trim();
        Alert alerta;
        if (nombre.isEmpty() || !chkAcepto.isSelected()) {
            alerta = new Alert(Alert.AlertType.WARNING,
                    "Ingrese su nombre y acepte continuar.");
        } else {
            alerta = new Alert(Alert.AlertType.INFORMATION,
                    "Usuario registrado: " + nombre);
        }
        alerta.showAndWait();
    }

    @FXML
    private void onLimpiar() {
        txtNombre.clear();
        chkAcepto.setSelected(false);
    }
}

