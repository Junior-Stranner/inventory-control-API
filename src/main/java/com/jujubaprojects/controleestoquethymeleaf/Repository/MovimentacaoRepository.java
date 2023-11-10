package com.jujubaprojects.controleestoquethymeleaf.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jujubaprojects.controleestoquethymeleaf.Model.Movimentacao;

@Repository
public interface MovimentacaoRepository extends JpaRepository <Movimentacao,Integer>{
    
}
