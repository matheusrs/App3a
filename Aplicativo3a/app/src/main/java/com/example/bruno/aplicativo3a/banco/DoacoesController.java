package com.example.bruno.aplicativo3a.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bruno.aplicativo3a.Entity.DoacaoEntity;

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

    public boolean insereDoacao(String id_parceiro,String dataDoacao,String descricao){
        ContentValues valores;
        long resultado;

        db = criaBD.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBD.TABDOACOES_PARCEIROID, Integer.valueOf(id_parceiro));
        valores.put(CriaBD.TABDOACOES_DATADOACAO,dataDoacao);
        valores.put(CriaBD.TABDOACOES_DESCRICAO, descricao);

        resultado = db.insert(CriaBD.TABDOACOES, null, valores);
        db.close();

        if (resultado ==-1)
            return false;
        else
            return true;
    }

    public boolean atualizaDoacao(String id_doacao, String id_parceiro, String dataDoacao, String descricao) {
        ContentValues valores;
        long resultado;

        db = criaBD.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBD.TABDOACOES_PARCEIROID, id_parceiro);
        valores.put(CriaBD.TABDOACOES_DATADOACAO, dataDoacao);
        valores.put(CriaBD.TABDOACOES_DESCRICAO, descricao);

        resultado = db.update(CriaBD.TABDOACOES, valores, "_id="+Integer.valueOf(id_doacao), null);
        db.close();

        if (resultado ==-1)
            return false;
        else
            return true;
    }

    public DoacaoEntity carregaDoacao(String id_doacao){
        Cursor cursor;
        DoacaoEntity doacao = new DoacaoEntity();

        db = criaBD.getReadableDatabase();
        String where = CriaBD.TABDOACOES_ID + "=" + id_doacao;
        cursor = db.query(criaBD.TABDOACOES, camposDoacoes, where, null, null, null, null, null);

        try {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                doacao.setId(cursor.getString(cursor.getColumnIndex(criaBD.TABDOACOES_ID)));
                doacao.setIdParceiro(cursor.getString(cursor.getColumnIndex(criaBD.TABDOACOES_PARCEIROID)));
                doacao.setDataDoacao(cursor.getString(cursor.getColumnIndex(criaBD.TABDOACOES_DATADOACAO)));
                doacao.setDescricao(cursor.getString(cursor.getColumnIndex(criaBD.TABDOACOES_DESCRICAO)));
            }
        } finally {
            cursor.close();
            db.close();
        }
        db.close();
        return doacao;
    }
  
    public Cursor carregaDoacoes(int id_parceiro) {
        Cursor cursor;
        db = criaBD.getReadableDatabase();
        String where = CriaBD.TABDOACOES_PARCEIROID + "=" + id_parceiro;
        String order = CriaBD.TABDOACOES_ID+ " desc";
        cursor = db.query(criaBD.TABDOACOES, camposDoacoes, where, null, null, null, order, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
}
