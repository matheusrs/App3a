package com.example.bruno.aplicativo3a.ListagemAvisos;

import android.database.Cursor;

import com.example.bruno.aplicativo3a.banco.CriaBD;
import com.example.bruno.aplicativo3a.entitiy.AvisoEntity;

import java.util.ArrayList;
import java.util.List;

public class FragmentoListarAvisosPresenter {
    FragmentoListarAvisosView view;

    public FragmentoListarAvisosPresenter(FragmentoListarAvisosView view) {
        this.view = view;
    }

    public void listarAvisos(Cursor cursorAvisos){

        //List<AvisoEntity> assistidos = new ArrayList<>();
        //while(cursorAvisos.moveToNext())
        //{
        //    AvisoEntity assistido = new AvisoEntity();
        //    assistido.setId(cursorAvisos.getString(cursorAvisos.getColumnIndex(CriaBD.TABASSISTIDOS_ID)));
        //    assistidos.add(assistido);
        //}

        //view.updateListAvisos(assistidos);
    }
}
