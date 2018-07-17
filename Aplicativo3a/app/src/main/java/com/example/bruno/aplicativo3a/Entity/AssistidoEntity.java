package com.example.bruno.aplicativo3a.Entity;

public class AssistidoEntity {
    int id;
    String cpf, rg, nome_completo, data_nascimento, tamanho_calcado, tamanho_roupa, datas_presentes, meio_transporte, status_ativo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getNomeCompleto() {
        return nome_completo;
    }

    public void setNomeCompleto(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public String getDataNascimento() {
        return data_nascimento;
    }

    public void setDataNascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getTamanhoCalcado() {
        return tamanho_calcado;
    }

    public void setTamanhoCalcado(String tamanho_calcado) {
        this.tamanho_calcado = tamanho_calcado;
    }

    public String getTamanhoRoupa() {
        return tamanho_roupa;
    }

    public void setTamanhoRoupa(String tamanho_roupa) {
        this.tamanho_roupa = tamanho_roupa;
    }

    public String getDatasPresentes() {
        return datas_presentes;
    }

    public void setDatasPresentes(String datas_presentes) {
        this.datas_presentes = datas_presentes;
    }

    public String getMeioTransporte() {
        return meio_transporte;
    }

    public void setMeioTransporte(String meio_transporte) {
        this.meio_transporte = meio_transporte;
    }

    public String getStatusAtivo() {
        return status_ativo;
    }

    public void setStatusAtivo(String status_ativo) {
        this.status_ativo = status_ativo;
    }
}
