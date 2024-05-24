package com.infsus.suhs.controller;

import com.infsus.suhs.model.Adresa;
import com.infsus.suhs.model.AdresaId;
import com.infsus.suhs.model.Centar;
import com.infsus.suhs.model.Pozivatelj;
import com.infsus.suhs.service.AdresaService;
import com.infsus.suhs.service.CentarService;
import com.infsus.suhs.utils.AdresaIdJson;
import com.infsus.suhs.utils.AdresaJson;
import com.infsus.suhs.utils.PozivateljJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:3000/"}, allowCredentials = "true")
@RequestMapping("/adresa")
public class AdresaController {

    @Autowired
    private AdresaService adresaService;

    @Autowired
    private CentarService centarService;

    @PutMapping("/addNew")
    public ResponseEntity<Adresa> putNewAdresa(@RequestBody AdresaJson adresaJson) {
        try {
            Optional<Centar> centar = centarService.getCentarById(adresaJson.getCentar());
            if (centar.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            AdresaId adresaId = new AdresaId(adresaJson.getGrad(), adresaJson.getP_broj(), adresaJson.getNaziv());

            Adresa adresa = new Adresa(
                    adresaId, adresaJson.getKoordinate(), centar.get());
            adresaService.saveAdresa(adresa);
            System.out.println("Adresa dodana...");
            return ResponseEntity.ok(adresa);
        } catch (Exception e) {
            System.out.println("Greska kod dodavanja adrese");
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getById")
    public Optional<Adresa> getAdresaById(@RequestBody AdresaIdJson adresaIdJson) {
        AdresaId adresaId = new AdresaId(adresaIdJson.getGrad(), adresaIdJson.getP_broj(), adresaIdJson.getNaziv());
        return adresaService.getAdresaById(adresaId);
    }


    @GetMapping("/getAll")
    public List<Adresa> getAllPozivatelj() {
        return adresaService.getAllAdresa();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAdresa(@RequestBody AdresaIdJson adresaIdJson) {
        try {
            AdresaId adresaId = new AdresaId(adresaIdJson.getGrad(), adresaIdJson.getP_broj(), adresaIdJson.getNaziv());
            boolean isRemoved = adresaService.deleteAdresaById(adresaId);
            if (!isRemoved) {
                System.out.println("Adresa nije pronađena.");
                return ResponseEntity.notFound().build();
            }
            System.out.println("Adresa je obrisana.");
            return ResponseEntity.ok("Adresa je uspješno obrisana");
        } catch (Exception e) {
            System.out.println("Greska kod brisanja adrese");
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Adresa> updateAdresa(@RequestBody AdresaJson adresaJson) {
        try {
            AdresaId adresaId = new AdresaId(adresaJson.getGrad(), adresaJson.getP_broj(), adresaJson.getNaziv());
            Optional<Adresa> existingAdresa = adresaService.getAdresaById(adresaId);
            if (!existingAdresa.isPresent()) {
                return ResponseEntity.notFound().build();
            }

            Adresa adresa = existingAdresa.get();
            adresa.setKoordinate(adresaJson.getKoordinate());

            Optional<Centar> centar = centarService.getCentarById(adresaJson.getCentar());
            if (centar.isEmpty()) {
                System.out.println("Centar nije pronađen");
                return ResponseEntity.notFound().build();
            }
            adresa.setCentar(centar.get());

            adresaService.saveAdresa(adresa);
            System.out.println("Adresa ažurirana...");
            return ResponseEntity.ok(adresa);
        } catch (Exception e) {
            System.out.println("Greška kod ažuriranja adrese");
            return ResponseEntity.notFound().build();
        }
    }
}
