package com.example.bruno.aplicativo3a.ListagemEventos;


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

import com.example.bruno.aplicativo3a.CadastroEventos.CadastroEventos;
import com.example.bruno.aplicativo3a.CadastroEventos.ExibirEvento;
import com.example.bruno.aplicativo3a.R;
import com.example.bruno.aplicativo3a.entitiy.EventoEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FragmentoListarEventos extends Fragment implements FragmentoListarEventosView {


    @BindView(R.id.searchViewEventos)
    SearchView searchView;

    @BindView(R.id.recycler_view_eventos)
    RecyclerView recyclerView;

    @BindView(R.id.buttonAddEventos)
    Button botaoAddEventos;

    FragmentoListarEventosPresenter presenter;
    private static OnRecyclerViewSelected itemListener;

    public FragmentoListarEventos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmento_eventos, container, false);
        ButterKnife.bind(this,view);
        searchView.setOnQueryTextListener(new SearchFiltro());
        presenter=new FragmentoListarEventosPresenter(this);

        //BancoController banco = new BancoController(getActivity().getBaseContext());
        //Cursor cursorEventos = banco.carregaEventos();

        //presenter.listarEventos(cursorEventos);

        botaoAddEventos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
            Intent adicionarEvento = new Intent(getActivity(), CadastroEventos.class);
            adicionarEvento.putExtra("evento_edit_mode", "false");
            startActivity(adicionarEvento);
            }
        }

        );

        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        //BancoController banco = new BancoController(getActivity().getBaseContext());
        //Cursor cursorEventos = banco.carregaEventos();

        //presenter.listarEventos(cursorEventos);
    }



    public void updateListEventos(final List<EventoEntity> eventoEntityList) {


        FragmentoListarEventosAdapter adapter = new FragmentoListarEventosAdapter(eventoEntityList,getActivity());
        adapter.setOnRecyclerViewSelected(new OnRecyclerViewSelected() {
            @Override
            public void onClick(View v, int position) {
                EventoEntity objEvento = eventoEntityList.get(position);
                Intent exibirEvento = new Intent(getActivity(), ExibirEvento.class);
                exibirEvento.putExtra("evento_id", objEvento.getId());

                startActivity(exibirEvento);
            }
        });
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(),layoutManager.getOrientation());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }
}