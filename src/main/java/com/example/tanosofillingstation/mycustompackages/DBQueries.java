package com.example.tanosofillingstation.mycustompackages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class DBQueries {
    //SQL STATEMENTS AND QUERIES.
    Connection connection = null;
    PreparedStatement preparedSQLStatement;
    ResultSet resultSet;
    boolean[] Authenticate_Authorize = new boolean[2];

    //Employee initials must be used on the Employee window, therefore we need to store it as a static variable.
    public static String emp_Ini;

    private Connection ConnectDB(Connection conn) {

        //Try and close all connections if there is any, before connecting.
        try {
            if (!conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e) {
            System.out.println("No connections hanging, proceed to connect.");
        }

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/Tanoso_Filling_Station", "root", "");
        } catch (Exception e) {
            System.out.println("Database not connected. Due to:" + e + " - " + e.getMessage());
        }
        return conn;
    }

    public boolean[] AuthenticationAndAuthorization(String username, int password) {
        //Connect to a database and execute the query.
        try {
            //Connecting to a database using a connection.
            connection = ConnectDB(connection);
            preparedSQLStatement = connection.prepareStatement("SELECT emp_id, emp_Status, emp_Name, emp_Initials FROM EMPLOYEE WHERE emp_id = ? AND emp_Name = ?");
            preparedSQLStatement.setInt(1, password);
            preparedSQLStatement.setString(2, username);
            resultSet = preparedSQLStatement.executeQuery();
            //If the username and password is true, make the boolean array return 1 at index 0,
            // specifying that the username and password is true.
            if (resultSet.next()) {
                int emp_id = resultSet.getInt(1);   //Where 1 is the index of the column we are selecting from.
                String emp_Status = resultSet.getString(2);
                String emp_Name = resultSet.getString(3);
                emp_Ini = resultSet.getString(4);
                System.out.println(emp_Ini);
                System.out.println("The emp_id is:" + emp_id + " " + emp_Status + " " + emp_Name);
                Authenticate_Authorize[0] = true;
                //If the credentials are true, authorize the user, if the user is an admin make Authenticate_Authorize[1] true, false otherwise.
                if (Objects.equals(emp_Status, "admin")) {
                    Authenticate_Authorize[1] = true;
                    System.out.println("The user is an admin.");
                } else {
                    Authenticate_Authorize[1] = false;
                    System.out.println("The user is an employee.");
                }
            } else {
                System.out.println("Password Incorrect");
                Authenticate_Authorize[0] = false;
            }
        } catch (Exception e) {
            System.out.println("Querying not successful.");
            System.out.println("The exception in the catch block is " + e + "\n" + e.getMessage());
        } finally {
            try {
                System.out.println("Closing connections.");
                resultSet.close();
                preparedSQLStatement.close();
                connection.close();
            } catch (Exception e) {
                System.out.println("Connections didn't close due to:  " + e + "\n" + e.getMessage());
            }
        }
        return Authenticate_Authorize;
    }

    public void DBInsertValuesIntoEmployeeTB(){
        connection = ConnectDB(connection);
        //preparedSQLStatement = connection.prepareStatement();
    }
}
