package com.example.bruno.aplicativo3a.CadastroParceiros;

import android.database.Cursor;
import android.util.Log;

import com.example.bruno.aplicativo3a.banco.CriaBD;
import com.example.bruno.aplicativo3a.entitiy.DoacaoEntity;
import com.example.bruno.aplicativo3a.entitiy.ParceiroEntity;

import java.util.ArrayList;
import java.util.List;

public class ExibirParceiroPresenter {
    ExibirParceiroView view;

    public ExibirParceiroPresenter(ExibirParceiroView view) {
        this.view = view;
    }

    public void listarDoacoes(Cursor cursorDoacoes){

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

    public ParceiroEntity carregaParceiro(Cursor cursorParceiros) {
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
