package com.servi.osgoverno.demo.model.dto;

import com.servi.osgoverno.demo.model.domain.Servicos;

import java.io.Serializable;

public class SecretariaDTO implements Serializable {

    private long id;
    private String nome;
    private String telefone;
    private Servicos servicos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Servicos getServicos() {
        return servicos;
    }

    public void setServicos(Servicos servicos) {
        this.servicos = servicos;
    }
}

