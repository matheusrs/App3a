package com.example.bruno.aplicativo3a.Eventos.Exibir;

import android.content.Context;

import com.example.bruno.aplicativo3a.Entity.EventoEntity;
import com.example.bruno.aplicativo3a.banco.EventosController;

public class ExibirEventoPresenter {
    ExibirEventoView view;
    Context context;

    ExibirEventoPresenter(ExibirEventoView view,Context context){
        this.view=view;
        this.context=context;
    }

    public EventoEntity carregaEvento(int id){
        EventosController banco = new EventosController(context);
        EventoEntity eventoEntity=banco.selectEvento(id);
        return eventoEntity;
    }
}
