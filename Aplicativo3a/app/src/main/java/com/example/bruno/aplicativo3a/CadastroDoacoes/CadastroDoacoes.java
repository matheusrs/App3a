package com.example.bruno.aplicativo3a.CadastroDoacoes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bruno.aplicativo3a.R;
import com.example.bruno.aplicativo3a.banco.BancoController;
import com.example.bruno.aplicativo3a.banco.DoacoesController;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CadastroDoacoes extends AppCompatActivity {

    @BindView(R.id.edTxtItensDoados)
    EditText itensDoados;
    @BindView(R.id.txtParceiroDoacao)
    TextView nomeParceiro;
    @BindView(R.id.txtParceiroID)
    TextView parceiroID;
    @BindView(R.id.edTxtDataDoacao)
    EditText dataDoacao;
    @BindView(R.id.btnAdicionarDoacao)
    Button addDoacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_doacoes);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Adicionar Doacao");
        addDoacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message;
                DoacoesController banco = new DoacoesController(getBaseContext());
                if (banco.insereDoacao(parceiroID.getText().toString(),itensDoados.getText().toString(), dataDoacao.getText().toString()))
                    message = "Doação adicionada!";
                else
                    message = "Erro ao gravar doação";
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
