package com.example.bruno.aplicativo3a.Eventos.InserirAlterar;

import android.content.Context;

import com.example.bruno.aplicativo3a.banco.EventosController;

public class CadastroEventoPresenter {

    CadastroEventoView view;
    Context context;

    public CadastroEventoPresenter(CadastroEventoView view, Context context) {
        this.view = view;
        this.context = context;
    }

    public void salvarEvento(String tituloEvento, String dataInicioEvento, String dataFimEvento, String descricaoEvento, String gastos, String receitas) {
        String message;
        EventosController banco = new EventosController(context);
        if (banco.insereEvento(tituloEvento, dataInicioEvento, dataFimEvento, descricaoEvento, gastos, receitas))
            message = "Evento cadastrado!";
        else
            message = "Erro ao gravar evento";
        view.exibeMensagem(message);
    }

    public void atualizarEvento(String idEvento, String tituloEvento, String dataInicioEvento, String dataFimEvento, String descricaoEvento, String gastos, String receitas) {
        String message;
        EventosController banco = new EventosController(context);
        if (banco.atualizaEvento(idEvento,tituloEvento, dataInicioEvento, dataFimEvento, descricaoEvento, gastos, receitas))
            message = "Evento atualizado!";
        else
            message = "Erro ao atualizar evento";
        view.exibeMensagem(message);

    }
}
