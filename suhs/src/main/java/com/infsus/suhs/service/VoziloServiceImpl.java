package com.infsus.suhs.service;

import com.infsus.suhs.model.Vozilo;
import com.infsus.suhs.repository.VoziloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoziloServiceImpl implements VoziloService {

    @Autowired
    private VoziloRepository voziloRepository;

    @Override
    public List<Vozilo> getAllAvailableVozila() {
        return voziloRepository.findAll()
                .stream().filter(Vozilo::getStatus).toList();
    }
}
