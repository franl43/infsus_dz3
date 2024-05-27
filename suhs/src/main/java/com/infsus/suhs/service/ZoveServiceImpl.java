package com.infsus.suhs.service;

import com.infsus.suhs.model.Pozivatelj;
import com.infsus.suhs.model.Zove;
import com.infsus.suhs.model.ZoveId;
import com.infsus.suhs.repository.ZoveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZoveServiceImpl implements ZoveService {

    @Autowired
    private ZoveRepository zoveRepository;

    public ZoveServiceImpl(ZoveRepository zoveRepository) {
        this.zoveRepository = zoveRepository;
    }

    @Override
    public List<Zove> getAllZove() {
        return zoveRepository.findAll();
    }

    @Override
    public Optional<Zove> getZoveById(ZoveId zoveId) {
        return zoveRepository.findById(zoveId);
    }

    @Override
    public Zove saveZove(Zove zove) {
        return zoveRepository.save(zove);
    }

    @Override
    public boolean deleteZoveById(ZoveId zoveId) {
        if (zoveRepository.existsById(zoveId)) {
            zoveRepository.deleteById(zoveId);
            return true;
        }
        return false;
    }

    public List<Zove> getZoveByPozivatelj(String oib) {
        return zoveRepository.findAll()
                .stream().filter(zove -> zove.getZoveId().getOib().equals(oib))
                .toList();
    }

    public List<Zove> getZoveByCentar(Long centarId) {
        return zoveRepository.findAll()
                .stream().filter(zove -> zove.getCentar().getCentarid() == centarId)
                .toList();
    }
}
