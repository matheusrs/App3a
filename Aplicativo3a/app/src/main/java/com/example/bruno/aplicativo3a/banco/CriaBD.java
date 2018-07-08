package com.example.bruno.aplicativo3a.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class CriaBD extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "banco_acorde.db";

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

    public static final String TABEVENTOS = "eventos";
    public static final String TABEVENTOS_ID = "_id";
    public static final String TABEVENTOS_TITULO = "titulo";
    public static final String TABEVENTOS_DESCRICAO = "descricao";
    public static final String TABEVENTOS_DATAINICIO = "data_inicio";
    public static final String TABEVENTOS_DATAFIM = "data_fim";

    public static final String TABESCALAS = "escalas";
    // PK poderá ser IDfuncionario+dia+turno futuramente.
    public static final String TABESCALAS_ID = "_id";
    public static final String TABESCALAS_DIA = "dia";
    public static final String TABESCALAS_TURNO = "turno";
    public static final String TABESCALAS_NOMEFUNCIONARIO = "funcionario"; // após integração de apps será FK para id de Funcionario
    public static final String TABESCALAS_ESPECIALIDADE = "especialidade";


    public static final int VERSAO = 1;

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
                +" FOREIGN KEY(" +TABDOACOES_PARCEIROID + ") REFERENCES "+ TABPARCEIROS+"(" +TABPARCEIROS_ID+ ")"
                +"); ";
        String table_eventos = "CREATE TABLE "+ TABEVENTOS +"("
                + TABEVENTOS_ID + " integer primary key autoincrement,"
                + TABEVENTOS_TITULO + " text,"
                + TABEVENTOS_DATAINICIO + " text,"
                + TABEVENTOS_DATAFIM + " text,"
                + TABEVENTOS_DESCRICAO + " text"
                +"); ";
        String table_escalas = "CREATE TABLE " + TABESCALAS + "("
                + TABESCALAS_ID + " integer primary key autoincrement,"
                + TABESCALAS_DIA + " text,"
                + TABESCALAS_TURNO + " text,"
                + TABESCALAS_NOMEFUNCIONARIO + " text,"
                +  TABESCALAS_ESPECIALIDADE + " text"
                + "); ";

        db.execSQL(table_assistidos);
        db.execSQL(table_parceiros);
        db.execSQL(table_doacoes);
        db.execSQL(table_eventos);
        db.execSQL(table_escalas);

        preencheMockups(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sqlAssistidos = "DROP TABLE IF EXISTS " + TABASSISTIDOS;
        String sqlParceiros = " DROP TABLE IF EXISTS " + TABPARCEIROS;
        String sqlDoacoes = " DROP TABLE IF EXISTS " + TABDOACOES;
        String sqlEventos = " DROP TABLE IF EXISTS " + TABEVENTOS;
        db.execSQL(sqlAssistidos + "; "+ sqlParceiros + "; " + sqlDoacoes + "; " + sqlEventos );
        onCreate(db);
    }

    private void preencheMockups(SQLiteDatabase db) {
        String insertAssistidos = "INSERT INTO " + TABASSISTIDOS + "(" + TABASSISTIDOS_CPF + ", " + TABASSISTIDOS_NOME + ", " + TABASSISTIDOS_SOBRENOME + ", " + TABASSISTIDOS_TELEFONE + ", " + TABASSISTIDOS_DATANASCIMENTO + ", " + TABASSISTIDOS_DEFICIENCIA + ", " + TABASSISTIDOS_OBSERVACOES + ", " + TABASSISTIDOS_STATUSATIVO + ") ";
        String values = "VALUES ('123456789','Dennis', 'Costa da Silva', '(16)3141-4835','21/03/1985', 'Perda Auditiva', 'nd','true');";
        db.execSQL(insertAssistidos.concat(values));
        values = "VALUES ('321654987', 'Joyce', 'Rodrigues', '(16)3203-8300','23/10/1994', 'Autismo', 'nd','true');";
        db.execSQL(insertAssistidos.concat(values));
        values = "VALUES ('741852963', 'Rebeca', 'Mello', '(16)9539-6423','11/05/1996', 'Física', 'nd','true');";
        db.execSQL(insertAssistidos.concat(values));
        values = "VALUES ('369258147', 'André', 'Gonçalves Dias', '(16)3531-4131','04/06/1991', 'Auditiva Mista', 'nd','true');";
        db.execSQL(insertAssistidos.concat(values));
        values = "VALUES ('369258147', 'Bernardo', 'Montes Alves', '(16)3792-2086','28/07/1992', 'Autismo', 'nd','true');";
        db.execSQL(insertAssistidos.concat(values));
        values = "VALUES ('369258147', 'Erick', 'Sousa Cruz', '(16)3598-3377','28/07/1992', 'Física', 'nd','true');";
        db.execSQL(insertAssistidos.concat(values));

        String insertParceiros = "INSERT INTO " + TABPARCEIROS + "(" + TABPARCEIROS_CNPJCPF + ", " + TABPARCEIROS_NOME + ", " + TABPARCEIROS_TELEFONE + ", " + TABPARCEIROS_DATAVINCULO + ", " + TABPARCEIROS_OBSERVACOES + ") ";
        values = "VALUES ('09.296.295/0001-60','AZUL Linhas Aéreas S/A','(11)4134-9800','10/10/2006','')";
        db.execSQL(insertParceiros.concat(values));
        values = "VALUES ('59.573.030/0001-30','Fundacao Itau Social','(11)3756-9800','01/01/2016','')";
        db.execSQL(insertParceiros.concat(values));
        values = "VALUES ('61.155.248/0001-16','Fundacao Itaubanco','(11)5697-1245','10/06/2015','')";
        db.execSQL(insertParceiros.concat(values));
        values = "VALUES ('45.543.915/0026-30','Carrefour','(11)3956-8472','22/09/2010','')";
        db.execSQL(insertParceiros.concat(values));
        values = "VALUES ('47.960.950/0449-27','Magazine Luiza ','(11)4589-7456','15/03/2000','')";
        db.execSQL(insertParceiros.concat(values));

        String insertEventos = "INSERT INTO " + TABEVENTOS + "(" + TABEVENTOS_TITULO + ", " + TABEVENTOS_DATAINICIO + ", " + TABEVENTOS_DATAFIM + ", " + TABEVENTOS_DESCRICAO + ") ";
        values = "VALUES ('Festa Junina','15/06/2018 16:00', '15/06/2018 22:00', 'Realização no salão de eventos')";
        db.execSQL(insertEventos.concat(values));
        values = "VALUES ('Semana dos Esportes','03/07/2018 08:00', '06/07/2018 16:00', 'Realização nas quadras esportivas')";
        db.execSQL(insertEventos.concat(values));
        values = "VALUES ('Bazar','12/06/2018 08:00', '12/06/2018 18:00', 'Realização no galpão')";
        db.execSQL(insertEventos.concat(values));
        values = "VALUES ('Festa de Fim de Ano','10/12/2018 14:00', '10/12/2018 20:00', 'Realização no salão de eventos')";
        db.execSQL(insertEventos.concat(values));
        values = "VALUES ('Concurso Criativo','01/11/2018 08:00', '02/11/2018 18:00', 'Realização na sala oval')";
        db.execSQL(insertEventos.concat(values));

        String insertEscalas = "INSERT INTO " + TABESCALAS + "(" + TABESCALAS_DIA + ","  + TABESCALAS_TURNO + ", "
                + TABESCALAS_NOMEFUNCIONARIO + "," + TABESCALAS_ESPECIALIDADE + ")";
        values = "VALUES ('segunda','manha','Renata Moura','Psicologa')";
        db.execSQL(insertEscalas.concat(values));
        values = "VALUES ('segunda','almoco','Maria das Dores','Recepcionista')";
        db.execSQL(insertEscalas.concat(values));
        values = "VALUES ('segunda','manha','Edilaine Ferreira','Psiquiatra')";
        db.execSQL(insertEscalas.concat(values));
        values = "VALUES ('terca','manha','Marcelo Padro','Fisioterapeuta')";
        db.execSQL(insertEscalas.concat(values));
        values = "VALUES ('terca','tarde','Silvia Paraiba','Pedagoga')";
        db.execSQL(insertEscalas.concat(values));
        values = "VALUES ('quarta','almoco','Renan Medeiros','Educação Especial')";
        db.execSQL(insertEscalas.concat(values));
        values = "VALUES ('quarta','tarde','Patricia','Educadora física')";
        db.execSQL(insertEscalas.concat(values));
        values = "VALUES ('quinta','almoco','Marcelo Padro','Fisioterapeuta')";
        db.execSQL(insertEscalas.concat(values));
        values = "VALUES ('quinta','tarde','Patricia','Educadora física')";
        db.execSQL(insertEscalas.concat(values));
        values = "VALUES ('sexta','manha','Maria das Dores','Recepcionista')";
        db.execSQL(insertEscalas.concat(values));
        values = "VALUES ('sexta','tarde','Edilaine Ferreira','Psiquiatra')";
        db.execSQL(insertEscalas.concat(values));
    }

}
