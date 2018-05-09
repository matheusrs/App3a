package com.example.bruno.aplicativo3a.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BancoController {

    private SQLiteDatabase db;
    private CriaBD criaBD;

    public BancoController(Context context) {
        criaBD = new CriaBD(context);
    }

    public boolean insereAssistido(String nome,String sobrenome,String telefone,String deficiencia,String observacoes){
        ContentValues valores;
        long resultado;

        db = criaBD.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBD.NOME, nome);
        valores.put(CriaBD.SOBRENOME, sobrenome);
        valores.put(CriaBD.TELEFONE, telefone);
        valores.put(CriaBD.DEFICIENCIA, deficiencia);
        valores.put(CriaBD.OBSERVACOES, observacoes);

        resultado = db.insert(CriaBD.TABASSISTIDOS, null, valores);
        db.close();

        if (resultado ==-1)
            return false;
        else
            return true;
    }

    public Cursor carregaAssistidos(){
        Cursor cursor;
        String sql = "SELECT NOME,SOBRENOME,TELEFONE,DEFICIENCIA,OBSERVACOES FROM ASSISTIDOS";
        db = criaBD.getReadableDatabase();
        cursor = db.rawQuery(sql,null);
        //db.close();
        return cursor;
    }
}
