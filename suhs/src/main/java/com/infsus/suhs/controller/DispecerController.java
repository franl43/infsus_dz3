package com.infsus.suhs.controller;


import com.infsus.suhs.model.Dispecer;
import com.infsus.suhs.model.Korisnik;
import com.infsus.suhs.model.Pozivatelj;
import com.infsus.suhs.service.DispecerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:3000/"}, allowCredentials = "true")
@RequestMapping("/dispecer")
public class DispecerController {

    @Autowired
    private DispecerService dispecerService;

    //@PutMapping("/addNew")

    @GetMapping("/getAll")
    public List<Dispecer> getAllDispecer() {
        return dispecerService.getAllDispecer();
    }

    @GetMapping("/getByKorisnickoIme/{korisnicko_ime}")
    public Optional<Dispecer> getDispecerByKorisnickoIme(@PathVariable(value = "korisnicko_ime") String korisnicko_ime) {
        return dispecerService.getDispecerByKorisnickoIme(korisnicko_ime);
    }


}
