package com.example.benja.model;

import com.example.benja.dto.UsuarioDto;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class UsuarioModel {
    private ArrayList<UsuarioDto> usuario;

    public UsuarioModel() {
        this.usuario = new ArrayList<>();

    }

    public ArrayList<UsuarioDto> getUsuario() {
        return this.usuario;
    }

    public void agregarUsuarioALista(UsuarioDto usuarioDto) {
        this.usuario.add(usuarioDto);
    }

    public void eliminar(UsuarioDto usuarioDto) {
        this.usuario.remove(usuarioDto);
    }

    public void actualizar(UsuarioDto usuarioDto) {
        for (int i = 0; i < this.usuario.size(); i++) {
            if (this.usuario.get(i).getId() == usuarioDto.getId()) {
                this.usuario.set(i, usuarioDto);
                return;
            }
        }
    }
}