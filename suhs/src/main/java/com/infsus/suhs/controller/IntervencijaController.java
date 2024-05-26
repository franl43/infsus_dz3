package com.infsus.suhs.controller;

import com.infsus.suhs.model.Intervencija;
import com.infsus.suhs.service.AdresaService;
import com.infsus.suhs.service.IntervencijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/intervencija")
public class IntervencijaController {

    @Autowired
    private IntervencijaService intervencijaService;

    @GetMapping()
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

            return "Intervencija/Index";
        } else {
            return "Common/Error";
        }
    }

    @GetMapping("/edit/{id}")
    public String editIntervencijaById(Model model, @PathVariable long id) {
        System.out.println(model);
        return "redirect:/intervencija/" + id;
    }

    @GetMapping("/delete/{id}")
    public String addIntervencija(Model model, @PathVariable long id) {
        intervencijaService.deleteIntervencija(id);

        return "redirect:/intervencija";
    }

}
