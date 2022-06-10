package com.farlive.masterproject.service.service;

import java.util.List;

import com.farlive.masterproject.entidades.CreditCard;
import com.farlive.masterproject.entidades.Customer;

public interface CreditCardService {

    public boolean save(CreditCard creditCard);

    public void remove(CreditCard creditCard);
    
}
