package com.example.bruno.aplicativo3a.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DoacoesController {

    private SQLiteDatabase db;
    private CriaBD criaBD;

    String[] camposDoacoes =  {
            criaBD.TABDOACOES_ID,
            criaBD.TABDOACOES_PARCEIROID,
            criaBD.TABDOACOES_DATADOACAO,
            criaBD.TABDOACOES_DESCRICAO
    };

    public DoacoesController(Context context) {
        criaBD = new CriaBD(context);
    }

    public boolean insereDoacao(String id_parceiro,String descricao,String dataDoacao){
        ContentValues valores;
        long resultado;

        db = criaBD.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBD.TABDOACOES_PARCEIROID, id_parceiro);
        valores.put(CriaBD.TABDOACOES_DATADOACAO,dataDoacao);
        valores.put(CriaBD.TABDOACOES_DESCRICAO, descricao);

        resultado = db.insert(CriaBD.TABASSISTIDOS, null, valores);
        db.close();

        if (resultado ==-1)
            return false;
        else
            return true;
    }

    public Cursor carregaDoacoes(){
        Cursor cursor;
        db = criaBD.getReadableDatabase();
        cursor = db.query(criaBD.TABDOACOES, camposDoacoes, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
}
