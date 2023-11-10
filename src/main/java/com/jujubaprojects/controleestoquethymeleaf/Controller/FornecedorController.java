package com.jujubaprojects.controleestoquethymeleaf.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jujubaprojects.controleestoquethymeleaf.Model.Fornecedor;
import com.jujubaprojects.controleestoquethymeleaf.Model.Produto;
import com.jujubaprojects.controleestoquethymeleaf.Model.Usuario;
import com.jujubaprojects.controleestoquethymeleaf.Repository.FornecedorRepository;
import com.jujubaprojects.controleestoquethymeleaf.Repository.ProdutoRepository;

@Controller
public class FornecedorController {
    
    @Autowired
    FornecedorRepository fornecedorRepository;
    ProdutoRepository produtoRepository;

    @GetMapping("/cadastroFornecedor")
    public ModelAndView cadastro(){
         ModelAndView mv = new ModelAndView("cadastroFornecedor");
        return mv ;

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

      @GetMapping("/editarFornecedor/{id}")
    public ModelAndView editar(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("cadastroFornecedor");
        Fornecedor fornecedor = fornecedorRepository.findById(id).get();
        mv.addObject("fornecedor", fornecedor);
        return mv;
    
   }

   @GetMapping("/excluirFornecedor/{id}")
   public String excluir(@PathVariable("id") int id) {
       fornecedorRepository.deleteById(id);
       return "redirect:/listaFornecedor";
   }
}
