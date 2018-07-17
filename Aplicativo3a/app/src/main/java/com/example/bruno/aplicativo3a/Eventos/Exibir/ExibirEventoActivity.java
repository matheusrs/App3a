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
    @BindView(R.id.valueGastosEvento)
    TextView gastos;
    @BindView(R.id.valueReceitasEvento)
    TextView receitas;

    ExibirEventoPresenter presenter;

    public ExibirEventoActivity() {
        // Required empty public constructor
    }

    /*@Override
    //protected void onResume() {
        super.onResume();

        EventoEntity evento = presenter.carregaEvento(Integer.valueOf(idEvento.getText().toString()));
        idEvento.setText(evento.getId());
        tituloEvento.setText(evento.getTitulo());
        dataInicio.setText(evento.getDataInicio());
        dataFim.setText(evento.getDataFim());
        descricao.setText(evento.getDescricao());
	    gastos.setText(evento.getGastos());
        receitas.setText(evento.getReceitas());
    }
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_evento);
        ButterKnife.bind(this);
        Bundle extras = getIntent().getExtras();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Detalhes do Evento");

        idEvento.setText(extras.getString("evento_id"));
        tituloEvento.setText(extras.getString("evento_titulo"));
        dataInicio.setText(extras.getString("evento_datainicio"));
        dataFim.setText(extras.getString("evento_datafim"));
        descricao.setText(extras.getString("evento_descricao"));
        gastos.setText(extras.getString("evento_gastos"));
        receitas.setText(extras.getString("evento_receitas"));
        presenter = new ExibirEventoPresenter(this, getBaseContext());

        editarEvento.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent editarEvento = new Intent(getBaseContext(), CadastroEventoActivity.class);
                    editarEvento.putExtra("evento_edit_mode", "true");
                    editarEvento.putExtra("evento_id", idEvento.getText().toString());
                    editarEvento.putExtra("evento_titulo", tituloEvento.getText().toString());
                    editarEvento.putExtra("evento_datainicio", dataInicio.getText().toString());
                    editarEvento.putExtra("evento_datafim", dataFim.getText().toString());
                    editarEvento.putExtra("evento_descricao", descricao.getText().toString());
                    editarEvento.putExtra("evento_gastos", gastos.getText().toString());
                    editarEvento.putExtra("evento_receitas", receitas.getText().toString());
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
