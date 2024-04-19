package com.example.polimorfismoaplicacion.Controllers;

import com.example.polimorfismoaplicacion.HelloApplication;
import com.example.polimorfismoaplicacion.models.Registro;
import com.example.polimorfismoaplicacion.models.MongoDB;
import com.example.polimorfismoaplicacion.models.Student;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class GuardarController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Student, String> apellido;

    @FXML
    private TextField apellidoStudent;

    @FXML
    private TableColumn<Student, String> matricula;

    @FXML
    private TextField matriculaStudent;

    @FXML
    private TableColumn<Student, String> nombre;

    @FXML
    private TextField nombreStudent;
    @FXML
    private TextField nuevoNombreStudent;

    @FXML
    private TableView<Student> tableView;
    private Registro registro = HelloApplication.getRegistro();
    @FXML
    void onMouseClickSalirButton(MouseEvent event) {
        Stage stage = (Stage) nombreStudent.getScene().getWindow();
        stage.close();

    }

    @FXML
    void onMouseClickRevisarButton(MouseEvent event) {

        MongoDB sqLite=new MongoDB();
        if (registro !=null&&registro.getMySQL()!=null&&registro.getMySQL().getEstudiantes()!=null) {
            tableView.getItems().addAll(registro.getMySQL().getEstudiantes());

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("La lista se encuentra vacia.");
            alert.showAndWait();

        }

    }

    @FXML
    void onMouseClickUpdateButton(MouseEvent event) {
        String name = nombreStudent.getText();
        String apellido = apellidoStudent.getText();
        String matricula = matriculaStudent.getText();
        String newName= nuevoNombreStudent.getText();
        if (name.isEmpty() || apellido.isEmpty() || matricula.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Rellene los campos correctamente.");
            alert.showAndWait();
        } else {
            boolean estudianteEncontrado = false;
                for (Student student : tableView.getItems()) {
                    if (name.equals(student.getName())) {
                        student.setName(newName);
                        student.setFirstName(apellido);
                        student.setMatricula(matricula);
                        registro.update(student);
                        estudianteEncontrado = true;
                        nombreStudent.clear();
                        apellidoStudent.clear();
                        matriculaStudent.clear();

                    } else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText("No exite el estudiante , no se puede actualizar.");
                        alert.showAndWait();

                    }

                }
                if (estudianteEncontrado) {
                    tableView.getItems().clear();
                    tableView.getItems().addAll(registro.getMySQL().getEstudiantes());
                }

        }

    }



    @FXML
    void initialize() {
        nombre.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        apellido.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        matricula.setCellValueFactory(cellData -> cellData.getValue().matriculaProperty());

    }

}
