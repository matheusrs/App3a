package com.example.bruno.aplicativo3a.ListagemAssistidos;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.bruno.aplicativo3a.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FragmentoAssistidos extends Fragment {


    @BindView(R.id.searchView)
    SearchView searchView;

    public FragmentoAssistidos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmento_assistidos, container, false);
        ButterKnife.bind(this,view);
        searchView.setOnQueryTextListener(new SearchFiltro());
        return view;

    }



}
