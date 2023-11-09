package com.jujubaprojects.controleestoquethymeleaf.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jujubaprojects.controleestoquethymeleaf.Repository.CategoriaRepository;

@Controller
public class CategoriaController {
    
    @Autowired
    CategoriaRepository categoriaRepository;
    

}
