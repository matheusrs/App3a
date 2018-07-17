package com.example.bruno.aplicativo3a.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MedicamentoAssistidoController {
    private SQLiteDatabase db;
    private CriaBD criaBD;

    String[] camposMedicamentoAssistido =  {
            criaBD.TABMEDICAMENTOASSISTIDO_ID,
            CriaBD.TABMEDICAMENTOASSISTIDO_IDASSISTIDO,
            CriaBD.TABMEDICAMENTOASSISTIDO_NOME_MEDICAMENTO,
            CriaBD.TABMEDICAMENTOASSISTIDO_OBSERVACOES
    };

    public MedicamentoAssistidoController(Context context) {
        criaBD = new CriaBD(context);
    }

    public boolean insereMedicamentoAssistido(String id_assistido,String nome_medicamento,String observacoes){
        ContentValues valores;
        long resultado;

        db = criaBD.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBD.TABMEDICAMENTOASSISTIDO_IDASSISTIDO, Integer.valueOf(id_assistido));
        valores.put(CriaBD.TABMEDICAMENTOASSISTIDO_NOME_MEDICAMENTO,nome_medicamento);
        valores.put(CriaBD.TABMEDICAMENTOASSISTIDO_OBSERVACOES, observacoes);

        resultado = db.insert(CriaBD.TABMEDICAMENTOASSISTIDO, null, valores);
        db.close();

        if (resultado ==-1)
            return false;
        else
            return true;
    }

    public boolean atualizaMedicamentoAssistido(String id_medicamento_assistido, String id_assistido,String nome_medicamento,String observacoes) {
        ContentValues valores;
        long resultado;

        db = criaBD.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBD.TABMEDICAMENTOASSISTIDO_IDASSISTIDO, Integer.valueOf(id_assistido));
        valores.put(CriaBD.TABMEDICAMENTOASSISTIDO_NOME_MEDICAMENTO,nome_medicamento);
        valores.put(CriaBD.TABMEDICAMENTOASSISTIDO_OBSERVACOES, observacoes);

        resultado = db.update(CriaBD.TABMEDICAMENTOASSISTIDO, valores, "_id="+ id_medicamento_assistido, null);
        db.close();

        if (resultado ==-1)
            return false;
        else
            return true;
    }

    public Cursor carregaMedicamentosAssistido(int id_assistido) {
        Cursor cursor;
        db = criaBD.getReadableDatabase();
        String where = CriaBD.TABMEDICAMENTOASSISTIDO_IDASSISTIDO + "=" + id_assistido;
        cursor = db.query(criaBD.TABMEDICAMENTOASSISTIDO, camposMedicamentoAssistido, where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
}
