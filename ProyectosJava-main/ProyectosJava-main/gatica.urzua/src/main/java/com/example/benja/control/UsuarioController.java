package com.example.benja.control;

import com.example.benja.dto.UsuarioDto;
import com.example.benja.model.UsuarioModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.util.Locale;

public class UsuarioController {
    @FXML
    public Button btnActualizar;
    @FXML
    public Button btnLimpiar;
    @FXML
    public Button btnEiminar;
    private UsuarioDto usuarioEliminar;
    @FXML
    public TextField txtNombre;
    @FXML
    public TextField txtEdad;

    @FXML
    public TextField txtIngress;
    @FXML
    public TableView tableUsuarios;
    @FXML
    public TableColumn <UsuarioDto, Integer>idCol;
    @FXML
    public TableColumn<UsuarioDto, String> columnaHombre;
    @FXML
    public TableColumn <UsuarioDto, String> colEdad;

    private UsuarioModel usuarioModel; //= new UsuarioModel(); recomendable para avanzar de forma mas expedita
    public UsuarioController(){ // costumbre de usar este metodo de inicializar
        usuarioModel= new UsuarioModel();
    }

    private Integer idUsuario = 0;

    private ObservableList <UsuarioDto> observableUsuario;{

    } //el observatorio es ingresado por el tema del ArrayList que no avisa que cosa cambio

    public void initialize(){ // initialize = inicializar

        usuarioModel = new UsuarioModel();
        this.idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.columnaHombre.setCellValueFactory(new PropertyValueFactory<>("nombre")); // era columna Nombre no HombreXD
        this.colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        // se le indica al observador que observara asi:
        observableUsuario = FXCollections.observableArrayList(usuarioModel.getUsuario());
        tableUsuarios.setItems(observableUsuario);
        // una vez observe, debe actualizar los usuarios de la tabla

    }

    @FXML
    public void handleIngresar(ActionEvent actionEvent) { // en caso de errores es aconsejado usar try catch
        try {
            String nombre = txtNombre.getText();
            String edad = txtEdad.getText();
            if(nombre.trim().isEmpty() || edad.trim().isEmpty()){
                throw new Exception("Nombre ni edad pueden estar vacios");
            }
            Integer idUsuario = this.getIdUsuario();

            UsuarioDto usuarioDto = new UsuarioDto();
            usuarioDto.setNombre(nombre);
            usuarioDto.setEdad(edad);
            usuarioDto.setId(idUsuario);

            this.usuarioModel.agregarUsuarioALista(usuarioDto);
            this.txtIngress.setText(String.valueOf(this.usuarioModel.getUsuario().size()));
            this.observableUsuario.setAll(usuarioModel.getUsuario());
        }catch (Exception e ){
            this.mostrarError(e.getMessage());
        }
    }

    @FXML
    public void handleActualizar(ActionEvent actionEvent) {

        UsuarioDto seleccionado = (UsuarioDto) tableUsuarios.getSelectionModel().getSelectedItem();

        if (seleccionado == null) {
            return;
        }

        if (txtNombre.getText().isBlank() || txtEdad.getText().isBlank()) {
            return; // aquí podrías mostrar una alerta
        }

        seleccionado.setNombre(txtNombre.getText());
        seleccionado.setEdad(txtEdad.getText());

        usuarioModel.actualizar(seleccionado);
        tableUsuarios.refresh();

        limpiarFormulario();
        this.btnActualizar.setDisable(true);

    }

    @FXML
    public void handleLimpiar(ActionEvent actionEvent) {

            txtNombre.clear();
            txtEdad.clear();
            txtIngress.clear();
            tableUsuarios.getSelectionModel().clearSelection();

            btnActualizar.setDisable(true);
            btnLimpiar.setDisable(true);

        this.btnLimpiar.setDisable(true);
    }

     @FXML
    private void limpiarFormulario() {
        txtNombre.clear();
        txtEdad.clear();
        tableUsuarios.getSelectionModel().clearSelection();
        btnActualizar.setDisable(true);
        btnLimpiar.setDisable(true);
    }





    @FXML
    public void handleEliminar(ActionEvent actionEvent) {

        this.usuarioModel.eliminar(usuarioEliminar); // para eliminar es facil, sencillamente ingresar .eliminar a java (modelo) y en modulo escribir this.---.delete()
        this.observableUsuario.setAll(usuarioModel.getUsuario());// agregar en cada array
        // a la lista observable la conecto al ArrayList del modelo,
        // conecto la tabla de Java FX a la lista observable
        this.btnEiminar.setDisable(true);
    }

    private Integer getIdUsuario(){
        this.idUsuario+=1;
        return  idUsuario;
    }
    private void mostrarError(String msj){
        Alert alerta    = new Alert((Alert.AlertType.ERROR));
        alerta.setTitle("Error");
        alerta.setHeaderText(null);
        alerta.setContentText(msj);
        alerta.showAndWait();
    }
    @FXML
    public void handleSelectTable(MouseEvent mouseEvent) { // el ingresar getSelectedItem da error porque dice que devuelve objeto pero se necesito usuario Dto pero de por si
        UsuarioDto usuarioDto = (UsuarioDto) tableUsuarios.getSelectionModel().getSelectedItem();// ya se que ingrese usuarios Dto pero para solucionar el problema, se debe forzar con (paremtesis y clase)
        System.out.println(usuarioDto);// ver que trae usuarioDto(La clase), demuestra que al clickear en en cualquier sector de la pagina arroja null, por lo cual
        if (usuarioDto != null)
            ; // se debe comprobar que no sea nulo ya que al ser nulo impide el proceso, en cambio cuando no es nulo, el trabajo continua normal
        this.btnEiminar.setDisable(false);
        this.btnActualizar.setDisable(false);
        this.btnLimpiar.setDisable(false);
        this.usuarioEliminar = usuarioDto;
    }
}