package com.infsus.suhs.controller;

import com.infsus.suhs.model.Centar;
import com.infsus.suhs.model.Intervencija;
import com.infsus.suhs.model.Vozilo;
import com.infsus.suhs.service.CentarService;
import com.infsus.suhs.service.IntervencijaService;
import com.infsus.suhs.service.VoziloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/intervencija")
public class IntervencijaController {

    @Autowired
    private IntervencijaService intervencijaService;
    @Autowired
    private CentarService centarService;
    @Autowired
    private VoziloService voziloService;

    @GetMapping("*")
    public String getAllIntervencija(Model model) {
        List<Intervencija> intervencije = intervencijaService.getAllIntervencija();
        intervencije.forEach(System.out::println);

        model.addAttribute("intervencije", intervencije);
        return "Intervencija/IndexSimple";
    }

    @GetMapping("/{id}")
    public String getIntervencijaById(Model model, @PathVariable long id) {
        Intervencija intervencija = intervencijaService.getIntervencijaById(id).orElse(null);

        if(intervencija != null) {
            model.addAttribute("intervencija", intervencija);
            model.addAttribute("adresa", intervencija.getAdresa());
            model.addAttribute("izvjestaji", intervencija.getIzvjestaji());
            List<Centar> centri = centarService.getAllCentar();
            model.addAttribute("centri", centri);

            List<Vozilo> vozila = voziloService.getAllAvailableVozila();
            model.addAttribute("vozila", vozila);

            return "Intervencija/Index";
        } else {
            return "Common/Error";
        }
    }

    @PostMapping("/{id}")
    public String editIntervencijaById(@ModelAttribute Intervencija intervencija, Model model, @PathVariable long id) {

        model.addAttribute("intervencija", intervencija);
        model.addAttribute("izvjestaji", intervencija.getIzvjestaji());
        List<Centar> centri = centarService.getAllCentar();
        model.addAttribute("centri", centri);

        List<Vozilo> vozila = voziloService.getAllAvailableVozila();
        model.addAttribute("vozila", vozila);

        return "redirect:/intervencija/" + id;
    }

    @GetMapping("/delete/{id}")
    public String addIntervencija(Model model, @PathVariable long id) {
        intervencijaService.deleteIntervencija(id);

        return "redirect:/intervencija";
    }

}
