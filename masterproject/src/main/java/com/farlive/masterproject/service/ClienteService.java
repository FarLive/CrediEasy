package com.farlive.masterproject.service;

import com.farlive.masterproject.entidades.Cliente;
import com.farlive.masterproject.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired      // Autoinyectable
    private ClienteRepository clienteRepository;

    public boolean existeUsuario(String username, String password) {
        for(Cliente cliente:clienteRepository.findAll()){
            if(cliente.getUsuario().equals(username) && cliente.getContrasena().equals(password)){
                return true;
            }     
        }
        return false;
    }
}
