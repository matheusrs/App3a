package com.example.bruno.aplicativo3a.ListagemAssistidos;

import android.database.Cursor;

import com.example.bruno.aplicativo3a.banco.CriaBD;
import com.example.bruno.aplicativo3a.entitiy.AssistidoEntity;

import java.util.ArrayList;
import java.util.List;

public class FragmentoListarAssistidosPresenter {
    FragmentoListarAssistidosView view;

    public FragmentoListarAssistidosPresenter(FragmentoListarAssistidosView view) {
        this.view = view;
    }

    public void listarAssistidos(Cursor cursorAssistidos){

        List<AssistidoEntity> assistidos = new ArrayList<>();
        while(cursorAssistidos.moveToNext())
        {
            AssistidoEntity assistido = new AssistidoEntity();
            assistido.setId(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_ID)));
            assistido.setNome(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_NOME)));
            assistido.setSobrenome(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_SOBRENOME)));
            assistido.setDataNascimento(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_DATANASCIMENTO)));
            assistido.setTelefone(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_TELEFONE)));
            assistido.setDeficiencia(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_DEFICIENCIA)));
            assistido.setObservacoes(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_OBSERVACOES)));
            assistidos.add(assistido);
        }

        view.updateListAssistidos(assistidos);
    }
}
