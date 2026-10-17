package com.example.listausuario.controller;


import com.example.listausuario.dto.UsuarioDto;
import com.example.listausuario.model.UsuarioModeller;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class UsuarioController {
    @FXML
    private void onAgregar() {
        if (txtNombre.getText().isBlank() || txtApellido.getText().isBlank()) {
            alerta("Completa nombre y apellido.");   // validar
            return;
        }
        UsuarioModeller<UsuarioDto>.PersonaModel modelo = new UsuarioModeller<UsuarioDto>.PersonaModel();
        modelo.crear(txtNombre.getText().trim(), txtApellido.getText().trim());  // pedir al modelo
        refrescarTabla();                            // actualizar vista
        limpiar();
    }
}




