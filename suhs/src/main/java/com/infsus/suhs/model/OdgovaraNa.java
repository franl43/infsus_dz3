package com.infsus.suhs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "odgovarana")
public class OdgovaraNa {
    @EmbeddedId
    @JsonIgnore
    private OdgovaraNaId odgovaraNaId = new OdgovaraNaId();

    @ManyToOne()
    @JoinColumn(name = "registracija",referencedColumnName = "registracija", insertable = false, updatable = false)
    private Vozilo vozilo;

    @ManyToOne()
    @JoinColumn(name = "intervencijaid",referencedColumnName = "intervencijaid", insertable = false, updatable = false)
    private Intervencija intervencija;

    public OdgovaraNa() {}

    public OdgovaraNa(OdgovaraNaId odgovaraNaId, Vozilo vozilo, Intervencija intervencija) {
        this.odgovaraNaId = odgovaraNaId;
        this.vozilo = vozilo;
        this.intervencija = intervencija;
    }

    public OdgovaraNaId getOdgovaraNaId() {
        return odgovaraNaId;
    }

    public void setOdgovaraNaId(OdgovaraNaId odgovaraNaId) {
        this.odgovaraNaId = odgovaraNaId;
    }

    public Vozilo getVozilo() {
        return vozilo;
    }

    public void setVozilo(Vozilo vozilo) {
        this.vozilo = vozilo;
    }

    public Intervencija getIntervencija() {
        return intervencija;
    }

    public void setIntervencija(Intervencija intervencija) {
        this.intervencija = intervencija;
    }
}
