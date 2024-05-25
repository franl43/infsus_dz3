package com.infsus.suhs.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "izvjestaj")
public class Izvjestaj {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "izvjestajid")
    private long izvjestajid;

    @Column(name = "sadrzaj")
    private String sadrzaj;

    @Column(name = "datvr")
    private Date datvr;

    @ManyToOne
    @JoinColumn(name = "intervencijaid", referencedColumnName = "intervencijaid")
    private Intervencija intervencija;

    @ManyToOne
    @JoinColumn(name = "korisnickoime", referencedColumnName = "korisnickoime")
    private ClanHitneSluzbe clanhitnesluzbe;

    public Izvjestaj() {}

    public Izvjestaj(long izvjestajid, String sadrzaj, Date datvr, Intervencija intervencija, ClanHitneSluzbe clanhitnesluzbe) {
        this.izvjestajid = izvjestajid;
        this.sadrzaj = sadrzaj;
        this.datvr = datvr;
        this.intervencija = intervencija;
        this.clanhitnesluzbe = clanhitnesluzbe;
    }

    public long getIzvjestajId() {
        return izvjestajid;
    }

    public void setIzvjestajId(long izvjestajid) {
        this.izvjestajid = izvjestajid;
    }

    public String getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public Date getDatVr() {
        return datvr;
    }

    public void setDat_vr(Date datvr) {
        this.datvr = datvr;
    }

    public Intervencija getIntervencija() {
        return intervencija;
    }

    public void setIntervencija(Intervencija intervencija) {
        this.intervencija = intervencija;
    }

    public ClanHitneSluzbe getClanHitneSluzbe() {
        return clanhitnesluzbe;
    }

    public void setClanHitneSluzbe(ClanHitneSluzbe clanhitnesluzbe) {
        this.clanhitnesluzbe = clanhitnesluzbe;
    }

    @Override
    public String toString() {
        return "Izvjestaj{" +
                "izvjestajId=" + izvjestajid +
                ", sadrzaj='" + sadrzaj + '\'' +
                ", dat_vr=" + datvr +
                ", intervencija=" + intervencija +
                ", clanHitneSluzbe=" + clanhitnesluzbe +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Izvjestaj izvjestaj)) return false;
        return izvjestajid == izvjestaj.izvjestajid && Objects.equals(sadrzaj, izvjestaj.sadrzaj) && Objects.equals(datvr, izvjestaj.datvr) && Objects.equals(intervencija, izvjestaj.intervencija) && Objects.equals(clanhitnesluzbe, izvjestaj.clanhitnesluzbe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(izvjestajid, sadrzaj, datvr, intervencija, clanhitnesluzbe);
    }
}
