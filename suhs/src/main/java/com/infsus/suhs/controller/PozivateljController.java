package com.infsus.suhs.controller;

import com.infsus.suhs.model.Pozivatelj;
import com.infsus.suhs.service.PozivateljService;
import com.infsus.suhs.utils.PozivateljJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = {"http://localhost:3000/"}, allowCredentials = "true")
@RequestMapping("/pozivatelj")
public class PozivateljController {

    @Autowired
    private PozivateljService pozivateljService;

    @PutMapping("/addNew")
    public ResponseEntity<Pozivatelj> putNewPozivatelj(@RequestBody PozivateljJson pozivateljJson) {
        try {
            Pozivatelj pozivatelj = new Pozivatelj(
                    pozivateljJson.getOIB(), pozivateljJson.getIme(), pozivateljJson.getPrezime(), pozivateljJson.getBroj());
            pozivateljService.savePozivatelj(pozivatelj);
            System.out.println("Pozivatelj dodan...");
            return ResponseEntity.ok(pozivatelj);
        } catch (Exception e) {
            System.out.println("Greska kod dodavanja pozivatelja");
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/getByOIB/{oib}")
    public Optional<Pozivatelj> getPozivateljByOIB(@PathVariable(value = "oib") String oib) {
        return pozivateljService.getPozivateljByOIB(oib);
    }

    @GetMapping("/getAll")
    public List<Pozivatelj> getAllPozivatelj() {
        return pozivateljService.getAllPozivatelj();
    }

    @DeleteMapping("/delete/{oib}")
    public ResponseEntity<String> deletePozivatelj(@PathVariable(value = "oib") String oib) {
        try {
            boolean isRemoved = pozivateljService.deletePozivateljByOIB(oib);
            if (!isRemoved) {
                System.out.println("Pozivatelj s OIB-om " + oib + " nije pronađen.");
                return ResponseEntity.notFound().build();
            }
            System.out.println("Pozivatelj s OIB-om " + oib + " je obrisan.");
            return ResponseEntity.ok("Pozivatelj je uspješno obrisan");
        } catch (Exception e) {
            System.out.println("Greska kod brisanja pozivatelja");
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{oib}")
    public ResponseEntity<Pozivatelj> updatePozivatelj(@PathVariable("oib") String oib, @RequestBody PozivateljJson pozivateljJson) {
        try {
            Optional<Pozivatelj> existingPozivatelj = pozivateljService.getPozivateljByOIB(oib);
            if (!existingPozivatelj.isPresent()) {
                return ResponseEntity.notFound().build();
            }

            Pozivatelj pozivatelj = existingPozivatelj.get();
            pozivatelj.setIme(pozivateljJson.getIme());
            pozivatelj.setPrezime(pozivateljJson.getPrezime());
            pozivatelj.setBroj(pozivateljJson.getBroj());

            pozivateljService.savePozivatelj(pozivatelj);
            System.out.println("Pozivatelj ažuriran...");
            return ResponseEntity.ok(pozivatelj);
        } catch (Exception e) {
            System.out.println("Greška kod ažuriranja pozivatelja");
            return ResponseEntity.notFound().build();
        }
    }

}
