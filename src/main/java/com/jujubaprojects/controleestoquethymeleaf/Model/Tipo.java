package com.jujubaprojects.controleestoquethymeleaf.Model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipos")
public class Tipo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String descricao;

    @ManyToMany(mappedBy = "tipos",fetch = FetchType.EAGER)
    private List<Usuario> usuarios;


    public Tipo(){

    }


    public UUID getId() {
        return id;
    }


    public void setId(UUID id) {
        this.id = id;
    }


    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public List<Usuario> getUsuarios() {
        return usuarios;
    }


    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }


    public Tipo(UUID id, String descricao, List<Usuario> usuarios) {
        this.id = id;
        this.descricao = descricao;
        this.usuarios = usuarios;
    }

    public boolean verificarPermissao(Usuario usuario, String tela) {
        // Lógica para verificar se o usuário tem permissão para acessar a tela (exemplo simplificado)
        // Aqui você pode ter regras específicas de permissão baseadas nos papéis/roles do usuário
    
        if (usuario.getRoles().contains("Admin")) {
            return true; // O usuário com papel Admin tem permissão para todas as telas
        } else if (usuario.getRoles().contains("Comum")) {
            // Exemplo: Usuário com papel Comum só tem permissão para uma tela específica
            return tela.equals("paginaInicial");
        }
    
        return false; // Usuário não tem permissão para acessar a tela
        }
   
}
