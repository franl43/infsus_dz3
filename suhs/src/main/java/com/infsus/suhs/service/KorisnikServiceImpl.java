package com.infsus.suhs.service;

import com.infsus.suhs.model.Korisnik;
import com.infsus.suhs.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KorisnikServiceImpl implements KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    public KorisnikServiceImpl(KorisnikRepository korisnikRepository) {
        this.korisnikRepository = korisnikRepository;
    }

    @Override
    public Korisnik saveKorisnik(Korisnik korisnik) {
        return korisnikRepository.save(korisnik);
    }

    @Override
    public Optional<Korisnik> getKorisnikByKorisnickoIme(String korisnickoIme) {
        return korisnikRepository.findById(korisnickoIme);
    }

    @Override
    public List<Korisnik> getAllKorisnik(){
        return korisnikRepository.findAll();
    }

    @Override
    public boolean deleteKorisnikByKorisnickoIme(String korisnickoIme) {
        if (korisnikRepository.existsById(korisnickoIme)) {
            korisnikRepository.deleteById(korisnickoIme);
            return true;
        }
        return false;
    }
}
