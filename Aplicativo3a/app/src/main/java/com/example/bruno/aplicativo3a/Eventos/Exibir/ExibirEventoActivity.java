package com.example.bruno.aplicativo3a.Eventos.Exibir;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bruno.aplicativo3a.Eventos.InserirAlterar.CadastroEventoActivity;
import com.example.bruno.aplicativo3a.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExibirEventoActivity extends AppCompatActivity {

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
    @BindView(R.id.valueDespesasEvento)
    TextView despesas;
    @BindView(R.id.valueReceitasEvento)
    TextView receitas;


    public ExibirEventoActivity() {
        // Required empty public constructor
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

        idEvento.setText(extras.getString("evento_id"));
        tituloEvento.setText(extras.getString("evento_titulo"));
        dataInicio.setText(extras.getString("evento_datainicio"));
        dataFim.setText(extras.getString("evento_datafim"));
        descricao.setText(extras.getString("evento_descricao"));
        despesas.setText(extras.getString("evento_despesas"));
        receitas.setText(extras.getString("evento_receitas"));

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
                    editarEvento.putExtra("evento_despesas", despesas.getText());
                    editarEvento.putExtra("evento_receitas", receitas.getText());
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
