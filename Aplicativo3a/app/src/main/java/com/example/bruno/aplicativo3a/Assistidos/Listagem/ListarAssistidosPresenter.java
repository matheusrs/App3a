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
            assistido.setId(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_ID)));
            assistido.setCPF(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_CPF)));
            assistido.setNome(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_NOME)));
            assistido.setSobrenome(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_SOBRENOME)));
            assistido.setDataNascimento(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_DATANASCIMENTO)));
            assistido.setTelefone(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_TELEFONE)));
            assistido.setDeficiencia(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_DEFICIENCIA)));
            assistido.setObservacoes(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_OBSERVACOES)));
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
                assistido.setId(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_ID)));
                assistido.setCPF(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_CPF)));
                assistido.setNome(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_NOME)));
                assistido.setSobrenome(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_SOBRENOME)));
                assistido.setDataNascimento(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_DATANASCIMENTO)));
                assistido.setTelefone(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_TELEFONE)));
                assistido.setDeficiencia(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_DEFICIENCIA)));
                assistido.setObservacoes(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_OBSERVACOES)));
                assistido.setStatusAtivo(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_STATUSATIVO)));
                assistidos.add(assistido);
            } while(cursorAssistidos.moveToNext());

        view.updateListAssistidos(assistidos);
    }
}
