package com.farlive.masterproject.config;

import com.kwms.core.managent.Fxml;

public enum Views implements Fxml{
    // Constantes por cada vista
    LOGIN{
        @Override
        public String getPath(){
            return "/fxml/login.fxml";
        }

        @Override
        public String getTitle(){
            return "Banco ElAbarrotero";
        }
    },

    SIGNUP{
        @Override
        public String getPath(){
            return "/fxml/SignUp.fxml";
        }

        @Override
        public String getTitle(){
            return "Registro";
        }        
    },

    MENU {

        @Override
        public String getPath() {
            return "/fxml/Menu.fxml";
        }

        @Override
        public String getTitle() {
            return "Menu";
        }

    },

    CREDIT_CARD {
        @Override
        public String getPath() {
            return "/fxml/CreditCard.fxml";
        }

        @Override
        public String getTitle() {
            return "Tarjeta de credito";
        }
        
    };

    @Override
    public abstract String getPath();

    @Override
    public abstract String getTitle();

    @Override
    public boolean isInitializable() {
        return true;
    }
    
}
