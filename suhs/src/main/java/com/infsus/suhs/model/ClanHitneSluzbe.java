package com.infsus.suhs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "clanhitnesluzbe")
public class ClanHitneSluzbe {

    @Id
    @Column(name = "korisnicko_ime")
    private String korisnicko_ime;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="korisnicko_ime", referencedColumnName = "korisnicko_ime")
    @JsonIgnore
    private Korisnik korisnik;

    @ManyToOne
    @JoinColumn(name = "registracija", referencedColumnName = "registracija")
    private Vozilo vozilo;

    public ClanHitneSluzbe() {}

    public ClanHitneSluzbe(String korisnicko_ime, Korisnik korisnik, Vozilo vozilo) {
        this.korisnicko_ime = korisnicko_ime;
        this.korisnik = korisnik;
        this.vozilo = vozilo;
    }

    public String getKorisnicko_ime() {
        return korisnicko_ime;
    }

    public void setKorisnicko_ime(String korisnicko_ime) {
        this.korisnicko_ime = korisnicko_ime;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Vozilo getVozilo() {
        return vozilo;
    }

    public void setVozilo(Vozilo vozilo) {
        this.vozilo = vozilo;
    }

    @Override
    public String toString() {
        return "ClanHitneSluzbe{" +
                "korisnicko_ime='" + korisnicko_ime + '\'' +
                ", korisnik=" + korisnik +
                ", vozilo=" + vozilo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClanHitneSluzbe that)) return false;
        return Objects.equals(korisnicko_ime, that.korisnicko_ime) && Objects.equals(korisnik, that.korisnik) && Objects.equals(vozilo, that.vozilo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(korisnicko_ime, korisnik, vozilo);
    }
}
