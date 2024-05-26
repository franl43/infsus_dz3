package com.infsus.suhs.service;

import com.infsus.suhs.model.Intervencija;

import java.util.List;
import java.util.Optional;

public interface IntervencijaService {
    Optional<Intervencija> getIntervencijaById(Long id);

    List<Intervencija> getAllIntervencija();

    Intervencija saveIntervencija(Intervencija intervencija);

    boolean deleteIntervencijaById(Long id);
}
