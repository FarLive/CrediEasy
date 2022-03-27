package com.farlive.masterproject.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Tarjetas_de_credito")
public class TarjetaCredito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_TarjetaCredito")
    private int idTarjetaCredito;

    @Column(name = "Num_Tarjeta")
    private int numTarjeta;

    @Column(name = "Fecha_Expiracion")
    private LocalDate fechaExpiracion;

    @Column(name = "CVV")
    private int CVV;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_Cliente")
    private List <Cliente> clientes = new ArrayList<>();


    public TarjetaCredito() {
    }
    

    public TarjetaCredito(int idTarjetaCredito, int numTarjeta, LocalDate fechaExpiracion, int CVV, List <Cliente> clientes) {
        this.idTarjetaCredito = idTarjetaCredito;
        this.numTarjeta = numTarjeta;
        this.fechaExpiracion = fechaExpiracion;
        this.CVV = CVV;
        this.clientes = clientes;
    }


    public int getIdTarjetaCredito() {
        return this.idTarjetaCredito;
    }

    public void setIdTarjetaCredito(int idTarjetaCredito) {
        this.idTarjetaCredito = idTarjetaCredito;
    }

    public int getNumTarjeta() {
        return this.numTarjeta;
    }

    public void setNumTarjeta(int numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public LocalDate getFechaExpiracion() {
        return this.fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDate fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public int getCVV() {
        return this.CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    public List <Cliente> getClientes() {
        return this.clientes;
    }

    public void setClientes(List <Cliente> clientes) {
        this.clientes = clientes;
    }

}
