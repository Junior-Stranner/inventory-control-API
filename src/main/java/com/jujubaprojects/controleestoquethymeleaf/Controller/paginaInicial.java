package com.jujubaprojects.controleestoquethymeleaf.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class paginaInicial {
    

     @GetMapping("/paginaInicial")
    public ModelAndView acessarPagina(){
        ModelAndView mv = new ModelAndView("paginaInicial");
        return mv;

    }
     @PostMapping("/paginaInicial")
     public String mostrarPagina(){
        return "paginaInicial";

     }
}
