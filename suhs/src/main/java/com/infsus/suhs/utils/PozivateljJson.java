package com.infsus.suhs.utils;

public class PozivateljJson {

    private String OIB;
    private String ime;
    private String prezime;
    private String broj;

    public PozivateljJson(String OIB, String ime, String prezime, String broj) {
        this.OIB = OIB;
        this.ime = ime;
        this.prezime = prezime;
        this.broj = broj;
    }

    public String getOIB() {
        return OIB;
    }

    public void setOIB(String OIB) {
        this.OIB = OIB;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }
}
