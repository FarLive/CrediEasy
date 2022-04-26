package com.farlive.masterproject.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import com.farlive.masterproject.config.Views;
import com.kwms.core.managent.SceneManagent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;

public class TooltipController implements Initializable {

    @FXML
    private StackPane root;

    private boolean isFocused = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        root.setOnMouseExited(e -> {
            isFocused = false;
            CreditCardController cc = SceneManagent.getInstance().getController(Views.CREDIT_CARD);
            cc.getPopup().hide();
        });
        root.setOnMouseEntered(e -> isFocused = true);
    }

    public StackPane getRoot() {
        return root;
    }

    public boolean isFocused() {
        return isFocused;
    }

}