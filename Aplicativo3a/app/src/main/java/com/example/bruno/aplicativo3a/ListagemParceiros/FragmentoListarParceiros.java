package com.example.bruno.aplicativo3a.ListagemParceiros;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;

import com.example.bruno.aplicativo3a.CadastroParceiros.CadastroParceiros;
import com.example.bruno.aplicativo3a.CadastroParceiros.ExibirParceiro;
import com.example.bruno.aplicativo3a.R;
import com.example.bruno.aplicativo3a.banco.ParceirosController;
import com.example.bruno.aplicativo3a.entitiy.ParceiroEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FragmentoListarParceiros extends Fragment  implements FragmentoListarParceirosView {


    @BindView(R.id.searchViewParceiros)
    SearchView searchView;

    @BindView(R.id.recycler_view_parceiros)
    RecyclerView recyclerView;

    @BindView(R.id.buttonAddParceiro)
    Button botaoAddParceiro;

    FragmentoListarParceirosPresenter presenter;

    public FragmentoListarParceiros() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmento_parceiros, container, false);
        ButterKnife.bind(this,view);
        presenter=new FragmentoListarParceirosPresenter(this);

        ParceirosController banco = new ParceirosController(getActivity().getBaseContext());
        Cursor cursorParceiros = banco.carregaParceiros();

        presenter.listarParceiros(cursorParceiros);

        botaoAddParceiro.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent adicionarParceiro = new Intent(getActivity(), CadastroParceiros.class);
              adicionarParceiro.putExtra("parceiro_edit_mode", "false");
              startActivity(adicionarParceiro);
          }
        });

        searchView.setOnQueryTextListener(
            new SearchView.OnQueryTextListener(){

                @Override
                public boolean onQueryTextSubmit(String query) {
                    ParceirosController banco = new ParceirosController(getActivity().getBaseContext());
                    Cursor cursorParceiros = banco.carregaParceiros(query);
                    presenter.listarParceiros(cursorParceiros);
                    return true;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    if (newText.isEmpty())
                    {
                        ParceirosController banco = new ParceirosController(getActivity().getBaseContext());
                        Cursor cursorParceiros = banco.carregaParceiros();
                        presenter.listarParceiros(cursorParceiros);
                    }
                    return true;
                }
            }
        );

        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        ParceirosController banco = new ParceirosController(getActivity().getBaseContext());
        Cursor cursorParceiros = banco.carregaParceiros();

        presenter.listarParceiros(cursorParceiros);
    }


    public void updateListParceiros(final List<ParceiroEntity> parceiroEntityList){
        FragmentoListarParceirosAdapter adapter = new FragmentoListarParceirosAdapter(parceiroEntityList,getActivity());
        adapter.setOnRecyclerViewSelected(new OnRecyclerViewSelected() {
            @Override
            public void onClick(View v, int position) {
                ParceiroEntity objParceiro = parceiroEntityList.get(position);
                Intent exibirParceiro = new Intent(getActivity(), ExibirParceiro.class);
                exibirParceiro.putExtra("parceiro_id", objParceiro.getId());
                exibirParceiro.putExtra("parceiro_nome", objParceiro.getNome());
                exibirParceiro.putExtra("parceiro_cnpjcpf", objParceiro.getCnpjCpf());
                exibirParceiro.putExtra("parceiro_telefone", objParceiro.getTelefone());
                exibirParceiro.putExtra("parceiro_datavinculo", objParceiro.getDatavinculo());
                exibirParceiro.putExtra("parceiro_observacoes", objParceiro.getObservacoes());

                startActivity(exibirParceiro);
            }
        });
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(),layoutManager.getOrientation());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

}
