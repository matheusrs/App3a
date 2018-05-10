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
        valores.put(CriaBD.TABASSISTIDOS_NOME, nome);
        valores.put(CriaBD.TABASSISTIDOS_SOBRENOME, sobrenome);
        valores.put(CriaBD.TABASSISTIDOS_TELEFONE, telefone);
        valores.put(CriaBD.TABASSISTIDOS_DEFICIENCIA, deficiencia);
        valores.put(CriaBD.TABASSISTIDOS_OBSERVACOES, observacoes);

        resultado = db.insert(CriaBD.TABASSISTIDOS, null, valores);
        db.close();

        if (resultado ==-1)
            return false;
        else
            return true;
    }

    /*public Cursor carregaAssistidos(){
        Cursor cursor;
        String sql = "SELECT NOME,SOBRENOME,TELEFONE,DEFICIENCIA,OBSERVACOES FROM ASSISTIDOS";
        db = criaBD.getReadableDatabase();
        cursor = db.rawQuery(sql,null);
        //db.close();
        return cursor;
    }*/

    public Cursor carregaAssistidos(){
        Cursor cursor;
        String[] campos =  {criaBD.TABASSISTIDOS_ID, criaBD.TABASSISTIDOS_NOME, criaBD.TABASSISTIDOS_SOBRENOME, criaBD.TABASSISTIDOS_TELEFONE, criaBD.TABASSISTIDOS_DEFICIENCIA, criaBD.TABASSISTIDOS_OBSERVACOES};
        db = criaBD.getReadableDatabase();
        cursor = db.query(criaBD.TABASSISTIDOS, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaAssistidos(String nome) {
        Cursor cursor;
        String [] campos = {criaBD.TABASSISTIDOS_ID,criaBD.TABASSISTIDOS_NOME,criaBD.TABASSISTIDOS_SOBRENOME,criaBD.TABASSISTIDOS_TELEFONE,criaBD.TABASSISTIDOS_DEFICIENCIA,criaBD.TABASSISTIDOS_OBSERVACOES};
        String where = CriaBD.TABASSISTIDOS_NOME + "like %" + nome + "%";
        db = criaBD.getReadableDatabase();
        cursor = db.query(criaBD.TABASSISTIDOS,campos, where, null,null,null,null,null);
        if(cursor!=null)
            cursor.moveToFirst();
        db.close();
        return cursor;
    }
}
