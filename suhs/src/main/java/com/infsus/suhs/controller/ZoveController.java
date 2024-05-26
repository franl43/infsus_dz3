package com.infsus.suhs.controller;

import com.infsus.suhs.model.Pozivatelj;
import com.infsus.suhs.model.Zove;
import com.infsus.suhs.model.ZoveId;
import com.infsus.suhs.service.CentarService;
import com.infsus.suhs.service.PozivateljService;
import com.infsus.suhs.service.ZoveService;
import com.infsus.suhs.utils.PozivateljJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PutMapping("/addNew")
    public Zove putNewZove(@RequestBody Zove zove) {
        return zoveService.saveZove(zove);
    }

    @GetMapping("/getById")
    public Optional<Zove> getZoveById(@RequestBody ZoveId zoveId) {
        return zoveService.getZoveById(zoveId);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteZove(@RequestBody ZoveId zoveId) {
        try {
            boolean isRemoved = zoveService.deleteZoveById(zoveId);
            if (!isRemoved) {
                System.out.println("Zove nije pronađen.");
                return ResponseEntity.notFound().build();
            }
            System.out.println("Zove je obrisan.");
            return ResponseEntity.ok("Zove je uspješno obrisan");
        } catch (Exception e) {
            System.out.println("Greska kod brisanja zove");
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Zove> updateZove(@RequestBody ZoveId zoveId, @RequestBody Zove zoveNovi) {
        try {
            Optional<Zove> existingZove = zoveService.getZoveById(zoveId);
            if (!existingZove.isPresent()) {
                return ResponseEntity.notFound().build();
            }

            Zove zove = existingZove.get();
            zove.setPozivatelj(zoveNovi.getPozivatelj());
            zove.setCentar(zoveNovi.getCentar());

            zoveService.saveZove(zove);
            System.out.println("Zove ažuriran...");
            return ResponseEntity.ok(zove);
        } catch (Exception e) {
            System.out.println("Greška kod ažuriranja zove");
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getByPozivatelj/{oib}")
    public List<Zove> getZoveByPozivatelj(@PathVariable(name = "oib") String oib) {
        return zoveService.getZoveByPozivatelj(oib);
    }

    @GetMapping("/getByCentar/{centarId}")
    public List<Zove> getZoveByCentar(@PathVariable Long centarId) {
        return zoveService.getZoveByCentar(centarId);
    }
}
