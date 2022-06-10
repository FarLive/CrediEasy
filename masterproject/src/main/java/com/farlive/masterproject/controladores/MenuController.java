package com.farlive.masterproject.controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.farlive.masterproject.APIRESTful.repositories.CreditCardRepository;
import com.farlive.masterproject.config.Views;
import com.farlive.masterproject.entidades.CreditCard;
import com.farlive.masterproject.entidades.CreditCardType;
import com.farlive.masterproject.entidades.Customer;
import com.farlive.masterproject.service.service.CreditCardService;
import com.farlive.masterproject.util.CreditCardCreator;
import com.jfoenix.controls.JFXButton;
import com.kwms.core.alert.Alert;
import com.kwms.core.managent.SceneManagent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import lombok.Data;

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
            { "Banca en linea", "Efectivo inmediato", "Credito tipo 1", "Tasa de interes fija", "Anualidades bajas\nConstruccion de historial crediticio" },
            { "Credito_Tipo2", "MSI en cualquier compra", "Recompensas", "Ofertas especiales", "Descuentos\nLinea de credito compartida" },
            { "Credito_Tipo3", "Seguros", "Acceso VIP", "Tasa de interes baja", "Recompensas dobles\nViajes Platinum" } };
    private final String[] gradients = { "-fx-background-color: linear-gradient(to left, #1270B1, #179DCB);",
            "-fx-background-color: linear-gradient(to left, #F1EA01, #F5EE10);",
            "-fx-background-color: linear-gradient(to left, #9C9C9C, #BDBDBD);" };

    private CreditCardController classic;
    private CreditCardController gold;
    private CreditCardController platinum;

    @Autowired
    private CreditCardService creditCardService;

    private CreditCardCreator creator;
    private SceneManagent sceneManagent;
    public static Customer customer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       sceneManagent = SceneManagent.getInstance();
       
    }

    protected void initilizeCards() {
        LoginController controller = sceneManagent.getController(Views.LOGIN);
        logout.setOnMouseClicked(e -> sceneManagent.changeScene(Views.LOGIN));
        customer = controller.getCustomerLoggedIn();
        creator = new CreditCardCreator(customer);
        configBtn.setOnMouseClicked(e -> {
            sceneManagent.showModalStage(Views.SETTINGS);
            sceneManagent.getController(Views.SETTINGS, SettingsController.class).putInfoCustomer(customer);
        });
        try {
            containerAvailable.getChildren().clear();
            myCardsContainer.getChildren().clear();
            CreditCard creditCard = null;

            classic = loadCreditCard(benefits[0], types[0], gradients[0]);
            gold = loadCreditCard(benefits[1], types[1], gradients[1]);
            platinum = loadCreditCard(benefits[2], types[2], gradients[2]);

            if ((creditCard = clientHas(CLASICA)) == null) {
                containerAvailable.getChildren().add(classic.getRoot());
                HBox.setHgrow(classic.getRoot(), Priority.ALWAYS);
            } else
                moveCreditCard(classic, creditCard);

            if ((creditCard = clientHas(ORO)) == null) {
                containerAvailable.getChildren().add(gold.getRoot());
                HBox.setHgrow(gold.getRoot(), Priority.ALWAYS);
            } else
                moveCreditCard(gold, creditCard);

            if ((creditCard = clientHas(PLATINO)) == null) {
                containerAvailable.getChildren().add(platinum.getRoot());
                HBox.setHgrow(platinum.getRoot(), Priority.ALWAYS);
            } else
                moveCreditCard(platinum, creditCard);
        } catch (IOException e) {
            Alert.error("Ocurrio un error", "Algo ha pasado al cargar las tarjetas");
        }
    }

    private CreditCard clientHas(CreditCardType type) {
        return customer.getCreditcards().stream().filter(card -> card.getType().equals(type.name())).findFirst().orElse(null);
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
        controller.getTooltipController().getHireButton().setOnMouseClicked(e -> {
                moveCreditCard(controller, saveCreditCard(controller));
                controller.getPopup().hide();
        });
        return controller;
    }

    private CreditCard saveCreditCard(CreditCardController controller) {
        CreditCard creditcard = creator.create(controller.getType().getText().toUpperCase());
        customer.addCreditCards(creditcard);
        if(creditcard.getCustomer().getCreditcards().size() <= 2) {
            if(creditCardService.save(creditcard)) {
                Alert.success("Exito!", "Su tarjeta ha sido generada");
                return creditcard;
            }else {
                customer.removeCreditCard(creditcard);
            }
        }else {
            Alert.warning("No se contratara", "Ha llegado al maximo de tarjetas aceptadas por este banco.");
            throw new RuntimeException("Max credit card acepted");
        }
        customer.removeCreditCard(creditcard);
        throw new RuntimeException("Invalid credit card");
    }

    private void moveCreditCard(CreditCardController controller, CreditCard creditCard) {
        if(creditCard == null) {
            Alert.error("Ha ocurrido un error", "No se ha podido generar su tarjeta de credito.");
            return;
        }
        controller.setCreditCard(creditCard, customer);
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
        creditCardService.remove(creditCard);
        controller.setCreditCard(new CreditCard(0, creditCard.getType(), "123456xxxxxxxxxx", creditCard.getDate(), "xxx", customer), customer);
        controller.getSubroot().setDisable(false);
        controller.getRoot().setOnMouseClicked(e -> {});
        containerAvailable.getChildren().add(controller.getRoot());
        myCardsContainer.getChildren().remove(controller.getRoot());
        HBox.setHgrow(controller.getRoot(), Priority.ALWAYS);
    }

}