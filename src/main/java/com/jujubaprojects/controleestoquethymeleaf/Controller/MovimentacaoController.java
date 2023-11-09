package com.jujubaprojects.controleestoquethymeleaf.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jujubaprojects.controleestoquethymeleaf.Repository.MovimentacaoRepository;
import com.jujubaprojects.controleestoquethymeleaf.Repository.ProdutoRepository;
 
@Controller
public class MovimentacaoController {
    
    @Autowired
    MovimentacaoRepository movimentacaoRepository;
    ProdutoRepository produtoRepository;

    @GetMapping("/cadastroMovimentacao")
    public ModelAndView cadastro(){
        return null;

    }

}
