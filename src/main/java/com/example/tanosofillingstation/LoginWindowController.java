package com.example.tanosofillingstation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.example.tanosofillingstation.mycustompackages.MyCustomPackage;

import java.io.IOException;
import java.util.Objects;

public class LoginWindowController {
    @FXML
    private Label LBInvalidLogIn;
    @FXML
    private Button BTCancelButton;
    @FXML
    private TextField TFUserName;
    @FXML
    private PasswordField PSPassword;
    @FXML
    private Button BTLogIn;

    @FXML
    private void LogInButtonAction(ActionEvent event) throws IOException {
        //If the credentials are false display "Invalid Login"
        //Check password and username if it falls in user, send user to user page, otherwise send admin to admin page.
        if (Objects.equals(TFUserName.getText(), "") || Objects.equals(PSPassword.getText(), "")) {
            LBInvalidLogIn.setVisible(true);
        }
        else
            MyCustomPackage.ChangeScene("EmployeeWindow.fxml","Shell Filling Station - Employee", BTLogIn);
    }

    @FXML
    //Go back to the last scene, thus the SelectUser scene.
    private void CancelButtonAction(ActionEvent event) throws IOException {
        MyCustomPackage.CloseStage(BTCancelButton);
    }
}