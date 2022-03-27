package com.farlive.masterproject.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Tarjeta_Clasica")
public class TarjetaClasica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdClasica")
    private int idClasica;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_TarjetaCredito")
    private TarjetaCredito tarjetaCredito;

    public TarjetaClasica() {

    }

    public TarjetaClasica(int idClasica, TarjetaCredito tarjetaCredito) {
        this.idClasica = idClasica;
        this.tarjetaCredito = tarjetaCredito;
    }


    public int getIdClasica() {
        return this.idClasica;
    }

    public void setIdClasica(int idClasica) {
        this.idClasica = idClasica;
    }

    public TarjetaCredito getTarjetaCredito() {
        return this.tarjetaCredito;
    }

    public void setTarjetaCredito(TarjetaCredito tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

}
