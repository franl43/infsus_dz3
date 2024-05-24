package com.infsus.suhs.service;

import com.infsus.suhs.model.Zove;
import com.infsus.suhs.repository.ZoveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
