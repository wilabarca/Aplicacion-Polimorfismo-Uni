package com.example.polimorfismoaplicacion.Controllers;

import com.example.polimorfismoaplicacion.HelloApplication;
import com.example.polimorfismoaplicacion.models.Registro;
import com.example.polimorfismoaplicacion.models.Student;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SaveController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField apellidoStudent;

    @FXML
    private TextField matriculaStudent;

    @FXML
    private TextField nombreStudent;

    private Registro registro = HelloApplication.getRegistro();

    @FXML
    void onMouseClickSalirButton(MouseEvent event) {
        Stage stage = (Stage) nombreStudent.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onMouseClickSaveButton(MouseEvent event) {
        if (registro != null) {
            String name = nombreStudent.getText();
            String firstName = apellidoStudent.getText();
            String matricula = matriculaStudent.getText();
            Student student = new Student(name, firstName, matricula);

            try {
                if (registro.getSqLite() != null) {
                    registro.getSqLite().saveStudent(student);
                    System.out.println("Estudiante guardado exitosamente en todas las bases de datos.");
                }
                if (registro.getSql() != null) {
                    registro.getSql().saveStudent(student);
                    System.out.println("Estudiante guardado exitosamente en todas las bases de datos.");
                }
                if (registro.getMySQL() != null) {
                    registro.getMySQL().saveStudent(student);
                    System.out.println("Estudiante guardado exitosamente en todas las bases de datos.");
                }


            } catch (Exception e) {
                System.err.println("Error al guardar el estudiante: " + e.getMessage());
            }
        } else {

            System.err.println("La instancia de Registro no ha sido inicializada correctamente.");
        }
    }

    @FXML
    void initialize() {

    }
}
