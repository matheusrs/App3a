package com.example.bruno.aplicativo3a.Assistidos.Exibir;

import com.example.bruno.aplicativo3a.Entity.DoacaoEntity;
import com.example.bruno.aplicativo3a.Entity.MedicamentoEntity;
import com.example.bruno.aplicativo3a.Entity.ResponsavelEntity;

import java.util.List;

public interface ExibirAssistidoView {

    void updateListResponsaveis(final List<ResponsavelEntity> responsavelEntityList);
    void updateListMedicamentos(final List<MedicamentoEntity> medicamentoEntityList);

}
