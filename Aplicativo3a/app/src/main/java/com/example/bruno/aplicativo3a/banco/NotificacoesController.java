package com.example.bruno.aplicativo3a.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class NotificacoesController {
    private SQLiteDatabase db;
    private CriaBD criaBD;

    String[] camposNotificacoes =  {
            criaBD.TABNOTIFICACOES_ID,
            criaBD.TABNOTIFICACOES_IDDESTINATARIO,
            criaBD.TABNOTIFICACOES_IDMENSAGEM,
            criaBD.TABNOTIFICACOES_DATA_ENVIO,
            criaBD.TABNOTIFICACOES_DATA_LEITURA
    };

    public NotificacoesController(Context context) {
        criaBD = new CriaBD(context);
    }

    public boolean insereNotificacao(String id_destinatario, String id_mensagem, String data_envio, String data_leitura) {
        ContentValues valores;
        long resultado;

        db = criaBD.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBD.TABNOTIFICACOES_IDDESTINATARIO, id_destinatario);
        valores.put(CriaBD.TABNOTIFICACOES_IDMENSAGEM, id_mensagem);
        valores.put(CriaBD.TABNOTIFICACOES_DATA_ENVIO, data_envio);
        valores.put(CriaBD.TABNOTIFICACOES_DATA_LEITURA, data_leitura);

        resultado = db.insert(CriaBD.TABNOTIFICACOES, null, valores);
        db.close();

        if (resultado ==-1)
            return false;
        else
            return true;
    }

    public Cursor carregaMensagensRecebidasNaoLidas(int id_usuario){
        Cursor cursor;
        String where = CriaBD.TABNOTIFICACOES_IDDESTINATARIO + " = " + id_usuario
                + " AND " + CriaBD.TABNOTIFICACOES_DATA_LEITURA + " = null";
        db = criaBD.getReadableDatabase();
        cursor = db.query(criaBD.TABNOTIFICACOES, camposNotificacoes, where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaMensagensRecebidas(int id_usuario){
        Cursor cursor;
        String where = CriaBD.TABNOTIFICACOES_IDDESTINATARIO + " = " + id_usuario;
        db = criaBD.getReadableDatabase();
        cursor = db.query(criaBD.TABNOTIFICACOES, camposNotificacoes, where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
}
