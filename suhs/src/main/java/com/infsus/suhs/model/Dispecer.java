package com.infsus.suhs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "dispecer")
public class Dispecer {

    @Id
    @Column(name = "korisnicko_ime")
    private String korisnicko_ime;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="korisnicko_ime", referencedColumnName = "korisnicko_ime")
    @JsonIgnore
    private Korisnik korisnik;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "centarid", referencedColumnName = "centarid")
    private Centar centar;

    public Dispecer() {}

    public Dispecer(String korisnicko_ime, Centar centar) {
        this.korisnicko_ime = korisnicko_ime;
        this.centar = centar;
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

    public Centar getCentar() {
        return centar;
    }

    public void setCentar(Centar centar) {
        this.centar = centar;
    }

    @Override
    public String toString() {
        return "Dispecer{" +
                "korisnicko_ime='" + korisnicko_ime + '\'' +
                ", korisnik=" + korisnik +
                ", centar=" + centar +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dispecer dispecer)) return false;
        return Objects.equals(korisnicko_ime, dispecer.korisnicko_ime) && Objects.equals(korisnik, dispecer.korisnik) && Objects.equals(centar, dispecer.centar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(korisnicko_ime, korisnik, centar);
    }
}
