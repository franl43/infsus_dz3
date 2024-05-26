package com.infsus.suhs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {

    public String returnErrorPage(Model model) {
        return "Common/Error";
    }
}
