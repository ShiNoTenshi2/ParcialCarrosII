package controller;

import java.sql.Connection;

import application.Main;
import data.CarroDAO;
import data.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Carro;

public class ConcesionarioController {

    @FXML
    private TableColumn<Carro, Integer> columnCantidadD;

    @FXML
    private TableColumn<Carro, String> columnColorE;

    @FXML
    private TableColumn<Carro, String> columnMarcaD;

    @FXML
    private TableColumn<Carro, String> columnMarcaE;

    @FXML
    private TableColumn<Carro, String> columnModeloD;

    @FXML
    private TableColumn<Carro, String> columnModeloE;

    @FXML
    private TableView<Carro> tableCarrosDisponibles;

    @FXML
    private TableView<Carro> tableCarrosEliminados;
    
    private Connection connection = DBConnection.getInstance().getConnection();
    private CarroDAO carroDAO = new CarroDAO(connection);
    
    @FXML
    public void initialize() {
        ObservableList<Carro> availableCarros = FXCollections.observableArrayList();
        
        for (Carro carro: carroDAO.fetchDisponible()) {
            availableCarros.add(carro); 
        }

        ObservableList<Carro> noavailableCarros = FXCollections.observableArrayList();
        
        for (Carro carro: carroDAO.fetchEliminados()) {
            noavailableCarros.add(carro); 
        }
        
        columnCantidadD.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        columnColorE.setCellValueFactory(new PropertyValueFactory<>("color"));
        columnMarcaD.setCellValueFactory(new PropertyValueFactory<>("marca"));
        columnMarcaE.setCellValueFactory(new PropertyValueFactory<>("marca"));
        columnModeloD.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        columnModeloE.setCellValueFactory(new PropertyValueFactory<>("modelo"));

        // Asigna los datos a la TableView
        tableCarrosDisponibles.setItems(availableCarros);
        tableCarrosEliminados.setItems(noavailableCarros);
    }

    
    @FXML
    void eliminar(ActionEvent event) {
        if (!tableCarrosDisponibles.getSelectionModel().isEmpty()) {
            Carro carro = tableCarrosDisponibles.getSelectionModel().getSelectedItem();
            carroDAO.eliminar(carro.getReferencia()); 
            initialize();
        } else {
            Main.showAlert("Seleccione un modelo", "Seleccione un modelo", "Debe seleccionar un dato de la tabla", Alert.AlertType.WARNING);
        }
    }

    @FXML
    void recuperar(ActionEvent event) {
        if (!tableCarrosEliminados.getSelectionModel().isEmpty()) {
            Carro carro = tableCarrosEliminados.getSelectionModel().getSelectedItem();
            carroDAO.recuperar(carro.getReferencia()); 
            initialize();
        } else {
            Main.showAlert("Seleccione un modelo", "Seleccione un modelo", "Debe seleccionar un dato de la tabla", Alert.AlertType.WARNING);
        }
    }
}


