package com.example.bruno.aplicativo3a.ListagemAvisos;

import com.example.bruno.aplicativo3a.entitiy.AvisoEntity;

import java.util.List;

public interface FragmentoListarAvisosView {

    void updateListAvisos(final List<AvisoEntity> avisoEntityList);

}