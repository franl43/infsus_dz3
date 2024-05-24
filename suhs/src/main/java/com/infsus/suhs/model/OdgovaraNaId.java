package com.infsus.suhs.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OdgovaraNaId implements Serializable {

    private String registracija;
    private long intervencijaId;

    public OdgovaraNaId() {}

    public OdgovaraNaId(String registracija, long intervencijaId) {
        this.registracija = registracija;
        this.intervencijaId = intervencijaId;
    }

    public String getRegistracija() {
        return registracija;
    }

    public void setRegistracija(String registracija) {
        this.registracija = registracija;
    }

    public long getIntervencijaId() {
        return intervencijaId;
    }

    public void setIntervencijaId(long intervencijaId) {
        this.intervencijaId = intervencijaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OdgovaraNaId that)) return false;
        return intervencijaId == that.intervencijaId && Objects.equals(registracija, that.registracija);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registracija, intervencijaId);
    }
}
