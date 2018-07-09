package com.example.bruno.aplicativo3a.Escalas.Dias.Terca;

import android.content.Context;

import com.example.bruno.aplicativo3a.Entity.EscalaEntity;
import com.example.bruno.aplicativo3a.banco.EscalasController;

import java.util.List;

public class EscalaTerPresenter {
    EscalaTerView view;
    Context context;

    EscalaTerPresenter(EscalaTerView view, Context context){
        this.view=view;
        this.context=context;
    }

    void carregaEscalas(){
        EscalasController banco = new EscalasController(context);
        List<EscalaEntity> escala = banco.carregaEscalas("terca", "manha");
        view.exibeEscala(escala,"manha");
        escala= banco.carregaEscalas("terca", "almoco");
        view.exibeEscala(escala,"almoco");
        escala=banco.carregaEscalas("terca", "tarde");
        view.exibeEscala(escala,"tarde");
    }
}
