package com.infsus.suhs.controller;

import com.infsus.suhs.model.Korisnik;
import com.infsus.suhs.service.KorisnikService;
import com.infsus.suhs.utils.KorisnikJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:3000/"}, allowCredentials = "true")
@RequestMapping("/korisnik")
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;

    //ovo mozda treba popravit
    @PutMapping("/addNew")
    public ResponseEntity<Korisnik> putNewKorisnik(@RequestBody KorisnikJson korisnikJson) {
        try {
            Korisnik korisnik = new Korisnik(
                    korisnikJson.getKorisnicko_ime(), korisnikJson.getIme(), korisnikJson.getPrezime(),
                    korisnikJson.getLozinka(), korisnikJson.getUloga());
            korisnikService.saveKorisnik(korisnik);
            System.out.println("Korisnik dodan...");
            return ResponseEntity.ok(korisnik);
        } catch (Exception e) {
            System.out.println("Greska kod dodavanja korisnika");
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getByKorisnickoIme/{korisnicko_ime}")
    public Optional<Korisnik> getKorisnikByKorisnickoIme(@PathVariable(value = "korisnicko_ime") String korisnicko_ime) {
        return korisnikService.getKorisnikByKorisnickoIme(korisnicko_ime);
    }

    @GetMapping("/getAll")
    public List<Korisnik> getAllKorisnik() {
        return korisnikService.getAllKorisnik();
    }

    @DeleteMapping("/delete/{korisnicko_ime}")
    public ResponseEntity<String> deleteKorisnik(@PathVariable(value = "korisnicko_ime") String korisnicko_ime) {
        try {
            boolean isRemoved = korisnikService.deleteKorisnikByKorisnickoIme(korisnicko_ime);
            if (!isRemoved) {
                System.out.println("Korisnik s korisnickim imenom " + korisnicko_ime + " nije pronađen.");
                return ResponseEntity.notFound().build();
            }
            System.out.println("Korisnik s korisnickim imenom " + korisnicko_ime + " je obrisan.");
            return ResponseEntity.ok("Korisnik je uspješno obrisan");
        } catch (Exception e) {
            System.out.println("Greska kod brisanja korisnika");
            return ResponseEntity.notFound().build();
        }
    }

}
