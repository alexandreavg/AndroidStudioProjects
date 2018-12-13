package com.cursoandroid.domain;

public class Usuario {

    private String nome;
    private String senha;

    public Usuario(){
        nome = new String();
        senha = new String();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
