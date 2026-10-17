package com.example.listausuario.model;
import com.example.listausuario.dto.UsuarioDto;

import java.util.ArrayList;
import java.util.List;
public class UsuarioModeller<UsuarioDto> {

    public class PersonaModel {
        private final List<UsuarioDto> personas = new ArrayList<>();
        private int siguienteId = 1;

        public List<UsuarioDto> listar() {
            return new ArrayList<>(personas);
        }

        public void crear(String nombre, String apellido) {
            personas.add(new UsuarioDto(siguienteId++, nombre, apellido));
        }

        public void actualizar(UsuarioDto p, String nombre, String apellido) {
            p.setNombre(nombre);
            p.setApellido(apellido);
        }

        public void eliminar(UsuarioDto p) {
            personas.remove(p);
        }
    }
}
