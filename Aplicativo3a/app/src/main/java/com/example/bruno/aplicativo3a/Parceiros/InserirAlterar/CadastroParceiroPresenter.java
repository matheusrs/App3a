package com.example.bruno.aplicativo3a.Parceiros.InserirAlterar;

import android.content.Context;

import com.example.bruno.aplicativo3a.banco.ParceirosController;

public class CadastroParceiroPresenter {
    CadastroParceiroView view;
    Context context;


    public CadastroParceiroPresenter(CadastroParceiroView view, Context context) {
        this.view = view;
        this.context = context;
    }

    public void salvarParceiro(String cnpjCpfParceiro, String nomeParceiro, String telefoneParceiro, String datavinculoParceiro, String observacoesParceiro){
        String message;
        ParceirosController banco = new ParceirosController(context);
        if (banco.insereParceiro(cnpjCpfParceiro , nomeParceiro, telefoneParceiro, datavinculoParceiro, observacoesParceiro))
            message = "Parceiro cadastrado!";
        else
            message = "Erro ao gravar parceiro";
        view.exibeMensagem(message);
    }

    public void atualizarParceiro(String idParceiro, String cnpjCpfParceiro, String nomeParceiro, String telefoneParceiro, String datavinculoParceiro, String observacoesParceiro){
        String message;
        ParceirosController banco = new ParceirosController(context);
        if (banco.atualizaParceiro(idParceiro, cnpjCpfParceiro , nomeParceiro, telefoneParceiro, datavinculoParceiro, observacoesParceiro))
            message = "Parceiro atualizado!";
        else
            message = "Erro ao atualizar parceiro";
        view.exibeMensagem(message);
    }
}
