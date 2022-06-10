package com.farlive.masterproject;

import com.farlive.masterproject.config.Views;
import com.kwms.core.managent.SceneManagent;
import com.kwms.core.threadpool.Executor;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Launcher extends Application {

    private ConfigurableApplicationContext ctx = null;

    @Override
    public void start(Stage primaryStage) throws Exception {
        SceneManagent.getInstance().createStage(Views.LOGIN).show();
    }

    @Override
    public void init(){
        
        ctx = new SpringApplicationBuilder(MasterprojectApplication.class)
					.run(getParameters().getRaw()
										.stream()
										.toArray(String[]::new));
    }

    @Override
    public void stop() {
        ctx.close();
        Executor.getInstance().shutdownNow();
        Platform.exit();
    }
}