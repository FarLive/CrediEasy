package com.farlive.masterproject.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import com.farlive.masterproject.config.Views;
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

    private SceneManagent sceneManagent;

    @FXML
    void loginAction(ActionEvent event) {
        if(!FieldValidator.areEmpty(true, username, password)) {
            if(!clienteService.findByUsuario(username.getText()))
                Alert.warning("El usuario no existe", "Crea una nueva cuenta");
            else {
                if(clienteService.existeUsuario(username.getText(), password.getText())) {
                    sceneManagent.changeScene(Views.MENU);
                }else Alert.error("Contraseña incorrecta", "Verifique su contraseña o cambiela si es que la olvido");
            }
        }
    }

    /* private String rutaGuardarPDF() {
        DirectoryChooser directorio = new DirectoryChooser();
        File file = directorio.showDialog(SceneManagent.getInstance().getStage());
        if(file == null)
            return null;
        return file.isDirectory() ? file.getAbsolutePath() : null;
    } */

    @FXML
    void switchCreate(MouseEvent event) {
        sceneManagent.changeScene(Views.SIGNUP);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sceneManagent = SceneManagent.getInstance();
    }

}
