package com.example.bruno.aplicativo3a.Escalas.Dias.Quinta;

import android.content.Context;

import com.example.bruno.aplicativo3a.Entity.EscalaEntity;
import com.example.bruno.aplicativo3a.banco.EscalasController;

import java.util.List;

public class EscalaQuiPresenter {
    EscalaQuiView view;
    Context context;

    EscalaQuiPresenter(EscalaQuiView view, Context context){
        this.view=view;
        this.context=context;
    }

    void carregaEscalas(){
        EscalasController banco = new EscalasController(context);
        List<EscalaEntity> escala = banco.carregaEscalas("quinta", "manha");
        view.exibeEscala(escala,"manha");
        escala= banco.carregaEscalas("quinta", "almoco");
        view.exibeEscala(escala,"almoco");
        escala=banco.carregaEscalas("quinta", "tarde");
        view.exibeEscala(escala,"tarde");
    }
}
