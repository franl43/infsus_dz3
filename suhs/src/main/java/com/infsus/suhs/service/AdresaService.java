package com.infsus.suhs.service;

import com.infsus.suhs.model.Adresa;
import com.infsus.suhs.model.AdresaId;

import java.util.List;
import java.util.Optional;

public interface AdresaService {

    Adresa saveAdresa(Adresa adresa);

    List<Adresa> getAllAdresa();

    boolean deleteAdresaById(AdresaId id);

    Optional<Adresa> getAdresaById(AdresaId adresaId);
}
