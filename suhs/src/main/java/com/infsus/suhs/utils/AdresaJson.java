package com.infsus.suhs.utils;

public class AdresaJson {

    private String grad;
    private int p_broj;
    private String naziv;
    private String koordinate;
    private Long centar;

    public AdresaJson(String grad, int p_broj, String naziv, String koordinate, Long centar) {
        this.grad = grad;
        this.p_broj = p_broj;
        this.naziv = naziv;
        this.koordinate = koordinate;
        this.centar = centar;
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

    public String getKoordinate() {
        return koordinate;
    }

    public void setKoordinate(String koordinate) {
        this.koordinate = koordinate;
    }

    public Long getCentar() {
        return centar;
    }

    public void setCentar(Long centar) {
        this.centar = centar;
    }
}
