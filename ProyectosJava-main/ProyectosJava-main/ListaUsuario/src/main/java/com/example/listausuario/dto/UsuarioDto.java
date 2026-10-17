package com.example.listausuario.dto;
public class UsuarioDto {
    private String nombre;
    private String contrasena;
    private int id;



    public UsuarioDto(int id, String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasena= contrasena;
        this.id=id;
    }


    public String getNombre() {
        return nombre;
    }
    public String getContrasena() {
        return contrasena; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
    }
    public void setNombre(String nombre) {
    }
    public void setContrasena(String contrasnea) {
    }
}
