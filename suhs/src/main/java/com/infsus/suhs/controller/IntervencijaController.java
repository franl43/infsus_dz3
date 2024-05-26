package com.infsus.suhs.controller;

import com.infsus.suhs.model.Adresa;
import com.infsus.suhs.model.Centar;
import com.infsus.suhs.model.Intervencija;
import com.infsus.suhs.model.Pozivatelj;
import com.infsus.suhs.service.AdresaService;
import com.infsus.suhs.service.CentarService;
import com.infsus.suhs.service.IntervencijaService;
import com.infsus.suhs.utils.PozivateljJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:3000/"}, allowCredentials = "true")
@RequestMapping("/intervencija")
public class IntervencijaController {

    @Autowired
    private IntervencijaService intervencijaService;

    @Autowired
    private AdresaService adresaService;

    @Autowired
    private CentarService centarService;

    @GetMapping("/getById/{id}")
    public Optional<Intervencija> getIntervencijaById(@PathVariable(value = "id") Long id) {
        return intervencijaService.getIntervencijaById(id);
    }

    @GetMapping("/getAll")
    public List<Intervencija> getAllIntervencija() {
        return intervencijaService.getAllIntervencija();
    }

    @PutMapping("/addNew")
    public ResponseEntity<Intervencija> putNewIntervencija(@RequestBody Intervencija intervencija) {
        try {
            // Provjera postoji li adresa
            Optional<Adresa> adresa = adresaService.getAdresaById(intervencija.getAdresa().getAdresaId());
            if (!adresa.isPresent()) {
                System.out.println("Adresa nije pronađena.");
                return ResponseEntity.badRequest().body(null);
            }

            // Provjera postoji li centar
            Optional<Centar> centar = centarService.getCentarById(intervencija.getCentar().getCentarId());
            if (!centar.isPresent()) {
                System.out.println("Centar nije pronađen.");
                return ResponseEntity.badRequest().body(null);
            }

            intervencija.setAdresa(adresa.get());
            intervencija.setCentar(centar.get());
            intervencijaService.saveIntervencija(intervencija);

            System.out.println("Intervencija dodana...");
            return ResponseEntity.ok(intervencija);
        } catch (Exception e) {
            System.out.println("Greška kod dodavanja intervencije");
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteIntervencija(@PathVariable(value = "id") Long id) {
        try {
            boolean isRemoved = intervencijaService.deleteIntervencijaById(id);
            if (!isRemoved) {
                System.out.println("Intervencija nije pronađena.");
                return ResponseEntity.notFound().build();
            }
            System.out.println("Intervencija je obrisana.");
            return ResponseEntity.ok("Intervencija je uspješno obrisana");
        } catch (Exception e) {
            System.out.println("Greska kod brisanja intervencije");
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Intervencija> updateIntervencija(@PathVariable("id") Long id, @RequestBody Intervencija intervencijaNovo) {
        try {
            Optional<Intervencija> existingIntervencija = intervencijaService.getIntervencijaById(id);
            if (!existingIntervencija.isPresent()) {
                return ResponseEntity.notFound().build();
            }

            Intervencija intervencija = existingIntervencija.get();
            intervencija.setOpis(intervencijaNovo.getOpis());
            intervencija.setDatVr(intervencijaNovo.getDatVr());

            if (!intervencija.getAdresa().equals(intervencijaNovo.getAdresa())) {
                Optional<Adresa> novaAdresa = adresaService.getAdresaById(intervencijaNovo.getAdresa().getAdresaId());
                if (!novaAdresa.isPresent()) {
                    return ResponseEntity.badRequest().body(null);
                }
                intervencija.setAdresa(novaAdresa.get());
            }

            if (!intervencija.getCentar().equals(intervencijaNovo.getCentar())) {
                Optional<Centar> noviCentar = centarService.getCentarById(intervencijaNovo.getCentar().getCentarId());
                if (!noviCentar.isPresent()) {
                    return ResponseEntity.badRequest().body(null);
                }
                intervencija.setCentar(noviCentar.get());
            }

            intervencijaService.saveIntervencija(intervencija);
            System.out.println("Intervencija ažurirana...");
            return ResponseEntity.ok(intervencija);
        } catch (Exception e) {
            System.out.println("Greška kod ažuriranja intervencije");
            return ResponseEntity.notFound().build();
        }
    }
}
