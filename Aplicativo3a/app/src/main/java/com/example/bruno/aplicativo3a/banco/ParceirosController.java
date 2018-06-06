package com.example.bruno.aplicativo3a.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bruno.aplicativo3a.entitiy.ParceiroEntity;

public class ParceirosController {
    private SQLiteDatabase db;
    private CriaBD criaBD;

    String[] camposParceiros =  {
            criaBD.TABPARCEIROS_ID,
            criaBD.TABPARCEIROS_CNPJCPF,
            criaBD.TABPARCEIROS_NOME,
            criaBD.TABPARCEIROS_DATAVINCULO,
            criaBD.TABPARCEIROS_TELEFONE,
            criaBD.TABPARCEIROS_OBSERVACOES
    };

    public ParceirosController(Context context) {
        criaBD = new CriaBD(context);
    }

    public boolean insereParceiro(String cnpjcpf, String nome,String telefone, String data_vinculo,String observacoes){
        ContentValues valores;
        long resultado;

        db = criaBD.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBD.TABPARCEIROS_CNPJCPF, cnpjcpf);
        valores.put(CriaBD.TABPARCEIROS_NOME, nome);
        valores.put(CriaBD.TABPARCEIROS_TELEFONE, telefone);
        valores.put(CriaBD.TABPARCEIROS_DATAVINCULO, data_vinculo);
        valores.put(CriaBD.TABPARCEIROS_OBSERVACOES, observacoes);

        resultado = db.insert(CriaBD.TABPARCEIROS, null, valores);
        db.close();

        if (resultado ==-1)
            return false;
        else
            return true;
    }

    public Cursor carregaParceiros(){
        Cursor cursor;
        db = criaBD.getReadableDatabase();
        cursor = db.query(criaBD.TABPARCEIROS, camposParceiros, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaParceiros(String nome){
        Cursor cursor;
        String where = "upper(" + CriaBD.TABPARCEIROS_NOME + ") like '%" + nome.toUpperCase() + "%'";
        db = criaBD.getReadableDatabase();
        cursor = db.query(criaBD.TABPARCEIROS, camposParceiros, where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public boolean atualizaParceiro(String id, String cnpjcpf, String nome,String telefone, String data_vinculo,String observacoes){
        ContentValues valores;
        long resultado;

        db = criaBD.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBD.TABASSISTIDOS_CPF, cnpjcpf);
        valores.put(CriaBD.TABASSISTIDOS_NOME, nome);
        valores.put(CriaBD.TABASSISTIDOS_TELEFONE, telefone);
        valores.put(CriaBD.TABASSISTIDOS_DATANASCIMENTO, data_vinculo);
        valores.put(CriaBD.TABASSISTIDOS_OBSERVACOES, observacoes);

        resultado = db.update(CriaBD.TABASSISTIDOS, valores, "_id="+id, null);
        db.close();

        if (resultado ==-1)
            return false;
        else
            return true;
    }

    public Cursor carregaParceiro(String id_parceiro) {
        Cursor cursor;
        String where = CriaBD.TABPARCEIROS_ID+ " = " + id_parceiro;
        db = criaBD.getReadableDatabase();
        cursor = db.query(criaBD.TABPARCEIROS, camposParceiros, where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
}
