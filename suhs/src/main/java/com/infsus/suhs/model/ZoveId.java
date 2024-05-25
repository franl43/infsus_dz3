package com.infsus.suhs.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class ZoveId implements Serializable {

    private String oib;
    private Long centarid;
    private Date dat_vr;

    public ZoveId() {}

    public ZoveId(String oib, Long centarId) {
        this.oib = oib;
        this.centarid = centarId;
        this.dat_vr = new Date();
    }

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public Long getCentarId() {
        return centarid;
    }

    public void setCentarId(Long centarid) {
        this.centarid = centarid;
    }

    public Date getDat_vr() {
        return dat_vr;
    }

    public void setDat_vr(Date dat_vr) {
        this.dat_vr = dat_vr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ZoveId zoveId)) return false;
        return Objects.equals(oib, zoveId.oib) && Objects.equals(centarid, zoveId.centarid) && Objects.equals(dat_vr, zoveId.dat_vr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oib, centarid, dat_vr);
    }
}
