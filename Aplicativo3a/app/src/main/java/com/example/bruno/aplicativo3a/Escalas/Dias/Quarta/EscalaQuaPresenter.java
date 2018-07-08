package com.example.bruno.aplicativo3a.Escalas.Dias.Quarta;

import android.content.Context;

import com.example.bruno.aplicativo3a.Entity.EscalaEntity;
import com.example.bruno.aplicativo3a.banco.EscalasController;

import java.util.List;

public class EscalaQuaPresenter {
    EscalaQuaView view;
    Context context;

    EscalaQuaPresenter(EscalaQuaView view, Context context){
        this.view=view;
        this.context=context;
    }

    void carregaEscalas(){
        EscalasController banco = new EscalasController(context);
        List<EscalaEntity> escala = banco.carregaEscalas("quarta", "manha");
        view.exibeEscala(escala,"manha");
        escala= banco.carregaEscalas("quarta", "almoco");
        view.exibeEscala(escala,"almoco");
        escala=banco.carregaEscalas("quarta", "tarde");
        view.exibeEscala(escala,"tarde");
    }
}
