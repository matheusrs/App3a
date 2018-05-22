package com.example.bruno.aplicativo3a.ListagemParceiros;

import android.database.Cursor;

import com.example.bruno.aplicativo3a.banco.CriaBD;
import com.example.bruno.aplicativo3a.entitiy.ParceiroEntity;

import java.util.ArrayList;
import java.util.List;

public class FragmentoListarParceirosPresenter {
    FragmentoListarParceirosView view;

    public FragmentoListarParceirosPresenter(FragmentoListarParceirosView view) {
        this.view = view;
    }

    public void listarParceiros(Cursor cursorParceiros){

        List<ParceiroEntity> parceiros = new ArrayList<>();
        while(cursorParceiros.moveToNext())
        {
            ParceiroEntity parceiro = new ParceiroEntity();
            parceiro.setId(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_ID)));
            parceiro.setCnpjCpf(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_CNPJCPF)));
            parceiro.setNome(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_NOME)));
            parceiro.setTelefone(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_TELEFONE)));
            parceiro.setDatavinculo(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_DATAVINCULO)));
            parceiro.setObservacoes(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_OBSERVACOES)));
            parceiros.add(parceiro);
        }

        view.updateListParceiros(parceiros);
    }
}
