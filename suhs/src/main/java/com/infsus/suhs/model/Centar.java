package com.infsus.suhs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.List;

@Entity
@Table(name = "centar")
public class Centar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "centarid")
    private long centarId;

    @Column(name = "broj")
    @JsonIgnore
    private String broj;

    @Column(name = "kapacitet")
    private int kapacitet;

    /*----------------------nez jel ovo treba----------------------------*/

    @OneToMany(mappedBy = "centar")
    @JsonIgnore
    List<Zove> pozivi;

    public List<Zove> getPozivi() {
        return pozivi;
    }

    public void setPozivi(List<Zove> pozivi) {
        this.pozivi = pozivi;
    }

    /*----------------------------------------------------------------*/

    public Centar() {}

    public Centar(String broj, int kapacitet) {
        this.broj = broj;
        this.kapacitet = kapacitet;
    }

    public long getCentarId() {
        return centarId;
    }

    public void setCentarId(long centarId) {
        this.centarId = centarId;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }

    @Override
    public String toString() {
        return "Centar{" +
                "centarId=" + centarId +
                ", broj='" + broj + '\'' +
                ", kapacitet=" + kapacitet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Centar centar)) return false;
        return centarId == centar.centarId && kapacitet == centar.kapacitet && Objects.equals(broj, centar.broj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(centarId, broj, kapacitet);
    }
}
