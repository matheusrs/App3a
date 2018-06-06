package com.example.bruno.aplicativo3a.CadastroEventos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bruno.aplicativo3a.Main.MainActivity;
import com.example.bruno.aplicativo3a.R;
import com.example.bruno.aplicativo3a.banco.EventosController;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CadastroEventos extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cadastro_eventos);
            ButterKnife.bind(this);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
            getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
            Bundle extras = getIntent().getExtras();
            boolean edit_mode = Boolean.valueOf(extras.getString("evento_edit_mode"));

            if (edit_mode == true){
                idEvento.setText(extras.getString("evento_id"));
                tituloEvento.setText(extras.getString("evento_titulo"));
                dataInicioEvento.setText(extras.getString("evento_datainicio"));
                dataFimEvento.setText(extras.getString("evento_datafim"));
                descricaoEvento.setText(extras.getString("evento_descricao"));
                getSupportActionBar().setTitle("Atualizar Evento");
                atualizar.setVisibility(View.VISIBLE);
                salvar.setVisibility(View.GONE);
            }
            else {
                getSupportActionBar().setTitle("Novo Evento");
            }

            salvar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String message;
                    EventosController banco = new EventosController(getBaseContext());
                    if (banco.insereEvento(tituloEvento.getText().toString() , dataInicioEvento.getText().toString(), dataFimEvento.getText().toString(), descricaoEvento.getText().toString()))
                        message = "Evento cadastrado!";
                    else
                        message = "Erro ao gravar evento";
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                    finish();
                }
            });

            atualizar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String message;
                    EventosController banco = new EventosController(getBaseContext());
                    if (banco.atualizaEvento(idEvento.getText().toString(),tituloEvento.getText().toString() , dataInicioEvento.getText().toString(), dataFimEvento.getText().toString(), descricaoEvento.getText().toString()))
                        message = "Evento atualizado!";
                    else
                        message = "Erro ao atualizar evento";
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                    finish();
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
}
