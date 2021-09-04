package com.example.tanosofillingstation.mycustompackages;

public class SharedData {
    //Data from EmployeeWindow that needs to be shared among other windows.
    public static String customerName, vehicleNum, telephoneNumber, fuelType, product, emp_Initials, cus_date;
    public static int oilProduct_id;
    public static float litresBought, pricePaid;

    //Incoming data from EmployeeWindow.
    public static void OutgoingEmployeeSharedData(String cusName, String vehNum, String telNum, String FT, String P,
                                                  float LB, float PP, int op_id, String emp_Ini, String date) {
        customerName = cusName;
        vehicleNum = vehNum;
        telephoneNumber = telNum;
        fuelType = FT;
        product = P;
        litresBought = LB;
        pricePaid = PP;
        oilProduct_id = op_id;
        emp_Initials = emp_Ini;
        cus_date = date;
    }

    //Outgoing shared data from EmployeeWindow, this data will be used by another window.
    public static String[] IncomingEmployeeSharedData() {
        return new String[]{customerName, vehicleNum, telephoneNumber, fuelType, product, String.valueOf(litresBought),
                String.valueOf(pricePaid), String.valueOf(oilProduct_id), String.valueOf(emp_Initials), cus_date};
    }
}