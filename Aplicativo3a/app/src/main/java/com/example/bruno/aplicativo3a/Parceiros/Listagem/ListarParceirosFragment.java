package com.example.bruno.aplicativo3a.Parceiros.Listagem;


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

import com.example.bruno.aplicativo3a.Parceiros.Exibir.ExibirParceiroActivity;
import com.example.bruno.aplicativo3a.Parceiros.InserirAlterar.CadastroParceiroActivity;
import com.example.bruno.aplicativo3a.R;
import com.example.bruno.aplicativo3a.Entity.ParceiroEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ListarParceirosFragment extends Fragment  implements ListarParceirosView {


    @BindView(R.id.searchViewParceiros)
    SearchView searchView;

    @BindView(R.id.recycler_view_parceiros)
    RecyclerView recyclerView;

    @BindView(R.id.buttonAddParceiro)
    Button botaoAddParceiro;

    ListarParceirosPresenter presenter;

    public ListarParceirosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmento_parceiros, container, false);
        ButterKnife.bind(this,view);
        presenter=new ListarParceirosPresenter(this, getActivity());
        presenter.listarParceiros();


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        botaoAddParceiro.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent adicionarParceiro = new Intent(getActivity(), CadastroParceiroActivity.class);
              adicionarParceiro.putExtra("parceiro_edit_mode", "false");
              startActivity(adicionarParceiro);
          }
        });

        searchView.setOnQueryTextListener(
            new SearchView.OnQueryTextListener(){

                @Override
                public boolean onQueryTextSubmit(String query) {
                    presenter.listarParceiros(query);
                    return true;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    if (newText.isEmpty())
                        presenter.listarParceiros();
                    return true;
                }
            }
        );

        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.listarParceiros();
    }


    public void updateListParceiros(final List<ParceiroEntity> parceiroEntityList){
        ListarParceirosAdapter adapter = new ListarParceirosAdapter(parceiroEntityList,getActivity());
        adapter.setOnRecyclerViewSelected(new OnRecyclerViewSelected() {
            @Override
            public void onClick(View v, int position) {
                ParceiroEntity objParceiro = parceiroEntityList.get(position);
                Intent exibirParceiro = new Intent(getActivity(), ExibirParceiroActivity.class);
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
    }

}
