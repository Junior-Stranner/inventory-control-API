package com.jujubaprojects.controleestoquethymeleaf.Controller;

import com.jujubaprojects.controleestoquethymeleaf.Model.Tipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jujubaprojects.controleestoquethymeleaf.Repository.UsuarioRepository;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsuarioController {
    
    @Autowired
    UsuarioRepository usuarioRepository;
    TipoRepository tipoRepository;

    public ModelAndView cadastro(){
        ModelAndView mv = new ModelAndView("cadastrarUsuario");


        return mv;
    }
}
