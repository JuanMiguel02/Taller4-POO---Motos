package juanycamilo.demo.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import static juanycamilo.demo.utils.SceneNavigator.cargarVista;


/**
 * Controlador para el Dashboard principal
 */
public class DashboardController {

    @FXML
    private HBox contenedorPrincipal;

    @FXML
    private Button btnGuardarProducto;

    @FXML
    private Button btnVerProducto;

    /**
     * Maneja los eventos para cargar las otras ventanas
     */
    @FXML
    private void onCargarFormulario() {
        //llama al metodo que carga las vistas
        cargarVista(this, "/FormularioMoto.fxml");

    }
    @FXML
    private void onVerMotos() {
        cargarVista(this, "/ListadoMoto.fxml");
    }

    public HBox getContenedorPrincipal() {
        return contenedorPrincipal;
    }

}
