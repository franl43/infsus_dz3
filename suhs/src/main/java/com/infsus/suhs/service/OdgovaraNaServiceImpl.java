package com.infsus.suhs.service;

import com.infsus.suhs.model.OdgovaraNa;
import com.infsus.suhs.model.OdgovaraNaId;
import com.infsus.suhs.model.ZoveId;
import com.infsus.suhs.repository.OdgovaraNaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdgovaraNaServiceImpl implements OdgovaraNaService {

    @Autowired
    private OdgovaraNaRepository odgovaraNaRepository;

    public OdgovaraNaServiceImpl(OdgovaraNaRepository odgovaraNaRepository) {
        this.odgovaraNaRepository = odgovaraNaRepository;
    }

    @Override
    public OdgovaraNa saveOdgovaraNa(OdgovaraNa odgovaraNa) {
        return odgovaraNaRepository.save(odgovaraNa);
    }

    @Override
    public List<OdgovaraNa> getAllOdgovaraNa() {
        return odgovaraNaRepository.findAll();
    }

    @Override
    public Optional<OdgovaraNa> getOdgovaraNaById(OdgovaraNaId odgovaraNaId) {
        return odgovaraNaRepository.findById(odgovaraNaId);
    }

    public List<OdgovaraNa> getOdgovaraNaByIntervencija(Long id) {
        return odgovaraNaRepository.findByIntervencijaIntervencijaId(id);
    }

    public List<OdgovaraNa> getOdgovaraNaByVozilo(String registracija) {
        return odgovaraNaRepository.findByVoziloRegistracija(registracija);
    }

    @Override
    public boolean deleteOdgovaraNaById(OdgovaraNaId odgovaraNaId) {
        if (odgovaraNaRepository.existsById(odgovaraNaId)) {
            odgovaraNaRepository.deleteById(odgovaraNaId);
            return true;
        }
        return false;
    }

}
