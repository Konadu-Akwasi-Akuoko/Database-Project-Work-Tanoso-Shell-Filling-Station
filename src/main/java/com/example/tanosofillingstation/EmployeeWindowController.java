package com.example.tanosofillingstation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class EmployeeWindowController {
    @FXML
    private Button BTTypeGasoline;
    @FXML
    private Button BTTypeDiesel;
    @FXML
    private Button BTTypeFluids;
    @FXML
    private GridPane PetrolGridPane;
    @FXML
    private GridPane DieselGridPane;
    @FXML
    private GridPane FluidGridPane;
    @FXML
    private Label LBTypeUpdate;
    @FXML
    private Label LBProductUpdate;
    @FXML
    private Label LBPricePerLitreUpdate;

    private enum CurrentButton {
        Petrol,
        Diesel,
        Fluid
    }

    CurrentButton currentButton;

    @FXML
    private void GasolineTypeButtonOnAction(ActionEvent event) {
        //Change the enum current variable to petrol and pass it to the ChangeProduct function.
        currentButton = CurrentButton.Petrol;
        ChangeProduct(currentButton);
        //When clicked, cast a button to use an action event, then use the getText to find the name of the string.
        Button bt = (Button) event.getSource();
        System.out.println(bt.getText());
    }

    @FXML
    private void DieselTypeButtonOnAction(ActionEvent event) {
        //Change the enum current variable to diesel and pass it to the ChangeProduct function.
        currentButton = CurrentButton.Diesel;
        ChangeProduct(currentButton);
    }

    @FXML
    private void FluidTypeButtonOnAction(ActionEvent event) {
        //Change the enum current variable to fluid and pass it to the ChangeProduct function.
        currentButton = CurrentButton.Fluid;
        ChangeProduct(currentButton);
    }

    //This function switches on and off the gridpanes, always the appropriate gridpane is shown.
    private void ChangeProduct(CurrentButton currentButton) {
        switch (currentButton) {
            case Petrol:
                PetrolGridPane.setVisible(true);
                DieselGridPane.setVisible(false);
                FluidGridPane.setVisible(false);
                break;
            case Diesel:
                PetrolGridPane.setVisible(false);
                DieselGridPane.setVisible(true);
                FluidGridPane.setVisible(false);
                break;
            case Fluid:
                PetrolGridPane.setVisible(false);
                DieselGridPane.setVisible(false);
                FluidGridPane.setVisible(true);
        }
    }

}
