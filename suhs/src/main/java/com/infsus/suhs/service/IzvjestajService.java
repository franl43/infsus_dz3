package com.infsus.suhs.service;

import com.infsus.suhs.model.Izvjestaj;

import java.util.List;
import java.util.Optional;

public interface IzvjestajService {
    List<Izvjestaj> getAllIzvjestaj();
    Optional<Izvjestaj> getIzvjestajById(Long id);
}
