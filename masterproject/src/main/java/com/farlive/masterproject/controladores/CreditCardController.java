package com.farlive.masterproject.controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.farlive.masterproject.config.Views;
import com.kwms.core.managent.SceneManagent;

import org.springframework.stereotype.Controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;

@Controller
public class CreditCardController implements Initializable {

    @FXML
    private VBox subroot;
    private boolean isShowCtxMenu = false;
    private TooltipController tooltipController;
    private Popup popup = new Popup();
    private double x = 0d;
    private double y = 0d;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tooltipController = loadCtxMenuView();
        createCtxMenu();
    }

    public Popup getPopup() {
        return popup;
    }

    private void createCtxMenu() {
        
        popup.getContent().add(tooltipController.getRoot());

        subroot.setOnMouseExited(e -> {
            System.out.println("MOUSE EXITED");
        });


        subroot.setOnMouseEntered(e -> {
            x = e.getSceneX();
            y = e.getSceneY();
        });

        subroot.hoverProperty().addListener((obsV, oldV, newV) -> {
            StackPane stackpane = getMenuController().getRoot();
            // Bounds bnds = stackpane.localToScreen(stackpane.getLayoutBounds());
            // double x = bnds.getMinX() - (stackpane.getWidth() / 2) + (stackpane.getWidth() / 2);
            // double y = bnds.getMinY() - stackpane.getHeight();
            if(tooltipController.isFocused()) return;

            if(newV)
                popup.show(getMenuController().getRoot(), x, y);
            else
                popup.hide();
        });
    }

    private TooltipController loadCtxMenuView() {
        FXMLLoader loader = new FXMLLoader(CreditCardController.class.getResource("/fxml/Tooltip.fxml"));
        try {
            loader.load();
            return loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Platform.exit();
        return null;
    }

    private MenuController getMenuController() {
        return SceneManagent.getInstance().getController(Views.MENU);
    }
    
}
