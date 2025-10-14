package juanycamilo.demo.Controller;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import juanycamilo.demo.utils.DashboardAware;
import juanycamilo.demo.Model.Moto;
import juanycamilo.demo.Repositories.MotoRepository;


import static juanycamilo.demo.utils.AlertHelper.mostrarAlerta;
import static juanycamilo.demo.utils.SceneNavigator.cargarDashboard;


/**
 * Controlador para el formulario de creación de productos
 */
public class FormularioMotoController implements DashboardAware {

    @FXML
    private TextField txtPlaca;

    @FXML
    private TextField txtModelo;

    @FXML
    private TextField txtMarca;

    @FXML private HBox contenedorPrincipal;

    private MotoRepository motoRepository;

    private DashboardController dashboardController;

    @FXML
    public void initialize() {
       motoRepository = MotoRepository.getInstancia();
    }

    /**
     * Maneja el evento de guardar producto
     */

    @FXML
    private void onGuardarMoto() {
        if (!validarCampos()) {
            return;
        }

        try {
            String placa = txtPlaca.getText().trim();
            String modelo = txtModelo.getText().trim();
            String marca = txtMarca.getText().trim();

            // Verificar si el código ya existe
            if (motoRepository.buscarPorPlaca(placa) != null) {
                mostrarAlerta("Error", "Ya existe una moto con esa placa", Alert.AlertType.ERROR);
                return;
            }

            // Crear y guardar el producto
            Moto nuevaMoto = new Moto(placa, modelo, marca);
            motoRepository.agregarMoto(nuevaMoto);

            mostrarAlerta("Éxito", "Moto añadida correctamente", Alert.AlertType.INFORMATION);
            
            // Volver al dashboard
            volverAlDashboard();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Maneja el evento de cancelar
     */
    @FXML
    private void onCancelar() {
        volverAlDashboard();
    }

    /**
     * Vuelve a mostrar el dashboard
     */
    private void volverAlDashboard() {
        //Llama al metodo que carga el dashboard principal
       cargarDashboard(contenedorPrincipal);
    }

    /**
     * Valida que los campos del formulario estén completos
     */
    private boolean validarCampos() {
        if (txtPlaca.getText().trim().isEmpty()) {
            mostrarAlerta("Error de validación", "La placa es obligatoria", Alert.AlertType.WARNING);
            return false;
        }
        if (txtModelo.getText().trim().isEmpty()) {
            mostrarAlerta("Error de validación", "El modelo es obligatorio", Alert.AlertType.WARNING);
            return false;
        }
        if (txtMarca.getText().trim().isEmpty()) {
            mostrarAlerta("Error de validación", "La marca es obligatoria", Alert.AlertType.WARNING);
            return false;
        }
        return true;
    }

    @Override
    public void setDashboardController(DashboardController dashboardController) {
        this.dashboardController = dashboardController;
    }
    @Override
    public void setContenedorPrincipal(HBox contenedorPrincipal){
        this.contenedorPrincipal = contenedorPrincipal;
    }

}

