package com.farlive.masterproject.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import com.farlive.masterproject.config.Views;
import com.jfoenix.controls.JFXButton;
import com.kwms.core.managent.SceneManagent;

import org.springframework.stereotype.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

@Controller
public class TooltipController implements Initializable {

    @FXML
    private StackPane root;

    @FXML
    private Text title;

    @FXML
    private Text fBenefit;

    @FXML
    private Text sBenefit;

    @FXML
    private Text tBenefit;

    @FXML
    private Text foBenefit;

    @FXML
    private Text fiBenefit;

    @FXML
    private JFXButton hireBtn;

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

    protected JFXButton getHireButton() {
        return hireBtn;
    }

    public void setNombreTarjeta(String nombre) {
        title.setText("Beneficios de la tarjeta " + nombre);
    }

    public void setBenefits(String... benefits) {
        if(benefits.length > 4) {
            fBenefit.setText(benefits[0]);
            sBenefit.setText(benefits[1]);
            tBenefit.setText(benefits[2]);
            foBenefit.setText(benefits[3]);
            fiBenefit.setText(benefits[4]);
        }
    }

    public StackPane getRoot() {
        return root;
    }

    public boolean isFocused() {
        return isFocused;
    }


}