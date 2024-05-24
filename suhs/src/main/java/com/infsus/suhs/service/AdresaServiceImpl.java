package com.infsus.suhs.service;

import com.infsus.suhs.model.Adresa;
import com.infsus.suhs.model.AdresaId;
import com.infsus.suhs.repository.AdresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdresaServiceImpl implements AdresaService {

    @Autowired
    private AdresaRepository adresaRepository;

    public AdresaServiceImpl(AdresaRepository adresaRepository) {
        this.adresaRepository = adresaRepository;
    }

    @Override
    public Adresa saveAdresa(Adresa adresa) {
        return adresaRepository.save(adresa);
    }

    @Override
    public List<Adresa> getAllAdresa() {
        return adresaRepository.findAll();
    }

    @Override
    public Optional<Adresa> getAdresaById(AdresaId adresaId) {
        return adresaRepository.findById(adresaId);
    }

    @Override
    public boolean deleteAdresaById(AdresaId id) {
        if (adresaRepository.existsById(id)) {
            adresaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
