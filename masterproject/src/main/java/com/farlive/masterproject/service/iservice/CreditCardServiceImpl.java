package com.farlive.masterproject.service.iservice;

import javax.transaction.Transactional;

import com.farlive.masterproject.APIRESTful.repositories.CreditCardRepository;
import com.farlive.masterproject.entidades.CreditCard;
import com.farlive.masterproject.entidades.Customer;
import com.farlive.masterproject.service.service.CreditCardService;
import com.farlive.masterproject.util.ServiceConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    @Autowired
    private ServiceConsumer serviceConsumer;

    @Autowired
    private CreditCardRepository repository;
    
    @Override
    @Transactional
    public boolean save(CreditCard creditCard) {
        System.out.println(creditCard);
        return repository.save(creditCard) != null;
//        return serviceConsumer.postMethod(creditCard, "save-creditcard").equals(HttpStatus.OK);
    }

    @Override
    @Transactional
    public void remove(CreditCard creditCard) {
        creditCard.getCustomer().removeCreditCard(creditCard);
        serviceConsumer.postMethod(creditCard, "remove-creditcard");
    }

}