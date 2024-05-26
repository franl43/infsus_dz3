package com.infsus.suhs.model;

import jakarta.persistence.Embeddable;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class ZoveId implements Serializable {

    private String oib;
    private Long centarid;
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date datvr;

    public ZoveId() {}

    public ZoveId(String oib, Long centarId) {
        this.oib = oib;
        this.centarid = centarId;
        this.datvr = new Date(new java.util.Date().getTime());
    }

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public Long getCentarid() {
        return centarid;
    }

    public void setCentarid(Long centarid) {
        this.centarid = centarid;
    }

    public Date getDatvr() {
        return datvr;
    }

    public void setDatvr(Date datvr) {
        this.datvr = datvr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZoveId zoveId = (ZoveId) o;
        return Objects.equals(oib, zoveId.oib) && Objects.equals(centarid, zoveId.centarid) && Objects.equals(datvr, zoveId.datvr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oib, centarid, datvr);
    }
}
