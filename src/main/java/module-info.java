module com.example.tanosofillingstation {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tanosofillingstation to javafx.fxml;
    exports com.example.tanosofillingstation;
}