package com.example.javafxdemo.model;

import com.example.javafxdemo.dto.UsuarioDto;

public class LoginModel {
    public boolean iniciarSesion (UsuarioDto usuario) {
        String nombre = "";
        String contrasenia = "";
        if (usuario.getNombreUsuario().equals(nombre)
            && usuario.getContrasenia().equals(contrasenia)){
        return true;
        }else{
        return false;
    }
}
}