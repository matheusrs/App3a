package com.example.bruno.aplicativo3a.Assistidos.InserirAlterar;

import android.content.Context;

import com.example.bruno.aplicativo3a.banco.AssistidosController;

public class CadastroAssistidoPresenter {
    CadastroAssistidoView view;
    Context context;

    public CadastroAssistidoPresenter(CadastroAssistidoView view, Context context) {
        this.view = view;
        this.context = context;
    }

    public void salvarAssistido(String cpfAssistido, String rgAssistido, String nomeAssistido, String dataNascimentoAssistido, String tamanhoCalcadoAssistido, String tamanhoRoupaAssistido, String datasPresenteAssistido, String meioTransporteAssistido) {
        String message;
        AssistidosController banco = new AssistidosController(context);
        if (banco.insereAssistido(cpfAssistido, rgAssistido, nomeAssistido, dataNascimentoAssistido, tamanhoCalcadoAssistido, tamanhoRoupaAssistido, datasPresenteAssistido, meioTransporteAssistido))
            message = "Assistido cadastrado!";
        else
            message = "Erro ao gravar assistido";
        view.exibeMensagem(message);
    }

    public void atualizarAssistido(String idAssistido, String cpfAssistido, String rgAssistido, String nomeAssistido, String dataNascimentoAssistido, String tamanhoCalcadoAssistido, String tamanhoRoupaAssistido, String datasPresenteAssistido, String meioTransporteAssistido) {
        String message;
        AssistidosController banco = new AssistidosController(context);
        if (banco.atualizaAssistido(idAssistido, cpfAssistido, rgAssistido, nomeAssistido, dataNascimentoAssistido, tamanhoCalcadoAssistido, tamanhoRoupaAssistido, datasPresenteAssistido, meioTransporteAssistido))
            message = "Assistido atualizado!";
        else
            message = "Erro ao atualizar assistido";
        view.exibeMensagem(message);
    }

    public void alteraStatus(String idAssistido, boolean status){
        String message;
        AssistidosController banco = new AssistidosController(context);
        if (banco.atualizaStatusAssistido(Integer.valueOf(idAssistido), status)) {
            message = (status ? "Cadastro ativado!" : "Cadastro inativado!");
        } else {
            message = "Erro ao alterar o status do assistido!";
        }
        view.alteraTextoSwitchAtivo(status);
        view.exibeMensagem(message);

    }
}
