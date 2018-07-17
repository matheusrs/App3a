package com.example.bruno.aplicativo3a.Assistidos.InserirAlterar;

import android.content.Context;
import android.database.Cursor;

import com.example.bruno.aplicativo3a.Entity.AssistidoEntity;
import com.example.bruno.aplicativo3a.banco.AssistidosController;
import com.example.bruno.aplicativo3a.banco.CriaBD;

public class CadastroAssistidoPresenter {
    CadastroAssistidoView view;
    Context context;

    public CadastroAssistidoPresenter(CadastroAssistidoView view, Context context) {
        this.view = view;
        this.context = context;
    }

    public void salvarAssistido(String cpfAssistido, String rgAssistido, String nomeAssistido, String dataNascimentoAssistido, String tamanhoCalcadoAssistido, String tamanhoRoupaAssistido, String datasPresenteAssistido, String meioTransporteAssistido) {
        String message;
        AssistidosController banco = new AssistidosController(context);
        if (banco.insereAssistido(cpfAssistido, rgAssistido, nomeAssistido, dataNascimentoAssistido, tamanhoCalcadoAssistido, tamanhoRoupaAssistido, datasPresenteAssistido, meioTransporteAssistido))
            message = "Assistido cadastrado!";
        else
            message = "Erro ao gravar assistido";
        view.exibeMensagem(message);
    }

    public void atualizarAssistido(String idAssistido, String cpfAssistido, String rgAssistido, String nomeAssistido, String dataNascimentoAssistido, String tamanhoCalcadoAssistido, String tamanhoRoupaAssistido, String datasPresenteAssistido, String meioTransporteAssistido) {
        String message;
        AssistidosController banco = new AssistidosController(context);
        if (banco.atualizaAssistido(idAssistido, cpfAssistido, rgAssistido, nomeAssistido, dataNascimentoAssistido, tamanhoCalcadoAssistido, tamanhoRoupaAssistido, datasPresenteAssistido, meioTransporteAssistido))
            message = "Assistido atualizado!";
        else
            message = "Erro ao atualizar assistido";
        view.exibeMensagem(message);
    }

    public AssistidoEntity carregaAssistido(String id_assistido) {
        AssistidosController banco = new AssistidosController(context);
        Cursor cursorAssistidos = banco.carregaAssistido(id_assistido);
        AssistidoEntity assistido = new AssistidoEntity();
        if (cursorAssistidos.getCount() > 0) {
            assistido.setId(Integer.valueOf(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_ID))));
            assistido.setCpf(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_CPF)));
            assistido.setRg(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_RG)));
            assistido.setNomeCompleto(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_NOME_COMPLETO)));
            assistido.setDataNascimento(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_DATANASCIMENTO)));
            assistido.setTamanhoCalcado(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_TAMANHO_CALCADO)));
            assistido.setTamanhoRoupa(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_TAMANHO_ROUPA)));
            assistido.setDatasPresentes(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_DATAS_PRESENTES)));
            assistido.setMeioTransporte(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_MEIOTRANSPORTE)));
            assistido.setStatusAtivo(cursorAssistidos.getString(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_STATUSATIVO)));
        }
        return assistido;
    }

    public void alteraStatus(String idAssistido, boolean status){
        String message;
        AssistidosController banco = new AssistidosController(context);
        if (banco.atualizaStatusAssistido(Integer.valueOf(idAssistido), status)) {
            message = (status ? "Cadastro ativado!" : "Cadastro inativado!");
        } else {
            message = "Erro ao alterar o status do assistido!";
        }
        view.alteraTextoSwitchAtivo(status);
        view.exibeMensagem(message);
    }
}
