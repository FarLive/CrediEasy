package com.farlive.masterproject;

import com.farlive.masterproject.config.Views;
import com.kwms.core.managent.Fxml;
import com.kwms.core.managent.Loader;
import com.kwms.core.managent.SceneManagent;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class Launcher extends Application {

    private ConfigurableApplicationContext ctx = null;

    @Override
    public void start(Stage primaryStage) throws Exception {
        SceneManagent.getInstance().createStage(Views.MENU).show();
    }

    @Override
    public void init(){
        
        ctx = new SpringApplicationBuilder(MasterprojectApplication.class)
					.run(getParameters().getRaw()
										.stream()
										.toArray(String[]::new));

        SceneManagent.init(new Loader() {

            @Override
            public FXMLLoader newLoader(Fxml fxml) {
                FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource(fxml.getPath()));
                fxmlLoader.setControllerFactory(ctx::getBean);
                return fxmlLoader;
            }
            
        }, Views.values());
    }

    @Override
    public void stop() {
        ctx.close();
        Platform.exit();

    }
}