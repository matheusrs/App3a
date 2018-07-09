package com.example.bruno.aplicativo3a.Assistidos.Exibir;

import android.content.Context;
import com.example.bruno.aplicativo3a.Entity.AssistidoEntity;
import com.example.bruno.aplicativo3a.banco.AssistidosController;

public class ExibirAssitidoPresenter {

    ExibirAssitidoView view;
    Context context;

    ExibirAssitidoPresenter (ExibirAssitidoView view, Context context) {
        this.view = view;
        this.context = context;
    }

    public AssistidoEntity carregaAssistido(int id){
        AssistidosController banco = new AssistidosController(context);
        AssistidoEntity assistido = banco.selectAssistido(id);
        return assistido;
    }

}
