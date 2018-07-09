package com.example.bruno.aplicativo3a.Assistidos.Listagem;

import android.content.Context;
import android.database.Cursor;

import com.example.bruno.aplicativo3a.banco.AssistidosController;
import com.example.bruno.aplicativo3a.banco.CriaBD;
import com.example.bruno.aplicativo3a.Entity.AssistidoEntity;

import java.util.ArrayList;
import java.util.List;

public class ListarAssistidosPresenter {
    ListarAssistidosView view;
    Context context;

    public ListarAssistidosPresenter(ListarAssistidosView view, Context context) {
        this.view = view;
        this.context = context;
    }

    public void listarAssistidos(){
        AssistidosController banco = new AssistidosController(context);
        List<AssistidoEntity> assistidos = banco.carregaAssistidos();

        view.updateListAssistidos(assistidos);
    }

    public void listarAssistidos(String query){
        AssistidosController banco = new AssistidosController(context);
        List<AssistidoEntity> assistidos =  banco.carregaAssistidos(query);
        view.updateListAssistidos(assistidos);
    }
}
