package com.infsus.suhs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "korisnik")
public class Korisnik {

    @Id
    @Column(name = "korisnickoime")
    private String korisnickoime;

    @Column(name = "ime")
    private String ime;

    @Column(name = "prezime")
    private String prezime;


    @Column(name = "lozinka")
    @JsonIgnore
    private String lozinka;

    @Column(name = "uloga")
    private String uloga;

    public Korisnik() {}

    public Korisnik(String korisnickoime, String ime, String prezime, String lozinka, String uloga) {
        this.korisnickoime = korisnickoime;
        this.ime = ime;
        this.prezime = prezime;
        this.lozinka = lozinka;
        this.uloga = uloga;
    }

    public String getKorisnicko_ime() {
        return korisnickoime;
    }

    public void setKorisnickoIme(String korisnickoime) {
        this.korisnickoime = korisnickoime;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getUloga() {
        return uloga;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }

    @Override
    public String toString() {
        return "Korisnik{" +
                "korisnicko_ime='" + korisnickoime + '\'' +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                //", lozinka='" + lozinka + '\'' +
                ", uloga='" + uloga + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Korisnik korisnik)) return false;
        return Objects.equals(korisnickoime, korisnik.korisnickoime) && Objects.equals(ime, korisnik.ime) && Objects.equals(prezime, korisnik.prezime) && Objects.equals(lozinka, korisnik.lozinka) && Objects.equals(uloga, korisnik.uloga);
    }

    @Override
    public int hashCode() {
        return Objects.hash(korisnickoime, ime, prezime, lozinka, uloga);
    }
}
