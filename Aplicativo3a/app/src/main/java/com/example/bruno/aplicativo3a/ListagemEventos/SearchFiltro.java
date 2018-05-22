package com.example.bruno.aplicativo3a.ListagemEventos;

import android.widget.SearchView;

public class SearchFiltro implements SearchView.OnQueryTextListener{

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

}
