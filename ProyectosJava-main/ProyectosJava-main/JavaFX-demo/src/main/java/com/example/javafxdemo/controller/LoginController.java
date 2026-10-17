package com.example.javafxdemo.controller;

import com.example.javafxdemo.dto.UsuarioDto;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    public TextField txtNombreUsuario;
    @FXML
    public PasswordField pswContrasenia;
    @FXML
    private Label lblCambiable;


    @FXML
    protected void onLoginButtonClick() throws Exception {
        String nombre= txtNombreUsuario.getText();
        String contrasenia= pswContrasenia.getText();
        UsuarioDto usuario = new UsuarioDto();
        usuario.setNombreUsuario(nombre);
        usuario.setContrasenia(contrasenia);




        lblCambiable.setText("Bienbvenido!");
    }

}
