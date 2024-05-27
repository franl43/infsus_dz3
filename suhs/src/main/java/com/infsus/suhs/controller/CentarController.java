package com.infsus.suhs.controller;

import com.infsus.suhs.model.Centar;
import com.infsus.suhs.service.CentarService;
import com.infsus.suhs.service.IntervencijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/centar")
public class CentarController {

    @Autowired
    private CentarService centarService;
    @Autowired
    private IntervencijaService intervencijaService;

    @GetMapping()
    public String getAllCentar(Model model) {
        List<Centar> centri = centarService.getAllCentar();
        centri.forEach(System.out::println);

        model.addAttribute("centri", centri);
        return "Centar/IndexSimple";
    }

    @GetMapping("/{id}")
    public String getCentarById(Model model, @PathVariable long id) {
        Centar centar = centarService.getCentarById(id).orElse(null);
        if(centar != null) {
            model.addAttribute("centar", centar);

            return "Centar/Index";
        } else {
            return "Common/Error";
        }
    }

    @PostMapping("/{id}")
    public String editCentarById(@ModelAttribute Centar centar, Model model, @PathVariable long id) {
        Optional<Centar> centarOptional = centarService.getCentarById(id);
        centarOptional.get().setBroj(centar.getBroj());
        centarOptional.get().setKapacitet(centar.getKapacitet());

        centarService.saveCentar(centarOptional.get());

        model.addAttribute("centar", centarOptional.get());
        return "redirect:/centar/" + id;
    }

    @GetMapping("/create")
    public String createCentar(Model model) {
        model.addAttribute("centar", new Centar());
        return "Centar/Create";
    }

    @PostMapping("/create")
    public String saveCentar(@ModelAttribute Centar centar, Model model) {
        Centar c = centarService.saveCentar(centar);

        model.addAttribute("centar", c);
        return "redirect:/centar/"+c.getCentarid();
    }

    @GetMapping("/delete/{id}")
    public String deleteCentar(Model model, @PathVariable long id) {
        centarService.deleteCentarById(id);
        return "redirect:/centar";
    }
}
