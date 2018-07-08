package com.example.bruno.aplicativo3a.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bruno.aplicativo3a.Entity.EscalaEntity;

import java.util.ArrayList;
import java.util.List;

public class EscalasController {
    private SQLiteDatabase db;
    private CriaBD criaBD;

    String[] camposEscalas =  {
            criaBD.TABESCALAS_ID,
            criaBD.TABESCALAS_DIA,
            criaBD.TABESCALAS_TURNO,
            criaBD.TABESCALAS_NOMEFUNCIONARIO,
            criaBD.TABESCALAS_ESPECIALIDADE
    };

    public EscalasController(Context context) {
        criaBD = new CriaBD(context);
    }

    public boolean insereEscala(String dia,String turno,String nome,String especialidade){
        ContentValues valores;
        long resultado;

        db = criaBD.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBD.TABESCALAS_DIA,dia);
        valores.put(CriaBD.TABESCALAS_TURNO,turno);
        valores.put(CriaBD.TABESCALAS_NOMEFUNCIONARIO, nome);
        valores.put(CriaBD.TABESCALAS_ESPECIALIDADE, especialidade);

        resultado = db.insert(CriaBD.TABESCALAS, null, valores);
        db.close();

        if (resultado ==-1)
            return false;
        else
            return true;
    }

    public List<EscalaEntity> carregaEscalas(String dia,String turno){
        Cursor cursor;
        db = criaBD.getReadableDatabase();
        String where = CriaBD.TABESCALAS_DIA + "='" + dia + "' AND " + CriaBD.TABESCALAS_TURNO + " = '" +turno+"'";
        cursor = db.query(criaBD.TABESCALAS, camposEscalas, where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        List<EscalaEntity> escalas = new ArrayList<>();
        if (cursor.getCount() > 0)
            do
            {
                EscalaEntity escala = new EscalaEntity();
                escala.setId(cursor.getString(cursor.getColumnIndex(CriaBD.TABESCALAS_ID)));
                escala.setDia(cursor.getString(cursor.getColumnIndex(CriaBD.TABESCALAS_DIA)));
                escala.setTurno(cursor.getString(cursor.getColumnIndex(CriaBD.TABESCALAS_TURNO)));
                escala.setNomeFuncionario(cursor.getString(cursor.getColumnIndex(CriaBD.TABESCALAS_NOMEFUNCIONARIO)));
                escala.setEspecialidade(cursor.getString(cursor.getColumnIndex(CriaBD.TABESCALAS_ESPECIALIDADE)));
                escalas.add(escala);
        } while(cursor.moveToNext());

        db.close();
        cursor.close();
        return escalas;
    }
}
