package com.infsus.suhs.service;

import com.infsus.suhs.model.Pozivatelj;
import com.infsus.suhs.model.Zove;
import com.infsus.suhs.model.ZoveId;

import java.util.List;
import java.util.Optional;

public interface ZoveService {
    List<Zove> getAllZove();

    Zove saveZove(Zove zove);

    boolean deleteZoveById(ZoveId zoveId);

    Optional<Zove> getZoveById(ZoveId zoveId);

    List<Zove> getZoveByPozivatelj(String oib);

    List<Zove> getZoveByCentar(Long centarId);
}
