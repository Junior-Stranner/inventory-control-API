package com.jujubaprojects.controleestoquethymeleaf.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jujubaprojects.controleestoquethymeleaf.Model.Categoria;
import com.jujubaprojects.controleestoquethymeleaf.Repository.CategoriaRepository;

@Controller
public class CategoriaController {
    
    @Autowired
    CategoriaRepository categoriaRepository;
    

    @GetMapping("/cadastroCategoria")
    public ModelAndView cadastroCategoria(){
        ModelAndView mv = new ModelAndView("cadastroCategoria");
       return mv ;
    }

    @PostMapping("/cadastroCategoria")
    public String salvarCategoria(Categoria categoria){
          categoriaRepository.save(categoria);
        return "redirect:/listaCategoria";

    }

    @GetMapping("/listaCategoria")
    public ModelAndView lista(){
        ModelAndView  mv = new ModelAndView("listaCategoria");
        List<Categoria> categorias = categoriaRepository.findAll();
        mv.addObject("categorias", categorias);
        return mv;
    }
}
