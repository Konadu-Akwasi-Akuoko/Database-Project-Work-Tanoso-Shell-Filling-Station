module com.example.tanosofillingstation {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.tanosofillingstation to javafx.fxml;
    exports com.example.tanosofillingstation;
}