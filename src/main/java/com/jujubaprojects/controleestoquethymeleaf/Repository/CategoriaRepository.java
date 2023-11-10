package com.jujubaprojects.controleestoquethymeleaf.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jujubaprojects.controleestoquethymeleaf.Model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository <Categoria,Integer>{

    
}
