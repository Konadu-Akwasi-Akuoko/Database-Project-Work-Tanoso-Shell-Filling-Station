package com.example.tanosofillingstation;

import com.example.tanosofillingstation.mycustompackages.DBQueries;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class AdminWindowController {
    @FXML
    private Label LBDate;
    @FXML
    private Label LBTime;
    @FXML
    private Label LBSelectedDate;

    //Date labels.
    @FXML
    private Label LBShowDate0;
    @FXML
    private Label LBShowDate1;
    @FXML
    private Label LBShowDate2;
    @FXML
    private Label LBShowDate3;
    @FXML
    private Label LBShowDate4;
    @FXML
    private Label LBShowDate5;
    @FXML
    private Label LBShowDate6;
    @FXML
    private Label LBShowDate7;
    @FXML
    private Label LBShowDate8;
    @FXML
    private Label LBShowDate9;

    //EmpName Labels.
    @FXML
    private Label LBShowEmpName0;
    @FXML
    private Label LBShowEmpName1;
    @FXML
    private Label LBShowEmpName2;
    @FXML
    private Label LBShowEmpName3;
    @FXML
    private Label LBShowEmpName4;
    @FXML
    private Label LBShowEmpName5;
    @FXML
    private Label LBShowEmpName6;
    @FXML
    private Label LBShowEmpName7;
    @FXML
    private Label LBShowEmpName8;
    @FXML
    private Label LBShowEmpName9;

    //VehicleNum labels.
    @FXML
    private Label LBVehicleNum0;
    @FXML
    private Label LBVehicleNum1;
    @FXML
    private Label LBVehicleNum2;
    @FXML
    private Label LBVehicleNum3;
    @FXML
    private Label LBVehicleNum4;
    @FXML
    private Label LBVehicleNum5;
    @FXML
    private Label LBVehicleNum6;
    @FXML
    private Label LBVehicleNum7;
    @FXML
    private Label LBVehicleNum8;
    @FXML
    private Label LBVehicleNum9;

    //CusName Labels.
    @FXML
    private Label LBCusName0;
    @FXML
    private Label LBCusName1;
    @FXML
    private Label LBCusName2;
    @FXML
    private Label LBCusName3;
    @FXML
    private Label LBCusName4;
    @FXML
    private Label LBCusName5;
    @FXML
    private Label LBCusName6;
    @FXML
    private Label LBCusName7;
    @FXML
    private Label LBCusName8;
    @FXML
    private Label LBCusName9;
    private Label[] CusNameLabelArray = {LBCusName0, LBCusName1, LBCusName2, LBCusName3, LBCusName3, LBCusName4,
            LBCusName5, LBCusName6, LBCusName7, LBCusName8, LBCusName9};

    //OilProductID labels
    @FXML
    private Label LBoilProdID0;
    @FXML
    private Label LBoilProdID1;
    @FXML
    private Label LBoilProdID2;
    @FXML
    private Label LBoilProdID3;
    @FXML
    private Label LBoilProdID4;
    @FXML
    private Label LBoilProdID5;
    @FXML
    private Label LBoilProdID6;
    @FXML
    private Label LBoilProdID7;
    @FXML
    private Label LBoilProdID8;
    @FXML
    private Label LBoilProdID9;
    private Label[] OilProductLabelArray = {LBoilProdID0, LBoilProdID1, LBoilProdID2, LBoilProdID3, LBoilProdID4,
            LBoilProdID5, LBoilProdID6, LBoilProdID7, LBoilProdID8, LBoilProdID9};

    //Price labels
    @FXML
    private Label LBPrice0;
    @FXML
    private Label LBPrice1;
    @FXML
    private Label LBPrice2;
    @FXML
    private Label LBPrice3;
    @FXML
    private Label LBPrice4;
    @FXML
    private Label LBPrice5;
    @FXML
    private Label LBPrice6;
    @FXML
    private Label LBPrice7;
    @FXML
    private Label LBPrice8;
    @FXML
    private Label LBPrice9;
    private Label[] PriceLabelArray = {LBPrice0, LBPrice1, LBPrice2, LBPrice3, LBPrice4,
            LBPrice5, LBPrice6, LBPrice7, LBPrice8, LBPrice9};

    //LitresBought label
    @FXML
    private Label LBLitresB0;
    @FXML
    private Label LBLitresB1;
    @FXML
    private Label LBLitresB2;
    @FXML
    private Label LBLitresB3;
    @FXML
    private Label LBLitresB4;
    @FXML
    private Label LBLitresB5;
    @FXML
    private Label LBLitresB6;
    @FXML
    private Label LBLitresB7;
    @FXML
    private Label LBLitresB8;
    @FXML
    private Label LBLitresB9;
    private Label[] LitresBLabelArray = {LBLitresB0, LBLitresB1, LBLitresB2, LBLitresB3, LBLitresB4,
            LBLitresB5, LBLitresB6, LBLitresB7, LBLitresB8, LBLitresB9};

    @FXML
    private Label usrLabel;

    //Boolean to check if the time has started.
    private boolean isTimeInitiated = false;

    //
    DBQueries dbQueries = new DBQueries();

    @FXML
    private void OnMouseEnteredOnLoad() {
        //DateLabelArray[0].setText("Hi you all");
        if (!isTimeInitiated) {
            TimeAndDate();
        }
    }

    //This function controls the time and date.
    private void TimeAndDate() {
        //When the admin window is called, set the day.
        //The day is set on a label that will house the date.
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E dd-MM-yyyy");
        LBDate.setText(simpleDateFormat.format(date));
        LBSelectedDate.setText(LBDate.getText());

        //Set the time, and it will update itself every second with the help of timer and timerTask.
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //Platform.runLater is used because apparently Timer does not work on javaFx threads, so the
                // function is used, so that Timer which is a java thread can be added to the javafx thread.
                Platform.runLater(() -> {
                    Date date2 = new Date();
                    SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("hh:mm:ss aa");
                    LBTime.setText(simpleTimeFormat.format(date2));
                });
            }
        }, 1000, 1000);

        isTimeInitiated = true;
        UpdateRows();

        //The timer needs to be stopped when the stage is coming to close.
        // Because the Timer is a java thread and not a javafx thread, it needs to be stooped, otherwise when the scene is closed
        // using the close button, the timer thread will continue running.
        Stage stage = (Stage) usrLabel.getScene().getWindow();
        stage.setOnCloseRequest(windowEvent -> timer.cancel());
    }

    private void UpdateRows() {
        //Updating rows for dates.
        //The set count querry needs to be called
        dbQueries.SetCount(LBSelectedDate.getText());
        Label[] DateLabelArray = {LBShowDate0, LBShowDate1, LBShowDate2, LBShowDate3, LBShowDate4,
                LBShowDate5, LBShowDate6, LBShowDate7, LBShowDate8, LBShowDate9};
        String[] DateValuesArray = dbQueries.GetDataDate(LBSelectedDate.getText());
        for (int i = 0; i < DBQueries.numberOfRows; i++) {
            DateLabelArray[i].setText(DateValuesArray[i]);
        }

        //Updating rows for emp_Initials
        Label[] EmpNameLabelArray = {LBShowEmpName0, LBShowEmpName1, LBShowEmpName2, LBShowEmpName3, LBShowEmpName4,
                LBShowEmpName5, LBShowEmpName6, LBShowEmpName7, LBShowEmpName8, LBShowEmpName9};
        String[] EmpValuesArray = dbQueries.GetDataEmpIni(LBSelectedDate.getText());
        for (int i = 0; i < DBQueries.numberOfRows; i++) {
            EmpNameLabelArray[i].setText(EmpValuesArray[i]);
        }

        //Updating rows for vehicle Number
        Label[] VehicleNumLabelArray = {LBVehicleNum0, LBVehicleNum1, LBVehicleNum2, LBVehicleNum3, LBVehicleNum4, LBVehicleNum5,
                LBVehicleNum6, LBVehicleNum7, LBVehicleNum8, LBVehicleNum9};
        String[] VehicleNumArray = dbQueries.GetDataVehicleNum(LBSelectedDate.getText());
        for (int i = 0; i < DBQueries.numberOfRows; i++) {
            VehicleNumLabelArray[i].setText(VehicleNumArray[i]);
        }
    }
}
