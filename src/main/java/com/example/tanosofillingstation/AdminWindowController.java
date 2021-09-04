package com.example.tanosofillingstation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class AdminWindowController {

    @FXML
    private static GridPane GPDataInDB;
    static  int rowIndex = 1;

    @FXML
    private void AddRowToGP(){
        GPDataInDB.add(new Button(), 0, rowIndex);
    }

}
