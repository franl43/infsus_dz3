package com.infsus.suhs.model;


import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AdresaId implements Serializable {

    private String grad;
    private int p_broj;
    private String naziv;

    public AdresaId() {}

    public AdresaId(String grad, int p_broj, String naziv) {
        this.grad = grad;
        this.p_broj = p_broj;
        this.naziv = naziv;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public int getP_broj() {
        return p_broj;
    }

    public void setP_broj(int p_broj) {
        this.p_broj = p_broj;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdresaId adresaId)) return false;
        return p_broj == adresaId.p_broj && Objects.equals(grad, adresaId.grad) && Objects.equals(naziv, adresaId.naziv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grad, p_broj, naziv);
    }
}
