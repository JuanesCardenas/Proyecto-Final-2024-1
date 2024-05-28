package com.proyectofinal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Stack;

/**
 * JavaFX App
 */
public class App extends Application {
    private static App instance;

    public App() {
        instance = this;
    }

    public static App getInstance() {
        return instance;
    }

    private Stage stage;
    private VistaEstadoCuidador cuidador = new VistaEstadoCuidador();
    private final Stack<VistaEstadoMemento> estadoStack = cuidador.getStack();

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        loadScene("/com/proyectofinal/login.fxml");
    }

    public void loadScene(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();

            // Guardar el estado actual antes de cargar una nueva escena
            VistaEstadoMemento newState = new VistaEstadoMemento(scene);
            cuidador.addMemento(newState);
            //estadoStack.push(newState);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goBack() {
        // Verificar si hay un estado anterior en la pila
        if (estadoStack.size() > 1) {
            // Remover el estado actual de la pila
            estadoStack.pop();
            // Obtener y mostrar el estado anterior
            VistaEstadoMemento previousState = estadoStack.peek();
            stage.setScene(previousState.getState());
            stage.show();
        } else {
            System.out.println("No hay estado anterior.");
        }
    }
    

    public static void main(String[] args) {
        launch(args);
    }

}