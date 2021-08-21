package com.example.tanosofillingstation;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.Objects;

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
    @FXML
    private TextField TFLitresBought;
    @FXML
    private TextField TFCostPrice;
    @FXML
    private TextField TFCustomerName;
    @FXML
    private TextField TFVehicleNumber;
    @FXML
    private TextField TFTelNumber;

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

    //This function switches on and off the gridpanes using the buttons, always the appropriate gridpane is shown.
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

    @FXML
    private void PetrolProdButtonOnAction() {
        LBTypeUpdate.setText("Gasoline");
        LBProductUpdate.setText("Petrol");
        LBPricePerLitreUpdate.setText("GH¢5.195");
    }

    @FXML
    private void SuperPetrolProdButtonOnAction() {
        LBTypeUpdate.setText("Gasoline");
        LBProductUpdate.setText("Super Petrol");
        LBPricePerLitreUpdate.setText("GH¢5.265");
    }

    @FXML
    private void PetrolEngineOilProdButtonOnAction() {
        LBTypeUpdate.setText("Gasoline");
        LBProductUpdate.setText("Engine Oil");
        LBPricePerLitreUpdate.setText("GH¢22.5");
    }

    @FXML
    private void DieselProdButtonOnAction() {
        LBTypeUpdate.setText("Diesel");
        LBProductUpdate.setText("Diesel");
        LBPricePerLitreUpdate.setText("GH¢5.095");
    }

    @FXML
    private void DieselEngineOilProdButtonOnAction() {
        LBTypeUpdate.setText("Diesel");
        LBProductUpdate.setText("Engine Oil");
        LBPricePerLitreUpdate.setText("GH¢22.5");
    }

    @FXML
    private void ATFProdButtonOnAction() {
        LBTypeUpdate.setText("Fluids");
        LBProductUpdate.setText("Automatic Transmission Fluid D3");
        LBPricePerLitreUpdate.setText("GH¢35");
    }

    @FXML
    private void MotorFlushProdButtonOnAction() {
        LBTypeUpdate.setText("Fluids");
        LBProductUpdate.setText("Motor Flush");
        LBPricePerLitreUpdate.setText("GH¢13");
    }

    @FXML
    private void BrakeFluidProdButtonOnAction() {
        LBTypeUpdate.setText("Fluids");
        LBProductUpdate.setText("Brake Fluid Dot 3");
        LBPricePerLitreUpdate.setText("GH¢23");
    }

    @FXML
    private void FuelInjectorProdButtonOnAction() {
        LBTypeUpdate.setText("Fluids");
        LBProductUpdate.setText("Fuel Injector");
        LBPricePerLitreUpdate.setText("GH¢15");
    }

    @FXML
    private void LitresBoughtOnInputTextChanges() {
        //Check if the Fuel type and product is of a certain type if so change the text in the cost price text box.
        //SQL statements must be here.
        double price = 0;
        if (Objects.equals(LBTypeUpdate.getText(), "Gasoline") && Objects.equals(LBProductUpdate.getText(), "Petrol")) {
            price = Math.round((Double.parseDouble(TFLitresBought.getText()) * 5.195)*100.0)/100.0;
            TFCostPrice.setText("GH¢"+price);
        }
        else if(Objects.equals(LBTypeUpdate.getText(), "Gasoline") && Objects.equals(LBProductUpdate.getText(), "Super Petrol")){
            price = Math.round((Double.parseDouble(TFLitresBought.getText()) * 5.265)*100.0)/100.0;
            TFCostPrice.setText("GH¢"+price);
        }
        else if(Objects.equals(LBTypeUpdate.getText(), "Gasoline") && Objects.equals(LBProductUpdate.getText(), "Engine Oil")){
            price = Math.round((Double.parseDouble(TFLitresBought.getText())* 22.5)*100.0)/100.0;
            TFCostPrice.setText("GH¢"+price);
        }
        else if(Objects.equals(LBTypeUpdate.getText(), "Diesel") && Objects.equals(LBProductUpdate.getText(), "Diesel")){
            price = Math.round((Double.parseDouble(TFLitresBought.getText())* 5.095)*100.0)/100.0;
            TFCostPrice.setText("GH¢"+price);
        }
        else if(Objects.equals(LBTypeUpdate.getText(), "Diesel") && Objects.equals(LBProductUpdate.getText(), "Engine Oil")){
            price = Math.round((Double.parseDouble(TFLitresBought.getText())* 22.5)*100.0)/100.0;
            TFCostPrice.setText("GH¢"+price);
        }
        else if(Objects.equals(LBTypeUpdate.getText(), "Fluids") && Objects.equals(LBProductUpdate.getText(), "Automatic Transmission Fluid D3")){
            price = Math.round((Double.parseDouble(TFLitresBought.getText())* 35)*100.0)/100.0;
            TFCostPrice.setText("GH¢"+price);
        }
        else if(Objects.equals(LBTypeUpdate.getText(), "Fluids") && Objects.equals(LBProductUpdate.getText(), "Brake Fluid Dot 3")){
            price = Math.round((Double.parseDouble(TFLitresBought.getText())* 23)*100.0)/100.0;
            TFCostPrice.setText("GH¢"+price);
        }
        else if(Objects.equals(LBTypeUpdate.getText(), "Fluids") && Objects.equals(LBProductUpdate.getText(), "Fuel Injector")){
            price = Math.round((Double.parseDouble(TFLitresBought.getText())* 15)*100.0)/100.0;
            TFCostPrice.setText("GH¢"+price);
        }
        else if(Objects.equals(LBTypeUpdate.getText(), "Fluids") && Objects.equals(LBProductUpdate.getText(), "Motor Flush")){
            price = Math.round((Double.parseDouble(TFLitresBought.getText())* 13)*100.0)/100.0;
            TFCostPrice.setText("GH¢"+price);
        }
    }

    @FXML
    private void CancelButtonOnAction(ActionEvent event){
        //When the cancel button is pressed all text fields needs to be cleared.
        TFCustomerName.setText("");
        TFCustomerName.setPromptText("Name");
        TFVehicleNumber.setText("");
        TFVehicleNumber.setPromptText("Vehicle number");
        TFTelNumber.setText("");
        TFTelNumber.setPromptText("Telephone number");

        TFLitresBought.setText("");
        TFLitresBought.setPromptText("Litres");
        TFCostPrice.setText("");
        TFCostPrice.setPromptText("Price");
    }
}
