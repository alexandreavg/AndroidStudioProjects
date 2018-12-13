package com.cursoandroid.firebaseapp.com.cursoandroid.firebaseapp.domain;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Usuario {

    private String nome;
    private String sobreNome;
    private String sexo;
    private int idade;
    //private Endereco endereco;

    public Usuario(){

    }

    //public Endereco getEndereco() {
    //    return endereco;
    //}

    //public void setEndereco(Endereco endereco) {
    //    this.endereco = endereco;
    //}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
