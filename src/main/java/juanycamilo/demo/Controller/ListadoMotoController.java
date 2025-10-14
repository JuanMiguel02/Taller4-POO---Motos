package juanycamilo.demo.Controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import juanycamilo.demo.utils.DashboardAware;
import juanycamilo.demo.utils.SceneNavigator;
import juanycamilo.demo.Model.Moto;
import juanycamilo.demo.Repositories.MotoRepository;

import static juanycamilo.demo.utils.AlertHelper.mostrarAlerta;
import static juanycamilo.demo.utils.SceneNavigator.cargarDashboard;


/**
 * Controlador para la lista de productos
 */
public class ListadoMotoController implements DashboardAware {

    @FXML
    public Button btnEliminar;

    @FXML
    public Button btnVolver;


    @FXML
    private HBox contenedorPrincipal;

    @FXML
    private TableView<Moto> tablaMotos;

    @FXML
    private TableColumn<Moto, String> colPlaca;

    @FXML
    private TableColumn<Moto, String> colModelo;

    @FXML
    private TableColumn<Moto, String> colMarca;


    private SceneNavigator sceneNavigator;
    private MotoRepository motoRepository;
    private ObservableList<Moto> listaMotos;
    private DashboardController dashboardController;

    @FXML
    public void initialize() {
        motoRepository = MotoRepository.getInstancia();
        
        // Configurar las columnas de la tabla
        colPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));

//
//        // Formatear la columna de precio
//        colPrecio.setCellFactory(column -> new TableCell<Producto, Double>() {
//            @Override
//            protected void updateItem(Double precio, boolean empty) {
//                super.updateItem(precio, empty);
//                if (empty || precio == null) {
//                    setText(null);
//                } else {
//                    setText(String.format("$%.2f", precio));
//                }
//            }
//        });

        // Cargar los productos
        cargarProductos();
    }

    /**
     * Carga los productos en la tabla
     */
    public void cargarProductos() {
        listaMotos = FXCollections.observableArrayList(motoRepository.getMotos());
        tablaMotos.setItems(listaMotos);
    }

    /**
     * Maneja el evento de click en el botón "Eliminar"
     */
    @FXML
    private void onEliminarProducto() {
        Moto motoSeleccionada = tablaMotos.getSelectionModel().getSelectedItem();
        
        if (motoSeleccionada == null) {
            mostrarAlerta("Advertencia", "Por favor seleccione una moto para eliminar", Alert.AlertType.WARNING);
            return;
        }

        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Confirmar eliminación");
        confirmacion.setHeaderText("¿Está seguro de eliminar la moto?");
        confirmacion.setContentText("Moto: " + motoSeleccionada.getPlaca());

        confirmacion.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                motoRepository.eliminarMoto(motoSeleccionada);
                cargarProductos();
                mostrarAlerta("Éxito", "Moto eliminada correctamente", Alert.AlertType.INFORMATION);
            }
        });
    }

    @Override
    public void setDashboardController(DashboardController dashboardController) {
        this.dashboardController = dashboardController;
    }
    @Override
    public void setContenedorPrincipal(HBox contenedorPrincipal){
        this.contenedorPrincipal = contenedorPrincipal;
    }

    /**
     * Restaura la vista del dashboard
     */
    public void onVolverDashboard() {
       cargarDashboard(contenedorPrincipal);
    }
}

