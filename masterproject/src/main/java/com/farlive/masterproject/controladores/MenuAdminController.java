package com.farlive.masterproject.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
/* import com.kodedu.terminalfx.Terminal;
import com.kodedu.terminalfx.TerminalBuilder;
import com.kodedu.terminalfx.TerminalTab;
import com.kodedu.terminalfx.config.TerminalConfig; */

import org.springframework.stereotype.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;

@Controller
public class MenuAdminController implements Initializable {

    @FXML
    private StackPane consolePane;

    @FXML
    private JFXButton processBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
        
    }

    /* private Terminal terminal;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> createConsole());
        processBtn.setOnMouseClicked(e -> {
            processBtn.setDisable(true);
            terminal.command("mySQL.exe");
            //GlassRobot robot = com.sun.glass.ui.Application.GetApplication().createRobot();
            // robot.mouseMove(robot.getMouseX(), 200);
            // robot.mousePress(MouseButton.PRIMARY);
            //robot.keyPress(KeyCode.ENTER);
        });
    }

    private void createConsole() {
        try {
            TerminalConfig darkConfig = new TerminalConfig();
            darkConfig.setBackgroundColor(Color.rgb(16, 16, 16));
            darkConfig.setForegroundColor(Color.rgb(0, 140, 15));
            darkConfig.setCursorColor(Color.rgb(255, 255, 255, 0.5));
            darkConfig.setFontFamily("Consolas");

            TerminalBuilder terminalBuilder = new TerminalBuilder(darkConfig);

            URI uri = MenuAdminController.class.getResource("/C++").toURI();
            terminalBuilder.setTerminalPath(Path.of(uri));
            TerminalTab terminal = terminalBuilder.newTerminal();
            this.terminal = terminal.getTerminal();

            TabPane tabPane = new TabPane();
            tabPane.getTabs().add(terminal);
            consolePane.getChildren().add(tabPane);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } */

}
