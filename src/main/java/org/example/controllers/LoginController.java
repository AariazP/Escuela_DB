package org.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
         * en el user: ' OR '1'='1
         * en el password: ' OR '1'='1
         * esto es un ejemplo de sql injection suponiendo que el usuario Alejandro existe
         */
        try {
            if (connection.iniciarSesion("SELECT * FROM administradores WHERE user='" + txtUsuario.getText() + "' AND password='" + txtContrasenia.getText() + "'")) {

                if(txtUsuario.getText().contains("OR")){
                    alertMessage("Haz hackeado la base de datos, felicidades");
                }
                application.setScene(Utils.rutaAdministrador);
            } else {
                alertMessage("Usuario o contraseña incorrectos");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    void alertMessage(String message){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();

    }

}
