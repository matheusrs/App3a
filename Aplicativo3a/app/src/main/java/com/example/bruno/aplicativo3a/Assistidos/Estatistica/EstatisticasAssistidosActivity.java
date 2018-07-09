package com.example.bruno.aplicativo3a.Assistidos.Estatistica;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.bruno.aplicativo3a.Assistidos.Estatistica.EstatisticasAssistidosPresenter;
import com.example.bruno.aplicativo3a.Assistidos.Exibir.ExibirAssistidoActivity;
import com.example.bruno.aplicativo3a.Assistidos.Listagem.ListarAssistidosAdapter;
import com.example.bruno.aplicativo3a.Assistidos.Listagem.OnRecyclerViewSelected;
import com.example.bruno.aplicativo3a.Entity.AssistidoEntity;
import com.example.bruno.aplicativo3a.R;
import com.example.bruno.aplicativo3a.banco.AssistidosController;

import java.util.List;

import butterknife.BindView;

import static android.app.PendingIntent.getActivity;

public class EstatisticasAssistidosActivity extends AppCompatActivity implements EstatisticasAssistidosView {

    @BindView(R.id.recycler_view_assistidos)
    RecyclerView recyclerView;

    EstatisticasAssistidosPresenter presenter;

    public EstatisticasAssistidosActivity() {
        // Required empty public constructor
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estatistica_assistidos);

        presenter=new EstatisticasAssistidosPresenter(this, getBaseContext());
        presenter.relatorioEstatisticasIdades();



    }


    public void updateEstatisticaAssistidos(List<AssistidoEntity> assistidoEntityList){

    }

    public void gerarGrafico(List<Integer> idadeAssistidos){
        //TODO criar gráfico
    }
}


