package com.example.bruno.aplicativo3a.Eventos.ListagemEventos;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;

import com.example.bruno.aplicativo3a.Eventos.Exibir.ExibirEventoActivity;
import com.example.bruno.aplicativo3a.Eventos.InserirAlterar.CadastroEventoActivity;
import com.example.bruno.aplicativo3a.R;
import com.example.bruno.aplicativo3a.Entity.EventoEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ListarEventosFragment extends Fragment implements ListarEventosView {


    @BindView(R.id.searchViewEventos)
    SearchView searchView;

    @BindView(R.id.recycler_view_eventos)
    RecyclerView recyclerView;

    @BindView(R.id.buttonAddEventos)
    Button botaoAddEventos;

    ListarEventosPresenter presenter;
    private static OnRecyclerViewSelected itemListener;

    public ListarEventosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmento_eventos, container, false);
        ButterKnife.bind(this,view);
        searchView.setOnQueryTextListener(new SearchFiltro());
        presenter=new ListarEventosPresenter(this, getActivity().getBaseContext());
        presenter.listarEventos();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        botaoAddEventos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
            Intent adicionarEvento = new Intent(getActivity(), CadastroEventoActivity.class);
            adicionarEvento.putExtra("evento_edit_mode", "false");
            startActivity(adicionarEvento);
            }
        });

        searchView.setOnQueryTextListener(
                new SearchView.OnQueryTextListener(){

                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        presenter.listarEventos(query);
                        return true;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        if (newText.isEmpty())
                            presenter.listarEventos();
                        return true;
                    }
                }
        );

        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.listarEventos();
    }



    public void updateListEventos(final List<EventoEntity> eventoEntityList) {
        ListarEventosAdapter adapter = new ListarEventosAdapter(eventoEntityList,getActivity());
        adapter.setOnRecyclerViewSelected(new OnRecyclerViewSelected() {
            @Override
            public void onClick(View v, int position) {
                EventoEntity objEvento = eventoEntityList.get(position);
                Intent exibirEvento = new Intent(getActivity(), ExibirEventoActivity.class);
                exibirEvento.putExtra("evento_id", objEvento.getId());
                exibirEvento.putExtra("evento_titulo", objEvento.getTitulo());
                exibirEvento.putExtra("evento_datainicio", objEvento.getDataInicio());
                exibirEvento.putExtra("evento_datafim", objEvento.getDataFim());
                exibirEvento.putExtra("evento_descricao", objEvento.getDescricao());
                startActivity(exibirEvento);
            }
        });
        recyclerView.setAdapter(adapter);
    }
}