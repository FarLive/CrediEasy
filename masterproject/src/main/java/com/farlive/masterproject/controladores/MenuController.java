package com.farlive.masterproject.controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.farlive.masterproject.config.Views;
import com.farlive.masterproject.entidades.CreditCard;
import com.farlive.masterproject.entidades.CreditCardType;
import com.farlive.masterproject.entidades.Customer;
import com.farlive.masterproject.service.service.CreditCardService;
import com.jfoenix.controls.JFXButton;
import com.kwms.core.alert.Alert;
import com.kwms.core.managent.SceneManagent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;

import static com.farlive.masterproject.entidades.CreditCardType.*;

@Controller
public class MenuController implements Initializable {

    @FXML
    private StackPane root;

    @FXML
    private HBox containerAvailable;

    @FXML
    private HBox myCardsContainer;

    @FXML
    private JFXButton configBtn;

    @FXML
    private JFXButton logout;

    private final String[] types = { "Clasica", "Oro", "Platino" };
    private final String[][] benefits = {
            { "Banca en linea", "Efectivo inmediato", "Credito tipo 1", "Tasa de interes fija", "Anualidades bajas" },
            { "Credito_Tipo2", "MSI en cualquier compra", "Recompensas", "Ofertas especiales", "Descuentos" },
            { "Credito_Tipo3", "Seguros", "Acceso VIP", "Tasa de interes baja", "Recompensas dobles" } };
    private final String[] gradients = { "-fx-background-color: linear-gradient(to left, #1270B1, #179DCB);",
            "-fx-background-color: linear-gradient(to left, #F1EA01, #F5EE10);",
            "-fx-background-color: linear-gradient(to left, #9C9C9C, #BDBDBD);" };

    private CreditCardController classic;
    private CreditCardController gold;
    private CreditCardController platinum;

    private Customer customer;

    private SceneManagent sceneManagent;

    @Autowired
    private CreditCardService creditCardService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sceneManagent = SceneManagent.getInstance();
    }

    protected void initilizeCards() {
        LoginController controller = sceneManagent.getController(Views.LOGIN);
        logout.setOnMouseClicked(e -> sceneManagent.changeScene(Views.LOGIN));
        customer = controller.getCustomerLoggedIn();
        configBtn.setOnMouseClicked(e -> {
            sceneManagent.showModalStage(Views.SETTINGS);
            sceneManagent.getController(Views.SETTINGS, SettingsController.class).putInfoCustomer(customer);
        });
        try {
            if (!clientHas(CLASICA)) {
                classic = loadCreditCard(benefits[0], types[0], gradients[0]);
                containerAvailable.getChildren().add(classic.getRoot());
                HBox.setHgrow(classic.getRoot(), Priority.ALWAYS);
            } else
                moveCreditCard(classic);

            if (!clientHas(ORO)) {
                gold = loadCreditCard(benefits[1], types[1], gradients[1]);
                containerAvailable.getChildren().add(gold.getRoot());
                HBox.setHgrow(gold.getRoot(), Priority.ALWAYS);
            } else
                moveCreditCard(gold);

            if (!clientHas(PLATINO)) {
                platinum = loadCreditCard(benefits[2], types[2], gradients[2]);
                containerAvailable.getChildren().add(platinum.getRoot());
                HBox.setHgrow(platinum.getRoot(), Priority.ALWAYS);
            } else
                moveCreditCard(platinum);
        } catch (IOException e) {
            Alert.error("Ocurrio un error", "Algo ha pasado al cargar las tarjetas");
        }
    }

    private boolean clientHas(CreditCardType type) {
        return customer.getCreditcards().stream().anyMatch(card -> card.getType().equals(type.toString()));
    }

    public StackPane getRoot() {
        return root;
    }

    private CreditCardController loadCreditCard(String[] infoBenefits, String type, String gradient)
            throws IOException {
        FXMLLoader loader = new FXMLLoader(MenuController.class.getResource(Views.CREDIT_CARD.getPath()));
        loader.load();
        CreditCardController controller = loader.getController();
        controller.setType(type);
        controller.getTooltipController().setNombreTarjeta(type);
        controller.setGradient(gradient);
        controller.getTooltipController().setBenefits(infoBenefits);
        controller.getTooltipController().getHireButton().setOnMouseClicked(e -> moveCreditCard(controller));
        return controller;
    }

    private void moveCreditCard(CreditCardController controller) {
        CreditCard creditCard = createCreditCard(controller.getType().getText());
        controller.setCreditCard(creditCard);
        controller.getPopup().hide();
        controller.getSubroot().setDisable(true);
        controller.getRoot().setOnMouseClicked(e -> {
            if (e.getButton().equals(MouseButton.PRIMARY)) {
                Alert.warning("Dar de baja", "Si desea dar de baja la tarjeta, de clic en el boton," +
                        " en caso contrario, solo cierre la ventana", evt -> removeCreditCard(controller));
            }
        });
        Node node = controller.getRoot();
        containerAvailable.getChildren().remove(node);
        myCardsContainer.getChildren().add(node);
        HBox.setHgrow(node, Priority.ALWAYS);
    }

    private void removeCreditCard(CreditCardController controller) {
        CreditCard creditCard = controller.getCreditCard();
        controller.setCreditCard(new CreditCard(0, creditCard.getType(), "1234567891234567", creditCard.getDate(), "xxx", customer));
        controller.getSubroot().setDisable(false);
        controller.getRoot().setOnMouseClicked(e -> {});
        containerAvailable.getChildren().add(controller.getRoot());
        myCardsContainer.getChildren().remove(controller.getRoot());
        HBox.setHgrow(controller.getRoot(), Priority.ALWAYS);
    }

    private CreditCard createCreditCard(String type) {
        LoginController controller = sceneManagent.getController(Views.LOGIN);
        CreditCard creditCard = new CreditCard();

        if (controller.getCustomerLoggedIn().getCreditcards().size() >= 2) {
            Alert.error("Debe de dar de baja una tarjeta", "Usted ha llegado al limite de tarjetas permitidas");
            throw new RuntimeException("Numero maximo de tarjetas permitidas");
        }

        creditCard.setCustomer(controller.getCustomerLoggedIn());
        creditCard.setDate("05/2026");
        creditCard.setCvv("334");
        creditCard.setType(type);
        creditCard.setNumber("4216070288940499");
        return creditCard;
    }

}