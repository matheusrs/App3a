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

    public void relatorioEstatisticasIdades() {
        AssistidosController banco = new AssistidosController(context);
        Cursor cursorAssistidos = banco.carregaAssistidos();
        List<AssistidoEntity> assistidos = new ArrayList<>();
        if (cursorAssistidos.getCount() > 0)
            do
            {
                AssistidoEntity assistido = new AssistidoEntity();
                assistido.setId(Integer.valueOf(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_ID))));
                assistido.setCpf(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_CPF)));
                assistido.setRg(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_RG)));
                assistido.setNomeCompleto(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_NOME_COMPLETO)));
                assistido.setDataNascimento(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_DATANASCIMENTO)));
                assistido.setTamanhoCalcado(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_TAMANHO_CALCADO)));
                assistido.setTamanhoRoupa(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_TAMANHO_ROUPA)));
                assistido.setDatasPresentes(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_DATAS_PRESENTES)));
                assistido.setMeioTransporte(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_MEIOTRANSPORTE)));
                assistido.setStatusAtivo(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_STATUSATIVO)));
                assistidos.add(assistido);
            } while(cursorAssistidos.moveToNext());

        view.updateEstatisticaAssistidos(assistidos);
    }
}

