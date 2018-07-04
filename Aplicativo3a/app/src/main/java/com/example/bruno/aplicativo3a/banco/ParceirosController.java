package com.example.bruno.aplicativo3a.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bruno.aplicativo3a.Entity.ParceiroEntity;

import java.util.ArrayList;
import java.util.List;

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

    public List<ParceiroEntity> carregaParceiros(){
        Cursor cursorParceiros;
        db = criaBD.getReadableDatabase();
        cursorParceiros = db.query(criaBD.TABPARCEIROS, camposParceiros, null, null, null, null, null, null);

        if(cursorParceiros!=null){
            cursorParceiros.moveToFirst();
        }
        List<ParceiroEntity> parceiros = new ArrayList<>();
        if (cursorParceiros.getCount() > 0)
            do
            {
                ParceiroEntity parceiro = new ParceiroEntity();
                parceiro.setId(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_ID)));
                parceiro.setCnpjCpf(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_CNPJCPF)));
                parceiro.setNome(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_NOME)));
                parceiro.setTelefone(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_TELEFONE)));
                parceiro.setDatavinculo(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_DATAVINCULO)));
                parceiro.setObservacoes(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_OBSERVACOES)));
                parceiros.add(parceiro);
            } while(cursorParceiros.moveToNext());
        db.close();
        cursorParceiros.close();
        return parceiros;
    }

    public List<ParceiroEntity> carregaParceiros(String nome){
        Cursor cursorParceiros;
        String where = "upper(" + CriaBD.TABPARCEIROS_NOME + ") like '%" + nome.toUpperCase() + "%'";
        db = criaBD.getReadableDatabase();
        cursorParceiros = db.query(criaBD.TABPARCEIROS, camposParceiros, where, null, null, null, null, null);

        if(cursorParceiros!=null){
            cursorParceiros.moveToFirst();
        } List<ParceiroEntity> parceiros = new ArrayList<>();
        if (cursorParceiros.getCount() > 0)
            do
            {
                ParceiroEntity parceiro = new ParceiroEntity();
                parceiro.setId(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_ID)));
                parceiro.setCnpjCpf(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_CNPJCPF)));
                parceiro.setNome(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_NOME)));
                parceiro.setTelefone(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_TELEFONE)));
                parceiro.setDatavinculo(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_DATAVINCULO)));
                parceiro.setObservacoes(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_OBSERVACOES)));
                parceiros.add(parceiro);
            } while(cursorParceiros.moveToNext());
        db.close();
        cursorParceiros.close();
        return parceiros;
    }

    public boolean atualizaParceiro(String id, String cnpjcpf, String nome,String telefone, String data_vinculo,String observacoes){
        ContentValues valores;
        long resultado;

        db = criaBD.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBD.TABPARCEIROS_NOME, nome);
        valores.put(CriaBD.TABPARCEIROS_CNPJCPF, cnpjcpf);
        valores.put(CriaBD.TABPARCEIROS_TELEFONE, telefone);
        valores.put(CriaBD.TABPARCEIROS_DATAVINCULO, data_vinculo);
        valores.put(CriaBD.TABPARCEIROS_OBSERVACOES, observacoes);

        resultado = db.update(CriaBD.TABPARCEIROS, valores, "_id="+id, null);
        db.close();

        if (resultado ==-1)
            return false;
        else
            return true;
    }

    public ParceiroEntity carregaParceiro(String id_parceiro) {
        Cursor cursor;
        ParceiroEntity parceiroEntity=new ParceiroEntity();

        String where = CriaBD.TABPARCEIROS_ID+ " = " + id_parceiro;
        db = criaBD.getReadableDatabase();
        cursor = db.query(criaBD.TABPARCEIROS, camposParceiros, where, null, null, null, null, null);
        try {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                parceiroEntity.setId(cursor.getString(cursor.getColumnIndex(criaBD.TABPARCEIROS_ID)));
                parceiroEntity.setCnpjCpf(cursor.getString(cursor.getColumnIndex(criaBD.TABPARCEIROS_CNPJCPF)));
                parceiroEntity.setNome(cursor.getString(cursor.getColumnIndex(criaBD.TABPARCEIROS_NOME)));
                parceiroEntity.setDatavinculo(cursor.getString(cursor.getColumnIndex(criaBD.TABPARCEIROS_DATAVINCULO)));
                parceiroEntity.setObservacoes(cursor.getString(cursor.getColumnIndex(criaBD.TABPARCEIROS_OBSERVACOES)));
                parceiroEntity.setTelefone(cursor.getString(cursor.getColumnIndex(criaBD.TABPARCEIROS_TELEFONE)));
                }
        } finally {
            cursor.close();
            db.close();
        }
        return parceiroEntity;
    }
}
