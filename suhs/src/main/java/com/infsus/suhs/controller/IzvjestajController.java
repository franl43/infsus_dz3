package com.infsus.suhs.controller;

import com.infsus.suhs.model.Centar;
import com.infsus.suhs.model.ClanHitneSluzbe;
import com.infsus.suhs.model.Intervencija;
import com.infsus.suhs.model.Izvjestaj;
import com.infsus.suhs.service.ClanHitneSluzbeService;
import com.infsus.suhs.service.IntervencijaService;
import com.infsus.suhs.service.IzvjestajService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/izvjestaj")
public class IzvjestajController {

    @Autowired
    private IzvjestajService izvjestajService;
    @Autowired
    private IntervencijaService intervencijaService;
    @Autowired
    private ClanHitneSluzbeService clanHitneSluzbeService;

    @GetMapping()
    public String getAllIzvjestaj(Model model) {
        List<Izvjestaj> izvjestaji = izvjestajService.getAllIzvjestaj();
        izvjestaji.forEach(System.out::println);
        model.addAttribute("izvjestaji", izvjestaji);
        return "Izvjestaj/IndexSimple";
    }

    @GetMapping("/{id}")
    public String getIzvjestajById(Model model, @PathVariable long id) {
        Izvjestaj izvjestaj = izvjestajService.getIzvjestajById(id).orElse(null);
        if(izvjestaj != null) {
            model.addAttribute("intervencije", intervencijaService.getAllIntervencija());
            model.addAttribute("clanovi", clanHitneSluzbeService.getAllClanHitneSlube());
            model.addAttribute("izvjestaj", izvjestaj);

            return "Izvjestaj/Index";
        } else {
            return "Common/Error";
        }
    }

    @PostMapping("/{id}")
    public String editIzvjestajById(@ModelAttribute Izvjestaj izvjestaj, Model model, @PathVariable long id) {
        Optional<Izvjestaj> izvjestajOptional = izvjestajService.getIzvjestajById(id);
        if(izvjestajOptional.isPresent()) {
            izvjestajOptional.get().setDatvr(izvjestaj.getDatvr());
            izvjestajOptional.get().setSadrzaj(izvjestaj.getSadrzaj());
            izvjestajOptional.get().setIntervencija(izvjestaj.getIntervencija());
            izvjestajOptional.get().setClanhitnesluzbe(izvjestaj.getClanhitnesluzbe());
            izvjestajService.saveIzvjestaj(izvjestajOptional.get());
        }
        return "redirect:/izvjestaj/" + id;
    }

    @GetMapping("/create")
    public String createIzvjestaj(Model model) {
        model.addAttribute("intervencije", intervencijaService.getAllIntervencija());
        model.addAttribute("clanovi", clanHitneSluzbeService.getAllClanHitneSlube());
        model.addAttribute("izvjestaj", new Izvjestaj());
        return "Izvjestaj/Create";
    }

    @PostMapping("/create")
    public String saveIzvjestaj(@ModelAttribute Izvjestaj izvjestaj, Model model) {
        Izvjestaj i = izvjestajService.saveIzvjestaj(izvjestaj);
        model.addAttribute("izvjestaj", i);
        return "redirect:/izvjestaj/"+i.getIzvjestajid();
    }

    @GetMapping("/delete/{id}")
    public String deleteCentar(Model model, @PathVariable long id) {
        izvjestajService.deleteIzvjestajById(id);
        return "redirect:/izvjestaj";
    }
}
