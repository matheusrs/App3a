package com.example.bruno.aplicativo3a.Entity;

public class EventoEntity {
    String id,titulo,descricao, dataInicio, dataFim, despesas, receitas;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getDespesas() {
        return despesas;
    }

    public void setDespesas(String despesas) {
        this.despesas = despesas;
    }

    public String getReceitas() {
        return receitas;
    }

    public void setReceitas(String receitas) {
        this.receitas = receitas;
    }
}
