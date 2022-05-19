package com.servi.osgoverno.demo.model.dto;

import com.servi.osgoverno.demo.model.domain.Secretaria;

import java.io.Serializable;

public class ServicosDTO implements Serializable {

    private long id;
    private String nome;
    private Secretaria secretaria;

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

    public Secretaria getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }
}
