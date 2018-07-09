package com.example.bruno.aplicativo3a.Entity;

public class ResponsavelEntity {
    int id, idAssistido;
    String nome_completo, cpf, rg, endereco, bairro, telefone, grau_parentesco, email, autorizado_retirar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAssistido() {
        return idAssistido;
    }

    public void setIdAssistido(int idAssistido) {
        this.idAssistido = idAssistido;
    }

    public String getNomeCompleto() {
        return nome_completo;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nome_completo = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getGrauParentesco() {
        return grau_parentesco;
    }

    public void setGrauParentesco(String grauParentesco) {
        this.grau_parentesco = grauParentesco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAutorizadoRetirar() {
        return autorizado_retirar;
    }

    public void setAutorizadoRetirar(String autorizado_retirar) {
        this.autorizado_retirar = autorizado_retirar;
    }
}
