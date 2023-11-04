package com.jujubaprojects.controleestoquethymeleaf.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jujubaprojects.controleestoquethymeleaf.Model.Usuario;
import com.jujubaprojects.controleestoquethymeleaf.Repository.UsuarioRepository;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller

public class UsuarioController {
    
    @Autowired
    UsuarioRepository usuarioRepository;
    TipoRepository tipoRepository;

    @GetMapping("/cadastroUsuario")
    public String cadastro(){
        return "cadastroUsuario";
    }


    @PostMapping("/cadastroUsuario")
    public String cadastrarUsuario(Usuario usuario) {
        
        if (usuario.getEmail().endsWith("@admin12345")) {
            usuario.setTipo("admin");
        } else {
            usuario.setTipo("comum");
        }
        
        usuarioRepository.save(usuario); // Salva o usuário no banco de dados
        
        return "redirect:/sucesso";
    }

}
