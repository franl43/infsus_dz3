package com.infsus.suhs.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OdgovaraNaId implements Serializable {

    private String registracija;
    private long intervencijaid;

    public OdgovaraNaId() {}

    public OdgovaraNaId(String registracija, long intervencijaid) {
        this.registracija = registracija;
        this.intervencijaid = intervencijaid;
    }

    public String getRegistracija() {
        return registracija;
    }

    public void setRegistracija(String registracija) {
        this.registracija = registracija;
    }

    public long getIntervencijaId() {
        return intervencijaid;
    }

    public void setIntervencijaId(long intervencijaId) {
        this.intervencijaid = intervencijaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OdgovaraNaId that)) return false;
        return intervencijaid == that.intervencijaid && Objects.equals(registracija, that.registracija);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registracija, intervencijaid);
    }
}
