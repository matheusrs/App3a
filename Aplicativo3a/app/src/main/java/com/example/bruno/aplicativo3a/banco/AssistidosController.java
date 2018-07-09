package com.example.bruno.aplicativo3a.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bruno.aplicativo3a.Entity.AssistidoEntity;

public class AssistidosController {
    private SQLiteDatabase db;
    private CriaBD criaBD;
    String[] camposAssistidos =  {
            criaBD.TABASSISTIDOS_ID,
            CriaBD.TABASSISTIDOS_CPF,
            CriaBD.TABASSISTIDOS_RG,
            CriaBD.TABASSISTIDOS_NOME_COMPLETO,
            CriaBD.TABASSISTIDOS_DATANASCIMENTO,
            CriaBD.TABASSISTIDOS_TAMANHO_CALCADO,
            CriaBD.TABASSISTIDOS_TAMANHO_ROUPA,
            CriaBD.TABASSISTIDOS_DATAS_PRESENTES,
            CriaBD.TABASSISTIDOS_MEIOTRANSPORTE,
            CriaBD.TABASSISTIDOS_STATUSATIVO
    };

    public AssistidosController(Context context) {
        criaBD = new CriaBD(context);
    }

    public boolean insereAssistido(String cpf, String rg, String nome_completo, String data_nascimento, String tamanho_calcado, String tamanho_roupa, String datas_presentes, String meio_transporte){
        ContentValues valores;
        long resultado;

        db = criaBD.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBD.TABASSISTIDOS_CPF, cpf);
        valores.put(CriaBD.TABASSISTIDOS_RG, rg);
        valores.put(CriaBD.TABASSISTIDOS_NOME_COMPLETO, nome_completo);
        valores.put(CriaBD.TABASSISTIDOS_DATANASCIMENTO, data_nascimento);
        valores.put(CriaBD.TABASSISTIDOS_TAMANHO_CALCADO, tamanho_calcado);
        valores.put(CriaBD.TABASSISTIDOS_TAMANHO_ROUPA, tamanho_roupa);
        valores.put(CriaBD.TABASSISTIDOS_DATAS_PRESENTES, datas_presentes);
        valores.put(CriaBD.TABASSISTIDOS_MEIOTRANSPORTE, meio_transporte);
        resultado = db.insert(CriaBD.TABASSISTIDOS, null, valores);
        db.close();

        if (resultado ==-1)
            return false;
        else
            return true;
    }

    public Cursor carregaAssistidos(){
        Cursor cursor;
        db = criaBD.getReadableDatabase();
        cursor = db.query(criaBD.TABASSISTIDOS, camposAssistidos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaAssistidos(String nome) {
        Cursor cursor;
        String where = "upper(" + CriaBD.TABASSISTIDOS_NOME_COMPLETO + ") like '%" + nome.toUpperCase() + "%'";
        db = criaBD.getReadableDatabase();
        cursor = db.query(criaBD.TABASSISTIDOS,camposAssistidos, where, null,null,null,null,null);
        if(cursor!=null)
            cursor.moveToFirst();
        db.close();
        return cursor;
    }

    public boolean atualizaAssistido(String id, String cpf, String rg, String nome_completo, String data_nascimento, String tamanho_calcado, String tamanho_roupa, String datas_presentes, String meio_transporte){
        ContentValues valores;
        long resultado;

        db = criaBD.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBD.TABASSISTIDOS_CPF, cpf);
        valores.put(CriaBD.TABASSISTIDOS_RG, rg);
        valores.put(CriaBD.TABASSISTIDOS_NOME_COMPLETO, nome_completo);
        valores.put(CriaBD.TABASSISTIDOS_DATANASCIMENTO, data_nascimento);
        valores.put(CriaBD.TABASSISTIDOS_TAMANHO_CALCADO, tamanho_calcado);
        valores.put(CriaBD.TABASSISTIDOS_TAMANHO_ROUPA, tamanho_roupa);
        valores.put(CriaBD.TABASSISTIDOS_DATAS_PRESENTES, datas_presentes);
        valores.put(CriaBD.TABASSISTIDOS_MEIOTRANSPORTE, meio_transporte);

        resultado = db.update(CriaBD.TABASSISTIDOS, valores, "_id="+id, null);
        db.close();

        if (resultado ==-1)
            return false;
        else
            return true;
    }

    public boolean atualizaStatusAssistido(int id_assistido, boolean status) {
        ContentValues valores;
        long resultado;

        db = criaBD.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBD.TABASSISTIDOS_STATUSATIVO, String.valueOf(status));

        resultado = db.update(CriaBD.TABASSISTIDOS, valores, "_id="+id_assistido, null);
        db.close();

        if (resultado ==-1)
            return false;
        else
            return true;
    }

    public Cursor carregaAssistido(String id_assistido) {
        Cursor cursor;
        String where = CriaBD.TABASSISTIDOS_ID+ " = " + id_assistido;
        db = criaBD.getReadableDatabase();
        cursor = db.query(criaBD.TABASSISTIDOS, camposAssistidos, where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
}
