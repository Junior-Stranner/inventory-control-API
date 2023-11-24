package com.jujubaprojects.controleestoquethymeleaf.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jujubaprojects.controleestoquethymeleaf.Model.Usuario;
import com.jujubaprojects.controleestoquethymeleaf.Repository.UsuarioRepository;

import ch.qos.logback.core.model.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller

public class UsuarioController {
    
    @Autowired
    UsuarioRepository usuarioRepository;

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
    public String verificaLoginAdm(Usuario usuario, Model model) {

        List<Usuario> usuarios = usuarioRepository.findAll();
        System.out.println("Comparando com: " + usuario.getEmail() + " / " + usuario.getSenha());

        for (Usuario usuarioLogAdm : usuarios) {
            if (usuarioLogAdm.getEmail().equals(usuario.getEmail()) && usuarioLogAdm.getSenha().equals(usuario.getSenha())) {
                String nomeAdm = usuarioLogAdm.getNome();
                System.out.println("Login bem-sucedido para: " + nomeAdm);
           //     ((RedirectAttributes) model).addAttribute("nomeAdm", nomeAdm);
                return "redirect:/paginaInicial";
            }
        }
        return "redirect:/loginAdm";
    }

    @GetMapping("/listaUsuario")
    public ModelAndView listarUsuarios(){
        ModelAndView mv = new ModelAndView("listaUsuario");
        Iterable<Usuario> usuarios = usuarioRepository.findAll();
        mv.addObject("usuarios", usuarios);
        return mv;
    }

    @GetMapping("/editarUsuario/{id}")
    public ModelAndView editar(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("cadastroUsuario");
       Usuario usuario = usuarioRepository.findById(id).get();
        mv.addObject("usuario", usuario);
        return mv;
    
   }

   @PostMapping("/salvarEdicaoUsuario")
public String salvarEdicaoUsuario(@ModelAttribute Usuario usuarioEditado) {
    // Lógica para salvar as alterações no banco de dados
    Usuario usuario = usuarioRepository.save(usuarioEditado);
    return "redirect:/listaUsuarios"; // Substitua pelo redirecionamento apropriado
}



   @GetMapping("/excluirUsuario/{id}")
   public String excluir(@PathVariable("id") int id) {
       usuarioRepository.deleteById(id);
       return "redirect:/listaUsuario";
   }

/*
  Done with the ADM 
  Terminei com o ADM
 * ======================================================================================================
 * irei fazer o mesmo agr para o usuario comum 
 * doing the same now with the common user
 */

  @GetMapping("/loginComum")
    public String login(){
        return "loginComum";
    }

    @PostMapping("/verificaLoginComum")
    public String verificaLoginAdm(Usuario usuario) {

        List<Usuario> usuarios = usuarioRepository.findAll();
        System.out.println("Comparando com: " + usuario.getEmail() + " / " + usuario.getSenha());

        for (Usuario usuarioLogComum : usuarios) {
            if (usuarioLogComum.getEmail().equals(usuario.getEmail()) && usuarioLogComum.getSenha().equals(usuario.getSenha())) {
                String nomeComum = usuarioLogComum.getNome();
                System.out.println("Login bem-sucedido para: " + nomeComum);
           //     ((RedirectAttributes) model).addAttribute("nomeAdm", nomeAdm);
                return "redirect:/paginaInicial";
            }
        }
        return "redirect:/loginComum";
    }

  /*   @GetMapping("/listaUsuario")
    public ModelAndView listarUsuariosComums(){
        ModelAndView mv = new ModelAndView("listaUsuario");
        List<Usuario> usuarios = usuarioRepository.findAll();
        mv.addObject("usuarios", usuarios);
        return mv;
    }*/

    @GetMapping("/editarUsuarioComum/{id}")
    public ModelAndView editarComum(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("cadastroUsuario");
        Usuario usuario = usuarioRepository.findById(id).get();
        mv.addObject("usuario", usuario);
        return mv;
    
   }

   @GetMapping("/excluirUsuarioComum/{id}")
   public String excluirComum(@PathVariable("id") int id) {
       usuarioRepository.deleteById(id);
       return "redirect:/listaUsuario";
   }

}
