package com.example.tanosofillingstation;

import com.example.tanosofillingstation.mycustompackages.CustomFunctionsAndSql;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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

    //package containing sql statements.
    CustomFunctionsAndSql customFunctionsAndSql = new CustomFunctionsAndSql();

    @FXML
    private void LogInButtonAction(ActionEvent event) throws IOException {
        //If the credentials are false display "Invalid Login"
        //Check password and username if it falls in user, send user to user page, otherwise send admin to admin page.
        if (customFunctionsAndSql.CheckUserNameAndPassword(TFUserName.getText(), Integer.parseInt(PSPassword.getText()))) {
            CustomFunctionsAndSql.ChangeScene("EmployeeWindow.fxml", "Tanoso Filling Station - Employee", BTLogIn);
        } else {
            LBInvalidLogIn.setVisible(true);
        }

    }

    @FXML
    //Go back to the last scene, thus the SelectUser scene.
    private void CancelButtonAction(ActionEvent event) throws IOException {
        CustomFunctionsAndSql.CloseStage(BTCancelButton);
    }

    private void CheckUserNameAndPassword() {

    }
}