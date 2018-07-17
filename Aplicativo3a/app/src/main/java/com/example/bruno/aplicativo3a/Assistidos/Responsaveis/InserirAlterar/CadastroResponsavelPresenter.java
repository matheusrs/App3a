package com.example.bruno.aplicativo3a.Assistidos.Responsaveis.InserirAlterar;

import android.content.Context;

import com.example.bruno.aplicativo3a.banco.ResponsavelAssistidoController;

public class CadastroResponsavelPresenter {
    CadastroResponsavelView view;
    Context context;


    public CadastroResponsavelPresenter(CadastroResponsavelView view, Context context) {
        this.view = view;
        this.context = context;
    }

    public void salvarResponsavel(String idAssistido, String nomeCompleto, String cpf, String rg, String endereco, String bairro, String telefone, String grauParentesco, String email, String autorizado_retirar) {
        String message;
        ResponsavelAssistidoController banco = new ResponsavelAssistidoController(context);
        if (banco.insereResponsavelAssistido(idAssistido, nomeCompleto, cpf, rg, endereco, bairro, telefone, grauParentesco, email, autorizado_retirar))
            message = "Responsável adicionado!";
        else
            message = "Erro ao gravar responsável";
        view.exibeMensagem(message);
    }

    public void atualizarResponsavel(String idResponsavel, String idAssistido, String nomeCompleto, String cpf, String rg, String endereco, String bairro, String telefone, String grauParentesco, String email, String autorizado_retirar) {
        String message;
        ResponsavelAssistidoController banco = new ResponsavelAssistidoController(context);
        if (banco.atualizaResponsavelAssistido(idResponsavel, idAssistido, nomeCompleto, cpf, rg, endereco, bairro, telefone, grauParentesco, email, autorizado_retirar))
            message = "Responsável atualizado!";
        else
            message = "Erro ao atualizar responsável";
        view.exibeMensagem(message);
    }
}
