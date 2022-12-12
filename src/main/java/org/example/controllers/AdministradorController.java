package org.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.example.Utilities.Utils;
import org.example.model.Controller;

public class AdministradorController extends Controller {

    @FXML
    private TableView<?> tblProfesores;

    @FXML
    private TableColumn<?, ?> tblProfesores_apellido;

    @FXML
    private TableColumn<?, ?> tblProfesores_asignaturas;

    @FXML
    private TableColumn<?, ?> tblProfesores_contrasenia;

    @FXML
    private TableColumn<?, ?> tblProfesores_correo;

    @FXML
    private TableColumn<?, ?> tblProfesores_id;

    @FXML
    private TableColumn<?, ?> tblProfesores_nombre;

    @FXML
    void actualizarAlumno(ActionEvent event) {

    }

    @FXML
    void actualizarAsignatura(ActionEvent event) {

    }

    @FXML
    void actualizarProfesor(ActionEvent event) {

    }

    @FXML
    void crearAlumno(ActionEvent event) {

    }

    @FXML
    void crearAsignatura(ActionEvent event) {

    }

    @FXML
    void crearProfesor(ActionEvent event) {

    }

    @FXML
    void eliminarAlumno(ActionEvent event) {

    }

    @FXML
    void eliminarAsignatura(ActionEvent event) {

    }

    @FXML
    void eliminarProfesor(ActionEvent event) {

    }

    @FXML
    void irLogin(ActionEvent event) {
        try {
            application.setScene(Utils.rutaLogin);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
