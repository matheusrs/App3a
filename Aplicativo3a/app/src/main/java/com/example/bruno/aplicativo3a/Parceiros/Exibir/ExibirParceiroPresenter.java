package com.example.bruno.aplicativo3a.Parceiros.Exibir;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.bruno.aplicativo3a.banco.CriaBD;
import com.example.bruno.aplicativo3a.banco.DoacoesController;
import com.example.bruno.aplicativo3a.banco.ParceirosController;
import com.example.bruno.aplicativo3a.Entity.DoacaoEntity;
import com.example.bruno.aplicativo3a.Entity.ParceiroEntity;

import java.util.ArrayList;
import java.util.List;

public class ExibirParceiroPresenter {
    ExibirParceiroView view;
    Context context;

    public ExibirParceiroPresenter(ExibirParceiroView view, Context context) {
        this.view = view;
        this.context = context;
    }

    public void listarDoacoes(int idParceiro){

        DoacoesController banco = new DoacoesController(context);
        Cursor cursorDoacoes = banco.carregaDoacoes(idParceiro);
        List<DoacaoEntity> doacoesParceiro = new ArrayList<>();
        if (cursorDoacoes.getCount() > 0) {
            do {
                DoacaoEntity doacaoParceiro = new DoacaoEntity();
                doacaoParceiro.setId(cursorDoacoes.getString(cursorDoacoes.getColumnIndex(CriaBD.TABDOACOES_ID)));
                doacaoParceiro.setIdParceiro(cursorDoacoes.getString(cursorDoacoes.getColumnIndex(CriaBD.TABDOACOES_PARCEIROID)));
                doacaoParceiro.setDescricao(cursorDoacoes.getString(cursorDoacoes.getColumnIndex(CriaBD.TABDOACOES_DESCRICAO)));
                doacaoParceiro.setDataDoacao(cursorDoacoes.getString(cursorDoacoes.getColumnIndex(CriaBD.TABDOACOES_DATADOACAO)));
                doacoesParceiro.add(doacaoParceiro);
            } while (cursorDoacoes.moveToNext());
        }
        view.updateListDoacoes(doacoesParceiro);
    }

    public ParceiroEntity carregaParceiro(int idParceiro) {
        ParceirosController bancoParceiros = new ParceirosController(context);
        Cursor cursorParceiros = bancoParceiros.carregaParceiro(idParceiro);
        ParceiroEntity parceiro = new ParceiroEntity();
        if(cursorParceiros.getCount() > 0 && cursorParceiros.moveToFirst()) {
            parceiro.setId(cursorParceiros.getInt(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_ID)));
            parceiro.setNome(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_NOME)));
            parceiro.setCnpjCpf(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_CNPJCPF)));
            parceiro.setTelefone(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_TELEFONE)));
            parceiro.setDatavinculo(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_DATAVINCULO)));
            parceiro.setObservacoes(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_OBSERVACOES)));
        }
        return parceiro;
    }
}
