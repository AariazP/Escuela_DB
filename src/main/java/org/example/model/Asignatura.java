package org.example.model;

import lombok.Data;
import java.util.Date;
@Data
public class Asignatura {

    private String id;
    private String nombre;
    private Profesor profesor;
    private Integer intensidadHoraria;
    private Date fechaAsignatura;

}
