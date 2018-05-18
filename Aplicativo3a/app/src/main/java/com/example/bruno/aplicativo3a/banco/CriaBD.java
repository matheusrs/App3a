package com.example.bruno.aplicativo3a.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBD extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "banco_160518us.db";
    public static final String TABASSISTIDOS = "assistidos";
    public static final String TABASSISTIDOS_ID = "_id";
    public static final String TABASSISTIDOS_NOME = "nome";
    public static final String TABASSISTIDOS_SOBRENOME = "sobrenome";
    public static final String TABASSISTIDOS_TELEFONE = "telefone";
    public static final String TABASSISTIDOS_DATANASCIMENTO= "datanascimento";
    public static final String TABASSISTIDOS_DEFICIENCIA = "deficiencia";
    public static final String TABASSISTIDOS_OBSERVACOES = "observacoes";
    public static final int VERSAO = 1;

    public CriaBD(Context context){
        super(context,NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABASSISTIDOS+"("
               + TABASSISTIDOS_ID + " integer primary key autoincrement,"
               + TABASSISTIDOS_NOME + " text,"
               + TABASSISTIDOS_SOBRENOME + " text,"
               + TABASSISTIDOS_TELEFONE + " text,"
               + TABASSISTIDOS_DATANASCIMENTO + " text,"
               + TABASSISTIDOS_DEFICIENCIA + " text,"
               + TABASSISTIDOS_OBSERVACOES + " text"
               +")";
                db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABASSISTIDOS;
        db.execSQL(sql);
        onCreate(db);
    }

}
