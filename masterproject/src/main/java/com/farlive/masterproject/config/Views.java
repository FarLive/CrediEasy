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
    }
        
    ;

    @Override
    public abstract String getPath();

    @Override
    public abstract String getTitle();

    @Override
    public boolean isInitializable() {
        return true;
    }
    
}
