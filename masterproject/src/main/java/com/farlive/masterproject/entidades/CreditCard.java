package com.farlive.masterproject.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "creditcards")
public class CreditCard {
    
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 45, nullable = false)
    private String type;

    @Column(length = 16, unique = true)
    private String number;

    @Column(length = 5, nullable = false)
    private String date;

    @Column(length = 3, nullable = false)
    private String cvv;

    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idcustomer", nullable = false, updatable = true, insertable = true)
    @JsonBackReference
    private Customer customer;


    public CreditCard(int id, String type, String number, String date, String cvv, Customer customer) {
        this.id = id;
        this.type = type;
        this.number = number;
        this.date = date;
        this.cvv = cvv;
        this.customer = customer;
    }

    public CreditCard() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCvv() {
        return this.cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    
    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", type='" + getType() + "'" +
            ", number='" + getNumber() + "'" +
            ", date='" + getDate() + "'" +
            ", cvv='" + getCvv() + "'" +
            ", customer='" + getCustomer() + "'" +
            "}";
    }


}