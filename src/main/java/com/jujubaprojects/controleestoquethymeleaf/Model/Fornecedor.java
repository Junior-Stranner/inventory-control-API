package com.jujubaprojects.controleestoquethymeleaf.Model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "fornecedores")
public class Fornecedor {

       @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String nome;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fornecedor")
    private List<Produto>prosutos;

    public Fornecedor(){
        
    }

    public Fornecedor(UUID id, String nome, List<Produto> prosutos) {
        this.id = id;
        this.nome = nome;
        this.prosutos = prosutos;
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

    public List<Produto> getProsutos() {
        return prosutos;
    }

    public void setProsutos(List<Produto> prosutos) {
        this.prosutos = prosutos;
    }

    
}
