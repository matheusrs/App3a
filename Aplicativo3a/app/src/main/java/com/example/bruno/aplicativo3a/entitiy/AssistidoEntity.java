package com.example.bruno.aplicativo3a.entitiy;

public class AssistidoEntity {
    String id,cpf,nome,sobrenome,telefone, datanascimento,deficiencia,observacoes,statusativo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCPF() { return cpf; }

    public void setCPF(String cpf) { this.cpf = cpf; }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() { return telefone; }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return datanascimento;
    }

    public void setDataNascimento(String datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getDeficiencia() {
        return deficiencia;
    }

    public void setDeficiencia(String deficiencia) {
        this.deficiencia = deficiencia;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getStatusAtivo() {
        return statusativo;
    }

    public void setStatusAtivo(String statusativo) {
        this.statusativo = statusativo;
    }
}
