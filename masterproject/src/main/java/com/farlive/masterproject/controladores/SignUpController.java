package com.farlive.masterproject.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

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

    @FXML
    private JFXTextField firstNameField;

    @FXML
    private JFXTextField lastNameField;

    @FXML
    private JFXTextField socialSecurityField;

    @FXML
    private JFXTextField socialSecurityField1;

    @FXML
    private JFXTextField socialSecurityField12;

    @FXML
    private JFXTextField socialSecurityField121;

    @FXML
    void createNewAccount(ActionEvent event) {

    }

    @FXML
    void switchCreate(MouseEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        
    }

}
