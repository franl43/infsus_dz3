package com.infsus.suhs.controller;

import com.infsus.suhs.model.Centar;
import com.infsus.suhs.model.Pozivatelj;
import com.infsus.suhs.service.CentarService;
import com.infsus.suhs.utils.CentarJson;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:3000/"}, allowCredentials = "true")
@RequestMapping("/centar")
public class CentarController {

    @Autowired
    private CentarService centarService;

    @PutMapping("/addNew")
    public ResponseEntity<Centar> putNewCentar(@RequestBody CentarJson centarJson, HttpServletRequest req) {
        try {
            Centar centar = new Centar(
                    centarJson.getBroj(), centarJson.getKapacitet());
            centarService.saveCentar(centar);
            System.out.println("Centar dodan...");
            return ResponseEntity.ok(centar);
        } catch (Exception e) {
            System.out.println("Greska kod dodavanja centra");
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getById/{id}")
    public Optional<Centar> getCentarById(@PathVariable(value = "id") String id) {
        return centarService.getCentarById(Long.parseLong(id));
    }

    @GetMapping("/getAll")
    public List<Centar> getAllCentar() {
        return centarService.getAllCentar();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCentar(@PathVariable(value = "id") String id) {
        try {
            boolean isRemoved = centarService.deleteCentarById(Long.parseLong(id));
            if (!isRemoved) {
                System.out.println("Centar s ID " + id + " nije pronađen.");
                return ResponseEntity.notFound().build();
            }
            System.out.println("Centar s ID " + id + " je obrisan.");
            return ResponseEntity.ok("Centar je uspješno obrisan");
        } catch (Exception e) {
            System.out.println("Greska kod brisanja centra");
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Centar> updateCentar(@PathVariable("id") Long id, @RequestBody CentarJson centarJson) {
        try {
            Optional<Centar> existingCentar = centarService.getCentarById(id);
            if (!existingCentar.isPresent()) {
                return ResponseEntity.notFound().build();
            }

            Centar centar = existingCentar.get();
            centar.setBroj(centarJson.getBroj());
            centar.setKapacitet(centarJson.getKapacitet());

            centarService.saveCentar(centar);
            System.out.println("Centar ažuriran...");
            return ResponseEntity.ok(centar);
        } catch (Exception e) {
            System.out.println("Greška kod ažuriranja centra");
            return ResponseEntity.notFound().build();
        }
    }
}
