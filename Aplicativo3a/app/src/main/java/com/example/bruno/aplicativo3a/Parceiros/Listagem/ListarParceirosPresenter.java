package com.example.bruno.aplicativo3a.Parceiros.Listagem;

import android.content.Context;
import android.database.Cursor;

import com.example.bruno.aplicativo3a.banco.CriaBD;
import com.example.bruno.aplicativo3a.banco.ParceirosController;
import com.example.bruno.aplicativo3a.Entity.ParceiroEntity;

import java.util.ArrayList;
import java.util.List;

public class ListarParceirosPresenter {
    ListarParceirosView view;
    Context context;


    public ListarParceirosPresenter(ListarParceirosView view, Context context) {
        this.view = view;
        this.context = context;
    }

    public void listarParceiros(String query){
        ParceirosController banco = new ParceirosController(context);
        List<ParceiroEntity> parceiros =banco.carregaParceiros(query);
        view.updateListParceiros(parceiros);
    }

    public void listarParceiros(){
        ParceirosController banco = new ParceirosController(context);
        List<ParceiroEntity> parceiros = banco.carregaParceiros();
        view.updateListParceiros(parceiros);
    }
}
