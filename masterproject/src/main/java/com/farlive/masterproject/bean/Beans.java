package com.farlive.masterproject.bean;

import com.farlive.masterproject.config.Views;
import com.farlive.masterproject.util.ServiceConsumer;
import com.kwms.core.managent.Fxml;
import com.kwms.core.managent.Loader;
import com.kwms.core.managent.SceneManagent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javafx.fxml.FXMLLoader;

@Configuration
public class Beans {

    @Autowired
    private ConfigurableApplicationContext ctx;

    private static boolean isInitialize = false;

    @Bean
    public SceneManagent sceneManagent() {
        if(!isInitialize) {
            SceneManagent.init(new Loader() {

                @Override
                public FXMLLoader newLoader(Fxml fxml) {
                    FXMLLoader fxmlLoader = new FXMLLoader(Beans.class.getResource(fxml.getPath()));
                    fxmlLoader.setControllerFactory(ctx::getBean);
                    return fxmlLoader;
                }
                
            }, Views.values());
            isInitialize = true;
        }
        return SceneManagent.getInstance();
    }

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public ServiceConsumer consumer() {
        return new ServiceConsumer();
    }


}
