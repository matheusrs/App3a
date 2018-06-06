package com.example.bruno.aplicativo3a.ListagemParceiros;

import android.widget.SearchView;

import com.example.bruno.aplicativo3a.entitiy.ParceiroEntity;

import java.util.List;

public class SearchFiltro implements SearchView.OnQueryTextListener{

    @Override
    public boolean onQueryTextSubmit(String query) { return false; }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

}
