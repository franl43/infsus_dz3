package com.infsus.suhs.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "")
public class Izvjestaj {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "izvjestajid")
    private long izvjestajId;

    @Column(name = "sadrzaj")
    private String sadrzaj;

    @Column(name = "dat_vr")
    private Date dat_vr;

    @ManyToOne
    @JoinColumn(name = "intervencijaid", referencedColumnName = "intervencijaid")
    private Intervencija intervencija;

    public Izvjestaj() {}

    public Izvjestaj(long izvjestajId, String sadrzaj, Date dat_vr, Intervencija intervencija) {
        this.izvjestajId = izvjestajId;
        this.sadrzaj = sadrzaj;
        this.dat_vr = dat_vr;
        this.intervencija = intervencija;
    }

    public long getIzvjestajId() {
        return izvjestajId;
    }

    public void setIzvjestajId(long izvjestajId) {
        this.izvjestajId = izvjestajId;
    }

    public String getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public Date getDat_vr() {
        return dat_vr;
    }

    public void setDat_vr(Date dat_vr) {
        this.dat_vr = dat_vr;
    }

    public Intervencija getIntervencija() {
        return intervencija;
    }

    public void setIntervencija(Intervencija intervencija) {
        this.intervencija = intervencija;
    }

    @Override
    public String toString() {
        return "Izvjestaj{" +
                "izvjestajId=" + izvjestajId +
                ", sadrzaj='" + sadrzaj + '\'' +
                ", dat_vr=" + dat_vr +
                ", intervencija=" + intervencija +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Izvjestaj izvjestaj)) return false;
        return izvjestajId == izvjestaj.izvjestajId && Objects.equals(sadrzaj, izvjestaj.sadrzaj) && Objects.equals(dat_vr, izvjestaj.dat_vr) && Objects.equals(intervencija, izvjestaj.intervencija);
    }

    @Override
    public int hashCode() {
        return Objects.hash(izvjestajId, sadrzaj, dat_vr, intervencija);
    }
}
