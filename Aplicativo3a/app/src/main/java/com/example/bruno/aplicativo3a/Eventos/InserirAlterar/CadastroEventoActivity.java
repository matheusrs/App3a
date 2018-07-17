package com.example.bruno.aplicativo3a.Eventos.InserirAlterar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bruno.aplicativo3a.Entity.EventoEntity;
import com.example.bruno.aplicativo3a.Mask;
import com.example.bruno.aplicativo3a.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CadastroEventoActivity extends AppCompatActivity implements CadastroEventoView {

    @BindView(R.id.btnSalvarEvento)
    Button salvar;
    @BindView(R.id.btnAtualizarEvento)
    Button atualizar;
    @BindView(R.id.hiddenIdEvento)
    TextView idEvento;
    @BindView(R.id.edTxtTituloEvento)
    EditText tituloEvento;
    @BindView(R.id.edTxtDataInicioEvento)
    EditText dataInicioEvento;
    @BindView(R.id.edTxtDataFimEvento)
    EditText dataFimEvento;
    @BindView(R.id.edTxtDescricaoEvento)
    EditText descricaoEvento;
    @BindView(R.id.edTxtReceitasEvento)
    EditText receitasEvento;
    @BindView(R.id.edTxtGastosEvento)
    EditText gastosEvento;

    CadastroEventoPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cadastro_eventos);
            ButterKnife.bind(this);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
            getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
            Bundle extras = getIntent().getExtras();
            boolean edit_mode = Boolean.valueOf(extras.getString("evento_edit_mode"));
            presenter=new CadastroEventoPresenter(this,this);

            dataInicioEvento.addTextChangedListener(Mask.insert(Mask.DATE_TIME,dataInicioEvento));
            dataFimEvento.addTextChangedListener(Mask.insert(Mask.DATE_TIME,dataFimEvento));
            if (edit_mode == true){
                EventoEntity eventoEntity=presenter.carregaEvento(Integer.parseInt(extras.getString("evento_id")));
                idEvento.setText(eventoEntity.getId());
                tituloEvento.setText(eventoEntity.getTitulo());
                dataInicioEvento.setText(eventoEntity.getDataInicio());
                dataFimEvento.setText(eventoEntity.getDataFim());
                descricaoEvento.setText(eventoEntity.getDescricao());
                receitasEvento.setText(eventoEntity.getReceitas());
                gastosEvento.setText(eventoEntity.getGastos());
                getSupportActionBar().setTitle("Atualizar Evento");
                salvar.setVisibility(View.GONE);
            }
            else {
                atualizar.setVisibility(View.GONE);
                getSupportActionBar().setTitle("Novo Evento");
            }

            salvar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CadastroEventoPresenter presenter = new CadastroEventoPresenter(CadastroEventoActivity.this, getBaseContext());
                    presenter.salvarEvento(tituloEvento.getText().toString() , dataInicioEvento.getText().toString(), dataFimEvento.getText().toString(), descricaoEvento.getText().toString(), gastosEvento.getText().toString(), receitasEvento.getText().toString());
                }
            });

            atualizar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CadastroEventoPresenter presenter = new CadastroEventoPresenter(CadastroEventoActivity.this, getBaseContext());
                    presenter.atualizarEvento(idEvento.getText().toString(), tituloEvento.getText().toString() , dataInicioEvento.getText().toString(), dataFimEvento.getText().toString(), descricaoEvento.getText().toString(), gastosEvento.getText().toString(), receitasEvento.getText().toString());
                }
            });
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

    @Override
    public void exibeMensagem(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        finish();
    }
}
