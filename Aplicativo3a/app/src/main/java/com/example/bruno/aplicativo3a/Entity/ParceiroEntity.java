package com.example.bruno.aplicativo3a.Entity;

public class ParceiroEntity {
    String id,cpfcnpj,nome,telefone,datavinculo,observacoes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCnpjCpf() {
        return cpfcnpj;
    }

    public void setCnpjCpf(String cpfcnpj) {
        this.cpfcnpj = cpfcnpj;
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

    public String getDatavinculo() {
        return datavinculo;
    }

    public void setDatavinculo(String datavinculo) {
        this.datavinculo = datavinculo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
