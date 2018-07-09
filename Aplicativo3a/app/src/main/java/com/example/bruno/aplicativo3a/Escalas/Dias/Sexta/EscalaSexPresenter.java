package com.example.bruno.aplicativo3a.Escalas.Dias.Sexta;

import android.content.Context;

import com.example.bruno.aplicativo3a.Entity.EscalaEntity;
import com.example.bruno.aplicativo3a.banco.EscalasController;

import java.util.List;

public class EscalaSexPresenter {
    EscalaSexView view;
    Context context;

    EscalaSexPresenter(EscalaSexView view, Context context){
        this.view=view;
        this.context=context;
    }

    void carregaEscalas(){
        EscalasController banco = new EscalasController(context);
        List<EscalaEntity> escala = banco.carregaEscalas("sexta", "manha");
        view.exibeEscala(escala,"manha");
        escala= banco.carregaEscalas("sexta", "almoco");
        view.exibeEscala(escala,"almoco");
        escala=banco.carregaEscalas("sexta", "tarde");
        view.exibeEscala(escala,"tarde");
    }
}
