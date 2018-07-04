package com.example.bruno.aplicativo3a.Eventos.ListagemEventos;

import android.content.Context;
import android.database.Cursor;

import com.example.bruno.aplicativo3a.banco.CriaBD;
import com.example.bruno.aplicativo3a.banco.EventosController;
import com.example.bruno.aplicativo3a.Entity.EventoEntity;

import java.util.ArrayList;
import java.util.List;

public class ListarEventosPresenter {
    ListarEventosView view;
    Context context;

    public ListarEventosPresenter(ListarEventosView view, Context context) {
        this.view = view;
        this.context = context;
    }

    public void listarEventos(){

        EventosController banco = new EventosController(context);
        Cursor cursorEventos = banco.carregaEventos();
        List<EventoEntity> eventos = new ArrayList<>();
        do
        {
            EventoEntity evento = new EventoEntity();
            evento.setId(cursorEventos.getString(cursorEventos.getColumnIndex(CriaBD.TABEVENTOS_ID)));
            evento.setTitulo(cursorEventos.getString(cursorEventos.getColumnIndex(CriaBD.TABEVENTOS_TITULO)));
            evento.setDataInicio(cursorEventos.getString(cursorEventos.getColumnIndex(CriaBD.TABEVENTOS_DATAINICIO)));
            evento.setDataFim(cursorEventos.getString(cursorEventos.getColumnIndex(CriaBD.TABEVENTOS_DATAFIM)));
            evento.setDescricao(cursorEventos.getString(cursorEventos.getColumnIndex(CriaBD.TABEVENTOS_DESCRICAO)));
            evento.setDespesas(cursorEventos.getString(cursorEventos.getColumnIndex(CriaBD.TABEVENTOS_DESPESAS)));
            evento.setReceitas(cursorEventos.getString(cursorEventos.getColumnIndex(CriaBD.TABEVENTOS_RECEITAS)));
            eventos.add(evento);
        } while(cursorEventos.moveToNext());


        view.updateListEventos(eventos);
    }

    public void listarEventos(String query){
        EventosController banco = new EventosController(context);
        Cursor cursorEventos = banco.carregaEventos(query);
        List<EventoEntity> eventos = new ArrayList<>();
        do
        {
            EventoEntity evento = new EventoEntity();
            evento.setId(cursorEventos.getString(cursorEventos.getColumnIndex(CriaBD.TABEVENTOS_ID)));
            evento.setTitulo(cursorEventos.getString(cursorEventos.getColumnIndex(CriaBD.TABEVENTOS_TITULO)));
            evento.setDataInicio(cursorEventos.getString(cursorEventos.getColumnIndex(CriaBD.TABEVENTOS_DATAINICIO)));
            evento.setDataFim(cursorEventos.getString(cursorEventos.getColumnIndex(CriaBD.TABEVENTOS_DATAFIM)));
            evento.setDescricao(cursorEventos.getString(cursorEventos.getColumnIndex(CriaBD.TABEVENTOS_DESCRICAO)));
            evento.setDespesas(cursorEventos.getString(cursorEventos.getColumnIndex(CriaBD.TABEVENTOS_DESPESAS)));
            evento.setReceitas(cursorEventos.getString(cursorEventos.getColumnIndex(CriaBD.TABEVENTOS_RECEITAS)));
            eventos.add(evento);
        } while(cursorEventos.moveToNext());
        view.updateListEventos(eventos);
    }
}
