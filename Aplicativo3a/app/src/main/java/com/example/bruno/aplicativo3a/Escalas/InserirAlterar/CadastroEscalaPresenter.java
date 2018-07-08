package com.example.bruno.aplicativo3a.Escalas.InserirAlterar;

import android.content.Context;

import com.example.bruno.aplicativo3a.banco.EscalasController;


public class CadastroEscalaPresenter {
    CadastroEscalaView view;
    Context context;

    CadastroEscalaPresenter(CadastroEscalaView view, Context context){
        this.context=context;
        this.view=view;
    }

    void insereFuncionario(String dia,String turno,String nome,String especialidade){
        EscalasController banco = new EscalasController(context);
        String message;
        if(turno.equals("Manhã"))
            turno = "manha";
        else if(turno.equals("Almoço"))
            turno = "almoco";
        else
            turno = "tarde";
        if(dia.equals("Terça"))
            dia = "terca";
        else
            dia = dia.toLowerCase();
        boolean res= banco.insereEscala(dia, turno, nome, especialidade);
        if(res)
            message = "Adicionado com sucesso!";
        else
            message = "Erro ao adicionar na escala!";
        view.exibeMensagem(message);

    }
}
