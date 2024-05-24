package com.infsus.suhs.service;

import com.infsus.suhs.model.Dispecer;
import com.infsus.suhs.model.Pozivatelj;

import java.util.List;
import java.util.Optional;

public interface DispecerService {
    List<Dispecer> getAllDispecer();

    Optional<Dispecer> getDispecerByKorisnickoIme(String korisnicko_ime);
}
