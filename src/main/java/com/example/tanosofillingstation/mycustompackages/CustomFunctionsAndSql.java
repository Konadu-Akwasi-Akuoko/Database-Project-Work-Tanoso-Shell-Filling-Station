package com.example.tanosofillingstation.mycustompackages;

import com.example.tanosofillingstation.FillingStationApp;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomFunctionsAndSql {
    private static final Stage stage = new Stage();

    public static void ChangeScene(String fxmlName /*Location of fxml file*/, String
            stageTitle, Button ButtonOfStageToClose) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FillingStationApp.class.getResource(fxmlName));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle(stageTitle);
        stage.setScene(scene);
        stage.show();
        //After showing the new scene, the previous stage/window needs to be closed, through one of its buttons.
        //The code below is syntactically correct, but it gives a null pointer exception, that is why we are using try and catch.
        Stage stageToClose = (Stage) ButtonOfStageToClose.getScene().getWindow();
        stageToClose.close();
    }

    public static void CloseStage(Button ButtonOfStageToClose) {
        Stage stageToClose = (Stage) ButtonOfStageToClose.getScene().getWindow();
        stageToClose.close();
    }

    //SQL STATEMENTS AND QUERIES.
    Connection connection = null;
    PreparedStatement preparedSQLStatement;
    ResultSet resultSet;
    boolean passwordAndUserNameExits;

    public boolean CheckUserNameAndPassword(String username, int id) {
        //Try and close all connections if there is any.
        try {
            if (!connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
            System.out.println("Exception in connection.isClosed is " + e + "\n" + e.getMessage());
        }

        //Connect to a database and execute the query.
        try {
            //Connecting to a database using a connection.
            connection = DriverManager.getConnection("jdbc:mysql://localhost/Tanoso_Filling_Station", "root", "");
            System.out.println("Connected successfully");
            preparedSQLStatement = connection.prepareStatement("SELECT emp_id, emp_Name FROM EMPLOYEE WHERE emp_id = ? AND emp_Name = ?");
            preparedSQLStatement.setInt(1, id);
            preparedSQLStatement.setString(2, username);
            resultSet = preparedSQLStatement.executeQuery();
            //If the result is true, make this function return true, by setting passwordAndUserNameExits to true, if false do otherwise.
            if (resultSet.next()) {
                //Where 1 is the index of the column we are selecting from.
                int emp_id = resultSet.getInt(1);
                String emp_Name = resultSet.getString(2);
                System.out.println("The emp_id is:" + emp_id + " " + emp_Name);
                passwordAndUserNameExits = true;
            } else {
                System.out.println("Nothing found.");
                passwordAndUserNameExits = false;
            }
        } catch (Exception e) {
            System.out.println("Connection not successful.");
            System.out.println("The exception in the catch block is " + e + "\n" + e.getMessage());
        } finally {
            try {
                System.out.println("Closing connections.");
                resultSet.close();
                preparedSQLStatement.close();
                connection.close();
            } catch (Exception e) {
                System.out.println("The result in the final block is " + e + "\n" + e.getMessage());
            }
        }
        return passwordAndUserNameExits;
    }
}
