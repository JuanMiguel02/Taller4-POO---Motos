package juanycamilo.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("/Dashboard.fxml"));

        Parent root = loader.load();

        Scene scene = new Scene(root, 900, 600);

        primaryStage.setTitle("Sistema de Gestión de Motos");
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(500);

        primaryStage.show();


    }
    public static void main(String[] args) {
        launch(args);
    }
}
