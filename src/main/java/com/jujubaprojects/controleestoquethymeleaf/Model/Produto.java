package com.jujubaprojects.controleestoquethymeleaf.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private int qntEstoque;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "produto")
    private List<Movimentacao> movimentacao;


    public Produto(){
        
    }

    public Produto(int id, String nome, String descricao, double preco, int qntEstoque, Categoria categoria,
            Fornecedor fornecedor, List<Movimentacao> movimentacao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.qntEstoque = qntEstoque;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
        this.movimentacao = movimentacao;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }


    public int getQntEstoque() {
        return qntEstoque;
    }


    public void setQntEstoque(int qntEstoque) {
        this.qntEstoque = qntEstoque;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }



    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }



    public List<Movimentacao> getMovimentacao() {
        return movimentacao;
    }


    public void setMovimentacao(List<Movimentacao> movimentacao) {
        this.movimentacao = movimentacao;
    }



    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco
                + ", qntEstoque=" + qntEstoque + ", Categoria=" + categoria + ", fornecedor=" + fornecedor
                + ", movimentacao=" + movimentacao + "]";
    }



    public Categoria getCategoria() {
        return categoria;
    }



    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }



}
