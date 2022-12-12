package org.example.application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.model.Controller;
import org.example.service.DatabaseConection;

public class Application extends javafx.application.Application {

    private DatabaseConection connection;
    private Stage stage;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        connection = DatabaseConection.getInstance();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
        stage.setScene(new Scene(loader.load()));
        Controller controller = loader.getController();
        controller.setApplication(this);
        stage.show();
    }

    public void setScene(String ruta) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(ruta));
        stage.setScene(new Scene(loader.load()));
        Controller controller = loader.getController();
        controller.setApplication(this);
        stage.show();
    }

}