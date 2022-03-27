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
@Table(name = "Tarjeta_Oro")
public class TarjetaOro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdOro")
    private int idOro;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_TarjetaCredito")
    private TarjetaCredito tarjetaCredito;

    public TarjetaOro() {
    }

    public TarjetaOro(int idOro, TarjetaCredito tarjetaCredito) {
        this.idOro = idOro;
        this.tarjetaCredito = tarjetaCredito;
    }

    public int getIdOro() {
        return this.idOro;
    }

    public void setIdOro(int idOro) {
        this.idOro = idOro;
    }

    public TarjetaCredito getTarjetaCredito() {
        return this.tarjetaCredito;
    }

    public void setTarjetaCredito(TarjetaCredito tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

}
