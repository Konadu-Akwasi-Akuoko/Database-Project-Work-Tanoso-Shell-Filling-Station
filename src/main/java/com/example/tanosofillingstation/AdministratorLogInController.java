package com.example.tanosofillingstation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.example.tanosofillingstation.mycustompackages.MyCustomPackage;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AdministratorLogInController {
    @FXML
    private Label LBInvalidLogIn;
    @FXML
    private Button BTCancelButton;
    @FXML
    private TextField TFUserName;
    @FXML
    private PasswordField PSPassword;

    @FXML
    private void LogInButtonAction(ActionEvent event) {
        //If the credentials are false display "Invalid Login"
        if (Objects.equals(TFUserName.getText(), "") || Objects.equals(PSPassword.getText(), "")) {
            LBInvalidLogIn.setVisible(true);
        }
    }

    @FXML
    //Go back to the last scene, thus the SelectUser scene.
    private void CancelButtonAction(ActionEvent event) throws IOException {
        MyCustomPackage.ChangeScene("SelectUser.fxml", "Tanoso Shel Filling Station");
        //After showing the new scene, the previous stage/window needs to be closed, through one of its buttons.
        Node node = (Node) event.getSource();
        Stage stageToClose = (Stage) node.getScene().getWindow();
        stageToClose.close();

    }
}