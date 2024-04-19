package com.example.polimorfismoaplicacion;

import com.example.polimorfismoaplicacion.models.BaseDeDatos;
import com.example.polimorfismoaplicacion.models.Registro;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static BaseDeDatos baseDeDatos;
    public static Registro registro=new Registro(baseDeDatos);
    public static Registro getRegistro(){
        return registro;
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("menu-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Descartes/Menu");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}