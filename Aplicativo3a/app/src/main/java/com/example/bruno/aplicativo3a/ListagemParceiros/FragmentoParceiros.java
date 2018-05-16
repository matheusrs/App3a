package com.example.bruno.aplicativo3a.ListagemParceiros;


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

import com.example.bruno.aplicativo3a.CadastroParceiros.CadastroParceiros;
import com.example.bruno.aplicativo3a.R;
import com.example.bruno.aplicativo3a.banco.BancoController;
import com.example.bruno.aplicativo3a.entitiy.ParceiroEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FragmentoParceiros extends Fragment {


    @BindView(R.id.searchView)
    SearchView searchView;

    @BindView(R.id.recycler_view_parceiros)
    RecyclerView recyclerView;

    @BindView(R.id.buttonAdd)
    Button botaoAdd;

    FragmentoParceirosPresenter presenter;

    public FragmentoParceiros() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmento_parceiros, container, false);
        ButterKnife.bind(this,view);
        searchView.setOnQueryTextListener(new SearchFiltro());
        presenter=new FragmentoParceirosPresenter();
        botaoAdd.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent adicionarParceiro = new Intent(getActivity(), CadastroParceiros.class);
                                            startActivity(adicionarParceiro);
                                        }
                                    }

        );

        return view;

    }

    public void updateListParceiros(final List<ParceiroEntity> parceirosEntityList){
        BancoController banco = new BancoController(getActivity().getBaseContext());
        FragmentoParceirosAdapter adapter = new FragmentoParceirosAdapter(parceirosEntityList,getActivity());
        adapter.setOnRecyclerViewSelected(new OnRecyclerViewSelected() {
            @Override
            public void onClick(View view, int position) {
                //ao clicar em algum Parceiro abre tela de visualizacao dos dados.
            }
        });
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(),layoutManager.getOrientation());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

}
