package com.infsus.suhs.service;

import com.infsus.suhs.model.OdgovaraNa;
import com.infsus.suhs.model.OdgovaraNaId;

import java.util.List;
import java.util.Optional;

public interface OdgovaraNaService {
    OdgovaraNa saveOdgovaraNa(OdgovaraNa odgovaraNa);

    List<OdgovaraNa> getAllOdgovaraNa();

    Optional<OdgovaraNa> getOdgovaraNaById(OdgovaraNaId odgovaraNaId);

    List<OdgovaraNa> getOdgovaraNaByIntervencija(Long id);

    List<OdgovaraNa> getOdgovaraNaByVozilo(String registracija);

    boolean deleteOdgovaraNaById(OdgovaraNaId odgovaraNaId);
}
