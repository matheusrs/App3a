package com.example.bruno.aplicativo3a.Assistidos.Exibir;

import android.content.Context;
import android.database.Cursor;

import com.example.bruno.aplicativo3a.Entity.AssistidoEntity;
import com.example.bruno.aplicativo3a.Entity.MedicamentoEntity;
import com.example.bruno.aplicativo3a.Entity.ResponsavelEntity;
import com.example.bruno.aplicativo3a.Entity.ParceiroEntity;
import com.example.bruno.aplicativo3a.banco.AssistidosController;
import com.example.bruno.aplicativo3a.banco.CriaBD;
import com.example.bruno.aplicativo3a.banco.MedicamentoAssistidoController;
import com.example.bruno.aplicativo3a.banco.ResponsavelAssistidoController;
import com.example.bruno.aplicativo3a.banco.ParceirosController;

import java.util.ArrayList;
import java.util.List;

public class ExibirAssistidoPresenter {
    ExibirAssistidoView view;
    Context context;

    public ExibirAssistidoPresenter(ExibirAssistidoView view, Context context) {
        this.view = view;
        this.context = context;
    }

    public void listarResponsaveis(String idAssistido){

        ResponsavelAssistidoController banco = new ResponsavelAssistidoController(context);
        Cursor cursorResponsaveis = banco.carregaResponsaveisAssistido(idAssistido);
        List<ResponsavelEntity> responsaveisAssistido = new ArrayList<>();
        if (cursorResponsaveis.getCount() > 0) {
            do {
                ResponsavelEntity responsavelAssistido = new ResponsavelEntity();
                responsavelAssistido.setId(cursorResponsaveis.getInt(cursorResponsaveis.getColumnIndex(CriaBD.TABRESPONSAVELASSISTIDO_ID)));
                responsavelAssistido.setIdAssistido(cursorResponsaveis.getInt(cursorResponsaveis.getColumnIndex(CriaBD.TABRESPONSAVELASSISTIDO_IDASSISTIDO)));
                responsavelAssistido.setNomeCompleto(cursorResponsaveis.getString(cursorResponsaveis.getColumnIndex(CriaBD.TABRESPONSAVELASSISTIDO_NOME_COMPLETO)));
                responsavelAssistido.setCpf(cursorResponsaveis.getString(cursorResponsaveis.getColumnIndex(CriaBD.TABRESPONSAVELASSISTIDO_CPF)));
                responsavelAssistido.setRg(cursorResponsaveis.getString(cursorResponsaveis.getColumnIndex(CriaBD.TABRESPONSAVELASSISTIDO_RG)));
                responsavelAssistido.setEndereco(cursorResponsaveis.getString(cursorResponsaveis.getColumnIndex(CriaBD.TABRESPONSAVELASSISTIDO_ENDERECO)));
                responsavelAssistido.setBairro(cursorResponsaveis.getString(cursorResponsaveis.getColumnIndex(CriaBD.TABRESPONSAVELASSISTIDO_BAIRRO)));
                responsavelAssistido.setTelefone(cursorResponsaveis.getString(cursorResponsaveis.getColumnIndex(CriaBD.TABRESPONSAVELASSISTIDO_TELEFONE)));
                responsavelAssistido.setGrauParentesco(cursorResponsaveis.getString(cursorResponsaveis.getColumnIndex(CriaBD.TABRESPONSAVELASSISTIDO_GRAU_PARENTESCO)));
                responsavelAssistido.setEmail(cursorResponsaveis.getString(cursorResponsaveis.getColumnIndex(CriaBD.TABRESPONSAVELASSISTIDO_EMAIL)));
                responsavelAssistido.setAutorizadoRetirar(cursorResponsaveis.getString(cursorResponsaveis.getColumnIndex(CriaBD.TABRESPONSAVELASSISTIDO_AUTORIZADO_RETIRAR)));
                responsaveisAssistido.add(responsavelAssistido);
            } while (cursorResponsaveis.moveToNext());
        }
        view.updateListResponsaveis(responsaveisAssistido);
    }

    public void listarMedicamentos(String idAssistido){

        MedicamentoAssistidoController banco = new MedicamentoAssistidoController(context);
        Cursor cursorMedicamentos = banco.carregaMedicamentosAssistido(idAssistido);
        List<MedicamentoEntity> medicamentosAssistido = new ArrayList<>();
        if (cursorMedicamentos.getCount() > 0) {
            do {
                MedicamentoEntity medicamentoAssistido = new MedicamentoEntity();
                medicamentoAssistido.setId(cursorMedicamentos.getInt(cursorMedicamentos.getColumnIndex(CriaBD.TABMEDICAMENTOASSISTIDO_ID)));
                medicamentoAssistido.setIdAssistido(cursorMedicamentos.getInt(cursorMedicamentos.getColumnIndex(CriaBD.TABMEDICAMENTOASSISTIDO_IDASSISTIDO)));
                medicamentoAssistido.setNomeMedicamento(cursorMedicamentos.getString(cursorMedicamentos.getColumnIndex(CriaBD.TABMEDICAMENTOASSISTIDO_NOME_MEDICAMENTO)));
                medicamentoAssistido.setObservacoes(cursorMedicamentos.getString(cursorMedicamentos.getColumnIndex(CriaBD.TABMEDICAMENTOASSISTIDO_OBSERVACOES)));
                medicamentosAssistido.add(medicamentoAssistido);
            } while (cursorMedicamentos.moveToNext());
        }
        view.updateListMedicamentos(medicamentosAssistido);
    }

    public AssistidoEntity carregaAssistido(String idAssistido) {
        AssistidosController bancoAssistidos = new AssistidosController(context);
        Cursor cursorAssistidos = bancoAssistidos.carregaAssistido(idAssistido);
        AssistidoEntity assistido = new AssistidoEntity();
        if(cursorAssistidos.getCount() > 0 && cursorAssistidos.moveToFirst()){
            assistido.setId(cursorAssistidos.getInt(cursorAssistidos.getColumnIndex(CriaBD.TABASSISTIDOS_ID)));
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
}
