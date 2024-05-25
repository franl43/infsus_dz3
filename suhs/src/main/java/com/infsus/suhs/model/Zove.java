package com.infsus.suhs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import java.io.Serializable;

//jel treba i id koji se generira redom jer pozivatelj,centar ne mora bit unique?
@Entity
@Table(name = "zove")
public class Zove implements Serializable {

    @EmbeddedId
    @JsonIgnore
    private ZoveId zoveid = new ZoveId();

    @ManyToOne()
    @JoinColumn(name = "oib",referencedColumnName = "oib", insertable = false, updatable = false)
    private Pozivatelj pozivatelj;

    @ManyToOne()
    @JoinColumn(name = "centarid", referencedColumnName = "centarid",insertable = false, updatable = false)
    private Centar centar;

    public Zove() {}

    public Zove(ZoveId zoveid, Pozivatelj pozivatelj, Centar centar) {
        this.zoveid = zoveid;
        this.pozivatelj = pozivatelj;
        this.centar = centar;
    }

    public ZoveId getZoveId() {
        return zoveid;
    }

    public void setZoveId(ZoveId zoveid) {
        this.zoveid = zoveid;
    }

    public Pozivatelj getPozivatelj() {
        return pozivatelj;
    }

    public void setPozivatelj(Pozivatelj pozivatelj) {
        this.pozivatelj = pozivatelj;
    }

    public Centar getCentar() {
        return centar;
    }

    public void setCentar(Centar centar) {
        this.centar = centar;
    }
}
