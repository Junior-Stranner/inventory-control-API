package com.jujubaprojects.controleestoquethymeleaf.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jujubaprojects.controleestoquethymeleaf.Model.Usuario;
import com.jujubaprojects.controleestoquethymeleaf.Repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

     public void cadastrarUsuario(String nome, String email, String senha, String tela) {
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);

        
    }

    
}
