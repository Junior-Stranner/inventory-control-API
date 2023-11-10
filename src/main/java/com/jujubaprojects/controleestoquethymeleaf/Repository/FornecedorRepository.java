package com.jujubaprojects.controleestoquethymeleaf.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jujubaprojects.controleestoquethymeleaf.Model.Fornecedor;

@Repository
public interface FornecedorRepository extends JpaRepository <Fornecedor,Integer>{
    
}
