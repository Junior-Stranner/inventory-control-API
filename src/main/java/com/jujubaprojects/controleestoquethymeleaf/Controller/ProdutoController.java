package com.jujubaprojects.controleestoquethymeleaf.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jujubaprojects.controleestoquethymeleaf.Model.Categoria;
import com.jujubaprojects.controleestoquethymeleaf.Model.Fornecedor;
import com.jujubaprojects.controleestoquethymeleaf.Model.Movimentacao;
import com.jujubaprojects.controleestoquethymeleaf.Model.Produto;
import com.jujubaprojects.controleestoquethymeleaf.Repository.CategoriaRepository;
import com.jujubaprojects.controleestoquethymeleaf.Repository.FornecedorRepository;
import com.jujubaprojects.controleestoquethymeleaf.Repository.MovimentacaoRepository;
import com.jujubaprojects.controleestoquethymeleaf.Repository.ProdutoRepository;

@Controller
public class ProdutoController {
    
    @Autowired
    ProdutoRepository produtoRepository;
    CategoriaRepository categoriaRepository;
    FornecedorRepository fornecedorRepository;
    MovimentacaoRepository movimentacaoProdRepository;

    @GetMapping("/cadastroProduto")
    public ModelAndView cadastrarProduto(){
        ModelAndView mv = new ModelAndView("cadastroProduto");

       List<Categoria> categorias = categoriaRepository.findAll();
       mv.addObject("categorias", categorias);

       List<Fornecedor> fornecedors = fornecedorRepository.findAll();
       mv.addObject("fornecedors", fornecedors);       

       List<Movimentacao> movimentacaoProds = movimentacaoProdRepository.findAll();
       mv.addObject("movimentacaoProds", movimentacaoProds);

        return mv;

    }

    @PostMapping("/cadastroProduto")
    public String salvarProduto(Produto produto , List<Integer> categoriaId 
     , List<Integer> fornecedorId ,List<Integer> movimentacaoId){

        List<Categoria> categorias = new ArrayList<>();
        Categoria categoria = new Categoria();
        for (Integer id : categoriaId) {
            categorias.add(categoriaRepository.findById(id).get());
        }
        produto.setCategoria(categoria);
        produtoRepository.save(produto);

        List<Fornecedor> fornecedors = new ArrayList<>();
        Fornecedor fornecedor = new Fornecedor();
        for (Integer id : fornecedorId) {
            fornecedors.add(fornecedorRepository.findById(id).get());
        }
        produto.setFornecedor(fornecedor);
        produtoRepository.save(produto);

        List<Movimentacao> movimentacaos = new ArrayList<>();
        for (Integer id : movimentacaoId) {
            movimentacaos.add(movimentacaoProdRepository.findById(id).get());
        }
        produto.setMovimentacao(movimentacaos);
        produtoRepository.save(produto);

        return "redirect:/listProduto";

    }

}
