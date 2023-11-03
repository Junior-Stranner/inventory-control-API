package com.jujubaprojects.controleestoquethymeleaf.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jujubaprojects.controleestoquethymeleaf.Model.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario,UUID>{
    
}
