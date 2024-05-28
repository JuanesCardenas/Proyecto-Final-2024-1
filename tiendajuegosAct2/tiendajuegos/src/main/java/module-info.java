module com.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.proyectofinal to javafx.fxml;
    exports com.proyectofinal;

    opens com.proyectofinal.controller;
    exports com.proyectofinal.controller;

    opens com.proyectofinal.model;
    exports  com.proyectofinal.model;
}
