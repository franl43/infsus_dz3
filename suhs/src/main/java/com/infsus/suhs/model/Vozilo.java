package com.infsus.suhs.model;

import jakarta.persistence.*;

//nije dovrseno zbog adrese
@Entity
@Table(name = "vozilo")
public class Vozilo {

    @Id
    @Column(name = "registracija")
    private String registracija;

    @Column(name = "status")
    private String status;

    @Column(name = "kapacitet")
    private int kapacitet;

    @Column(name = "uloga")
    private String uloga;

    //ovo ne znam kak da spojim s adresom
    @ManyToOne
    @JoinColumn(name = "adresaid", referencedColumnName = "adresaid")
    private Adresa adresa;

    public Vozilo() {
    }

    public String getRegistracija() {
        return registracija;
    }

    public void setRegistracija(String registracija) {
        this.registracija = registracija;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }

    public String getUloga() {
        return uloga;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }
}
