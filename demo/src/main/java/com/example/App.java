package com.example;
import java.io.IOException;

import com.example.controlador.AlumnoControlador;
import com.example.modelo.AlumnoModelo;
import com.example.vista.AlumnoView;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        //launch();
        AlumnoModelo modelo=new AlumnoModelo();
        AlumnoControlador controlador=new AlumnoControlador(modelo);
        AlumnoView alumnoInterfaz= new AlumnoView(controlador);
        alumnoInterfaz.iniciar();
    }

}