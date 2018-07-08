package com.example.bruno.aplicativo3a.Eventos.Exibir;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bruno.aplicativo3a.Entity.EventoEntity;
import com.example.bruno.aplicativo3a.Eventos.InserirAlterar.CadastroEventoActivity;
import com.example.bruno.aplicativo3a.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExibirEventoActivity extends AppCompatActivity implements ExibirEventoView {

    @BindView(R.id.btnEditEvento)
    Button editarEvento;
    @BindView(R.id.hiddenIdEvento)
    TextView idEvento;
    @BindView(R.id.valueTituloEvento)
    TextView tituloEvento;
    @BindView(R.id.valueDataInicioEvento)
    TextView dataInicio;
    @BindView(R.id.valueDataFimEvento)
    TextView dataFim;
    @BindView(R.id.valueDescricaoEvento)
    TextView descricao;

    int idEventoVal;
    ExibirEventoPresenter presenter;

    public ExibirEventoActivity() {
        // Required empty public constructor
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventoEntity evento = presenter.carregaEvento(idEventoVal);
        idEvento.setText(evento.getId());
        tituloEvento.setText(evento.getTitulo());
        dataInicio.setText(evento.getDataInicio());
        dataFim.setText(evento.getDataFim());
        descricao.setText(evento.getDescricao());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_evento);
        ButterKnife.bind(this);
        Bundle extras = getIntent().getExtras();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Detalhes do Evento");

        presenter = new ExibirEventoPresenter(this,this);
        idEventoVal=Integer.parseInt(extras.getString("evento_id"));

        editarEvento.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent editarEvento = new Intent(getBaseContext(), CadastroEventoActivity.class);
                    editarEvento.putExtra("evento_edit_mode", "true");
                    editarEvento.putExtra("evento_id", idEvento.getText());
                    editarEvento.putExtra("evento_titulo", tituloEvento.getText());
                    editarEvento.putExtra("evento_datainicio", dataInicio.getText());
                    editarEvento.putExtra("evento_datafim", dataFim.getText());
                    editarEvento.putExtra("evento_descricao", descricao.getText());
                    startActivity(editarEvento);
                }
            }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            //configura opção Up Action na ActionBar
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
