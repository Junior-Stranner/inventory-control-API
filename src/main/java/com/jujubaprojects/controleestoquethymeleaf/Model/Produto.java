package com.jujubaprojects.controleestoquethymeleaf.Model;

import java.util.List;
import java.util.UUID;


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
    private UUID id;
    private String nome;
    private String descricao;
    private double preco;
    private int qntEstoque;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoria_id")
    private CategoriaProd Categoria;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fornrcrdor_id")
    private Fornecedor fornecedor;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "produto")
    private List<MovimentacaoProd> movimentacaoProds;


    public Produto(){
        
    }



    public Produto(UUID id, String nome, String descricao, double preco, int qntEstoque,
            com.jujubaprojects.controleestoquethymeleaf.Model.CategoriaProd categoria, Fornecedor fornecedor) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.qntEstoque = qntEstoque;
        Categoria = categoria;
        this.fornecedor = fornecedor;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public CategoriaProd getCategoria() {
        return Categoria;
    }

    public void setCategoria(CategoriaProd categoria) {
        Categoria = categoria;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }



    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco
                + ", qntEstoque=" + qntEstoque + ", Categoria=" + Categoria + ", fornecedor=" + fornecedor
                + ", movimentacaoProds=" + movimentacaoProds + "]";
    }

    
    
}
