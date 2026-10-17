package com.example.javafxdemo.dto;

import javax.lang.model.util.Elements;
import javax.swing.text.Element;

public class UsuarioDto {
    private String nombreUsuario = "";


    private String contrasenia = "";

    public UsuarioDto() {
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) throws Exception {

    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
