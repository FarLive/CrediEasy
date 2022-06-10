package com.farlive.masterproject.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_person")
    private Person person;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<CreditCard> creditcards;

    public Customer() {}
    
    public Customer(int id, Person person, List<CreditCard> creditcards) {
        this.id = id;
        this.person = person;
        this.creditcards = creditcards;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<CreditCard> getCreditcards() {
        return this.creditcards;
    }

    public void setCreditcards(List<CreditCard> creditcards) {
        this.creditcards = creditcards;
        if(this.creditcards !=  null)
            this.creditcards.forEach(card -> card.setCustomer(this));
    }

    public void addCreditCards(CreditCard creditCard) {
        creditcards.add(creditCard);
        creditCard.setCustomer(this);
    }

    public void removeCreditCard(CreditCard creditCard) {
        creditcards.remove(creditCard);
        creditCard.setCustomer(null);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", person='" + getPerson() + "'" +
            "}";
    }
}