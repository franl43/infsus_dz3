package com.infsus.suhs.controller;

import com.infsus.suhs.model.Zove;
import com.infsus.suhs.service.CentarService;
import com.infsus.suhs.service.PozivateljService;
import com.infsus.suhs.service.ZoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//dovrsi

@RestController
@CrossOrigin(origins = {"http://localhost:3000/"}, allowCredentials = "true")
@RequestMapping("/zove")
public class ZoveController {

    @Autowired
    private ZoveService zoveService;

    @Autowired
    private PozivateljService pozivateljService;

    @Autowired
    private CentarService centarService;

    @GetMapping("/getAll")
    public List<Zove> getAllZove() {
        return zoveService.getAllZove();
    }



}
