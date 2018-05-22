package com.example.bruno.aplicativo3a.Main;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.example.bruno.aplicativo3a.ListagemAssistidos.FragmentoListarAssistidos;
import com.example.bruno.aplicativo3a.ListagemAvisos.FragmentoListarAvisos;
import com.example.bruno.aplicativo3a.ListagemEventos.FragmentoListarEventos;
import com.example.bruno.aplicativo3a.ListagemParceiros.FragmentoListarParceiros;
import com.example.bruno.aplicativo3a.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    @BindView(R.id.tabs)
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        setupViewPager(mViewPager);

        tabLayout.setupWithViewPager(mViewPager);


    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentoListarAvisos(), "Avisos");
        adapter.addFragment(new FragmentoListarEventos(), "Eventos");
        adapter.addFragment(new FragmentoListarAssistidos(), "Assistidos");
        adapter.addFragment(new FragmentoListarParceiros(), "Parceiros");
        viewPager.setAdapter(adapter);
    }

}
