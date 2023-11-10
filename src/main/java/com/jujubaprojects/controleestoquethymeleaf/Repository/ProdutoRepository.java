package com.jujubaprojects.controleestoquethymeleaf.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jujubaprojects.controleestoquethymeleaf.Model.Produto;

@Repository
public interface ProdutoRepository  extends JpaRepository <Produto, Integer>{
    
}
