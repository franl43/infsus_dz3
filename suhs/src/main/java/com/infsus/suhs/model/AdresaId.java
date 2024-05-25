package com.infsus.suhs.model;


import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AdresaId implements Serializable {

    private String grad;
    private int pbroj;
    private String naziv;

    public AdresaId() {}

    public AdresaId(String grad, int pbroj, String naziv) {
        this.grad = grad;
        this.pbroj = pbroj;
        this.naziv = naziv;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public int getPBroj() {
        return pbroj;
    }

    public void setPBroj(int pbroj) {
        this.pbroj = pbroj;
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
        return pbroj == adresaId.pbroj && Objects.equals(grad, adresaId.grad) && Objects.equals(naziv, adresaId.naziv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grad, pbroj, naziv);
    }
}
