package com.infsus.suhs.model;

import jakarta.persistence.*;

import java.util.Objects;

//nije dovrseno zbog adrese
@Entity
@Table(name = "vozilo")
public class Vozilo {

    @Id
    @Column(name = "registracija")
    private String registracija;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "kapacitet")
    private int kapacitet;

    @Column(name = "uloga")
    private String uloga;

    @Embedded
    private AdresaId adresaId;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "grad", referencedColumnName = "grad", insertable = false, updatable = false),
            @JoinColumn(name = "pbroj", referencedColumnName = "pbroj", insertable = false, updatable = false),
            @JoinColumn(name = "naziv", referencedColumnName = "naziv", insertable = false, updatable = false)
    })
    private Adresa adresa;

    public Vozilo() {
    }

    public Vozilo(String registracija, Boolean status, int kapacitet, String uloga, Adresa adresa) {
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public AdresaId getAdresaId() {
        return adresaId;
    }

    public void setAdresaId(AdresaId adresaId) {
        this.adresaId = adresaId;
    }

    public Adresa getAdresa() {
        return adresa;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vozilo vozilo = (Vozilo) o;
        return Objects.equals(registracija, vozilo.registracija);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registracija, status, kapacitet, uloga, adresaId, adresa);
    }

    @Override
    public String toString() {
        return String.format("Vozilo-%s (%s)", uloga, registracija);
    }
}
