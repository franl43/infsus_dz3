package com.infsus.suhs.controller;

import com.infsus.suhs.model.OdgovaraNa;
import com.infsus.suhs.model.OdgovaraNaId;
import com.infsus.suhs.service.OdgovaraNaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/odgovarana")
public class OdgovaraNaController {

    @Autowired
    private OdgovaraNaService odgovaraNaService;

    @GetMapping("/getAll")
    public List<OdgovaraNa> getAllOdgovaraNa() {
        return odgovaraNaService.getAllOdgovaraNa();
    }

    @PutMapping("/addNew")
    public OdgovaraNa putNewOdgovaraNa(@RequestBody OdgovaraNa odgovaraNa) {
        return odgovaraNaService.saveOdgovaraNa(odgovaraNa);
    }

    @GetMapping("/getById")
    public Optional<OdgovaraNa> getOdgovaraNaById(@RequestBody OdgovaraNaId odgovaraNaId) {
        return odgovaraNaService.getOdgovaraNaById(odgovaraNaId);
    }

    @GetMapping("/getByIntervencija/{id}")
    public List<OdgovaraNa> getOdgovaraNaByIntervencija(@PathVariable(name = "id") Long id) {
        return odgovaraNaService.getOdgovaraNaByIntervencija(id);
    }

    @GetMapping("/getByVozilo/{registracija}")
    public List<OdgovaraNa> getOdgovaraNaByVozilo(@PathVariable String registracija) {
        return odgovaraNaService.getOdgovaraNaByVozilo(registracija);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteOdgovaraNa(@RequestBody OdgovaraNaId odgovaraNaId) {
        try {
            boolean isRemoved = odgovaraNaService.deleteOdgovaraNaById(odgovaraNaId);
            if (!isRemoved) {
                System.out.println("OdgovaraNa nije pronađen.");
                return ResponseEntity.notFound().build();
            }
            System.out.println("OdgovaraNa je obrisan.");
            return ResponseEntity.ok("OdgovaraNa je uspješno obrisan");
        } catch (Exception e) {
            System.out.println("Greska kod brisanja odgovaraNa");
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<OdgovaraNa> updateOdgovaraNa(@RequestBody OdgovaraNaId OdgovaraNaId, @RequestBody OdgovaraNa odgovaraNaNovi) {
        try {
            Optional<OdgovaraNa> existingOdgovaraNa = odgovaraNaService.getOdgovaraNaById(OdgovaraNaId);
            if (!existingOdgovaraNa.isPresent()) {
                return ResponseEntity.notFound().build();
            }

            OdgovaraNa odgovaraNa = existingOdgovaraNa.get();
            odgovaraNa.setIntervencija(odgovaraNaNovi.getIntervencija());
            odgovaraNa.setVozilo(odgovaraNaNovi.getVozilo());

            odgovaraNaService.saveOdgovaraNa(odgovaraNa);
            System.out.println("OdgovaraNa ažuriran...");
            return ResponseEntity.ok(odgovaraNa);
        } catch (Exception e) {
            System.out.println("Greška kod ažuriranja OdgovaraNa");
            return ResponseEntity.notFound().build();
        }
    }

}
