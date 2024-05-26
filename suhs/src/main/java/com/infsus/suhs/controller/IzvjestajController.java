package com.infsus.suhs.controller;

import com.infsus.suhs.model.Intervencija;
import com.infsus.suhs.model.Izvjestaj;
import com.infsus.suhs.service.IzvjestajService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/izvjestaj")
public class IzvjestajController {

    @Autowired
    private IzvjestajService izvjestajService;

    @GetMapping()
    public String getAllIzvjestaj(Model model) {
        List<Izvjestaj> izvjestaji = izvjestajService.getAllIzvjestaj();
        izvjestaji.forEach(System.out::println);
        model.addAttribute("izvjestaj", izvjestaji);
        return "Izvjestaj/IndexSimple";
    }
}
