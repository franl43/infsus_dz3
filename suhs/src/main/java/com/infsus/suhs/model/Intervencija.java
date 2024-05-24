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
    private long intervencijaId;

    @Column(name = "dat_vr")
    private Date dat_vr;

    @Column(name = "opis")
    private String opis;

    //ovo ne znam kak da spojim s adresom
    @ManyToOne
    @JoinColumn(name = "adresaid", referencedColumnName = "adresaid")
    private Adresa adresa;

    @ManyToOne
    @JoinColumn(name = "centarid", referencedColumnName = "centarid")
    private Centar centar;

    public Intervencija() {
    }

    public long getIntervencijaId() {
        return intervencijaId;
    }

    public void setIntervencijaId(long intervencijaId) {
        this.intervencijaId = intervencijaId;
    }

    public Date getDat_vr() {
        return dat_vr;
    }

    public void setDat_vr(Date dat_vr) {
        this.dat_vr = dat_vr;
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
}
