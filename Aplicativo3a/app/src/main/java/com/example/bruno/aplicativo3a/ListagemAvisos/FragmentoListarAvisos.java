package com.example.bruno.aplicativo3a.ListagemAvisos;


import android.content.Intent;
import android.database.Cursor;
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

import com.example.bruno.aplicativo3a.CadastroAvisos.CadastroAvisos;
import com.example.bruno.aplicativo3a.CadastroAvisos.ExibirAviso;
import com.example.bruno.aplicativo3a.R;
import com.example.bruno.aplicativo3a.entitiy.AvisoEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FragmentoListarAvisos extends Fragment implements FragmentoListarAvisosView {


    @BindView(R.id.searchViewAvisos)
    SearchView searchView;

    @BindView(R.id.recycler_view_avisos)
    RecyclerView recyclerView;

    @BindView(R.id.buttonAddAvisos)
    Button botaoAddAvisos;

    FragmentoListarAvisosPresenter presenter;
    private static OnRecyclerViewSelected itemListener;

    public FragmentoListarAvisos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmento_avisos, container, false);
        ButterKnife.bind(this,view);
        searchView.setOnQueryTextListener(new SearchFiltro());
        presenter=new FragmentoListarAvisosPresenter(this);

        //BancoController banco = new BancoController(getActivity().getBaseContext());
        //Cursor cursorAvisos = banco.carregaAvisos();

        //presenter.listarAvisos(cursorAvisos);

        botaoAddAvisos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
            Intent adicionarAviso = new Intent(getActivity(), CadastroAvisos.class);
            adicionarAviso.putExtra("aviso_edit_mode", "false");
            startActivity(adicionarAviso);
            }
        }

        );

        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        //BancoController banco = new BancoController(getActivity().getBaseContext());
        //Cursor cursorAvisos = banco.carregaAvisos();

        //presenter.listarAvisos(cursorAvisos);
    }



    public void updateListAvisos(final List<AvisoEntity> avisoEntityList) {


        FragmentoListarAvisosAdapter adapter = new FragmentoListarAvisosAdapter(avisoEntityList,getActivity());
        adapter.setOnRecyclerViewSelected(new OnRecyclerViewSelected() {
            @Override
            public void onClick(View v, int position) {
                AvisoEntity objAviso = avisoEntityList.get(position);
                Intent exibirAviso = new Intent(getActivity(), ExibirAviso.class);
                exibirAviso.putExtra("aviso_id", objAviso.getId());

                startActivity(exibirAviso);
            }
        });
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(),layoutManager.getOrientation());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }
}