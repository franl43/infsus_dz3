package com.infsus.suhs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "dispecer")
public class Dispecer {

    @Id
    @Column(name = "korisnickoime")
    private String korisnickoime;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="korisnickoime", referencedColumnName = "korisnickoime")
    @JsonIgnore
    private Korisnik korisnik;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "centarid", referencedColumnName = "centarid")
    private Centar centar;

    public Dispecer() {}

    public Dispecer(String korisnickoime, Centar centar) {
        this.korisnickoime = korisnickoime;
        this.centar = centar;
    }

    public String getKorisnickoIme() {
        return korisnickoime;
    }

    public void setKorisnickoIme(String korisnickoime) {
        this.korisnickoime = korisnickoime;
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
                "korisnicko_ime='" + korisnickoime + '\'' +
                ", korisnik=" + korisnik +
                ", centar=" + centar +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dispecer dispecer)) return false;
        return Objects.equals(korisnickoime, dispecer.korisnickoime) && Objects.equals(korisnik, dispecer.korisnik) && Objects.equals(centar, dispecer.centar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(korisnickoime, korisnik, centar);
    }
}
