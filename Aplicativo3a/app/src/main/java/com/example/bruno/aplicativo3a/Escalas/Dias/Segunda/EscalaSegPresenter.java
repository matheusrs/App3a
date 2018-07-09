package com.example.bruno.aplicativo3a.Escalas.Dias.Segunda;

import android.content.Context;

import com.example.bruno.aplicativo3a.Entity.EscalaEntity;
import com.example.bruno.aplicativo3a.banco.EscalasController;

import java.util.List;

public class EscalaSegPresenter {
    EscalaSegView view;
    Context context;

    EscalaSegPresenter(EscalaSegView view, Context context){
        this.view=view;
        this.context=context;
    }

    void carregaEscalas(){
        EscalasController banco = new EscalasController(context);
        List<EscalaEntity> escala = banco.carregaEscalas("segunda", "manha");
        view.exibeEscala(escala,"manha");
        escala= banco.carregaEscalas("segunda", "almoco");
        view.exibeEscala(escala,"almoco");
        escala=banco.carregaEscalas("segunda", "tarde");
        view.exibeEscala(escala,"tarde");
    }

}
