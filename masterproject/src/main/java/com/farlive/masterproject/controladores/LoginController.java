package com.farlive.masterproject.controladores;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.farlive.masterproject.service.ClienteService;
import com.kwms.core.alert.Alert;
import com.kwms.core.managent.SceneManagent;
import com.kwms.core.validation.FieldValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

@Controller
public class LoginController implements Initializable {

     

    @FXML
    private HBox box_password;

    @FXML
    private HBox box_username;

    @FXML
    private Label lbl_error;

    @FXML
    private Label lbl_password;

    @FXML
    private Label lbl_username;

    @FXML
    private Button login;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @Autowired
    private ClienteService clienteService;


    @FXML
    void loginAction(ActionEvent event) {
        if(!FieldValidator.areEmpty(true, username, password) && clienteService.existeUsuario(username.getText(), password.getText())) {

            Process proceso;
            String ruta = rutaGuardarPDF();
            if(ruta == null) return;

            if(LoginController.class.getResource("\\python\\consulta.py").toExternalForm()==null) {
                System.out.println("alo");
                return;
            }else System.out.println("si encontro");

            try{
                String[] args1 = new String[]{ "python", LoginController.class.getResource("\\python\\consulta.py").toExternalForm(), ruta};
                proceso = Runtime.getRuntime().exec(args1);
                proceso.waitFor();
                
            } catch(InterruptedException | IOException e ){
                
            }   

        }
        
        
        //FieldValidator.addValidationMessage(username);
        
        //Alert.success("Alerta", "Hola");

    }

    private String rutaGuardarPDF() {
        DirectoryChooser directorio = new DirectoryChooser();
        File file = directorio.showDialog(SceneManagent.getInstance().getStage());
        if(file == null)
            return null;
        return file.isDirectory() ? file.getAbsolutePath() : null;
    }

    @FXML
    void switchCreate(MouseEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        
    }

}
