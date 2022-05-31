package com.farlive.masterproject.APIRESTful.repositories;

import com.farlive.masterproject.entidades.CreditCard;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {
    
}
