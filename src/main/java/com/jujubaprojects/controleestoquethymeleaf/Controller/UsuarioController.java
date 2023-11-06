package com.jujubaprojects.controleestoquethymeleaf.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jujubaprojects.controleestoquethymeleaf.Model.Usuario;
import com.jujubaprojects.controleestoquethymeleaf.Repository.UsuarioRepository;

import ch.qos.logback.core.model.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
            // Salva o usuário no banco de dados
            usuarioRepository.save(usuario);
            // Redireciona os usuários "admin" para uma URL específica
            return "redirect:/loginAdm"; // Substitua com a URL desejada para usuários "admin"
        } else {
            usuario.setTipo("comum");
            // Salva o usuário no banco de dados
            usuarioRepository.save(usuario);
            // Redireciona os usuários "comum" para uma URL diferente
            return "redirect:/loginComum"; // Substitua com a URL desejada para usuários "comum"
        }
    }

    @GetMapping("/loginAdm")
    public String loginAdmin(){
        return "loginAdm";
    }

    @PostMapping("/verificaLoginAdm")
    public String verificaLoginAdm(Usuario usuario){
     List<Usuario> usuarios = usuarioRepository.findAll();
     for (Usuario usuarioLogAdm : usuarios) {
        if (usuarioLogAdm.getEmail().equals(usuario.getEmail())
         && usuarioLogAdm.getSenha().equals(usuario.getSenha())) {

               return "redirect:/paginaInicial";
            }
        }
    return "redirect:/loginAdm";
    }

    @GetMapping("/listaUsuario")
    public ModelAndView listarUsuarios(){
        ModelAndView mv = new ModelAndView("listaUsuario");
        List<Usuario> usuarios = usuarioRepository.findAll();
        mv.addObject("usuarios", usuarios);
        return mv;

    }
    

}
