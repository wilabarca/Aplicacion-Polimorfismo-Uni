module com.example.polimorfismoaplicacion {
    requires javafx.controls;
    requires javafx.fxml;
    exports com.example.polimorfismoaplicacion.models;
    opens com.example.polimorfismoaplicacion.models to javafx.fxml;


    opens com.example.polimorfismoaplicacion to javafx.fxml;
    exports com.example.polimorfismoaplicacion;
    exports com.example.polimorfismoaplicacion.Controllers;
    opens com.example.polimorfismoaplicacion.Controllers to javafx.fxml;
}