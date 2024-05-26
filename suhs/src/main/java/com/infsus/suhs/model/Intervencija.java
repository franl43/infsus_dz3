package com.infsus.suhs.model;

import jakarta.persistence.*;

import java.util.Date;

//nije dovrseno zbog adrese
@Entity
@Table(name = "intervencija")
public class Intervencija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "intervencijaid")
    private long intervencijaid;

    @Column(name = "datvr")
    private Date datvr;

    @Column(name = "opis")
    private String opis;

    @Embedded
    private AdresaId adresaId;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "grad", referencedColumnName = "grad", insertable = false, updatable = false),
            @JoinColumn(name = "pbroj", referencedColumnName = "pbroj", insertable = false, updatable = false),
            @JoinColumn(name = "naziv", referencedColumnName = "naziv", insertable = false, updatable = false)
    })
    private Adresa adresa;

    @ManyToOne
    @JoinColumn(name = "centarid", referencedColumnName = "centarid")
    private Centar centar;

    public Intervencija() {
    }

    public Intervencija(Long intervencijaid, Date datvr, String opis, Adresa adresa, Centar centar) {
        this.intervencijaid = intervencijaid;
        this.datvr = datvr;
        this.opis = opis;
        this.adresa = adresa;
        this.centar = centar;
    }

    public Long getIntervencijaId() {
        return intervencijaid;
    }

    public void setIntervencijaId(long intervencijaid) {
        this.intervencijaid = intervencijaid;
    }

    public Date getDatVr() {
        return datvr;
    }

    public void setDatVr(Date datvr) {
        this.datvr = datvr;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Centar getCentar() {
        return centar;
    }

    public void setCentar(Centar centar) {
        this.centar = centar;
    }

    public Date getDatvr() {
        return datvr;
    }

    public void setDatvr(Date datvr) {
        this.datvr = datvr;
    }

    public Adresa getAdresa() {
        return adresa;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    }
}
