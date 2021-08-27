package com.example.tanosofillingstation.mycustompackages;

public class SharedData {
    //Data from EmployeeWindow that needs to be shared among other windows.
    public static String customerName, vehicleNum, telephoneNumber, fuelType, product, litresBought, pricePaid;
    public static int oilProduct_id;

    //Incoming data from EmployeeWindow.
    public static void OutgoingEmployeeSharedData(String cusName, String vehNum, String telNum, String FT, String P, String LB, String PP, int op_id) {
        customerName = cusName;
        vehicleNum = vehNum;
        telephoneNumber = telNum;
        fuelType = FT;
        product = P;
        litresBought = LB;
        pricePaid = PP;
        op_id = oilProduct_id;
    }

    //Outgoing shared data from EmployeeWindow, this data will be used by another window.
    public static String[] IncomingEmployeeSharedData() {
        return new String[]{customerName, vehicleNum, telephoneNumber, fuelType, product, litresBought, pricePaid, String.valueOf(oilProduct_id)};
    }
}