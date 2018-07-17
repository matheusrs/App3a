package com.example.bruno.aplicativo3a.Entity;

public class MedicamentoEntity {
    int id, id_assistido;
    String nome_medicamento, observacoes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAssistido() {
        return id_assistido;
    }

    public void setIdAssistido(int id_assistido) {
        this.id_assistido = id_assistido;
    }

    public String getNomeMedicamento() {
        return nome_medicamento;
    }

    public void setNomeMedicamento(String nome_medicamento) {
        this.nome_medicamento = nome_medicamento;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
