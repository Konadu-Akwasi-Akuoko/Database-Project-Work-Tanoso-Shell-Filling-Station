package com.example.tanosofillingstation;

import com.example.tanosofillingstation.mycustompackages.SharedData;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ConfirmWindowController {
    @FXML
    private Label LBConCusName;
    @FXML
    private Label LBConVehicleNum;
    @FXML
    private Label LBConTelNum;
    @FXML
    private Label LBConFuelType;
    @FXML
    private Label LBConProduct;
    @FXML
    private Label LBConLitresB;
    @FXML
    private Label LBConPriceP;
    @FXML
    private Button BTConCancel;
    @FXML
    private Button BTConConfirm;

    EmployeeWindowController employeeWindowController = new EmployeeWindowController();

    @FXML
    private void MouseEnteredOnLoad() {
            String[] sharedValues = SharedData.IncomingEmployeeSharedData();
            LBConCusName.setText(sharedValues[0]);
            LBConVehicleNum.setText(sharedValues[1]);
            LBConTelNum.setText(sharedValues[2]);
            LBConFuelType.setText(sharedValues[3]);
            LBConProduct.setText(sharedValues[4]);
            LBConLitresB.setText(sharedValues[5]);
            LBConPriceP.setText(sharedValues[6]);
    }

    @FXML
    private void CancelBTOnAction(){
        //Close the window when the cancel button in pressed.
        Stage stage = (Stage) BTConCancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void ConfirmBTOnAction(){
        System.out.println("Confirmation made.");
        //When you confirm all text on the EmployeeWindow must also be cleared.
        //SQL queries below.
    }

}
