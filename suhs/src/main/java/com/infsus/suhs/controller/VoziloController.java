package com.infsus.suhs.controller;

import com.infsus.suhs.model.Adresa;
import com.infsus.suhs.model.AdresaId;
import com.infsus.suhs.model.Vozilo;
import com.infsus.suhs.service.AdresaService;
import com.infsus.suhs.service.VoziloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:3000/"}, allowCredentials = "true")
@RequestMapping("/vozilo")
public class VoziloController {

    @Autowired
    private VoziloService voziloService;

    @Autowired
    private AdresaService adresaService;

    @GetMapping("/getAll")
    public List<Vozilo> getAllVozilo() {
        return voziloService.getAllVozilo();
    }

    @GetMapping("/getByRegistracija/{registracija}")
    public Optional<Vozilo> getVoziloByRegistracija(@PathVariable String registracija) {
        return voziloService.getVoziloByRegistracija(registracija);
    }

    @PutMapping("/addNew")
    public ResponseEntity<Vozilo> putNewVozilo(@RequestBody Vozilo vozilo) {
        try {

            AdresaId adresaId = vozilo.getAdresaId();
            Optional<Adresa> adresa = adresaService.getAdresaById(adresaId);

            if (!adresa.isPresent()) {
                System.out.println("Adresa nije pronađena.");
                return ResponseEntity.badRequest().body(null);
            }

            vozilo.setAdresa(adresa.get());
            voziloService.saveVozilo(vozilo);

            System.out.println("Vozilo dodano...");
            return ResponseEntity.ok(vozilo);
        } catch (Exception e) {
            System.out.println("Greska kod dodavanja vozila");
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{registracija}")
    public ResponseEntity<String> deleteVozilo(@PathVariable(value = "registracija") String registracija) {
        try {
            boolean isRemoved = voziloService.deleteVoziloByRegistracija(registracija);
            if (!isRemoved) {
                System.out.println("Vozilo s registracijom " + registracija + " nije pronađeno.");
                return ResponseEntity.notFound().build();
            }
            System.out.println("Vozilo s registracijom " + registracija + " je pronađeno.");
            return ResponseEntity.ok("Vozilo je uspješno obrisano");
        } catch (Exception e) {
            System.out.println("Greska kod brisanja vozila");
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{registracija}")
    public ResponseEntity<Vozilo> updateVozilo(@PathVariable("registracija") String registracija, @RequestBody Vozilo voziloNovo) {
        try {
            Optional<Vozilo> existingVozilo = voziloService.getVoziloByRegistracija(registracija);
            if (!existingVozilo.isPresent()) {
                return ResponseEntity.notFound().build();
            }

            Vozilo vozilo = existingVozilo.get();
            vozilo.setKapacitet(voziloNovo.getKapacitet());
            vozilo.setStatus(voziloNovo.getStatus());
            vozilo.setUloga(voziloNovo.getUloga());

            if (!vozilo.getAdresa().equals(voziloNovo.getAdresa())) {
                Optional<Adresa> novaAdresa = adresaService.getAdresaById(voziloNovo.getAdresa().getAdresaId());
                if (!novaAdresa.isPresent()) {
                    return ResponseEntity.badRequest().body(null);
                }
                vozilo.setAdresa(novaAdresa.get());
            }

            voziloService.saveVozilo(vozilo);
            System.out.println("Vozilo ažurirano...");
            return ResponseEntity.ok(vozilo);
        } catch (Exception e) {
            System.out.println("Greška kod ažuriranja vozila");
            return ResponseEntity.notFound().build();
        }
    }
}
