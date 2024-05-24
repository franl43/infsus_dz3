package com.infsus.suhs.service;

import com.infsus.suhs.model.Pozivatelj;

import java.util.List;
import java.util.Optional;

public interface PozivateljService {
    Pozivatelj savePozivatelj(Pozivatelj pozivatelj);
    List<Pozivatelj> getAllPozivatelj();
    Optional<Pozivatelj> getPozivateljByOIB(String OIB);
    boolean deletePozivateljByOIB(String oib);
}
