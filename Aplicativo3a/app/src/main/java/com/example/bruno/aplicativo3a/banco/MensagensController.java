package com.example.bruno.aplicativo3a.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MensagensController {
    private SQLiteDatabase db;
    private CriaBD criaBD;

    String[] camposMensagens =  {
            criaBD.TABMENSAGENS_ID,
            criaBD.TABMENSAGENS_IDAUTOR,
            criaBD.TABMENSAGENS_ASSUNTO,
            criaBD.TABMENSAGENS_CONTEUDO
    };

    public MensagensController(Context context) {
        criaBD = new CriaBD(context);
    }

    public boolean insereMensagem(String id_autor, String assunto,String conteudo){
        ContentValues valores;
        long resultado;

        db = criaBD.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBD.TABMENSAGENS_IDAUTOR, id_autor);
        valores.put(CriaBD.TABMENSAGENS_ASSUNTO, assunto);
        valores.put(CriaBD.TABMENSAGENS_CONTEUDO, conteudo);

        resultado = db.insert(CriaBD.TABMENSAGENS, null, valores);
        db.close();

        if (resultado ==-1)
            return false;
        else
            return true;
    }

    public Cursor carregaMensagensEmitidas(int id_usuario){
        Cursor cursor;
        String where = criaBD.TABMENSAGENS_IDAUTOR + " = " + id_usuario;
        db = criaBD.getReadableDatabase();
        cursor = db.query(criaBD.TABMENSAGENS, camposMensagens, where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaMensagem(String id_mensagem) {
        Cursor cursor;
        String where = CriaBD.TABMENSAGENS+ " = " + id_mensagem;
        db = criaBD.getReadableDatabase();
        cursor = db.query(criaBD.TABMENSAGENS, camposMensagens, where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

}
