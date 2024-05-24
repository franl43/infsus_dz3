package com.infsus.suhs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "adresa")
public class Adresa implements Serializable {

    @EmbeddedId
    @JsonIgnore
    private AdresaId adresaId = new AdresaId();

    @Column(name = "koordinate")
    private String koordinate;

    @ManyToOne
    @JoinColumn(name = "centarid", referencedColumnName = "centarid")
    private Centar centar;

    public Adresa() {}

    public Adresa(AdresaId adresaId, String koordinate, Centar centar) {
        this.adresaId = adresaId;
        this.koordinate = koordinate;
        this.centar = centar;
    }

    public AdresaId getAdresaId() {
        return adresaId;
    }

    public void setAdresaId(AdresaId adresaId) {
        this.adresaId = adresaId;
    }

    public String getKoordinate() {
        return koordinate;
    }

    public void setKoordinate(String koordinate) {
        this.koordinate = koordinate;
    }

    public Centar getCentar() {
        return centar;
    }

    public void setCentar(Centar centar) {
        this.centar = centar;
    }

    @Override
    public String toString() {
        return "Adresa{" +
                "adresaId=" + adresaId +
                ", koordinate='" + koordinate + '\'' +
                ", centar=" + centar +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Adresa adresa)) return false;
        return Objects.equals(adresaId, adresa.adresaId) && Objects.equals(koordinate, adresa.koordinate) && Objects.equals(centar, adresa.centar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adresaId, koordinate, centar);
    }
}
