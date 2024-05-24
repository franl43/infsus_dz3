package com.infsus.suhs.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ZoveId implements Serializable {

    private String oib;
    private long centarId;

    public ZoveId() {}

    public ZoveId(String oib, long centarId) {
        this.oib = oib;
        this.centarId = centarId;
    }

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public long getCentarId() {
        return centarId;
    }

    public void setCentarId(long centarId) {
        this.centarId = centarId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ZoveId zoveId)) return false;
        return centarId == zoveId.centarId && Objects.equals(oib, zoveId.oib);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oib, centarId);
    }
}
