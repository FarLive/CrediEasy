package com.farlive.masterproject.controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.farlive.masterproject.config.Views;
import com.farlive.masterproject.entidades.CreditCard;
import com.farlive.masterproject.entidades.Customer;
import com.kwms.core.managent.SceneManagent;

import org.springframework.stereotype.Controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Popup;

@Controller
public class CreditCardController implements Initializable {

    @FXML
    private StackPane root;

    @FXML
    private VBox subroot;

    @FXML
    private Text type;

    @FXML
    private Text first;

    @FXML
    private Text second;

    @FXML
    private Text third;

    @FXML
    private Text fourth;

    @FXML
    private Text nameTxt;

    @FXML
    private Text dateTxt;
    private boolean isShowCtxMenu = false;
    private TooltipController tooltipController;
    private Popup popup = new Popup();
    private double x = 0d;
    private double y = 0d;
    private CreditCard creditCard;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tooltipController = loadCtxMenuView();
        createCtxMenu();
    }

    public TooltipController getTooltipController() {
        return tooltipController;
    }

    public Popup getPopup() {
        return popup;
    }

    public StackPane getRoot() {
        return root;
    }

    public void setCreditCard(CreditCard creditCard, Customer customer) {
        this.creditCard = creditCard;
        this.setDateTxt(creditCard.getDate());
        this.setNameTxt(customer.getPerson().getName());
        String number = creditCard.getNumber();
        this.setFirst(number.substring(0, 4));
        this.setSecond(number.substring(4, 8));
        this.setThird(number.substring(8, 12));
        this.setFourth(number.substring(12, 16));
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

    public void setGradient(String gradient) {
        subroot.setStyle(gradient);
    }

    public void setRoot(StackPane root) {
        this.root = root;
    }

    public VBox getSubroot() {
        return this.subroot;
    }

    public void setSubroot(VBox subroot) {
        this.subroot = subroot;
    }

    public Text getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type.setText(type);
    }

    public Text getFirst() {
        return this.first;
    }

    public void setFirst(String first) {
        this.first.setText(first);
    }

    public Text getSecond() {
        return this.second;
    }

    public void setSecond(String second) {
        this.second.setText(second);
    }

    public Text getThird() {
        return this.third;
    }

    public void setThird(String third) {
        this.third.setText(third);
    }

    public Text getFourth() {
        return this.fourth;
    }

    public void setFourth(String fourth) {
        this.fourth.setText(fourth);
    }

    public Text getNameTxt() {
        return this.nameTxt;
    }

    public void setNameTxt(String nameTxt) {
        this.nameTxt.setText(nameTxt);
    }

    public Text getDateTxt() {
        return this.dateTxt;
    }

    public void setDateTxt(String dateTxt) {
        this.dateTxt.setText(dateTxt);
    }   

    public CreditCard getCreditCard() {
        return creditCard;
    }

    @Override
    public String toString() {
        return "Control of " + type.getText();
    }
}
