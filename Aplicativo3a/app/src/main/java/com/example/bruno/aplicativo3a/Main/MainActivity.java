package com.example.bruno.aplicativo3a.Main;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.bruno.aplicativo3a.Assistidos.Listagem.ListarAssistidosFragment;
import com.example.bruno.aplicativo3a.Escalas.EscalaFuncionariosFragment;
import com.example.bruno.aplicativo3a.Eventos.ListagemEventos.ListarEventosFragment;
import com.example.bruno.aplicativo3a.Parceiros.Listagem.ListarParceirosFragment;
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
        adapter.addFragment(new ListarAssistidosFragment(), "Assistidos");
        adapter.addFragment(new ListarParceirosFragment(), "Parceiros");
        adapter.addFragment(new EscalaFuncionariosFragment(), "Escala");
        adapter.addFragment(new ListarEventosFragment(), "Eventos");
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case R.id.action_avisos:
                //Intent editarEvento = new Intent(getBaseContext(), CadastroEventoActivity.class);
                //editarEvento.putExtra("evento_edit_mode", "true");
                //startActivity(editarEvento);
                break;
            case R.id.action_lucro:
                //your action
                break;
            case R.id.action_estatisticas:
                //your action
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

}
