package com.infsus.suhs.utils;

public class KorisnikJson {
    private String korisnicko_ime;
    private String ime;
    private String prezime;
    private String lozinka;
    private String uloga;

    public KorisnikJson(String korisnicko_ime, String ime, String prezime, String lozinka, String uloga) {
        this.korisnicko_ime = korisnicko_ime;
        this.ime = ime;
        this.prezime = prezime;
        this.lozinka = lozinka;
        this.uloga = uloga;
    }

    public String getKorisnicko_ime() {
        return korisnicko_ime;
    }

    public void setKorisnicko_ime(String korisnicko_ime) {
        this.korisnicko_ime = korisnicko_ime;
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

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getUloga() {
        return uloga;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }
}
