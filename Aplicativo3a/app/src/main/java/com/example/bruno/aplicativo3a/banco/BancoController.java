package com.example.bruno.aplicativo3a.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bruno.aplicativo3a.entitiy.AssistidoEntity;

public class BancoController {

    private SQLiteDatabase db;
    private CriaBD criaBD;
    String[] campos =  {
            criaBD.TABASSISTIDOS_ID,
            criaBD.TABASSISTIDOS_NOME,
            criaBD.TABASSISTIDOS_SOBRENOME,
            criaBD.TABASSISTIDOS_TELEFONE,
            criaBD.TABASSISTIDOS_DATANASCIMENTO,
            criaBD.TABASSISTIDOS_DEFICIENCIA,
            criaBD.TABASSISTIDOS_OBSERVACOES};


    public BancoController(Context context) {
        criaBD = new CriaBD(context);
    }

    public boolean insereAssistido(String nome,String sobrenome,String telefone, String data_nascimento, String deficiencia,String observacoes){
        ContentValues valores;
        long resultado;

        db = criaBD.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBD.TABASSISTIDOS_NOME, nome);
        valores.put(CriaBD.TABASSISTIDOS_SOBRENOME, sobrenome);
        valores.put(CriaBD.TABASSISTIDOS_TELEFONE, telefone);
        valores.put(CriaBD.TABASSISTIDOS_DATANASCIMENTO, data_nascimento);
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
        String where = CriaBD.TABASSISTIDOS_NOME + "like %" + nome + "%";
        db = criaBD.getReadableDatabase();
        cursor = db.query(criaBD.TABASSISTIDOS,campos, where, null,null,null,null,null);
        if(cursor!=null)
            cursor.moveToFirst();
        db.close();
        return cursor;
    }

    public AssistidoEntity selectAssistido(int id_assistido) {
        Cursor cursorAssistido;
        AssistidoEntity assistido = new AssistidoEntity();

        String where = CriaBD.TABASSISTIDOS_ID + "=" + id_assistido;
        db = criaBD.getReadableDatabase();
        cursorAssistido = db.query(criaBD.TABASSISTIDOS, campos, where, null, null, null, null, null);
        try {
            if (cursorAssistido.getCount() > 0) {
                cursorAssistido.moveToFirst();
                assistido.setId(cursorAssistido.getString(cursorAssistido.getColumnIndex(criaBD.TABASSISTIDOS_ID)));
                assistido.setNome(cursorAssistido.getString(cursorAssistido.getColumnIndex(criaBD.TABASSISTIDOS_NOME)));
                assistido.setSobrenome(cursorAssistido.getString(cursorAssistido.getColumnIndex(criaBD.TABASSISTIDOS_SOBRENOME)));
                assistido.setTelefone(cursorAssistido.getString(cursorAssistido.getColumnIndex(criaBD.TABASSISTIDOS_TELEFONE)));
                assistido.setDataNascimento(cursorAssistido.getString(cursorAssistido.getColumnIndex(criaBD.TABASSISTIDOS_DATANASCIMENTO)));
                assistido.setDeficiencia(cursorAssistido.getString(cursorAssistido.getColumnIndex(criaBD.TABASSISTIDOS_DEFICIENCIA)));
                assistido.setObservacoes(cursorAssistido.getString(cursorAssistido.getColumnIndex(criaBD.TABASSISTIDOS_OBSERVACOES)));
            }
        } finally {
            cursorAssistido.close();
            db.close();
        }
        return assistido;
    }

    public boolean atualizaAssistido(String id, String nome,String sobrenome,String telefone, String datanascimento,String deficiencia,String observacoes){
        ContentValues valores;
        long resultado;

        db = criaBD.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBD.TABASSISTIDOS_NOME, nome);
        valores.put(CriaBD.TABASSISTIDOS_SOBRENOME, sobrenome);
        valores.put(CriaBD.TABASSISTIDOS_TELEFONE, telefone);
        valores.put(CriaBD.TABASSISTIDOS_DATANASCIMENTO, datanascimento);
        valores.put(CriaBD.TABASSISTIDOS_DEFICIENCIA, deficiencia);
        valores.put(CriaBD.TABASSISTIDOS_OBSERVACOES, observacoes);

        resultado = db.update(CriaBD.TABASSISTIDOS, valores, "_id="+id, null);
        db.close();

        if (resultado ==-1)
            return false;
        else
            return true;
    }
}



