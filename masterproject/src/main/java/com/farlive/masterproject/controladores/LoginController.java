package com.farlive.masterproject.controladores;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import com.farlive.masterproject.config.Views;
import com.farlive.masterproject.entidades.Customer;
import com.farlive.masterproject.entidades.RoleType;
import com.farlive.masterproject.entidades.User;
import com.farlive.masterproject.service.service.CustomerService;
import com.farlive.masterproject.service.service.UserService;
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
    private UserService userService;

    @Autowired
    private CustomerService customerService;

    private SceneManagent sceneManagent;
    private Customer customer;

    @FXML
    void loginAction(ActionEvent event) {
        if(!FieldValidator.areEmpty(true, username, password)) {
            User user = userService.findByUsername(username.getText());
            if(user == null)
                Alert.warning("El usuario no existe", "Crea una nueva cuenta!!!");
            else {
                if(user.getRole().getName().equals(RoleType.ADMIN.toString())) {
                    try {
                        new MenuAdminController().launchConsole();
                    } catch (IOException | URISyntaxException e) {
                        Alert.error("No se ha cargado el menu", e.getMessage());
                    }
                }else {
                    customer = customerService.findByUser(user.getUsername());
                    sceneManagent.getController(Views.MENU, MenuController.class).initilizeCards();
                    sceneManagent.changeScene(Views.MENU);    
                }
            }
        }
    }

    @FXML
    void switchCreate(MouseEvent event) {
        sceneManagent.changeScene(Views.SIGNUP);
    }

    public Customer getCustomerLoggedIn() {
        return customer;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sceneManagent = SceneManagent.getInstance();
    }

}