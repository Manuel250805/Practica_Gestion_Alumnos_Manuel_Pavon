module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    exports com.example;
    exports com.example.controlador;
    exports com.example.modelo;
    exports com.example.vista;
    exports com.example.interfaz;
    opens com.example to javafx.fxml;
}
