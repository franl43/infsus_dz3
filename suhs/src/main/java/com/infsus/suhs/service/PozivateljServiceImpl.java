package com.infsus.suhs.service;

import com.infsus.suhs.model.Pozivatelj;
import com.infsus.suhs.repository.PozivateljRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PozivateljServiceImpl implements PozivateljService {

    @Autowired
    private PozivateljRepository pozivateljRepository;

    public PozivateljServiceImpl(PozivateljRepository pozivateljRepository) {
        this.pozivateljRepository = pozivateljRepository;
    }

    @Override
    public Pozivatelj savePozivatelj(Pozivatelj pozivatelj) {
        return pozivateljRepository.save(pozivatelj);
    }

    @Override
    public List<Pozivatelj> getAllPozivatelj() {
        return pozivateljRepository.findAll();
    }

    @Override
    public Optional<Pozivatelj> getPozivateljByOIB(String OIB) {
        return pozivateljRepository.findById(OIB);
    }

    @Override
    public boolean deletePozivateljByOIB(String oib) {
        if (pozivateljRepository.existsById(oib)) {
            pozivateljRepository.deleteById(oib);
            return true;
        }
        return false;
    }
}
