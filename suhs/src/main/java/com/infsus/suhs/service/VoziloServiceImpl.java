package com.infsus.suhs.service;

import com.infsus.suhs.model.Pozivatelj;
import com.infsus.suhs.model.Vozilo;
import com.infsus.suhs.repository.VoziloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class VoziloServiceImpl implements VoziloService {

    @Autowired
    private VoziloRepository voziloRepository;

    public VoziloServiceImpl(VoziloRepository voziloRepository) {
        this.voziloRepository = voziloRepository;
    }

    @Override
    public List<Vozilo> getAllVozilo() {
        return voziloRepository.findAll();
    }

    @Override
    public Optional<Vozilo> getVoziloByRegistracija(String registracija) {
        return voziloRepository.findById(registracija);
    }

    @Override
    public Vozilo saveVozilo(Vozilo vozilo) {
        return voziloRepository.save(vozilo);
    }

    @Override
    public boolean deleteVoziloByRegistracija(String registracija) {
        if (voziloRepository.existsById(registracija)) {
            voziloRepository.deleteById(registracija);
            return true;
        }
        return false;
    }


}
