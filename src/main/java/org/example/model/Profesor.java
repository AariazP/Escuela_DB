package org.example.model;

import lombok.Data;

@Data
public class Profesor {

    private String id;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasenia;
    private Asignatura[] asignaturas;

}
