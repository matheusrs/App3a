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
        Cursor cursorParceiros = banco.carregaParceiros(query);
        List<ParceiroEntity> parceiros = new ArrayList<>();
        if (cursorParceiros.getCount() > 0)
            do
            {
                ParceiroEntity parceiro = new ParceiroEntity();
                parceiro.setId(cursorParceiros.getInt(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_ID)));
                parceiro.setNome(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_NOME)));
                parceiro.setCnpjCpf(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_CNPJCPF)));
                parceiro.setTelefone(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_TELEFONE)));
                parceiro.setDatavinculo(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_DATAVINCULO)));
                parceiro.setObservacoes(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_OBSERVACOES)));
                parceiros.add(parceiro);
            } while(cursorParceiros.moveToNext());
        view.updateListParceiros(parceiros);
    }

    public void listarParceiros(){
        ParceirosController banco = new ParceirosController(context);
        Cursor cursorParceiros = banco.carregaParceiros();
        List<ParceiroEntity> parceiros = new ArrayList<>();
        if (cursorParceiros.getCount() > 0)
            do
            {
                ParceiroEntity parceiro = new ParceiroEntity();
                parceiro.setId(cursorParceiros.getInt(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_ID)));
                parceiro.setNome(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_NOME)));
                parceiro.setCnpjCpf(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_CNPJCPF)));
                parceiro.setTelefone(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_TELEFONE)));
                parceiro.setDatavinculo(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_DATAVINCULO)));
                parceiro.setObservacoes(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_OBSERVACOES)));
                parceiros.add(parceiro);
            } while(cursorParceiros.moveToNext());
        view.updateListParceiros(parceiros);
    }
}
