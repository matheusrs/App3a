package com.example.bruno.aplicativo3a.Assistidos.Medicamentos.InserirAlterar;

import android.content.Context;

import com.example.bruno.aplicativo3a.banco.DoacoesController;
import com.example.bruno.aplicativo3a.banco.MedicamentoAssistidoController;

public class CadastroMedicamentoPresenter {
    CadastroMedicamentoView view;
    Context context;


    public CadastroMedicamentoPresenter(CadastroMedicamentoView view, Context context) {
        this.view = view;
        this.context = context;
    }

    public void salvarMedicamento(String idAssistidoMedicamento, String nomeMedicamento, String observacoesMedicamento) {
        String message;
        MedicamentoAssistidoController banco = new MedicamentoAssistidoController(context);
        if (banco.insereMedicamentoAssistido(idAssistidoMedicamento, nomeMedicamento, observacoesMedicamento))
            message = "Medicamento adicionado!";
        else
            message = "Erro ao gravar medicamento";
        view.exibeMensagem(message);
    }

    public void atualizarMedicamento(String idMedicamento, String idAssistidoMedicamento, String nomeMedicamento, String observacoesMedicamento) {
        String message;
        MedicamentoAssistidoController banco = new MedicamentoAssistidoController(context);
        if (banco.atualizaMedicamentoAssistido(idMedicamento, idAssistidoMedicamento, nomeMedicamento, observacoesMedicamento))
            message = "Medicamento atualizado!";
        else
            message = "Erro ao atualizar medicamento";
        view.exibeMensagem(message);
    }
}
