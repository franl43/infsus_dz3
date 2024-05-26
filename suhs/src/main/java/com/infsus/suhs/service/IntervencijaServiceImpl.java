package com.infsus.suhs.service;

import com.infsus.suhs.model.Intervencija;
import com.infsus.suhs.repository.IntervencijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IntervencijaServiceImpl implements IntervencijaService {

    @Autowired
    private IntervencijaRepository intervencijaRepository;

    public IntervencijaServiceImpl(IntervencijaRepository intervencijaRepository) {
        this.intervencijaRepository = intervencijaRepository;
    }

    @Override
    public List<Intervencija> getAllIntervencija() {
        return intervencijaRepository.findAll();
    }

    @Override
    public Optional<Intervencija> getIntervencijaById(Long id) {
        return intervencijaRepository.findById(id);
    }

    @Override
    public void deleteIntervencija(Long id) {
        intervencijaRepository.deleteById(id);
    }
}
