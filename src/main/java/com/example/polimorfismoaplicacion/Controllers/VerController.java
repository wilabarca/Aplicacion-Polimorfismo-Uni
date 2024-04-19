package com.example.polimorfismoaplicacion.Controllers;

import com.example.polimorfismoaplicacion.HelloApplication;
import com.example.polimorfismoaplicacion.models.Registro;
import com.example.polimorfismoaplicacion.models.Student;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class VerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    private TableColumn<Student, String> apellidoMySQL;
    @FXML
    private TableColumn<Student, String> matriculaMySQL;
    @FXML
    private TableColumn<Student, String> nombreMySQL;
    @FXML
    private TableView<Student> tableViewMySQL;


    @FXML
    private TableColumn<Student, String> apellidoSQL;
    @FXML
    private TableColumn<Student, String> matriculaSQL;
    @FXML
    private TableColumn<Student, String> nombreSQL;
    @FXML
    private TableView<Student> tableViewSQL;


    @FXML
    private TableColumn<Student, String> apellidoSQLite;
    @FXML
    private TableColumn<Student, String> matriculaSQLite;
    @FXML
    private TableColumn<Student, String> nombreSQLite;
    @FXML
    private TableView<Student> tableViewSQLite;
    private Registro registro = HelloApplication.getRegistro();

    @FXML
    void onMouseClickSalirButton(MouseEvent event) {

        Stage stage = (Stage) tableViewSQLite.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onMouseClickSeeButton(MouseEvent event) {


        if (registro !=null&&registro.getMySQL()!=null&&registro.getMySQL().getEstudiantes()!=null) {
            tableViewMySQL.getItems().addAll(registro.getMySQL().getEstudiantes());
            tableViewSQL.getItems().addAll(registro.getSql().getEstudiantes());
            tableViewSQLite.getItems().addAll(registro.getSqLite().getEstudiantes());
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("La lista se encuentra vacía.");
            alert.showAndWait();
        }
    }

    @FXML
    void initialize() {

        nombreMySQL.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        apellidoMySQL.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        matriculaMySQL.setCellValueFactory(cellData -> cellData.getValue().matriculaProperty());

        nombreSQL.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        apellidoSQL.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        matriculaSQL.setCellValueFactory(cellData -> cellData.getValue().matriculaProperty());

        nombreSQLite.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        apellidoSQLite.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        matriculaSQLite.setCellValueFactory(cellData -> cellData.getValue().matriculaProperty());
    }
}
