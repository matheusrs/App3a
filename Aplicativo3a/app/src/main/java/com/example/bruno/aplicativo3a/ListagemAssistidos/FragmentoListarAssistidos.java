package com.example.bruno.aplicativo3a.ListagemAssistidos;


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

import com.example.bruno.aplicativo3a.CadastroAssistidos.CadastroAssistidos;
import com.example.bruno.aplicativo3a.CadastroAssistidos.ExibirAssistido;
import com.example.bruno.aplicativo3a.R;
import com.example.bruno.aplicativo3a.banco.BancoController;
import com.example.bruno.aplicativo3a.entitiy.AssistidoEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FragmentoListarAssistidos extends Fragment implements FragmentoListarAssistidosView {


    @BindView(R.id.searchView)
    SearchView searchView;

    @BindView(R.id.recycler_view_assistidos)
    RecyclerView recyclerView;

    @BindView(R.id.buttonAdd)
    Button botaoAdd;

    FragmentoListarAssistidosPresenter presenter;
    private static OnRecyclerViewSelected itemListener;

    public FragmentoListarAssistidos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmento_assistidos, container, false);
        ButterKnife.bind(this,view);
        searchView.setOnQueryTextListener(new SearchFiltro());
        presenter=new FragmentoListarAssistidosPresenter(this);

        BancoController banco = new BancoController(getActivity().getBaseContext());
        Cursor cursorAssistidos = banco.carregaAssistidos();

        presenter.listarAssistidos(cursorAssistidos);

        botaoAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                Intent adicionarAssistido = new Intent(getActivity(), CadastroAssistidos.class);
                startActivity(adicionarAssistido);
                }
            }

        );

        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        BancoController banco = new BancoController(getActivity().getBaseContext());
        Cursor cursorAssistidos = banco.carregaAssistidos();

        presenter.listarAssistidos(cursorAssistidos);
    }



    public void updateListAssistidos(final List<AssistidoEntity> assistidoEntityList){


        FragmentoListarAssistidosAdapter adapter = new FragmentoListarAssistidosAdapter(assistidoEntityList,getActivity());
        adapter.setOnRecyclerViewSelected(new OnRecyclerViewSelected() {
            @Override
            public void onClick(View v, int position) {
                AssistidoEntity objAssistido = assistidoEntityList.get(position);
                Intent exibirAssistido = new Intent(getActivity(), ExibirAssistido.class);
                exibirAssistido.putExtra("assistido_id", objAssistido.getId());
                exibirAssistido.putExtra("assistido_nome", objAssistido.getNome());
                exibirAssistido.putExtra("assistido_sobrenome", objAssistido.getSobrenome());
                exibirAssistido.putExtra("assistido_telefone", objAssistido.getTelefone());
                exibirAssistido.putExtra("assistido_datanascimento", objAssistido.getDataNascimento());
                exibirAssistido.putExtra("assistido_deficiencia", objAssistido.getDeficiencia());
                exibirAssistido.putExtra("assistido_observacoes", objAssistido.getObservacoes());

                startActivity(exibirAssistido);
            }
        });
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(),layoutManager.getOrientation());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }
}