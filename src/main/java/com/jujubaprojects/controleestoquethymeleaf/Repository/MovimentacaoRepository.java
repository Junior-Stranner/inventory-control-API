package com.jujubaprojects.controleestoquethymeleaf.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jujubaprojects.controleestoquethymeleaf.Model.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository <Movimentacao,Integer>{
    
}
