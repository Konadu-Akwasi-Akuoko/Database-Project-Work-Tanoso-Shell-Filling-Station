package com.example.tanosofillingstation.mycustompackages;

import com.example.tanosofillingstation.FillingStationApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MyCustomPackage {
    private static final Stage stage = new Stage();

    public static void ChangeScene(String fxmlName /*Location of fxml file*/, String
            stageTitle, Button ButtonOfStageToClose) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FillingStationApp.class.getResource(fxmlName));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle(stageTitle);
        stage.setScene(scene);
        stage.show();
        //After showing the new scene, the previous stage/window needs to be closed, through one of its buttons.
        //The code below is syntactically correct, but it gives a null pointer exception, that is why we are using try and catch.
        Stage stageToClose = (Stage) ButtonOfStageToClose.getScene().getWindow();
        stageToClose.close();
    }

    public static void CloseStage(Button ButtonOfStageToClose) {
        Stage stageToClose = (Stage) ButtonOfStageToClose.getScene().getWindow();
        stageToClose.close();
    }
}
