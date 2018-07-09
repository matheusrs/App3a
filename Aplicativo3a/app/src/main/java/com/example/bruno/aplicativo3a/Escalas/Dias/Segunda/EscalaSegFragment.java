package com.example.bruno.aplicativo3a.Escalas.Dias.Segunda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.bruno.aplicativo3a.Entity.EscalaEntity;
import com.example.bruno.aplicativo3a.Escalas.InserirAlterar.CadastroEscalaActivity;
import com.example.bruno.aplicativo3a.R;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class EscalaSegFragment extends Fragment implements EscalaSegView {

    @BindView(R.id.cvSegAlmoco)
    CardView cvAlmoco;
    @BindView(R.id.cvSegManha)
    CardView cvManha;
    @BindView(R.id.cvSegTarde)
    CardView cvTarde;
    @BindView(R.id.txtSegAlmoco)
    TextView txtAlmoco;
    @BindView(R.id.txtSegManha)
    TextView txtManha;
    @BindView(R.id.txtSegTarde)
    TextView txtTarde;
    @BindView(R.id.buttonAddEscalaSeg)
    Button btnAdd;

    EscalaSegPresenter presenter;


    public EscalaSegFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
        txtManha.setText("");
        txtAlmoco.setText("");
        txtTarde.setText("");
        presenter.carregaEscalas();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_seg, container, false);
        ButterKnife.bind(this, view);
        presenter = new EscalaSegPresenter(this, getActivity().getBaseContext());

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent adicionarEscala = new Intent(getActivity(), CadastroEscalaActivity.class);
                startActivity(adicionarEscala);
            }
        });
        return view;
    }

    public void exibeEscala(List<EscalaEntity> escalas, String turno) {
        if (!escalas.isEmpty()) {
            if (turno.equals("manha")) {
                cvManha.setVisibility(View.VISIBLE);
                for (EscalaEntity e : escalas)
                    txtManha.append(e.getNomeFuncionario() + "(" + e.getEspecialidade() + ")\n");
            } else if (turno.equals("almoco")) {
                cvAlmoco.setVisibility(View.VISIBLE);
                for (EscalaEntity e : escalas)
                    txtAlmoco.append(e.getNomeFuncionario() + "(" + e.getEspecialidade() + ")\n");
            } else if (turno.equals("tarde")) {
                cvTarde.setVisibility(View.VISIBLE);
                for (EscalaEntity e : escalas)
                    txtTarde.append(e.getNomeFuncionario() + "(" + e.getEspecialidade() + ")\n");
            }
        } else {
            if (turno.equals("manha"))
                cvManha.setVisibility(View.GONE);
            else if (turno.equals("almoco"))
                cvAlmoco.setVisibility(View.GONE);
            else if (turno.equals("tarde"))
                cvTarde.setVisibility(View.GONE);
        }
    }
}
