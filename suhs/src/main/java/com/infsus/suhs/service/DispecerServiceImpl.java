package com.infsus.suhs.service;

import com.infsus.suhs.model.Dispecer;
import com.infsus.suhs.repository.DispecerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DispecerServiceImpl implements DispecerService {

    @Autowired
    private DispecerRepository dispecerRepository;

    public DispecerServiceImpl(DispecerRepository dispecerRepository) {
        this.dispecerRepository = dispecerRepository;
    }

    @Override
    public List<Dispecer> getAllDispecer() {
        return dispecerRepository.findAll();
    }

    @Override
    public Optional<Dispecer> getDispecerByKorisnickoIme(String korisnicko_ime) {
        return dispecerRepository.findById(korisnicko_ime);
    }
}
