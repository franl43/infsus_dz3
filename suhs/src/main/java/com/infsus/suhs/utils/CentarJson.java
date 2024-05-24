package com.infsus.suhs.utils;


public class CentarJson {

    private String broj;
    private int kapacitet;

    public CentarJson(String broj, int kapacitet) {
        this.broj = broj;
        this.kapacitet = kapacitet;
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
}
