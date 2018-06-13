package com.example.bruno.aplicativo3a.Parceiros.Exibir;

import android.content.Context;
import android.database.Cursor;

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

    public void listarDoacoes(String idParceiro){

        DoacoesController banco = new DoacoesController(context);
        Cursor cursorDoacoes = banco.carregaDoacoes(idParceiro);
        List<DoacaoEntity> doacoesParceiro = new ArrayList<>();
        if (cursorDoacoes.getCount() > 0)
        do
        {
            DoacaoEntity doacaoParceiro = new DoacaoEntity();
            doacaoParceiro.setId(cursorDoacoes.getString(cursorDoacoes.getColumnIndex(CriaBD.TABDOACOES_ID)));
            doacaoParceiro.setIdParceiro(cursorDoacoes.getString(cursorDoacoes.getColumnIndex(CriaBD.TABDOACOES_PARCEIROID)));
            doacaoParceiro.setDescricao(cursorDoacoes.getString(cursorDoacoes.getColumnIndex(CriaBD.TABDOACOES_DESCRICAO)));
            doacaoParceiro.setDataDoacao(cursorDoacoes.getString(cursorDoacoes.getColumnIndex(CriaBD.TABDOACOES_DATADOACAO)));
            doacoesParceiro.add(doacaoParceiro);
        } while(cursorDoacoes.moveToNext());

        view.updateListDoacoes(doacoesParceiro);
    }

    public ParceiroEntity carregaParceiro(String idParceiro) {
        ParceirosController bancoParceiros = new ParceirosController(context);
        Cursor cursorParceiros = bancoParceiros.carregaParceiro(idParceiro);
        ParceiroEntity parceiroDoacao = new ParceiroEntity();
        if(cursorParceiros.getCount() > 0 && cursorParceiros.moveToFirst()){
            parceiroDoacao.setId(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_ID)));
            parceiroDoacao.setCnpjCpf(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_CNPJCPF)));
            parceiroDoacao.setNome(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_NOME)));
            parceiroDoacao.setDatavinculo(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_DATAVINCULO)));
            parceiroDoacao.setObservacoes(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_OBSERVACOES)));
            parceiroDoacao.setTelefone(cursorParceiros.getString(cursorParceiros.getColumnIndex(CriaBD.TABPARCEIROS_TELEFONE)));
        }
        return parceiroDoacao;
    }
}
