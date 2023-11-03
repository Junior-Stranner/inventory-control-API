package com.jujubaprojects.controleestoquethymeleaf.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String nome;
    private String email;
    private String senha;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_tipos" , joinColumns = @JoinColumn(name = "usuarios_is"),
    inverseJoinColumns = @JoinColumn(name = "tipo_id"))
    private List <Tipo> tipos;

    private Set<String> roles = new HashSet<>();




public Usuario(){
}
    

  

    public Usuario(UUID id, String nome, String email, String senha, List<Tipo> tipos, Set<String> roles) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.senha = senha;
    this.tipos = tipos;
    this.roles = roles;
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




    public String getEmail() {
        return email;
    }




    public void setEmail(String email) {
        this.email = email;
    }




    public String getSenha() {
        return senha;
    }




    public void setSenha(String senha) {
        this.senha = senha;
    }




    public List<Tipo> getTipos() {
        return tipos;
    }




    public void setTipos(List<Tipo> tipos) {
        this.tipos = tipos;
    }




    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }




    public String getRoles() {
        return null;
    }



}
