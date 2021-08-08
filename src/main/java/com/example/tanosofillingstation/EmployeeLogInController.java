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

public class EmployeeLogInController {
    @FXML
    private Button BTLogIn;
    @FXML
    private Button BTCancel;
    @FXML
    private TextField TFUserName;
    @FXML
    private PasswordField PSPassword;
    @FXML
    private Label LBInvalidLogIn;

    @FXML
    public void LogInButtonOnAction(ActionEvent event) {
        //If the credentials are false display "Invalid Login"
        if (Objects.equals(TFUserName.getText(), "") || Objects.equals(PSPassword.getText(), "")) {
            LBInvalidLogIn.setVisible(true);
        }
    }

    @FXML
    //If the cancel button is clicked the old window must come up, thus the SelectUser.fxml window.
    public void CancelButtonOnAction(ActionEvent event) throws IOException {
        MyCustomPackage.ChangeScene("SelectUser.fxml", "Tanoso Shell Filling Station");
        //After showing the new scene, the previous stage/window needs to be closed, through one of its buttons.
        Stage stageToClose;
        stageToClose = (Stage) BTCancel.getScene().getWindow();
        try {
            stageToClose.close();
        }
        catch (NullPointerException exception){
            System.out.println(exception);
        }
    }
}
