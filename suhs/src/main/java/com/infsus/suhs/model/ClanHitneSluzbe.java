package com.infsus.suhs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "clanhitnesluzbe")
public class ClanHitneSluzbe {

    @Id
    @Column(name = "korisnickoime")
    private String korisnickoime;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="korisnickoime", referencedColumnName = "korisnickoime")
    @JsonIgnore
    private Korisnik korisnik;

    @ManyToOne
    @JoinColumn(name = "registracija", referencedColumnName = "registracija")
    private Vozilo vozilo;

    public ClanHitneSluzbe() {}

    public ClanHitneSluzbe(String korisnickoime, Korisnik korisnik, Vozilo vozilo) {
        this.korisnickoime = korisnickoime;
        this.korisnik = korisnik;
        this.vozilo = vozilo;
    }

    public String getKorisnickoIme() { return korisnickoime; }

    public void setKorisnickoIme(String korisnicko_ime) {
        this.korisnickoime = korisnicko_ime;
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
                "korisnicko_ime='" + korisnickoime + '\'' +
                ", korisnik=" + korisnik +
                ", vozilo=" + vozilo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClanHitneSluzbe that)) return false;
        return Objects.equals(korisnickoime, that.korisnickoime) && Objects.equals(korisnik, that.korisnik) && Objects.equals(vozilo, that.vozilo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(korisnickoime, korisnik, vozilo);
    }
}
