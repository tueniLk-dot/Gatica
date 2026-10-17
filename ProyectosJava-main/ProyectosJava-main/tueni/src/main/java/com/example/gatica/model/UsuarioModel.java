package com.example.gatica.model;

import com.example.gatica.dto.UsuarioDto;

import java.util.ArrayList;

public class UsuarioModel {
    private final ArrayList<UsuarioDto.UsuarioDto> usuarios =  new ArrayList<>();

    public ArrayList<UsuarioDto.UsuarioDto> getUsuarios() {
        return usuarios;
    }

    public void agregarUsuario(UsuarioDto.UsuarioDto usuario) {
        usuarios.add(usuario);
    }

    public void eliminarUsuario(UsuarioDto.UsuarioDto usuario) {
        usuarios.remove(usuario);
    }

}
