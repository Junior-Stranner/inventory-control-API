package com.jujubaprojects.controleestoquethymeleaf.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jujubaprojects.controleestoquethymeleaf.Model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Integer>{
    
}
