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

    @Embedded
    private AdresaId adresaId;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "grad", referencedColumnName = "grad", insertable = false, updatable = false),
            @JoinColumn(name = "p_broj", referencedColumnName = "p_broj", insertable = false, updatable = false),
            @JoinColumn(name = "naziv", referencedColumnName = "naziv", insertable = false, updatable = false)
    })
    private Adresa adresa;

    public Vozilo() {
    }

    public Vozilo(String registracija, String status, int kapacitet, String uloga, Adresa adresa) {
        this.registracija = registracija;
        this.status = status;
        this.kapacitet = kapacitet;
        this.uloga = uloga;
        this.adresa = adresa;
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
