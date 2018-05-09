package com.example.bruno.aplicativo3a.CadastroAssistidos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bruno.aplicativo3a.R;
import com.example.bruno.aplicativo3a.banco.BancoController;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CadastroAssistidos extends AppCompatActivity {


    @BindView(R.id.btnSalvar)
    Button salvar;
    @BindView(R.id.edTxtNome)
    EditText nome;
    @BindView(R.id.edTxtDeficiencia)
    EditText deficiencia;
    @BindView(R.id.edTxtObservacoes)
    EditText observacoes;
    @BindView(R.id.edTxtSobrenome)
    EditText sobrenome;
    @BindView(R.id.edTxtTelefone)
    EditText telefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_assistidos);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Novo Assistido");
        salvar.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            BancoController banco = new BancoController(getBaseContext());
                                            if(banco.insereAssistido(nome.getText().toString(),sobrenome.getText().toString(),telefone.getText().toString(),deficiencia.getText().toString(),observacoes.getText().toString()))
                                                Log.i("Script","Inserido");
                                            else  Log.i("Script","Erro");
                                            finish();
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
