package com.infsus.suhs.service;

import com.infsus.suhs.model.Izvjestaj;
import com.infsus.suhs.repository.IzvjestajRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IzvjestajServiceImpl implements IzvjestajService {

    @Autowired
    private IzvjestajRepository izvjestajRepository;

    public IzvjestajServiceImpl(IzvjestajRepository izvjestajRepository) {
        this.izvjestajRepository = izvjestajRepository;
    }

    @Override
    public List<Izvjestaj> getAllIzvjestaj() {
        return izvjestajRepository.findAll();
    }

    @Override
    public Optional<Izvjestaj> getIzvjestajById(Long id) {
        return izvjestajRepository.findById(id);
    }

    @Override
    public Izvjestaj saveIzvjestaj(Izvjestaj izvjestaj) {
        return izvjestajRepository.save(izvjestaj);
    }

    @Override
    public void deleteIzvjestajById(Long id) { izvjestajRepository.deleteById(id); }
}
