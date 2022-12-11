package org.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lombok.Getter;
import lombok.Setter;
import org.example.model.Controller;
import org.example.service.DatabaseConection;
import java.sql.SQLException;

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
        try {
            if (connection.iniciarSesion("SELECT * FROM administradores WHERE nombre='" + txtUsuario.getText() + "' AND telefono='" + txtContrasenia.getText() + "'")) {

            } else {
                System.out.println("Usuario o contraseña incorrectos");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
