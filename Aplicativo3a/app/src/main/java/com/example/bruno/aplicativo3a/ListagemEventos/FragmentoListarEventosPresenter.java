package com.example.bruno.aplicativo3a.ListagemEventos;

import android.database.Cursor;

public class FragmentoListarEventosPresenter {
    FragmentoListarEventosView view;

    public FragmentoListarEventosPresenter(FragmentoListarEventosView view) {
        this.view = view;
    }

    public void listarEventos(Cursor cursorEventos){

        //List<EventoEntity> assistidos = new ArrayList<>();
        //while(cursorEventos.moveToNext())
        //{
        //    EventoEntity assistido = new EventoEntity();
        //    assistido.setId(cursorEventos.getString(cursorEventos.getColumnIndex(CriaBD.TABASSISTIDOS_ID)));
        //    assistidos.add(assistido);
        //}

        //view.updateListEventos(assistidos);
    }
}
