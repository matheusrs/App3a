package com.example.bruno.aplicativo3a.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class CriaBD extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "banco.db";

    public static final String TABASSISTIDOS = "assistidos";
    public static final String TABASSISTIDOS_ID = "_id";
    public static final String TABASSISTIDOS_CPF = "cpf";
    public static final String TABASSISTIDOS_NOME = "nome";
    public static final String TABASSISTIDOS_SOBRENOME = "sobrenome";
    public static final String TABASSISTIDOS_TELEFONE = "telefone";
    public static final String TABASSISTIDOS_DATANASCIMENTO= "datanascimento";
    public static final String TABASSISTIDOS_DEFICIENCIA = "deficiencia";
    public static final String TABASSISTIDOS_OBSERVACOES = "observacoes";
    public static final String TABASSISTIDOS_STATUSATIVO = "status_ativo";

    public static final String TABPARCEIROS = "parceiros";
    public static final String TABPARCEIROS_ID = "_id";
    public static final String TABPARCEIROS_CNPJCPF = "cnpj";
    public static final String TABPARCEIROS_NOME = "nome";
    public static final String TABPARCEIROS_TELEFONE = "telefone";
    public static final String TABPARCEIROS_DATAVINCULO= "datavinculo";
    public static final String TABPARCEIROS_OBSERVACOES = "observacoes";

    public static final String TABDOACOES = "doacoes";
    public static final String TABDOACOES_ID = "_id";
    public static final String TABDOACOES_PARCEIROID = "id_parceiro";
    public static final String TABDOACOES_DATADOACAO = "datadoacao";
    public static final String TABDOACOES_DESCRICAO = "descricao";

    public static final int VERSAO = 5;

    public CriaBD(Context context){
        super(context,NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       String table_assistidos = "CREATE TABLE "+TABASSISTIDOS+"("
               + TABASSISTIDOS_ID + " integer primary key autoincrement,"
               + TABASSISTIDOS_CPF + " text,"
               + TABASSISTIDOS_NOME + " text,"
               + TABASSISTIDOS_SOBRENOME + " text,"
               + TABASSISTIDOS_TELEFONE + " text,"
               + TABASSISTIDOS_DATANASCIMENTO + " text,"
               + TABASSISTIDOS_DEFICIENCIA + " text,"
               + TABASSISTIDOS_OBSERVACOES + " text,"
               + TABASSISTIDOS_STATUSATIVO + " text default 'true'"
               +"); ";
        String table_parceiros = "CREATE TABLE "+TABPARCEIROS+"("
                + TABPARCEIROS_ID + " integer primary key autoincrement,"
                + TABPARCEIROS_CNPJCPF + " text,"
                + TABPARCEIROS_NOME + " text,"
                + TABPARCEIROS_TELEFONE + " text,"
                + TABPARCEIROS_DATAVINCULO + " text,"
                + TABPARCEIROS_OBSERVACOES + " text"
                +"); ";
        String table_doacoes = "CREATE TABLE "+ TABDOACOES +"("
                + TABDOACOES_ID + " integer primary key autoincrement,"
                + TABDOACOES_PARCEIROID + " integer,"
                + TABDOACOES_DATADOACAO + " text,"
                + TABDOACOES_DESCRICAO + " text,"
                +"FOREIGN KEY(" +TABDOACOES_PARCEIROID + ") REFERENCES "+ TABPARCEIROS+"(" +TABPARCEIROS_ID+ ")"
                +")";
        String sql = table_assistidos;
        db.execSQL(sql);
        sql = table_parceiros;
        db.execSQL(sql);
        sql = table_doacoes;
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("versões", oldVersion + ", " + newVersion);
        String sqlAssistidos = "DROP TABLE IF EXISTS " + TABASSISTIDOS;
        String sqlParceiros = " DROP TABLE IF EXISTS " + TABPARCEIROS;
        String sqlDoacoes = " DROP TABLE IF EXISTS " + TABDOACOES;
        db.execSQL(sqlAssistidos + "; "+ sqlParceiros  + "; " + sqlDoacoes);
        onCreate(db);
    }

}
