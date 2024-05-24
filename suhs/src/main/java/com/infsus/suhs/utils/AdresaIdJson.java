package com.infsus.suhs.utils;

public class AdresaIdJson {

    private String grad;
    private int p_broj;
    private String naziv;

    public AdresaIdJson(String grad, int p_broj, String naziv) {
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
}
