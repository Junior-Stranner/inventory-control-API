package com.jujubaprojects.controleestoquethymeleaf.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jujubaprojects.controleestoquethymeleaf.Model.Produto;

public interface ProdutoRepository  extends JpaRepository <Produto, Integer>{
    
}
