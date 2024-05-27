package com.infsus.suhs.service;

import com.infsus.suhs.model.ClanHitneSluzbe;
import com.infsus.suhs.repository.ClanHitneSluzbeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClanHitneSluzbeServiceImpl implements ClanHitneSluzbeService {

    @Autowired
    private ClanHitneSluzbeRepository clanHitneSluzbeRepository;

    public ClanHitneSluzbeServiceImpl(ClanHitneSluzbeRepository clanHitneSluzbeRepository) {
        this.clanHitneSluzbeRepository = clanHitneSluzbeRepository;
    }

    @Override
    public List<ClanHitneSluzbe> getAllClanHitneSlube() {
        return clanHitneSluzbeRepository.findAll();
    }
}
