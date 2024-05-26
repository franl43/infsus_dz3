package com.infsus.suhs.service;

import com.infsus.suhs.model.Vozilo;

import java.util.List;
import java.util.Optional;

public interface VoziloService {
    List<Vozilo> getAllVozilo();
    Optional<Vozilo> getVoziloByRegistracija(String registracija);
    Vozilo saveVozilo(Vozilo vozilo);
    boolean deleteVoziloByRegistracija(String registracija);
}
