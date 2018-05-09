package com.example.bruno.aplicativo3a.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBD extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "banco.db";
    public static final String TABASSISTIDOS = "assistidos";
    public static final String ID = "_id";
    public static final String NOME = "nome";
    public static final String SOBRENOME = "sobrenome";
    public static final String TELEFONE = "telefone";
    public static final String DEFICIENCIA = "deficiencia";
    public static final String OBSERVACOES = "observacoes";
    public static final int VERSAO = 1;

    public CriaBD(Context context){
        super(context,NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       String sql = "CREATE TABLE "+TABASSISTIDOS+"("
               + ID + " integer primary key autoincrement,"
               + NOME + " text,"
               + SOBRENOME + " text,"
               + TELEFONE + " text,"
               + DEFICIENCIA + " text,"
               + OBSERVACOES + " text"
               +")";
                db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        String sql = "DROP TABLE IF EXISTS " + TABASSISTIDOS;
//        db.execSQL(sql);
//        onCreate(db);
    }

}
