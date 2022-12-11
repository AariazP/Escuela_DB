package org.example.application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.model.Controller;
import org.example.service.DatabaseConection;

public class Application extends javafx.application.Application {

    private DatabaseConection connection;


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        connection = DatabaseConection.getInstance();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
        Controller controller = loader.getController();
        controller.setApplication(this);
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }


    


}