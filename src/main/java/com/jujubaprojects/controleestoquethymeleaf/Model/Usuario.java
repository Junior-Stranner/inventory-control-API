package com.jujubaprojects.controleestoquethymeleaf.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String tipo;

   /*  @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_tipos" , joinColumns = @JoinColumn(name = "usuarios_is"),
    inverseJoinColumns = @JoinColumn(name = "tipo_id"))
    private List <Tipo> tipos;*/



public Usuario(){
}

public Usuario(int id, String nome, String email, String senha, String tipo) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.senha = senha;
    this.tipo = tipo;
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

public String getTipo() {
    return tipo;
}

public void setTipo(String tipo) {
    this.tipo = tipo;
}
  

}
