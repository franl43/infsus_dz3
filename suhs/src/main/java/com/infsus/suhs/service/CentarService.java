package com.infsus.suhs.service;

import com.infsus.suhs.model.Centar;

import java.util.List;
import java.util.Optional;

public interface CentarService {
    Centar saveCentar(Centar centar);
    Optional<Centar> getCentarById(Long id);
    List<Centar> getAllCentar();
    boolean deleteCentarById(Long id);
}
