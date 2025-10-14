module juanycamilo.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    // Paquetes abiertos para reflexión (FXML y bindings)
    opens juanycamilo.demo to javafx.fxml;
    opens juanycamilo.demo.Controller to javafx.fxml;
    opens juanycamilo.demo.Model to javafx.base;

    // Paquetes exportados públicamente
    exports juanycamilo.demo;
    exports juanycamilo.demo.Controller;
    exports juanycamilo.demo.Model;
}