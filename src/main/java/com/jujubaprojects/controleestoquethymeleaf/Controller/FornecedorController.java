package com.jujubaprojects.controleestoquethymeleaf.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jujubaprojects.controleestoquethymeleaf.Model.Fornecedor;
import com.jujubaprojects.controleestoquethymeleaf.Repository.FornecedorRepository;

@Controller
public class FornecedorController {
    
    @Autowired
    FornecedorRepository fornecedorRepository;

    @GetMapping("/cadastroFornecedor")
    public String cadastro(){
      /*   ModelAndView mv = new ModelAndView("cadastroFornecedor");
         List<Produto> produtos = produtoRepository.findAll();
        mv.addObject("produtos", produtos);*/
        return "cadastroFornecedor";

    }

    @PostMapping("/cadastroFornecedor")
    public String salvarProduto(Fornecedor fornecedor){
          fornecedorRepository.save(fornecedor);
        return "redirect:/listaFornecedor";

    }

    @GetMapping("/listaFornecedor")
    public ModelAndView lista(){
        ModelAndView  mv = new ModelAndView("listaFornecedor");
        List<Fornecedor> fornecedores = fornecedorRepository.findAll();
        mv.addObject("fornecedores", fornecedores);
        return mv;
    }

}
