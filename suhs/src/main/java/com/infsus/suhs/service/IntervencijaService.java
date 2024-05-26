package com.infsus.suhs.service;

import com.infsus.suhs.model.Intervencija;

import java.util.List;
import java.util.Optional;

public interface IntervencijaService {
    List<Intervencija> getAllIntervencija();
    Optional<Intervencija> getIntervencijaById(Long id);
    void deleteIntervencija(Long id);
}
