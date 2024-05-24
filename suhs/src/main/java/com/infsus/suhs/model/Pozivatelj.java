package com.infsus.suhs.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "pozivatelj")
public class Pozivatelj {

    @Id
    @Column(name = "oib")
    private String oib;

    @Column(name = "ime")
    private String ime;

    @Column(name = "prezime")
    private String prezime;

    @Column(name = "broj")
    private String broj;

    public Pozivatelj() {}

    public Pozivatelj(String oib, String ime, String prezime, String broj) {
        this.oib = oib;
        this.ime = ime;
        this.prezime = prezime;
        this.broj = broj;
    }

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
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

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    @Override
    public String toString() {
        return "Pozivatelj{" +
                "oib=" + oib +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", broj='" + broj + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pozivatelj that)) return false;
        return oib == that.oib && Objects.equals(ime, that.ime) && Objects.equals(prezime, that.prezime) && Objects.equals(broj, that.broj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oib, ime, prezime, broj);
    }
}
