package com.example.urzua_benjamin.control;

import com.example.urzua_benjamin.dto.UsuarioDto;
import com.example.urzua_benjamin.model.UsuarioModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class UsuarioController {
    @FXML
    public TableColumn<UsuarioDto, Integer> colId;


    @FXML
    public TableColumn<UsuarioDto, String> colNombre;
    @FXML
    public TableColumn<UsuarioDto, String> colEdad;
    @FXML
    public Button btnEliminar;

    @FXML
    public Button btnCont;
    @FXML
    public Button btnActualizar;
    private UsuarioModel usuarioModel; // = new UsuarioModel(); forma mas sencilla
    private Integer id = 0; // id usuario en automatizacion por asi referirme
    private UsuarioDto eliminarUsuario;

    @FXML
    public TableView tableUsuario;


    @FXML
    public TextField txtNombre;
    @FXML
    public TextField txtEdad;
    @FXML
    public TextField txtAprovacion;

    public void initialize() {// inicilizar el comprotamiento de la tabla y vincular tambien la tabla alos datos
        usuarioModel = new UsuarioModel();
        this.colId.setCellValueFactory(new PropertyValueFactory<>("id")); //
        this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre")); //
        this.colEdad.setCellValueFactory(new PropertyValueFactory<>("edad")); //el ()dsp del new es en minuscula!!!
        // la lista observable se conecta al arraylist del MOdelo
        observableUsuarios = FXCollections.observableArrayList(usuarioModel.getUsuarios());// el observatorio quedara pendiente de ArrayList
        // conecto la tabla JAvaFX a la lista observacion, cuando ya se observe, debe actualizar usuarios de la tabla
        tableUsuario.set(observableUsuarios);
        tableUsuario.getSelectionModel().selectedItemProperty().addListener((obs, anterior, seleccionado) -> {
            if (seleccionado != null) {
                txtNombre.getText(seleccionado.getNombre());
                txtEdad.getText(String.valueOf(seleccionado.getEdad()));
                btnActualizar.setDisable(false);
            }
        });

    }

    public UsuarioController() {
        usuarioModel = new UsuarioModel(); // instancia creada de forma "tipida", "recomendada"

    }

    // particularidad de ArrayList, no notifica ni avisa a nadie que cambió entonces debemos crear un "atributo" una "propiedad" que avise que cambio, eso es con observable list
    private ObservableList<UsuarioDto> observableUsuarios;


    @FXML
    public void handleContinuacion(ActionEvent actionEvent) {
        try {
            String nombre = txtNombre.getText();
            String edad = txtEdad.getText();
            if (nombre.trim().isEmpty() || edad.trim().isEmpty()) {
                throw new Exception("Nombre o apellido no valido, no puede estar vacio");
            }
            Integer id = this.getId();
            // System.out.println("Ingresado: "+ nombre + " " + edad); forma habitual de mostrar

            UsuarioDto usuarioDto = new UsuarioDto(); //
            usuarioDto.setEdad(edad); //   USUARIO CON TODOS LOS ATRIBUTOS INICIALIZADO
            usuarioDto.setNombre(nombre);//
            usuarioDto.setId(id);//

            this.usuarioModel.agregarUsuario(usuarioDto);
            this.txtAprovacion.setText(String.valueOf(this.usuarioModel.getUsuarios().size()));
            // actualizar vista observable
            this.observableUsuarios.setAll(usuarioModel.getUsuarios());
        } catch (Exception e) {
            this.mostrarMsjError(e.getMessage());
        }
    }


    private Integer getId() {
        this.id = this.id + 1; // la primera vez en llamar al metodo primero suma 1 y despues retorna el numero-id
        return id;
    }

    private void mostrarMsjError(String msj) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Error");
        alerta.setHeaderText(null);
        alerta.setContentText(msj);
        alerta.showAndWait();
    }

    @FXML
    public void handleSelectTable(MouseEvent mouseEvent) {
        UsuarioDto usuarioDto = (UsuarioDto) this.tableUsuario.getSelectionModel().getSelectedItem();
        System.out.println(usuarioDto);
        if (usuarioDto != null) {
            this.btnEliminar.setDisable(false);
            this.eliminarUsuario = usuarioDto;

        }
    }

    public void handleEliminar(ActionEvent actionEvent) {
        this.usuarioModel.eliminar(eliminarUsuario);
        this.observableUsuarios.setAll(usuarioModel.getUsuarios());
    }

}