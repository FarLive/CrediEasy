package com.farlive.masterproject.service.iservice;

import javax.transaction.Transactional;

import com.farlive.masterproject.entidades.CreditCard;
import com.farlive.masterproject.service.service.CreditCardService;
import com.farlive.masterproject.util.ServiceConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    @Autowired
    private ServiceConsumer serviceConsumer;
    
    @Override
    @Transactional
    public boolean save(CreditCard creditCard) {
        return serviceConsumer.postMethod(creditCard, "save-creditcard").equals(HttpStatus.OK);
    }

    @Override
    public void remove(CreditCard creditCard) {
        
    }

}