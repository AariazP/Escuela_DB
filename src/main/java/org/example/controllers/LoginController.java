package org.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lombok.Getter;
import lombok.Setter;
import org.example.Utilities.Utils;
import org.example.model.Controller;
import org.example.service.DatabaseConection;

@Getter
@Setter
public class LoginController extends Controller {

    private final DatabaseConection connection = DatabaseConection.getInstance();
    @FXML
    private TextField txtContrasenia;

    @FXML
    private TextField txtUsuario;

    @FXML
    void logIn(ActionEvent ignoredEvent) {
        /**
         * Importante:
         * si se ingresa dentro de algún campo de texto este mensaje
         * se producirá un sql injection
         * ' OR nombre='Alejandro' -- con un espacio al final
         * esto es un ejemplo de sql injection suponiendo que el usuario Alejandro existe
         */
        try {
            if (connection.iniciarSesion("SELECT * FROM administradores WHERE nombre='" + txtUsuario.getText() + "' AND telefono='" + txtContrasenia.getText() + "'")) {
                application.setScene(Utils.rutaAdministrador);
            } else {
                System.out.println("Usuario o contraseña incorrectos");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
