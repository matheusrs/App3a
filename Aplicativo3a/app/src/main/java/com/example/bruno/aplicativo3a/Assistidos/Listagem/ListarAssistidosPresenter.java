package com.example.bruno.aplicativo3a.Assistidos.Listagem;

import android.content.Context;
import android.database.Cursor;

import com.example.bruno.aplicativo3a.banco.AssistidosController;
import com.example.bruno.aplicativo3a.banco.CriaBD;
import com.example.bruno.aplicativo3a.Entity.AssistidoEntity;

import java.util.ArrayList;
import java.util.List;

public class ListarAssistidosPresenter {
    ListarAssistidosView view;
    Context context;

    public ListarAssistidosPresenter(ListarAssistidosView view, Context context) {
        this.view = view;
        this.context = context;
    }

    public void listarAssistidos(){
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

        view.updateListAssistidos(assistidos);
    }

    public void listarAssistidos(String query){
        AssistidosController banco = new AssistidosController(context);
        Cursor cursorAssistidos = banco.carregaAssistidos(query);
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

        view.updateListAssistidos(assistidos);
    }
}
