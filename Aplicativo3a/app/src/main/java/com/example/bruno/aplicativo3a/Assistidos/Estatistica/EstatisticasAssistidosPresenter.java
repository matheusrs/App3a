package com.example.bruno.aplicativo3a.Assistidos.Estatistica;


import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.bruno.aplicativo3a.Entity.AssistidoEntity;
import com.example.bruno.aplicativo3a.banco.AssistidosController;
import com.example.bruno.aplicativo3a.banco.CriaBD;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class EstatisticasAssistidosPresenter {
    EstatisticasAssistidosView view;
    Context context;

    public EstatisticasAssistidosPresenter(EstatisticasAssistidosView view, Context context) {
        this.view = view;
        this.context = context;
    }

    public  List<Integer> relatorioEstatisticasIdades() {
        AssistidosController banco = new AssistidosController(context);
        Cursor cursorAssistidos = banco.carregaAssistidos();
        List<Integer> idadeAssistidos = new ArrayList<>();
        if (cursorAssistidos.getCount() > 0)
            do
            {
                try {
                    Date dataAtual = new Date();
                    Date dataNascimento = new Date(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_DATANASCIMENTO));

                    int idade= dataAtual - dataNascimento;
                    idadeAssistidos.add(idade);
                } catch (Exception e) {
                    Log.i("error", "data de nascimento em formato inválido");
                }
            } while(cursorAssistidos.moveToNext());
        view.gerarGrafico(idadeAssistidos);
    }
}

