package com.example.urzua_benjamin.model;

import com.example.urzua_benjamin.control.UsuarioController;
import com.example.urzua_benjamin.dto.UsuarioDto;

import java.util.ArrayList;

public class UsuarioModel {
    private ArrayList<UsuarioDto> usuarios;

    public UsuarioModel(){
        this.usuarios = new ArrayList<>();
    }
    public ArrayList<UsuarioDto> getUsuarios(){
        return this.usuarios;
    }
    public void agregarUsuario(UsuarioDto usuarioDto){
        this.usuarios.add(usuarioDto);
    }

    public void eliminar(UsuarioDto usuarioDto) {
        this.usuarios.remove(usuarioDto);
    }
    public void actualizarUsuario(int id, String nombre, String edad) {
        for (UsuarioDto u : usuarios) {
            if (u.getId() == id) {
                u.setNombre(nombre);
                u.setEdad(edad);
                return;
            }
        }
    }
}
