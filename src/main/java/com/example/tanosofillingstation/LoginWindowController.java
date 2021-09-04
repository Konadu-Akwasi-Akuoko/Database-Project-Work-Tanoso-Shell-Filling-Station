package com.example.tanosofillingstation;

import com.example.tanosofillingstation.mycustompackages.DBQueries;
import com.example.tanosofillingstation.mycustompackages.WindowManipulators;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

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
    DBQueries dbQueries = new DBQueries();

    @FXML
    private void LogInButtonAction(ActionEvent event) throws IOException {
        //If the credentials are false display "Invalid Login"
        //Check password and username if it falls in user, send user to user page, otherwise send admin to admin page.
        boolean[] authenticate_authorize;
        authenticate_authorize = dbQueries.AuthenticationAndAuthorization(TFUserName.getText(), Integer.parseInt(PSPassword.getText()));
        if (authenticate_authorize[0]) {
            //If authentication is true, then authorize the user. True means the user is an admin, otherwise the user is an employee.
            if (authenticate_authorize[1]) {
                WindowManipulators.ChangeScene(/*"AdminWindow.fxml", "Tanoso Filling Station - Administrator", BTLogIn*/
                        "EmployeeWindow.fxml", "Tanoso Filling Station - Employee", BTLogIn);
            } else {
                WindowManipulators.ChangeScene("EmployeeWindow.fxml", "Tanoso Filling Station - Employee", BTLogIn);
            }
        } else {
            LBInvalidLogIn.setVisible(true);
        }

    }

    @FXML
    //Go back to the last scene, thus the SelectUser scene.
    private void CancelButtonAction(ActionEvent event) throws IOException {
        WindowManipulators.CloseStage(BTCancelButton);
    }
}