package com.farlive.masterproject.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import com.farlive.masterproject.config.Views;
import com.kwms.core.managent.SceneManagent;

import org.springframework.stereotype.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

@Controller
public class MenuController implements Initializable {

    @FXML
    private StackPane root;

    @FXML
    private AnchorPane classicCardContainer;

    private SceneManagent sceneManagent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sceneManagent = SceneManagent.getInstance();
        sceneManagent.putSubPane(classicCardContainer, Views.CREDIT_CARD);
    }

    public StackPane getRoot() {
        return root;
    }
    
}
