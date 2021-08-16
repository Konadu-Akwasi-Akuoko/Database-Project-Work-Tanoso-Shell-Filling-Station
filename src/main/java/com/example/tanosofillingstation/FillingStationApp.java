package com.example.tanosofillingstation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FillingStationApp extends Application {
    public Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FillingStationApp.class.getResource("LoginWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Tanoso Shell Filling Station");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}