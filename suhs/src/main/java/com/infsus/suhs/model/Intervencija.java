package com.infsus.suhs.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//nije dovrseno zbog adrese
@Entity
@Table(name = "intervencija")
public class Intervencija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "intervencijaid")
    private long intervencijaid;

    @Column(name = "datvr")
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date datvr;

    @Column(name = "opis")
    private String opis;

    //ovo ne znam kak da spojim s adresom
    @Embedded
    private AdresaId adresaid;

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

    /*--------------------------------------------------------------------------------*/
    @OneToMany(mappedBy = "intervencija")
    private List<Izvjestaj> izvjestaji = new ArrayList<>();

    public List<Izvjestaj> getIzvjestaji() {
        return izvjestaji;
    }

    public void setIzvjestaji(List<Izvjestaj> izvjestaji) {
        this.izvjestaji = izvjestaji;
    }

    /*--------------------------------------------------------------------------------*/

    /*--------------------------------------------------------------------------------*/
    @OneToMany(mappedBy = "intervencija")
    private List<OdgovaraNa> odgovori = new ArrayList<>();

    public List<OdgovaraNa> getOdgovori() {
        return odgovori;
    }

    public void setOdgovori(List<OdgovaraNa> odgovori) {
        this.odgovori = odgovori;
    }

    /*--------------------------------------------------------------------------------*/

    public Intervencija() {
    }

    public long getIntervencijaid() {
        return intervencijaid;
    }

    public void setIntervencijaid(long intervencijaid) {
        this.intervencijaid = intervencijaid;
    }

    public Date getDatvr() {
        return datvr;
    }

    public void setDatvr(Date datvr) {
        this.datvr = datvr;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public AdresaId getAdresaid() {
        return adresaid;
    }

    public void setAdresaid(AdresaId adresaid) {
        this.adresaid = adresaid;
    }

    public Adresa getAdresa() {
        return adresa;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    }

    public Centar getCentar() {
        return centar;
    }

    public void setCentar(Centar centar) {
        this.centar = centar;
    }

    @Override
    public String toString() {
        return String.format("Intervencija %d-%s", intervencijaid, opis);
    }
}
