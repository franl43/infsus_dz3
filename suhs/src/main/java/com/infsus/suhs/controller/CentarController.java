package com.infsus.suhs.controller;

import com.infsus.suhs.model.Centar;
import com.infsus.suhs.service.CentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/centar")
public class CentarController {

    @Autowired
    private CentarService centarService;

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

    @GetMapping()
    public String getAllCentar(Model model) {
        List<Centar> centri = centarService.getAllCentar();
        centri.forEach(System.out::println);

        model.addAttribute("centri", centri);
        return "Centar/IndexSimple";
    }

    @GetMapping("/edit/{id}")
    public String editCentarById(Model model, @PathVariable long id) {
        System.out.println(model);
        return "redirect:/centar/" + id;
    }

    @GetMapping("/delete/{id}")
    public String addCentar(Model model, @PathVariable long id) {
        centarService.deleteCentarById(id);
        return "redirect:/centar";
    }
}
