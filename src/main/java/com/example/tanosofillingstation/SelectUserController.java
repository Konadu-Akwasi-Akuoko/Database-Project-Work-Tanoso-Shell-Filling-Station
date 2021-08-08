package com.example.tanosofillingstation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import com.example.tanosofillingstation.mycustompackages.MyCustomPackage;
import javafx.stage.Stage;

import java.io.IOException;

public class SelectUserController {
    @FXML
    private Button BTAdministrator;
    @FXML
    private Button BTEmployee;

    @FXML
    //When the administrator button is pressed we instantiate a new window for the Administrator for logging in.
    public void AdministratorButtonOnAction(ActionEvent event) throws IOException {
        MyCustomPackage.ChangeScene("AdministratorLogin.fxml", "Administrator");
        //After showing the new scene, the previous stage/window needs to be closed, through one of its buttons.
        Node node = (Node) event.getSource();
        Stage stageToClose = (Stage) node.getScene().getWindow();
        stageToClose.close();
    }

    @FXML
    //When the administrator button is pressed we instantiate a new window for the Employee for logging in.
    public void EmployeeButtonOnAction(ActionEvent event) throws IOException {
        MyCustomPackage.ChangeScene("EmployeeLogin.fxml", "Employee");
        //After showing the new scene, the previous stage/window needs to be closed, through one of its buttons.
        Node node = (Node) event.getSource();
        Stage stageToClose = (Stage) node.getScene().getWindow();
        stageToClose.close();
    }

}
