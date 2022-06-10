package com.farlive.masterproject.controladores;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import com.kwms.core.alert.Alert;

public class MenuAdminController {

    public void launchConsole() throws URISyntaxException, IOException {
        String url = Paths.get(MenuAdminController.class.getResource("/python").toURI()).toFile().getAbsolutePath();
        System.out.println(url);
        Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"cd " + url + " && python Banco.py\"");
    }

}
