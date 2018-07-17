package com.example.bruno.aplicativo3a.Assistidos.Listagem;


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

import com.example.bruno.aplicativo3a.Assistidos.InserirAlterar.CadastroAssistidoActivity;
import com.example.bruno.aplicativo3a.Assistidos.Exibir.ExibirAssistidoActivity;
import com.example.bruno.aplicativo3a.R;
import com.example.bruno.aplicativo3a.Entity.AssistidoEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ListarAssistidosFragment extends Fragment implements ListarAssistidosView {


    @BindView(R.id.searchViewAssistidos)
    SearchView searchView;

    @BindView(R.id.recycler_view_assistidos)
    RecyclerView recyclerView;

    @BindView(R.id.buttonAddAssistidos)
    Button botaoAddAssistidos;

    ListarAssistidosPresenter presenter;
    private static OnRecyclerViewSelected itemListener;

    public ListarAssistidosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmento_assistidos, container, false);
        ButterKnife.bind(this,view);
        presenter=new ListarAssistidosPresenter(this, getActivity().getBaseContext());
        presenter.listarAssistidos();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        botaoAddAssistidos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
            Intent adicionarAssistido = new Intent(getActivity(), CadastroAssistidoActivity.class);
            adicionarAssistido.putExtra("assistido_edit_mode", "false");
            startActivity(adicionarAssistido);
            }
        });

        searchView.setOnQueryTextListener(
                new SearchView.OnQueryTextListener(){

                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        presenter.listarAssistidos(query);
                        return true;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        if (newText.isEmpty()){
                            presenter.listarAssistidos();
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
        presenter.listarAssistidos();
    }



    public void updateListAssistidos(final List<AssistidoEntity> assistidoEntityList){
        ListarAssistidosAdapter adapter = new ListarAssistidosAdapter(assistidoEntityList,getActivity());
        adapter.setOnRecyclerViewSelected(new OnRecyclerViewSelected() {
            @Override
            public void onClick(View v, int position) {
                AssistidoEntity objAssistido = assistidoEntityList.get(position);
                Intent exibirAssistido = new Intent(getActivity(), ExibirAssistidoActivity.class);
                exibirAssistido.putExtra("assistido_id", objAssistido.getId());
                exibirAssistido.putExtra("assistido_cpf", objAssistido.getCpf());
                exibirAssistido.putExtra("assistido_rg", objAssistido.getRg());
                exibirAssistido.putExtra("assistido_nome", objAssistido.getNomeCompleto());
                exibirAssistido.putExtra("assistido_datanascimento", objAssistido.getDataNascimento());
                exibirAssistido.putExtra("assistido_tamanho_calcado", objAssistido.getTamanhoCalcado());
                exibirAssistido.putExtra("assistido_tamanho_roupa", objAssistido.getTamanhoRoupa());
                exibirAssistido.putExtra("assistido_datas_presentes", objAssistido.getDatasPresentes());
                exibirAssistido.putExtra("assistido_meio_transporte", objAssistido.getMeioTransporte());
                exibirAssistido.putExtra("assistido_statusativo", objAssistido.getStatusAtivo());
                startActivity(exibirAssistido);
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);
    }
}