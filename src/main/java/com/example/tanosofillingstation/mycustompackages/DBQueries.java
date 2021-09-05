package com.example.tanosofillingstation.mycustompackages;

import java.sql.*;
import java.util.Objects;

public class DBQueries {
    //SQL STATEMENTS AND QUERIES.
    static Connection connection = null;
    static PreparedStatement preparedSQLStatement;
    static ResultSet resultSet;
    static int resultSetInt;
    boolean[] Authenticate_Authorize = new boolean[2];

    //The amount of arrays to create when you are on the admin window.
    public static int numberOfRows;

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

    //Close all DB connections.
    private void DBCloseConnections() {
        try {
            System.out.println("Closing connections.");
            resultSet.close();
            preparedSQLStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Connections didn't close due to:  " + e + "\n" + e.getMessage());
        }
    }


    public boolean[] AuthenticationAndAuthorization(String username, int password) {
        //Connect to a database and execute the query.
        try {
            //Connecting to a database using a connection.
            connection = ConnectDB(connection);
            preparedSQLStatement = connection.prepareStatement("SELECT emp_id, emp_Status, emp_Name, emp_Initials " +
                    "FROM EMPLOYEE WHERE emp_id = ? AND emp_UserName = ?");
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
            DBCloseConnections();
        }
        return Authenticate_Authorize;
    }

    public void DBInsertValuesIntoEmployeeTB(String cus_Name, String cus_vNum, int cus_tNum,
                                             float cus_pPaid, float cus_lBought, int oilP_id, String emp_Ini, String cus_Date) {
        connection = ConnectDB(connection);
        try {
            preparedSQLStatement = connection.prepareStatement("INSERT INTO CUSTOMER" +
                    "(cus_Name,cus_vehicleNum,cus_telephoneNum,cus_pricePaid,cus_litresBought,op_id,emp_Initials,cus_dateBought)" +
                    "VALUES (?,?,?,?,?,?,?,?)");
            preparedSQLStatement.setString(1, cus_Name);
            preparedSQLStatement.setString(2, cus_vNum);
            preparedSQLStatement.setInt(3, cus_tNum);
            preparedSQLStatement.setFloat(4, cus_pPaid);
            preparedSQLStatement.setFloat(5, cus_lBought);
            preparedSQLStatement.setInt(6, oilP_id);
            preparedSQLStatement.setString(7, emp_Ini);
            preparedSQLStatement.setString(8, cus_Date);
            //Result set here must be integer, because it is executing an update.
            resultSetInt = preparedSQLStatement.executeUpdate();
            System.out.println(resultSet);
            System.out.println("Values inserted into DB.");
        } catch (SQLException e) {
            System.out.println("SQL exception in Inserting data to Employees table: " + e + e.getMessage());
        } finally {
            try {
                DBCloseConnections();
            } catch (NumberFormatException e) {
                System.out.println("Error in sql resultSet.close: " + e.getMessage() + " " + e);
            }
        }
    }

    public void SetCount(String dateSelected) {
        try {
            connection = ConnectDB(connection);
            preparedSQLStatement = connection.prepareStatement("SELECT COUNT(cus_dateBought) FROM CUSTOMER WHERE cus_dateBought = ?");
            preparedSQLStatement.setString(1, dateSelected);
            resultSet = preparedSQLStatement.executeQuery();
            if (resultSet.next()) {
                numberOfRows = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("SQL exception in count of array, on admin window:" + e.getMessage() + " " + e);
        } finally {
            DBCloseConnections();
        }
    }

    public String[] GetDataDate(String dateSelected) {
        //Create an array to store the date in, then later return it.
        String[] dateArray = new String[numberOfRows];
        try {
            //Opening connections
            connection = ConnectDB(connection);
            preparedSQLStatement = connection.prepareStatement("SELECT cus_dateBought " +
                    "FROM CUSTOMER WHERE  cus_dateBought = ?");
            preparedSQLStatement.setString(1, dateSelected);
            resultSet = preparedSQLStatement.executeQuery();
            if (resultSet.next()) {
                for (int i = 1; i <= resultSet.getRow(); i++) {
                    dateArray[i - 1] = resultSet.getString(1);
                    System.out.println(dateArray[i - 1]);
                    resultSet.next();
                }
            }


        } catch (SQLException e) {
            System.out.println("SQL exception when retrieving data to share on admin window : " + e.getMessage() + " " + e);
        } finally {
            DBCloseConnections();
        }
        return dateArray;
    }

    //Getting results of employee
    public String[] GetDataEmpIni(String dateSelected) {
        //Create an array to store the date in, then later return it.
        String[] empIniArray = new String[numberOfRows];
        try {
            //Opening connections
            connection = ConnectDB(connection);
            preparedSQLStatement = connection.prepareStatement("SELECT emp_Initials " +
                    "FROM CUSTOMER WHERE  cus_dateBought = ?");
            preparedSQLStatement.setString(1, dateSelected);
            resultSet = preparedSQLStatement.executeQuery();
            if (resultSet.next()) {
                for (int i = 1; i <= resultSet.getRow(); i++) {
                    empIniArray[i - 1] = resultSet.getString(1);
                    System.out.println(empIniArray[i - 1]);
                    resultSet.next();
                }
            }


        } catch (SQLException e) {
            System.out.println("SQL exception when retrieving data to share on admin window : " + e.getMessage() + " " + e);
        } finally {
            DBCloseConnections();
        }
        return empIniArray;
    }

    //Getting results of employee
    public String[] GetDataVehicleNum(String dateSelected) {
        //Create an array to store the date in, then later return it.
        String[] vehicleNumArray = new String[numberOfRows];
        try {
            //Opening connections
            connection = ConnectDB(connection);
            preparedSQLStatement = connection.prepareStatement("SELECT cus_vehicleNum " +
                    "FROM CUSTOMER WHERE  cus_dateBought = ?");
            preparedSQLStatement.setString(1, dateSelected);
            resultSet = preparedSQLStatement.executeQuery();
            if (resultSet.next()) {
                for (int i = 1; i <= resultSet.getRow(); i++) {
                    vehicleNumArray[i - 1] = resultSet.getString(1);
                    System.out.println(vehicleNumArray[i - 1]);
                    resultSet.next();
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL exception when retrieving data to share on admin window : " + e.getMessage() + " " + e);
        } finally {
            DBCloseConnections();
        }
        return vehicleNumArray;
    }
}
