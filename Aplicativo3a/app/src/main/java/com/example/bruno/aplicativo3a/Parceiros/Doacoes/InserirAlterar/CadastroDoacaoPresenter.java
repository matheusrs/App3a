package com.example.bruno.aplicativo3a.Parceiros.Doacoes.InserirAlterar;

import android.content.Context;

import com.example.bruno.aplicativo3a.Entity.DoacaoEntity;
import com.example.bruno.aplicativo3a.banco.DoacoesController;

public class CadastroDoacaoPresenter {
    CadastroDoacaoView view;
    Context context;


    public CadastroDoacaoPresenter(CadastroDoacaoView view, Context context) {
        this.view = view;
        this.context = context;
    }

    public void salvarDoacao(String idParceiroDoacao, String dataDoacao, String descricaoDoacao) {
        String message;
        DoacoesController banco = new DoacoesController(context);
        if (banco.insereDoacao(idParceiroDoacao, dataDoacao, descricaoDoacao))
            message = "Doação adicionada!";
        else
            message = "Erro ao gravar doação";
        view.exibeMensagem(idParceiroDoacao, message);
    }

    public void atualizarDoacao(String idDoacao, String idParceiroDoacao, String dataDoacao, String descricaoDoacao) {
        String message;
        DoacoesController banco = new DoacoesController(context);
        if (banco.atualizaDoacao(idDoacao, idParceiroDoacao, dataDoacao, descricaoDoacao))
            message = "Doação atualizada!";
        else
            message = "Erro ao atualizar doação";
        view.exibeMensagem(idParceiroDoacao, message);
    }

    public DoacaoEntity carregaDoacao(String idDoacao){
        DoacoesController banco = new DoacoesController(context);
        DoacaoEntity doacao = banco.carregaDoacao(idDoacao);
        return doacao;
    }
}
