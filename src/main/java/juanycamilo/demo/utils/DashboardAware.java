package juanycamilo.demo.utils;


import javafx.scene.layout.HBox;
import juanycamilo.demo.Controller.DashboardController;


public interface DashboardAware {
/*
 * Interfaz que deben implementar los controladores de vistas
 * que necesitan interactuar con el {@link DashboardController}.
 */

    /**
     * Inyecta la referencia al controlador principal del Dashboard.
     * @param dashboardController controlador principal del Dashboard.
     */
    void setDashboardController(DashboardController dashboardController);


    /**
     * Inyecta la referencia al contenedor principal del Dashboard,
     * utilizado para mostrar dinámicamente las diferentes vistas.
     *
     * @param contenedorPrincipal contenedor donde se cargan las vistas.
     */
    void setContenedorPrincipal(HBox contenedorPrincipal);

}
