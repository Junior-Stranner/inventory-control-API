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
    private FornecedorRepository fornecedorRepository;

    MovimentacaoRepository movimentacaoProdRepository;

    @GetMapping("/cadastroProduto")
    public ModelAndView cadastrarProduto(){
        ModelAndView mv = new ModelAndView("cadastroProduto");

       List<Fornecedor> fornecedors = fornecedorRepository.findAll();
       mv.addObject("fornecedors", fornecedors);       

       List<Categoria> categorias = categoriaRepository.findAll();
       mv.addObject("categorias", categorias);

       return mv;

    }
    @PostMapping("/cadastroProduto")
    public String salvarProduto(Produto produto, Categoria categoria, List<Integer> categoriaId,
                                Fornecedor fornecedor, List<Integer> fornecedorId) {
    try {
                                     
        if (categoriaId != null && !categoriaId.isEmpty()) {
            List<Categoria> categorias = new ArrayList<>();
            for (Integer id : categoriaId) {
                categorias.add(categoriaRepository.findById(id).orElse(null));
            }
            produto.setCategoria(categoria);
        }
    
        if (fornecedorId != null && !fornecedorId.isEmpty()) {
            List<Fornecedor> fornecedors = new ArrayList<>();
            for (Integer id : fornecedorId) {
                fornecedors.add(fornecedorRepository.findById(id).orElse(null));
            }
            produto.setFornecedor(fornecedor);
        }
    
        produtoRepository.save(produto);
    
    } catch (NullPointerException e) {
        e.printStackTrace();
        System.out.println("Objetos vazios ... ");
        // TODO: handle exception
    }
       
        return "redirect:/listProduto";
    }
    

    @GetMapping("listaProduto")
    public ModelAndView listaProduto(){
        ModelAndView mv = new ModelAndView("listaProduto");
        List<Produto> produtos = produtoRepository.findAll();
        mv.addObject("produtos", produtos);
        return mv;
    }

}
