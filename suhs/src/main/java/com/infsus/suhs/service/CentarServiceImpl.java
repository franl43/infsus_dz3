package com.infsus.suhs.service;

import com.infsus.suhs.model.Centar;
import com.infsus.suhs.model.Pozivatelj;
import com.infsus.suhs.repository.CentarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CentarServiceImpl implements CentarService {

    @Autowired
    private CentarRepository centarRepository;

    public CentarServiceImpl(CentarRepository centarRepository) {
        this.centarRepository = centarRepository;
    }
    @Override
    public Centar saveCentar(Centar centar) {
        return centarRepository.save(centar);
    }

    @Override
    public Optional<Centar> getCentarById(Long id) {
        return centarRepository.findById(id);
    }

    @Override
    public List<Centar> getAllCentar() {
        return centarRepository.findAll();
    }

    @Override
    public boolean deleteCentarById(Long id) {
        if (centarRepository.existsById(id)) {
            centarRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
