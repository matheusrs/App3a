package com.example.bruno.aplicativo3a.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ResponsavelAssistidoController {
    private SQLiteDatabase db;
    private CriaBD criaBD;

    String[] camposResponsavelAssistido =  {
            CriaBD.TABRESPONSAVELASSISTIDO_ID,
            CriaBD.TABRESPONSAVELASSISTIDO_IDASSISTIDO,
            CriaBD.TABRESPONSAVELASSISTIDO_NOME_COMPLETO,
            CriaBD.TABRESPONSAVELASSISTIDO_CPF,
            CriaBD.TABRESPONSAVELASSISTIDO_RG,
            CriaBD.TABRESPONSAVELASSISTIDO_ENDERECO,
            CriaBD.TABRESPONSAVELASSISTIDO_BAIRRO,
            CriaBD.TABRESPONSAVELASSISTIDO_TELEFONE,
            CriaBD.TABRESPONSAVELASSISTIDO_GRAU_PARENTESCO,
            CriaBD.TABRESPONSAVELASSISTIDO_EMAIL,
            CriaBD.TABRESPONSAVELASSISTIDO_AUTORIZADO_RETIRAR
    };

    public ResponsavelAssistidoController(Context context) {
        criaBD = new CriaBD(context);
    }

    public boolean insereResponsavelAssistido(String id_assistido, String nome_completo, String cpf, String rg, String endereco, String bairro, String telefone, String grau_parentesco, String email, String autorizado_retirar){
        ContentValues valores;
        long resultado;

        db = criaBD.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBD.TABRESPONSAVELASSISTIDO_IDASSISTIDO, Integer.valueOf(id_assistido));
        valores.put(CriaBD.TABRESPONSAVELASSISTIDO_NOME_COMPLETO, nome_completo);
        valores.put(CriaBD.TABRESPONSAVELASSISTIDO_CPF, cpf);
        valores.put(CriaBD.TABRESPONSAVELASSISTIDO_RG, rg);
        valores.put(CriaBD.TABRESPONSAVELASSISTIDO_ENDERECO, endereco);
        valores.put(CriaBD.TABRESPONSAVELASSISTIDO_BAIRRO, bairro);
        valores.put(CriaBD.TABRESPONSAVELASSISTIDO_TELEFONE, telefone);
        valores.put(CriaBD.TABRESPONSAVELASSISTIDO_GRAU_PARENTESCO, grau_parentesco);
        valores.put(CriaBD.TABRESPONSAVELASSISTIDO_EMAIL, email);
        valores.put(CriaBD.TABRESPONSAVELASSISTIDO_AUTORIZADO_RETIRAR, autorizado_retirar);

        resultado = db.insert(CriaBD.TABRESPONSAVELASSISTIDO, null, valores);
        db.close();

        if (resultado ==-1)
            return false;
        else
            return true;
    }

    public boolean atualizaResponsavelAssistido(String id_responsavel_assistido, String id_assistido, String nome_completo, String cpf, String rg, String endereco, String bairro, String telefone, String grau_parentesco, String email, String autorizado_retirar) {
        ContentValues valores;
        long resultado;

        db = criaBD.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBD.TABRESPONSAVELASSISTIDO_IDASSISTIDO, Integer.valueOf(id_assistido));
        valores.put(CriaBD.TABRESPONSAVELASSISTIDO_NOME_COMPLETO, nome_completo);
        valores.put(CriaBD.TABRESPONSAVELASSISTIDO_CPF, cpf);
        valores.put(CriaBD.TABRESPONSAVELASSISTIDO_RG, rg);
        valores.put(CriaBD.TABRESPONSAVELASSISTIDO_ENDERECO, endereco);
        valores.put(CriaBD.TABRESPONSAVELASSISTIDO_BAIRRO, bairro);
        valores.put(CriaBD.TABRESPONSAVELASSISTIDO_TELEFONE, telefone);
        valores.put(CriaBD.TABRESPONSAVELASSISTIDO_GRAU_PARENTESCO, grau_parentesco);
        valores.put(CriaBD.TABRESPONSAVELASSISTIDO_EMAIL, email);
        valores.put(CriaBD.TABRESPONSAVELASSISTIDO_AUTORIZADO_RETIRAR, autorizado_retirar);

        resultado = db.update(CriaBD.TABRESPONSAVELASSISTIDO, valores, "_id="+ id_responsavel_assistido, null);
        db.close();

        if (resultado ==-1)
            return false;
        else
            return true;
    }

    public Cursor carregaResponsaveisAssistido(int id_assistido) {
        Cursor cursor;
        db = criaBD.getReadableDatabase();
        String where = CriaBD.TABRESPONSAVELASSISTIDO_IDASSISTIDO + "=" + id_assistido;
        cursor = db.query(criaBD.TABRESPONSAVELASSISTIDO, camposResponsavelAssistido, where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
}
