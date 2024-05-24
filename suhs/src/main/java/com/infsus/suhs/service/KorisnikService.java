package com.infsus.suhs.service;

import com.infsus.suhs.model.Korisnik;

import java.util.List;
import java.util.Optional;

public interface KorisnikService {

    Korisnik saveKorisnik(Korisnik korisnik);

    Optional<Korisnik> getKorisnikByKorisnickoIme(String korisnickoIme);

    List<Korisnik> getAllKorisnik();

    boolean deleteKorisnikByKorisnickoIme(String korisnickoIme);
}
