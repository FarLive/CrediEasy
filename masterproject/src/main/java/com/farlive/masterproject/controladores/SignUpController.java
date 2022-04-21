package com.farlive.masterproject.controladores;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;

import com.farlive.masterproject.config.Views;
import com.farlive.masterproject.entidades.Cliente;
import com.farlive.masterproject.service.ClienteService;
import com.jfoenix.controls.JFXTextField;
import com.kwms.core.alert.Alert;
import com.kwms.core.annotation.SFXEntity;
import com.kwms.core.control.SimpleEntityControl;
import com.kwms.core.logger.NewEntityException;
import com.kwms.core.managent.SceneManagent;
import com.kwms.core.validation.FieldValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

@Controller
public class SignUpController implements Initializable{
    
    @FXML
    private AnchorPane registerClientPane;

    @SFXEntity(name = "nombre", canBeNull = false)
    @FXML
    private JFXTextField fullNameField;

    @SFXEntity(name = "usuario", canBeNull = false)
    @FXML
    private JFXTextField userNameField;

    @SFXEntity(name = "correo", canBeNull = false)
    @FXML
    private JFXTextField emailField;

    @SFXEntity(name = "contrasena", canBeNull = false)
    @FXML
    private JFXTextField passwordField;

    @SFXEntity(name = "telefono", canBeNull = false)
    @FXML
    private JFXTextField phoneField;

    @SFXEntity(name = "direccion", canBeNull = false)
    @FXML
    private JFXTextField addressField;

    @Autowired
    private ClienteService clienteService;

    @FXML
    void createNewAccount(ActionEvent event) {
        if(!FieldValidator.areEmpty(true, fullNameField, userNameField, emailField, passwordField, phoneField, addressField)) {
            SimpleEntityControl entityControl = new SimpleEntityControl();
            try {
                Cliente cliente = entityControl.getNewEntity(Cliente.class, this);
                if(clienteService.save(cliente))
                    Alert.success("Registro correcto", "Ahora puede usar sus credenciales para ingresar al sistema.");
                else 
                    Alert.error("Algo salio mal", "No se ha podido registrar su cuenta, vuelva a intentarlo");
            } catch (Exception e) {
                e.printStackTrace(System.err);
                Alert.warning("Faltan datos", "Verifique sus entradas, debe llenar todos los campos");
            } 
        }
    }

    @FXML
    void switchCreate(MouseEvent event) {
        SceneManagent.getInstance().changeScene(Views.LOGIN);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        
    }

}
