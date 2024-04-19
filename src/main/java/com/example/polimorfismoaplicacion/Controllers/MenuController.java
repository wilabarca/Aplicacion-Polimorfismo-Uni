package com.example.polimorfismoaplicacion.Controllers;

import com.example.polimorfismoaplicacion.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    Stage callSave =new Stage();
    Stage callUpdate=new Stage();
    Stage callSee =new Stage();

    @FXML
    void onMouseClickSalirButton(MouseEvent event)  {


    }

    @FXML
    void onMouseClickSaveButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("saveStudent-view.fxml"));
        Scene scene = null;
        scene = new Scene(fxmlLoader.load());
        callSave.setTitle("Descartes/Save Student");
        callSave.setScene(scene);
        callSave.show();
    }

    @FXML
    void onMouseClickSeeButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("VerStudent-view.fxml"));
        Scene scene = null;
        scene = new Scene(fxmlLoader.load());
        callSee.setTitle("Descartes/See Student");
        callSee.setScene(scene);
        callSee.show();

    }

    @FXML
    void onMouseClickUpDateButton(MouseEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("GuardarStudent-view.fxml"));
        Scene scene = null;
        scene = new Scene(fxmlLoader.load());
        callUpdate.setTitle("Descartes/Update Student");
        callUpdate.setScene(scene);
        callUpdate.show();


    }

    @FXML
    void initialize() {

    }

}
