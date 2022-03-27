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
@Table(name = "Tarjeta_Platino")
public class TarjetaPlatino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPlatino")
    private int idPlatino;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_TarjetaCredito")
    private TarjetaCredito tarjetaCredito;

    public TarjetaPlatino() {
    }

    public TarjetaPlatino(int idPlatino, TarjetaCredito tarjetaCredito) {
        this.idPlatino = idPlatino;
        this.tarjetaCredito = tarjetaCredito;
    }

    public int getIdPlatino() {
        return this.idPlatino;
    }

    public void setIdPlatino(int idPlatino) {
        this.idPlatino = idPlatino;
    }

    public TarjetaCredito getTarjetaCredito() {
        return this.tarjetaCredito;
    }

    public void setTarjetaCredito(TarjetaCredito tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

}
