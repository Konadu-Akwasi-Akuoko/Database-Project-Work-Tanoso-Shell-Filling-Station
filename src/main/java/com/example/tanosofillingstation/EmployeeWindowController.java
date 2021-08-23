package com.example.tanosofillingstation;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class EmployeeWindowController {
    @FXML
    private Button BTTypeGasoline;
    @FXML
    private Button BTTypeDiesel;
    @FXML
    private Button BTTypeFluids;
    @FXML
    private Button BTContinue;
    @FXML
    private Button BTCancel;
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
    private Label LBDate;
    @FXML
    private Label LBTime;
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
    @FXML
    private BorderPane BPane;

    private enum CurrentButton {
        Petrol,
        Diesel,
        Fluid
    }

    //The Enum which has been selected.
    CurrentButton currentButton;
    //A boolean to take care of when the time and date is initiated. And it will stay false when the time and date is initiated for the first time.
    private Boolean timeInitiated = true;

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

    //This function switches on and off the gridpanes of the products using the enums, always the appropriate gridpane is shown.
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
    private void TFLitresBoughtOnMouseClicked() {
        //Add a listener to the LitresBought textField, so that everytime there is a text change,
        // the text inside the CostPrice textField is also
        // updated to match the litres.
        TFLitresBought.textProperty().addListener(((observableValue, oldValue, newValue) -> {
            //Check if the Fuel type and product have a certain name, if so do the calculation
            // and change the text in the cost price text box.
            double price = 0;
            if (Objects.equals(LBTypeUpdate.getText(), "Gasoline") && Objects.equals(LBProductUpdate.getText(), "Petrol")) {
                price = Math.round((Double.parseDouble(TFLitresBought.getText()) * 5.195) * 100.0) / 100.0;
                TFCostPrice.setText("GH¢" + price);
            } else if (Objects.equals(LBTypeUpdate.getText(), "Gasoline") && Objects.equals(LBProductUpdate.getText(), "Super Petrol")) {
                price = Math.round((Double.parseDouble(TFLitresBought.getText()) * 5.265) * 100.0) / 100.0;
                TFCostPrice.setText("GH¢" + price);
            } else if (Objects.equals(LBTypeUpdate.getText(), "Gasoline") && Objects.equals(LBProductUpdate.getText(), "Engine Oil")) {
                price = Math.round((Double.parseDouble(TFLitresBought.getText()) * 22.5) * 100.0) / 100.0;
                TFCostPrice.setText("GH¢" + price);
            } else if (Objects.equals(LBTypeUpdate.getText(), "Diesel") && Objects.equals(LBProductUpdate.getText(), "Diesel")) {
                price = Math.round((Double.parseDouble(TFLitresBought.getText()) * 5.095) * 100.0) / 100.0;
                TFCostPrice.setText("GH¢" + price);
            } else if (Objects.equals(LBTypeUpdate.getText(), "Diesel") && Objects.equals(LBProductUpdate.getText(), "Engine Oil")) {
                price = Math.round((Double.parseDouble(TFLitresBought.getText()) * 22.5) * 100.0) / 100.0;
                TFCostPrice.setText("GH¢" + price);
            } else if (Objects.equals(LBTypeUpdate.getText(), "Fluids") && Objects.equals(LBProductUpdate.getText(), "Automatic Transmission Fluid D3")) {
                price = Math.round((Double.parseDouble(TFLitresBought.getText()) * 35) * 100.0) / 100.0;
                TFCostPrice.setText("GH¢" + price);
            } else if (Objects.equals(LBTypeUpdate.getText(), "Fluids") && Objects.equals(LBProductUpdate.getText(), "Brake Fluid Dot 3")) {
                price = Math.round((Double.parseDouble(TFLitresBought.getText()) * 23) * 100.0) / 100.0;
                TFCostPrice.setText("GH¢" + price);
            } else if (Objects.equals(LBTypeUpdate.getText(), "Fluids") && Objects.equals(LBProductUpdate.getText(), "Fuel Injector")) {
                price = Math.round((Double.parseDouble(TFLitresBought.getText()) * 15) * 100.0) / 100.0;
                TFCostPrice.setText("GH¢" + price);
            } else if (Objects.equals(LBTypeUpdate.getText(), "Fluids") && Objects.equals(LBProductUpdate.getText(), "Motor Flush")) {
                price = Math.round((Double.parseDouble(TFLitresBought.getText()) * 13) * 100.0) / 100.0;
                TFCostPrice.setText("GH¢" + price);
            }
        }));

        //The ContinueButton and CancelButton must show everytime there is a text change, otherwise they stay hidden.
        BTContinue.setVisible(true);
        BTCancel.setVisible(true);
    }

    @FXML
    private void TFCostPriceOnTextChanged() {
        TFCostPrice.textProperty().addListener(((observableValue, oldValue, newValue) -> {
            //Check if the Fuel type and product is of a certain name.
            // if so change the text in the cost price text box.
            double litresBought = 0;
            if (Objects.equals(LBTypeUpdate.getText(), "Gasoline") && Objects.equals(LBProductUpdate.getText(), "Petrol")) {
                litresBought = Math.round(Double.parseDouble(TFCostPrice.getText()) / 5.195) * 1000.0 / 1000.0;
                TFLitresBought.setText(litresBought + "litres");
            } else if (Objects.equals(LBTypeUpdate.getText(), "Gasoline") && Objects.equals(LBProductUpdate.getText(), "Super Petrol")) {
                litresBought = Math.round(Double.parseDouble(TFCostPrice.getText()) / 5.265) * 1000.0 / 1000.0;
                TFLitresBought.setText(litresBought + "litres");
            } else if (Objects.equals(LBTypeUpdate.getText(), "Gasoline") && Objects.equals(LBProductUpdate.getText(), "Engine Oil")) {
                litresBought = Math.round(Double.parseDouble(TFCostPrice.getText()) / 22.5) * 1000.0 / 1000.0;
                TFLitresBought.setText(litresBought + "litres");
            } else if (Objects.equals(LBTypeUpdate.getText(), "Diesel") && Objects.equals(LBProductUpdate.getText(), "Diesel")) {
                litresBought = Math.round(Double.parseDouble(TFCostPrice.getText()) / 5.095) * 1000.0 / 1000.0;
                TFLitresBought.setText(litresBought + "litres");
            } else if (Objects.equals(LBTypeUpdate.getText(), "Diesel") && Objects.equals(LBProductUpdate.getText(), "Engine Oil")) {
                litresBought = Math.round(Double.parseDouble(TFCostPrice.getText()) / 22.5) * 1000.0 / 1000.0;
                TFLitresBought.setText(litresBought + "litres");
            } else if (Objects.equals(LBTypeUpdate.getText(), "Fluids") && Objects.equals(LBProductUpdate.getText(), "Automatic Transmission Fluid D3")) {
                litresBought = Math.round(Double.parseDouble(TFCostPrice.getText()) / 35) * 1000.0 / 1000.0;
                TFLitresBought.setText(litresBought + "litres");
            } else if (Objects.equals(LBTypeUpdate.getText(), "Fluids") && Objects.equals(LBProductUpdate.getText(), "Brake Fluid Dot 3")) {
                litresBought = Math.round(Double.parseDouble(TFCostPrice.getText()) / 23) * 1000.0 / 1000.0;
                TFLitresBought.setText(litresBought + "litres");
            } else if (Objects.equals(LBTypeUpdate.getText(), "Fluids") && Objects.equals(LBProductUpdate.getText(), "Fuel Injector")) {
                litresBought = Math.round(Double.parseDouble(TFCostPrice.getText()) / 15) * 1000.0 / 1000.0;
                TFLitresBought.setText(litresBought + "litres");
            } else if (Objects.equals(LBTypeUpdate.getText(), "Fluids") && Objects.equals(LBProductUpdate.getText(), "Motor Flush")) {
                litresBought = Math.round(Double.parseDouble(TFCostPrice.getText()) / 13) * 1000.0 / 1000.0;
                TFLitresBought.setText(litresBought + "litres");
            }
        }));

        //The ContinueButton and CancelButton must show everytime there is a text change, otherwise there always stay hidden.
        BTContinue.setVisible(true);
        BTCancel.setVisible(true);
    }

    @FXML
    private void CancelButtonOnAction(ActionEvent event) {
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

        //The ContinueButton and CancelButton must hide everytime the cancel button in pressed.
        BTContinue.setVisible(false);
        BTCancel.setVisible(false);
        //Setting focus area to customerName textField when the cancel button is pressed.
        TFCustomerName.requestFocus();
    }

    //This function takes care of the time and date.
    @FXML
    private void BorderBoxOnMouseEntered() {
        //This function is called once, only at the start when the scene is changed.
        if(timeInitiated){
            TimeAndDateUpdate();
        }
    }

    //This function updates and controls the time and date on the Employee Window.
    public void TimeAndDateUpdate() {
        timeInitiated = false;
        //When the employee window is called, set the day.
        //The day is set on a label that will house the date.
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E dd-MM-yyyy");
        LBDate.setText(simpleDateFormat.format(date));
        //Set the time, and it will update itself every second with the help of timer and timerTask.
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //Platform.runLater is used because apparently Timer does not work on javaFx threads, so the
                // function is used, so that Timer which is a java thread can be added to the javafx thread.
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Date date2 = new Date();
                        SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("hh:mm:ss");
                        LBTime.setText(simpleTimeFormat.format(date2));
                    }
                });
            }
        }, 1000, 1000);

        //The timer needs to be stopped when the stage is coming to close.
        // Because the Timer is a java thread and not a javafx thread, it needs to be stooped, otherwise when the scene is closed
        // using the close button, the timer thread will continue running.
        Stage stage = (Stage) BPane.getScene().getWindow();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                timer.cancel();
            }
        });
    }
}