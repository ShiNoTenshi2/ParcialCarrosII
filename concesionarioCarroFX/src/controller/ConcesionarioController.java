package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ConcesionarioController {

    @FXML
    private TableColumn<?, ?> columnCantidadD;

    @FXML
    private TableColumn<?, ?> columnColorE;

    @FXML
    private TableColumn<?, ?> columnMarcaD;

    @FXML
    private TableColumn<?, ?> columnMarcaE;

    @FXML
    private TableColumn<?, ?> columnModeloD;

    @FXML
    private TableColumn<?, ?> columnModeloE;

    @FXML
    private TableView<?> tableCarrosDisponibles;

    @FXML
    private TableView<?> tableCarrosEliminados;
 
    

    @FXML
    void eliminar(ActionEvent event) {

    }

    @FXML
    void recuperar(ActionEvent event) {

    }

}
