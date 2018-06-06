package com.example.bruno.aplicativo3a.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bruno.aplicativo3a.entitiy.EventoEntity;

public class EventosController {

    private SQLiteDatabase db;
    private CriaBD criaBD;
    String[] camposEventos =  {
            criaBD.TABEVENTOS_ID,
            criaBD.TABEVENTOS_TITULO,
            criaBD.TABEVENTOS_DESCRICAO,
            criaBD.TABEVENTOS_DATAINICIO,
            criaBD.TABEVENTOS_DATAFIM
    };

    public EventosController(Context context) {
        criaBD = new CriaBD(context);
    }


    public boolean insereEvento(String titulo,String dataInicio, String dataFim, String descricao){
        ContentValues valores;
        long resultado;

        db = criaBD.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBD.TABEVENTOS_TITULO, titulo);
        valores.put(CriaBD.TABEVENTOS_DESCRICAO, descricao);
        valores.put(CriaBD.TABEVENTOS_DATAINICIO, dataInicio);
        valores.put(CriaBD.TABEVENTOS_DATAFIM, dataFim);

        resultado = db.insert(CriaBD.TABEVENTOS, null, valores);
        db.close();

        if (resultado ==-1)
            return false;
        else
            return true;
    }

    public Cursor carregaEventos(){
        Cursor cursor;
        db = criaBD.getReadableDatabase();
        cursor = db.query(criaBD.TABEVENTOS, camposEventos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaEventos(String nome) {
        Cursor cursor;
        String where = "upper(" + CriaBD.TABEVENTOS_TITULO + ") like '%" + nome.toUpperCase() + "%'";
        db = criaBD.getReadableDatabase();
        cursor = db.query(criaBD.TABEVENTOS,camposEventos, where, null,null,null,null,null);
        if(cursor!=null)
            cursor.moveToFirst();
        db.close();
        return cursor;
    }

    public EventoEntity selectEvento(int id_evento) {
        Cursor cursorEvento;
        EventoEntity evento = new EventoEntity();

        String where = CriaBD.TABEVENTOS_ID + "=" + id_evento;
        db = criaBD.getReadableDatabase();
        cursorEvento = db.query(criaBD.TABEVENTOS, camposEventos, where, null, null, null, null, null);
        try {
            if (cursorEvento.getCount() > 0) {
                cursorEvento.moveToFirst();
                evento.setId(cursorEvento.getString(cursorEvento.getColumnIndex(criaBD.TABEVENTOS_ID)));
                evento.setTitulo(cursorEvento.getString(cursorEvento.getColumnIndex(criaBD.TABEVENTOS_TITULO)));
                evento.setDataInicio(cursorEvento.getString(cursorEvento.getColumnIndex(criaBD.TABEVENTOS_DATAINICIO)));
                evento.setDataFim(cursorEvento.getString(cursorEvento.getColumnIndex(criaBD.TABEVENTOS_DATAFIM)));
                evento.setDescricao(cursorEvento.getString(cursorEvento.getColumnIndex(criaBD.TABEVENTOS_DESCRICAO)));
            }
        } finally {
            cursorEvento.close();
            db.close();
        }
        return evento;
    }

    public boolean atualizaEvento(String id, String titulo, String dataInicio, String dataFim, String descricao){
        ContentValues valores;
        long resultado;

        db = criaBD.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBD.TABEVENTOS_TITULO, titulo);
        valores.put(CriaBD.TABEVENTOS_DESCRICAO, descricao);
        valores.put(CriaBD.TABEVENTOS_DATAINICIO, dataInicio);
        valores.put(CriaBD.TABEVENTOS_DATAFIM, dataFim);

        resultado = db.update(CriaBD.TABEVENTOS, valores, "_id="+id, null);
        db.close();

        if (resultado ==-1)
            return false;
        else
            return true;
    }
}
