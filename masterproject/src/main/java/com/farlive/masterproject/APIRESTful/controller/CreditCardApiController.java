package com.farlive.masterproject.APIRESTful.controller;

import java.util.List;

import com.farlive.masterproject.APIRESTful.repositories.CreditCardRepository;
import com.farlive.masterproject.entidades.CreditCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CreditCardApiController {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @PostMapping("/save-creditcard")
    public ResponseEntity<CreditCard> save(@RequestBody CreditCard creditCard) {
        return creditCardRepository.save(creditCard) != null ? new ResponseEntity<>(HttpStatus.OK)
                                                             : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/remove-creditcard")
    public void remove(@RequestBody CreditCard creditCard) {
        creditCardRepository.delete(creditCard);
    }

    @GetMapping("/all-cards")
    public List<CreditCard> getAll() {
        return creditCardRepository.findAll();
    }
}