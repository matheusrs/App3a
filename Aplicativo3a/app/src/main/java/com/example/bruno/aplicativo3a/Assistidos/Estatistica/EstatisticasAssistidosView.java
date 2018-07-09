package com.example.bruno.aplicativo3a.Assistidos.Estatistica;

import com.example.bruno.aplicativo3a.Entity.AssistidoEntity;

import java.util.List;



interface EstatisticasAssistidosView {
    void updateEstatisticaAssistidos( List<AssistidoEntity> assistidoEntityList);
    void gerarGrafico(List<Integer> idadeAssistidos);
}
