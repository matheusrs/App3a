package com.example.bruno.aplicativo3a.Escalas.Dias.Terca;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.bruno.aplicativo3a.Entity.EscalaEntity;
import com.example.bruno.aplicativo3a.Escalas.Dias.Quarta.EscalaQuaPresenter;
import com.example.bruno.aplicativo3a.Escalas.InserirAlterar.CadastroEscalaActivity;
import com.example.bruno.aplicativo3a.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EscalaTerFragment extends Fragment implements EscalaTerView {

    @BindView(R.id.cvTerAlmoco)
    CardView cvAlmoco;
    @BindView(R.id.cvTerManha)
    CardView cvManha;
    @BindView(R.id.cvTerTarde)
    CardView cvTarde;
    @BindView(R.id.txtTerAlmoco)
    TextView txtAlmoco;
    @BindView(R.id.txtTerManha)
    TextView txtManha;
    @BindView(R.id.txtTerTarde)
    TextView txtTarde;
    @BindView(R.id.buttonAddEscalaTer)
    Button btnAdd;

    EscalaTerPresenter presenter;
    public EscalaTerFragment() {
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
        View view= inflater.inflate(R.layout.fragment_ter, container, false); ButterKnife.bind(this, view);
        presenter = new EscalaTerPresenter(this, getActivity().getBaseContext());

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
