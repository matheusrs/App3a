package com.example.bruno.aplicativo3a.ListagemEventos;

import android.database.Cursor;

import com.example.bruno.aplicativo3a.banco.CriaBD;
import com.example.bruno.aplicativo3a.entitiy.EventoEntity;

import java.util.ArrayList;
import java.util.List;

public class FragmentoListarEventosPresenter {
    FragmentoListarEventosView view;

    public FragmentoListarEventosPresenter(FragmentoListarEventosView view) {
        this.view = view;
    }

    public void listarEventos(Cursor cursorEventos){

        List<EventoEntity> eventos = new ArrayList<>();
        do
        {
            EventoEntity evento = new EventoEntity();
            evento.setId(cursorEventos.getString(cursorEventos.getColumnIndex(CriaBD.TABEVENTOS_ID)));
            evento.setTitulo(cursorEventos.getString(cursorEventos.getColumnIndex(CriaBD.TABEVENTOS_TITULO)));
            evento.setDataInicio(cursorEventos.getString(cursorEventos.getColumnIndex(CriaBD.TABEVENTOS_DATAINICIO)));
            evento.setDataFim(cursorEventos.getString(cursorEventos.getColumnIndex(CriaBD.TABEVENTOS_DATAFIM)));
            evento.setDescricao(cursorEventos.getString(cursorEventos.getColumnIndex(CriaBD.TABEVENTOS_DESCRICAO)));
            eventos.add(evento);
        } while(cursorEventos.moveToNext());


        view.updateListEventos(eventos);
    }
}
