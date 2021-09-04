package com.example.tanosofillingstation;

import com.example.tanosofillingstation.mycustompackages.DBQueries;
import com.example.tanosofillingstation.mycustompackages.SharedData;
import com.example.tanosofillingstation.mycustompackages.WindowManipulators;
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

    DBQueries dbQueries = new DBQueries();
    String cus_Name;
    String cus_vNum;
    int cus_tNum;
    float cus_pPaid;
    float cus_lBought;
    static int oilP_id;
    String emp_Ini;
    String cus_Date;
    //This boolean will make sure the MouseEnteredOnLoad run only once.
    boolean hasRun = false;

    @FXML
    private void MouseEnteredOnLoad() {
        if (!hasRun) {
            //This function must run only once, so it's better to put it inside an if block.
            String[] sharedValues = SharedData.IncomingEmployeeSharedData();
            LBConCusName.setText(sharedValues[0]);
            LBConVehicleNum.setText(sharedValues[1]);
            LBConTelNum.setText(sharedValues[2]);
            LBConFuelType.setText(sharedValues[3]);
            LBConProduct.setText(sharedValues[4]);
            LBConLitresB.setText(sharedValues[5]);
            LBConPriceP.setText(sharedValues[6]);

            //Setting the values that will be inserted into the sql table.
            try {
                cus_Name = sharedValues[0];
                cus_vNum = sharedValues[1];
                cus_tNum = Integer.parseInt(sharedValues[2]);
                cus_pPaid = Float.parseFloat(sharedValues[6]);
                cus_lBought = Float.parseFloat(sharedValues[5]);
                oilP_id = Integer.parseInt(sharedValues[7]);
                emp_Ini = sharedValues[8];
                cus_Date = sharedValues[9];
            } catch (NumberFormatException e) {
                System.out.println("Number format exception on MouseEntered: " + e + e.getMessage());
            }
            hasRun = true;
        }
    }

    @FXML
    private void CancelBTOnAction() {
        //Close the window when the cancel button in pressed.
        Stage stage = (Stage) BTConCancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void ConfirmBTOnAction() {
        //When you confirm all text on the EmployeeWindow must also be cleared.
        //SQL queries below.
        dbQueries.DBInsertValuesIntoEmployeeTB(cus_Name, cus_vNum, cus_tNum, cus_pPaid, cus_lBought, oilP_id, emp_Ini, cus_Date);
        WindowManipulators.CloseStage(BTConConfirm);
    }

}
