package com.example.bruno.aplicativo3a.ListagemAssistidos;

import android.database.Cursor;

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
            assistido.setId(cursorAssistidos.getString(cursorAssistidos.getColumnIndex("_id")));
            assistido.setNome(cursorAssistidos.getString(cursorAssistidos.getColumnIndex("nome")));
            assistido.setSobrenome(cursorAssistidos.getString(cursorAssistidos.getColumnIndex("sobrenome")));
            assistido.setTelefone(cursorAssistidos.getString(cursorAssistidos.getColumnIndex("telefone")));
            assistido.setDeficiencia(cursorAssistidos.getString(cursorAssistidos.getColumnIndex("deficiencia")));
            assistido.setObservacoes(cursorAssistidos.getString(cursorAssistidos.getColumnIndex("observacoes")));
            assistidos.add(assistido);
        }

        view.updateListAssistidos(assistidos);
    }
}
