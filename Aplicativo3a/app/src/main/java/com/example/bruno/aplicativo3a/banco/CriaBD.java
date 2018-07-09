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
    public static final String TABASSISTIDOS_RG = "rg";
    public static final String TABASSISTIDOS_NOME_COMPLETO = "nome_completo";
    public static final String TABASSISTIDOS_DATANASCIMENTO = "datanascimento";
    public static final String TABASSISTIDOS_TAMANHO_CALCADO = "tamanho_calcado";
    public static final String TABASSISTIDOS_TAMANHO_ROUPA = "tamanho_roupa";
    public static final String TABASSISTIDOS_DATAS_PRESENTES = "datas_presentes";
    public static final String TABASSISTIDOS_MEIOTRANSPORTE = "meio_transporte";
    public static final String TABASSISTIDOS_STATUSATIVO = "status_ativo";

    public static final String TABRESPONSAVELASSISTIDO = "responsavel_assistido";
    public static final String TABRESPONSAVELASSISTIDO_ID = "_id";
    public static final String TABRESPONSAVELASSISTIDO_IDASSISTIDO = "id_assistido";
    public static final String TABRESPONSAVELASSISTIDO_NOME_COMPLETO = "nome_completo";
    public static final String TABRESPONSAVELASSISTIDO_CPF = "cpf";
    public static final String TABRESPONSAVELASSISTIDO_RG = "rg";
    public static final String TABRESPONSAVELASSISTIDO_ENDERECO = "endereco";
    public static final String TABRESPONSAVELASSISTIDO_BAIRRO = "bairro";
    public static final String TABRESPONSAVELASSISTIDO_TELEFONE = "telefone";
    public static final String TABRESPONSAVELASSISTIDO_GRAU_PARENTESCO =  "grau_parentesco";
    public static final String TABRESPONSAVELASSISTIDO_EMAIL = "email";
    public static final String TABRESPONSAVELASSISTIDO_AUTORIZADO_RETIRAR = "autorizado_retirar";

    public static final String TABMEDICAMENTOASSISTIDO = "medicamento_assistido";
    public static final String TABMEDICAMENTOASSISTIDO_ID = "_id";
    public static final String TABMEDICAMENTOASSISTIDO_IDASSISTIDO = "id_assistido";
    public static final String TABMEDICAMENTOASSISTIDO_NOME_MEDICAMENTO = "nome_medicamento";
    public static final String TABMEDICAMENTOASSISTIDO_OBSERVACOES = "observacoes_medicamento";

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
    public static final String TABEVENTOS_GASTOS = "gastos";
    public static final String TABEVENTOS_RECEITAS = "receitas";
    public static final String TABEVENTOS_DATAINICIO = "data_inicio";
    public static final String TABEVENTOS_DATAFIM = "data_fim";

    public static final String TABNOTIFICACOES = "notificacoes";
    public static final String TABNOTIFICACOES_ID = "_id";
    public static final String TABNOTIFICACOES_IDDESTINATARIO = "id_destinatario";
    public static final String TABNOTIFICACOES_IDMENSAGEM = "id_mensagem";
    public static final String TABNOTIFICACOES_DATA_ENVIO = "data_envio";
    public static final String TABNOTIFICACOES_DATA_LEITURA = "data_leitura";

    public static final String TABMENSAGENS = "mensagens";
    public static final String TABMENSAGENS_ID = "_id";
    public static final String TABMENSAGENS_IDAUTOR = "id_autor";
    public static final String TABMENSAGENS_ASSUNTO = "assunto";
    public static final String TABMENSAGENS_CONTEUDO = "conteudo";

    public static final String TABUSUARIOS = "usuarios";
    public static final String TABUSUARIOS_ID = "_id";
    public static final String TABUSUARIOS_NOME = "nome";
    public static final String TABUSUARIOS_EMAIL = "email";
    public static final String TABUSUARIOS_SENHA = "senha";
    public static final String TABUSUARIOS_ADMIN = "is_admin";

    public static final int VERSAO = 1;

    public CriaBD(Context context){
        super(context,NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       String table_assistidos = "CREATE TABLE "+TABASSISTIDOS+"("
               + TABASSISTIDOS_ID + " integer primary key autoincrement,"
               + TABASSISTIDOS_CPF + " text,"
               + TABASSISTIDOS_RG + " text,"
               + TABASSISTIDOS_NOME_COMPLETO + " text,"
               + TABASSISTIDOS_DATANASCIMENTO + " text,"
               + TABASSISTIDOS_TAMANHO_CALCADO + " text,"
               + TABASSISTIDOS_TAMANHO_ROUPA + " text,"
               + TABASSISTIDOS_DATAS_PRESENTES + " text,"
               + TABASSISTIDOS_MEIOTRANSPORTE + " text,"
               + TABASSISTIDOS_STATUSATIVO + " text default 'true'"
               +"); ";
        String table_responsavel_assistido = "CREATE TABLE "+ TABRESPONSAVELASSISTIDO + " ("
               + TABRESPONSAVELASSISTIDO_ID + " integer primary key autoincrement,"
               + TABRESPONSAVELASSISTIDO_IDASSISTIDO + " integer,"
               + TABRESPONSAVELASSISTIDO_NOME_COMPLETO + " text,"
               + TABRESPONSAVELASSISTIDO_CPF + " text,"
               + TABRESPONSAVELASSISTIDO_RG + " text,"
               + TABRESPONSAVELASSISTIDO_ENDERECO + " text,"
               + TABRESPONSAVELASSISTIDO_BAIRRO + " text,"
               + TABRESPONSAVELASSISTIDO_TELEFONE + " text,"
               + TABRESPONSAVELASSISTIDO_GRAU_PARENTESCO + " text,"
               + TABRESPONSAVELASSISTIDO_EMAIL + " text,"
               + TABRESPONSAVELASSISTIDO_AUTORIZADO_RETIRAR + " text default 'false',"
               +" FOREIGN KEY(" +TABRESPONSAVELASSISTIDO_IDASSISTIDO + ") REFERENCES "+ TABASSISTIDOS+"(" +TABASSISTIDOS_ID+ ")"
               +"); ";
        String table_medicamento_assistido = "CREATE TABLE "+ TABMEDICAMENTOASSISTIDO + " ("
                + TABMEDICAMENTOASSISTIDO_ID + " integer primary key autoincrement,"
                + TABMEDICAMENTOASSISTIDO_IDASSISTIDO + " integer,"
                + TABMEDICAMENTOASSISTIDO_NOME_MEDICAMENTO + " text,"
                + TABMEDICAMENTOASSISTIDO_OBSERVACOES + " text,"
                +" FOREIGN KEY(" +TABMEDICAMENTOASSISTIDO_IDASSISTIDO + ") REFERENCES "+ TABASSISTIDOS+"(" +TABASSISTIDOS_ID+ ")"
                +"); ";
        String table_parceiros = "CREATE TABLE "+TABPARCEIROS+" ("
                + TABPARCEIROS_ID + " integer primary key autoincrement,"
                + TABPARCEIROS_CNPJCPF + " text,"
                + TABPARCEIROS_NOME + " text,"
                + TABPARCEIROS_TELEFONE + " text,"
                + TABPARCEIROS_DATAVINCULO + " text,"
                + TABPARCEIROS_OBSERVACOES + " text"
                +"); ";
        String table_doacoes = "CREATE TABLE "+ TABDOACOES +" ("
                + TABDOACOES_ID + " integer primary key autoincrement,"
                + TABDOACOES_PARCEIROID + " integer,"
                + TABDOACOES_DATADOACAO + " text,"
                + TABDOACOES_DESCRICAO + " text,"
                +" FOREIGN KEY(" +TABDOACOES_PARCEIROID + ") REFERENCES "+ TABPARCEIROS+"(" +TABPARCEIROS_ID+ ")"
                +"); ";
        String table_eventos = "CREATE TABLE "+ TABEVENTOS +" ("
                + TABEVENTOS_ID + " integer primary key autoincrement,"
                + TABEVENTOS_TITULO + " text,"
                + TABEVENTOS_DATAINICIO + " text,"
                + TABEVENTOS_DATAFIM + " text,"
                + TABEVENTOS_DESCRICAO + " text,"
                + TABEVENTOS_GASTOS + " text,"
                + TABEVENTOS_RECEITAS + " text"
                +"); ";
        String table_notificacoes = "CREATE TABLE "+ TABNOTIFICACOES +" ("
                + TABNOTIFICACOES_ID + " integer primary key autoincrement,"
                + TABNOTIFICACOES_IDDESTINATARIO + " integer,"
                + TABNOTIFICACOES_IDMENSAGEM + " integer,"
                + TABNOTIFICACOES_DATA_ENVIO + " text,"
                + TABNOTIFICACOES_DATA_LEITURA + " text,"
                +" FOREIGN KEY(" +TABNOTIFICACOES_IDDESTINATARIO + ") REFERENCES "+ TABUSUARIOS +"(" +TABUSUARIOS_ID+ "), "
                +" FOREIGN KEY(" +TABNOTIFICACOES_IDMENSAGEM + ") REFERENCES "+ TABMENSAGENS +"(" +TABMENSAGENS_ID+ ")"
                +"); ";
        String table_mensagens = "CREATE TABLE "+ TABMENSAGENS +" ("
                + TABMENSAGENS_ID + " integer primary key autoincrement,"
                + TABMENSAGENS_IDAUTOR + " integer,"
                + TABMENSAGENS_ASSUNTO + " text,"
                + TABMENSAGENS_CONTEUDO + " text,"
                +" FOREIGN KEY(" +TABMENSAGENS_IDAUTOR + ") REFERENCES "+ TABUSUARIOS +"(" +TABUSUARIOS_ID+ ")"
                +"); ";
        String table_usuarios = "CREATE TABLE "+ TABUSUARIOS +" ("
                + TABUSUARIOS_ID + " integer primary key autoincrement,"
                + TABUSUARIOS_NOME + " text,"
                + TABUSUARIOS_EMAIL + " text,"
                + TABUSUARIOS_SENHA + " text,"
                + TABUSUARIOS_ADMIN + " text default 'false'"
                +"); ";
        db.execSQL(table_assistidos);
        db.execSQL(table_responsavel_assistido);
        db.execSQL(table_medicamento_assistido);
        db.execSQL(table_parceiros);
        db.execSQL(table_doacoes);
        db.execSQL(table_eventos);
        db.execSQL(table_notificacoes);
        db.execSQL(table_mensagens);
        db.execSQL(table_usuarios);

        preencheMockups(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sqlAssistidos = "DROP TABLE IF EXISTS " + TABASSISTIDOS;
        String sqlResponsavelAssistido = " DROP TABLE IF EXISTS " + TABRESPONSAVELASSISTIDO;
        String sqlMedicamentoAssistido = " DROP TABLE IF EXISTS " + TABMEDICAMENTOASSISTIDO;
        String sqlParceiros = " DROP TABLE IF EXISTS " + TABPARCEIROS;
        String sqlDoacoes = " DROP TABLE IF EXISTS " + TABDOACOES;
        String sqlEventos = " DROP TABLE IF EXISTS " + TABEVENTOS;
        String sqlNotificacoes = " DROP TABLE IF EXISTS " + TABNOTIFICACOES;
        String sqlMensagens = " DROP TABLE IF EXISTS " + TABMENSAGENS;
        String sqlUsuarios = " DROP TABLE IF EXISTS " + TABUSUARIOS;

        db.execSQL(sqlAssistidos + "; "+ sqlResponsavelAssistido + "; "+ sqlMedicamentoAssistido + "; "+ sqlParceiros + "; " + sqlDoacoes + "; " + sqlEventos  + "; "+ sqlNotificacoes + "; "+ sqlMensagens + "; "+ sqlUsuarios);
        onCreate(db);
    }

    private void preencheMockups(SQLiteDatabase db) {
        String insertAssistidos = "INSERT INTO " + TABASSISTIDOS + " (" + TABASSISTIDOS_CPF + ", " + TABASSISTIDOS_RG + ", " + TABASSISTIDOS_NOME_COMPLETO + ", " + TABASSISTIDOS_DATANASCIMENTO + ", " + TABASSISTIDOS_TAMANHO_CALCADO + ", " + TABASSISTIDOS_TAMANHO_ROUPA + ", " + TABASSISTIDOS_DATAS_PRESENTES + ", " + TABASSISTIDOS_MEIOTRANSPORTE + ", " + TABASSISTIDOS_STATUSATIVO + ") ";
        String values = "VALUES ('22546887076','298222656','Dennis Costa da Silva','21/03/1985','40','M','Aniversário, Natal','Onibus','true');";
        db.execSQL(insertAssistidos.concat(values));
        values = "VALUES ('94343868028','394290525','Joyce Rodrigues','23/10/1994','36','P','Aniversário, Natal','Van','true');";
        db.execSQL(insertAssistidos.concat(values));
        values = "VALUES ('29083745015','228799764','Rebeca Mello','11/05/1996','34','P','Aniversário, Natal','Carro','true');";
        db.execSQL(insertAssistidos.concat(values));
        values = "VALUES ('39345737030','373714853','André Gonçalves Dias','04/06/1991','40','M','Aniversário, Natal','Carro','true');";
        db.execSQL(insertAssistidos.concat(values));
        values = "VALUES ('85643665093','271636579','Bernardo Montes Alves','28/07/1992','43','GG','Aniversário, Natal','A pé','true');";
        db.execSQL(insertAssistidos.concat(values));
        values = "VALUES ('78224044076','258483131','Erick Sousa Cruz','28/07/1992','42','G','Aniversário, Natal','Bicicleta','true');";
        db.execSQL(insertAssistidos.concat(values));
        values = "VALUES ('13969264022','126865577','Gabriel Iago Drumond','02/10/1996','40','M','Aniversário, Natal','Carro','true');";
        db.execSQL(insertAssistidos.concat(values));
        values = "VALUES ('13929114003','234417614','Benício Lucca Heitor Caldeira','22/11/1988','39','M','Aniversário, Natal','Carro','true');";
        db.execSQL(insertAssistidos.concat(values));
        values = "VALUES ('27184858093','339333455','Emily Rayssa Moreira','01/05/1986','37','M','Aniversário, Natal','Carro','true');";
        db.execSQL(insertAssistidos.concat(values));
        values = "VALUES ('79136925020','385632654','Isabelly Nicole Rocha','05/09/1990','37','M','Aniversário, Natal','Carro','true');";
        db.execSQL(insertAssistidos.concat(values));

        String insertResponsavelAssistido = "INSERT INTO " + TABRESPONSAVELASSISTIDO + " (" + TABRESPONSAVELASSISTIDO_IDASSISTIDO + ", " + TABRESPONSAVELASSISTIDO_NOME_COMPLETO + ", " + TABRESPONSAVELASSISTIDO_CPF + ", " + TABRESPONSAVELASSISTIDO_RG + ", " + TABRESPONSAVELASSISTIDO_ENDERECO + ", " + TABRESPONSAVELASSISTIDO_BAIRRO + ", " + TABRESPONSAVELASSISTIDO_TELEFONE + ", " + TABRESPONSAVELASSISTIDO_GRAU_PARENTESCO + ", " + TABRESPONSAVELASSISTIDO_EMAIL + ", " + TABRESPONSAVELASSISTIDO_AUTORIZADO_RETIRAR + ") ";
        values = "VALUES ('1','Nina Vera Ayla da Rosa','26898767011','161686199','Avenida São Carlos 37','Vila Costa do Sol','(16)3141-4835','Mãe','teste1@email.com','true');";
        db.execSQL(insertResponsavelAssistido.concat(values));
        values = "VALUES ('2','Cecília Vanessa Luna Almeida','93868442065','486291467','Rua Irineu Rios','Jardim Beatriz','(16)3203-8300','Tia','teste2@email.com','true');";
        db.execSQL(insertResponsavelAssistido.concat(values));
        values = "VALUES ('3','Pedro Joaquim Bernardo Moura','89313353008','401013078','Alameda das Cerejeiras','Parque Faber Castell I','(16)9539-6423','Avô','teste3@email.com','true');";
        db.execSQL(insertResponsavelAssistido.concat(values));
        values = "VALUES ('4','Sérgio Noah da Conceição','39744119098','434976817','Rua Professor Walter Blanco','Jardim Social Belvedere','(16)3531-4131','Pai','teste4@email.com','true');";
        db.execSQL(insertResponsavelAssistido.concat(values));
        values = "VALUES ('5','Heloisa Laís Daniela Assunção','16021389077','475823655','Alameda Abaeté','Parque Itaipu','(16)3792-2086','Mãe','teste5@email.com','true');";
        db.execSQL(insertResponsavelAssistido.concat(values));
        values = "VALUES ('6','Murilo Martin Novaes','50881034096','266698049','Travessa Waldemar Nutti','Centro','(16)3598-3377','Neto','teste6@email.com','true');";
        db.execSQL(insertResponsavelAssistido.concat(values));
        values = "VALUES ('7','Daniela Carla Ferreira','85076531036','219455958','Rua da Alta Tecnologia','Parque Espraiado','(16)3916-7934','Mãe','teste7@email.com','true');";
        db.execSQL(insertResponsavelAssistido.concat(values));
        values = "VALUES ('8','Sebastião Guilherme Rezende','20419977023','504653544','Rua Nações Unidas','Jardim Cruzeiro do Sul','(16) 2747-0039','Tio','teste8@email.com','true');";
        db.execSQL(insertResponsavelAssistido.concat(values));
        values = "VALUES ('9','Sabrina Stefany Mariana Cavalcanti','52149234068','404594517','Rua Sebastião Sampaio Osório','Parque Santa Felícia Jardim','(16) 3852-3183','Tia','teste9@email.com','true');";
        db.execSQL(insertResponsavelAssistido.concat(values));
        values = "VALUES ('10','Ruan Marcos Martins','43204150003','275867511','Rua José Ferraz','Centro','(16) 2865-9002','Pai','teste10@email.com','true');";
        db.execSQL(insertResponsavelAssistido.concat(values));

        String insertMedicamentoAssistido = "INSERT INTO " + TABMEDICAMENTOASSISTIDO + " (" + TABMEDICAMENTOASSISTIDO_IDASSISTIDO + ", " + TABMEDICAMENTOASSISTIDO_NOME_MEDICAMENTO + ", " + TABMEDICAMENTOASSISTIDO_OBSERVACOES + ") ";
        values = "VALUES ('1','Aspirina','Quando necessário');";
        db.execSQL(insertMedicamentoAssistido.concat(values));
        values = "VALUES ('1','Vitamina C','Todos os dias às 18h');";
        db.execSQL(insertMedicamentoAssistido.concat(values));

        String insertParceiros = "INSERT INTO " + TABPARCEIROS + " (" + TABPARCEIROS_CNPJCPF + ", " + TABPARCEIROS_NOME + ", " + TABPARCEIROS_TELEFONE + ", " + TABPARCEIROS_DATAVINCULO + ", " + TABPARCEIROS_OBSERVACOES + ") ";
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

        String insertDoacoes = "INSERT INTO " + TABDOACOES + " (" + TABDOACOES_PARCEIROID + ", " + TABDOACOES_DATADOACAO + ", " + TABDOACOES_DESCRICAO + ") ";
        values = "VALUES ('1','12/05/2010','R$ 400,00')";
        db.execSQL(insertDoacoes.concat(values));
        values = "VALUES ('1','17/03/2014','R$ 4000,00')";
        db.execSQL(insertDoacoes.concat(values));
        values = "VALUES ('1','10/04/2018','R$ 8000,00')";
        db.execSQL(insertDoacoes.concat(values));

        String insertEventos = "INSERT INTO " + TABEVENTOS + "(" + TABEVENTOS_TITULO + ", " + TABEVENTOS_DATAINICIO + ", " + TABEVENTOS_DATAFIM + ", " + TABEVENTOS_DESCRICAO + ", " + TABEVENTOS_GASTOS + ", " + TABEVENTOS_RECEITAS + ") ";
        values = "VALUES ('Festa Junina','15/06/2018 16:00', '15/06/2018 22:00', 'Realização no salão de eventos', '0', '0')";
        db.execSQL(insertEventos.concat(values));
        values = "VALUES ('Semana dos Esportes','03/07/2018 08:00', '06/07/2018 16:00', 'Realização nas quadras esportivas', '0', '0')";
        db.execSQL(insertEventos.concat(values));
        values = "VALUES ('Bazar','12/06/2018 08:00', '12/06/2018 18:00', 'Realização no galpão', '0', '0')";
        db.execSQL(insertEventos.concat(values));
        values = "VALUES ('Festa de Fim de Ano','10/12/2018 14:00', '10/12/2018 20:00', 'Realização no salão de eventos', '0', '0')";
        db.execSQL(insertEventos.concat(values));
        values = "VALUES ('Concurso Criativo','01/11/2018 08:00', '02/11/2018 18:00', 'Realização na sala oval', '0', '0')";
        db.execSQL(insertEventos.concat(values));

        //String insertNotificacoes = "INSERT INTO " + TABNOTIFICACOES + " (" + TABNOTIFICACOES_IDDESTINATARIO + ", " + TABNOTIFICACOES_IDMENSAGEM + ", " + TABNOTIFICACOES_DATA_ENVIO + ", " + TABNOTIFICACOES_DATA_LEITURA + ") ";
        //String insertMensagens = "INSERT INTO " + TABMENSAGENS + " (" + TABMENSAGENS_IDAUTOR + ", " + TABMENSAGENS_ASSUNTO + ", " + TABMENSAGENS_CONTEUDO + ") ";
        String insertUsuarios = "INSERT INTO " + TABUSUARIOS + " (" + TABUSUARIOS_NOME + ", " + TABUSUARIOS_EMAIL + ", " + TABUSUARIOS_SENHA + ", " + TABUSUARIOS_ADMIN + ") ";
        values = "VALUES ('Admin','admin@email.com', 'admin', 'true')";
        db.execSQL(insertUsuarios.concat(values));
    }

}
